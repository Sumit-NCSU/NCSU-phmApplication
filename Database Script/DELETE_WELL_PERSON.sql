CREATE OR REPLACE TRIGGER delete_well_person BEFORE
    DELETE ON sick_person
    FOR EACH ROW
BEGIN
    DELETE FROM well_person WHERE
        p_id =:old.p_id;

END;
/
