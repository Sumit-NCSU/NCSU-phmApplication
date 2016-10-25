create or replace TRIGGER obsv_value_bound
  BEFORE
    INSERT-- OR
    --UPDATE OF ob_value
  ON observation
FOR EACH ROW
declare is_null number;
lo_bound varchar2(20);
up_bound varchar2(20);
alert_count number;
descrip_reco VARCHAR2(1024);
is_sick number;
ob_frequency varchar2(20);
BEGIN
select R1.lower_bound into is_null from RECOMMENDATION R1 where R1.r_id = :new.r_id;
if is_null is not null
  then
    select to_number(R1.lower_bound), to_number(R1.upper_bound), R1.description, R1.frequency into lo_bound, up_bound, descrip_reco, ob_frequency from RECOMMENDATION R1 where R1.r_id = :new.r_id;
    if (to_number(:new.ob_value) > to_number(up_bound) or to_number(:new.ob_value) < to_number(lo_bound))
      then
        select count(*) into alert_count from alert;
        select count(*) into is_sick from sick_person where p_id = :new.p_id;
        if is_sick = 1
          then
            insert into alert values(alert_count+1,:new.p_id, descrip_reco, :new.ob_time, :new.ob_value, ob_frequency, lo_bound, up_bound,  'T', 'F');
          else
            insert into alert values(alert_count+1,:new.p_id, descrip_reco, :new.ob_time, :new.ob_value, ob_frequency, lo_bound, up_bound, 'F', 'F');
        end if;
    end if;
end if;
END;
/



COMMIT;

