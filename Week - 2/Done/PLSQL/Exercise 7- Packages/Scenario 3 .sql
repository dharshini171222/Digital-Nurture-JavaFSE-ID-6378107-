-- package creation 

CREATE OR REPLACE PACKAGE BODY AccountOperations AS

    PROCEDURE OpenAccount(
        p_account_id   IN NUMBER,
        p_customer_id  IN NUMBER,
        p_account_type IN VARCHAR2,
        p_balance      IN NUMBER
    ) IS
    BEGIN
        INSERT INTO Accounts(AccountID, CustomerID, AccountType, Balance, LastModified)
        VALUES (p_account_id, p_customer_id, p_account_type, p_balance, SYSDATE);

        DBMS_OUTPUT.PUT_LINE('Account opened with ID: ' || p_account_id);
    EXCEPTION
        WHEN DUP_VAL_ON_INDEX THEN
            DBMS_OUTPUT.PUT_LINE('Account ID already exists.');
        WHEN OTHERS THEN
            DBMS_OUTPUT.PUT_LINE('Error: ' || SQLERRM);
    END;

    PROCEDURE CloseAccount(
        p_account_id IN NUMBER
    ) IS
    BEGIN
        DELETE FROM Accounts
        WHERE AccountID = p_account_id;

        IF SQL%ROWCOUNT = 0 THEN
            DBMS_OUTPUT.PUT_LINE('No such account found.');
        ELSE
            DBMS_OUTPUT.PUT_LINE('Account closed successfully.');
        END IF;
    END;

    FUNCTION GetTotalBalance(
        p_customer_id IN NUMBER
    ) RETURN NUMBER IS
        v_total NUMBER;
    BEGIN
        SELECT NVL(SUM(Balance), 0)
        INTO v_total
        FROM Accounts
        WHERE CustomerID = p_customer_id;

        RETURN v_total;
    EXCEPTION
        WHEN OTHERS THEN
            DBMS_OUTPUT.PUT_LINE('Error: ' || SQLERRM);
            RETURN NULL;
    END;

END AccountOperations;
/



-- Testing :

-- 1. new account 
EXEC AccountOperations.OpenAccount(21, 2, 'Savings', 3000);

-- 2. close account
EXEC AccountOperations.CloseAccount(21);

-- 3. getting total balance
DECLARE
    v_balance NUMBER;
BEGIN
    v_balance := AccountOperations.GetTotalBalance(2);
    DBMS_OUTPUT.PUT_LINE('Total Balance for Customer 2: ₹' || v_balance);
END;
/


