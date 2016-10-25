exec CreateTables.sql
exec TRIGGER_OBSV_BOUND.sql
exec TRIGGER_DELETE_WELL_PERSON.sql
exec TRIGGER_RECORD_WELL_PERSON.sql
exec TRIGGER_OBSERVATION_VIEWED.sql
exec PROCEDURE_CHECK_FREQ.sql
exec insertSampleData.sql

commit;
