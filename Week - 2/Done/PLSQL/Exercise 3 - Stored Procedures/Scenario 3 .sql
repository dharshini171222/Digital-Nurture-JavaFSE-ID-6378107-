-- checking before the qurrey

SELECT * FROM ACCOUNTS ;


-- qurrey to create a procedure

CREATE OR REPLACE PROCEDURE TransferFunds (
    p_from_account_id IN NUMBER,
    p_to_account_id   IN NUMBER,
    p_amount          IN NUMBER
) AS
    v_from_balance Accounts.Balance%TYPE;
BEGIN
    -- Lock the source account and get balance
    SELECT Balance INTO v_from_balance
    FROM Accounts
    WHERE AccountID = p_from_account_id
    FOR UPDATE;

    -- Check for sufficient balance
    IF v_from_balance < p_amount THEN
        RAISE_APPLICATION_ERROR(-20001, 'Insufficient balance in source account.');
    END IF;

    -- Deduct from source
    UPDATE Accounts
    SET Balance = Balance - p_amount
    WHERE AccountID = p_from_account_id;

    -- Add to destination
    UPDATE Accounts
    SET Balance = Balance + p_amount
    WHERE AccountID = p_to_account_id;

    COMMIT;

    DBMS_OUTPUT.PUT_LINE('Transferred ₹' || p_amount || 
                         ' from Account ' || p_from_account_id || 
                         ' to Account ' || p_to_account_id);

EXCEPTION
    WHEN NO_DATA_FOUND THEN
        DBMS_OUTPUT.PUT_LINE('Error: One or both account IDs do not exist.');
    WHEN OTHERS THEN
        ROLLBACK;
        DBMS_OUTPUT.PUT_LINE('Error: ' || SQLERRM);
END;
/


-- running procedure

EXEC TransferFunds(5, 6, 1000);    -- Works if Account 5 has ₹1000+
EXEC TransferFunds(4, 3, 50000);   -- Should raise an insufficient funds error


-- checking after the qurrey

SELECT * FROM ACCOUNTS ;
