-- package creation 

CREATE OR REPLACE PACKAGE BODY CustomerManagement AS

    PROCEDURE AddCustomer(
        p_customer_id   IN NUMBER,
        p_name          IN VARCHAR2,
        p_dob           IN DATE,
        p_balance       IN NUMBER
    ) IS
    BEGIN
        INSERT INTO Customers(CustomerID, Name, DOB, Balance, LastModified)
        VALUES (p_customer_id, p_name, p_dob, p_balance, SYSDATE);

        DBMS_OUTPUT.PUT_LINE('Customer added: ' || p_name);
    EXCEPTION
        WHEN DUP_VAL_ON_INDEX THEN
            DBMS_OUTPUT.PUT_LINE('Customer ID already exists.');
        WHEN OTHERS THEN
            DBMS_OUTPUT.PUT_LINE('Error: ' || SQLERRM);
    END;

    PROCEDURE UpdateCustomerDetails(
        p_customer_id   IN NUMBER,
        p_name          IN VARCHAR2,
        p_dob           IN DATE
    ) IS
    BEGIN
        UPDATE Customers
        SET Name = p_name,
            DOB = p_dob,
            LastModified = SYSDATE
        WHERE CustomerID = p_customer_id;

        IF SQL%ROWCOUNT = 0 THEN
            DBMS_OUTPUT.PUT_LINE('No such customer found.');
        ELSE
            DBMS_OUTPUT.PUT_LINE('Customer details updated.');
        END IF;
    END;

    FUNCTION GetCustomerBalance(
        p_customer_id IN NUMBER
    ) RETURN NUMBER IS
        v_total_balance NUMBER := 0;
    BEGIN
        SELECT NVL(SUM(Balance), 0)
        INTO v_total_balance
        FROM Accounts
        WHERE CustomerID = p_customer_id;

        RETURN v_total_balance;
    END;

END CustomerManagement;
/


-- Testing :

-- 1. Addition of customer 
EXEC CustomerManagement.AddCustomer(20, 'New Customer', TO_DATE('1995-01-01', 'YYYY-MM-DD'), 2500);

-- 2. Updatation of customer details
EXEC CustomerManagement.UpdateCustomerDetails(20, 'Updated Customer', TO_DATE('1996-02-02', 'YYYY-MM-DD'));

-- 3. getting Balance
DECLARE
    v_balance NUMBER;
BEGIN
    v_balance := CustomerManagement.GetCustomerBalance(1);
    DBMS_OUTPUT.PUT_LINE('Total Balance: ₹' || v_balance);
END;
/
