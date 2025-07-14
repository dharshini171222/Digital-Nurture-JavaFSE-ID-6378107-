-- making changes so that table can have Vip coloum 

ALTER TABLE Customers ADD IsVIP VARCHAR2(5);


-- Checking before qurrey excution

SELECT * from Customers;


-- Qurrey 

SET SERVEROUTPUT ON;

BEGIN
    FOR rec IN (
        SELECT CustomerID, Balance 
        FROM Customers 
        WHERE Balance > 10000
    ) LOOP
        UPDATE Customers
        SET IsVIP = 'TRUE'
        WHERE CustomerID = rec.CustomerID;

        DBMS_OUTPUT.PUT_LINE(
            'Customer ID ' || rec.CustomerID || 
            ' promoted to VIP (Balance: $' || rec.Balance || ')'
        );
    END LOOP;

    COMMIT;
END;
/


-- Checking after qurrey excution

SELECT * from Customers;