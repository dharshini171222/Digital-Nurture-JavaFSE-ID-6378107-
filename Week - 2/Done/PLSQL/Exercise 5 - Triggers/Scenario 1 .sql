--- table before updation

SELECT Name, LastModified FROM Customers WHERE CustomerID = 1;


-- qurrey to create a Trigger 

CREATE OR REPLACE TRIGGER UpdateCustomerLastModified
BEFORE UPDATE ON Customers
FOR EACH ROW
BEGIN
    :NEW.LastModified := SYSDATE;
END;
/


-- checking after the qurrey

UPDATE Customers
SET Name = 'Updated John'
WHERE CustomerID = 1;


--- table after updation

SELECT Name, LastModified FROM Customers WHERE CustomerID = 1;