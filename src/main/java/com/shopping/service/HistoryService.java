package com.shopping.service;

import com.shopping.Entities.History;

public interface HistoryService{

	History history(int productNo,int customerId,int orderNo,History history);
}
