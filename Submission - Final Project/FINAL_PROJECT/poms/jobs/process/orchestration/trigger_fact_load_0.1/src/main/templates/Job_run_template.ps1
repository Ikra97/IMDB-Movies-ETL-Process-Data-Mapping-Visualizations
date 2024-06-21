$fileDir = Split-Path -Parent $MyInvocation.MyCommand.Path
cd $fileDir
java '-Dtalend.component.manager.m2.repository=%cd%/../lib' '-Xms256M' '-Xmx1024M' '-Dfile.encoding=UTF-8' -cp '.;../lib/routines.jar;../lib/log4j-slf4j-impl-2.17.1.jar;../lib/log4j-api-2.17.1.jar;../lib/log4j-core-2.17.1.jar;../lib/log4j-1.2-api-2.17.1.jar;../lib/commons-collections-3.2.2.jar;../lib/audit-log4j2-1.16.1.jar;../lib/jboss-marshalling-2.0.12.Final.jar;../lib/json-smart-2.4.11.jar;../lib/logging-event-layout-1.16.1.jar;../lib/crypto-utils-7.0.5.jar;../lib/asm-9.5.jar;../lib/commons-lang3-3.10.jar;../lib/slf4j-api-1.7.34.jar;../lib/job-audit-1.5.jar;../lib/advancedPersistentLookupLib.jar;../lib/talend_file_enhanced-1.3.jar;../lib/dom4j-2.1.3.jar;../lib/mysql-connector-j-8.0.33.jar;../lib/trove.jar;../lib/audit-common-1.16.1.jar;../lib/jboss-marshalling-river-2.0.12.Final.jar;../lib/accessors-smart-2.4.11.jar;trigger_fact_load_0_1.jar;fact_aggregation_0_1.jar;fact_earning_0_1.jar;fact_movie_0_1.jar;pre_job_log_0_1.jar;' final_project.trigger_fact_load_0_1.trigger_fact_load $args
