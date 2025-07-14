-- package creation 

CREATE OR REPLACE PACKAGE BODY EmployeeManagement AS

    PROCEDURE HireEmployee(
        p_employee_id IN NUMBER,
        p_name        IN VARCHAR2,
        p_position    IN VARCHAR2,
        p_salary      IN NUMBER,
        p_department  IN VARCHAR2,
        p_hire_date   IN DATE
    ) IS
    BEGIN
        INSERT INTO Employees (EmployeeID, Name, Position, Salary, Department, HireDate)
        VALUES (p_employee_id, p_name, p_position, p_salary, p_department, p_hire_date);

        DBMS_OUTPUT.PUT_LINE('Employee hired: ' || p_name);
    EXCEPTION
        WHEN DUP_VAL_ON_INDEX THEN
            DBMS_OUTPUT.PUT_LINE('Employee ID already exists.');
        WHEN OTHERS THEN
            DBMS_OUTPUT.PUT_LINE('Error: ' || SQLERRM);
    END;

    PROCEDURE UpdateEmployeeDetails(
        p_employee_id IN NUMBER,
        p_position    IN VARCHAR2,
        p_salary      IN NUMBER,
        p_department  IN VARCHAR2
    ) IS
    BEGIN
        UPDATE Employees
        SET Position = p_position,
            Salary = p_salary,
            Department = p_department
        WHERE EmployeeID = p_employee_id;

        IF SQL%ROWCOUNT = 0 THEN
            DBMS_OUTPUT.PUT_LINE('No such employee found.');
        ELSE
            DBMS_OUTPUT.PUT_LINE('Employee updated successfully.');
        END IF;
    END;

    FUNCTION CalculateAnnualSalary(
        p_employee_id IN NUMBER
    ) RETURN NUMBER IS
        v_salary Employees.Salary%TYPE;
    BEGIN
        SELECT Salary INTO v_salary
        FROM Employees
        WHERE EmployeeID = p_employee_id;

        RETURN v_salary * 12;
    EXCEPTION
        WHEN NO_DATA_FOUND THEN
            DBMS_OUTPUT.PUT_LINE('Employee not found.');
            RETURN NULL;
    END;

END EmployeeManagement;
/


-- Testing :

-- 1. new employee 
EXEC EmployeeManagement.HireEmployee(11, 'Kevin Hart', 'Analyst', 48000, 'Finance', TO_DATE('2024-01-01', 'YYYY-MM-DD'));

-- 2. Updatation of empluee details
EXEC EmployeeManagement.UpdateEmployeeDetails(11, 'Sr. Analyst', 52000, 'Finance');

-- 3. getting anual salary
DECLARE
    v_annual_salary NUMBER;
BEGIN
    v_annual_salary := EmployeeManagement.CalculateAnnualSalary(11);
    DBMS_OUTPUT.PUT_LINE('Annual Salary: ₹' || v_annual_salary);
END;
/

