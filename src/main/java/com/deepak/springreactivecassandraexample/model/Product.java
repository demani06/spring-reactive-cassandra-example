package com.deepak.springreactivecassandraexample.model;

import lombok.Data;
import org.springframework.data.cassandra.core.mapping.PrimaryKey;
import org.springframework.data.cassandra.core.mapping.Table;

@Table("products")
@Data
public class Product {

    @PrimaryKey
    private String productId;
    private String productName;

}
