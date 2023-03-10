package com.jojo.service;

import com.jojo.entry.CommonResult;
import com.jojo.entry.Payment;

/**
 * @auther Easy
 * @date 2023/2/21 22:30
 * @revision 0.1 version
 */
public interface PaymentService {
  int create(Payment payment);
  CommonResult getPaymentById(Long id);
}
