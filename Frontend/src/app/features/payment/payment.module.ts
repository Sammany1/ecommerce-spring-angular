import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { PaymentComponent } from './components/payment/payment.component';
import { PaymentHistoryComponent } from './components/payment-history/payment-history.component';



@NgModule({
  declarations: [
    PaymentComponent,
    PaymentHistoryComponent
  ],
  imports: [
    CommonModule
  ]
})
export class PaymentModule { }
