package com.byaj.mydynamodbspring.controllers;

import com.amazonaws.services.dynamodbv2.AmazonDynamoDB;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBMapper;
import com.amazonaws.services.dynamodbv2.model.CreateTableRequest;
import com.amazonaws.services.dynamodbv2.model.ProvisionedThroughput;
import com.byaj.mydynamodbspring.dynamorepository.ProductInfoRepository;

import com.byaj.mydynamodbspring.models.ProductInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HomeController {

  private DynamoDBMapper dynamoDBMapper;

  @Autowired
  private AmazonDynamoDB amazonDynamoDB;

  @Autowired
  ProductInfoRepository repository;

  @RequestMapping("/createtable")
  public String standing()
  {
    dynamoDBMapper = new DynamoDBMapper(amazonDynamoDB);

    CreateTableRequest tableRequest = dynamoDBMapper.generateCreateTableRequest(ProductInfo.class);
    tableRequest.setProvisionedThroughput(new ProvisionedThroughput(1L, 1L));
    amazonDynamoDB.createTable(tableRequest);

    return "page";
  }

  @RequestMapping("/add")
  public String addrecord()
  {
    ProductInfo productInfo = new ProductInfo()

    return "page";
  }
}
