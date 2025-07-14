-- qurrey to create a procedure 

CREATE OR REPLACE FUNCTION HasSufficientBalance (
    p_account_id IN NUMBER,
    p_amount     IN NUMBER
) RETURN BOOLEAN IS
    v_balance NUMBER;
BEGIN
    SELECT Balance INTO v_balance
    FROM Accounts
    WHERE AccountID = p_account_id;

    RETURN v_balance >= p_amount;
EXCEPTION
    WHEN NO_DATA_FOUND THEN
        DBMS_OUTPUT.PUT_LINE('Account ID ' || p_account_id || ' not found.');
        RETURN FALSE;
    WHEN OTHERS THEN
        DBMS_OUTPUT.PUT_LINE('Error: ' || SQLERRM);
        RETURN FALSE;
END;
/


-- checking after the qurrey

SET SERVEROUTPUT ON;

DECLARE
    v_result BOOLEAN;
BEGIN
    FOR rec IN (SELECT AccountID, Balance FROM Accounts) LOOP
        v_result := HasSufficientBalance(rec.AccountID, 1000); -- change the amount as needed

        IF v_result THEN
            DBMS_OUTPUT.PUT_LINE('Account ' || rec.AccountID || ' has sufficient balance (₹' || rec.Balance || ').');
        ELSE
            DBMS_OUTPUT.PUT_LINE('Account ' || rec.AccountID || ' does NOT have sufficient balance (₹' || rec.Balance || ').');
        END IF;
    END LOOP;
END;
/
