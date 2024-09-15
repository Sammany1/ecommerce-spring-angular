package com.example.ecommerceapi.service;

import com.example.ecommerceapi.exception.ResourceNotFoundException;
import com.example.ecommerceapi.model.Wishlist;
import com.example.ecommerceapi.repository.WishlistRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class WishlistService {

    @Autowired
    private WishlistRepository wishlistRepository;

    public List<Wishlist> getAllWishlists() {
        return wishlistRepository.findAll();
    }

    public Wishlist getWishlistById(Long id) {
        return wishlistRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Wishlist not found with id: " + id));
    }

    public Wishlist createWishlist(Wishlist wishlist) {
        return wishlistRepository.save(wishlist);
    }

    public Wishlist updateWishlist(Long id, Wishlist wishlistDetails) {
        Wishlist wishlist = wishlistRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Wishlist not found with id: " + id));
        wishlist.setUser(wishlistDetails.getUser());
        wishlist.setProduct(wishlistDetails.getProduct());
        wishlist.setCreatedAt(wishlistDetails.getCreatedAt());
        wishlist.setDeletedAt(wishlistDetails.getDeletedAt());
        return wishlistRepository.save(wishlist);
    }

    public void deleteWishlist(Long id) {
        Wishlist wishlist = wishlistRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Wishlist not found with id: " + id));
        wishlistRepository.delete(wishlist);
    }
}