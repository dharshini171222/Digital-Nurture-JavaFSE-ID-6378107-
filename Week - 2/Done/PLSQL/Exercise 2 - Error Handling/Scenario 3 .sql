-- checking before the qurrey

SELECT * FROM CUSTOMERS;


-- qurrey to create a procedure

CREATE OR REPLACE PROCEDURE AddNewCustomer (
    p_customer_id   IN NUMBER,
    p_name          IN VARCHAR2,
    p_dob           IN DATE,
    p_balance       IN NUMBER
) AS
BEGIN
    INSERT INTO Customers (
        CustomerID, Name, DOB, Balance, LastModified, IsVIP
    ) VALUES (
        p_customer_id, p_name, p_dob, p_balance, SYSDATE, NULL
    );

    COMMIT;

    DBMS_OUTPUT.PUT_LINE('Customer "' || p_name || '" added successfully.');

EXCEPTION
    WHEN DUP_VAL_ON_INDEX THEN
        DBMS_OUTPUT.PUT_LINE('Error: Customer ID ' || p_customer_id || ' already exists. Cannot insert duplicate.');
    WHEN OTHERS THEN
        DBMS_OUTPUT.PUT_LINE('Unexpected error: ' || SQLERRM);
END;
/


-- running procedure

EXEC AddNewCustomer(11, 'Priya Mehta', TO_DATE('1992-04-11', 'YYYY-MM-DD'), 5000);
EXEC AddNewCustomer(1, 'Duplicate Test', TO_DATE('1980-01-01', 'YYYY-MM-DD'), 1000);


-- checking after the qurrey

SELECT * FROM CUSTOMERS ;
