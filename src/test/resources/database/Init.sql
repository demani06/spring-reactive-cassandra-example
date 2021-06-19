CREATE KEYSPACE sample
  WITH REPLICATION = {
   'class' : 'SimpleStrategy',
   'replication_factor' : 1
  };


  CREATE TABLE sample.products ( productId UUID PRIMARY KEY, productName text);

  INSERT INTO sample.products (productId, productName) VALUES (5b6962dd-3f90-4c93-8f61-eabfa4a803e2, 'Digital Watch');
