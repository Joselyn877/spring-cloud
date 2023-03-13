package com.jojo.service.impl;

import com.jojo.dao.PaymentDao;
import com.jojo.entry.CommonResult;
import com.jojo.entry.Payment;
import com.jojo.service.PaymentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @auther Easy
 * @date 2023/2/21 22:33
 * @revision 0.1 version
 */
@Service
public class PaymentServiceImpl implements PaymentService {
  @Autowired
  private PaymentDao paymentDao;

  @Override
  public int create(Payment payment) {
    int count = paymentDao.create(payment);
    return count;
  }

  @Override
  public CommonResult getPaymentById(Long id) {
    CommonResult result = new CommonResult<>();
    Payment payment = paymentDao.getPaymentById(id);
    result.setData(payment);
    result.setCode(500);
    return result;
  }
}
