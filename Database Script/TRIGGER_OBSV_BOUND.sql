create or replace TRIGGER obsv_value_bound
  BEFORE
    INSERT-- OR
    --UPDATE OF ob_value
  ON observation
FOR EACH ROW
declare is_null number;
lo_bound number;
up_bound number;
alert_count number;
descrip_reco VARCHAR2(1024);
is_sick number;
BEGIN
select R1.lower_bound into is_null from RECOMMENDATION R1 where R1.r_id = :new.r_id;
if is_null is not null
  then
    select to_number(R1.lower_bound) into lo_bound from RECOMMENDATION R1 where R1.r_id = :new.r_id;
    select to_number(R1.upper_bound) into up_bound from RECOMMENDATION R1 where R1.r_id = :new.r_id;
    select R1.description into descrip_reco from RECOMMENDATION R1 where R1.r_id = :new.r_id;
    if (to_number(:new.ob_value) > up_bound or to_number(:new.ob_value) < lo_bound)
      then
        select count(*) into alert_count from alert;
        select count(*) into is_sick from sick_person where p_id = :new.p_id;
        if is_sick = 1
          then
            insert into alert values(alert_count+1,:new.p_id, descrip_reco, 'T', 'F');
          else
            insert into alert values(alert_count+1,:new.p_id, descrip_reco, 'T', 'F');
        end if;
        --DBMS_OUTPUT.PUT_LINE('InsertingYY');
        --DBMS_OUTPUT.PUT_LINE('InsertingNNN');
    end if;
end if;
END;
/


COMMIT;
