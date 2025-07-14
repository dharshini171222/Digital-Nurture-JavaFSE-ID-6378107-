-- Table before qurrey
SELECT * FROM Accounts ;


-- CURSOR creation 

SET SERVEROUTPUT ON;

DECLARE
    CURSOR fee_cursor IS
        SELECT AccountID, Balance
        FROM Accounts
        FOR UPDATE;

    v_new_balance Accounts.Balance%TYPE;
    v_fee CONSTANT NUMBER := 100;  -- Annual fee
BEGIN
    FOR acc IN fee_cursor LOOP
        v_new_balance := acc.Balance - v_fee;

        -- Deduct the fee
        UPDATE Accounts
        SET Balance = v_new_balance
        WHERE AccountID = acc.AccountID;

        DBMS_OUTPUT.PUT_LINE(
            'Annual fee of ₹' || v_fee || ' applied to Account ID ' || acc.AccountID ||
            '. New Balance: ₹' || v_new_balance
        );
    END LOOP;

    COMMIT;
END;
/


-- Table after qurrey
SELECT * FROM Accounts ;