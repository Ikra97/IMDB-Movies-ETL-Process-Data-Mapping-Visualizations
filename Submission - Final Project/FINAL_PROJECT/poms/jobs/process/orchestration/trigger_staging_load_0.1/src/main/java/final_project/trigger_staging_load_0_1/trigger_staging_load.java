
package final_project.trigger_staging_load_0_1;

import routines.Numeric;
import routines.DataOperation;
import routines.TalendDataGenerator;
import routines.TalendStringUtil;
import routines.TalendString;
import routines.StringHandling;
import routines.Relational;
import routines.TalendDate;
import routines.Mathematical;
import routines.SQLike;
import routines.system.*;
import routines.system.api.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.math.BigDecimal;
import java.io.ByteArrayOutputStream;
import java.io.ByteArrayInputStream;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.ObjectOutputStream;
import java.io.ObjectInputStream;
import java.io.IOException;
import java.util.Comparator;

@SuppressWarnings("unused")

/**
 * Job: trigger_staging_load Purpose: <br>
 * Description: <br>
 * 
 * @author gorle.g@northeastern.edu
 * @version 8.0.1.20230913_0925-patch
 * @status
 */
public class trigger_staging_load implements TalendJob {
	static {
		System.setProperty("TalendJob.log", "trigger_staging_load.log");
	}

	private static org.apache.logging.log4j.Logger log = org.apache.logging.log4j.LogManager
			.getLogger(trigger_staging_load.class);

	protected static void logIgnoredError(String message, Throwable cause) {
		log.error(message, cause);

	}

	public final Object obj = new Object();

	// for transmiting parameters purpose
	private Object valueObject = null;

	public Object getValueObject() {
		return this.valueObject;
	}

	public void setValueObject(Object valueObject) {
		this.valueObject = valueObject;
	}

	private final static String defaultCharset = java.nio.charset.Charset.defaultCharset().name();

	private final static String utf8Charset = "UTF-8";

	// contains type for every context property
	public class PropertiesWithType extends java.util.Properties {
		private static final long serialVersionUID = 1L;
		private java.util.Map<String, String> propertyTypes = new java.util.HashMap<>();

		public PropertiesWithType(java.util.Properties properties) {
			super(properties);
		}

		public PropertiesWithType() {
			super();
		}

		public void setContextType(String key, String type) {
			propertyTypes.put(key, type);
		}

		public String getContextType(String key) {
			return propertyTypes.get(key);
		}
	}

	// create and load default properties
	private java.util.Properties defaultProps = new java.util.Properties();

	// create application properties with default
	public class ContextProperties extends PropertiesWithType {

		private static final long serialVersionUID = 1L;

		public ContextProperties(java.util.Properties properties) {
			super(properties);
		}

		public ContextProperties() {
			super();
		}

		public void synchronizeContext() {

			if (json_job != null) {

				this.setProperty("json_job", json_job.toString());

			}

			if (job_name != null) {

				this.setProperty("job_name", job_name.toString());

			}

			if (sql_job != null) {

				this.setProperty("sql_job", sql_job.toString());

			}

			if (tsv_job != null) {

				this.setProperty("tsv_job", tsv_job.toString());

			}

		}

		// if the stored or passed value is "<TALEND_NULL>" string, it mean null
		public String getStringValue(String key) {
			String origin_value = this.getProperty(key);
			if (NULL_VALUE_EXPRESSION_IN_COMMAND_STRING_FOR_CHILD_JOB_ONLY.equals(origin_value)) {
				return null;
			}
			return origin_value;
		}

		public String json_job;

		public String getJson_job() {
			return this.json_job;
		}

		public String job_name;

		public String getJob_name() {
			return this.job_name;
		}

		public String sql_job;

		public String getSql_job() {
			return this.sql_job;
		}

		public String tsv_job;

		public String getTsv_job() {
			return this.tsv_job;
		}
	}

	protected ContextProperties context = new ContextProperties(); // will be instanciated by MS.

	public ContextProperties getContext() {
		return this.context;
	}

	private final String jobVersion = "0.1";
	private final String jobName = "trigger_staging_load";
	private final String projectName = "FINAL_PROJECT";
	public Integer errorCode = null;
	private String currentComponent = "";

	private String cLabel = null;

	private final java.util.Map<String, Object> globalMap = new java.util.HashMap<String, Object>();
	private final static java.util.Map<String, Object> junitGlobalMap = new java.util.HashMap<String, Object>();

	private final java.util.Map<String, Long> start_Hash = new java.util.HashMap<String, Long>();
	private final java.util.Map<String, Long> end_Hash = new java.util.HashMap<String, Long>();
	private final java.util.Map<String, Boolean> ok_Hash = new java.util.HashMap<String, Boolean>();
	public final java.util.List<String[]> globalBuffer = new java.util.ArrayList<String[]>();

	private final JobStructureCatcherUtils talendJobLog = new JobStructureCatcherUtils(jobName,
			"_zRgRoJI2Ee6x56qGn8mRSw", "0.1");
	private org.talend.job.audit.JobAuditLogger auditLogger_talendJobLog = null;

	private RunStat runStat = new RunStat(talendJobLog, System.getProperty("audit.interval"));

	// OSGi DataSource
	private final static String KEY_DB_DATASOURCES = "KEY_DB_DATASOURCES";

	private final static String KEY_DB_DATASOURCES_RAW = "KEY_DB_DATASOURCES_RAW";

	public void setDataSources(java.util.Map<String, javax.sql.DataSource> dataSources) {
		java.util.Map<String, routines.system.TalendDataSource> talendDataSources = new java.util.HashMap<String, routines.system.TalendDataSource>();
		for (java.util.Map.Entry<String, javax.sql.DataSource> dataSourceEntry : dataSources.entrySet()) {
			talendDataSources.put(dataSourceEntry.getKey(),
					new routines.system.TalendDataSource(dataSourceEntry.getValue()));
		}
		globalMap.put(KEY_DB_DATASOURCES, talendDataSources);
		globalMap.put(KEY_DB_DATASOURCES_RAW, new java.util.HashMap<String, javax.sql.DataSource>(dataSources));
	}

	public void setDataSourceReferences(List serviceReferences) throws Exception {

		java.util.Map<String, routines.system.TalendDataSource> talendDataSources = new java.util.HashMap<String, routines.system.TalendDataSource>();
		java.util.Map<String, javax.sql.DataSource> dataSources = new java.util.HashMap<String, javax.sql.DataSource>();

		for (java.util.Map.Entry<String, javax.sql.DataSource> entry : BundleUtils
				.getServices(serviceReferences, javax.sql.DataSource.class).entrySet()) {
			dataSources.put(entry.getKey(), entry.getValue());
			talendDataSources.put(entry.getKey(), new routines.system.TalendDataSource(entry.getValue()));
		}

		globalMap.put(KEY_DB_DATASOURCES, talendDataSources);
		globalMap.put(KEY_DB_DATASOURCES_RAW, new java.util.HashMap<String, javax.sql.DataSource>(dataSources));
	}

	private final java.io.ByteArrayOutputStream baos = new java.io.ByteArrayOutputStream();
	private final java.io.PrintStream errorMessagePS = new java.io.PrintStream(new java.io.BufferedOutputStream(baos));

	public String getExceptionStackTrace() {
		if ("failure".equals(this.getStatus())) {
			errorMessagePS.flush();
			return baos.toString();
		}
		return null;
	}

	private Exception exception;

	public Exception getException() {
		if ("failure".equals(this.getStatus())) {
			return this.exception;
		}
		return null;
	}

	private class TalendException extends Exception {

		private static final long serialVersionUID = 1L;

		private java.util.Map<String, Object> globalMap = null;
		private Exception e = null;

		private String currentComponent = null;
		private String cLabel = null;

		private String virtualComponentName = null;

		public void setVirtualComponentName(String virtualComponentName) {
			this.virtualComponentName = virtualComponentName;
		}

		private TalendException(Exception e, String errorComponent, final java.util.Map<String, Object> globalMap) {
			this.currentComponent = errorComponent;
			this.globalMap = globalMap;
			this.e = e;
		}

		private TalendException(Exception e, String errorComponent, String errorComponentLabel,
				final java.util.Map<String, Object> globalMap) {
			this(e, errorComponent, globalMap);
			this.cLabel = errorComponentLabel;
		}

		public Exception getException() {
			return this.e;
		}

		public String getCurrentComponent() {
			return this.currentComponent;
		}

		public String getExceptionCauseMessage(Exception e) {
			Throwable cause = e;
			String message = null;
			int i = 10;
			while (null != cause && 0 < i--) {
				message = cause.getMessage();
				if (null == message) {
					cause = cause.getCause();
				} else {
					break;
				}
			}
			if (null == message) {
				message = e.getClass().getName();
			}
			return message;
		}

		@Override
		public void printStackTrace() {
			if (!(e instanceof TalendException || e instanceof TDieException)) {
				if (virtualComponentName != null && currentComponent.indexOf(virtualComponentName + "_") == 0) {
					globalMap.put(virtualComponentName + "_ERROR_MESSAGE", getExceptionCauseMessage(e));
				}
				globalMap.put(currentComponent + "_ERROR_MESSAGE", getExceptionCauseMessage(e));
				System.err.println("Exception in component " + currentComponent + " (" + jobName + ")");
			}
			if (!(e instanceof TDieException)) {
				if (e instanceof TalendException) {
					e.printStackTrace();
				} else {
					e.printStackTrace();
					e.printStackTrace(errorMessagePS);
					trigger_staging_load.this.exception = e;
				}
			}
			if (!(e instanceof TalendException)) {
				try {
					for (java.lang.reflect.Method m : this.getClass().getEnclosingClass().getMethods()) {
						if (m.getName().compareTo(currentComponent + "_error") == 0) {
							m.invoke(trigger_staging_load.this, new Object[] { e, currentComponent, globalMap });
							break;
						}
					}

					if (!(e instanceof TDieException)) {
						if (enableLogStash) {
							talendJobLog.addJobExceptionMessage(currentComponent, cLabel, null, e);
							talendJobLogProcess(globalMap);
						}
					}
				} catch (Exception e) {
					this.e.printStackTrace();
				}
			}
		}
	}

	public void tPostjob_1_error(Exception exception, String errorComponent,
			final java.util.Map<String, Object> globalMap) throws TalendException {

		end_Hash.put(errorComponent, System.currentTimeMillis());

		status = "failure";

		tPostjob_1_onSubJobError(exception, errorComponent, globalMap);
	}

	public void tRunJob_2_error(Exception exception, String errorComponent,
			final java.util.Map<String, Object> globalMap) throws TalendException {

		end_Hash.put(errorComponent, System.currentTimeMillis());

		status = "failure";

		tRunJob_2_onSubJobError(exception, errorComponent, globalMap);
	}

	public void tPrejob_1_error(Exception exception, String errorComponent,
			final java.util.Map<String, Object> globalMap) throws TalendException {

		end_Hash.put(errorComponent, System.currentTimeMillis());

		status = "failure";

		tPrejob_1_onSubJobError(exception, errorComponent, globalMap);
	}

	public void tRunJob_1_error(Exception exception, String errorComponent,
			final java.util.Map<String, Object> globalMap) throws TalendException {

		end_Hash.put(errorComponent, System.currentTimeMillis());

		status = "failure";

		tRunJob_1_onSubJobError(exception, errorComponent, globalMap);
	}

	public void tRunJob_3_error(Exception exception, String errorComponent,
			final java.util.Map<String, Object> globalMap) throws TalendException {

		end_Hash.put(errorComponent, System.currentTimeMillis());

		status = "failure";

		tRunJob_3_onSubJobError(exception, errorComponent, globalMap);
	}

	public void tRunJob_4_error(Exception exception, String errorComponent,
			final java.util.Map<String, Object> globalMap) throws TalendException {

		end_Hash.put(errorComponent, System.currentTimeMillis());

		status = "failure";

		tRunJob_4_onSubJobError(exception, errorComponent, globalMap);
	}

	public void tRunJob_5_error(Exception exception, String errorComponent,
			final java.util.Map<String, Object> globalMap) throws TalendException {

		end_Hash.put(errorComponent, System.currentTimeMillis());

		tRunJob_5_onSubJobError(exception, errorComponent, globalMap);
	}

	public void tRunJob_6_error(Exception exception, String errorComponent,
			final java.util.Map<String, Object> globalMap) throws TalendException {

		end_Hash.put(errorComponent, System.currentTimeMillis());

		status = "failure";

		tRunJob_6_onSubJobError(exception, errorComponent, globalMap);
	}

	public void tRunJob_7_error(Exception exception, String errorComponent,
			final java.util.Map<String, Object> globalMap) throws TalendException {

		end_Hash.put(errorComponent, System.currentTimeMillis());

		tRunJob_7_onSubJobError(exception, errorComponent, globalMap);
	}

	public void tRunJob_8_error(Exception exception, String errorComponent,
			final java.util.Map<String, Object> globalMap) throws TalendException {

		end_Hash.put(errorComponent, System.currentTimeMillis());

		status = "failure";

		tRunJob_8_onSubJobError(exception, errorComponent, globalMap);
	}

	public void talendJobLog_error(Exception exception, String errorComponent,
			final java.util.Map<String, Object> globalMap) throws TalendException {

		end_Hash.put(errorComponent, System.currentTimeMillis());

		status = "failure";

		talendJobLog_onSubJobError(exception, errorComponent, globalMap);
	}

	public void tPostjob_1_onSubJobError(Exception exception, String errorComponent,
			final java.util.Map<String, Object> globalMap) throws TalendException {

		resumeUtil.addLog("SYSTEM_LOG", "NODE:" + errorComponent, "", Thread.currentThread().getId() + "", "FATAL", "",
				exception.getMessage(), ResumeUtil.getExceptionStackTrace(exception), "");

	}

	public void tRunJob_2_onSubJobError(Exception exception, String errorComponent,
			final java.util.Map<String, Object> globalMap) throws TalendException {

		resumeUtil.addLog("SYSTEM_LOG", "NODE:" + errorComponent, "", Thread.currentThread().getId() + "", "FATAL", "",
				exception.getMessage(), ResumeUtil.getExceptionStackTrace(exception), "");

	}

	public void tPrejob_1_onSubJobError(Exception exception, String errorComponent,
			final java.util.Map<String, Object> globalMap) throws TalendException {

		resumeUtil.addLog("SYSTEM_LOG", "NODE:" + errorComponent, "", Thread.currentThread().getId() + "", "FATAL", "",
				exception.getMessage(), ResumeUtil.getExceptionStackTrace(exception), "");

	}

	public void tRunJob_1_onSubJobError(Exception exception, String errorComponent,
			final java.util.Map<String, Object> globalMap) throws TalendException {

		resumeUtil.addLog("SYSTEM_LOG", "NODE:" + errorComponent, "", Thread.currentThread().getId() + "", "FATAL", "",
				exception.getMessage(), ResumeUtil.getExceptionStackTrace(exception), "");

	}

	public void tRunJob_3_onSubJobError(Exception exception, String errorComponent,
			final java.util.Map<String, Object> globalMap) throws TalendException {

		resumeUtil.addLog("SYSTEM_LOG", "NODE:" + errorComponent, "", Thread.currentThread().getId() + "", "FATAL", "",
				exception.getMessage(), ResumeUtil.getExceptionStackTrace(exception), "");

	}

	public void tRunJob_4_onSubJobError(Exception exception, String errorComponent,
			final java.util.Map<String, Object> globalMap) throws TalendException {

		resumeUtil.addLog("SYSTEM_LOG", "NODE:" + errorComponent, "", Thread.currentThread().getId() + "", "FATAL", "",
				exception.getMessage(), ResumeUtil.getExceptionStackTrace(exception), "");

	}

	public void tRunJob_5_onSubJobError(Exception exception, String errorComponent,
			final java.util.Map<String, Object> globalMap) throws TalendException {

		resumeUtil.addLog("SYSTEM_LOG", "NODE:" + errorComponent, "", Thread.currentThread().getId() + "", "ERROR", "",
				exception.getMessage(), ResumeUtil.getExceptionStackTrace(exception), "");

		try {

			if (this.execStat) {
				runStat.updateStatOnConnection("OnSubjobError1", 0, "error");
			}

			errorCode = null;
			tRunJob_6Process(globalMap);
			if (!"failure".equals(status)) {
				status = "end";
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void tRunJob_6_onSubJobError(Exception exception, String errorComponent,
			final java.util.Map<String, Object> globalMap) throws TalendException {

		resumeUtil.addLog("SYSTEM_LOG", "NODE:" + errorComponent, "", Thread.currentThread().getId() + "", "FATAL", "",
				exception.getMessage(), ResumeUtil.getExceptionStackTrace(exception), "");

	}

	public void tRunJob_7_onSubJobError(Exception exception, String errorComponent,
			final java.util.Map<String, Object> globalMap) throws TalendException {

		resumeUtil.addLog("SYSTEM_LOG", "NODE:" + errorComponent, "", Thread.currentThread().getId() + "", "ERROR", "",
				exception.getMessage(), ResumeUtil.getExceptionStackTrace(exception), "");

		try {

			if (this.execStat) {
				runStat.updateStatOnConnection("OnSubjobError2", 0, "error");
			}

			errorCode = null;
			tRunJob_8Process(globalMap);
			if (!"failure".equals(status)) {
				status = "end";
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void tRunJob_8_onSubJobError(Exception exception, String errorComponent,
			final java.util.Map<String, Object> globalMap) throws TalendException {

		resumeUtil.addLog("SYSTEM_LOG", "NODE:" + errorComponent, "", Thread.currentThread().getId() + "", "FATAL", "",
				exception.getMessage(), ResumeUtil.getExceptionStackTrace(exception), "");

	}

	public void talendJobLog_onSubJobError(Exception exception, String errorComponent,
			final java.util.Map<String, Object> globalMap) throws TalendException {

		resumeUtil.addLog("SYSTEM_LOG", "NODE:" + errorComponent, "", Thread.currentThread().getId() + "", "FATAL", "",
				exception.getMessage(), ResumeUtil.getExceptionStackTrace(exception), "");

	}

	public void tPostjob_1Process(final java.util.Map<String, Object> globalMap) throws TalendException {
		globalMap.put("tPostjob_1_SUBPROCESS_STATE", 0);

		final boolean execStat = this.execStat;

		mdcInfo.forEach(org.slf4j.MDC::put);
		org.slf4j.MDC.put("_subJobName", "tPostjob_1");
		org.slf4j.MDC.put("_subJobPid", "X8PEyM_" + subJobPidCounter.getAndIncrement());

		String iterateId = "";

		String currentComponent = "";
		String cLabel = null;
		java.util.Map<String, Object> resourceMap = new java.util.HashMap<String, Object>();

		try {
			// TDI-39566 avoid throwing an useless Exception
			boolean resumeIt = true;
			if (globalResumeTicket == false && resumeEntryMethodName != null) {
				String currentMethodName = new java.lang.Exception().getStackTrace()[0].getMethodName();
				resumeIt = resumeEntryMethodName.equals(currentMethodName);
			}
			if (resumeIt || globalResumeTicket) { // start the resume
				globalResumeTicket = true;

				/**
				 * [tPostjob_1 begin ] start
				 */

				ok_Hash.put("tPostjob_1", false);
				start_Hash.put("tPostjob_1", System.currentTimeMillis());

				currentComponent = "tPostjob_1";

				int tos_count_tPostjob_1 = 0;

				if (enableLogStash) {
					talendJobLog.addCM("tPostjob_1", "tPostjob_1", "tPostjob");
					talendJobLogProcess(globalMap);
				}

				/**
				 * [tPostjob_1 begin ] stop
				 */

				/**
				 * [tPostjob_1 main ] start
				 */

				currentComponent = "tPostjob_1";

				tos_count_tPostjob_1++;

				/**
				 * [tPostjob_1 main ] stop
				 */

				/**
				 * [tPostjob_1 process_data_begin ] start
				 */

				currentComponent = "tPostjob_1";

				/**
				 * [tPostjob_1 process_data_begin ] stop
				 */

				/**
				 * [tPostjob_1 process_data_end ] start
				 */

				currentComponent = "tPostjob_1";

				/**
				 * [tPostjob_1 process_data_end ] stop
				 */

				/**
				 * [tPostjob_1 end ] start
				 */

				currentComponent = "tPostjob_1";

				ok_Hash.put("tPostjob_1", true);
				end_Hash.put("tPostjob_1", System.currentTimeMillis());

				if (execStat) {
					runStat.updateStatOnConnection("OnComponentOk2", 0, "ok");
				}
				tRunJob_2Process(globalMap);

				/**
				 * [tPostjob_1 end ] stop
				 */
			} // end the resume

		} catch (java.lang.Exception e) {

			if (!(e instanceof TalendException)) {
				log.fatal(currentComponent + " " + e.getMessage(), e);
			}

			TalendException te = new TalendException(e, currentComponent, cLabel, globalMap);

			throw te;
		} catch (java.lang.Error error) {

			runStat.stopThreadStat();

			throw error;
		} finally {

			try {

				/**
				 * [tPostjob_1 finally ] start
				 */

				currentComponent = "tPostjob_1";

				/**
				 * [tPostjob_1 finally ] stop
				 */
			} catch (java.lang.Exception e) {
				// ignore
			} catch (java.lang.Error error) {
				// ignore
			}
			resourceMap = null;
		}

		globalMap.put("tPostjob_1_SUBPROCESS_STATE", 1);
	}

	public void tRunJob_2Process(final java.util.Map<String, Object> globalMap) throws TalendException {
		globalMap.put("tRunJob_2_SUBPROCESS_STATE", 0);

		final boolean execStat = this.execStat;

		mdcInfo.forEach(org.slf4j.MDC::put);
		org.slf4j.MDC.put("_subJobName", "tRunJob_2");
		org.slf4j.MDC.put("_subJobPid", "ILV8Bj_" + subJobPidCounter.getAndIncrement());

		String iterateId = "";

		String currentComponent = "";
		String cLabel = null;
		java.util.Map<String, Object> resourceMap = new java.util.HashMap<String, Object>();

		try {
			// TDI-39566 avoid throwing an useless Exception
			boolean resumeIt = true;
			if (globalResumeTicket == false && resumeEntryMethodName != null) {
				String currentMethodName = new java.lang.Exception().getStackTrace()[0].getMethodName();
				resumeIt = resumeEntryMethodName.equals(currentMethodName);
			}
			if (resumeIt || globalResumeTicket) { // start the resume
				globalResumeTicket = true;

				/**
				 * [tRunJob_2 begin ] start
				 */

				ok_Hash.put("tRunJob_2", false);
				start_Hash.put("tRunJob_2", System.currentTimeMillis());

				currentComponent = "tRunJob_2";

				int tos_count_tRunJob_2 = 0;

				if (log.isDebugEnabled())
					log.debug("tRunJob_2 - " + ("Start to work."));
				if (log.isDebugEnabled()) {
					class BytesLimit65535_tRunJob_2 {
						public void limitLog4jByte() throws Exception {
							StringBuilder log4jParamters_tRunJob_2 = new StringBuilder();
							log4jParamters_tRunJob_2.append("Parameters:");
							log4jParamters_tRunJob_2.append("USE_DYNAMIC_JOB" + " = " + "false");
							log4jParamters_tRunJob_2.append(" | ");
							log4jParamters_tRunJob_2.append("PROCESS" + " = " + "pre_job_log");
							log4jParamters_tRunJob_2.append(" | ");
							log4jParamters_tRunJob_2.append("USE_INDEPENDENT_PROCESS" + " = " + "false");
							log4jParamters_tRunJob_2.append(" | ");
							log4jParamters_tRunJob_2.append("DIE_ON_CHILD_ERROR" + " = " + "true");
							log4jParamters_tRunJob_2.append(" | ");
							log4jParamters_tRunJob_2.append("TRANSMIT_WHOLE_CONTEXT" + " = " + "false");
							log4jParamters_tRunJob_2.append(" | ");
							log4jParamters_tRunJob_2
									.append("CONTEXTPARAMS" + " = " + "[{PARAM_NAME_COLUMN=" + ("job_name")
											+ ", PARAM_VALUE_COLUMN=" + ("context.job_name") + "}, {PARAM_NAME_COLUMN="
											+ ("job_status") + ", PARAM_VALUE_COLUMN=" + ("\"Completed\"") + "}]");
							log4jParamters_tRunJob_2.append(" | ");
							log4jParamters_tRunJob_2.append("PROPAGATE_CHILD_RESULT" + " = " + "false");
							log4jParamters_tRunJob_2.append(" | ");
							log4jParamters_tRunJob_2.append("PRINT_PARAMETER" + " = " + "false");
							log4jParamters_tRunJob_2.append(" | ");
							log4jParamters_tRunJob_2.append("USE_DYNAMIC_CONTEXT" + " = " + "false");
							log4jParamters_tRunJob_2.append(" | ");
							if (log.isDebugEnabled())
								log.debug("tRunJob_2 - " + (log4jParamters_tRunJob_2));
						}
					}
					new BytesLimit65535_tRunJob_2().limitLog4jByte();
				}
				if (enableLogStash) {
					talendJobLog.addCM("tRunJob_2", "tRunJob_2", "tRunJob");
					talendJobLogProcess(globalMap);
				}

				/**
				 * [tRunJob_2 begin ] stop
				 */

				/**
				 * [tRunJob_2 main ] start
				 */

				currentComponent = "tRunJob_2";

				java.util.List<String> paraList_tRunJob_2 = new java.util.ArrayList<String>();

				paraList_tRunJob_2.add("--father_pid=" + pid);

				paraList_tRunJob_2.add("--root_pid=" + rootPid);

				paraList_tRunJob_2.add("--father_node=tRunJob_2");

				paraList_tRunJob_2.add("--context=Default");

				if (!"".equals(log4jLevel)) {
					paraList_tRunJob_2.add("--log4jLevel=" + log4jLevel);
				}

				if (enableLogStash) {
					paraList_tRunJob_2.add("--audit.enabled=" + enableLogStash);
				}

				// for feature:10589

				paraList_tRunJob_2.add("--stat_port=" + portStats);

				if (resuming_logs_dir_path != null) {
					paraList_tRunJob_2.add("--resuming_logs_dir_path=" + resuming_logs_dir_path);
				}
				String childResumePath_tRunJob_2 = ResumeUtil.getChildJobCheckPointPath(resuming_checkpoint_path);
				String tRunJobName_tRunJob_2 = ResumeUtil.getRighttRunJob(resuming_checkpoint_path);
				if ("tRunJob_2".equals(tRunJobName_tRunJob_2) && childResumePath_tRunJob_2 != null) {
					paraList_tRunJob_2.add("--resuming_checkpoint_path="
							+ ResumeUtil.getChildJobCheckPointPath(resuming_checkpoint_path));
				}
				paraList_tRunJob_2.add("--parent_part_launcher=JOB:" + jobName + "/NODE:tRunJob_2");

				java.util.Map<String, Object> parentContextMap_tRunJob_2 = new java.util.HashMap<String, Object>();

				Object obj_tRunJob_2 = null;

				obj_tRunJob_2 = context.job_name;
				if (obj_tRunJob_2 != null) {
					if (obj_tRunJob_2.getClass().getName().equals("java.util.Date")) {
						paraList_tRunJob_2
								.add("--context_param job_name=" + ((java.util.Date) obj_tRunJob_2).getTime());
					} else {
						paraList_tRunJob_2
								.add("--context_param job_name=" + RuntimeUtils.tRunJobConvertContext(obj_tRunJob_2));
					}
				} else {
					paraList_tRunJob_2.add(
							"--context_param job_name=" + NULL_VALUE_EXPRESSION_IN_COMMAND_STRING_FOR_CHILD_JOB_ONLY);
				}

				parentContextMap_tRunJob_2.put("job_name", obj_tRunJob_2);

				obj_tRunJob_2 = "Completed";
				if (obj_tRunJob_2 != null) {
					if (obj_tRunJob_2.getClass().getName().equals("java.util.Date")) {
						paraList_tRunJob_2
								.add("--context_param job_status=" + ((java.util.Date) obj_tRunJob_2).getTime());
					} else {
						paraList_tRunJob_2
								.add("--context_param job_status=" + RuntimeUtils.tRunJobConvertContext(obj_tRunJob_2));
					}
				} else {
					paraList_tRunJob_2.add(
							"--context_param job_status=" + NULL_VALUE_EXPRESSION_IN_COMMAND_STRING_FOR_CHILD_JOB_ONLY);
				}

				parentContextMap_tRunJob_2.put("job_status", obj_tRunJob_2);

				final_project.pre_job_log_0_1.pre_job_log childJob_tRunJob_2 = new final_project.pre_job_log_0_1.pre_job_log();
				// pass DataSources
				java.util.Map<String, routines.system.TalendDataSource> talendDataSources_tRunJob_2 = (java.util.Map<String, routines.system.TalendDataSource>) globalMap
						.get(KEY_DB_DATASOURCES);
				if (null != talendDataSources_tRunJob_2) {
					java.util.Map<String, javax.sql.DataSource> dataSources_tRunJob_2 = new java.util.HashMap<String, javax.sql.DataSource>();
					for (java.util.Map.Entry<String, routines.system.TalendDataSource> talendDataSourceEntry_tRunJob_2 : talendDataSources_tRunJob_2
							.entrySet()) {
						dataSources_tRunJob_2.put(talendDataSourceEntry_tRunJob_2.getKey(),
								talendDataSourceEntry_tRunJob_2.getValue().getRawDataSource());
					}
					childJob_tRunJob_2.setDataSources(dataSources_tRunJob_2);
				}

				childJob_tRunJob_2.parentContextMap = parentContextMap_tRunJob_2;

				log.info(
						"tRunJob_2 - The child job 'final_project.pre_job_log_0_1.pre_job_log' starts on the version '0.1' with the context 'Default'.");

				String[][] childReturn_tRunJob_2 = childJob_tRunJob_2
						.runJob((String[]) paraList_tRunJob_2.toArray(new String[paraList_tRunJob_2.size()]));

				log.info("tRunJob_2 - The child job 'final_project.pre_job_log_0_1.pre_job_log' is done.");

				if (childJob_tRunJob_2.getErrorCode() == null) {
					globalMap.put("tRunJob_2_CHILD_RETURN_CODE",
							childJob_tRunJob_2.getStatus() != null && ("failure").equals(childJob_tRunJob_2.getStatus())
									? 1
									: 0);
				} else {
					globalMap.put("tRunJob_2_CHILD_RETURN_CODE", childJob_tRunJob_2.getErrorCode());
				}
				if (childJob_tRunJob_2.getExceptionStackTrace() != null) {
					globalMap.put("tRunJob_2_CHILD_EXCEPTION_STACKTRACE", childJob_tRunJob_2.getExceptionStackTrace());
				}
				errorCode = childJob_tRunJob_2.getErrorCode();
				if (childJob_tRunJob_2.getErrorCode() != null || ("failure").equals(childJob_tRunJob_2.getStatus())) {
					java.lang.Exception ce_tRunJob_2 = childJob_tRunJob_2.getException();
					throw new RuntimeException("Child job running failed.\n" + ((ce_tRunJob_2 != null)
							? (ce_tRunJob_2.getClass().getName() + ": " + ce_tRunJob_2.getMessage())
							: ""));
				}

				tos_count_tRunJob_2++;

				/**
				 * [tRunJob_2 main ] stop
				 */

				/**
				 * [tRunJob_2 process_data_begin ] start
				 */

				currentComponent = "tRunJob_2";

				/**
				 * [tRunJob_2 process_data_begin ] stop
				 */

				/**
				 * [tRunJob_2 process_data_end ] start
				 */

				currentComponent = "tRunJob_2";

				/**
				 * [tRunJob_2 process_data_end ] stop
				 */

				/**
				 * [tRunJob_2 end ] start
				 */

				currentComponent = "tRunJob_2";

				if (log.isDebugEnabled())
					log.debug("tRunJob_2 - " + ("Done."));

				ok_Hash.put("tRunJob_2", true);
				end_Hash.put("tRunJob_2", System.currentTimeMillis());

				/**
				 * [tRunJob_2 end ] stop
				 */
			} // end the resume

		} catch (java.lang.Exception e) {

			if (!(e instanceof TalendException)) {
				log.fatal(currentComponent + " " + e.getMessage(), e);
			}

			TalendException te = new TalendException(e, currentComponent, cLabel, globalMap);

			throw te;
		} catch (java.lang.Error error) {

			runStat.stopThreadStat();

			throw error;
		} finally {

			try {

				/**
				 * [tRunJob_2 finally ] start
				 */

				currentComponent = "tRunJob_2";

				/**
				 * [tRunJob_2 finally ] stop
				 */
			} catch (java.lang.Exception e) {
				// ignore
			} catch (java.lang.Error error) {
				// ignore
			}
			resourceMap = null;
		}

		globalMap.put("tRunJob_2_SUBPROCESS_STATE", 1);
	}

	public void tPrejob_1Process(final java.util.Map<String, Object> globalMap) throws TalendException {
		globalMap.put("tPrejob_1_SUBPROCESS_STATE", 0);

		final boolean execStat = this.execStat;

		mdcInfo.forEach(org.slf4j.MDC::put);
		org.slf4j.MDC.put("_subJobName", "tPrejob_1");
		org.slf4j.MDC.put("_subJobPid", "lxtYAn_" + subJobPidCounter.getAndIncrement());

		String iterateId = "";

		String currentComponent = "";
		String cLabel = null;
		java.util.Map<String, Object> resourceMap = new java.util.HashMap<String, Object>();

		try {
			// TDI-39566 avoid throwing an useless Exception
			boolean resumeIt = true;
			if (globalResumeTicket == false && resumeEntryMethodName != null) {
				String currentMethodName = new java.lang.Exception().getStackTrace()[0].getMethodName();
				resumeIt = resumeEntryMethodName.equals(currentMethodName);
			}
			if (resumeIt || globalResumeTicket) { // start the resume
				globalResumeTicket = true;

				/**
				 * [tPrejob_1 begin ] start
				 */

				ok_Hash.put("tPrejob_1", false);
				start_Hash.put("tPrejob_1", System.currentTimeMillis());

				currentComponent = "tPrejob_1";

				int tos_count_tPrejob_1 = 0;

				if (enableLogStash) {
					talendJobLog.addCM("tPrejob_1", "tPrejob_1", "tPrejob");
					talendJobLogProcess(globalMap);
				}

				/**
				 * [tPrejob_1 begin ] stop
				 */

				/**
				 * [tPrejob_1 main ] start
				 */

				currentComponent = "tPrejob_1";

				tos_count_tPrejob_1++;

				/**
				 * [tPrejob_1 main ] stop
				 */

				/**
				 * [tPrejob_1 process_data_begin ] start
				 */

				currentComponent = "tPrejob_1";

				/**
				 * [tPrejob_1 process_data_begin ] stop
				 */

				/**
				 * [tPrejob_1 process_data_end ] start
				 */

				currentComponent = "tPrejob_1";

				/**
				 * [tPrejob_1 process_data_end ] stop
				 */

				/**
				 * [tPrejob_1 end ] start
				 */

				currentComponent = "tPrejob_1";

				ok_Hash.put("tPrejob_1", true);
				end_Hash.put("tPrejob_1", System.currentTimeMillis());

				if (execStat) {
					runStat.updateStatOnConnection("OnComponentOk1", 0, "ok");
				}
				tRunJob_1Process(globalMap);

				/**
				 * [tPrejob_1 end ] stop
				 */
			} // end the resume

		} catch (java.lang.Exception e) {

			if (!(e instanceof TalendException)) {
				log.fatal(currentComponent + " " + e.getMessage(), e);
			}

			TalendException te = new TalendException(e, currentComponent, cLabel, globalMap);

			throw te;
		} catch (java.lang.Error error) {

			runStat.stopThreadStat();

			throw error;
		} finally {

			try {

				/**
				 * [tPrejob_1 finally ] start
				 */

				currentComponent = "tPrejob_1";

				/**
				 * [tPrejob_1 finally ] stop
				 */
			} catch (java.lang.Exception e) {
				// ignore
			} catch (java.lang.Error error) {
				// ignore
			}
			resourceMap = null;
		}

		globalMap.put("tPrejob_1_SUBPROCESS_STATE", 1);
	}

	public void tRunJob_1Process(final java.util.Map<String, Object> globalMap) throws TalendException {
		globalMap.put("tRunJob_1_SUBPROCESS_STATE", 0);

		final boolean execStat = this.execStat;

		mdcInfo.forEach(org.slf4j.MDC::put);
		org.slf4j.MDC.put("_subJobName", "tRunJob_1");
		org.slf4j.MDC.put("_subJobPid", "DpVlxF_" + subJobPidCounter.getAndIncrement());

		String iterateId = "";

		String currentComponent = "";
		String cLabel = null;
		java.util.Map<String, Object> resourceMap = new java.util.HashMap<String, Object>();

		try {
			// TDI-39566 avoid throwing an useless Exception
			boolean resumeIt = true;
			if (globalResumeTicket == false && resumeEntryMethodName != null) {
				String currentMethodName = new java.lang.Exception().getStackTrace()[0].getMethodName();
				resumeIt = resumeEntryMethodName.equals(currentMethodName);
			}
			if (resumeIt || globalResumeTicket) { // start the resume
				globalResumeTicket = true;

				/**
				 * [tRunJob_1 begin ] start
				 */

				ok_Hash.put("tRunJob_1", false);
				start_Hash.put("tRunJob_1", System.currentTimeMillis());

				currentComponent = "tRunJob_1";

				int tos_count_tRunJob_1 = 0;

				if (log.isDebugEnabled())
					log.debug("tRunJob_1 - " + ("Start to work."));
				if (log.isDebugEnabled()) {
					class BytesLimit65535_tRunJob_1 {
						public void limitLog4jByte() throws Exception {
							StringBuilder log4jParamters_tRunJob_1 = new StringBuilder();
							log4jParamters_tRunJob_1.append("Parameters:");
							log4jParamters_tRunJob_1.append("USE_DYNAMIC_JOB" + " = " + "false");
							log4jParamters_tRunJob_1.append(" | ");
							log4jParamters_tRunJob_1.append("PROCESS" + " = " + "pre_job_log");
							log4jParamters_tRunJob_1.append(" | ");
							log4jParamters_tRunJob_1.append("USE_INDEPENDENT_PROCESS" + " = " + "false");
							log4jParamters_tRunJob_1.append(" | ");
							log4jParamters_tRunJob_1.append("DIE_ON_CHILD_ERROR" + " = " + "true");
							log4jParamters_tRunJob_1.append(" | ");
							log4jParamters_tRunJob_1.append("TRANSMIT_WHOLE_CONTEXT" + " = " + "false");
							log4jParamters_tRunJob_1.append(" | ");
							log4jParamters_tRunJob_1
									.append("CONTEXTPARAMS" + " = " + "[{PARAM_NAME_COLUMN=" + ("job_name")
											+ ", PARAM_VALUE_COLUMN=" + ("context.job_name") + "}, {PARAM_NAME_COLUMN="
											+ ("job_status") + ", PARAM_VALUE_COLUMN=" + ("\"Starting\"") + "}]");
							log4jParamters_tRunJob_1.append(" | ");
							log4jParamters_tRunJob_1.append("PROPAGATE_CHILD_RESULT" + " = " + "false");
							log4jParamters_tRunJob_1.append(" | ");
							log4jParamters_tRunJob_1.append("PRINT_PARAMETER" + " = " + "false");
							log4jParamters_tRunJob_1.append(" | ");
							log4jParamters_tRunJob_1.append("USE_DYNAMIC_CONTEXT" + " = " + "false");
							log4jParamters_tRunJob_1.append(" | ");
							if (log.isDebugEnabled())
								log.debug("tRunJob_1 - " + (log4jParamters_tRunJob_1));
						}
					}
					new BytesLimit65535_tRunJob_1().limitLog4jByte();
				}
				if (enableLogStash) {
					talendJobLog.addCM("tRunJob_1", "tRunJob_1", "tRunJob");
					talendJobLogProcess(globalMap);
				}

				/**
				 * [tRunJob_1 begin ] stop
				 */

				/**
				 * [tRunJob_1 main ] start
				 */

				currentComponent = "tRunJob_1";

				java.util.List<String> paraList_tRunJob_1 = new java.util.ArrayList<String>();

				paraList_tRunJob_1.add("--father_pid=" + pid);

				paraList_tRunJob_1.add("--root_pid=" + rootPid);

				paraList_tRunJob_1.add("--father_node=tRunJob_1");

				paraList_tRunJob_1.add("--context=Default");

				if (!"".equals(log4jLevel)) {
					paraList_tRunJob_1.add("--log4jLevel=" + log4jLevel);
				}

				if (enableLogStash) {
					paraList_tRunJob_1.add("--audit.enabled=" + enableLogStash);
				}

				// for feature:10589

				paraList_tRunJob_1.add("--stat_port=" + portStats);

				if (resuming_logs_dir_path != null) {
					paraList_tRunJob_1.add("--resuming_logs_dir_path=" + resuming_logs_dir_path);
				}
				String childResumePath_tRunJob_1 = ResumeUtil.getChildJobCheckPointPath(resuming_checkpoint_path);
				String tRunJobName_tRunJob_1 = ResumeUtil.getRighttRunJob(resuming_checkpoint_path);
				if ("tRunJob_1".equals(tRunJobName_tRunJob_1) && childResumePath_tRunJob_1 != null) {
					paraList_tRunJob_1.add("--resuming_checkpoint_path="
							+ ResumeUtil.getChildJobCheckPointPath(resuming_checkpoint_path));
				}
				paraList_tRunJob_1.add("--parent_part_launcher=JOB:" + jobName + "/NODE:tRunJob_1");

				java.util.Map<String, Object> parentContextMap_tRunJob_1 = new java.util.HashMap<String, Object>();

				Object obj_tRunJob_1 = null;

				obj_tRunJob_1 = context.job_name;
				if (obj_tRunJob_1 != null) {
					if (obj_tRunJob_1.getClass().getName().equals("java.util.Date")) {
						paraList_tRunJob_1
								.add("--context_param job_name=" + ((java.util.Date) obj_tRunJob_1).getTime());
					} else {
						paraList_tRunJob_1
								.add("--context_param job_name=" + RuntimeUtils.tRunJobConvertContext(obj_tRunJob_1));
					}
				} else {
					paraList_tRunJob_1.add(
							"--context_param job_name=" + NULL_VALUE_EXPRESSION_IN_COMMAND_STRING_FOR_CHILD_JOB_ONLY);
				}

				parentContextMap_tRunJob_1.put("job_name", obj_tRunJob_1);

				obj_tRunJob_1 = "Starting";
				if (obj_tRunJob_1 != null) {
					if (obj_tRunJob_1.getClass().getName().equals("java.util.Date")) {
						paraList_tRunJob_1
								.add("--context_param job_status=" + ((java.util.Date) obj_tRunJob_1).getTime());
					} else {
						paraList_tRunJob_1
								.add("--context_param job_status=" + RuntimeUtils.tRunJobConvertContext(obj_tRunJob_1));
					}
				} else {
					paraList_tRunJob_1.add(
							"--context_param job_status=" + NULL_VALUE_EXPRESSION_IN_COMMAND_STRING_FOR_CHILD_JOB_ONLY);
				}

				parentContextMap_tRunJob_1.put("job_status", obj_tRunJob_1);

				final_project.pre_job_log_0_1.pre_job_log childJob_tRunJob_1 = new final_project.pre_job_log_0_1.pre_job_log();
				// pass DataSources
				java.util.Map<String, routines.system.TalendDataSource> talendDataSources_tRunJob_1 = (java.util.Map<String, routines.system.TalendDataSource>) globalMap
						.get(KEY_DB_DATASOURCES);
				if (null != talendDataSources_tRunJob_1) {
					java.util.Map<String, javax.sql.DataSource> dataSources_tRunJob_1 = new java.util.HashMap<String, javax.sql.DataSource>();
					for (java.util.Map.Entry<String, routines.system.TalendDataSource> talendDataSourceEntry_tRunJob_1 : talendDataSources_tRunJob_1
							.entrySet()) {
						dataSources_tRunJob_1.put(talendDataSourceEntry_tRunJob_1.getKey(),
								talendDataSourceEntry_tRunJob_1.getValue().getRawDataSource());
					}
					childJob_tRunJob_1.setDataSources(dataSources_tRunJob_1);
				}

				childJob_tRunJob_1.parentContextMap = parentContextMap_tRunJob_1;

				log.info(
						"tRunJob_1 - The child job 'final_project.pre_job_log_0_1.pre_job_log' starts on the version '0.1' with the context 'Default'.");

				String[][] childReturn_tRunJob_1 = childJob_tRunJob_1
						.runJob((String[]) paraList_tRunJob_1.toArray(new String[paraList_tRunJob_1.size()]));

				log.info("tRunJob_1 - The child job 'final_project.pre_job_log_0_1.pre_job_log' is done.");

				if (childJob_tRunJob_1.getErrorCode() == null) {
					globalMap.put("tRunJob_1_CHILD_RETURN_CODE",
							childJob_tRunJob_1.getStatus() != null && ("failure").equals(childJob_tRunJob_1.getStatus())
									? 1
									: 0);
				} else {
					globalMap.put("tRunJob_1_CHILD_RETURN_CODE", childJob_tRunJob_1.getErrorCode());
				}
				if (childJob_tRunJob_1.getExceptionStackTrace() != null) {
					globalMap.put("tRunJob_1_CHILD_EXCEPTION_STACKTRACE", childJob_tRunJob_1.getExceptionStackTrace());
				}
				errorCode = childJob_tRunJob_1.getErrorCode();
				if (childJob_tRunJob_1.getErrorCode() != null || ("failure").equals(childJob_tRunJob_1.getStatus())) {
					java.lang.Exception ce_tRunJob_1 = childJob_tRunJob_1.getException();
					throw new RuntimeException("Child job running failed.\n" + ((ce_tRunJob_1 != null)
							? (ce_tRunJob_1.getClass().getName() + ": " + ce_tRunJob_1.getMessage())
							: ""));
				}

				tos_count_tRunJob_1++;

				/**
				 * [tRunJob_1 main ] stop
				 */

				/**
				 * [tRunJob_1 process_data_begin ] start
				 */

				currentComponent = "tRunJob_1";

				/**
				 * [tRunJob_1 process_data_begin ] stop
				 */

				/**
				 * [tRunJob_1 process_data_end ] start
				 */

				currentComponent = "tRunJob_1";

				/**
				 * [tRunJob_1 process_data_end ] stop
				 */

				/**
				 * [tRunJob_1 end ] start
				 */

				currentComponent = "tRunJob_1";

				if (log.isDebugEnabled())
					log.debug("tRunJob_1 - " + ("Done."));

				ok_Hash.put("tRunJob_1", true);
				end_Hash.put("tRunJob_1", System.currentTimeMillis());

				/**
				 * [tRunJob_1 end ] stop
				 */
			} // end the resume

		} catch (java.lang.Exception e) {

			if (!(e instanceof TalendException)) {
				log.fatal(currentComponent + " " + e.getMessage(), e);
			}

			TalendException te = new TalendException(e, currentComponent, cLabel, globalMap);

			throw te;
		} catch (java.lang.Error error) {

			runStat.stopThreadStat();

			throw error;
		} finally {

			try {

				/**
				 * [tRunJob_1 finally ] start
				 */

				currentComponent = "tRunJob_1";

				/**
				 * [tRunJob_1 finally ] stop
				 */
			} catch (java.lang.Exception e) {
				// ignore
			} catch (java.lang.Error error) {
				// ignore
			}
			resourceMap = null;
		}

		globalMap.put("tRunJob_1_SUBPROCESS_STATE", 1);
	}

	public void tRunJob_3Process(final java.util.Map<String, Object> globalMap) throws TalendException {
		globalMap.put("tRunJob_3_SUBPROCESS_STATE", 0);

		final boolean execStat = this.execStat;

		mdcInfo.forEach(org.slf4j.MDC::put);
		org.slf4j.MDC.put("_subJobName", "tRunJob_3");
		org.slf4j.MDC.put("_subJobPid", "JVH56n_" + subJobPidCounter.getAndIncrement());

		String iterateId = "";

		String currentComponent = "";
		String cLabel = null;
		java.util.Map<String, Object> resourceMap = new java.util.HashMap<String, Object>();

		try {
			// TDI-39566 avoid throwing an useless Exception
			boolean resumeIt = true;
			if (globalResumeTicket == false && resumeEntryMethodName != null) {
				String currentMethodName = new java.lang.Exception().getStackTrace()[0].getMethodName();
				resumeIt = resumeEntryMethodName.equals(currentMethodName);
			}
			if (resumeIt || globalResumeTicket) { // start the resume
				globalResumeTicket = true;

				/**
				 * [tRunJob_3 begin ] start
				 */

				ok_Hash.put("tRunJob_3", false);
				start_Hash.put("tRunJob_3", System.currentTimeMillis());

				currentComponent = "tRunJob_3";

				cLabel = "JSON Load";

				int tos_count_tRunJob_3 = 0;

				if (log.isDebugEnabled())
					log.debug("tRunJob_3 - " + ("Start to work."));
				if (log.isDebugEnabled()) {
					class BytesLimit65535_tRunJob_3 {
						public void limitLog4jByte() throws Exception {
							StringBuilder log4jParamters_tRunJob_3 = new StringBuilder();
							log4jParamters_tRunJob_3.append("Parameters:");
							log4jParamters_tRunJob_3.append("USE_DYNAMIC_JOB" + " = " + "false");
							log4jParamters_tRunJob_3.append(" | ");
							log4jParamters_tRunJob_3.append("PROCESS" + " = " + "json_staging_job");
							log4jParamters_tRunJob_3.append(" | ");
							log4jParamters_tRunJob_3.append("USE_INDEPENDENT_PROCESS" + " = " + "false");
							log4jParamters_tRunJob_3.append(" | ");
							log4jParamters_tRunJob_3.append("DIE_ON_CHILD_ERROR" + " = " + "true");
							log4jParamters_tRunJob_3.append(" | ");
							log4jParamters_tRunJob_3.append("TRANSMIT_WHOLE_CONTEXT" + " = " + "false");
							log4jParamters_tRunJob_3.append(" | ");
							log4jParamters_tRunJob_3.append("CONTEXTPARAMS" + " = " + "[{PARAM_NAME_COLUMN="
									+ ("job_name") + ", PARAM_VALUE_COLUMN=" + ("context.json_job") + "}]");
							log4jParamters_tRunJob_3.append(" | ");
							log4jParamters_tRunJob_3.append("PROPAGATE_CHILD_RESULT" + " = " + "false");
							log4jParamters_tRunJob_3.append(" | ");
							log4jParamters_tRunJob_3.append("PRINT_PARAMETER" + " = " + "false");
							log4jParamters_tRunJob_3.append(" | ");
							log4jParamters_tRunJob_3.append("USE_DYNAMIC_CONTEXT" + " = " + "false");
							log4jParamters_tRunJob_3.append(" | ");
							if (log.isDebugEnabled())
								log.debug("tRunJob_3 - " + (log4jParamters_tRunJob_3));
						}
					}
					new BytesLimit65535_tRunJob_3().limitLog4jByte();
				}
				if (enableLogStash) {
					talendJobLog.addCM("tRunJob_3", "JSON Load", "tRunJob");
					talendJobLogProcess(globalMap);
				}

				/**
				 * [tRunJob_3 begin ] stop
				 */

				/**
				 * [tRunJob_3 main ] start
				 */

				currentComponent = "tRunJob_3";

				cLabel = "JSON Load";

				java.util.List<String> paraList_tRunJob_3 = new java.util.ArrayList<String>();

				paraList_tRunJob_3.add("--father_pid=" + pid);

				paraList_tRunJob_3.add("--root_pid=" + rootPid);

				paraList_tRunJob_3.add("--father_node=tRunJob_3");

				paraList_tRunJob_3.add("--context=Default");

				if (!"".equals(log4jLevel)) {
					paraList_tRunJob_3.add("--log4jLevel=" + log4jLevel);
				}

				if (enableLogStash) {
					paraList_tRunJob_3.add("--audit.enabled=" + enableLogStash);
				}

				// for feature:10589

				paraList_tRunJob_3.add("--stat_port=" + portStats);

				if (resuming_logs_dir_path != null) {
					paraList_tRunJob_3.add("--resuming_logs_dir_path=" + resuming_logs_dir_path);
				}
				String childResumePath_tRunJob_3 = ResumeUtil.getChildJobCheckPointPath(resuming_checkpoint_path);
				String tRunJobName_tRunJob_3 = ResumeUtil.getRighttRunJob(resuming_checkpoint_path);
				if ("tRunJob_3".equals(tRunJobName_tRunJob_3) && childResumePath_tRunJob_3 != null) {
					paraList_tRunJob_3.add("--resuming_checkpoint_path="
							+ ResumeUtil.getChildJobCheckPointPath(resuming_checkpoint_path));
				}
				paraList_tRunJob_3.add("--parent_part_launcher=JOB:" + jobName + "/NODE:tRunJob_3");

				java.util.Map<String, Object> parentContextMap_tRunJob_3 = new java.util.HashMap<String, Object>();

				Object obj_tRunJob_3 = null;

				obj_tRunJob_3 = context.json_job;
				if (obj_tRunJob_3 != null) {
					if (obj_tRunJob_3.getClass().getName().equals("java.util.Date")) {
						paraList_tRunJob_3
								.add("--context_param job_name=" + ((java.util.Date) obj_tRunJob_3).getTime());
					} else {
						paraList_tRunJob_3
								.add("--context_param job_name=" + RuntimeUtils.tRunJobConvertContext(obj_tRunJob_3));
					}
				} else {
					paraList_tRunJob_3.add(
							"--context_param job_name=" + NULL_VALUE_EXPRESSION_IN_COMMAND_STRING_FOR_CHILD_JOB_ONLY);
				}

				parentContextMap_tRunJob_3.put("job_name", obj_tRunJob_3);

				final_project.json_staging_job_0_1.json_staging_job childJob_tRunJob_3 = new final_project.json_staging_job_0_1.json_staging_job();
				// pass DataSources
				java.util.Map<String, routines.system.TalendDataSource> talendDataSources_tRunJob_3 = (java.util.Map<String, routines.system.TalendDataSource>) globalMap
						.get(KEY_DB_DATASOURCES);
				if (null != talendDataSources_tRunJob_3) {
					java.util.Map<String, javax.sql.DataSource> dataSources_tRunJob_3 = new java.util.HashMap<String, javax.sql.DataSource>();
					for (java.util.Map.Entry<String, routines.system.TalendDataSource> talendDataSourceEntry_tRunJob_3 : talendDataSources_tRunJob_3
							.entrySet()) {
						dataSources_tRunJob_3.put(talendDataSourceEntry_tRunJob_3.getKey(),
								talendDataSourceEntry_tRunJob_3.getValue().getRawDataSource());
					}
					childJob_tRunJob_3.setDataSources(dataSources_tRunJob_3);
				}

				childJob_tRunJob_3.parentContextMap = parentContextMap_tRunJob_3;

				log.info(
						"tRunJob_3 - The child job 'final_project.json_staging_job_0_1.json_staging_job' starts on the version '0.1' with the context 'Default'.");

				String[][] childReturn_tRunJob_3 = childJob_tRunJob_3
						.runJob((String[]) paraList_tRunJob_3.toArray(new String[paraList_tRunJob_3.size()]));

				log.info("tRunJob_3 - The child job 'final_project.json_staging_job_0_1.json_staging_job' is done.");

				if (childJob_tRunJob_3.getErrorCode() == null) {
					globalMap.put("tRunJob_3_CHILD_RETURN_CODE",
							childJob_tRunJob_3.getStatus() != null && ("failure").equals(childJob_tRunJob_3.getStatus())
									? 1
									: 0);
				} else {
					globalMap.put("tRunJob_3_CHILD_RETURN_CODE", childJob_tRunJob_3.getErrorCode());
				}
				if (childJob_tRunJob_3.getExceptionStackTrace() != null) {
					globalMap.put("tRunJob_3_CHILD_EXCEPTION_STACKTRACE", childJob_tRunJob_3.getExceptionStackTrace());
				}
				errorCode = childJob_tRunJob_3.getErrorCode();
				if (childJob_tRunJob_3.getErrorCode() != null || ("failure").equals(childJob_tRunJob_3.getStatus())) {
					java.lang.Exception ce_tRunJob_3 = childJob_tRunJob_3.getException();
					throw new RuntimeException("Child job running failed.\n" + ((ce_tRunJob_3 != null)
							? (ce_tRunJob_3.getClass().getName() + ": " + ce_tRunJob_3.getMessage())
							: ""));
				}

				tos_count_tRunJob_3++;

				/**
				 * [tRunJob_3 main ] stop
				 */

				/**
				 * [tRunJob_3 process_data_begin ] start
				 */

				currentComponent = "tRunJob_3";

				cLabel = "JSON Load";

				/**
				 * [tRunJob_3 process_data_begin ] stop
				 */

				/**
				 * [tRunJob_3 process_data_end ] start
				 */

				currentComponent = "tRunJob_3";

				cLabel = "JSON Load";

				/**
				 * [tRunJob_3 process_data_end ] stop
				 */

				/**
				 * [tRunJob_3 end ] start
				 */

				currentComponent = "tRunJob_3";

				cLabel = "JSON Load";

				if (log.isDebugEnabled())
					log.debug("tRunJob_3 - " + ("Done."));

				ok_Hash.put("tRunJob_3", true);
				end_Hash.put("tRunJob_3", System.currentTimeMillis());

				/**
				 * [tRunJob_3 end ] stop
				 */
			} // end the resume

			if (resumeEntryMethodName == null || globalResumeTicket) {
				resumeUtil.addLog("CHECKPOINT", "CONNECTION:SUBJOB_OK:tRunJob_3:OnSubjobOk", "",
						Thread.currentThread().getId() + "", "", "", "", "", "");
			}

			if (execStat) {
				runStat.updateStatOnConnection("OnSubjobOk1", 0, "ok");
			}

			tRunJob_4Process(globalMap);

		} catch (java.lang.Exception e) {

			if (!(e instanceof TalendException)) {
				log.fatal(currentComponent + " " + e.getMessage(), e);
			}

			TalendException te = new TalendException(e, currentComponent, cLabel, globalMap);

			throw te;
		} catch (java.lang.Error error) {

			runStat.stopThreadStat();

			throw error;
		} finally {

			try {

				/**
				 * [tRunJob_3 finally ] start
				 */

				currentComponent = "tRunJob_3";

				cLabel = "JSON Load";

				/**
				 * [tRunJob_3 finally ] stop
				 */
			} catch (java.lang.Exception e) {
				// ignore
			} catch (java.lang.Error error) {
				// ignore
			}
			resourceMap = null;
		}

		globalMap.put("tRunJob_3_SUBPROCESS_STATE", 1);
	}

	public void tRunJob_4Process(final java.util.Map<String, Object> globalMap) throws TalendException {
		globalMap.put("tRunJob_4_SUBPROCESS_STATE", 0);

		final boolean execStat = this.execStat;

		mdcInfo.forEach(org.slf4j.MDC::put);
		org.slf4j.MDC.put("_subJobName", "tRunJob_4");
		org.slf4j.MDC.put("_subJobPid", "42du4C_" + subJobPidCounter.getAndIncrement());

		String iterateId = "";

		String currentComponent = "";
		String cLabel = null;
		java.util.Map<String, Object> resourceMap = new java.util.HashMap<String, Object>();

		try {
			// TDI-39566 avoid throwing an useless Exception
			boolean resumeIt = true;
			if (globalResumeTicket == false && resumeEntryMethodName != null) {
				String currentMethodName = new java.lang.Exception().getStackTrace()[0].getMethodName();
				resumeIt = resumeEntryMethodName.equals(currentMethodName);
			}
			if (resumeIt || globalResumeTicket) { // start the resume
				globalResumeTicket = true;

				/**
				 * [tRunJob_4 begin ] start
				 */

				ok_Hash.put("tRunJob_4", false);
				start_Hash.put("tRunJob_4", System.currentTimeMillis());

				currentComponent = "tRunJob_4";

				cLabel = "TSV Load";

				int tos_count_tRunJob_4 = 0;

				if (log.isDebugEnabled())
					log.debug("tRunJob_4 - " + ("Start to work."));
				if (log.isDebugEnabled()) {
					class BytesLimit65535_tRunJob_4 {
						public void limitLog4jByte() throws Exception {
							StringBuilder log4jParamters_tRunJob_4 = new StringBuilder();
							log4jParamters_tRunJob_4.append("Parameters:");
							log4jParamters_tRunJob_4.append("USE_DYNAMIC_JOB" + " = " + "false");
							log4jParamters_tRunJob_4.append(" | ");
							log4jParamters_tRunJob_4.append("PROCESS" + " = " + "tsv_staging_job");
							log4jParamters_tRunJob_4.append(" | ");
							log4jParamters_tRunJob_4.append("USE_INDEPENDENT_PROCESS" + " = " + "false");
							log4jParamters_tRunJob_4.append(" | ");
							log4jParamters_tRunJob_4.append("DIE_ON_CHILD_ERROR" + " = " + "true");
							log4jParamters_tRunJob_4.append(" | ");
							log4jParamters_tRunJob_4.append("TRANSMIT_WHOLE_CONTEXT" + " = " + "false");
							log4jParamters_tRunJob_4.append(" | ");
							log4jParamters_tRunJob_4.append("CONTEXTPARAMS" + " = " + "[{PARAM_NAME_COLUMN="
									+ ("job_name") + ", PARAM_VALUE_COLUMN=" + ("context.tsv_job") + "}]");
							log4jParamters_tRunJob_4.append(" | ");
							log4jParamters_tRunJob_4.append("PROPAGATE_CHILD_RESULT" + " = " + "false");
							log4jParamters_tRunJob_4.append(" | ");
							log4jParamters_tRunJob_4.append("PRINT_PARAMETER" + " = " + "false");
							log4jParamters_tRunJob_4.append(" | ");
							log4jParamters_tRunJob_4.append("USE_DYNAMIC_CONTEXT" + " = " + "false");
							log4jParamters_tRunJob_4.append(" | ");
							if (log.isDebugEnabled())
								log.debug("tRunJob_4 - " + (log4jParamters_tRunJob_4));
						}
					}
					new BytesLimit65535_tRunJob_4().limitLog4jByte();
				}
				if (enableLogStash) {
					talendJobLog.addCM("tRunJob_4", "TSV Load", "tRunJob");
					talendJobLogProcess(globalMap);
				}

				/**
				 * [tRunJob_4 begin ] stop
				 */

				/**
				 * [tRunJob_4 main ] start
				 */

				currentComponent = "tRunJob_4";

				cLabel = "TSV Load";

				java.util.List<String> paraList_tRunJob_4 = new java.util.ArrayList<String>();

				paraList_tRunJob_4.add("--father_pid=" + pid);

				paraList_tRunJob_4.add("--root_pid=" + rootPid);

				paraList_tRunJob_4.add("--father_node=tRunJob_4");

				paraList_tRunJob_4.add("--context=Default");

				if (!"".equals(log4jLevel)) {
					paraList_tRunJob_4.add("--log4jLevel=" + log4jLevel);
				}

				if (enableLogStash) {
					paraList_tRunJob_4.add("--audit.enabled=" + enableLogStash);
				}

				// for feature:10589

				paraList_tRunJob_4.add("--stat_port=" + portStats);

				if (resuming_logs_dir_path != null) {
					paraList_tRunJob_4.add("--resuming_logs_dir_path=" + resuming_logs_dir_path);
				}
				String childResumePath_tRunJob_4 = ResumeUtil.getChildJobCheckPointPath(resuming_checkpoint_path);
				String tRunJobName_tRunJob_4 = ResumeUtil.getRighttRunJob(resuming_checkpoint_path);
				if ("tRunJob_4".equals(tRunJobName_tRunJob_4) && childResumePath_tRunJob_4 != null) {
					paraList_tRunJob_4.add("--resuming_checkpoint_path="
							+ ResumeUtil.getChildJobCheckPointPath(resuming_checkpoint_path));
				}
				paraList_tRunJob_4.add("--parent_part_launcher=JOB:" + jobName + "/NODE:tRunJob_4");

				java.util.Map<String, Object> parentContextMap_tRunJob_4 = new java.util.HashMap<String, Object>();

				Object obj_tRunJob_4 = null;

				obj_tRunJob_4 = context.tsv_job;
				if (obj_tRunJob_4 != null) {
					if (obj_tRunJob_4.getClass().getName().equals("java.util.Date")) {
						paraList_tRunJob_4
								.add("--context_param job_name=" + ((java.util.Date) obj_tRunJob_4).getTime());
					} else {
						paraList_tRunJob_4
								.add("--context_param job_name=" + RuntimeUtils.tRunJobConvertContext(obj_tRunJob_4));
					}
				} else {
					paraList_tRunJob_4.add(
							"--context_param job_name=" + NULL_VALUE_EXPRESSION_IN_COMMAND_STRING_FOR_CHILD_JOB_ONLY);
				}

				parentContextMap_tRunJob_4.put("job_name", obj_tRunJob_4);

				final_project.tsv_staging_job_0_1.tsv_staging_job childJob_tRunJob_4 = new final_project.tsv_staging_job_0_1.tsv_staging_job();
				// pass DataSources
				java.util.Map<String, routines.system.TalendDataSource> talendDataSources_tRunJob_4 = (java.util.Map<String, routines.system.TalendDataSource>) globalMap
						.get(KEY_DB_DATASOURCES);
				if (null != talendDataSources_tRunJob_4) {
					java.util.Map<String, javax.sql.DataSource> dataSources_tRunJob_4 = new java.util.HashMap<String, javax.sql.DataSource>();
					for (java.util.Map.Entry<String, routines.system.TalendDataSource> talendDataSourceEntry_tRunJob_4 : talendDataSources_tRunJob_4
							.entrySet()) {
						dataSources_tRunJob_4.put(talendDataSourceEntry_tRunJob_4.getKey(),
								talendDataSourceEntry_tRunJob_4.getValue().getRawDataSource());
					}
					childJob_tRunJob_4.setDataSources(dataSources_tRunJob_4);
				}

				childJob_tRunJob_4.parentContextMap = parentContextMap_tRunJob_4;

				log.info(
						"tRunJob_4 - The child job 'final_project.tsv_staging_job_0_1.tsv_staging_job' starts on the version '0.1' with the context 'Default'.");

				String[][] childReturn_tRunJob_4 = childJob_tRunJob_4
						.runJob((String[]) paraList_tRunJob_4.toArray(new String[paraList_tRunJob_4.size()]));

				log.info("tRunJob_4 - The child job 'final_project.tsv_staging_job_0_1.tsv_staging_job' is done.");

				if (childJob_tRunJob_4.getErrorCode() == null) {
					globalMap.put("tRunJob_4_CHILD_RETURN_CODE",
							childJob_tRunJob_4.getStatus() != null && ("failure").equals(childJob_tRunJob_4.getStatus())
									? 1
									: 0);
				} else {
					globalMap.put("tRunJob_4_CHILD_RETURN_CODE", childJob_tRunJob_4.getErrorCode());
				}
				if (childJob_tRunJob_4.getExceptionStackTrace() != null) {
					globalMap.put("tRunJob_4_CHILD_EXCEPTION_STACKTRACE", childJob_tRunJob_4.getExceptionStackTrace());
				}
				errorCode = childJob_tRunJob_4.getErrorCode();
				if (childJob_tRunJob_4.getErrorCode() != null || ("failure").equals(childJob_tRunJob_4.getStatus())) {
					java.lang.Exception ce_tRunJob_4 = childJob_tRunJob_4.getException();
					throw new RuntimeException("Child job running failed.\n" + ((ce_tRunJob_4 != null)
							? (ce_tRunJob_4.getClass().getName() + ": " + ce_tRunJob_4.getMessage())
							: ""));
				}

				tos_count_tRunJob_4++;

				/**
				 * [tRunJob_4 main ] stop
				 */

				/**
				 * [tRunJob_4 process_data_begin ] start
				 */

				currentComponent = "tRunJob_4";

				cLabel = "TSV Load";

				/**
				 * [tRunJob_4 process_data_begin ] stop
				 */

				/**
				 * [tRunJob_4 process_data_end ] start
				 */

				currentComponent = "tRunJob_4";

				cLabel = "TSV Load";

				/**
				 * [tRunJob_4 process_data_end ] stop
				 */

				/**
				 * [tRunJob_4 end ] start
				 */

				currentComponent = "tRunJob_4";

				cLabel = "TSV Load";

				if (log.isDebugEnabled())
					log.debug("tRunJob_4 - " + ("Done."));

				ok_Hash.put("tRunJob_4", true);
				end_Hash.put("tRunJob_4", System.currentTimeMillis());

				/**
				 * [tRunJob_4 end ] stop
				 */
			} // end the resume

			if (resumeEntryMethodName == null || globalResumeTicket) {
				resumeUtil.addLog("CHECKPOINT", "CONNECTION:SUBJOB_OK:tRunJob_4:OnSubjobOk", "",
						Thread.currentThread().getId() + "", "", "", "", "", "");
			}

			if (execStat) {
				runStat.updateStatOnConnection("OnSubjobOk2", 0, "ok");
			}

			tRunJob_5Process(globalMap);

		} catch (java.lang.Exception e) {

			if (!(e instanceof TalendException)) {
				log.fatal(currentComponent + " " + e.getMessage(), e);
			}

			TalendException te = new TalendException(e, currentComponent, cLabel, globalMap);

			throw te;
		} catch (java.lang.Error error) {

			runStat.stopThreadStat();

			throw error;
		} finally {

			try {

				/**
				 * [tRunJob_4 finally ] start
				 */

				currentComponent = "tRunJob_4";

				cLabel = "TSV Load";

				/**
				 * [tRunJob_4 finally ] stop
				 */
			} catch (java.lang.Exception e) {
				// ignore
			} catch (java.lang.Error error) {
				// ignore
			}
			resourceMap = null;
		}

		globalMap.put("tRunJob_4_SUBPROCESS_STATE", 1);
	}

	public void tRunJob_5Process(final java.util.Map<String, Object> globalMap) throws TalendException {
		globalMap.put("tRunJob_5_SUBPROCESS_STATE", 0);

		final boolean execStat = this.execStat;

		mdcInfo.forEach(org.slf4j.MDC::put);
		org.slf4j.MDC.put("_subJobName", "tRunJob_5");
		org.slf4j.MDC.put("_subJobPid", "9csVuz_" + subJobPidCounter.getAndIncrement());

		String iterateId = "";

		String currentComponent = "";
		String cLabel = null;
		java.util.Map<String, Object> resourceMap = new java.util.HashMap<String, Object>();

		try {
			// TDI-39566 avoid throwing an useless Exception
			boolean resumeIt = true;
			if (globalResumeTicket == false && resumeEntryMethodName != null) {
				String currentMethodName = new java.lang.Exception().getStackTrace()[0].getMethodName();
				resumeIt = resumeEntryMethodName.equals(currentMethodName);
			}
			if (resumeIt || globalResumeTicket) { // start the resume
				globalResumeTicket = true;

				/**
				 * [tRunJob_5 begin ] start
				 */

				ok_Hash.put("tRunJob_5", false);
				start_Hash.put("tRunJob_5", System.currentTimeMillis());

				currentComponent = "tRunJob_5";

				cLabel = "SQL Load";

				int tos_count_tRunJob_5 = 0;

				if (log.isDebugEnabled())
					log.debug("tRunJob_5 - " + ("Start to work."));
				if (log.isDebugEnabled()) {
					class BytesLimit65535_tRunJob_5 {
						public void limitLog4jByte() throws Exception {
							StringBuilder log4jParamters_tRunJob_5 = new StringBuilder();
							log4jParamters_tRunJob_5.append("Parameters:");
							log4jParamters_tRunJob_5.append("USE_DYNAMIC_JOB" + " = " + "false");
							log4jParamters_tRunJob_5.append(" | ");
							log4jParamters_tRunJob_5.append("PROCESS" + " = " + "sql_staging_job");
							log4jParamters_tRunJob_5.append(" | ");
							log4jParamters_tRunJob_5.append("USE_INDEPENDENT_PROCESS" + " = " + "false");
							log4jParamters_tRunJob_5.append(" | ");
							log4jParamters_tRunJob_5.append("DIE_ON_CHILD_ERROR" + " = " + "true");
							log4jParamters_tRunJob_5.append(" | ");
							log4jParamters_tRunJob_5.append("TRANSMIT_WHOLE_CONTEXT" + " = " + "false");
							log4jParamters_tRunJob_5.append(" | ");
							log4jParamters_tRunJob_5.append("CONTEXTPARAMS" + " = " + "[{PARAM_NAME_COLUMN="
									+ ("job_name") + ", PARAM_VALUE_COLUMN=" + ("context.sql_job") + "}]");
							log4jParamters_tRunJob_5.append(" | ");
							log4jParamters_tRunJob_5.append("PROPAGATE_CHILD_RESULT" + " = " + "false");
							log4jParamters_tRunJob_5.append(" | ");
							log4jParamters_tRunJob_5.append("PRINT_PARAMETER" + " = " + "false");
							log4jParamters_tRunJob_5.append(" | ");
							log4jParamters_tRunJob_5.append("USE_DYNAMIC_CONTEXT" + " = " + "false");
							log4jParamters_tRunJob_5.append(" | ");
							if (log.isDebugEnabled())
								log.debug("tRunJob_5 - " + (log4jParamters_tRunJob_5));
						}
					}
					new BytesLimit65535_tRunJob_5().limitLog4jByte();
				}
				if (enableLogStash) {
					talendJobLog.addCM("tRunJob_5", "SQL Load", "tRunJob");
					talendJobLogProcess(globalMap);
				}

				/**
				 * [tRunJob_5 begin ] stop
				 */

				/**
				 * [tRunJob_5 main ] start
				 */

				currentComponent = "tRunJob_5";

				cLabel = "SQL Load";

				java.util.List<String> paraList_tRunJob_5 = new java.util.ArrayList<String>();

				paraList_tRunJob_5.add("--father_pid=" + pid);

				paraList_tRunJob_5.add("--root_pid=" + rootPid);

				paraList_tRunJob_5.add("--father_node=tRunJob_5");

				paraList_tRunJob_5.add("--context=Default");

				if (!"".equals(log4jLevel)) {
					paraList_tRunJob_5.add("--log4jLevel=" + log4jLevel);
				}

				if (enableLogStash) {
					paraList_tRunJob_5.add("--audit.enabled=" + enableLogStash);
				}

				// for feature:10589

				paraList_tRunJob_5.add("--stat_port=" + portStats);

				if (resuming_logs_dir_path != null) {
					paraList_tRunJob_5.add("--resuming_logs_dir_path=" + resuming_logs_dir_path);
				}
				String childResumePath_tRunJob_5 = ResumeUtil.getChildJobCheckPointPath(resuming_checkpoint_path);
				String tRunJobName_tRunJob_5 = ResumeUtil.getRighttRunJob(resuming_checkpoint_path);
				if ("tRunJob_5".equals(tRunJobName_tRunJob_5) && childResumePath_tRunJob_5 != null) {
					paraList_tRunJob_5.add("--resuming_checkpoint_path="
							+ ResumeUtil.getChildJobCheckPointPath(resuming_checkpoint_path));
				}
				paraList_tRunJob_5.add("--parent_part_launcher=JOB:" + jobName + "/NODE:tRunJob_5");

				java.util.Map<String, Object> parentContextMap_tRunJob_5 = new java.util.HashMap<String, Object>();

				Object obj_tRunJob_5 = null;

				obj_tRunJob_5 = context.sql_job;
				if (obj_tRunJob_5 != null) {
					if (obj_tRunJob_5.getClass().getName().equals("java.util.Date")) {
						paraList_tRunJob_5
								.add("--context_param job_name=" + ((java.util.Date) obj_tRunJob_5).getTime());
					} else {
						paraList_tRunJob_5
								.add("--context_param job_name=" + RuntimeUtils.tRunJobConvertContext(obj_tRunJob_5));
					}
				} else {
					paraList_tRunJob_5.add(
							"--context_param job_name=" + NULL_VALUE_EXPRESSION_IN_COMMAND_STRING_FOR_CHILD_JOB_ONLY);
				}

				parentContextMap_tRunJob_5.put("job_name", obj_tRunJob_5);

				final_project.sql_staging_job_0_1.sql_staging_job childJob_tRunJob_5 = new final_project.sql_staging_job_0_1.sql_staging_job();
				// pass DataSources
				java.util.Map<String, routines.system.TalendDataSource> talendDataSources_tRunJob_5 = (java.util.Map<String, routines.system.TalendDataSource>) globalMap
						.get(KEY_DB_DATASOURCES);
				if (null != talendDataSources_tRunJob_5) {
					java.util.Map<String, javax.sql.DataSource> dataSources_tRunJob_5 = new java.util.HashMap<String, javax.sql.DataSource>();
					for (java.util.Map.Entry<String, routines.system.TalendDataSource> talendDataSourceEntry_tRunJob_5 : talendDataSources_tRunJob_5
							.entrySet()) {
						dataSources_tRunJob_5.put(talendDataSourceEntry_tRunJob_5.getKey(),
								talendDataSourceEntry_tRunJob_5.getValue().getRawDataSource());
					}
					childJob_tRunJob_5.setDataSources(dataSources_tRunJob_5);
				}

				childJob_tRunJob_5.parentContextMap = parentContextMap_tRunJob_5;

				log.info(
						"tRunJob_5 - The child job 'final_project.sql_staging_job_0_1.sql_staging_job' starts on the version '0.1' with the context 'Default'.");

				String[][] childReturn_tRunJob_5 = childJob_tRunJob_5
						.runJob((String[]) paraList_tRunJob_5.toArray(new String[paraList_tRunJob_5.size()]));

				log.info("tRunJob_5 - The child job 'final_project.sql_staging_job_0_1.sql_staging_job' is done.");

				if (childJob_tRunJob_5.getErrorCode() == null) {
					globalMap.put("tRunJob_5_CHILD_RETURN_CODE",
							childJob_tRunJob_5.getStatus() != null && ("failure").equals(childJob_tRunJob_5.getStatus())
									? 1
									: 0);
				} else {
					globalMap.put("tRunJob_5_CHILD_RETURN_CODE", childJob_tRunJob_5.getErrorCode());
				}
				if (childJob_tRunJob_5.getExceptionStackTrace() != null) {
					globalMap.put("tRunJob_5_CHILD_EXCEPTION_STACKTRACE", childJob_tRunJob_5.getExceptionStackTrace());
				}
				errorCode = childJob_tRunJob_5.getErrorCode();
				if (childJob_tRunJob_5.getErrorCode() != null || ("failure").equals(childJob_tRunJob_5.getStatus())) {
					java.lang.Exception ce_tRunJob_5 = childJob_tRunJob_5.getException();
					throw new RuntimeException("Child job running failed.\n" + ((ce_tRunJob_5 != null)
							? (ce_tRunJob_5.getClass().getName() + ": " + ce_tRunJob_5.getMessage())
							: ""));
				}

				tos_count_tRunJob_5++;

				/**
				 * [tRunJob_5 main ] stop
				 */

				/**
				 * [tRunJob_5 process_data_begin ] start
				 */

				currentComponent = "tRunJob_5";

				cLabel = "SQL Load";

				/**
				 * [tRunJob_5 process_data_begin ] stop
				 */

				/**
				 * [tRunJob_5 process_data_end ] start
				 */

				currentComponent = "tRunJob_5";

				cLabel = "SQL Load";

				/**
				 * [tRunJob_5 process_data_end ] stop
				 */

				/**
				 * [tRunJob_5 end ] start
				 */

				currentComponent = "tRunJob_5";

				cLabel = "SQL Load";

				if (log.isDebugEnabled())
					log.debug("tRunJob_5 - " + ("Done."));

				ok_Hash.put("tRunJob_5", true);
				end_Hash.put("tRunJob_5", System.currentTimeMillis());

				/**
				 * [tRunJob_5 end ] stop
				 */
			} // end the resume

			if (resumeEntryMethodName == null || globalResumeTicket) {
				resumeUtil.addLog("CHECKPOINT", "CONNECTION:SUBJOB_OK:tRunJob_5:OnSubjobOk", "",
						Thread.currentThread().getId() + "", "", "", "", "", "");
			}

			if (execStat) {
				runStat.updateStatOnConnection("OnSubjobOk3", 0, "ok");
			}

			tRunJob_7Process(globalMap);

		} catch (java.lang.Exception e) {

			if (!(e instanceof TalendException)) {
				log.fatal(currentComponent + " " + e.getMessage(), e);
			}

			TalendException te = new TalendException(e, currentComponent, cLabel, globalMap);

			throw te;
		} catch (java.lang.Error error) {

			runStat.stopThreadStat();

			throw error;
		} finally {

			try {

				/**
				 * [tRunJob_5 finally ] start
				 */

				currentComponent = "tRunJob_5";

				cLabel = "SQL Load";

				/**
				 * [tRunJob_5 finally ] stop
				 */
			} catch (java.lang.Exception e) {
				// ignore
			} catch (java.lang.Error error) {
				// ignore
			}
			resourceMap = null;
		}

		globalMap.put("tRunJob_5_SUBPROCESS_STATE", 1);
	}

	public void tRunJob_6Process(final java.util.Map<String, Object> globalMap) throws TalendException {
		globalMap.put("tRunJob_6_SUBPROCESS_STATE", 0);

		final boolean execStat = this.execStat;

		mdcInfo.forEach(org.slf4j.MDC::put);
		org.slf4j.MDC.put("_subJobName", "tRunJob_6");
		org.slf4j.MDC.put("_subJobPid", "v9hIJ7_" + subJobPidCounter.getAndIncrement());

		String iterateId = "";

		String currentComponent = "";
		String cLabel = null;
		java.util.Map<String, Object> resourceMap = new java.util.HashMap<String, Object>();

		try {
			// TDI-39566 avoid throwing an useless Exception
			boolean resumeIt = true;
			if (globalResumeTicket == false && resumeEntryMethodName != null) {
				String currentMethodName = new java.lang.Exception().getStackTrace()[0].getMethodName();
				resumeIt = resumeEntryMethodName.equals(currentMethodName);
			}
			if (resumeIt || globalResumeTicket) { // start the resume
				globalResumeTicket = true;

				/**
				 * [tRunJob_6 begin ] start
				 */

				ok_Hash.put("tRunJob_6", false);
				start_Hash.put("tRunJob_6", System.currentTimeMillis());

				currentComponent = "tRunJob_6";

				int tos_count_tRunJob_6 = 0;

				if (log.isDebugEnabled())
					log.debug("tRunJob_6 - " + ("Start to work."));
				if (log.isDebugEnabled()) {
					class BytesLimit65535_tRunJob_6 {
						public void limitLog4jByte() throws Exception {
							StringBuilder log4jParamters_tRunJob_6 = new StringBuilder();
							log4jParamters_tRunJob_6.append("Parameters:");
							log4jParamters_tRunJob_6.append("USE_DYNAMIC_JOB" + " = " + "false");
							log4jParamters_tRunJob_6.append(" | ");
							log4jParamters_tRunJob_6.append("PROCESS" + " = " + "pre_job_log");
							log4jParamters_tRunJob_6.append(" | ");
							log4jParamters_tRunJob_6.append("USE_INDEPENDENT_PROCESS" + " = " + "false");
							log4jParamters_tRunJob_6.append(" | ");
							log4jParamters_tRunJob_6.append("DIE_ON_CHILD_ERROR" + " = " + "true");
							log4jParamters_tRunJob_6.append(" | ");
							log4jParamters_tRunJob_6.append("TRANSMIT_WHOLE_CONTEXT" + " = " + "false");
							log4jParamters_tRunJob_6.append(" | ");
							log4jParamters_tRunJob_6
									.append("CONTEXTPARAMS" + " = " + "[{PARAM_NAME_COLUMN=" + ("job_name")
											+ ", PARAM_VALUE_COLUMN=" + ("context.sql_job") + "}, {PARAM_NAME_COLUMN="
											+ ("job_status") + ", PARAM_VALUE_COLUMN=" + ("\"Error\"") + "}]");
							log4jParamters_tRunJob_6.append(" | ");
							log4jParamters_tRunJob_6.append("PROPAGATE_CHILD_RESULT" + " = " + "false");
							log4jParamters_tRunJob_6.append(" | ");
							log4jParamters_tRunJob_6.append("PRINT_PARAMETER" + " = " + "false");
							log4jParamters_tRunJob_6.append(" | ");
							log4jParamters_tRunJob_6.append("USE_DYNAMIC_CONTEXT" + " = " + "false");
							log4jParamters_tRunJob_6.append(" | ");
							if (log.isDebugEnabled())
								log.debug("tRunJob_6 - " + (log4jParamters_tRunJob_6));
						}
					}
					new BytesLimit65535_tRunJob_6().limitLog4jByte();
				}
				if (enableLogStash) {
					talendJobLog.addCM("tRunJob_6", "tRunJob_6", "tRunJob");
					talendJobLogProcess(globalMap);
				}

				/**
				 * [tRunJob_6 begin ] stop
				 */

				/**
				 * [tRunJob_6 main ] start
				 */

				currentComponent = "tRunJob_6";

				java.util.List<String> paraList_tRunJob_6 = new java.util.ArrayList<String>();

				paraList_tRunJob_6.add("--father_pid=" + pid);

				paraList_tRunJob_6.add("--root_pid=" + rootPid);

				paraList_tRunJob_6.add("--father_node=tRunJob_6");

				paraList_tRunJob_6.add("--context=Default");

				if (!"".equals(log4jLevel)) {
					paraList_tRunJob_6.add("--log4jLevel=" + log4jLevel);
				}

				if (enableLogStash) {
					paraList_tRunJob_6.add("--audit.enabled=" + enableLogStash);
				}

				// for feature:10589

				paraList_tRunJob_6.add("--stat_port=" + portStats);

				if (resuming_logs_dir_path != null) {
					paraList_tRunJob_6.add("--resuming_logs_dir_path=" + resuming_logs_dir_path);
				}
				String childResumePath_tRunJob_6 = ResumeUtil.getChildJobCheckPointPath(resuming_checkpoint_path);
				String tRunJobName_tRunJob_6 = ResumeUtil.getRighttRunJob(resuming_checkpoint_path);
				if ("tRunJob_6".equals(tRunJobName_tRunJob_6) && childResumePath_tRunJob_6 != null) {
					paraList_tRunJob_6.add("--resuming_checkpoint_path="
							+ ResumeUtil.getChildJobCheckPointPath(resuming_checkpoint_path));
				}
				paraList_tRunJob_6.add("--parent_part_launcher=JOB:" + jobName + "/NODE:tRunJob_6");

				java.util.Map<String, Object> parentContextMap_tRunJob_6 = new java.util.HashMap<String, Object>();

				Object obj_tRunJob_6 = null;

				obj_tRunJob_6 = context.sql_job;
				if (obj_tRunJob_6 != null) {
					if (obj_tRunJob_6.getClass().getName().equals("java.util.Date")) {
						paraList_tRunJob_6
								.add("--context_param job_name=" + ((java.util.Date) obj_tRunJob_6).getTime());
					} else {
						paraList_tRunJob_6
								.add("--context_param job_name=" + RuntimeUtils.tRunJobConvertContext(obj_tRunJob_6));
					}
				} else {
					paraList_tRunJob_6.add(
							"--context_param job_name=" + NULL_VALUE_EXPRESSION_IN_COMMAND_STRING_FOR_CHILD_JOB_ONLY);
				}

				parentContextMap_tRunJob_6.put("job_name", obj_tRunJob_6);

				obj_tRunJob_6 = "Error";
				if (obj_tRunJob_6 != null) {
					if (obj_tRunJob_6.getClass().getName().equals("java.util.Date")) {
						paraList_tRunJob_6
								.add("--context_param job_status=" + ((java.util.Date) obj_tRunJob_6).getTime());
					} else {
						paraList_tRunJob_6
								.add("--context_param job_status=" + RuntimeUtils.tRunJobConvertContext(obj_tRunJob_6));
					}
				} else {
					paraList_tRunJob_6.add(
							"--context_param job_status=" + NULL_VALUE_EXPRESSION_IN_COMMAND_STRING_FOR_CHILD_JOB_ONLY);
				}

				parentContextMap_tRunJob_6.put("job_status", obj_tRunJob_6);

				final_project.pre_job_log_0_1.pre_job_log childJob_tRunJob_6 = new final_project.pre_job_log_0_1.pre_job_log();
				// pass DataSources
				java.util.Map<String, routines.system.TalendDataSource> talendDataSources_tRunJob_6 = (java.util.Map<String, routines.system.TalendDataSource>) globalMap
						.get(KEY_DB_DATASOURCES);
				if (null != talendDataSources_tRunJob_6) {
					java.util.Map<String, javax.sql.DataSource> dataSources_tRunJob_6 = new java.util.HashMap<String, javax.sql.DataSource>();
					for (java.util.Map.Entry<String, routines.system.TalendDataSource> talendDataSourceEntry_tRunJob_6 : talendDataSources_tRunJob_6
							.entrySet()) {
						dataSources_tRunJob_6.put(talendDataSourceEntry_tRunJob_6.getKey(),
								talendDataSourceEntry_tRunJob_6.getValue().getRawDataSource());
					}
					childJob_tRunJob_6.setDataSources(dataSources_tRunJob_6);
				}

				childJob_tRunJob_6.parentContextMap = parentContextMap_tRunJob_6;

				log.info(
						"tRunJob_6 - The child job 'final_project.pre_job_log_0_1.pre_job_log' starts on the version '0.1' with the context 'Default'.");

				String[][] childReturn_tRunJob_6 = childJob_tRunJob_6
						.runJob((String[]) paraList_tRunJob_6.toArray(new String[paraList_tRunJob_6.size()]));

				log.info("tRunJob_6 - The child job 'final_project.pre_job_log_0_1.pre_job_log' is done.");

				if (childJob_tRunJob_6.getErrorCode() == null) {
					globalMap.put("tRunJob_6_CHILD_RETURN_CODE",
							childJob_tRunJob_6.getStatus() != null && ("failure").equals(childJob_tRunJob_6.getStatus())
									? 1
									: 0);
				} else {
					globalMap.put("tRunJob_6_CHILD_RETURN_CODE", childJob_tRunJob_6.getErrorCode());
				}
				if (childJob_tRunJob_6.getExceptionStackTrace() != null) {
					globalMap.put("tRunJob_6_CHILD_EXCEPTION_STACKTRACE", childJob_tRunJob_6.getExceptionStackTrace());
				}
				errorCode = childJob_tRunJob_6.getErrorCode();
				if (childJob_tRunJob_6.getErrorCode() != null || ("failure").equals(childJob_tRunJob_6.getStatus())) {
					java.lang.Exception ce_tRunJob_6 = childJob_tRunJob_6.getException();
					throw new RuntimeException("Child job running failed.\n" + ((ce_tRunJob_6 != null)
							? (ce_tRunJob_6.getClass().getName() + ": " + ce_tRunJob_6.getMessage())
							: ""));
				}

				tos_count_tRunJob_6++;

				/**
				 * [tRunJob_6 main ] stop
				 */

				/**
				 * [tRunJob_6 process_data_begin ] start
				 */

				currentComponent = "tRunJob_6";

				/**
				 * [tRunJob_6 process_data_begin ] stop
				 */

				/**
				 * [tRunJob_6 process_data_end ] start
				 */

				currentComponent = "tRunJob_6";

				/**
				 * [tRunJob_6 process_data_end ] stop
				 */

				/**
				 * [tRunJob_6 end ] start
				 */

				currentComponent = "tRunJob_6";

				if (log.isDebugEnabled())
					log.debug("tRunJob_6 - " + ("Done."));

				ok_Hash.put("tRunJob_6", true);
				end_Hash.put("tRunJob_6", System.currentTimeMillis());

				/**
				 * [tRunJob_6 end ] stop
				 */
			} // end the resume

		} catch (java.lang.Exception e) {

			if (!(e instanceof TalendException)) {
				log.fatal(currentComponent + " " + e.getMessage(), e);
			}

			TalendException te = new TalendException(e, currentComponent, cLabel, globalMap);

			throw te;
		} catch (java.lang.Error error) {

			runStat.stopThreadStat();

			throw error;
		} finally {

			try {

				/**
				 * [tRunJob_6 finally ] start
				 */

				currentComponent = "tRunJob_6";

				/**
				 * [tRunJob_6 finally ] stop
				 */
			} catch (java.lang.Exception e) {
				// ignore
			} catch (java.lang.Error error) {
				// ignore
			}
			resourceMap = null;
		}

		globalMap.put("tRunJob_6_SUBPROCESS_STATE", 1);
	}

	public void tRunJob_7Process(final java.util.Map<String, Object> globalMap) throws TalendException {
		globalMap.put("tRunJob_7_SUBPROCESS_STATE", 0);

		final boolean execStat = this.execStat;

		mdcInfo.forEach(org.slf4j.MDC::put);
		org.slf4j.MDC.put("_subJobName", "tRunJob_7");
		org.slf4j.MDC.put("_subJobPid", "hujJqD_" + subJobPidCounter.getAndIncrement());

		String iterateId = "";

		String currentComponent = "";
		String cLabel = null;
		java.util.Map<String, Object> resourceMap = new java.util.HashMap<String, Object>();

		try {
			// TDI-39566 avoid throwing an useless Exception
			boolean resumeIt = true;
			if (globalResumeTicket == false && resumeEntryMethodName != null) {
				String currentMethodName = new java.lang.Exception().getStackTrace()[0].getMethodName();
				resumeIt = resumeEntryMethodName.equals(currentMethodName);
			}
			if (resumeIt || globalResumeTicket) { // start the resume
				globalResumeTicket = true;

				/**
				 * [tRunJob_7 begin ] start
				 */

				ok_Hash.put("tRunJob_7", false);
				start_Hash.put("tRunJob_7", System.currentTimeMillis());

				currentComponent = "tRunJob_7";

				cLabel = "SQL Load 2";

				int tos_count_tRunJob_7 = 0;

				if (log.isDebugEnabled())
					log.debug("tRunJob_7 - " + ("Start to work."));
				if (log.isDebugEnabled()) {
					class BytesLimit65535_tRunJob_7 {
						public void limitLog4jByte() throws Exception {
							StringBuilder log4jParamters_tRunJob_7 = new StringBuilder();
							log4jParamters_tRunJob_7.append("Parameters:");
							log4jParamters_tRunJob_7.append("USE_DYNAMIC_JOB" + " = " + "false");
							log4jParamters_tRunJob_7.append(" | ");
							log4jParamters_tRunJob_7.append("PROCESS" + " = " + "sql_staging_job_2");
							log4jParamters_tRunJob_7.append(" | ");
							log4jParamters_tRunJob_7.append("USE_INDEPENDENT_PROCESS" + " = " + "false");
							log4jParamters_tRunJob_7.append(" | ");
							log4jParamters_tRunJob_7.append("DIE_ON_CHILD_ERROR" + " = " + "true");
							log4jParamters_tRunJob_7.append(" | ");
							log4jParamters_tRunJob_7.append("TRANSMIT_WHOLE_CONTEXT" + " = " + "false");
							log4jParamters_tRunJob_7.append(" | ");
							log4jParamters_tRunJob_7.append("CONTEXTPARAMS" + " = " + "[{PARAM_NAME_COLUMN="
									+ ("job_name") + ", PARAM_VALUE_COLUMN=" + ("context.sql_job") + "}]");
							log4jParamters_tRunJob_7.append(" | ");
							log4jParamters_tRunJob_7.append("PROPAGATE_CHILD_RESULT" + " = " + "false");
							log4jParamters_tRunJob_7.append(" | ");
							log4jParamters_tRunJob_7.append("PRINT_PARAMETER" + " = " + "false");
							log4jParamters_tRunJob_7.append(" | ");
							log4jParamters_tRunJob_7.append("USE_DYNAMIC_CONTEXT" + " = " + "false");
							log4jParamters_tRunJob_7.append(" | ");
							if (log.isDebugEnabled())
								log.debug("tRunJob_7 - " + (log4jParamters_tRunJob_7));
						}
					}
					new BytesLimit65535_tRunJob_7().limitLog4jByte();
				}
				if (enableLogStash) {
					talendJobLog.addCM("tRunJob_7", "SQL Load 2", "tRunJob");
					talendJobLogProcess(globalMap);
				}

				/**
				 * [tRunJob_7 begin ] stop
				 */

				/**
				 * [tRunJob_7 main ] start
				 */

				currentComponent = "tRunJob_7";

				cLabel = "SQL Load 2";

				java.util.List<String> paraList_tRunJob_7 = new java.util.ArrayList<String>();

				paraList_tRunJob_7.add("--father_pid=" + pid);

				paraList_tRunJob_7.add("--root_pid=" + rootPid);

				paraList_tRunJob_7.add("--father_node=tRunJob_7");

				paraList_tRunJob_7.add("--context=Default");

				if (!"".equals(log4jLevel)) {
					paraList_tRunJob_7.add("--log4jLevel=" + log4jLevel);
				}

				if (enableLogStash) {
					paraList_tRunJob_7.add("--audit.enabled=" + enableLogStash);
				}

				// for feature:10589

				paraList_tRunJob_7.add("--stat_port=" + portStats);

				if (resuming_logs_dir_path != null) {
					paraList_tRunJob_7.add("--resuming_logs_dir_path=" + resuming_logs_dir_path);
				}
				String childResumePath_tRunJob_7 = ResumeUtil.getChildJobCheckPointPath(resuming_checkpoint_path);
				String tRunJobName_tRunJob_7 = ResumeUtil.getRighttRunJob(resuming_checkpoint_path);
				if ("tRunJob_7".equals(tRunJobName_tRunJob_7) && childResumePath_tRunJob_7 != null) {
					paraList_tRunJob_7.add("--resuming_checkpoint_path="
							+ ResumeUtil.getChildJobCheckPointPath(resuming_checkpoint_path));
				}
				paraList_tRunJob_7.add("--parent_part_launcher=JOB:" + jobName + "/NODE:tRunJob_7");

				java.util.Map<String, Object> parentContextMap_tRunJob_7 = new java.util.HashMap<String, Object>();

				Object obj_tRunJob_7 = null;

				obj_tRunJob_7 = context.sql_job;
				if (obj_tRunJob_7 != null) {
					if (obj_tRunJob_7.getClass().getName().equals("java.util.Date")) {
						paraList_tRunJob_7
								.add("--context_param job_name=" + ((java.util.Date) obj_tRunJob_7).getTime());
					} else {
						paraList_tRunJob_7
								.add("--context_param job_name=" + RuntimeUtils.tRunJobConvertContext(obj_tRunJob_7));
					}
				} else {
					paraList_tRunJob_7.add(
							"--context_param job_name=" + NULL_VALUE_EXPRESSION_IN_COMMAND_STRING_FOR_CHILD_JOB_ONLY);
				}

				parentContextMap_tRunJob_7.put("job_name", obj_tRunJob_7);

				final_project.sql_staging_job_2_0_1.sql_staging_job_2 childJob_tRunJob_7 = new final_project.sql_staging_job_2_0_1.sql_staging_job_2();
				// pass DataSources
				java.util.Map<String, routines.system.TalendDataSource> talendDataSources_tRunJob_7 = (java.util.Map<String, routines.system.TalendDataSource>) globalMap
						.get(KEY_DB_DATASOURCES);
				if (null != talendDataSources_tRunJob_7) {
					java.util.Map<String, javax.sql.DataSource> dataSources_tRunJob_7 = new java.util.HashMap<String, javax.sql.DataSource>();
					for (java.util.Map.Entry<String, routines.system.TalendDataSource> talendDataSourceEntry_tRunJob_7 : talendDataSources_tRunJob_7
							.entrySet()) {
						dataSources_tRunJob_7.put(talendDataSourceEntry_tRunJob_7.getKey(),
								talendDataSourceEntry_tRunJob_7.getValue().getRawDataSource());
					}
					childJob_tRunJob_7.setDataSources(dataSources_tRunJob_7);
				}

				childJob_tRunJob_7.parentContextMap = parentContextMap_tRunJob_7;

				log.info(
						"tRunJob_7 - The child job 'final_project.sql_staging_job_2_0_1.sql_staging_job_2' starts on the version '0.1' with the context 'Default'.");

				String[][] childReturn_tRunJob_7 = childJob_tRunJob_7
						.runJob((String[]) paraList_tRunJob_7.toArray(new String[paraList_tRunJob_7.size()]));

				log.info("tRunJob_7 - The child job 'final_project.sql_staging_job_2_0_1.sql_staging_job_2' is done.");

				if (childJob_tRunJob_7.getErrorCode() == null) {
					globalMap.put("tRunJob_7_CHILD_RETURN_CODE",
							childJob_tRunJob_7.getStatus() != null && ("failure").equals(childJob_tRunJob_7.getStatus())
									? 1
									: 0);
				} else {
					globalMap.put("tRunJob_7_CHILD_RETURN_CODE", childJob_tRunJob_7.getErrorCode());
				}
				if (childJob_tRunJob_7.getExceptionStackTrace() != null) {
					globalMap.put("tRunJob_7_CHILD_EXCEPTION_STACKTRACE", childJob_tRunJob_7.getExceptionStackTrace());
				}
				errorCode = childJob_tRunJob_7.getErrorCode();
				if (childJob_tRunJob_7.getErrorCode() != null || ("failure").equals(childJob_tRunJob_7.getStatus())) {
					java.lang.Exception ce_tRunJob_7 = childJob_tRunJob_7.getException();
					throw new RuntimeException("Child job running failed.\n" + ((ce_tRunJob_7 != null)
							? (ce_tRunJob_7.getClass().getName() + ": " + ce_tRunJob_7.getMessage())
							: ""));
				}

				tos_count_tRunJob_7++;

				/**
				 * [tRunJob_7 main ] stop
				 */

				/**
				 * [tRunJob_7 process_data_begin ] start
				 */

				currentComponent = "tRunJob_7";

				cLabel = "SQL Load 2";

				/**
				 * [tRunJob_7 process_data_begin ] stop
				 */

				/**
				 * [tRunJob_7 process_data_end ] start
				 */

				currentComponent = "tRunJob_7";

				cLabel = "SQL Load 2";

				/**
				 * [tRunJob_7 process_data_end ] stop
				 */

				/**
				 * [tRunJob_7 end ] start
				 */

				currentComponent = "tRunJob_7";

				cLabel = "SQL Load 2";

				if (log.isDebugEnabled())
					log.debug("tRunJob_7 - " + ("Done."));

				ok_Hash.put("tRunJob_7", true);
				end_Hash.put("tRunJob_7", System.currentTimeMillis());

				/**
				 * [tRunJob_7 end ] stop
				 */
			} // end the resume

		} catch (java.lang.Exception e) {

			if (!(e instanceof TalendException)) {
				log.fatal(currentComponent + " " + e.getMessage(), e);
			}

			TalendException te = new TalendException(e, currentComponent, cLabel, globalMap);

			throw te;
		} catch (java.lang.Error error) {

			runStat.stopThreadStat();

			throw error;
		} finally {

			try {

				/**
				 * [tRunJob_7 finally ] start
				 */

				currentComponent = "tRunJob_7";

				cLabel = "SQL Load 2";

				/**
				 * [tRunJob_7 finally ] stop
				 */
			} catch (java.lang.Exception e) {
				// ignore
			} catch (java.lang.Error error) {
				// ignore
			}
			resourceMap = null;
		}

		globalMap.put("tRunJob_7_SUBPROCESS_STATE", 1);
	}

	public void tRunJob_8Process(final java.util.Map<String, Object> globalMap) throws TalendException {
		globalMap.put("tRunJob_8_SUBPROCESS_STATE", 0);

		final boolean execStat = this.execStat;

		mdcInfo.forEach(org.slf4j.MDC::put);
		org.slf4j.MDC.put("_subJobName", "tRunJob_8");
		org.slf4j.MDC.put("_subJobPid", "AfigWU_" + subJobPidCounter.getAndIncrement());

		String iterateId = "";

		String currentComponent = "";
		String cLabel = null;
		java.util.Map<String, Object> resourceMap = new java.util.HashMap<String, Object>();

		try {
			// TDI-39566 avoid throwing an useless Exception
			boolean resumeIt = true;
			if (globalResumeTicket == false && resumeEntryMethodName != null) {
				String currentMethodName = new java.lang.Exception().getStackTrace()[0].getMethodName();
				resumeIt = resumeEntryMethodName.equals(currentMethodName);
			}
			if (resumeIt || globalResumeTicket) { // start the resume
				globalResumeTicket = true;

				/**
				 * [tRunJob_8 begin ] start
				 */

				ok_Hash.put("tRunJob_8", false);
				start_Hash.put("tRunJob_8", System.currentTimeMillis());

				currentComponent = "tRunJob_8";

				int tos_count_tRunJob_8 = 0;

				if (log.isDebugEnabled())
					log.debug("tRunJob_8 - " + ("Start to work."));
				if (log.isDebugEnabled()) {
					class BytesLimit65535_tRunJob_8 {
						public void limitLog4jByte() throws Exception {
							StringBuilder log4jParamters_tRunJob_8 = new StringBuilder();
							log4jParamters_tRunJob_8.append("Parameters:");
							log4jParamters_tRunJob_8.append("USE_DYNAMIC_JOB" + " = " + "false");
							log4jParamters_tRunJob_8.append(" | ");
							log4jParamters_tRunJob_8.append("PROCESS" + " = " + "pre_job_log");
							log4jParamters_tRunJob_8.append(" | ");
							log4jParamters_tRunJob_8.append("USE_INDEPENDENT_PROCESS" + " = " + "false");
							log4jParamters_tRunJob_8.append(" | ");
							log4jParamters_tRunJob_8.append("DIE_ON_CHILD_ERROR" + " = " + "true");
							log4jParamters_tRunJob_8.append(" | ");
							log4jParamters_tRunJob_8.append("TRANSMIT_WHOLE_CONTEXT" + " = " + "false");
							log4jParamters_tRunJob_8.append(" | ");
							log4jParamters_tRunJob_8
									.append("CONTEXTPARAMS" + " = " + "[{PARAM_NAME_COLUMN=" + ("job_name")
											+ ", PARAM_VALUE_COLUMN=" + ("context.sql_job") + "}, {PARAM_NAME_COLUMN="
											+ ("job_status") + ", PARAM_VALUE_COLUMN=" + ("\"Error\"") + "}]");
							log4jParamters_tRunJob_8.append(" | ");
							log4jParamters_tRunJob_8.append("PROPAGATE_CHILD_RESULT" + " = " + "false");
							log4jParamters_tRunJob_8.append(" | ");
							log4jParamters_tRunJob_8.append("PRINT_PARAMETER" + " = " + "false");
							log4jParamters_tRunJob_8.append(" | ");
							log4jParamters_tRunJob_8.append("USE_DYNAMIC_CONTEXT" + " = " + "false");
							log4jParamters_tRunJob_8.append(" | ");
							if (log.isDebugEnabled())
								log.debug("tRunJob_8 - " + (log4jParamters_tRunJob_8));
						}
					}
					new BytesLimit65535_tRunJob_8().limitLog4jByte();
				}
				if (enableLogStash) {
					talendJobLog.addCM("tRunJob_8", "tRunJob_8", "tRunJob");
					talendJobLogProcess(globalMap);
				}

				/**
				 * [tRunJob_8 begin ] stop
				 */

				/**
				 * [tRunJob_8 main ] start
				 */

				currentComponent = "tRunJob_8";

				java.util.List<String> paraList_tRunJob_8 = new java.util.ArrayList<String>();

				paraList_tRunJob_8.add("--father_pid=" + pid);

				paraList_tRunJob_8.add("--root_pid=" + rootPid);

				paraList_tRunJob_8.add("--father_node=tRunJob_8");

				paraList_tRunJob_8.add("--context=Default");

				if (!"".equals(log4jLevel)) {
					paraList_tRunJob_8.add("--log4jLevel=" + log4jLevel);
				}

				if (enableLogStash) {
					paraList_tRunJob_8.add("--audit.enabled=" + enableLogStash);
				}

				// for feature:10589

				paraList_tRunJob_8.add("--stat_port=" + portStats);

				if (resuming_logs_dir_path != null) {
					paraList_tRunJob_8.add("--resuming_logs_dir_path=" + resuming_logs_dir_path);
				}
				String childResumePath_tRunJob_8 = ResumeUtil.getChildJobCheckPointPath(resuming_checkpoint_path);
				String tRunJobName_tRunJob_8 = ResumeUtil.getRighttRunJob(resuming_checkpoint_path);
				if ("tRunJob_8".equals(tRunJobName_tRunJob_8) && childResumePath_tRunJob_8 != null) {
					paraList_tRunJob_8.add("--resuming_checkpoint_path="
							+ ResumeUtil.getChildJobCheckPointPath(resuming_checkpoint_path));
				}
				paraList_tRunJob_8.add("--parent_part_launcher=JOB:" + jobName + "/NODE:tRunJob_8");

				java.util.Map<String, Object> parentContextMap_tRunJob_8 = new java.util.HashMap<String, Object>();

				Object obj_tRunJob_8 = null;

				obj_tRunJob_8 = context.sql_job;
				if (obj_tRunJob_8 != null) {
					if (obj_tRunJob_8.getClass().getName().equals("java.util.Date")) {
						paraList_tRunJob_8
								.add("--context_param job_name=" + ((java.util.Date) obj_tRunJob_8).getTime());
					} else {
						paraList_tRunJob_8
								.add("--context_param job_name=" + RuntimeUtils.tRunJobConvertContext(obj_tRunJob_8));
					}
				} else {
					paraList_tRunJob_8.add(
							"--context_param job_name=" + NULL_VALUE_EXPRESSION_IN_COMMAND_STRING_FOR_CHILD_JOB_ONLY);
				}

				parentContextMap_tRunJob_8.put("job_name", obj_tRunJob_8);

				obj_tRunJob_8 = "Error";
				if (obj_tRunJob_8 != null) {
					if (obj_tRunJob_8.getClass().getName().equals("java.util.Date")) {
						paraList_tRunJob_8
								.add("--context_param job_status=" + ((java.util.Date) obj_tRunJob_8).getTime());
					} else {
						paraList_tRunJob_8
								.add("--context_param job_status=" + RuntimeUtils.tRunJobConvertContext(obj_tRunJob_8));
					}
				} else {
					paraList_tRunJob_8.add(
							"--context_param job_status=" + NULL_VALUE_EXPRESSION_IN_COMMAND_STRING_FOR_CHILD_JOB_ONLY);
				}

				parentContextMap_tRunJob_8.put("job_status", obj_tRunJob_8);

				final_project.pre_job_log_0_1.pre_job_log childJob_tRunJob_8 = new final_project.pre_job_log_0_1.pre_job_log();
				// pass DataSources
				java.util.Map<String, routines.system.TalendDataSource> talendDataSources_tRunJob_8 = (java.util.Map<String, routines.system.TalendDataSource>) globalMap
						.get(KEY_DB_DATASOURCES);
				if (null != talendDataSources_tRunJob_8) {
					java.util.Map<String, javax.sql.DataSource> dataSources_tRunJob_8 = new java.util.HashMap<String, javax.sql.DataSource>();
					for (java.util.Map.Entry<String, routines.system.TalendDataSource> talendDataSourceEntry_tRunJob_8 : talendDataSources_tRunJob_8
							.entrySet()) {
						dataSources_tRunJob_8.put(talendDataSourceEntry_tRunJob_8.getKey(),
								talendDataSourceEntry_tRunJob_8.getValue().getRawDataSource());
					}
					childJob_tRunJob_8.setDataSources(dataSources_tRunJob_8);
				}

				childJob_tRunJob_8.parentContextMap = parentContextMap_tRunJob_8;

				log.info(
						"tRunJob_8 - The child job 'final_project.pre_job_log_0_1.pre_job_log' starts on the version '0.1' with the context 'Default'.");

				String[][] childReturn_tRunJob_8 = childJob_tRunJob_8
						.runJob((String[]) paraList_tRunJob_8.toArray(new String[paraList_tRunJob_8.size()]));

				log.info("tRunJob_8 - The child job 'final_project.pre_job_log_0_1.pre_job_log' is done.");

				if (childJob_tRunJob_8.getErrorCode() == null) {
					globalMap.put("tRunJob_8_CHILD_RETURN_CODE",
							childJob_tRunJob_8.getStatus() != null && ("failure").equals(childJob_tRunJob_8.getStatus())
									? 1
									: 0);
				} else {
					globalMap.put("tRunJob_8_CHILD_RETURN_CODE", childJob_tRunJob_8.getErrorCode());
				}
				if (childJob_tRunJob_8.getExceptionStackTrace() != null) {
					globalMap.put("tRunJob_8_CHILD_EXCEPTION_STACKTRACE", childJob_tRunJob_8.getExceptionStackTrace());
				}
				errorCode = childJob_tRunJob_8.getErrorCode();
				if (childJob_tRunJob_8.getErrorCode() != null || ("failure").equals(childJob_tRunJob_8.getStatus())) {
					java.lang.Exception ce_tRunJob_8 = childJob_tRunJob_8.getException();
					throw new RuntimeException("Child job running failed.\n" + ((ce_tRunJob_8 != null)
							? (ce_tRunJob_8.getClass().getName() + ": " + ce_tRunJob_8.getMessage())
							: ""));
				}

				tos_count_tRunJob_8++;

				/**
				 * [tRunJob_8 main ] stop
				 */

				/**
				 * [tRunJob_8 process_data_begin ] start
				 */

				currentComponent = "tRunJob_8";

				/**
				 * [tRunJob_8 process_data_begin ] stop
				 */

				/**
				 * [tRunJob_8 process_data_end ] start
				 */

				currentComponent = "tRunJob_8";

				/**
				 * [tRunJob_8 process_data_end ] stop
				 */

				/**
				 * [tRunJob_8 end ] start
				 */

				currentComponent = "tRunJob_8";

				if (log.isDebugEnabled())
					log.debug("tRunJob_8 - " + ("Done."));

				ok_Hash.put("tRunJob_8", true);
				end_Hash.put("tRunJob_8", System.currentTimeMillis());

				/**
				 * [tRunJob_8 end ] stop
				 */
			} // end the resume

		} catch (java.lang.Exception e) {

			if (!(e instanceof TalendException)) {
				log.fatal(currentComponent + " " + e.getMessage(), e);
			}

			TalendException te = new TalendException(e, currentComponent, cLabel, globalMap);

			throw te;
		} catch (java.lang.Error error) {

			runStat.stopThreadStat();

			throw error;
		} finally {

			try {

				/**
				 * [tRunJob_8 finally ] start
				 */

				currentComponent = "tRunJob_8";

				/**
				 * [tRunJob_8 finally ] stop
				 */
			} catch (java.lang.Exception e) {
				// ignore
			} catch (java.lang.Error error) {
				// ignore
			}
			resourceMap = null;
		}

		globalMap.put("tRunJob_8_SUBPROCESS_STATE", 1);
	}

	public void talendJobLogProcess(final java.util.Map<String, Object> globalMap) throws TalendException {
		globalMap.put("talendJobLog_SUBPROCESS_STATE", 0);

		final boolean execStat = this.execStat;

		mdcInfo.forEach(org.slf4j.MDC::put);
		org.slf4j.MDC.put("_subJobName", "talendJobLog");
		org.slf4j.MDC.put("_subJobPid", "Hpk7KO_" + subJobPidCounter.getAndIncrement());

		String iterateId = "";

		String currentComponent = "";
		String cLabel = null;
		java.util.Map<String, Object> resourceMap = new java.util.HashMap<String, Object>();

		try {
			// TDI-39566 avoid throwing an useless Exception
			boolean resumeIt = true;
			if (globalResumeTicket == false && resumeEntryMethodName != null) {
				String currentMethodName = new java.lang.Exception().getStackTrace()[0].getMethodName();
				resumeIt = resumeEntryMethodName.equals(currentMethodName);
			}
			if (resumeIt || globalResumeTicket) { // start the resume
				globalResumeTicket = true;

				/**
				 * [talendJobLog begin ] start
				 */

				ok_Hash.put("talendJobLog", false);
				start_Hash.put("talendJobLog", System.currentTimeMillis());

				currentComponent = "talendJobLog";

				int tos_count_talendJobLog = 0;

				for (JobStructureCatcherUtils.JobStructureCatcherMessage jcm : talendJobLog.getMessages()) {
					org.talend.job.audit.JobContextBuilder builder_talendJobLog = org.talend.job.audit.JobContextBuilder
							.create().jobName(jcm.job_name).jobId(jcm.job_id).jobVersion(jcm.job_version)
							.custom("process_id", jcm.pid).custom("thread_id", jcm.tid).custom("pid", pid)
							.custom("father_pid", fatherPid).custom("root_pid", rootPid);
					org.talend.logging.audit.Context log_context_talendJobLog = null;

					if (jcm.log_type == JobStructureCatcherUtils.LogType.PERFORMANCE) {
						long timeMS = jcm.end_time - jcm.start_time;
						String duration = String.valueOf(timeMS);

						log_context_talendJobLog = builder_talendJobLog.sourceId(jcm.sourceId)
								.sourceLabel(jcm.sourceLabel).sourceConnectorType(jcm.sourceComponentName)
								.targetId(jcm.targetId).targetLabel(jcm.targetLabel)
								.targetConnectorType(jcm.targetComponentName).connectionName(jcm.current_connector)
								.rows(jcm.row_count).duration(duration).build();
						auditLogger_talendJobLog.flowExecution(log_context_talendJobLog);
					} else if (jcm.log_type == JobStructureCatcherUtils.LogType.JOBSTART) {
						log_context_talendJobLog = builder_talendJobLog.timestamp(jcm.moment).build();
						auditLogger_talendJobLog.jobstart(log_context_talendJobLog);
					} else if (jcm.log_type == JobStructureCatcherUtils.LogType.JOBEND) {
						long timeMS = jcm.end_time - jcm.start_time;
						String duration = String.valueOf(timeMS);

						log_context_talendJobLog = builder_talendJobLog.timestamp(jcm.moment).duration(duration)
								.status(jcm.status).build();
						auditLogger_talendJobLog.jobstop(log_context_talendJobLog);
					} else if (jcm.log_type == JobStructureCatcherUtils.LogType.RUNCOMPONENT) {
						log_context_talendJobLog = builder_talendJobLog.timestamp(jcm.moment)
								.connectorType(jcm.component_name).connectorId(jcm.component_id)
								.connectorLabel(jcm.component_label).build();
						auditLogger_talendJobLog.runcomponent(log_context_talendJobLog);
					} else if (jcm.log_type == JobStructureCatcherUtils.LogType.FLOWINPUT) {// log current component
																							// input line
						long timeMS = jcm.end_time - jcm.start_time;
						String duration = String.valueOf(timeMS);

						log_context_talendJobLog = builder_talendJobLog.connectorType(jcm.component_name)
								.connectorId(jcm.component_id).connectorLabel(jcm.component_label)
								.connectionName(jcm.current_connector).connectionType(jcm.current_connector_type)
								.rows(jcm.total_row_number).duration(duration).build();
						auditLogger_talendJobLog.flowInput(log_context_talendJobLog);
					} else if (jcm.log_type == JobStructureCatcherUtils.LogType.FLOWOUTPUT) {// log current component
																								// output/reject line
						long timeMS = jcm.end_time - jcm.start_time;
						String duration = String.valueOf(timeMS);

						log_context_talendJobLog = builder_talendJobLog.connectorType(jcm.component_name)
								.connectorId(jcm.component_id).connectorLabel(jcm.component_label)
								.connectionName(jcm.current_connector).connectionType(jcm.current_connector_type)
								.rows(jcm.total_row_number).duration(duration).build();
						auditLogger_talendJobLog.flowOutput(log_context_talendJobLog);
					} else if (jcm.log_type == JobStructureCatcherUtils.LogType.JOBERROR) {
						java.lang.Exception e_talendJobLog = jcm.exception;
						if (e_talendJobLog != null) {
							try (java.io.StringWriter sw_talendJobLog = new java.io.StringWriter();
									java.io.PrintWriter pw_talendJobLog = new java.io.PrintWriter(sw_talendJobLog)) {
								e_talendJobLog.printStackTrace(pw_talendJobLog);
								builder_talendJobLog.custom("stacktrace", sw_talendJobLog.getBuffer().substring(0,
										java.lang.Math.min(sw_talendJobLog.getBuffer().length(), 512)));
							}
						}

						if (jcm.extra_info != null) {
							builder_talendJobLog.connectorId(jcm.component_id).custom("extra_info", jcm.extra_info);
						}

						log_context_talendJobLog = builder_talendJobLog
								.connectorType(jcm.component_id.substring(0, jcm.component_id.lastIndexOf('_')))
								.connectorId(jcm.component_id)
								.connectorLabel(jcm.component_label == null ? jcm.component_id : jcm.component_label)
								.build();

						auditLogger_talendJobLog.exception(log_context_talendJobLog);
					}

				}

				/**
				 * [talendJobLog begin ] stop
				 */

				/**
				 * [talendJobLog main ] start
				 */

				currentComponent = "talendJobLog";

				tos_count_talendJobLog++;

				/**
				 * [talendJobLog main ] stop
				 */

				/**
				 * [talendJobLog process_data_begin ] start
				 */

				currentComponent = "talendJobLog";

				/**
				 * [talendJobLog process_data_begin ] stop
				 */

				/**
				 * [talendJobLog process_data_end ] start
				 */

				currentComponent = "talendJobLog";

				/**
				 * [talendJobLog process_data_end ] stop
				 */

				/**
				 * [talendJobLog end ] start
				 */

				currentComponent = "talendJobLog";

				ok_Hash.put("talendJobLog", true);
				end_Hash.put("talendJobLog", System.currentTimeMillis());

				/**
				 * [talendJobLog end ] stop
				 */
			} // end the resume

		} catch (java.lang.Exception e) {

			if (!(e instanceof TalendException)) {
				log.fatal(currentComponent + " " + e.getMessage(), e);
			}

			TalendException te = new TalendException(e, currentComponent, cLabel, globalMap);

			throw te;
		} catch (java.lang.Error error) {

			runStat.stopThreadStat();

			throw error;
		} finally {

			try {

				/**
				 * [talendJobLog finally ] start
				 */

				currentComponent = "talendJobLog";

				/**
				 * [talendJobLog finally ] stop
				 */
			} catch (java.lang.Exception e) {
				// ignore
			} catch (java.lang.Error error) {
				// ignore
			}
			resourceMap = null;
		}

		globalMap.put("talendJobLog_SUBPROCESS_STATE", 1);
	}

	public String resuming_logs_dir_path = null;
	public String resuming_checkpoint_path = null;
	public String parent_part_launcher = null;
	private String resumeEntryMethodName = null;
	private boolean globalResumeTicket = false;

	public boolean watch = false;
	// portStats is null, it means don't execute the statistics
	public Integer portStats = null;
	public int portTraces = 4334;
	public String clientHost;
	public String defaultClientHost = "localhost";
	public String contextStr = "Default";
	public boolean isDefaultContext = true;
	public String pid = "0";
	public String rootPid = null;
	public String fatherPid = null;
	public String fatherNode = null;
	public long startTime = 0;
	public boolean isChildJob = false;
	public String log4jLevel = "";

	private boolean enableLogStash;

	private boolean execStat = true;

	private ThreadLocal<java.util.Map<String, String>> threadLocal = new ThreadLocal<java.util.Map<String, String>>() {
		protected java.util.Map<String, String> initialValue() {
			java.util.Map<String, String> threadRunResultMap = new java.util.HashMap<String, String>();
			threadRunResultMap.put("errorCode", null);
			threadRunResultMap.put("status", "");
			return threadRunResultMap;
		};
	};

	protected PropertiesWithType context_param = new PropertiesWithType();
	public java.util.Map<String, Object> parentContextMap = new java.util.HashMap<String, Object>();

	public String status = "";

	private final static java.util.Properties jobInfo = new java.util.Properties();
	private final static java.util.Map<String, String> mdcInfo = new java.util.HashMap<>();
	private final static java.util.concurrent.atomic.AtomicLong subJobPidCounter = new java.util.concurrent.atomic.AtomicLong();

	public static void main(String[] args) {
		final trigger_staging_load trigger_staging_loadClass = new trigger_staging_load();

		int exitCode = trigger_staging_loadClass.runJobInTOS(args);
		if (exitCode == 0) {
			log.info("TalendJob: 'trigger_staging_load' - Done.");
		}

		System.exit(exitCode);
	}

	private void getjobInfo() {
		final String TEMPLATE_PATH = "src/main/templates/jobInfo_template.properties";
		final String BUILD_PATH = "../jobInfo.properties";
		final String path = this.getClass().getResource("").getPath();
		if (path.lastIndexOf("target") > 0) {
			final java.io.File templateFile = new java.io.File(
					path.substring(0, path.lastIndexOf("target")).concat(TEMPLATE_PATH));
			if (templateFile.exists()) {
				readJobInfo(templateFile);
				return;
			}
		}
		readJobInfo(new java.io.File(BUILD_PATH));
	}

	private void readJobInfo(java.io.File jobInfoFile) {

		if (jobInfoFile.exists()) {
			try (java.io.InputStream is = new java.io.FileInputStream(jobInfoFile)) {
				jobInfo.load(is);
			} catch (IOException e) {

				log.debug("Read jobInfo.properties file fail: " + e.getMessage());

			}
		}
		log.info(String.format("Project name: %s\tJob name: %s\tGIT Commit ID: %s\tTalend Version: %s", projectName,
				jobName, jobInfo.getProperty("gitCommitId"), "8.0.1.20230913_0925-patch"));

	}

	public String[][] runJob(String[] args) {

		int exitCode = runJobInTOS(args);
		String[][] bufferValue = new String[][] { { Integer.toString(exitCode) } };

		return bufferValue;
	}

	public boolean hastBufferOutputComponent() {
		boolean hastBufferOutput = false;

		return hastBufferOutput;
	}

	public int runJobInTOS(String[] args) {
		// reset status
		status = "";

		String lastStr = "";
		for (String arg : args) {
			if (arg.equalsIgnoreCase("--context_param")) {
				lastStr = arg;
			} else if (lastStr.equals("")) {
				evalParam(arg);
			} else {
				evalParam(lastStr + " " + arg);
				lastStr = "";
			}
		}
		enableLogStash = "true".equalsIgnoreCase(System.getProperty("audit.enabled"));

		if (!"".equals(log4jLevel)) {

			if ("trace".equalsIgnoreCase(log4jLevel)) {
				org.apache.logging.log4j.core.config.Configurator.setLevel(log.getName(),
						org.apache.logging.log4j.Level.TRACE);
			} else if ("debug".equalsIgnoreCase(log4jLevel)) {
				org.apache.logging.log4j.core.config.Configurator.setLevel(log.getName(),
						org.apache.logging.log4j.Level.DEBUG);
			} else if ("info".equalsIgnoreCase(log4jLevel)) {
				org.apache.logging.log4j.core.config.Configurator.setLevel(log.getName(),
						org.apache.logging.log4j.Level.INFO);
			} else if ("warn".equalsIgnoreCase(log4jLevel)) {
				org.apache.logging.log4j.core.config.Configurator.setLevel(log.getName(),
						org.apache.logging.log4j.Level.WARN);
			} else if ("error".equalsIgnoreCase(log4jLevel)) {
				org.apache.logging.log4j.core.config.Configurator.setLevel(log.getName(),
						org.apache.logging.log4j.Level.ERROR);
			} else if ("fatal".equalsIgnoreCase(log4jLevel)) {
				org.apache.logging.log4j.core.config.Configurator.setLevel(log.getName(),
						org.apache.logging.log4j.Level.FATAL);
			} else if ("off".equalsIgnoreCase(log4jLevel)) {
				org.apache.logging.log4j.core.config.Configurator.setLevel(log.getName(),
						org.apache.logging.log4j.Level.OFF);
			}
			org.apache.logging.log4j.core.config.Configurator
					.setLevel(org.apache.logging.log4j.LogManager.getRootLogger().getName(), log.getLevel());

		}

		getjobInfo();
		log.info("TalendJob: 'trigger_staging_load' - Start.");

		java.util.Set<Object> jobInfoKeys = jobInfo.keySet();
		for (Object jobInfoKey : jobInfoKeys) {
			org.slf4j.MDC.put("_" + jobInfoKey.toString(), jobInfo.get(jobInfoKey).toString());
		}
		org.slf4j.MDC.put("_pid", pid);
		org.slf4j.MDC.put("_rootPid", rootPid);
		org.slf4j.MDC.put("_fatherPid", fatherPid);
		org.slf4j.MDC.put("_projectName", projectName);
		org.slf4j.MDC.put("_startTimestamp", java.time.ZonedDateTime.now(java.time.ZoneOffset.UTC)
				.format(java.time.format.DateTimeFormatter.ISO_INSTANT));
		org.slf4j.MDC.put("_jobRepositoryId", "_zRgRoJI2Ee6x56qGn8mRSw");
		org.slf4j.MDC.put("_compiledAtTimestamp", "2023-12-04T00:39:43.351780400Z");

		java.lang.management.RuntimeMXBean mx = java.lang.management.ManagementFactory.getRuntimeMXBean();
		String[] mxNameTable = mx.getName().split("@"); //$NON-NLS-1$
		if (mxNameTable.length == 2) {
			org.slf4j.MDC.put("_systemPid", mxNameTable[0]);
		} else {
			org.slf4j.MDC.put("_systemPid", String.valueOf(java.lang.Thread.currentThread().getId()));
		}

		if (enableLogStash) {
			java.util.Properties properties_talendJobLog = new java.util.Properties();
			properties_talendJobLog.setProperty("root.logger", "audit");
			properties_talendJobLog.setProperty("encoding", "UTF-8");
			properties_talendJobLog.setProperty("application.name", "Talend Studio");
			properties_talendJobLog.setProperty("service.name", "Talend Studio Job");
			properties_talendJobLog.setProperty("instance.name", "Talend Studio Job Instance");
			properties_talendJobLog.setProperty("propagate.appender.exceptions", "none");
			properties_talendJobLog.setProperty("log.appender", "file");
			properties_talendJobLog.setProperty("appender.file.path", "audit.json");
			properties_talendJobLog.setProperty("appender.file.maxsize", "52428800");
			properties_talendJobLog.setProperty("appender.file.maxbackup", "20");
			properties_talendJobLog.setProperty("host", "false");

			System.getProperties().stringPropertyNames().stream().filter(it -> it.startsWith("audit.logger."))
					.forEach(key -> properties_talendJobLog.setProperty(key.substring("audit.logger.".length()),
							System.getProperty(key)));

			org.apache.logging.log4j.core.config.Configurator
					.setLevel(properties_talendJobLog.getProperty("root.logger"), org.apache.logging.log4j.Level.DEBUG);

			auditLogger_talendJobLog = org.talend.job.audit.JobEventAuditLoggerFactory
					.createJobAuditLogger(properties_talendJobLog);
		}

		if (clientHost == null) {
			clientHost = defaultClientHost;
		}

		if (pid == null || "0".equals(pid)) {
			pid = TalendString.getAsciiRandomString(6);
		}

		org.slf4j.MDC.put("_pid", pid);

		if (rootPid == null) {
			rootPid = pid;
		}

		org.slf4j.MDC.put("_rootPid", rootPid);

		if (fatherPid == null) {
			fatherPid = pid;
		} else {
			isChildJob = true;
		}
		org.slf4j.MDC.put("_fatherPid", fatherPid);

		if (portStats != null) {
			// portStats = -1; //for testing
			if (portStats < 0 || portStats > 65535) {
				// issue:10869, the portStats is invalid, so this client socket can't open
				System.err.println("The statistics socket port " + portStats + " is invalid.");
				execStat = false;
			}
		} else {
			execStat = false;
		}
		boolean inOSGi = routines.system.BundleUtils.inOSGi();

		try {
			java.util.Dictionary<String, Object> jobProperties = null;
			if (inOSGi) {
				jobProperties = routines.system.BundleUtils.getJobProperties(jobName);

				if (jobProperties != null && jobProperties.get("context") != null) {
					contextStr = (String) jobProperties.get("context");
				}
			}
			// call job/subjob with an existing context, like: --context=production. if
			// without this parameter, there will use the default context instead.
			java.io.InputStream inContext = trigger_staging_load.class.getClassLoader().getResourceAsStream(
					"final_project/trigger_staging_load_0_1/contexts/" + contextStr + ".properties");
			if (inContext == null) {
				inContext = trigger_staging_load.class.getClassLoader()
						.getResourceAsStream("config/contexts/" + contextStr + ".properties");
			}
			if (inContext != null) {
				try {
					// defaultProps is in order to keep the original context value
					if (context != null && context.isEmpty()) {
						defaultProps.load(inContext);
						if (inOSGi && jobProperties != null) {
							java.util.Enumeration<String> keys = jobProperties.keys();
							while (keys.hasMoreElements()) {
								String propKey = keys.nextElement();
								if (defaultProps.containsKey(propKey)) {
									defaultProps.put(propKey, (String) jobProperties.get(propKey));
								}
							}
						}
						context = new ContextProperties(defaultProps);
					}
				} finally {
					inContext.close();
				}
			} else if (!isDefaultContext) {
				// print info and job continue to run, for case: context_param is not empty.
				System.err.println("Could not find the context " + contextStr);
			}

			if (!context_param.isEmpty()) {
				context.putAll(context_param);
				// set types for params from parentJobs
				for (Object key : context_param.keySet()) {
					String context_key = key.toString();
					String context_type = context_param.getContextType(context_key);
					context.setContextType(context_key, context_type);

				}
			}
			class ContextProcessing {
				private void processContext_0() {
					context.setContextType("json_job", "id_String");
					if (context.getStringValue("json_job") == null) {
						context.json_job = null;
					} else {
						context.json_job = (String) context.getProperty("json_job");
					}
					context.setContextType("job_name", "id_String");
					if (context.getStringValue("job_name") == null) {
						context.job_name = null;
					} else {
						context.job_name = (String) context.getProperty("job_name");
					}
					context.setContextType("sql_job", "id_String");
					if (context.getStringValue("sql_job") == null) {
						context.sql_job = null;
					} else {
						context.sql_job = (String) context.getProperty("sql_job");
					}
					context.setContextType("tsv_job", "id_String");
					if (context.getStringValue("tsv_job") == null) {
						context.tsv_job = null;
					} else {
						context.tsv_job = (String) context.getProperty("tsv_job");
					}
				}

				public void processAllContext() {
					processContext_0();
				}
			}

			new ContextProcessing().processAllContext();
		} catch (java.io.IOException ie) {
			System.err.println("Could not load context " + contextStr);
			ie.printStackTrace();
		}

		// get context value from parent directly
		if (parentContextMap != null && !parentContextMap.isEmpty()) {
			if (parentContextMap.containsKey("json_job")) {
				context.json_job = (String) parentContextMap.get("json_job");
			}
			if (parentContextMap.containsKey("job_name")) {
				context.job_name = (String) parentContextMap.get("job_name");
			}
			if (parentContextMap.containsKey("sql_job")) {
				context.sql_job = (String) parentContextMap.get("sql_job");
			}
			if (parentContextMap.containsKey("tsv_job")) {
				context.tsv_job = (String) parentContextMap.get("tsv_job");
			}
		}

		// Resume: init the resumeUtil
		resumeEntryMethodName = ResumeUtil.getResumeEntryMethodName(resuming_checkpoint_path);
		resumeUtil = new ResumeUtil(resuming_logs_dir_path, isChildJob, rootPid);
		resumeUtil.initCommonInfo(pid, rootPid, fatherPid, projectName, jobName, contextStr, jobVersion);

		List<String> parametersToEncrypt = new java.util.ArrayList<String>();
		// Resume: jobStart
		resumeUtil.addLog("JOB_STARTED", "JOB:" + jobName, parent_part_launcher, Thread.currentThread().getId() + "",
				"", "", "", "", resumeUtil.convertToJsonText(context, ContextProperties.class, parametersToEncrypt));

		org.slf4j.MDC.put("_context", contextStr);
		log.info("TalendJob: 'trigger_staging_load' - Started.");
		java.util.Optional.ofNullable(org.slf4j.MDC.getCopyOfContextMap()).ifPresent(mdcInfo::putAll);

		if (execStat) {
			try {
				runStat.openSocket(!isChildJob);
				runStat.setAllPID(rootPid, fatherPid, pid, jobName);
				runStat.startThreadStat(clientHost, portStats);
				runStat.updateStatOnJob(RunStat.JOBSTART, fatherNode);
			} catch (java.io.IOException ioException) {
				ioException.printStackTrace();
			}
		}

		java.util.concurrent.ConcurrentHashMap<Object, Object> concurrentHashMap = new java.util.concurrent.ConcurrentHashMap<Object, Object>();
		globalMap.put("concurrentHashMap", concurrentHashMap);

		long startUsedMemory = Runtime.getRuntime().totalMemory() - Runtime.getRuntime().freeMemory();
		long endUsedMemory = 0;
		long end = 0;

		startTime = System.currentTimeMillis();

		this.globalResumeTicket = true;// to run tPreJob

		try {
			errorCode = null;
			tPrejob_1Process(globalMap);
			if (!"failure".equals(status)) {
				status = "end";
			}
		} catch (TalendException e_tPrejob_1) {
			globalMap.put("tPrejob_1_SUBPROCESS_STATE", -1);

			e_tPrejob_1.printStackTrace();

		}

		if (enableLogStash) {
			talendJobLog.addJobStartMessage();
			try {
				talendJobLogProcess(globalMap);
			} catch (java.lang.Exception e) {
				e.printStackTrace();
			}
		}

		this.globalResumeTicket = false;// to run others jobs

		try {
			errorCode = null;
			tRunJob_3Process(globalMap);
			if (!"failure".equals(status)) {
				status = "end";
			}
		} catch (TalendException e_tRunJob_3) {
			globalMap.put("tRunJob_3_SUBPROCESS_STATE", -1);

			e_tRunJob_3.printStackTrace();

		}

		this.globalResumeTicket = true;// to run tPostJob

		try {
			errorCode = null;
			tPostjob_1Process(globalMap);
			if (!"failure".equals(status)) {
				status = "end";
			}
		} catch (TalendException e_tPostjob_1) {
			globalMap.put("tPostjob_1_SUBPROCESS_STATE", -1);

			e_tPostjob_1.printStackTrace();

		}

		end = System.currentTimeMillis();

		if (watch) {
			System.out.println((end - startTime) + " milliseconds");
		}

		endUsedMemory = Runtime.getRuntime().totalMemory() - Runtime.getRuntime().freeMemory();
		if (false) {
			System.out.println(
					(endUsedMemory - startUsedMemory) + " bytes memory increase when running : trigger_staging_load");
		}
		if (enableLogStash) {
			talendJobLog.addJobEndMessage(startTime, end, status);
			try {
				talendJobLogProcess(globalMap);
			} catch (java.lang.Exception e) {
				e.printStackTrace();
			}
		}

		if (execStat) {
			runStat.updateStatOnJob(RunStat.JOBEND, fatherNode);
			runStat.stopThreadStat();
		}
		int returnCode = 0;

		if (errorCode == null) {
			returnCode = status != null && status.equals("failure") ? 1 : 0;
		} else {
			returnCode = errorCode.intValue();
		}
		resumeUtil.addLog("JOB_ENDED", "JOB:" + jobName, parent_part_launcher, Thread.currentThread().getId() + "", "",
				"" + returnCode, "", "", "");
		resumeUtil.flush();

		org.slf4j.MDC.remove("_subJobName");
		org.slf4j.MDC.remove("_subJobPid");
		org.slf4j.MDC.remove("_systemPid");
		log.info("TalendJob: 'trigger_staging_load' - Finished - status: " + status + " returnCode: " + returnCode);

		return returnCode;

	}

	// only for OSGi env
	public void destroy() {

	}

	private java.util.Map<String, Object> getSharedConnections4REST() {
		java.util.Map<String, Object> connections = new java.util.HashMap<String, Object>();

		return connections;
	}

	private void evalParam(String arg) {
		if (arg.startsWith("--resuming_logs_dir_path")) {
			resuming_logs_dir_path = arg.substring(25);
		} else if (arg.startsWith("--resuming_checkpoint_path")) {
			resuming_checkpoint_path = arg.substring(27);
		} else if (arg.startsWith("--parent_part_launcher")) {
			parent_part_launcher = arg.substring(23);
		} else if (arg.startsWith("--watch")) {
			watch = true;
		} else if (arg.startsWith("--stat_port=")) {
			String portStatsStr = arg.substring(12);
			if (portStatsStr != null && !portStatsStr.equals("null")) {
				portStats = Integer.parseInt(portStatsStr);
			}
		} else if (arg.startsWith("--trace_port=")) {
			portTraces = Integer.parseInt(arg.substring(13));
		} else if (arg.startsWith("--client_host=")) {
			clientHost = arg.substring(14);
		} else if (arg.startsWith("--context=")) {
			contextStr = arg.substring(10);
			isDefaultContext = false;
		} else if (arg.startsWith("--father_pid=")) {
			fatherPid = arg.substring(13);
		} else if (arg.startsWith("--root_pid=")) {
			rootPid = arg.substring(11);
		} else if (arg.startsWith("--father_node=")) {
			fatherNode = arg.substring(14);
		} else if (arg.startsWith("--pid=")) {
			pid = arg.substring(6);
		} else if (arg.startsWith("--context_type")) {
			String keyValue = arg.substring(15);
			int index = -1;
			if (keyValue != null && (index = keyValue.indexOf('=')) > -1) {
				if (fatherPid == null) {
					context_param.setContextType(keyValue.substring(0, index),
							replaceEscapeChars(keyValue.substring(index + 1)));
				} else { // the subjob won't escape the especial chars
					context_param.setContextType(keyValue.substring(0, index), keyValue.substring(index + 1));
				}

			}

		} else if (arg.startsWith("--context_param")) {
			String keyValue = arg.substring(16);
			int index = -1;
			if (keyValue != null && (index = keyValue.indexOf('=')) > -1) {
				if (fatherPid == null) {
					context_param.put(keyValue.substring(0, index), replaceEscapeChars(keyValue.substring(index + 1)));
				} else { // the subjob won't escape the especial chars
					context_param.put(keyValue.substring(0, index), keyValue.substring(index + 1));
				}
			}
		} else if (arg.startsWith("--log4jLevel=")) {
			log4jLevel = arg.substring(13);
		} else if (arg.startsWith("--audit.enabled") && arg.contains("=")) {// for trunjob call
			final int equal = arg.indexOf('=');
			final String key = arg.substring("--".length(), equal);
			System.setProperty(key, arg.substring(equal + 1));
		}
	}

	private static final String NULL_VALUE_EXPRESSION_IN_COMMAND_STRING_FOR_CHILD_JOB_ONLY = "<TALEND_NULL>";

	private final String[][] escapeChars = { { "\\\\", "\\" }, { "\\n", "\n" }, { "\\'", "\'" }, { "\\r", "\r" },
			{ "\\f", "\f" }, { "\\b", "\b" }, { "\\t", "\t" } };

	private String replaceEscapeChars(String keyValue) {

		if (keyValue == null || ("").equals(keyValue.trim())) {
			return keyValue;
		}

		StringBuilder result = new StringBuilder();
		int currIndex = 0;
		while (currIndex < keyValue.length()) {
			int index = -1;
			// judege if the left string includes escape chars
			for (String[] strArray : escapeChars) {
				index = keyValue.indexOf(strArray[0], currIndex);
				if (index >= 0) {

					result.append(keyValue.substring(currIndex, index + strArray[0].length()).replace(strArray[0],
							strArray[1]));
					currIndex = index + strArray[0].length();
					break;
				}
			}
			// if the left string doesn't include escape chars, append the left into the
			// result
			if (index < 0) {
				result.append(keyValue.substring(currIndex));
				currIndex = currIndex + keyValue.length();
			}
		}

		return result.toString();
	}

	public Integer getErrorCode() {
		return errorCode;
	}

	public String getStatus() {
		return status;
	}

	ResumeUtil resumeUtil = null;
}
/************************************************************************************************
 * 138208 characters generated by Talend Cloud Data Fabric on the December 3,
 * 2023 at 7:39:43 PM EST
 ************************************************************************************************/