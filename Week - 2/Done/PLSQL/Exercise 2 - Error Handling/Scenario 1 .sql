-- checking before the qurrey

SELECT * FROM Accounts ;


-- qurrey to create a procedure 

CREATE OR REPLACE PROCEDURE SafeTransferFunds (
    p_from_account_id IN NUMBER,
    p_to_account_id   IN NUMBER,
    p_amount          IN NUMBER
) AS
    v_balance NUMBER;
BEGIN
    -- Get balance of source account
    SELECT Balance INTO v_balance
    FROM Accounts
    WHERE AccountID = p_from_account_id
    FOR UPDATE;

    IF v_balance < p_amount THEN
        RAISE_APPLICATION_ERROR(-20001, 'Insufficient funds in source account.');
    END IF;

    -- Deduct from source
    UPDATE Accounts
    SET Balance = Balance - p_amount
    WHERE AccountID = p_from_account_id;

    -- Add to target
    UPDATE Accounts
    SET Balance = Balance + p_amount
    WHERE AccountID = p_to_account_id;

    COMMIT;

    DBMS_OUTPUT.PUT_LINE('Transferred ₹' || p_amount || ' from account ' || p_from_account_id || ' to ' || p_to_account_id);

EXCEPTION
    WHEN OTHERS THEN
        ROLLBACK;
        DBMS_OUTPUT.PUT_LINE('Error: ' || SQLERRM);
END;
/


-- running procedure
EXEC SafeTransferFunds(5, 6, 1000);  -- Works if Account 5 has enough balance
EXEC SafeTransferFunds(4, 3, 5000);  -- Fails if Account 4 doesn't have ₹5000


-- checking after the qurrey

SELECT * FROM Accounts ;