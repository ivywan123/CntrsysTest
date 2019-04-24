package com.niu.cntrsys;

import com.jayway.jsonpath.DocumentContext;

public class Products {
    //新增合约
    public DocumentContext productsData;
    public void load(){
        productsData=CntrsysTest.readJson("/product.json");
    }


}
