package com.jojo.dao;

import com.jojo.entry.Payment;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

/**
 * @auther Easy
 * @date 2023/2/21 22:11
 * @revision 0.1 version
 */
@Mapper
public interface PaymentDao {
  int create(Payment payment);
  Payment getPaymentById(@Param("id")Long id);
}
