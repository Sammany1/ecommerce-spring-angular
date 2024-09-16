import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { AddressListComponent } from './components/address-list/address-list.component';
import { AddressFormComponent } from './components/address-form/address-form.component';



@NgModule({
  declarations: [
    AddressListComponent,
    AddressFormComponent
  ],
  imports: [
    CommonModule
  ]
})
export class AddressModule { }
