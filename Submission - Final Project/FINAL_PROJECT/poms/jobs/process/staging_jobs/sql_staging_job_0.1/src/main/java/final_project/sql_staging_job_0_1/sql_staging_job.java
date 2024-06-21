
package final_project.sql_staging_job_0_1;

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
 * Job: sql_staging_job Purpose: <br>
 * Description:  <br>
 * @author gorle.g@northeastern.edu
 * @version 8.0.1.20230913_0925-patch
 * @status 
 */
public class sql_staging_job implements TalendJob {
	static {System.setProperty("TalendJob.log", "sql_staging_job.log");}

	

	
	private static org.apache.logging.log4j.Logger log = org.apache.logging.log4j.LogManager.getLogger(sql_staging_job.class);
	

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
	

	//contains type for every context property
	public class PropertiesWithType extends java.util.Properties {
		private static final long serialVersionUID = 1L;
		private java.util.Map<String,String> propertyTypes = new java.util.HashMap<>();
		
		public PropertiesWithType(java.util.Properties properties){
			super(properties);
		}
		public PropertiesWithType(){
			super();
		}
		
		public void setContextType(String key, String type) {
			propertyTypes.put(key,type);
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

		public ContextProperties(java.util.Properties properties){
			super(properties);
		}
		public ContextProperties(){
			super();
		}

		public void synchronizeContext(){
			
			if(MySqlLocal_Password != null){
				
					this.setProperty("MySqlLocal_Password", MySqlLocal_Password.toString());
				
			}
			
			if(MySqlLocal_AdditionalParams != null){
				
					this.setProperty("MySqlLocal_AdditionalParams", MySqlLocal_AdditionalParams.toString());
				
			}
			
			if(MySqlLocal_Login != null){
				
					this.setProperty("MySqlLocal_Login", MySqlLocal_Login.toString());
				
			}
			
			if(MySqlLocal_Database != null){
				
					this.setProperty("MySqlLocal_Database", MySqlLocal_Database.toString());
				
			}
			
			if(MySqlLocal_Server != null){
				
					this.setProperty("MySqlLocal_Server", MySqlLocal_Server.toString());
				
			}
			
			if(MySqlLocal_Port != null){
				
					this.setProperty("MySqlLocal_Port", MySqlLocal_Port.toString());
				
			}
			
			if(job_name != null){
				
					this.setProperty("job_name", job_name.toString());
				
			}
			
		}
		
		//if the stored or passed value is "<TALEND_NULL>" string, it mean null
		public String getStringValue(String key) {
			String origin_value = this.getProperty(key);
			if(NULL_VALUE_EXPRESSION_IN_COMMAND_STRING_FOR_CHILD_JOB_ONLY.equals(origin_value)) {
				return null;
			}
			return origin_value;
		}

public java.lang.String MySqlLocal_Password;
public java.lang.String getMySqlLocal_Password(){
	return this.MySqlLocal_Password;
}
public String MySqlLocal_AdditionalParams;
public String getMySqlLocal_AdditionalParams(){
	return this.MySqlLocal_AdditionalParams;
}
public String MySqlLocal_Login;
public String getMySqlLocal_Login(){
	return this.MySqlLocal_Login;
}
public String MySqlLocal_Database;
public String getMySqlLocal_Database(){
	return this.MySqlLocal_Database;
}
public String MySqlLocal_Server;
public String getMySqlLocal_Server(){
	return this.MySqlLocal_Server;
}
public String MySqlLocal_Port;
public String getMySqlLocal_Port(){
	return this.MySqlLocal_Port;
}
public String job_name;
public String getJob_name(){
	return this.job_name;
}
	}
			
	protected ContextProperties context = new ContextProperties(); // will be instanciated by MS.
	public ContextProperties getContext() {
		return this.context;
	}
	private final String jobVersion = "0.1";
	private final String jobName = "sql_staging_job";
	private final String projectName = "FINAL_PROJECT";
	public Integer errorCode = null;
	private String currentComponent = "";
	
	private String cLabel =  null;
	
		private final java.util.Map<String, Object> globalMap = new java.util.HashMap<String, Object>();
        private final static java.util.Map<String, Object> junitGlobalMap = new java.util.HashMap<String, Object>();
	
		private final java.util.Map<String, Long> start_Hash = new java.util.HashMap<String, Long>();
		private final java.util.Map<String, Long> end_Hash = new java.util.HashMap<String, Long>();
		private final java.util.Map<String, Boolean> ok_Hash = new java.util.HashMap<String, Boolean>();
		public  final java.util.List<String[]> globalBuffer = new java.util.ArrayList<String[]>();
	

private final JobStructureCatcherUtils talendJobLog = new JobStructureCatcherUtils(jobName, "_5lZK4JEgEe6FmMo3PpyKlQ", "0.1");
private org.talend.job.audit.JobAuditLogger auditLogger_talendJobLog = null;

private RunStat runStat = new RunStat(talendJobLog, System.getProperty("audit.interval"));

	// OSGi DataSource
	private final static String KEY_DB_DATASOURCES = "KEY_DB_DATASOURCES";
	
	private final static String KEY_DB_DATASOURCES_RAW = "KEY_DB_DATASOURCES_RAW";

	public void setDataSources(java.util.Map<String, javax.sql.DataSource> dataSources) {
		java.util.Map<String, routines.system.TalendDataSource> talendDataSources = new java.util.HashMap<String, routines.system.TalendDataSource>();
		for (java.util.Map.Entry<String, javax.sql.DataSource> dataSourceEntry : dataSources.entrySet()) {
			talendDataSources.put(dataSourceEntry.getKey(), new routines.system.TalendDataSource(dataSourceEntry.getValue()));
		}
		globalMap.put(KEY_DB_DATASOURCES, talendDataSources);
		globalMap.put(KEY_DB_DATASOURCES_RAW, new java.util.HashMap<String, javax.sql.DataSource>(dataSources));
	}
	
	public void setDataSourceReferences(List serviceReferences) throws Exception{
		
		java.util.Map<String, routines.system.TalendDataSource> talendDataSources = new java.util.HashMap<String, routines.system.TalendDataSource>();
		java.util.Map<String, javax.sql.DataSource> dataSources = new java.util.HashMap<String, javax.sql.DataSource>();
		
		for (java.util.Map.Entry<String, javax.sql.DataSource> entry : BundleUtils.getServices(serviceReferences,  javax.sql.DataSource.class).entrySet()) {
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
	private String cLabel =  null;
	
	private String virtualComponentName = null;
	
	public void setVirtualComponentName (String virtualComponentName){
		this.virtualComponentName = virtualComponentName;
	}

	private TalendException(Exception e, String errorComponent, final java.util.Map<String, Object> globalMap) {
		this.currentComponent= errorComponent;
		this.globalMap = globalMap;
		this.e = e;
	}
	
	private TalendException(Exception e, String errorComponent, String errorComponentLabel, final java.util.Map<String, Object> globalMap) {
		this(e, errorComponent, globalMap);
		this.cLabel = errorComponentLabel;
	}

	public Exception getException() {
		return this.e;
	}

	public String getCurrentComponent() {
		return this.currentComponent;
	}

	
    public String getExceptionCauseMessage(Exception e){
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
			if(virtualComponentName!=null && currentComponent.indexOf(virtualComponentName+"_")==0){
				globalMap.put(virtualComponentName+"_ERROR_MESSAGE",getExceptionCauseMessage(e));
			}
			globalMap.put(currentComponent+"_ERROR_MESSAGE",getExceptionCauseMessage(e));
			System.err.println("Exception in component " + currentComponent + " (" + jobName + ")");
		}
		if (!(e instanceof TDieException)) {
			if(e instanceof TalendException){
				e.printStackTrace();
			} else {
				e.printStackTrace();
				e.printStackTrace(errorMessagePS);
				sql_staging_job.this.exception = e;
			}
		}
		if (!(e instanceof TalendException)) {
		try {
			for (java.lang.reflect.Method m : this.getClass().getEnclosingClass().getMethods()) {
				if (m.getName().compareTo(currentComponent + "_error") == 0) {
					m.invoke(sql_staging_job.this, new Object[] { e , currentComponent, globalMap});
					break;
				}
			}

			if(!(e instanceof TDieException)){
		if(enableLogStash) {
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

			public void tDBInput_2_error(Exception exception, String errorComponent, final java.util.Map<String, Object> globalMap) throws TalendException {
				
				end_Hash.put(errorComponent, System.currentTimeMillis());
				
				status = "failure";
				
					tDBInput_2_onSubJobError(exception, errorComponent, globalMap);
			}
			
			public void tMap_2_error(Exception exception, String errorComponent, final java.util.Map<String, Object> globalMap) throws TalendException {
				
				end_Hash.put(errorComponent, System.currentTimeMillis());
				
				status = "failure";
				
					tDBInput_2_onSubJobError(exception, errorComponent, globalMap);
			}
			
			public void tDBOutput_2_error(Exception exception, String errorComponent, final java.util.Map<String, Object> globalMap) throws TalendException {
				
				end_Hash.put(errorComponent, System.currentTimeMillis());
				
				status = "failure";
				
					tDBInput_2_onSubJobError(exception, errorComponent, globalMap);
			}
			
			public void tDBInput_1_error(Exception exception, String errorComponent, final java.util.Map<String, Object> globalMap) throws TalendException {
				
				end_Hash.put(errorComponent, System.currentTimeMillis());
				
				status = "failure";
				
					tDBInput_1_onSubJobError(exception, errorComponent, globalMap);
			}
			
			public void tMap_1_error(Exception exception, String errorComponent, final java.util.Map<String, Object> globalMap) throws TalendException {
				
				end_Hash.put(errorComponent, System.currentTimeMillis());
				
				status = "failure";
				
					tDBInput_1_onSubJobError(exception, errorComponent, globalMap);
			}
			
			public void tDBOutput_1_error(Exception exception, String errorComponent, final java.util.Map<String, Object> globalMap) throws TalendException {
				
				end_Hash.put(errorComponent, System.currentTimeMillis());
				
				status = "failure";
				
					tDBInput_1_onSubJobError(exception, errorComponent, globalMap);
			}
			
			public void tDBInput_3_error(Exception exception, String errorComponent, final java.util.Map<String, Object> globalMap) throws TalendException {
				
				end_Hash.put(errorComponent, System.currentTimeMillis());
				
				status = "failure";
				
					tDBInput_3_onSubJobError(exception, errorComponent, globalMap);
			}
			
			public void tMap_3_error(Exception exception, String errorComponent, final java.util.Map<String, Object> globalMap) throws TalendException {
				
				end_Hash.put(errorComponent, System.currentTimeMillis());
				
				status = "failure";
				
					tDBInput_3_onSubJobError(exception, errorComponent, globalMap);
			}
			
			public void tDBOutput_3_error(Exception exception, String errorComponent, final java.util.Map<String, Object> globalMap) throws TalendException {
				
				end_Hash.put(errorComponent, System.currentTimeMillis());
				
				status = "failure";
				
					tDBInput_3_onSubJobError(exception, errorComponent, globalMap);
			}
			
			public void tDBInput_4_error(Exception exception, String errorComponent, final java.util.Map<String, Object> globalMap) throws TalendException {
				
				end_Hash.put(errorComponent, System.currentTimeMillis());
				
				status = "failure";
				
					tDBInput_4_onSubJobError(exception, errorComponent, globalMap);
			}
			
			public void tMap_4_error(Exception exception, String errorComponent, final java.util.Map<String, Object> globalMap) throws TalendException {
				
				end_Hash.put(errorComponent, System.currentTimeMillis());
				
				status = "failure";
				
					tDBInput_4_onSubJobError(exception, errorComponent, globalMap);
			}
			
			public void tDBOutput_4_error(Exception exception, String errorComponent, final java.util.Map<String, Object> globalMap) throws TalendException {
				
				end_Hash.put(errorComponent, System.currentTimeMillis());
				
				status = "failure";
				
					tDBInput_4_onSubJobError(exception, errorComponent, globalMap);
			}
			
			public void tPrejob_1_error(Exception exception, String errorComponent, final java.util.Map<String, Object> globalMap) throws TalendException {
				
				end_Hash.put(errorComponent, System.currentTimeMillis());
				
				status = "failure";
				
					tPrejob_1_onSubJobError(exception, errorComponent, globalMap);
			}
			
			public void tRunJob_1_error(Exception exception, String errorComponent, final java.util.Map<String, Object> globalMap) throws TalendException {
				
				end_Hash.put(errorComponent, System.currentTimeMillis());
				
				status = "failure";
				
					tRunJob_1_onSubJobError(exception, errorComponent, globalMap);
			}
			
			public void tPostjob_1_error(Exception exception, String errorComponent, final java.util.Map<String, Object> globalMap) throws TalendException {
				
				end_Hash.put(errorComponent, System.currentTimeMillis());
				
				status = "failure";
				
					tPostjob_1_onSubJobError(exception, errorComponent, globalMap);
			}
			
			public void tRunJob_2_error(Exception exception, String errorComponent, final java.util.Map<String, Object> globalMap) throws TalendException {
				
				end_Hash.put(errorComponent, System.currentTimeMillis());
				
				status = "failure";
				
					tRunJob_2_onSubJobError(exception, errorComponent, globalMap);
			}
			
			public void talendJobLog_error(Exception exception, String errorComponent, final java.util.Map<String, Object> globalMap) throws TalendException {
				
				end_Hash.put(errorComponent, System.currentTimeMillis());
				
				status = "failure";
				
					talendJobLog_onSubJobError(exception, errorComponent, globalMap);
			}
			
			public void tDBInput_2_onSubJobError(Exception exception, String errorComponent, final java.util.Map<String, Object> globalMap) throws TalendException {

resumeUtil.addLog("SYSTEM_LOG", "NODE:"+ errorComponent, "", Thread.currentThread().getId()+ "", "FATAL", "", exception.getMessage(), ResumeUtil.getExceptionStackTrace(exception),"");

			}
			public void tDBInput_1_onSubJobError(Exception exception, String errorComponent, final java.util.Map<String, Object> globalMap) throws TalendException {

resumeUtil.addLog("SYSTEM_LOG", "NODE:"+ errorComponent, "", Thread.currentThread().getId()+ "", "FATAL", "", exception.getMessage(), ResumeUtil.getExceptionStackTrace(exception),"");

			}
			public void tDBInput_3_onSubJobError(Exception exception, String errorComponent, final java.util.Map<String, Object> globalMap) throws TalendException {

resumeUtil.addLog("SYSTEM_LOG", "NODE:"+ errorComponent, "", Thread.currentThread().getId()+ "", "FATAL", "", exception.getMessage(), ResumeUtil.getExceptionStackTrace(exception),"");

			}
			public void tDBInput_4_onSubJobError(Exception exception, String errorComponent, final java.util.Map<String, Object> globalMap) throws TalendException {

resumeUtil.addLog("SYSTEM_LOG", "NODE:"+ errorComponent, "", Thread.currentThread().getId()+ "", "FATAL", "", exception.getMessage(), ResumeUtil.getExceptionStackTrace(exception),"");

			}
			public void tPrejob_1_onSubJobError(Exception exception, String errorComponent, final java.util.Map<String, Object> globalMap) throws TalendException {

resumeUtil.addLog("SYSTEM_LOG", "NODE:"+ errorComponent, "", Thread.currentThread().getId()+ "", "FATAL", "", exception.getMessage(), ResumeUtil.getExceptionStackTrace(exception),"");

			}
			public void tRunJob_1_onSubJobError(Exception exception, String errorComponent, final java.util.Map<String, Object> globalMap) throws TalendException {

resumeUtil.addLog("SYSTEM_LOG", "NODE:"+ errorComponent, "", Thread.currentThread().getId()+ "", "FATAL", "", exception.getMessage(), ResumeUtil.getExceptionStackTrace(exception),"");

			}
			public void tPostjob_1_onSubJobError(Exception exception, String errorComponent, final java.util.Map<String, Object> globalMap) throws TalendException {

resumeUtil.addLog("SYSTEM_LOG", "NODE:"+ errorComponent, "", Thread.currentThread().getId()+ "", "FATAL", "", exception.getMessage(), ResumeUtil.getExceptionStackTrace(exception),"");

			}
			public void tRunJob_2_onSubJobError(Exception exception, String errorComponent, final java.util.Map<String, Object> globalMap) throws TalendException {

resumeUtil.addLog("SYSTEM_LOG", "NODE:"+ errorComponent, "", Thread.currentThread().getId()+ "", "FATAL", "", exception.getMessage(), ResumeUtil.getExceptionStackTrace(exception),"");

			}
			public void talendJobLog_onSubJobError(Exception exception, String errorComponent, final java.util.Map<String, Object> globalMap) throws TalendException {

resumeUtil.addLog("SYSTEM_LOG", "NODE:"+ errorComponent, "", Thread.currentThread().getId()+ "", "FATAL", "", exception.getMessage(), ResumeUtil.getExceptionStackTrace(exception),"");

			}
	



public static class copyOftoTableStruct implements routines.system.IPersistableRow<copyOftoTableStruct> {
    final static byte[] commonByteArrayLock_FINAL_PROJECT_sql_staging_job = new byte[0];
    static byte[] commonByteArray_FINAL_PROJECT_sql_staging_job = new byte[0];

	
			    public String tconst;

				public String getTconst () {
					return this.tconst;
				}

				public Boolean tconstIsNullable(){
				    return false;
				}
				public Boolean tconstIsKey(){
				    return false;
				}
				public Integer tconstLength(){
				    return 10;
				}
				public Integer tconstPrecision(){
				    return 0;
				}
				public String tconstDefault(){
				
					return null;
				
				}
				public String tconstComment(){
				
				    return "";
				
				}
				public String tconstPattern(){
				
					return "";
				
				}
				public String tconstOriginalDbColumnName(){
				
					return "tconst";
				
				}

				
			    public String titleType;

				public String getTitleType () {
					return this.titleType;
				}

				public Boolean titleTypeIsNullable(){
				    return true;
				}
				public Boolean titleTypeIsKey(){
				    return false;
				}
				public Integer titleTypeLength(){
				    return 255;
				}
				public Integer titleTypePrecision(){
				    return 0;
				}
				public String titleTypeDefault(){
				
					return null;
				
				}
				public String titleTypeComment(){
				
				    return "";
				
				}
				public String titleTypePattern(){
				
					return "";
				
				}
				public String titleTypeOriginalDbColumnName(){
				
					return "titleType";
				
				}

				
			    public String primaryTitle;

				public String getPrimaryTitle () {
					return this.primaryTitle;
				}

				public Boolean primaryTitleIsNullable(){
				    return true;
				}
				public Boolean primaryTitleIsKey(){
				    return false;
				}
				public Integer primaryTitleLength(){
				    return 1024;
				}
				public Integer primaryTitlePrecision(){
				    return 0;
				}
				public String primaryTitleDefault(){
				
					return null;
				
				}
				public String primaryTitleComment(){
				
				    return "";
				
				}
				public String primaryTitlePattern(){
				
					return "";
				
				}
				public String primaryTitleOriginalDbColumnName(){
				
					return "primaryTitle";
				
				}

				
			    public String originalTitle;

				public String getOriginalTitle () {
					return this.originalTitle;
				}

				public Boolean originalTitleIsNullable(){
				    return true;
				}
				public Boolean originalTitleIsKey(){
				    return false;
				}
				public Integer originalTitleLength(){
				    return 1024;
				}
				public Integer originalTitlePrecision(){
				    return 0;
				}
				public String originalTitleDefault(){
				
					return null;
				
				}
				public String originalTitleComment(){
				
				    return "";
				
				}
				public String originalTitlePattern(){
				
					return "";
				
				}
				public String originalTitleOriginalDbColumnName(){
				
					return "originalTitle";
				
				}

				
			    public Byte isAdult;

				public Byte getIsAdult () {
					return this.isAdult;
				}

				public Boolean isAdultIsNullable(){
				    return true;
				}
				public Boolean isAdultIsKey(){
				    return false;
				}
				public Integer isAdultLength(){
				    return 3;
				}
				public Integer isAdultPrecision(){
				    return 0;
				}
				public String isAdultDefault(){
				
					return "";
				
				}
				public String isAdultComment(){
				
				    return "";
				
				}
				public String isAdultPattern(){
				
					return "";
				
				}
				public String isAdultOriginalDbColumnName(){
				
					return "isAdult";
				
				}

				
			    public String startYear;

				public String getStartYear () {
					return this.startYear;
				}

				public Boolean startYearIsNullable(){
				    return true;
				}
				public Boolean startYearIsKey(){
				    return false;
				}
				public Integer startYearLength(){
				    return 4;
				}
				public Integer startYearPrecision(){
				    return 0;
				}
				public String startYearDefault(){
				
					return null;
				
				}
				public String startYearComment(){
				
				    return "";
				
				}
				public String startYearPattern(){
				
					return "";
				
				}
				public String startYearOriginalDbColumnName(){
				
					return "startYear";
				
				}

				
			    public String endYear;

				public String getEndYear () {
					return this.endYear;
				}

				public Boolean endYearIsNullable(){
				    return true;
				}
				public Boolean endYearIsKey(){
				    return false;
				}
				public Integer endYearLength(){
				    return 4;
				}
				public Integer endYearPrecision(){
				    return 0;
				}
				public String endYearDefault(){
				
					return null;
				
				}
				public String endYearComment(){
				
				    return "";
				
				}
				public String endYearPattern(){
				
					return "";
				
				}
				public String endYearOriginalDbColumnName(){
				
					return "endYear";
				
				}

				
			    public String runtimeMinutes;

				public String getRuntimeMinutes () {
					return this.runtimeMinutes;
				}

				public Boolean runtimeMinutesIsNullable(){
				    return true;
				}
				public Boolean runtimeMinutesIsKey(){
				    return false;
				}
				public Integer runtimeMinutesLength(){
				    return 10;
				}
				public Integer runtimeMinutesPrecision(){
				    return 0;
				}
				public String runtimeMinutesDefault(){
				
					return null;
				
				}
				public String runtimeMinutesComment(){
				
				    return "";
				
				}
				public String runtimeMinutesPattern(){
				
					return "";
				
				}
				public String runtimeMinutesOriginalDbColumnName(){
				
					return "runtimeMinutes";
				
				}

				
			    public String genres;

				public String getGenres () {
					return this.genres;
				}

				public Boolean genresIsNullable(){
				    return true;
				}
				public Boolean genresIsKey(){
				    return false;
				}
				public Integer genresLength(){
				    return 255;
				}
				public Integer genresPrecision(){
				    return 0;
				}
				public String genresDefault(){
				
					return null;
				
				}
				public String genresComment(){
				
				    return "";
				
				}
				public String genresPattern(){
				
					return "";
				
				}
				public String genresOriginalDbColumnName(){
				
					return "genres";
				
				}

				
			    public java.util.Date DI_Create_DT;

				public java.util.Date getDI_Create_DT () {
					return this.DI_Create_DT;
				}

				public Boolean DI_Create_DTIsNullable(){
				    return false;
				}
				public Boolean DI_Create_DTIsKey(){
				    return false;
				}
				public Integer DI_Create_DTLength(){
				    return 19;
				}
				public Integer DI_Create_DTPrecision(){
				    return 0;
				}
				public String DI_Create_DTDefault(){
				
					return null;
				
				}
				public String DI_Create_DTComment(){
				
				    return "";
				
				}
				public String DI_Create_DTPattern(){
				
					return "dd-MM-yyyy";
				
				}
				public String DI_Create_DTOriginalDbColumnName(){
				
					return "DI_Create_DT";
				
				}

				
			    public String DI_WorkflowJobId;

				public String getDI_WorkflowJobId () {
					return this.DI_WorkflowJobId;
				}

				public Boolean DI_WorkflowJobIdIsNullable(){
				    return true;
				}
				public Boolean DI_WorkflowJobIdIsKey(){
				    return false;
				}
				public Integer DI_WorkflowJobIdLength(){
				    return 8;
				}
				public Integer DI_WorkflowJobIdPrecision(){
				    return null;
				}
				public String DI_WorkflowJobIdDefault(){
				
					return null;
				
				}
				public String DI_WorkflowJobIdComment(){
				
				    return "";
				
				}
				public String DI_WorkflowJobIdPattern(){
				
					return "";
				
				}
				public String DI_WorkflowJobIdOriginalDbColumnName(){
				
					return "DI_WorkflowJobId";
				
				}

				



	private String readString(ObjectInputStream dis) throws IOException{
		String strReturn = null;
		int length = 0;
        length = dis.readInt();
		if (length == -1) {
			strReturn = null;
		} else {
			if(length > commonByteArray_FINAL_PROJECT_sql_staging_job.length) {
				if(length < 1024 && commonByteArray_FINAL_PROJECT_sql_staging_job.length == 0) {
   					commonByteArray_FINAL_PROJECT_sql_staging_job = new byte[1024];
				} else {
   					commonByteArray_FINAL_PROJECT_sql_staging_job = new byte[2 * length];
   				}
			}
			dis.readFully(commonByteArray_FINAL_PROJECT_sql_staging_job, 0, length);
			strReturn = new String(commonByteArray_FINAL_PROJECT_sql_staging_job, 0, length, utf8Charset);
		}
		return strReturn;
	}
	
	private String readString(org.jboss.marshalling.Unmarshaller unmarshaller) throws IOException{
		String strReturn = null;
		int length = 0;
        length = unmarshaller.readInt();
		if (length == -1) {
			strReturn = null;
		} else {
			if(length > commonByteArray_FINAL_PROJECT_sql_staging_job.length) {
				if(length < 1024 && commonByteArray_FINAL_PROJECT_sql_staging_job.length == 0) {
   					commonByteArray_FINAL_PROJECT_sql_staging_job = new byte[1024];
				} else {
   					commonByteArray_FINAL_PROJECT_sql_staging_job = new byte[2 * length];
   				}
			}
			unmarshaller.readFully(commonByteArray_FINAL_PROJECT_sql_staging_job, 0, length);
			strReturn = new String(commonByteArray_FINAL_PROJECT_sql_staging_job, 0, length, utf8Charset);
		}
		return strReturn;
	}

    private void writeString(String str, ObjectOutputStream dos) throws IOException{
		if(str == null) {
            dos.writeInt(-1);
		} else {
            byte[] byteArray = str.getBytes(utf8Charset);
	    	dos.writeInt(byteArray.length);
			dos.write(byteArray);
    	}
    }
    
    private void writeString(String str, org.jboss.marshalling.Marshaller marshaller) throws IOException{
		if(str == null) {
			marshaller.writeInt(-1);
		} else {
            byte[] byteArray = str.getBytes(utf8Charset);
            marshaller.writeInt(byteArray.length);
            marshaller.write(byteArray);
    	}
    }

	private java.util.Date readDate(ObjectInputStream dis) throws IOException{
		java.util.Date dateReturn = null;
        int length = 0;
        length = dis.readByte();
		if (length == -1) {
			dateReturn = null;
		} else {
	    	dateReturn = new Date(dis.readLong());
		}
		return dateReturn;
	}
	
	private java.util.Date readDate(org.jboss.marshalling.Unmarshaller unmarshaller) throws IOException{
		java.util.Date dateReturn = null;
        int length = 0;
        length = unmarshaller.readByte();
		if (length == -1) {
			dateReturn = null;
		} else {
	    	dateReturn = new Date(unmarshaller.readLong());
		}
		return dateReturn;
	}

    private void writeDate(java.util.Date date1, ObjectOutputStream dos) throws IOException{
		if(date1 == null) {
            dos.writeByte(-1);
		} else {
			dos.writeByte(0);
	    	dos.writeLong(date1.getTime());
    	}
    }
    
    private void writeDate(java.util.Date date1, org.jboss.marshalling.Marshaller marshaller) throws IOException{
		if(date1 == null) {
			marshaller.writeByte(-1);
		} else {
			marshaller.writeByte(0);
			marshaller.writeLong(date1.getTime());
    	}
    }

    public void readData(ObjectInputStream dis) {

		synchronized(commonByteArrayLock_FINAL_PROJECT_sql_staging_job) {

        	try {

        		int length = 0;
		
					this.tconst = readString(dis);
					
					this.titleType = readString(dis);
					
					this.primaryTitle = readString(dis);
					
					this.originalTitle = readString(dis);
					
			            length = dis.readByte();
           				if (length == -1) {
           	    			this.isAdult = null;
           				} else {
           			    	this.isAdult = dis.readByte();
           				}
					
					this.startYear = readString(dis);
					
					this.endYear = readString(dis);
					
					this.runtimeMinutes = readString(dis);
					
					this.genres = readString(dis);
					
					this.DI_Create_DT = readDate(dis);
					
					this.DI_WorkflowJobId = readString(dis);
					
        	} catch (IOException e) {
	            throw new RuntimeException(e);

		

        }

		

      }


    }
    
    public void readData(org.jboss.marshalling.Unmarshaller dis) {

		synchronized(commonByteArrayLock_FINAL_PROJECT_sql_staging_job) {

        	try {

        		int length = 0;
		
					this.tconst = readString(dis);
					
					this.titleType = readString(dis);
					
					this.primaryTitle = readString(dis);
					
					this.originalTitle = readString(dis);
					
			            length = dis.readByte();
           				if (length == -1) {
           	    			this.isAdult = null;
           				} else {
           			    	this.isAdult = dis.readByte();
           				}
					
					this.startYear = readString(dis);
					
					this.endYear = readString(dis);
					
					this.runtimeMinutes = readString(dis);
					
					this.genres = readString(dis);
					
					this.DI_Create_DT = readDate(dis);
					
					this.DI_WorkflowJobId = readString(dis);
					
        	} catch (IOException e) {
	            throw new RuntimeException(e);

		

        }

		

      }


    }

    public void writeData(ObjectOutputStream dos) {
        try {

		
					// String
				
						writeString(this.tconst,dos);
					
					// String
				
						writeString(this.titleType,dos);
					
					// String
				
						writeString(this.primaryTitle,dos);
					
					// String
				
						writeString(this.originalTitle,dos);
					
					// Byte
				
						if(this.isAdult == null) {
			                dos.writeByte(-1);
						} else {
               				dos.writeByte(0);
           			    	dos.writeByte(this.isAdult);
		            	}
					
					// String
				
						writeString(this.startYear,dos);
					
					// String
				
						writeString(this.endYear,dos);
					
					// String
				
						writeString(this.runtimeMinutes,dos);
					
					// String
				
						writeString(this.genres,dos);
					
					// java.util.Date
				
						writeDate(this.DI_Create_DT,dos);
					
					// String
				
						writeString(this.DI_WorkflowJobId,dos);
					
        	} catch (IOException e) {
	            throw new RuntimeException(e);
        }


    }
    
    public void writeData(org.jboss.marshalling.Marshaller dos) {
        try {

		
					// String
				
						writeString(this.tconst,dos);
					
					// String
				
						writeString(this.titleType,dos);
					
					// String
				
						writeString(this.primaryTitle,dos);
					
					// String
				
						writeString(this.originalTitle,dos);
					
					// Byte
				
						if(this.isAdult == null) {
			                dos.writeByte(-1);
						} else {
               				dos.writeByte(0);
           			    	dos.writeByte(this.isAdult);
		            	}
					
					// String
				
						writeString(this.startYear,dos);
					
					// String
				
						writeString(this.endYear,dos);
					
					// String
				
						writeString(this.runtimeMinutes,dos);
					
					// String
				
						writeString(this.genres,dos);
					
					// java.util.Date
				
						writeDate(this.DI_Create_DT,dos);
					
					// String
				
						writeString(this.DI_WorkflowJobId,dos);
					
        	} catch (IOException e) {
	            throw new RuntimeException(e);
        }


    }


    public String toString() {

		StringBuilder sb = new StringBuilder();
		sb.append(super.toString());
		sb.append("[");
		sb.append("tconst="+tconst);
		sb.append(",titleType="+titleType);
		sb.append(",primaryTitle="+primaryTitle);
		sb.append(",originalTitle="+originalTitle);
		sb.append(",isAdult="+String.valueOf(isAdult));
		sb.append(",startYear="+startYear);
		sb.append(",endYear="+endYear);
		sb.append(",runtimeMinutes="+runtimeMinutes);
		sb.append(",genres="+genres);
		sb.append(",DI_Create_DT="+String.valueOf(DI_Create_DT));
		sb.append(",DI_WorkflowJobId="+DI_WorkflowJobId);
	    sb.append("]");

	    return sb.toString();
    }
        public String toLogString(){
        	StringBuilder sb = new StringBuilder();
        	
        				if(tconst == null){
        					sb.append("<null>");
        				}else{
            				sb.append(tconst);
            			}
            		
        			sb.append("|");
        		
        				if(titleType == null){
        					sb.append("<null>");
        				}else{
            				sb.append(titleType);
            			}
            		
        			sb.append("|");
        		
        				if(primaryTitle == null){
        					sb.append("<null>");
        				}else{
            				sb.append(primaryTitle);
            			}
            		
        			sb.append("|");
        		
        				if(originalTitle == null){
        					sb.append("<null>");
        				}else{
            				sb.append(originalTitle);
            			}
            		
        			sb.append("|");
        		
        				if(isAdult == null){
        					sb.append("<null>");
        				}else{
            				sb.append(isAdult);
            			}
            		
        			sb.append("|");
        		
        				if(startYear == null){
        					sb.append("<null>");
        				}else{
            				sb.append(startYear);
            			}
            		
        			sb.append("|");
        		
        				if(endYear == null){
        					sb.append("<null>");
        				}else{
            				sb.append(endYear);
            			}
            		
        			sb.append("|");
        		
        				if(runtimeMinutes == null){
        					sb.append("<null>");
        				}else{
            				sb.append(runtimeMinutes);
            			}
            		
        			sb.append("|");
        		
        				if(genres == null){
        					sb.append("<null>");
        				}else{
            				sb.append(genres);
            			}
            		
        			sb.append("|");
        		
        				if(DI_Create_DT == null){
        					sb.append("<null>");
        				}else{
            				sb.append(DI_Create_DT);
            			}
            		
        			sb.append("|");
        		
        				if(DI_WorkflowJobId == null){
        					sb.append("<null>");
        				}else{
            				sb.append(DI_WorkflowJobId);
            			}
            		
        			sb.append("|");
        		
        	return sb.toString();
        }

    /**
     * Compare keys
     */
    public int compareTo(copyOftoTableStruct other) {

		int returnValue = -1;
		
	    return returnValue;
    }


    private int checkNullsAndCompare(Object object1, Object object2) {
        int returnValue = 0;
		if (object1 instanceof Comparable && object2 instanceof Comparable) {
            returnValue = ((Comparable) object1).compareTo(object2);
        } else if (object1 != null && object2 != null) {
            returnValue = compareStrings(object1.toString(), object2.toString());
        } else if (object1 == null && object2 != null) {
            returnValue = 1;
        } else if (object1 != null && object2 == null) {
            returnValue = -1;
        } else {
            returnValue = 0;
        }

        return returnValue;
    }

    private int compareStrings(String string1, String string2) {
        return string1.compareTo(string2);
    }


}

public static class row2Struct implements routines.system.IPersistableRow<row2Struct> {
    final static byte[] commonByteArrayLock_FINAL_PROJECT_sql_staging_job = new byte[0];
    static byte[] commonByteArray_FINAL_PROJECT_sql_staging_job = new byte[0];

	
			    public String tconst;

				public String getTconst () {
					return this.tconst;
				}

				public Boolean tconstIsNullable(){
				    return false;
				}
				public Boolean tconstIsKey(){
				    return false;
				}
				public Integer tconstLength(){
				    return 10;
				}
				public Integer tconstPrecision(){
				    return 0;
				}
				public String tconstDefault(){
				
					return null;
				
				}
				public String tconstComment(){
				
				    return "";
				
				}
				public String tconstPattern(){
				
					return "";
				
				}
				public String tconstOriginalDbColumnName(){
				
					return "tconst";
				
				}

				
			    public String titleType;

				public String getTitleType () {
					return this.titleType;
				}

				public Boolean titleTypeIsNullable(){
				    return true;
				}
				public Boolean titleTypeIsKey(){
				    return false;
				}
				public Integer titleTypeLength(){
				    return 255;
				}
				public Integer titleTypePrecision(){
				    return 0;
				}
				public String titleTypeDefault(){
				
					return null;
				
				}
				public String titleTypeComment(){
				
				    return "";
				
				}
				public String titleTypePattern(){
				
					return "";
				
				}
				public String titleTypeOriginalDbColumnName(){
				
					return "titleType";
				
				}

				
			    public String primaryTitle;

				public String getPrimaryTitle () {
					return this.primaryTitle;
				}

				public Boolean primaryTitleIsNullable(){
				    return true;
				}
				public Boolean primaryTitleIsKey(){
				    return false;
				}
				public Integer primaryTitleLength(){
				    return 1024;
				}
				public Integer primaryTitlePrecision(){
				    return 0;
				}
				public String primaryTitleDefault(){
				
					return null;
				
				}
				public String primaryTitleComment(){
				
				    return "";
				
				}
				public String primaryTitlePattern(){
				
					return "";
				
				}
				public String primaryTitleOriginalDbColumnName(){
				
					return "primaryTitle";
				
				}

				
			    public String originalTitle;

				public String getOriginalTitle () {
					return this.originalTitle;
				}

				public Boolean originalTitleIsNullable(){
				    return true;
				}
				public Boolean originalTitleIsKey(){
				    return false;
				}
				public Integer originalTitleLength(){
				    return 1024;
				}
				public Integer originalTitlePrecision(){
				    return 0;
				}
				public String originalTitleDefault(){
				
					return null;
				
				}
				public String originalTitleComment(){
				
				    return "";
				
				}
				public String originalTitlePattern(){
				
					return "";
				
				}
				public String originalTitleOriginalDbColumnName(){
				
					return "originalTitle";
				
				}

				
			    public Byte isAdult;

				public Byte getIsAdult () {
					return this.isAdult;
				}

				public Boolean isAdultIsNullable(){
				    return true;
				}
				public Boolean isAdultIsKey(){
				    return false;
				}
				public Integer isAdultLength(){
				    return 3;
				}
				public Integer isAdultPrecision(){
				    return 0;
				}
				public String isAdultDefault(){
				
					return "";
				
				}
				public String isAdultComment(){
				
				    return "";
				
				}
				public String isAdultPattern(){
				
					return "";
				
				}
				public String isAdultOriginalDbColumnName(){
				
					return "isAdult";
				
				}

				
			    public String startYear;

				public String getStartYear () {
					return this.startYear;
				}

				public Boolean startYearIsNullable(){
				    return true;
				}
				public Boolean startYearIsKey(){
				    return false;
				}
				public Integer startYearLength(){
				    return 4;
				}
				public Integer startYearPrecision(){
				    return 0;
				}
				public String startYearDefault(){
				
					return null;
				
				}
				public String startYearComment(){
				
				    return "";
				
				}
				public String startYearPattern(){
				
					return "";
				
				}
				public String startYearOriginalDbColumnName(){
				
					return "startYear";
				
				}

				
			    public String endYear;

				public String getEndYear () {
					return this.endYear;
				}

				public Boolean endYearIsNullable(){
				    return true;
				}
				public Boolean endYearIsKey(){
				    return false;
				}
				public Integer endYearLength(){
				    return 4;
				}
				public Integer endYearPrecision(){
				    return 0;
				}
				public String endYearDefault(){
				
					return null;
				
				}
				public String endYearComment(){
				
				    return "";
				
				}
				public String endYearPattern(){
				
					return "";
				
				}
				public String endYearOriginalDbColumnName(){
				
					return "endYear";
				
				}

				
			    public String runtimeMinutes;

				public String getRuntimeMinutes () {
					return this.runtimeMinutes;
				}

				public Boolean runtimeMinutesIsNullable(){
				    return true;
				}
				public Boolean runtimeMinutesIsKey(){
				    return false;
				}
				public Integer runtimeMinutesLength(){
				    return 10;
				}
				public Integer runtimeMinutesPrecision(){
				    return 0;
				}
				public String runtimeMinutesDefault(){
				
					return null;
				
				}
				public String runtimeMinutesComment(){
				
				    return "";
				
				}
				public String runtimeMinutesPattern(){
				
					return "";
				
				}
				public String runtimeMinutesOriginalDbColumnName(){
				
					return "runtimeMinutes";
				
				}

				
			    public String genres;

				public String getGenres () {
					return this.genres;
				}

				public Boolean genresIsNullable(){
				    return true;
				}
				public Boolean genresIsKey(){
				    return false;
				}
				public Integer genresLength(){
				    return 255;
				}
				public Integer genresPrecision(){
				    return 0;
				}
				public String genresDefault(){
				
					return null;
				
				}
				public String genresComment(){
				
				    return "";
				
				}
				public String genresPattern(){
				
					return "";
				
				}
				public String genresOriginalDbColumnName(){
				
					return "genres";
				
				}

				
			    public java.util.Date DI_Create_DT;

				public java.util.Date getDI_Create_DT () {
					return this.DI_Create_DT;
				}

				public Boolean DI_Create_DTIsNullable(){
				    return false;
				}
				public Boolean DI_Create_DTIsKey(){
				    return false;
				}
				public Integer DI_Create_DTLength(){
				    return 19;
				}
				public Integer DI_Create_DTPrecision(){
				    return 0;
				}
				public String DI_Create_DTDefault(){
				
					return null;
				
				}
				public String DI_Create_DTComment(){
				
				    return "";
				
				}
				public String DI_Create_DTPattern(){
				
					return "dd-MM-yyyy";
				
				}
				public String DI_Create_DTOriginalDbColumnName(){
				
					return "DI_Create_DT";
				
				}

				



	private String readString(ObjectInputStream dis) throws IOException{
		String strReturn = null;
		int length = 0;
        length = dis.readInt();
		if (length == -1) {
			strReturn = null;
		} else {
			if(length > commonByteArray_FINAL_PROJECT_sql_staging_job.length) {
				if(length < 1024 && commonByteArray_FINAL_PROJECT_sql_staging_job.length == 0) {
   					commonByteArray_FINAL_PROJECT_sql_staging_job = new byte[1024];
				} else {
   					commonByteArray_FINAL_PROJECT_sql_staging_job = new byte[2 * length];
   				}
			}
			dis.readFully(commonByteArray_FINAL_PROJECT_sql_staging_job, 0, length);
			strReturn = new String(commonByteArray_FINAL_PROJECT_sql_staging_job, 0, length, utf8Charset);
		}
		return strReturn;
	}
	
	private String readString(org.jboss.marshalling.Unmarshaller unmarshaller) throws IOException{
		String strReturn = null;
		int length = 0;
        length = unmarshaller.readInt();
		if (length == -1) {
			strReturn = null;
		} else {
			if(length > commonByteArray_FINAL_PROJECT_sql_staging_job.length) {
				if(length < 1024 && commonByteArray_FINAL_PROJECT_sql_staging_job.length == 0) {
   					commonByteArray_FINAL_PROJECT_sql_staging_job = new byte[1024];
				} else {
   					commonByteArray_FINAL_PROJECT_sql_staging_job = new byte[2 * length];
   				}
			}
			unmarshaller.readFully(commonByteArray_FINAL_PROJECT_sql_staging_job, 0, length);
			strReturn = new String(commonByteArray_FINAL_PROJECT_sql_staging_job, 0, length, utf8Charset);
		}
		return strReturn;
	}

    private void writeString(String str, ObjectOutputStream dos) throws IOException{
		if(str == null) {
            dos.writeInt(-1);
		} else {
            byte[] byteArray = str.getBytes(utf8Charset);
	    	dos.writeInt(byteArray.length);
			dos.write(byteArray);
    	}
    }
    
    private void writeString(String str, org.jboss.marshalling.Marshaller marshaller) throws IOException{
		if(str == null) {
			marshaller.writeInt(-1);
		} else {
            byte[] byteArray = str.getBytes(utf8Charset);
            marshaller.writeInt(byteArray.length);
            marshaller.write(byteArray);
    	}
    }

	private java.util.Date readDate(ObjectInputStream dis) throws IOException{
		java.util.Date dateReturn = null;
        int length = 0;
        length = dis.readByte();
		if (length == -1) {
			dateReturn = null;
		} else {
	    	dateReturn = new Date(dis.readLong());
		}
		return dateReturn;
	}
	
	private java.util.Date readDate(org.jboss.marshalling.Unmarshaller unmarshaller) throws IOException{
		java.util.Date dateReturn = null;
        int length = 0;
        length = unmarshaller.readByte();
		if (length == -1) {
			dateReturn = null;
		} else {
	    	dateReturn = new Date(unmarshaller.readLong());
		}
		return dateReturn;
	}

    private void writeDate(java.util.Date date1, ObjectOutputStream dos) throws IOException{
		if(date1 == null) {
            dos.writeByte(-1);
		} else {
			dos.writeByte(0);
	    	dos.writeLong(date1.getTime());
    	}
    }
    
    private void writeDate(java.util.Date date1, org.jboss.marshalling.Marshaller marshaller) throws IOException{
		if(date1 == null) {
			marshaller.writeByte(-1);
		} else {
			marshaller.writeByte(0);
			marshaller.writeLong(date1.getTime());
    	}
    }

    public void readData(ObjectInputStream dis) {

		synchronized(commonByteArrayLock_FINAL_PROJECT_sql_staging_job) {

        	try {

        		int length = 0;
		
					this.tconst = readString(dis);
					
					this.titleType = readString(dis);
					
					this.primaryTitle = readString(dis);
					
					this.originalTitle = readString(dis);
					
			            length = dis.readByte();
           				if (length == -1) {
           	    			this.isAdult = null;
           				} else {
           			    	this.isAdult = dis.readByte();
           				}
					
					this.startYear = readString(dis);
					
					this.endYear = readString(dis);
					
					this.runtimeMinutes = readString(dis);
					
					this.genres = readString(dis);
					
					this.DI_Create_DT = readDate(dis);
					
        	} catch (IOException e) {
	            throw new RuntimeException(e);

		

        }

		

      }


    }
    
    public void readData(org.jboss.marshalling.Unmarshaller dis) {

		synchronized(commonByteArrayLock_FINAL_PROJECT_sql_staging_job) {

        	try {

        		int length = 0;
		
					this.tconst = readString(dis);
					
					this.titleType = readString(dis);
					
					this.primaryTitle = readString(dis);
					
					this.originalTitle = readString(dis);
					
			            length = dis.readByte();
           				if (length == -1) {
           	    			this.isAdult = null;
           				} else {
           			    	this.isAdult = dis.readByte();
           				}
					
					this.startYear = readString(dis);
					
					this.endYear = readString(dis);
					
					this.runtimeMinutes = readString(dis);
					
					this.genres = readString(dis);
					
					this.DI_Create_DT = readDate(dis);
					
        	} catch (IOException e) {
	            throw new RuntimeException(e);

		

        }

		

      }


    }

    public void writeData(ObjectOutputStream dos) {
        try {

		
					// String
				
						writeString(this.tconst,dos);
					
					// String
				
						writeString(this.titleType,dos);
					
					// String
				
						writeString(this.primaryTitle,dos);
					
					// String
				
						writeString(this.originalTitle,dos);
					
					// Byte
				
						if(this.isAdult == null) {
			                dos.writeByte(-1);
						} else {
               				dos.writeByte(0);
           			    	dos.writeByte(this.isAdult);
		            	}
					
					// String
				
						writeString(this.startYear,dos);
					
					// String
				
						writeString(this.endYear,dos);
					
					// String
				
						writeString(this.runtimeMinutes,dos);
					
					// String
				
						writeString(this.genres,dos);
					
					// java.util.Date
				
						writeDate(this.DI_Create_DT,dos);
					
        	} catch (IOException e) {
	            throw new RuntimeException(e);
        }


    }
    
    public void writeData(org.jboss.marshalling.Marshaller dos) {
        try {

		
					// String
				
						writeString(this.tconst,dos);
					
					// String
				
						writeString(this.titleType,dos);
					
					// String
				
						writeString(this.primaryTitle,dos);
					
					// String
				
						writeString(this.originalTitle,dos);
					
					// Byte
				
						if(this.isAdult == null) {
			                dos.writeByte(-1);
						} else {
               				dos.writeByte(0);
           			    	dos.writeByte(this.isAdult);
		            	}
					
					// String
				
						writeString(this.startYear,dos);
					
					// String
				
						writeString(this.endYear,dos);
					
					// String
				
						writeString(this.runtimeMinutes,dos);
					
					// String
				
						writeString(this.genres,dos);
					
					// java.util.Date
				
						writeDate(this.DI_Create_DT,dos);
					
        	} catch (IOException e) {
	            throw new RuntimeException(e);
        }


    }


    public String toString() {

		StringBuilder sb = new StringBuilder();
		sb.append(super.toString());
		sb.append("[");
		sb.append("tconst="+tconst);
		sb.append(",titleType="+titleType);
		sb.append(",primaryTitle="+primaryTitle);
		sb.append(",originalTitle="+originalTitle);
		sb.append(",isAdult="+String.valueOf(isAdult));
		sb.append(",startYear="+startYear);
		sb.append(",endYear="+endYear);
		sb.append(",runtimeMinutes="+runtimeMinutes);
		sb.append(",genres="+genres);
		sb.append(",DI_Create_DT="+String.valueOf(DI_Create_DT));
	    sb.append("]");

	    return sb.toString();
    }
        public String toLogString(){
        	StringBuilder sb = new StringBuilder();
        	
        				if(tconst == null){
        					sb.append("<null>");
        				}else{
            				sb.append(tconst);
            			}
            		
        			sb.append("|");
        		
        				if(titleType == null){
        					sb.append("<null>");
        				}else{
            				sb.append(titleType);
            			}
            		
        			sb.append("|");
        		
        				if(primaryTitle == null){
        					sb.append("<null>");
        				}else{
            				sb.append(primaryTitle);
            			}
            		
        			sb.append("|");
        		
        				if(originalTitle == null){
        					sb.append("<null>");
        				}else{
            				sb.append(originalTitle);
            			}
            		
        			sb.append("|");
        		
        				if(isAdult == null){
        					sb.append("<null>");
        				}else{
            				sb.append(isAdult);
            			}
            		
        			sb.append("|");
        		
        				if(startYear == null){
        					sb.append("<null>");
        				}else{
            				sb.append(startYear);
            			}
            		
        			sb.append("|");
        		
        				if(endYear == null){
        					sb.append("<null>");
        				}else{
            				sb.append(endYear);
            			}
            		
        			sb.append("|");
        		
        				if(runtimeMinutes == null){
        					sb.append("<null>");
        				}else{
            				sb.append(runtimeMinutes);
            			}
            		
        			sb.append("|");
        		
        				if(genres == null){
        					sb.append("<null>");
        				}else{
            				sb.append(genres);
            			}
            		
        			sb.append("|");
        		
        				if(DI_Create_DT == null){
        					sb.append("<null>");
        				}else{
            				sb.append(DI_Create_DT);
            			}
            		
        			sb.append("|");
        		
        	return sb.toString();
        }

    /**
     * Compare keys
     */
    public int compareTo(row2Struct other) {

		int returnValue = -1;
		
	    return returnValue;
    }


    private int checkNullsAndCompare(Object object1, Object object2) {
        int returnValue = 0;
		if (object1 instanceof Comparable && object2 instanceof Comparable) {
            returnValue = ((Comparable) object1).compareTo(object2);
        } else if (object1 != null && object2 != null) {
            returnValue = compareStrings(object1.toString(), object2.toString());
        } else if (object1 == null && object2 != null) {
            returnValue = 1;
        } else if (object1 != null && object2 == null) {
            returnValue = -1;
        } else {
            returnValue = 0;
        }

        return returnValue;
    }

    private int compareStrings(String string1, String string2) {
        return string1.compareTo(string2);
    }


}

public void tDBInput_2Process(final java.util.Map<String, Object> globalMap) throws TalendException {
	globalMap.put("tDBInput_2_SUBPROCESS_STATE", 0);

 final boolean execStat = this.execStat;
	
		mdcInfo.forEach(org.slf4j.MDC::put);
		org.slf4j.MDC.put("_subJobName", "tDBInput_2");
		org.slf4j.MDC.put("_subJobPid", "MxYBKY_" + subJobPidCounter.getAndIncrement());
	

	
		String iterateId = "";
	
	
	String currentComponent = "";
	String cLabel =  null;
	java.util.Map<String, Object> resourceMap = new java.util.HashMap<String, Object>();

	try {
			// TDI-39566 avoid throwing an useless Exception
			boolean resumeIt = true;
			if (globalResumeTicket == false && resumeEntryMethodName != null) {
				String currentMethodName = new java.lang.Exception().getStackTrace()[0].getMethodName();
				resumeIt = resumeEntryMethodName.equals(currentMethodName);
			}
			if (resumeIt || globalResumeTicket) { //start the resume
				globalResumeTicket = true;



		row2Struct row2 = new row2Struct();
copyOftoTableStruct copyOftoTable = new copyOftoTableStruct();





	
	/**
	 * [tDBOutput_2 begin ] start
	 */

	

	
		
		ok_Hash.put("tDBOutput_2", false);
		start_Hash.put("tDBOutput_2", System.currentTimeMillis());
		
	
	currentComponent="tDBOutput_2";
	
	
			cLabel="stg_movie_details";
		
			runStat.updateStatAndLog(execStat,enableLogStash,resourceMap,iterateId,0,0,"copyOftoTable");
			
		int tos_count_tDBOutput_2 = 0;
		
                if(log.isDebugEnabled())
            log.debug("tDBOutput_2 - "  + ("Start to work.") );
            if (log.isDebugEnabled()) {
                class BytesLimit65535_tDBOutput_2{
                    public void limitLog4jByte() throws Exception{
                    StringBuilder log4jParamters_tDBOutput_2 = new StringBuilder();
                    log4jParamters_tDBOutput_2.append("Parameters:");
                            log4jParamters_tDBOutput_2.append("DB_VERSION" + " = " + "MYSQL_8");
                        log4jParamters_tDBOutput_2.append(" | ");
                            log4jParamters_tDBOutput_2.append("USE_EXISTING_CONNECTION" + " = " + "false");
                        log4jParamters_tDBOutput_2.append(" | ");
                            log4jParamters_tDBOutput_2.append("HOST" + " = " + "context.MySqlLocal_Server");
                        log4jParamters_tDBOutput_2.append(" | ");
                            log4jParamters_tDBOutput_2.append("PORT" + " = " + "context.MySqlLocal_Port");
                        log4jParamters_tDBOutput_2.append(" | ");
                            log4jParamters_tDBOutput_2.append("DBNAME" + " = " + "context.MySqlLocal_Database");
                        log4jParamters_tDBOutput_2.append(" | ");
                            log4jParamters_tDBOutput_2.append("USER" + " = " + "context.MySqlLocal_Login");
                        log4jParamters_tDBOutput_2.append(" | ");
                            log4jParamters_tDBOutput_2.append("PASS" + " = " + String.valueOf(routines.system.PasswordEncryptUtil.encryptPassword(context.MySqlLocal_Password)).substring(0, 4) + "...");     
                        log4jParamters_tDBOutput_2.append(" | ");
                            log4jParamters_tDBOutput_2.append("TABLE" + " = " + "\"stg_movie_details\"");
                        log4jParamters_tDBOutput_2.append(" | ");
                            log4jParamters_tDBOutput_2.append("TABLE_ACTION" + " = " + "CREATE_IF_NOT_EXISTS");
                        log4jParamters_tDBOutput_2.append(" | ");
                            log4jParamters_tDBOutput_2.append("DATA_ACTION" + " = " + "INSERT");
                        log4jParamters_tDBOutput_2.append(" | ");
                            log4jParamters_tDBOutput_2.append("SPECIFY_DATASOURCE_ALIAS" + " = " + "false");
                        log4jParamters_tDBOutput_2.append(" | ");
                            log4jParamters_tDBOutput_2.append("DIE_ON_ERROR" + " = " + "false");
                        log4jParamters_tDBOutput_2.append(" | ");
                            log4jParamters_tDBOutput_2.append("PROPERTIES" + " = " + "context.MySqlLocal_AdditionalParams");
                        log4jParamters_tDBOutput_2.append(" | ");
                            log4jParamters_tDBOutput_2.append("EXTENDINSERT" + " = " + "true");
                        log4jParamters_tDBOutput_2.append(" | ");
                            log4jParamters_tDBOutput_2.append("NB_ROWS_PER_INSERT" + " = " + "100");
                        log4jParamters_tDBOutput_2.append(" | ");
                            log4jParamters_tDBOutput_2.append("COMMIT_EVERY" + " = " + "10000");
                        log4jParamters_tDBOutput_2.append(" | ");
                            log4jParamters_tDBOutput_2.append("ADD_COLS" + " = " + "[]");
                        log4jParamters_tDBOutput_2.append(" | ");
                            log4jParamters_tDBOutput_2.append("USE_FIELD_OPTIONS" + " = " + "false");
                        log4jParamters_tDBOutput_2.append(" | ");
                            log4jParamters_tDBOutput_2.append("USE_HINT_OPTIONS" + " = " + "false");
                        log4jParamters_tDBOutput_2.append(" | ");
                            log4jParamters_tDBOutput_2.append("ENABLE_DEBUG_MODE" + " = " + "false");
                        log4jParamters_tDBOutput_2.append(" | ");
                            log4jParamters_tDBOutput_2.append("ON_DUPLICATE_KEY_UPDATE" + " = " + "false");
                        log4jParamters_tDBOutput_2.append(" | ");
                            log4jParamters_tDBOutput_2.append("UNIFIED_COMPONENTS" + " = " + "tMysqlOutput");
                        log4jParamters_tDBOutput_2.append(" | ");
                if(log.isDebugEnabled())
            log.debug("tDBOutput_2 - "  + (log4jParamters_tDBOutput_2) );
                    } 
                } 
            new BytesLimit65535_tDBOutput_2().limitLog4jByte();
            }
			if(enableLogStash) {
				talendJobLog.addCM("tDBOutput_2", "stg_movie_details", "tMysqlOutput");
				talendJobLogProcess(globalMap);
			}
			







int nb_line_tDBOutput_2 = 0;
int nb_line_update_tDBOutput_2 = 0;
int nb_line_inserted_tDBOutput_2 = 0;
int nb_line_deleted_tDBOutput_2 = 0;
int nb_line_rejected_tDBOutput_2 = 0;

int deletedCount_tDBOutput_2=0;
int updatedCount_tDBOutput_2=0;
int insertedCount_tDBOutput_2=0;
int rowsToCommitCount_tDBOutput_2=0;
int rejectedCount_tDBOutput_2=0;

String tableName_tDBOutput_2 = "stg_movie_details";
boolean whetherReject_tDBOutput_2 = false;

java.util.Calendar calendar_tDBOutput_2 = java.util.Calendar.getInstance();
calendar_tDBOutput_2.set(1, 0, 1, 0, 0, 0);
long year1_tDBOutput_2 = calendar_tDBOutput_2.getTime().getTime();
calendar_tDBOutput_2.set(10000, 0, 1, 0, 0, 0);
long year10000_tDBOutput_2 = calendar_tDBOutput_2.getTime().getTime();
long date_tDBOutput_2;

java.sql.Connection conn_tDBOutput_2 = null;
		
			
        String properties_tDBOutput_2 = context.MySqlLocal_AdditionalParams;
        if (properties_tDBOutput_2 == null || properties_tDBOutput_2.trim().length() == 0) {
            properties_tDBOutput_2 = "rewriteBatchedStatements=true&allowLoadLocalInfile=true";
        }else {
            if (!properties_tDBOutput_2.contains("rewriteBatchedStatements=")) {
                properties_tDBOutput_2 += "&rewriteBatchedStatements=true";
            }

            if (!properties_tDBOutput_2.contains("allowLoadLocalInfile=")) {
                properties_tDBOutput_2 += "&allowLoadLocalInfile=true";
            }
        }

        String url_tDBOutput_2 = "jdbc:mysql://" + context.MySqlLocal_Server + ":" + context.MySqlLocal_Port + "/" + context.MySqlLocal_Database + "?" + properties_tDBOutput_2;

			String driverClass_tDBOutput_2 = "com.mysql.cj.jdbc.Driver";
			
                if(log.isDebugEnabled())
            log.debug("tDBOutput_2 - "  + ("Driver ClassName: ")  + (driverClass_tDBOutput_2)  + (".") );
			String dbUser_tDBOutput_2 = context.MySqlLocal_Login;
			

			
	final String decryptedPassword_tDBOutput_2 = context.MySqlLocal_Password; 

			String dbPwd_tDBOutput_2 = decryptedPassword_tDBOutput_2;
			java.lang.Class.forName(driverClass_tDBOutput_2);
			
                if(log.isDebugEnabled())
            log.debug("tDBOutput_2 - "  + ("Connection attempts to '")  + (url_tDBOutput_2)  + ("' with the username '")  + (dbUser_tDBOutput_2)  + ("'.") );
			conn_tDBOutput_2 = java.sql.DriverManager.getConnection(url_tDBOutput_2, dbUser_tDBOutput_2, dbPwd_tDBOutput_2);
			
                if(log.isDebugEnabled())
            log.debug("tDBOutput_2 - "  + ("Connection to '")  + (url_tDBOutput_2)  + ("' has succeeded.") );
			
	resourceMap.put("conn_tDBOutput_2", conn_tDBOutput_2);
	
			conn_tDBOutput_2.setAutoCommit(false);
			int commitEvery_tDBOutput_2 = 10000;
			int commitCounter_tDBOutput_2 = 0;
			
                if(log.isDebugEnabled())
            log.debug("tDBOutput_2 - "  + ("Connection is set auto commit to '")  + (conn_tDBOutput_2.getAutoCommit())  + ("'.") );

		int count_tDBOutput_2=0;
		
				
                                java.sql.DatabaseMetaData dbMetaData_tDBOutput_2 = conn_tDBOutput_2.getMetaData();
                                    java.sql.ResultSet rsTable_tDBOutput_2 = dbMetaData_tDBOutput_2.getTables(context.MySqlLocal_Database, null, null, new String[]{"TABLE"});
                                boolean whetherExist_tDBOutput_2 = false;
                                while(rsTable_tDBOutput_2.next()) {
                                    String table_tDBOutput_2 = rsTable_tDBOutput_2.getString("TABLE_NAME");
                                    if(table_tDBOutput_2.equalsIgnoreCase("stg_movie_details")) {
                                        whetherExist_tDBOutput_2 = true;
                                        break;
                                    }
                                }
                                if(!whetherExist_tDBOutput_2) {
                                    try (java.sql.Statement stmtCreate_tDBOutput_2 = conn_tDBOutput_2.createStatement()) {
                if(log.isDebugEnabled())
            log.debug("tDBOutput_2 - "  + ("Creating")  + (" table '")  + (tableName_tDBOutput_2)  + ("'.") );
                                        stmtCreate_tDBOutput_2.execute("CREATE TABLE `" + tableName_tDBOutput_2 + "`(`tconst` VARCHAR(10)   not null ,`titleType` VARCHAR(255)  ,`primaryTitle` VARCHAR(1024)  ,`originalTitle` VARCHAR(1024)  ,`isAdult` TINYINT(3)  ,`startYear` VARCHAR(4)  ,`endYear` VARCHAR(4)  ,`runtimeMinutes` VARCHAR(10)  ,`genres` VARCHAR(255)  ,`DI_Create_DT` DATETIME  not null ,`DI_WorkflowJobId` VARCHAR(8)  )");
                if(log.isDebugEnabled())
            log.debug("tDBOutput_2 - "  + ("Create")  + (" table '")  + (tableName_tDBOutput_2)  + ("' has succeeded.") );
                                    }
                                }
			

		
						String insert_tDBOutput_2 = "INSERT INTO `" + "stg_movie_details" + "` (`tconst`,`titleType`,`primaryTitle`,`originalTitle`,`isAdult`,`startYear`,`endYear`,`runtimeMinutes`,`genres`,`DI_Create_DT`,`DI_WorkflowJobId`) VALUES (?,?,?,?,?,?,?,?,?,?,?)";
		
						int batchSize_tDBOutput_2 = 100;
						int batchSizeCounter_tDBOutput_2=0;
						    
						java.sql.PreparedStatement pstmt_tDBOutput_2 = conn_tDBOutput_2.prepareStatement(insert_tDBOutput_2);
						resourceMap.put("pstmt_tDBOutput_2", pstmt_tDBOutput_2);

		


 



/**
 * [tDBOutput_2 begin ] stop
 */



	
	/**
	 * [tMap_2 begin ] start
	 */

	

	
		
		ok_Hash.put("tMap_2", false);
		start_Hash.put("tMap_2", System.currentTimeMillis());
		
	
	currentComponent="tMap_2";
	
	
			runStat.updateStatAndLog(execStat,enableLogStash,resourceMap,iterateId,0,0,"row2");
			
		int tos_count_tMap_2 = 0;
		
                if(log.isDebugEnabled())
            log.debug("tMap_2 - "  + ("Start to work.") );
            if (log.isDebugEnabled()) {
                class BytesLimit65535_tMap_2{
                    public void limitLog4jByte() throws Exception{
                    StringBuilder log4jParamters_tMap_2 = new StringBuilder();
                    log4jParamters_tMap_2.append("Parameters:");
                            log4jParamters_tMap_2.append("LINK_STYLE" + " = " + "AUTO");
                        log4jParamters_tMap_2.append(" | ");
                            log4jParamters_tMap_2.append("TEMPORARY_DATA_DIRECTORY" + " = " + "");
                        log4jParamters_tMap_2.append(" | ");
                            log4jParamters_tMap_2.append("ROWS_BUFFER_SIZE" + " = " + "2000000");
                        log4jParamters_tMap_2.append(" | ");
                            log4jParamters_tMap_2.append("CHANGE_HASH_AND_EQUALS_FOR_BIGDECIMAL" + " = " + "true");
                        log4jParamters_tMap_2.append(" | ");
                if(log.isDebugEnabled())
            log.debug("tMap_2 - "  + (log4jParamters_tMap_2) );
                    } 
                } 
            new BytesLimit65535_tMap_2().limitLog4jByte();
            }
			if(enableLogStash) {
				talendJobLog.addCM("tMap_2", "tMap_2", "tMap");
				talendJobLogProcess(globalMap);
			}
			




// ###############################
// # Lookup's keys initialization
		int count_row2_tMap_2 = 0;
		
// ###############################        

// ###############################
// # Vars initialization
class  Var__tMap_2__Struct  {
}
Var__tMap_2__Struct Var__tMap_2 = new Var__tMap_2__Struct();
// ###############################

// ###############################
// # Outputs initialization
				int count_copyOftoTable_tMap_2 = 0;
				
copyOftoTableStruct copyOftoTable_tmp = new copyOftoTableStruct();
// ###############################

        
        



        









 



/**
 * [tMap_2 begin ] stop
 */



	
	/**
	 * [tDBInput_2 begin ] start
	 */

	

	
		
		ok_Hash.put("tDBInput_2", false);
		start_Hash.put("tDBInput_2", System.currentTimeMillis());
		
	
	currentComponent="tDBInput_2";
	
	
			cLabel="imdb_title_basics";
		
		int tos_count_tDBInput_2 = 0;
		
                if(log.isDebugEnabled())
            log.debug("tDBInput_2 - "  + ("Start to work.") );
            if (log.isDebugEnabled()) {
                class BytesLimit65535_tDBInput_2{
                    public void limitLog4jByte() throws Exception{
                    StringBuilder log4jParamters_tDBInput_2 = new StringBuilder();
                    log4jParamters_tDBInput_2.append("Parameters:");
                            log4jParamters_tDBInput_2.append("DB_VERSION" + " = " + "MYSQL_8");
                        log4jParamters_tDBInput_2.append(" | ");
                            log4jParamters_tDBInput_2.append("USE_EXISTING_CONNECTION" + " = " + "false");
                        log4jParamters_tDBInput_2.append(" | ");
                            log4jParamters_tDBInput_2.append("HOST" + " = " + "context.MySqlLocal_Server");
                        log4jParamters_tDBInput_2.append(" | ");
                            log4jParamters_tDBInput_2.append("PORT" + " = " + "context.MySqlLocal_Port");
                        log4jParamters_tDBInput_2.append(" | ");
                            log4jParamters_tDBInput_2.append("DBNAME" + " = " + "context.MySqlLocal_Database");
                        log4jParamters_tDBInput_2.append(" | ");
                            log4jParamters_tDBInput_2.append("USER" + " = " + "context.MySqlLocal_Login");
                        log4jParamters_tDBInput_2.append(" | ");
                            log4jParamters_tDBInput_2.append("PASS" + " = " + String.valueOf(routines.system.PasswordEncryptUtil.encryptPassword(context.MySqlLocal_Password)).substring(0, 4) + "...");     
                        log4jParamters_tDBInput_2.append(" | ");
                            log4jParamters_tDBInput_2.append("TABLE" + " = " + "\"imdb_title_basics\"");
                        log4jParamters_tDBInput_2.append(" | ");
                            log4jParamters_tDBInput_2.append("QUERYSTORE" + " = " + "\"\"");
                        log4jParamters_tDBInput_2.append(" | ");
                            log4jParamters_tDBInput_2.append("QUERY" + " = " + "\"SELECT * FROM imdb_title_basics;\"");
                        log4jParamters_tDBInput_2.append(" | ");
                            log4jParamters_tDBInput_2.append("SPECIFY_DATASOURCE_ALIAS" + " = " + "false");
                        log4jParamters_tDBInput_2.append(" | ");
                            log4jParamters_tDBInput_2.append("PROPERTIES" + " = " + "context.MySqlLocal_AdditionalParams");
                        log4jParamters_tDBInput_2.append(" | ");
                            log4jParamters_tDBInput_2.append("ENABLE_STREAM" + " = " + "false");
                        log4jParamters_tDBInput_2.append(" | ");
                            log4jParamters_tDBInput_2.append("TRIM_ALL_COLUMN" + " = " + "false");
                        log4jParamters_tDBInput_2.append(" | ");
                            log4jParamters_tDBInput_2.append("TRIM_COLUMN" + " = " + "[{TRIM="+("false")+", SCHEMA_COLUMN="+("tconst")+"}, {TRIM="+("false")+", SCHEMA_COLUMN="+("titleType")+"}, {TRIM="+("false")+", SCHEMA_COLUMN="+("primaryTitle")+"}, {TRIM="+("false")+", SCHEMA_COLUMN="+("originalTitle")+"}, {TRIM="+("false")+", SCHEMA_COLUMN="+("isAdult")+"}, {TRIM="+("false")+", SCHEMA_COLUMN="+("startYear")+"}, {TRIM="+("false")+", SCHEMA_COLUMN="+("endYear")+"}, {TRIM="+("false")+", SCHEMA_COLUMN="+("runtimeMinutes")+"}, {TRIM="+("false")+", SCHEMA_COLUMN="+("genres")+"}, {TRIM="+("false")+", SCHEMA_COLUMN="+("DI_Create_DT")+"}]");
                        log4jParamters_tDBInput_2.append(" | ");
                            log4jParamters_tDBInput_2.append("UNIFIED_COMPONENTS" + " = " + "tMysqlInput");
                        log4jParamters_tDBInput_2.append(" | ");
                if(log.isDebugEnabled())
            log.debug("tDBInput_2 - "  + (log4jParamters_tDBInput_2) );
                    } 
                } 
            new BytesLimit65535_tDBInput_2().limitLog4jByte();
            }
			if(enableLogStash) {
				talendJobLog.addCM("tDBInput_2", "imdb_title_basics", "tMysqlInput");
				talendJobLogProcess(globalMap);
			}
			
	
	
		    java.util.Calendar calendar_tDBInput_2 = java.util.Calendar.getInstance();
		    calendar_tDBInput_2.set(0, 0, 0, 0, 0, 0);
		    java.util.Date year0_tDBInput_2 = calendar_tDBInput_2.getTime();
		    int nb_line_tDBInput_2 = 0;
		    java.sql.Connection conn_tDBInput_2 = null;
				String driverClass_tDBInput_2 = "com.mysql.cj.jdbc.Driver";
			    java.lang.Class jdbcclazz_tDBInput_2 = java.lang.Class.forName(driverClass_tDBInput_2);
				String dbUser_tDBInput_2 = context.MySqlLocal_Login;
				
				
	final String decryptedPassword_tDBInput_2 = context.MySqlLocal_Password; 
				
				String dbPwd_tDBInput_2 = decryptedPassword_tDBInput_2;
				
        String properties_tDBInput_2 = context.MySqlLocal_AdditionalParams;
        if (properties_tDBInput_2 == null || properties_tDBInput_2.trim().length() == 0) {
            properties_tDBInput_2 = "";
        }
        String url_tDBInput_2 = "jdbc:mysql://" + context.MySqlLocal_Server + ":" + context.MySqlLocal_Port + "/" + context.MySqlLocal_Database + "?" + properties_tDBInput_2;
				
	    		log.debug("tDBInput_2 - Driver ClassName: "+driverClass_tDBInput_2+".");
			
	    		log.debug("tDBInput_2 - Connection attempt to '" + url_tDBInput_2 + "' with the username '" + dbUser_tDBInput_2 + "'.");
			
				conn_tDBInput_2 = java.sql.DriverManager.getConnection(url_tDBInput_2,dbUser_tDBInput_2,dbPwd_tDBInput_2);
	    		log.debug("tDBInput_2 - Connection to '" + url_tDBInput_2 + "' has succeeded.");
			
		        
		    
			java.sql.Statement stmt_tDBInput_2 = conn_tDBInput_2.createStatement();

		    String dbquery_tDBInput_2 = "SELECT * FROM imdb_title_basics;";
		    
	    		log.debug("tDBInput_2 - Executing the query: '" + dbquery_tDBInput_2 + "'.");
			

		    globalMap.put("tDBInput_2_QUERY",dbquery_tDBInput_2);

		    java.sql.ResultSet rs_tDBInput_2 = null;

		    try {
		    	rs_tDBInput_2 = stmt_tDBInput_2.executeQuery(dbquery_tDBInput_2);
		    	java.sql.ResultSetMetaData rsmd_tDBInput_2 = rs_tDBInput_2.getMetaData();
		    	int colQtyInRs_tDBInput_2 = rsmd_tDBInput_2.getColumnCount();

		    String tmpContent_tDBInput_2 = null;
		    
		    
		    	log.debug("tDBInput_2 - Retrieving records from the database.");
		    
		    while (rs_tDBInput_2.next()) {
		        nb_line_tDBInput_2++;
		        
							if(colQtyInRs_tDBInput_2 < 1) {
								row2.tconst = null;
							} else {
	                         		
        	row2.tconst = routines.system.JDBCUtil.getString(rs_tDBInput_2, 1, false);
		                    }
							if(colQtyInRs_tDBInput_2 < 2) {
								row2.titleType = null;
							} else {
	                         		
        	row2.titleType = routines.system.JDBCUtil.getString(rs_tDBInput_2, 2, false);
		                    }
							if(colQtyInRs_tDBInput_2 < 3) {
								row2.primaryTitle = null;
							} else {
	                         		
        	row2.primaryTitle = routines.system.JDBCUtil.getString(rs_tDBInput_2, 3, false);
		                    }
							if(colQtyInRs_tDBInput_2 < 4) {
								row2.originalTitle = null;
							} else {
	                         		
        	row2.originalTitle = routines.system.JDBCUtil.getString(rs_tDBInput_2, 4, false);
		                    }
							if(colQtyInRs_tDBInput_2 < 5) {
								row2.isAdult = null;
							} else {
		                          
            row2.isAdult = rs_tDBInput_2.getByte(5);
            if(rs_tDBInput_2.wasNull()){
                    row2.isAdult = null;
            }
		                    }
							if(colQtyInRs_tDBInput_2 < 6) {
								row2.startYear = null;
							} else {
	                         		
        	row2.startYear = routines.system.JDBCUtil.getString(rs_tDBInput_2, 6, false);
		                    }
							if(colQtyInRs_tDBInput_2 < 7) {
								row2.endYear = null;
							} else {
	                         		
        	row2.endYear = routines.system.JDBCUtil.getString(rs_tDBInput_2, 7, false);
		                    }
							if(colQtyInRs_tDBInput_2 < 8) {
								row2.runtimeMinutes = null;
							} else {
	                         		
        	row2.runtimeMinutes = routines.system.JDBCUtil.getString(rs_tDBInput_2, 8, false);
		                    }
							if(colQtyInRs_tDBInput_2 < 9) {
								row2.genres = null;
							} else {
	                         		
        	row2.genres = routines.system.JDBCUtil.getString(rs_tDBInput_2, 9, false);
		                    }
							if(colQtyInRs_tDBInput_2 < 10) {
								row2.DI_Create_DT = null;
							} else {
										
				if(rs_tDBInput_2.getString(10) != null) {
					String dateString_tDBInput_2 = rs_tDBInput_2.getString(10);
					if (!("0000-00-00").equals(dateString_tDBInput_2) && !("0000-00-00 00:00:00").equals(dateString_tDBInput_2)) {
						row2.DI_Create_DT = rs_tDBInput_2.getTimestamp(10);
					} else {
						row2.DI_Create_DT = (java.util.Date) year0_tDBInput_2.clone();
					}
				} else {
					row2.DI_Create_DT =  null;
				}
		                    }
					
						log.debug("tDBInput_2 - Retrieving the record " + nb_line_tDBInput_2 + ".");
					

 



/**
 * [tDBInput_2 begin ] stop
 */
	
	/**
	 * [tDBInput_2 main ] start
	 */

	

	
	
	currentComponent="tDBInput_2";
	
	
			cLabel="imdb_title_basics";
		

 


	tos_count_tDBInput_2++;

/**
 * [tDBInput_2 main ] stop
 */
	
	/**
	 * [tDBInput_2 process_data_begin ] start
	 */

	

	
	
	currentComponent="tDBInput_2";
	
	
			cLabel="imdb_title_basics";
		

 



/**
 * [tDBInput_2 process_data_begin ] stop
 */

	
	/**
	 * [tMap_2 main ] start
	 */

	

	
	
	currentComponent="tMap_2";
	
	
			if(runStat.update(execStat,enableLogStash,iterateId,1,1
				
					,"row2","tDBInput_2","imdb_title_basics","tMysqlInput","tMap_2","tMap_2","tMap"
				
			)) {
				talendJobLogProcess(globalMap);
			}
			
    			if(log.isTraceEnabled()){
    				log.trace("row2 - " + (row2==null? "": row2.toLogString()));
    			}
    		

		
		
		boolean hasCasePrimitiveKeyWithNull_tMap_2 = false;
		
		// ###############################
		// # Input tables (lookups)
		
		boolean rejectedInnerJoin_tMap_2 = false;
		boolean mainRowRejected_tMap_2 = false;
		// ###############################
        { // start of Var scope
        
	        // ###############################
        	// # Vars tables
        
Var__tMap_2__Struct Var = Var__tMap_2;// ###############################
        // ###############################
        // # Output tables

copyOftoTable = null;


// # Output table : 'copyOftoTable'
count_copyOftoTable_tMap_2++;

copyOftoTable_tmp.tconst = row2.tconst;
copyOftoTable_tmp.titleType = row2.titleType;
copyOftoTable_tmp.primaryTitle = row2.primaryTitle;
copyOftoTable_tmp.originalTitle = row2.originalTitle;
copyOftoTable_tmp.isAdult = row2.isAdult;
copyOftoTable_tmp.startYear = row2.startYear;
copyOftoTable_tmp.endYear = row2.endYear;
copyOftoTable_tmp.runtimeMinutes = row2.runtimeMinutes;
copyOftoTable_tmp.genres = row2.genres;
copyOftoTable_tmp.DI_Create_DT = TalendDate.getCurrentDate();
copyOftoTable_tmp.DI_WorkflowJobId = pid;
copyOftoTable = copyOftoTable_tmp;
log.debug("tMap_2 - Outputting the record " + count_copyOftoTable_tMap_2 + " of the output table 'copyOftoTable'.");

// ###############################

} // end of Var scope

rejectedInnerJoin_tMap_2 = false;










 


	tos_count_tMap_2++;

/**
 * [tMap_2 main ] stop
 */
	
	/**
	 * [tMap_2 process_data_begin ] start
	 */

	

	
	
	currentComponent="tMap_2";
	
	

 



/**
 * [tMap_2 process_data_begin ] stop
 */
// Start of branch "copyOftoTable"
if(copyOftoTable != null) { 



	
	/**
	 * [tDBOutput_2 main ] start
	 */

	

	
	
	currentComponent="tDBOutput_2";
	
	
			cLabel="stg_movie_details";
		
			if(runStat.update(execStat,enableLogStash,iterateId,1,1
				
					,"copyOftoTable","tMap_2","tMap_2","tMap","tDBOutput_2","stg_movie_details","tMysqlOutput"
				
			)) {
				talendJobLogProcess(globalMap);
			}
			
    			if(log.isTraceEnabled()){
    				log.trace("copyOftoTable - " + (copyOftoTable==null? "": copyOftoTable.toLogString()));
    			}
    		



        whetherReject_tDBOutput_2 = false;
                            if(copyOftoTable.tconst == null) {
pstmt_tDBOutput_2.setNull(1, java.sql.Types.VARCHAR);
} else {pstmt_tDBOutput_2.setString(1, copyOftoTable.tconst);
}

                            if(copyOftoTable.titleType == null) {
pstmt_tDBOutput_2.setNull(2, java.sql.Types.VARCHAR);
} else {pstmt_tDBOutput_2.setString(2, copyOftoTable.titleType);
}

                            if(copyOftoTable.primaryTitle == null) {
pstmt_tDBOutput_2.setNull(3, java.sql.Types.VARCHAR);
} else {pstmt_tDBOutput_2.setString(3, copyOftoTable.primaryTitle);
}

                            if(copyOftoTable.originalTitle == null) {
pstmt_tDBOutput_2.setNull(4, java.sql.Types.VARCHAR);
} else {pstmt_tDBOutput_2.setString(4, copyOftoTable.originalTitle);
}

                            if(copyOftoTable.isAdult == null) {
pstmt_tDBOutput_2.setNull(5, java.sql.Types.INTEGER);
} else {pstmt_tDBOutput_2.setByte(5, copyOftoTable.isAdult);
}

                            if(copyOftoTable.startYear == null) {
pstmt_tDBOutput_2.setNull(6, java.sql.Types.VARCHAR);
} else {pstmt_tDBOutput_2.setString(6, copyOftoTable.startYear);
}

                            if(copyOftoTable.endYear == null) {
pstmt_tDBOutput_2.setNull(7, java.sql.Types.VARCHAR);
} else {pstmt_tDBOutput_2.setString(7, copyOftoTable.endYear);
}

                            if(copyOftoTable.runtimeMinutes == null) {
pstmt_tDBOutput_2.setNull(8, java.sql.Types.VARCHAR);
} else {pstmt_tDBOutput_2.setString(8, copyOftoTable.runtimeMinutes);
}

                            if(copyOftoTable.genres == null) {
pstmt_tDBOutput_2.setNull(9, java.sql.Types.VARCHAR);
} else {pstmt_tDBOutput_2.setString(9, copyOftoTable.genres);
}

                            if(copyOftoTable.DI_Create_DT != null) {
date_tDBOutput_2 = copyOftoTable.DI_Create_DT.getTime();
if(date_tDBOutput_2 < year1_tDBOutput_2 || date_tDBOutput_2 >= year10000_tDBOutput_2) {
pstmt_tDBOutput_2.setString(10, "0000-00-00 00:00:00");
} else {pstmt_tDBOutput_2.setTimestamp(10, new java.sql.Timestamp(date_tDBOutput_2));
}
} else {
pstmt_tDBOutput_2.setNull(10, java.sql.Types.DATE);
}

                            if(copyOftoTable.DI_WorkflowJobId == null) {
pstmt_tDBOutput_2.setNull(11, java.sql.Types.VARCHAR);
} else {pstmt_tDBOutput_2.setString(11, copyOftoTable.DI_WorkflowJobId);
}

                    pstmt_tDBOutput_2.addBatch();
                    nb_line_tDBOutput_2++;

                if(log.isDebugEnabled())
            log.debug("tDBOutput_2 - "  + ("Adding the record ")  + (nb_line_tDBOutput_2)  + (" to the ")  + ("INSERT")  + (" batch.") );
                      batchSizeCounter_tDBOutput_2++;
                if ( batchSize_tDBOutput_2 <= batchSizeCounter_tDBOutput_2) {
                try {
                        int countSum_tDBOutput_2 = 0;
                if(log.isDebugEnabled())
            log.debug("tDBOutput_2 - "  + ("Executing the ")  + ("INSERT")  + (" batch.") );
                        for(int countEach_tDBOutput_2: pstmt_tDBOutput_2.executeBatch()) {
                            countSum_tDBOutput_2 += (countEach_tDBOutput_2 == java.sql.Statement.EXECUTE_FAILED ? 0 : 1);
                        }
                        rowsToCommitCount_tDBOutput_2 += countSum_tDBOutput_2;
                if(log.isDebugEnabled())
            log.debug("tDBOutput_2 - "  + ("The ")  + ("INSERT")  + (" batch execution has succeeded.") );
                        insertedCount_tDBOutput_2 += countSum_tDBOutput_2;
                }catch (java.sql.BatchUpdateException e){
                    globalMap.put("tDBOutput_2_ERROR_MESSAGE",e.getMessage());
                    int countSum_tDBOutput_2 = 0;
                    for(int countEach_tDBOutput_2: e.getUpdateCounts()) {
                        countSum_tDBOutput_2 += (countEach_tDBOutput_2 < 0 ? 0 : countEach_tDBOutput_2);
                    }
                    rowsToCommitCount_tDBOutput_2 += countSum_tDBOutput_2;
                    insertedCount_tDBOutput_2 += countSum_tDBOutput_2;
                    System.err.println(e.getMessage());
            log.error("tDBOutput_2 - "  + (e.getMessage()) );
                }

                batchSizeCounter_tDBOutput_2 = 0;
            }
                commitCounter_tDBOutput_2++;

                if(commitEvery_tDBOutput_2 <= commitCounter_tDBOutput_2) {

                        try {
                                int countSum_tDBOutput_2 = 0;
                if(log.isDebugEnabled())
            log.debug("tDBOutput_2 - "  + ("Executing the ")  + ("INSERT")  + (" batch.") );
                                for(int countEach_tDBOutput_2: pstmt_tDBOutput_2.executeBatch()) {
                                    countSum_tDBOutput_2 += (countEach_tDBOutput_2 < 0 ? 0 : 1);
                                }
                                rowsToCommitCount_tDBOutput_2 += countSum_tDBOutput_2;
                if(log.isDebugEnabled())
            log.debug("tDBOutput_2 - "  + ("The ")  + ("INSERT")  + (" batch execution has succeeded.") );
                                insertedCount_tDBOutput_2 += countSum_tDBOutput_2;
                        }catch (java.sql.BatchUpdateException e){
                            globalMap.put("tDBOutput_2_ERROR_MESSAGE",e.getMessage());
                            int countSum_tDBOutput_2 = 0;
                            for(int countEach_tDBOutput_2: e.getUpdateCounts()) {
                                countSum_tDBOutput_2 += (countEach_tDBOutput_2 < 0 ? 0 : countEach_tDBOutput_2);
                            }
                            rowsToCommitCount_tDBOutput_2 += countSum_tDBOutput_2;
                            insertedCount_tDBOutput_2 += countSum_tDBOutput_2;
                            System.err.println(e.getMessage());
            log.error("tDBOutput_2 - "  + (e.getMessage()) );

                        }
                    if(rowsToCommitCount_tDBOutput_2 != 0){
                if(log.isDebugEnabled())
            log.debug("tDBOutput_2 - "  + ("Connection starting to commit ")  + (rowsToCommitCount_tDBOutput_2)  + (" record(s).") );
                    }
                    conn_tDBOutput_2.commit();
                    if(rowsToCommitCount_tDBOutput_2 != 0){
                if(log.isDebugEnabled())
            log.debug("tDBOutput_2 - "  + ("Connection commit has succeeded.") );
                        rowsToCommitCount_tDBOutput_2 = 0;
                    }
                    commitCounter_tDBOutput_2=0;
                }

 


	tos_count_tDBOutput_2++;

/**
 * [tDBOutput_2 main ] stop
 */
	
	/**
	 * [tDBOutput_2 process_data_begin ] start
	 */

	

	
	
	currentComponent="tDBOutput_2";
	
	
			cLabel="stg_movie_details";
		

 



/**
 * [tDBOutput_2 process_data_begin ] stop
 */
	
	/**
	 * [tDBOutput_2 process_data_end ] start
	 */

	

	
	
	currentComponent="tDBOutput_2";
	
	
			cLabel="stg_movie_details";
		

 



/**
 * [tDBOutput_2 process_data_end ] stop
 */

} // End of branch "copyOftoTable"




	
	/**
	 * [tMap_2 process_data_end ] start
	 */

	

	
	
	currentComponent="tMap_2";
	
	

 



/**
 * [tMap_2 process_data_end ] stop
 */



	
	/**
	 * [tDBInput_2 process_data_end ] start
	 */

	

	
	
	currentComponent="tDBInput_2";
	
	
			cLabel="imdb_title_basics";
		

 



/**
 * [tDBInput_2 process_data_end ] stop
 */
	
	/**
	 * [tDBInput_2 end ] start
	 */

	

	
	
	currentComponent="tDBInput_2";
	
	
			cLabel="imdb_title_basics";
		

	}
}finally{
	if (rs_tDBInput_2 != null) {
		rs_tDBInput_2.close();
	}
	if (stmt_tDBInput_2 != null) {
		stmt_tDBInput_2.close();
	}
		if(conn_tDBInput_2 != null && !conn_tDBInput_2.isClosed()) {
			
	    		log.debug("tDBInput_2 - Closing the connection to the database.");
			
			conn_tDBInput_2.close();
			
			if("com.mysql.cj.jdbc.Driver".equals((String)globalMap.get("driverClass_"))
			    && routines.system.BundleUtils.inOSGi()) {
			        Class.forName("com.mysql.cj.jdbc.AbandonedConnectionCleanupThread").
			            getMethod("checkedShutdown").invoke(null, (Object[]) null);
			}
			
	    		log.debug("tDBInput_2 - Connection to the database closed.");
			
		}
		
}
globalMap.put("tDBInput_2_NB_LINE",nb_line_tDBInput_2);
	    		log.debug("tDBInput_2 - Retrieved records count: "+nb_line_tDBInput_2 + " .");
			

 
                if(log.isDebugEnabled())
            log.debug("tDBInput_2 - "  + ("Done.") );

ok_Hash.put("tDBInput_2", true);
end_Hash.put("tDBInput_2", System.currentTimeMillis());




/**
 * [tDBInput_2 end ] stop
 */

	
	/**
	 * [tMap_2 end ] start
	 */

	

	
	
	currentComponent="tMap_2";
	
	


// ###############################
// # Lookup hashes releasing
// ###############################      
				log.debug("tMap_2 - Written records count in the table 'copyOftoTable': " + count_copyOftoTable_tMap_2 + ".");





			 		if(runStat.updateStatAndLog(execStat,enableLogStash,resourceMap,iterateId,"row2",2,0,
			 			"tDBInput_2","imdb_title_basics","tMysqlInput","tMap_2","tMap_2","tMap","output")) {
						talendJobLogProcess(globalMap);
					}
				
 
                if(log.isDebugEnabled())
            log.debug("tMap_2 - "  + ("Done.") );

ok_Hash.put("tMap_2", true);
end_Hash.put("tMap_2", System.currentTimeMillis());




/**
 * [tMap_2 end ] stop
 */

	
	/**
	 * [tDBOutput_2 end ] start
	 */

	

	
	
	currentComponent="tDBOutput_2";
	
	
			cLabel="stg_movie_details";
		



				
					try {
						if (batchSizeCounter_tDBOutput_2 != 0) {
							int countSum_tDBOutput_2 = 0;
							
                if(log.isDebugEnabled())
            log.debug("tDBOutput_2 - "  + ("Executing the ")  + ("INSERT")  + (" batch.") );
							for(int countEach_tDBOutput_2: pstmt_tDBOutput_2.executeBatch()) {
								countSum_tDBOutput_2 += (countEach_tDBOutput_2 == java.sql.Statement.EXECUTE_FAILED ? 0 : 1);
							}
							rowsToCommitCount_tDBOutput_2 += countSum_tDBOutput_2;
							
                if(log.isDebugEnabled())
            log.debug("tDBOutput_2 - "  + ("The ")  + ("INSERT")  + (" batch execution has succeeded.") );
							
								insertedCount_tDBOutput_2 += countSum_tDBOutput_2;
							
						}
					}catch (java.sql.BatchUpdateException e){
						globalMap.put(currentComponent+"_ERROR_MESSAGE",e.getMessage());
						
							int countSum_tDBOutput_2 = 0;
							for(int countEach_tDBOutput_2: e.getUpdateCounts()) {
								countSum_tDBOutput_2 += (countEach_tDBOutput_2 < 0 ? 0 : countEach_tDBOutput_2);
							}
							rowsToCommitCount_tDBOutput_2 += countSum_tDBOutput_2;
							
								insertedCount_tDBOutput_2 += countSum_tDBOutput_2;
								
            log.error("tDBOutput_2 - "  + (e.getMessage()) );
							System.err.println(e.getMessage());
							
					}
					batchSizeCounter_tDBOutput_2 = 0;
					
			
		

		if(pstmt_tDBOutput_2 != null) {
			
				pstmt_tDBOutput_2.close();
				resourceMap.remove("pstmt_tDBOutput_2");
			
		}
		
	resourceMap.put("statementClosed_tDBOutput_2", true);
	
			if (commitCounter_tDBOutput_2 > 0 && rowsToCommitCount_tDBOutput_2 != 0) {
				
                if(log.isDebugEnabled())
            log.debug("tDBOutput_2 - "  + ("Connection starting to commit ")  + (rowsToCommitCount_tDBOutput_2)  + (" record(s).") );
			}
			conn_tDBOutput_2.commit();
			if (commitCounter_tDBOutput_2 > 0 && rowsToCommitCount_tDBOutput_2 != 0) {
				
                if(log.isDebugEnabled())
            log.debug("tDBOutput_2 - "  + ("Connection commit has succeeded.") );
				rowsToCommitCount_tDBOutput_2 = 0;
			}
			commitCounter_tDBOutput_2 = 0;
			
		
                if(log.isDebugEnabled())
            log.debug("tDBOutput_2 - "  + ("Closing the connection to the database.") );
		conn_tDBOutput_2 .close();
		
                if(log.isDebugEnabled())
            log.debug("tDBOutput_2 - "  + ("Connection to the database has closed.") );
		resourceMap.put("finish_tDBOutput_2", true);
	

	nb_line_deleted_tDBOutput_2=nb_line_deleted_tDBOutput_2+ deletedCount_tDBOutput_2;
	nb_line_update_tDBOutput_2=nb_line_update_tDBOutput_2 + updatedCount_tDBOutput_2;
	nb_line_inserted_tDBOutput_2=nb_line_inserted_tDBOutput_2 + insertedCount_tDBOutput_2;
	nb_line_rejected_tDBOutput_2=nb_line_rejected_tDBOutput_2 + rejectedCount_tDBOutput_2;
	
        globalMap.put("tDBOutput_2_NB_LINE",nb_line_tDBOutput_2);
        globalMap.put("tDBOutput_2_NB_LINE_UPDATED",nb_line_update_tDBOutput_2);
        globalMap.put("tDBOutput_2_NB_LINE_INSERTED",nb_line_inserted_tDBOutput_2);
        globalMap.put("tDBOutput_2_NB_LINE_DELETED",nb_line_deleted_tDBOutput_2);
        globalMap.put("tDBOutput_2_NB_LINE_REJECTED", nb_line_rejected_tDBOutput_2);
    

	
                if(log.isDebugEnabled())
            log.debug("tDBOutput_2 - "  + ("Has ")  + ("inserted")  + (" ")  + (nb_line_inserted_tDBOutput_2)  + (" record(s).") );

			 		if(runStat.updateStatAndLog(execStat,enableLogStash,resourceMap,iterateId,"copyOftoTable",2,0,
			 			"tMap_2","tMap_2","tMap","tDBOutput_2","stg_movie_details","tMysqlOutput","output")) {
						talendJobLogProcess(globalMap);
					}
				
 
                if(log.isDebugEnabled())
            log.debug("tDBOutput_2 - "  + ("Done.") );

ok_Hash.put("tDBOutput_2", true);
end_Hash.put("tDBOutput_2", System.currentTimeMillis());




/**
 * [tDBOutput_2 end ] stop
 */






				}//end the resume

				
				    			if(resumeEntryMethodName == null || globalResumeTicket){
				    				resumeUtil.addLog("CHECKPOINT", "CONNECTION:SUBJOB_OK:tDBInput_2:OnSubjobOk", "", Thread.currentThread().getId() + "", "", "", "", "", "");
								}	    				    			
					    	
								if(execStat){    	
									runStat.updateStatOnConnection("OnSubjobOk1", 0, "ok");
								} 
							
							tDBInput_1Process(globalMap); 
						



	
			}catch(java.lang.Exception e){	
				
				    if(!(e instanceof TalendException)){
					   log.fatal(currentComponent + " " + e.getMessage(),e);
					}
				
				TalendException te = new TalendException(e, currentComponent, cLabel, globalMap);
				
				throw te;
			}catch(java.lang.Error error){	
				
					runStat.stopThreadStat();
				
				throw error;
			}finally{
				
				try{
					
	
	/**
	 * [tDBInput_2 finally ] start
	 */

	

	
	
	currentComponent="tDBInput_2";
	
	
			cLabel="imdb_title_basics";
		

 



/**
 * [tDBInput_2 finally ] stop
 */

	
	/**
	 * [tMap_2 finally ] start
	 */

	

	
	
	currentComponent="tMap_2";
	
	

 



/**
 * [tMap_2 finally ] stop
 */

	
	/**
	 * [tDBOutput_2 finally ] start
	 */

	

	
	
	currentComponent="tDBOutput_2";
	
	
			cLabel="stg_movie_details";
		



    try {
    if (resourceMap.get("statementClosed_tDBOutput_2") == null) {
                java.sql.PreparedStatement pstmtToClose_tDBOutput_2 = null;
                if ((pstmtToClose_tDBOutput_2 = (java.sql.PreparedStatement) resourceMap.remove("pstmt_tDBOutput_2")) != null) {
                    pstmtToClose_tDBOutput_2.close();
                }
    }
    } finally {
        if(resourceMap.get("finish_tDBOutput_2") == null){
            java.sql.Connection ctn_tDBOutput_2 = null;
            if((ctn_tDBOutput_2 = (java.sql.Connection)resourceMap.get("conn_tDBOutput_2")) != null){
                try {
                if(log.isDebugEnabled())
            log.debug("tDBOutput_2 - "  + ("Closing the connection to the database.") );
                    ctn_tDBOutput_2.close();
                if(log.isDebugEnabled())
            log.debug("tDBOutput_2 - "  + ("Connection to the database has closed.") );
                } catch (java.sql.SQLException sqlEx_tDBOutput_2) {
                    String errorMessage_tDBOutput_2 = "failed to close the connection in tDBOutput_2 :" + sqlEx_tDBOutput_2.getMessage();
            log.error("tDBOutput_2 - "  + (errorMessage_tDBOutput_2) );
                    System.err.println(errorMessage_tDBOutput_2);
                }
            }
        }
    }
 



/**
 * [tDBOutput_2 finally ] stop
 */






				}catch(java.lang.Exception e){	
					//ignore
				}catch(java.lang.Error error){
					//ignore
				}
				resourceMap = null;
			}
		

		globalMap.put("tDBInput_2_SUBPROCESS_STATE", 1);
	}
	


public static class toTableStruct implements routines.system.IPersistableRow<toTableStruct> {
    final static byte[] commonByteArrayLock_FINAL_PROJECT_sql_staging_job = new byte[0];
    static byte[] commonByteArray_FINAL_PROJECT_sql_staging_job = new byte[0];

	
			    public String titleId;

				public String getTitleId () {
					return this.titleId;
				}

				public Boolean titleIdIsNullable(){
				    return false;
				}
				public Boolean titleIdIsKey(){
				    return false;
				}
				public Integer titleIdLength(){
				    return 10;
				}
				public Integer titleIdPrecision(){
				    return 0;
				}
				public String titleIdDefault(){
				
					return null;
				
				}
				public String titleIdComment(){
				
				    return "";
				
				}
				public String titleIdPattern(){
				
					return "";
				
				}
				public String titleIdOriginalDbColumnName(){
				
					return "titleId";
				
				}

				
			    public int ordering;

				public int getOrdering () {
					return this.ordering;
				}

				public Boolean orderingIsNullable(){
				    return false;
				}
				public Boolean orderingIsKey(){
				    return false;
				}
				public Integer orderingLength(){
				    return 10;
				}
				public Integer orderingPrecision(){
				    return 0;
				}
				public String orderingDefault(){
				
					return "";
				
				}
				public String orderingComment(){
				
				    return "";
				
				}
				public String orderingPattern(){
				
					return "";
				
				}
				public String orderingOriginalDbColumnName(){
				
					return "ordering";
				
				}

				
			    public String title;

				public String getTitle () {
					return this.title;
				}

				public Boolean titleIsNullable(){
				    return true;
				}
				public Boolean titleIsKey(){
				    return false;
				}
				public Integer titleLength(){
				    return 1024;
				}
				public Integer titlePrecision(){
				    return 0;
				}
				public String titleDefault(){
				
					return null;
				
				}
				public String titleComment(){
				
				    return "";
				
				}
				public String titlePattern(){
				
					return "";
				
				}
				public String titleOriginalDbColumnName(){
				
					return "title";
				
				}

				
			    public String region;

				public String getRegion () {
					return this.region;
				}

				public Boolean regionIsNullable(){
				    return true;
				}
				public Boolean regionIsKey(){
				    return false;
				}
				public Integer regionLength(){
				    return 255;
				}
				public Integer regionPrecision(){
				    return 0;
				}
				public String regionDefault(){
				
					return null;
				
				}
				public String regionComment(){
				
				    return "";
				
				}
				public String regionPattern(){
				
					return "";
				
				}
				public String regionOriginalDbColumnName(){
				
					return "region";
				
				}

				
			    public String language;

				public String getLanguage () {
					return this.language;
				}

				public Boolean languageIsNullable(){
				    return true;
				}
				public Boolean languageIsKey(){
				    return false;
				}
				public Integer languageLength(){
				    return 255;
				}
				public Integer languagePrecision(){
				    return 0;
				}
				public String languageDefault(){
				
					return null;
				
				}
				public String languageComment(){
				
				    return "";
				
				}
				public String languagePattern(){
				
					return "";
				
				}
				public String languageOriginalDbColumnName(){
				
					return "language";
				
				}

				
			    public String types;

				public String getTypes () {
					return this.types;
				}

				public Boolean typesIsNullable(){
				    return true;
				}
				public Boolean typesIsKey(){
				    return false;
				}
				public Integer typesLength(){
				    return 255;
				}
				public Integer typesPrecision(){
				    return 0;
				}
				public String typesDefault(){
				
					return null;
				
				}
				public String typesComment(){
				
				    return "";
				
				}
				public String typesPattern(){
				
					return "";
				
				}
				public String typesOriginalDbColumnName(){
				
					return "types";
				
				}

				
			    public String attributes;

				public String getAttributes () {
					return this.attributes;
				}

				public Boolean attributesIsNullable(){
				    return true;
				}
				public Boolean attributesIsKey(){
				    return false;
				}
				public Integer attributesLength(){
				    return 1024;
				}
				public Integer attributesPrecision(){
				    return 0;
				}
				public String attributesDefault(){
				
					return null;
				
				}
				public String attributesComment(){
				
				    return "";
				
				}
				public String attributesPattern(){
				
					return "";
				
				}
				public String attributesOriginalDbColumnName(){
				
					return "attributes";
				
				}

				
			    public String isOriginalTitle;

				public String getIsOriginalTitle () {
					return this.isOriginalTitle;
				}

				public Boolean isOriginalTitleIsNullable(){
				    return true;
				}
				public Boolean isOriginalTitleIsKey(){
				    return false;
				}
				public Integer isOriginalTitleLength(){
				    return 255;
				}
				public Integer isOriginalTitlePrecision(){
				    return 0;
				}
				public String isOriginalTitleDefault(){
				
					return null;
				
				}
				public String isOriginalTitleComment(){
				
				    return "";
				
				}
				public String isOriginalTitlePattern(){
				
					return "";
				
				}
				public String isOriginalTitleOriginalDbColumnName(){
				
					return "isOriginalTitle";
				
				}

				
			    public java.util.Date DI_Create_DT;

				public java.util.Date getDI_Create_DT () {
					return this.DI_Create_DT;
				}

				public Boolean DI_Create_DTIsNullable(){
				    return false;
				}
				public Boolean DI_Create_DTIsKey(){
				    return false;
				}
				public Integer DI_Create_DTLength(){
				    return 19;
				}
				public Integer DI_Create_DTPrecision(){
				    return 0;
				}
				public String DI_Create_DTDefault(){
				
					return null;
				
				}
				public String DI_Create_DTComment(){
				
				    return "";
				
				}
				public String DI_Create_DTPattern(){
				
					return "dd-MM-yyyy";
				
				}
				public String DI_Create_DTOriginalDbColumnName(){
				
					return "DI_Create_DT";
				
				}

				
			    public String DI_WorkflowJobId;

				public String getDI_WorkflowJobId () {
					return this.DI_WorkflowJobId;
				}

				public Boolean DI_WorkflowJobIdIsNullable(){
				    return true;
				}
				public Boolean DI_WorkflowJobIdIsKey(){
				    return false;
				}
				public Integer DI_WorkflowJobIdLength(){
				    return 8;
				}
				public Integer DI_WorkflowJobIdPrecision(){
				    return null;
				}
				public String DI_WorkflowJobIdDefault(){
				
					return null;
				
				}
				public String DI_WorkflowJobIdComment(){
				
				    return "";
				
				}
				public String DI_WorkflowJobIdPattern(){
				
					return "";
				
				}
				public String DI_WorkflowJobIdOriginalDbColumnName(){
				
					return "DI_WorkflowJobId";
				
				}

				



	private String readString(ObjectInputStream dis) throws IOException{
		String strReturn = null;
		int length = 0;
        length = dis.readInt();
		if (length == -1) {
			strReturn = null;
		} else {
			if(length > commonByteArray_FINAL_PROJECT_sql_staging_job.length) {
				if(length < 1024 && commonByteArray_FINAL_PROJECT_sql_staging_job.length == 0) {
   					commonByteArray_FINAL_PROJECT_sql_staging_job = new byte[1024];
				} else {
   					commonByteArray_FINAL_PROJECT_sql_staging_job = new byte[2 * length];
   				}
			}
			dis.readFully(commonByteArray_FINAL_PROJECT_sql_staging_job, 0, length);
			strReturn = new String(commonByteArray_FINAL_PROJECT_sql_staging_job, 0, length, utf8Charset);
		}
		return strReturn;
	}
	
	private String readString(org.jboss.marshalling.Unmarshaller unmarshaller) throws IOException{
		String strReturn = null;
		int length = 0;
        length = unmarshaller.readInt();
		if (length == -1) {
			strReturn = null;
		} else {
			if(length > commonByteArray_FINAL_PROJECT_sql_staging_job.length) {
				if(length < 1024 && commonByteArray_FINAL_PROJECT_sql_staging_job.length == 0) {
   					commonByteArray_FINAL_PROJECT_sql_staging_job = new byte[1024];
				} else {
   					commonByteArray_FINAL_PROJECT_sql_staging_job = new byte[2 * length];
   				}
			}
			unmarshaller.readFully(commonByteArray_FINAL_PROJECT_sql_staging_job, 0, length);
			strReturn = new String(commonByteArray_FINAL_PROJECT_sql_staging_job, 0, length, utf8Charset);
		}
		return strReturn;
	}

    private void writeString(String str, ObjectOutputStream dos) throws IOException{
		if(str == null) {
            dos.writeInt(-1);
		} else {
            byte[] byteArray = str.getBytes(utf8Charset);
	    	dos.writeInt(byteArray.length);
			dos.write(byteArray);
    	}
    }
    
    private void writeString(String str, org.jboss.marshalling.Marshaller marshaller) throws IOException{
		if(str == null) {
			marshaller.writeInt(-1);
		} else {
            byte[] byteArray = str.getBytes(utf8Charset);
            marshaller.writeInt(byteArray.length);
            marshaller.write(byteArray);
    	}
    }

	private java.util.Date readDate(ObjectInputStream dis) throws IOException{
		java.util.Date dateReturn = null;
        int length = 0;
        length = dis.readByte();
		if (length == -1) {
			dateReturn = null;
		} else {
	    	dateReturn = new Date(dis.readLong());
		}
		return dateReturn;
	}
	
	private java.util.Date readDate(org.jboss.marshalling.Unmarshaller unmarshaller) throws IOException{
		java.util.Date dateReturn = null;
        int length = 0;
        length = unmarshaller.readByte();
		if (length == -1) {
			dateReturn = null;
		} else {
	    	dateReturn = new Date(unmarshaller.readLong());
		}
		return dateReturn;
	}

    private void writeDate(java.util.Date date1, ObjectOutputStream dos) throws IOException{
		if(date1 == null) {
            dos.writeByte(-1);
		} else {
			dos.writeByte(0);
	    	dos.writeLong(date1.getTime());
    	}
    }
    
    private void writeDate(java.util.Date date1, org.jboss.marshalling.Marshaller marshaller) throws IOException{
		if(date1 == null) {
			marshaller.writeByte(-1);
		} else {
			marshaller.writeByte(0);
			marshaller.writeLong(date1.getTime());
    	}
    }

    public void readData(ObjectInputStream dis) {

		synchronized(commonByteArrayLock_FINAL_PROJECT_sql_staging_job) {

        	try {

        		int length = 0;
		
					this.titleId = readString(dis);
					
			        this.ordering = dis.readInt();
					
					this.title = readString(dis);
					
					this.region = readString(dis);
					
					this.language = readString(dis);
					
					this.types = readString(dis);
					
					this.attributes = readString(dis);
					
					this.isOriginalTitle = readString(dis);
					
					this.DI_Create_DT = readDate(dis);
					
					this.DI_WorkflowJobId = readString(dis);
					
        	} catch (IOException e) {
	            throw new RuntimeException(e);

		

        }

		

      }


    }
    
    public void readData(org.jboss.marshalling.Unmarshaller dis) {

		synchronized(commonByteArrayLock_FINAL_PROJECT_sql_staging_job) {

        	try {

        		int length = 0;
		
					this.titleId = readString(dis);
					
			        this.ordering = dis.readInt();
					
					this.title = readString(dis);
					
					this.region = readString(dis);
					
					this.language = readString(dis);
					
					this.types = readString(dis);
					
					this.attributes = readString(dis);
					
					this.isOriginalTitle = readString(dis);
					
					this.DI_Create_DT = readDate(dis);
					
					this.DI_WorkflowJobId = readString(dis);
					
        	} catch (IOException e) {
	            throw new RuntimeException(e);

		

        }

		

      }


    }

    public void writeData(ObjectOutputStream dos) {
        try {

		
					// String
				
						writeString(this.titleId,dos);
					
					// int
				
		            	dos.writeInt(this.ordering);
					
					// String
				
						writeString(this.title,dos);
					
					// String
				
						writeString(this.region,dos);
					
					// String
				
						writeString(this.language,dos);
					
					// String
				
						writeString(this.types,dos);
					
					// String
				
						writeString(this.attributes,dos);
					
					// String
				
						writeString(this.isOriginalTitle,dos);
					
					// java.util.Date
				
						writeDate(this.DI_Create_DT,dos);
					
					// String
				
						writeString(this.DI_WorkflowJobId,dos);
					
        	} catch (IOException e) {
	            throw new RuntimeException(e);
        }


    }
    
    public void writeData(org.jboss.marshalling.Marshaller dos) {
        try {

		
					// String
				
						writeString(this.titleId,dos);
					
					// int
				
		            	dos.writeInt(this.ordering);
					
					// String
				
						writeString(this.title,dos);
					
					// String
				
						writeString(this.region,dos);
					
					// String
				
						writeString(this.language,dos);
					
					// String
				
						writeString(this.types,dos);
					
					// String
				
						writeString(this.attributes,dos);
					
					// String
				
						writeString(this.isOriginalTitle,dos);
					
					// java.util.Date
				
						writeDate(this.DI_Create_DT,dos);
					
					// String
				
						writeString(this.DI_WorkflowJobId,dos);
					
        	} catch (IOException e) {
	            throw new RuntimeException(e);
        }


    }


    public String toString() {

		StringBuilder sb = new StringBuilder();
		sb.append(super.toString());
		sb.append("[");
		sb.append("titleId="+titleId);
		sb.append(",ordering="+String.valueOf(ordering));
		sb.append(",title="+title);
		sb.append(",region="+region);
		sb.append(",language="+language);
		sb.append(",types="+types);
		sb.append(",attributes="+attributes);
		sb.append(",isOriginalTitle="+isOriginalTitle);
		sb.append(",DI_Create_DT="+String.valueOf(DI_Create_DT));
		sb.append(",DI_WorkflowJobId="+DI_WorkflowJobId);
	    sb.append("]");

	    return sb.toString();
    }
        public String toLogString(){
        	StringBuilder sb = new StringBuilder();
        	
        				if(titleId == null){
        					sb.append("<null>");
        				}else{
            				sb.append(titleId);
            			}
            		
        			sb.append("|");
        		
        				sb.append(ordering);
        			
        			sb.append("|");
        		
        				if(title == null){
        					sb.append("<null>");
        				}else{
            				sb.append(title);
            			}
            		
        			sb.append("|");
        		
        				if(region == null){
        					sb.append("<null>");
        				}else{
            				sb.append(region);
            			}
            		
        			sb.append("|");
        		
        				if(language == null){
        					sb.append("<null>");
        				}else{
            				sb.append(language);
            			}
            		
        			sb.append("|");
        		
        				if(types == null){
        					sb.append("<null>");
        				}else{
            				sb.append(types);
            			}
            		
        			sb.append("|");
        		
        				if(attributes == null){
        					sb.append("<null>");
        				}else{
            				sb.append(attributes);
            			}
            		
        			sb.append("|");
        		
        				if(isOriginalTitle == null){
        					sb.append("<null>");
        				}else{
            				sb.append(isOriginalTitle);
            			}
            		
        			sb.append("|");
        		
        				if(DI_Create_DT == null){
        					sb.append("<null>");
        				}else{
            				sb.append(DI_Create_DT);
            			}
            		
        			sb.append("|");
        		
        				if(DI_WorkflowJobId == null){
        					sb.append("<null>");
        				}else{
            				sb.append(DI_WorkflowJobId);
            			}
            		
        			sb.append("|");
        		
        	return sb.toString();
        }

    /**
     * Compare keys
     */
    public int compareTo(toTableStruct other) {

		int returnValue = -1;
		
	    return returnValue;
    }


    private int checkNullsAndCompare(Object object1, Object object2) {
        int returnValue = 0;
		if (object1 instanceof Comparable && object2 instanceof Comparable) {
            returnValue = ((Comparable) object1).compareTo(object2);
        } else if (object1 != null && object2 != null) {
            returnValue = compareStrings(object1.toString(), object2.toString());
        } else if (object1 == null && object2 != null) {
            returnValue = 1;
        } else if (object1 != null && object2 == null) {
            returnValue = -1;
        } else {
            returnValue = 0;
        }

        return returnValue;
    }

    private int compareStrings(String string1, String string2) {
        return string1.compareTo(string2);
    }


}

public static class row1Struct implements routines.system.IPersistableRow<row1Struct> {
    final static byte[] commonByteArrayLock_FINAL_PROJECT_sql_staging_job = new byte[0];
    static byte[] commonByteArray_FINAL_PROJECT_sql_staging_job = new byte[0];

	
			    public String titleId;

				public String getTitleId () {
					return this.titleId;
				}

				public Boolean titleIdIsNullable(){
				    return false;
				}
				public Boolean titleIdIsKey(){
				    return false;
				}
				public Integer titleIdLength(){
				    return 10;
				}
				public Integer titleIdPrecision(){
				    return 0;
				}
				public String titleIdDefault(){
				
					return null;
				
				}
				public String titleIdComment(){
				
				    return "";
				
				}
				public String titleIdPattern(){
				
					return "";
				
				}
				public String titleIdOriginalDbColumnName(){
				
					return "titleId";
				
				}

				
			    public int ordering;

				public int getOrdering () {
					return this.ordering;
				}

				public Boolean orderingIsNullable(){
				    return false;
				}
				public Boolean orderingIsKey(){
				    return false;
				}
				public Integer orderingLength(){
				    return 10;
				}
				public Integer orderingPrecision(){
				    return 0;
				}
				public String orderingDefault(){
				
					return "";
				
				}
				public String orderingComment(){
				
				    return "";
				
				}
				public String orderingPattern(){
				
					return "";
				
				}
				public String orderingOriginalDbColumnName(){
				
					return "ordering";
				
				}

				
			    public String title;

				public String getTitle () {
					return this.title;
				}

				public Boolean titleIsNullable(){
				    return true;
				}
				public Boolean titleIsKey(){
				    return false;
				}
				public Integer titleLength(){
				    return 1024;
				}
				public Integer titlePrecision(){
				    return 0;
				}
				public String titleDefault(){
				
					return null;
				
				}
				public String titleComment(){
				
				    return "";
				
				}
				public String titlePattern(){
				
					return "";
				
				}
				public String titleOriginalDbColumnName(){
				
					return "title";
				
				}

				
			    public String region;

				public String getRegion () {
					return this.region;
				}

				public Boolean regionIsNullable(){
				    return true;
				}
				public Boolean regionIsKey(){
				    return false;
				}
				public Integer regionLength(){
				    return 255;
				}
				public Integer regionPrecision(){
				    return 0;
				}
				public String regionDefault(){
				
					return null;
				
				}
				public String regionComment(){
				
				    return "";
				
				}
				public String regionPattern(){
				
					return "";
				
				}
				public String regionOriginalDbColumnName(){
				
					return "region";
				
				}

				
			    public String language;

				public String getLanguage () {
					return this.language;
				}

				public Boolean languageIsNullable(){
				    return true;
				}
				public Boolean languageIsKey(){
				    return false;
				}
				public Integer languageLength(){
				    return 255;
				}
				public Integer languagePrecision(){
				    return 0;
				}
				public String languageDefault(){
				
					return null;
				
				}
				public String languageComment(){
				
				    return "";
				
				}
				public String languagePattern(){
				
					return "";
				
				}
				public String languageOriginalDbColumnName(){
				
					return "language";
				
				}

				
			    public String types;

				public String getTypes () {
					return this.types;
				}

				public Boolean typesIsNullable(){
				    return true;
				}
				public Boolean typesIsKey(){
				    return false;
				}
				public Integer typesLength(){
				    return 255;
				}
				public Integer typesPrecision(){
				    return 0;
				}
				public String typesDefault(){
				
					return null;
				
				}
				public String typesComment(){
				
				    return "";
				
				}
				public String typesPattern(){
				
					return "";
				
				}
				public String typesOriginalDbColumnName(){
				
					return "types";
				
				}

				
			    public String attributes;

				public String getAttributes () {
					return this.attributes;
				}

				public Boolean attributesIsNullable(){
				    return true;
				}
				public Boolean attributesIsKey(){
				    return false;
				}
				public Integer attributesLength(){
				    return 1024;
				}
				public Integer attributesPrecision(){
				    return 0;
				}
				public String attributesDefault(){
				
					return null;
				
				}
				public String attributesComment(){
				
				    return "";
				
				}
				public String attributesPattern(){
				
					return "";
				
				}
				public String attributesOriginalDbColumnName(){
				
					return "attributes";
				
				}

				
			    public String isOriginalTitle;

				public String getIsOriginalTitle () {
					return this.isOriginalTitle;
				}

				public Boolean isOriginalTitleIsNullable(){
				    return true;
				}
				public Boolean isOriginalTitleIsKey(){
				    return false;
				}
				public Integer isOriginalTitleLength(){
				    return 255;
				}
				public Integer isOriginalTitlePrecision(){
				    return 0;
				}
				public String isOriginalTitleDefault(){
				
					return null;
				
				}
				public String isOriginalTitleComment(){
				
				    return "";
				
				}
				public String isOriginalTitlePattern(){
				
					return "";
				
				}
				public String isOriginalTitleOriginalDbColumnName(){
				
					return "isOriginalTitle";
				
				}

				
			    public java.util.Date DI_Create_DT;

				public java.util.Date getDI_Create_DT () {
					return this.DI_Create_DT;
				}

				public Boolean DI_Create_DTIsNullable(){
				    return false;
				}
				public Boolean DI_Create_DTIsKey(){
				    return false;
				}
				public Integer DI_Create_DTLength(){
				    return 19;
				}
				public Integer DI_Create_DTPrecision(){
				    return 0;
				}
				public String DI_Create_DTDefault(){
				
					return null;
				
				}
				public String DI_Create_DTComment(){
				
				    return "";
				
				}
				public String DI_Create_DTPattern(){
				
					return "dd-MM-yyyy";
				
				}
				public String DI_Create_DTOriginalDbColumnName(){
				
					return "DI_Create_DT";
				
				}

				



	private String readString(ObjectInputStream dis) throws IOException{
		String strReturn = null;
		int length = 0;
        length = dis.readInt();
		if (length == -1) {
			strReturn = null;
		} else {
			if(length > commonByteArray_FINAL_PROJECT_sql_staging_job.length) {
				if(length < 1024 && commonByteArray_FINAL_PROJECT_sql_staging_job.length == 0) {
   					commonByteArray_FINAL_PROJECT_sql_staging_job = new byte[1024];
				} else {
   					commonByteArray_FINAL_PROJECT_sql_staging_job = new byte[2 * length];
   				}
			}
			dis.readFully(commonByteArray_FINAL_PROJECT_sql_staging_job, 0, length);
			strReturn = new String(commonByteArray_FINAL_PROJECT_sql_staging_job, 0, length, utf8Charset);
		}
		return strReturn;
	}
	
	private String readString(org.jboss.marshalling.Unmarshaller unmarshaller) throws IOException{
		String strReturn = null;
		int length = 0;
        length = unmarshaller.readInt();
		if (length == -1) {
			strReturn = null;
		} else {
			if(length > commonByteArray_FINAL_PROJECT_sql_staging_job.length) {
				if(length < 1024 && commonByteArray_FINAL_PROJECT_sql_staging_job.length == 0) {
   					commonByteArray_FINAL_PROJECT_sql_staging_job = new byte[1024];
				} else {
   					commonByteArray_FINAL_PROJECT_sql_staging_job = new byte[2 * length];
   				}
			}
			unmarshaller.readFully(commonByteArray_FINAL_PROJECT_sql_staging_job, 0, length);
			strReturn = new String(commonByteArray_FINAL_PROJECT_sql_staging_job, 0, length, utf8Charset);
		}
		return strReturn;
	}

    private void writeString(String str, ObjectOutputStream dos) throws IOException{
		if(str == null) {
            dos.writeInt(-1);
		} else {
            byte[] byteArray = str.getBytes(utf8Charset);
	    	dos.writeInt(byteArray.length);
			dos.write(byteArray);
    	}
    }
    
    private void writeString(String str, org.jboss.marshalling.Marshaller marshaller) throws IOException{
		if(str == null) {
			marshaller.writeInt(-1);
		} else {
            byte[] byteArray = str.getBytes(utf8Charset);
            marshaller.writeInt(byteArray.length);
            marshaller.write(byteArray);
    	}
    }

	private java.util.Date readDate(ObjectInputStream dis) throws IOException{
		java.util.Date dateReturn = null;
        int length = 0;
        length = dis.readByte();
		if (length == -1) {
			dateReturn = null;
		} else {
	    	dateReturn = new Date(dis.readLong());
		}
		return dateReturn;
	}
	
	private java.util.Date readDate(org.jboss.marshalling.Unmarshaller unmarshaller) throws IOException{
		java.util.Date dateReturn = null;
        int length = 0;
        length = unmarshaller.readByte();
		if (length == -1) {
			dateReturn = null;
		} else {
	    	dateReturn = new Date(unmarshaller.readLong());
		}
		return dateReturn;
	}

    private void writeDate(java.util.Date date1, ObjectOutputStream dos) throws IOException{
		if(date1 == null) {
            dos.writeByte(-1);
		} else {
			dos.writeByte(0);
	    	dos.writeLong(date1.getTime());
    	}
    }
    
    private void writeDate(java.util.Date date1, org.jboss.marshalling.Marshaller marshaller) throws IOException{
		if(date1 == null) {
			marshaller.writeByte(-1);
		} else {
			marshaller.writeByte(0);
			marshaller.writeLong(date1.getTime());
    	}
    }

    public void readData(ObjectInputStream dis) {

		synchronized(commonByteArrayLock_FINAL_PROJECT_sql_staging_job) {

        	try {

        		int length = 0;
		
					this.titleId = readString(dis);
					
			        this.ordering = dis.readInt();
					
					this.title = readString(dis);
					
					this.region = readString(dis);
					
					this.language = readString(dis);
					
					this.types = readString(dis);
					
					this.attributes = readString(dis);
					
					this.isOriginalTitle = readString(dis);
					
					this.DI_Create_DT = readDate(dis);
					
        	} catch (IOException e) {
	            throw new RuntimeException(e);

		

        }

		

      }


    }
    
    public void readData(org.jboss.marshalling.Unmarshaller dis) {

		synchronized(commonByteArrayLock_FINAL_PROJECT_sql_staging_job) {

        	try {

        		int length = 0;
		
					this.titleId = readString(dis);
					
			        this.ordering = dis.readInt();
					
					this.title = readString(dis);
					
					this.region = readString(dis);
					
					this.language = readString(dis);
					
					this.types = readString(dis);
					
					this.attributes = readString(dis);
					
					this.isOriginalTitle = readString(dis);
					
					this.DI_Create_DT = readDate(dis);
					
        	} catch (IOException e) {
	            throw new RuntimeException(e);

		

        }

		

      }


    }

    public void writeData(ObjectOutputStream dos) {
        try {

		
					// String
				
						writeString(this.titleId,dos);
					
					// int
				
		            	dos.writeInt(this.ordering);
					
					// String
				
						writeString(this.title,dos);
					
					// String
				
						writeString(this.region,dos);
					
					// String
				
						writeString(this.language,dos);
					
					// String
				
						writeString(this.types,dos);
					
					// String
				
						writeString(this.attributes,dos);
					
					// String
				
						writeString(this.isOriginalTitle,dos);
					
					// java.util.Date
				
						writeDate(this.DI_Create_DT,dos);
					
        	} catch (IOException e) {
	            throw new RuntimeException(e);
        }


    }
    
    public void writeData(org.jboss.marshalling.Marshaller dos) {
        try {

		
					// String
				
						writeString(this.titleId,dos);
					
					// int
				
		            	dos.writeInt(this.ordering);
					
					// String
				
						writeString(this.title,dos);
					
					// String
				
						writeString(this.region,dos);
					
					// String
				
						writeString(this.language,dos);
					
					// String
				
						writeString(this.types,dos);
					
					// String
				
						writeString(this.attributes,dos);
					
					// String
				
						writeString(this.isOriginalTitle,dos);
					
					// java.util.Date
				
						writeDate(this.DI_Create_DT,dos);
					
        	} catch (IOException e) {
	            throw new RuntimeException(e);
        }


    }


    public String toString() {

		StringBuilder sb = new StringBuilder();
		sb.append(super.toString());
		sb.append("[");
		sb.append("titleId="+titleId);
		sb.append(",ordering="+String.valueOf(ordering));
		sb.append(",title="+title);
		sb.append(",region="+region);
		sb.append(",language="+language);
		sb.append(",types="+types);
		sb.append(",attributes="+attributes);
		sb.append(",isOriginalTitle="+isOriginalTitle);
		sb.append(",DI_Create_DT="+String.valueOf(DI_Create_DT));
	    sb.append("]");

	    return sb.toString();
    }
        public String toLogString(){
        	StringBuilder sb = new StringBuilder();
        	
        				if(titleId == null){
        					sb.append("<null>");
        				}else{
            				sb.append(titleId);
            			}
            		
        			sb.append("|");
        		
        				sb.append(ordering);
        			
        			sb.append("|");
        		
        				if(title == null){
        					sb.append("<null>");
        				}else{
            				sb.append(title);
            			}
            		
        			sb.append("|");
        		
        				if(region == null){
        					sb.append("<null>");
        				}else{
            				sb.append(region);
            			}
            		
        			sb.append("|");
        		
        				if(language == null){
        					sb.append("<null>");
        				}else{
            				sb.append(language);
            			}
            		
        			sb.append("|");
        		
        				if(types == null){
        					sb.append("<null>");
        				}else{
            				sb.append(types);
            			}
            		
        			sb.append("|");
        		
        				if(attributes == null){
        					sb.append("<null>");
        				}else{
            				sb.append(attributes);
            			}
            		
        			sb.append("|");
        		
        				if(isOriginalTitle == null){
        					sb.append("<null>");
        				}else{
            				sb.append(isOriginalTitle);
            			}
            		
        			sb.append("|");
        		
        				if(DI_Create_DT == null){
        					sb.append("<null>");
        				}else{
            				sb.append(DI_Create_DT);
            			}
            		
        			sb.append("|");
        		
        	return sb.toString();
        }

    /**
     * Compare keys
     */
    public int compareTo(row1Struct other) {

		int returnValue = -1;
		
	    return returnValue;
    }


    private int checkNullsAndCompare(Object object1, Object object2) {
        int returnValue = 0;
		if (object1 instanceof Comparable && object2 instanceof Comparable) {
            returnValue = ((Comparable) object1).compareTo(object2);
        } else if (object1 != null && object2 != null) {
            returnValue = compareStrings(object1.toString(), object2.toString());
        } else if (object1 == null && object2 != null) {
            returnValue = 1;
        } else if (object1 != null && object2 == null) {
            returnValue = -1;
        } else {
            returnValue = 0;
        }

        return returnValue;
    }

    private int compareStrings(String string1, String string2) {
        return string1.compareTo(string2);
    }


}

public void tDBInput_1Process(final java.util.Map<String, Object> globalMap) throws TalendException {
	globalMap.put("tDBInput_1_SUBPROCESS_STATE", 0);

 final boolean execStat = this.execStat;
	
		mdcInfo.forEach(org.slf4j.MDC::put);
		org.slf4j.MDC.put("_subJobName", "tDBInput_1");
		org.slf4j.MDC.put("_subJobPid", "B0o9JU_" + subJobPidCounter.getAndIncrement());
	

	
		String iterateId = "";
	
	
	String currentComponent = "";
	String cLabel =  null;
	java.util.Map<String, Object> resourceMap = new java.util.HashMap<String, Object>();

	try {
			// TDI-39566 avoid throwing an useless Exception
			boolean resumeIt = true;
			if (globalResumeTicket == false && resumeEntryMethodName != null) {
				String currentMethodName = new java.lang.Exception().getStackTrace()[0].getMethodName();
				resumeIt = resumeEntryMethodName.equals(currentMethodName);
			}
			if (resumeIt || globalResumeTicket) { //start the resume
				globalResumeTicket = true;



		row1Struct row1 = new row1Struct();
toTableStruct toTable = new toTableStruct();





	
	/**
	 * [tDBOutput_1 begin ] start
	 */

	

	
		
		ok_Hash.put("tDBOutput_1", false);
		start_Hash.put("tDBOutput_1", System.currentTimeMillis());
		
	
	currentComponent="tDBOutput_1";
	
	
			cLabel="stg_movie_releases";
		
			runStat.updateStatAndLog(execStat,enableLogStash,resourceMap,iterateId,0,0,"toTable");
			
		int tos_count_tDBOutput_1 = 0;
		
                if(log.isDebugEnabled())
            log.debug("tDBOutput_1 - "  + ("Start to work.") );
            if (log.isDebugEnabled()) {
                class BytesLimit65535_tDBOutput_1{
                    public void limitLog4jByte() throws Exception{
                    StringBuilder log4jParamters_tDBOutput_1 = new StringBuilder();
                    log4jParamters_tDBOutput_1.append("Parameters:");
                            log4jParamters_tDBOutput_1.append("DB_VERSION" + " = " + "MYSQL_8");
                        log4jParamters_tDBOutput_1.append(" | ");
                            log4jParamters_tDBOutput_1.append("USE_EXISTING_CONNECTION" + " = " + "false");
                        log4jParamters_tDBOutput_1.append(" | ");
                            log4jParamters_tDBOutput_1.append("HOST" + " = " + "context.MySqlLocal_Server");
                        log4jParamters_tDBOutput_1.append(" | ");
                            log4jParamters_tDBOutput_1.append("PORT" + " = " + "context.MySqlLocal_Port");
                        log4jParamters_tDBOutput_1.append(" | ");
                            log4jParamters_tDBOutput_1.append("DBNAME" + " = " + "context.MySqlLocal_Database");
                        log4jParamters_tDBOutput_1.append(" | ");
                            log4jParamters_tDBOutput_1.append("USER" + " = " + "context.MySqlLocal_Login");
                        log4jParamters_tDBOutput_1.append(" | ");
                            log4jParamters_tDBOutput_1.append("PASS" + " = " + String.valueOf(routines.system.PasswordEncryptUtil.encryptPassword(context.MySqlLocal_Password)).substring(0, 4) + "...");     
                        log4jParamters_tDBOutput_1.append(" | ");
                            log4jParamters_tDBOutput_1.append("TABLE" + " = " + "\"stg_movie_releases\"");
                        log4jParamters_tDBOutput_1.append(" | ");
                            log4jParamters_tDBOutput_1.append("TABLE_ACTION" + " = " + "CREATE_IF_NOT_EXISTS");
                        log4jParamters_tDBOutput_1.append(" | ");
                            log4jParamters_tDBOutput_1.append("DATA_ACTION" + " = " + "INSERT");
                        log4jParamters_tDBOutput_1.append(" | ");
                            log4jParamters_tDBOutput_1.append("SPECIFY_DATASOURCE_ALIAS" + " = " + "false");
                        log4jParamters_tDBOutput_1.append(" | ");
                            log4jParamters_tDBOutput_1.append("DIE_ON_ERROR" + " = " + "false");
                        log4jParamters_tDBOutput_1.append(" | ");
                            log4jParamters_tDBOutput_1.append("PROPERTIES" + " = " + "context.MySqlLocal_AdditionalParams");
                        log4jParamters_tDBOutput_1.append(" | ");
                            log4jParamters_tDBOutput_1.append("EXTENDINSERT" + " = " + "true");
                        log4jParamters_tDBOutput_1.append(" | ");
                            log4jParamters_tDBOutput_1.append("NB_ROWS_PER_INSERT" + " = " + "100");
                        log4jParamters_tDBOutput_1.append(" | ");
                            log4jParamters_tDBOutput_1.append("COMMIT_EVERY" + " = " + "10000");
                        log4jParamters_tDBOutput_1.append(" | ");
                            log4jParamters_tDBOutput_1.append("ADD_COLS" + " = " + "[]");
                        log4jParamters_tDBOutput_1.append(" | ");
                            log4jParamters_tDBOutput_1.append("USE_FIELD_OPTIONS" + " = " + "false");
                        log4jParamters_tDBOutput_1.append(" | ");
                            log4jParamters_tDBOutput_1.append("USE_HINT_OPTIONS" + " = " + "false");
                        log4jParamters_tDBOutput_1.append(" | ");
                            log4jParamters_tDBOutput_1.append("ENABLE_DEBUG_MODE" + " = " + "false");
                        log4jParamters_tDBOutput_1.append(" | ");
                            log4jParamters_tDBOutput_1.append("ON_DUPLICATE_KEY_UPDATE" + " = " + "false");
                        log4jParamters_tDBOutput_1.append(" | ");
                            log4jParamters_tDBOutput_1.append("UNIFIED_COMPONENTS" + " = " + "tMysqlOutput");
                        log4jParamters_tDBOutput_1.append(" | ");
                if(log.isDebugEnabled())
            log.debug("tDBOutput_1 - "  + (log4jParamters_tDBOutput_1) );
                    } 
                } 
            new BytesLimit65535_tDBOutput_1().limitLog4jByte();
            }
			if(enableLogStash) {
				talendJobLog.addCM("tDBOutput_1", "stg_movie_releases", "tMysqlOutput");
				talendJobLogProcess(globalMap);
			}
			







int nb_line_tDBOutput_1 = 0;
int nb_line_update_tDBOutput_1 = 0;
int nb_line_inserted_tDBOutput_1 = 0;
int nb_line_deleted_tDBOutput_1 = 0;
int nb_line_rejected_tDBOutput_1 = 0;

int deletedCount_tDBOutput_1=0;
int updatedCount_tDBOutput_1=0;
int insertedCount_tDBOutput_1=0;
int rowsToCommitCount_tDBOutput_1=0;
int rejectedCount_tDBOutput_1=0;

String tableName_tDBOutput_1 = "stg_movie_releases";
boolean whetherReject_tDBOutput_1 = false;

java.util.Calendar calendar_tDBOutput_1 = java.util.Calendar.getInstance();
calendar_tDBOutput_1.set(1, 0, 1, 0, 0, 0);
long year1_tDBOutput_1 = calendar_tDBOutput_1.getTime().getTime();
calendar_tDBOutput_1.set(10000, 0, 1, 0, 0, 0);
long year10000_tDBOutput_1 = calendar_tDBOutput_1.getTime().getTime();
long date_tDBOutput_1;

java.sql.Connection conn_tDBOutput_1 = null;
		
			
        String properties_tDBOutput_1 = context.MySqlLocal_AdditionalParams;
        if (properties_tDBOutput_1 == null || properties_tDBOutput_1.trim().length() == 0) {
            properties_tDBOutput_1 = "rewriteBatchedStatements=true&allowLoadLocalInfile=true";
        }else {
            if (!properties_tDBOutput_1.contains("rewriteBatchedStatements=")) {
                properties_tDBOutput_1 += "&rewriteBatchedStatements=true";
            }

            if (!properties_tDBOutput_1.contains("allowLoadLocalInfile=")) {
                properties_tDBOutput_1 += "&allowLoadLocalInfile=true";
            }
        }

        String url_tDBOutput_1 = "jdbc:mysql://" + context.MySqlLocal_Server + ":" + context.MySqlLocal_Port + "/" + context.MySqlLocal_Database + "?" + properties_tDBOutput_1;

			String driverClass_tDBOutput_1 = "com.mysql.cj.jdbc.Driver";
			
                if(log.isDebugEnabled())
            log.debug("tDBOutput_1 - "  + ("Driver ClassName: ")  + (driverClass_tDBOutput_1)  + (".") );
			String dbUser_tDBOutput_1 = context.MySqlLocal_Login;
			

			
	final String decryptedPassword_tDBOutput_1 = context.MySqlLocal_Password; 

			String dbPwd_tDBOutput_1 = decryptedPassword_tDBOutput_1;
			java.lang.Class.forName(driverClass_tDBOutput_1);
			
                if(log.isDebugEnabled())
            log.debug("tDBOutput_1 - "  + ("Connection attempts to '")  + (url_tDBOutput_1)  + ("' with the username '")  + (dbUser_tDBOutput_1)  + ("'.") );
			conn_tDBOutput_1 = java.sql.DriverManager.getConnection(url_tDBOutput_1, dbUser_tDBOutput_1, dbPwd_tDBOutput_1);
			
                if(log.isDebugEnabled())
            log.debug("tDBOutput_1 - "  + ("Connection to '")  + (url_tDBOutput_1)  + ("' has succeeded.") );
			
	resourceMap.put("conn_tDBOutput_1", conn_tDBOutput_1);
	
			conn_tDBOutput_1.setAutoCommit(false);
			int commitEvery_tDBOutput_1 = 10000;
			int commitCounter_tDBOutput_1 = 0;
			
                if(log.isDebugEnabled())
            log.debug("tDBOutput_1 - "  + ("Connection is set auto commit to '")  + (conn_tDBOutput_1.getAutoCommit())  + ("'.") );

		int count_tDBOutput_1=0;
		
				
                                java.sql.DatabaseMetaData dbMetaData_tDBOutput_1 = conn_tDBOutput_1.getMetaData();
                                    java.sql.ResultSet rsTable_tDBOutput_1 = dbMetaData_tDBOutput_1.getTables(context.MySqlLocal_Database, null, null, new String[]{"TABLE"});
                                boolean whetherExist_tDBOutput_1 = false;
                                while(rsTable_tDBOutput_1.next()) {
                                    String table_tDBOutput_1 = rsTable_tDBOutput_1.getString("TABLE_NAME");
                                    if(table_tDBOutput_1.equalsIgnoreCase("stg_movie_releases")) {
                                        whetherExist_tDBOutput_1 = true;
                                        break;
                                    }
                                }
                                if(!whetherExist_tDBOutput_1) {
                                    try (java.sql.Statement stmtCreate_tDBOutput_1 = conn_tDBOutput_1.createStatement()) {
                if(log.isDebugEnabled())
            log.debug("tDBOutput_1 - "  + ("Creating")  + (" table '")  + (tableName_tDBOutput_1)  + ("'.") );
                                        stmtCreate_tDBOutput_1.execute("CREATE TABLE `" + tableName_tDBOutput_1 + "`(`titleId` VARCHAR(10)   not null ,`ordering` INT(10)   not null ,`title` VARCHAR(1024)  ,`region` VARCHAR(255)  ,`language` VARCHAR(255)  ,`types` VARCHAR(255)  ,`attributes` VARCHAR(1024)  ,`isOriginalTitle` VARCHAR(255)  ,`DI_Create_DT` DATETIME  not null ,`DI_WorkflowJobId` VARCHAR(8)  )");
                if(log.isDebugEnabled())
            log.debug("tDBOutput_1 - "  + ("Create")  + (" table '")  + (tableName_tDBOutput_1)  + ("' has succeeded.") );
                                    }
                                }
			

		
						String insert_tDBOutput_1 = "INSERT INTO `" + "stg_movie_releases" + "` (`titleId`,`ordering`,`title`,`region`,`language`,`types`,`attributes`,`isOriginalTitle`,`DI_Create_DT`,`DI_WorkflowJobId`) VALUES (?,?,?,?,?,?,?,?,?,?)";
		
						int batchSize_tDBOutput_1 = 100;
						int batchSizeCounter_tDBOutput_1=0;
						    
						java.sql.PreparedStatement pstmt_tDBOutput_1 = conn_tDBOutput_1.prepareStatement(insert_tDBOutput_1);
						resourceMap.put("pstmt_tDBOutput_1", pstmt_tDBOutput_1);

		


 



/**
 * [tDBOutput_1 begin ] stop
 */



	
	/**
	 * [tMap_1 begin ] start
	 */

	

	
		
		ok_Hash.put("tMap_1", false);
		start_Hash.put("tMap_1", System.currentTimeMillis());
		
	
	currentComponent="tMap_1";
	
	
			runStat.updateStatAndLog(execStat,enableLogStash,resourceMap,iterateId,0,0,"row1");
			
		int tos_count_tMap_1 = 0;
		
                if(log.isDebugEnabled())
            log.debug("tMap_1 - "  + ("Start to work.") );
            if (log.isDebugEnabled()) {
                class BytesLimit65535_tMap_1{
                    public void limitLog4jByte() throws Exception{
                    StringBuilder log4jParamters_tMap_1 = new StringBuilder();
                    log4jParamters_tMap_1.append("Parameters:");
                            log4jParamters_tMap_1.append("LINK_STYLE" + " = " + "AUTO");
                        log4jParamters_tMap_1.append(" | ");
                            log4jParamters_tMap_1.append("TEMPORARY_DATA_DIRECTORY" + " = " + "");
                        log4jParamters_tMap_1.append(" | ");
                            log4jParamters_tMap_1.append("ROWS_BUFFER_SIZE" + " = " + "2000000");
                        log4jParamters_tMap_1.append(" | ");
                            log4jParamters_tMap_1.append("CHANGE_HASH_AND_EQUALS_FOR_BIGDECIMAL" + " = " + "true");
                        log4jParamters_tMap_1.append(" | ");
                if(log.isDebugEnabled())
            log.debug("tMap_1 - "  + (log4jParamters_tMap_1) );
                    } 
                } 
            new BytesLimit65535_tMap_1().limitLog4jByte();
            }
			if(enableLogStash) {
				talendJobLog.addCM("tMap_1", "tMap_1", "tMap");
				talendJobLogProcess(globalMap);
			}
			




// ###############################
// # Lookup's keys initialization
		int count_row1_tMap_1 = 0;
		
// ###############################        

// ###############################
// # Vars initialization
class  Var__tMap_1__Struct  {
}
Var__tMap_1__Struct Var__tMap_1 = new Var__tMap_1__Struct();
// ###############################

// ###############################
// # Outputs initialization
				int count_toTable_tMap_1 = 0;
				
toTableStruct toTable_tmp = new toTableStruct();
// ###############################

        
        



        









 



/**
 * [tMap_1 begin ] stop
 */



	
	/**
	 * [tDBInput_1 begin ] start
	 */

	

	
		
		ok_Hash.put("tDBInput_1", false);
		start_Hash.put("tDBInput_1", System.currentTimeMillis());
		
	
	currentComponent="tDBInput_1";
	
	
			cLabel="imdb_title_akas";
		
		int tos_count_tDBInput_1 = 0;
		
                if(log.isDebugEnabled())
            log.debug("tDBInput_1 - "  + ("Start to work.") );
            if (log.isDebugEnabled()) {
                class BytesLimit65535_tDBInput_1{
                    public void limitLog4jByte() throws Exception{
                    StringBuilder log4jParamters_tDBInput_1 = new StringBuilder();
                    log4jParamters_tDBInput_1.append("Parameters:");
                            log4jParamters_tDBInput_1.append("DB_VERSION" + " = " + "MYSQL_8");
                        log4jParamters_tDBInput_1.append(" | ");
                            log4jParamters_tDBInput_1.append("USE_EXISTING_CONNECTION" + " = " + "false");
                        log4jParamters_tDBInput_1.append(" | ");
                            log4jParamters_tDBInput_1.append("HOST" + " = " + "context.MySqlLocal_Server");
                        log4jParamters_tDBInput_1.append(" | ");
                            log4jParamters_tDBInput_1.append("PORT" + " = " + "context.MySqlLocal_Port");
                        log4jParamters_tDBInput_1.append(" | ");
                            log4jParamters_tDBInput_1.append("DBNAME" + " = " + "context.MySqlLocal_Database");
                        log4jParamters_tDBInput_1.append(" | ");
                            log4jParamters_tDBInput_1.append("USER" + " = " + "context.MySqlLocal_Login");
                        log4jParamters_tDBInput_1.append(" | ");
                            log4jParamters_tDBInput_1.append("PASS" + " = " + String.valueOf(routines.system.PasswordEncryptUtil.encryptPassword(context.MySqlLocal_Password)).substring(0, 4) + "...");     
                        log4jParamters_tDBInput_1.append(" | ");
                            log4jParamters_tDBInput_1.append("TABLE" + " = " + "\"imdb_title_akas\"");
                        log4jParamters_tDBInput_1.append(" | ");
                            log4jParamters_tDBInput_1.append("QUERYSTORE" + " = " + "\"\"");
                        log4jParamters_tDBInput_1.append(" | ");
                            log4jParamters_tDBInput_1.append("QUERY" + " = " + "\"SELECT * FROM imdb_title_akas;\"");
                        log4jParamters_tDBInput_1.append(" | ");
                            log4jParamters_tDBInput_1.append("SPECIFY_DATASOURCE_ALIAS" + " = " + "false");
                        log4jParamters_tDBInput_1.append(" | ");
                            log4jParamters_tDBInput_1.append("PROPERTIES" + " = " + "context.MySqlLocal_AdditionalParams");
                        log4jParamters_tDBInput_1.append(" | ");
                            log4jParamters_tDBInput_1.append("ENABLE_STREAM" + " = " + "false");
                        log4jParamters_tDBInput_1.append(" | ");
                            log4jParamters_tDBInput_1.append("TRIM_ALL_COLUMN" + " = " + "false");
                        log4jParamters_tDBInput_1.append(" | ");
                            log4jParamters_tDBInput_1.append("TRIM_COLUMN" + " = " + "[{TRIM="+("false")+", SCHEMA_COLUMN="+("titleId")+"}, {TRIM="+("false")+", SCHEMA_COLUMN="+("ordering")+"}, {TRIM="+("false")+", SCHEMA_COLUMN="+("title")+"}, {TRIM="+("false")+", SCHEMA_COLUMN="+("region")+"}, {TRIM="+("false")+", SCHEMA_COLUMN="+("language")+"}, {TRIM="+("false")+", SCHEMA_COLUMN="+("types")+"}, {TRIM="+("false")+", SCHEMA_COLUMN="+("attributes")+"}, {TRIM="+("false")+", SCHEMA_COLUMN="+("isOriginalTitle")+"}, {TRIM="+("false")+", SCHEMA_COLUMN="+("DI_Create_DT")+"}]");
                        log4jParamters_tDBInput_1.append(" | ");
                            log4jParamters_tDBInput_1.append("UNIFIED_COMPONENTS" + " = " + "tMysqlInput");
                        log4jParamters_tDBInput_1.append(" | ");
                if(log.isDebugEnabled())
            log.debug("tDBInput_1 - "  + (log4jParamters_tDBInput_1) );
                    } 
                } 
            new BytesLimit65535_tDBInput_1().limitLog4jByte();
            }
			if(enableLogStash) {
				talendJobLog.addCM("tDBInput_1", "imdb_title_akas", "tMysqlInput");
				talendJobLogProcess(globalMap);
			}
			
	
	
		    java.util.Calendar calendar_tDBInput_1 = java.util.Calendar.getInstance();
		    calendar_tDBInput_1.set(0, 0, 0, 0, 0, 0);
		    java.util.Date year0_tDBInput_1 = calendar_tDBInput_1.getTime();
		    int nb_line_tDBInput_1 = 0;
		    java.sql.Connection conn_tDBInput_1 = null;
				String driverClass_tDBInput_1 = "com.mysql.cj.jdbc.Driver";
			    java.lang.Class jdbcclazz_tDBInput_1 = java.lang.Class.forName(driverClass_tDBInput_1);
				String dbUser_tDBInput_1 = context.MySqlLocal_Login;
				
				
	final String decryptedPassword_tDBInput_1 = context.MySqlLocal_Password; 
				
				String dbPwd_tDBInput_1 = decryptedPassword_tDBInput_1;
				
        String properties_tDBInput_1 = context.MySqlLocal_AdditionalParams;
        if (properties_tDBInput_1 == null || properties_tDBInput_1.trim().length() == 0) {
            properties_tDBInput_1 = "";
        }
        String url_tDBInput_1 = "jdbc:mysql://" + context.MySqlLocal_Server + ":" + context.MySqlLocal_Port + "/" + context.MySqlLocal_Database + "?" + properties_tDBInput_1;
				
	    		log.debug("tDBInput_1 - Driver ClassName: "+driverClass_tDBInput_1+".");
			
	    		log.debug("tDBInput_1 - Connection attempt to '" + url_tDBInput_1 + "' with the username '" + dbUser_tDBInput_1 + "'.");
			
				conn_tDBInput_1 = java.sql.DriverManager.getConnection(url_tDBInput_1,dbUser_tDBInput_1,dbPwd_tDBInput_1);
	    		log.debug("tDBInput_1 - Connection to '" + url_tDBInput_1 + "' has succeeded.");
			
		        
		    
			java.sql.Statement stmt_tDBInput_1 = conn_tDBInput_1.createStatement();

		    String dbquery_tDBInput_1 = "SELECT * FROM imdb_title_akas;";
		    
	    		log.debug("tDBInput_1 - Executing the query: '" + dbquery_tDBInput_1 + "'.");
			

		    globalMap.put("tDBInput_1_QUERY",dbquery_tDBInput_1);

		    java.sql.ResultSet rs_tDBInput_1 = null;

		    try {
		    	rs_tDBInput_1 = stmt_tDBInput_1.executeQuery(dbquery_tDBInput_1);
		    	java.sql.ResultSetMetaData rsmd_tDBInput_1 = rs_tDBInput_1.getMetaData();
		    	int colQtyInRs_tDBInput_1 = rsmd_tDBInput_1.getColumnCount();

		    String tmpContent_tDBInput_1 = null;
		    
		    
		    	log.debug("tDBInput_1 - Retrieving records from the database.");
		    
		    while (rs_tDBInput_1.next()) {
		        nb_line_tDBInput_1++;
		        
							if(colQtyInRs_tDBInput_1 < 1) {
								row1.titleId = null;
							} else {
	                         		
        	row1.titleId = routines.system.JDBCUtil.getString(rs_tDBInput_1, 1, false);
		                    }
							if(colQtyInRs_tDBInput_1 < 2) {
								row1.ordering = 0;
							} else {
		                          
            row1.ordering = rs_tDBInput_1.getInt(2);
            if(rs_tDBInput_1.wasNull()){
                    throw new RuntimeException("Null value in non-Nullable column");
            }
		                    }
							if(colQtyInRs_tDBInput_1 < 3) {
								row1.title = null;
							} else {
	                         		
        	row1.title = routines.system.JDBCUtil.getString(rs_tDBInput_1, 3, false);
		                    }
							if(colQtyInRs_tDBInput_1 < 4) {
								row1.region = null;
							} else {
	                         		
        	row1.region = routines.system.JDBCUtil.getString(rs_tDBInput_1, 4, false);
		                    }
							if(colQtyInRs_tDBInput_1 < 5) {
								row1.language = null;
							} else {
	                         		
        	row1.language = routines.system.JDBCUtil.getString(rs_tDBInput_1, 5, false);
		                    }
							if(colQtyInRs_tDBInput_1 < 6) {
								row1.types = null;
							} else {
	                         		
        	row1.types = routines.system.JDBCUtil.getString(rs_tDBInput_1, 6, false);
		                    }
							if(colQtyInRs_tDBInput_1 < 7) {
								row1.attributes = null;
							} else {
	                         		
        	row1.attributes = routines.system.JDBCUtil.getString(rs_tDBInput_1, 7, false);
		                    }
							if(colQtyInRs_tDBInput_1 < 8) {
								row1.isOriginalTitle = null;
							} else {
	                         		
        	row1.isOriginalTitle = routines.system.JDBCUtil.getString(rs_tDBInput_1, 8, false);
		                    }
							if(colQtyInRs_tDBInput_1 < 9) {
								row1.DI_Create_DT = null;
							} else {
										
				if(rs_tDBInput_1.getString(9) != null) {
					String dateString_tDBInput_1 = rs_tDBInput_1.getString(9);
					if (!("0000-00-00").equals(dateString_tDBInput_1) && !("0000-00-00 00:00:00").equals(dateString_tDBInput_1)) {
						row1.DI_Create_DT = rs_tDBInput_1.getTimestamp(9);
					} else {
						row1.DI_Create_DT = (java.util.Date) year0_tDBInput_1.clone();
					}
				} else {
					row1.DI_Create_DT =  null;
				}
		                    }
					
						log.debug("tDBInput_1 - Retrieving the record " + nb_line_tDBInput_1 + ".");
					

 



/**
 * [tDBInput_1 begin ] stop
 */
	
	/**
	 * [tDBInput_1 main ] start
	 */

	

	
	
	currentComponent="tDBInput_1";
	
	
			cLabel="imdb_title_akas";
		

 


	tos_count_tDBInput_1++;

/**
 * [tDBInput_1 main ] stop
 */
	
	/**
	 * [tDBInput_1 process_data_begin ] start
	 */

	

	
	
	currentComponent="tDBInput_1";
	
	
			cLabel="imdb_title_akas";
		

 



/**
 * [tDBInput_1 process_data_begin ] stop
 */

	
	/**
	 * [tMap_1 main ] start
	 */

	

	
	
	currentComponent="tMap_1";
	
	
			if(runStat.update(execStat,enableLogStash,iterateId,1,1
				
					,"row1","tDBInput_1","imdb_title_akas","tMysqlInput","tMap_1","tMap_1","tMap"
				
			)) {
				talendJobLogProcess(globalMap);
			}
			
    			if(log.isTraceEnabled()){
    				log.trace("row1 - " + (row1==null? "": row1.toLogString()));
    			}
    		

		
		
		boolean hasCasePrimitiveKeyWithNull_tMap_1 = false;
		
		// ###############################
		// # Input tables (lookups)
		
		boolean rejectedInnerJoin_tMap_1 = false;
		boolean mainRowRejected_tMap_1 = false;
		// ###############################
        { // start of Var scope
        
	        // ###############################
        	// # Vars tables
        
Var__tMap_1__Struct Var = Var__tMap_1;// ###############################
        // ###############################
        // # Output tables

toTable = null;


// # Output table : 'toTable'
count_toTable_tMap_1++;

toTable_tmp.titleId = row1.titleId;
toTable_tmp.ordering = row1.ordering;
toTable_tmp.title = row1.title;
toTable_tmp.region = row1.region;
toTable_tmp.language = row1.language;
toTable_tmp.types = row1.types;
toTable_tmp.attributes = row1.attributes;
toTable_tmp.isOriginalTitle = row1.isOriginalTitle;
toTable_tmp.DI_Create_DT = TalendDate.getCurrentDate();
toTable_tmp.DI_WorkflowJobId = pid;
toTable = toTable_tmp;
log.debug("tMap_1 - Outputting the record " + count_toTable_tMap_1 + " of the output table 'toTable'.");

// ###############################

} // end of Var scope

rejectedInnerJoin_tMap_1 = false;










 


	tos_count_tMap_1++;

/**
 * [tMap_1 main ] stop
 */
	
	/**
	 * [tMap_1 process_data_begin ] start
	 */

	

	
	
	currentComponent="tMap_1";
	
	

 



/**
 * [tMap_1 process_data_begin ] stop
 */
// Start of branch "toTable"
if(toTable != null) { 



	
	/**
	 * [tDBOutput_1 main ] start
	 */

	

	
	
	currentComponent="tDBOutput_1";
	
	
			cLabel="stg_movie_releases";
		
			if(runStat.update(execStat,enableLogStash,iterateId,1,1
				
					,"toTable","tMap_1","tMap_1","tMap","tDBOutput_1","stg_movie_releases","tMysqlOutput"
				
			)) {
				talendJobLogProcess(globalMap);
			}
			
    			if(log.isTraceEnabled()){
    				log.trace("toTable - " + (toTable==null? "": toTable.toLogString()));
    			}
    		



        whetherReject_tDBOutput_1 = false;
                            if(toTable.titleId == null) {
pstmt_tDBOutput_1.setNull(1, java.sql.Types.VARCHAR);
} else {pstmt_tDBOutput_1.setString(1, toTable.titleId);
}

                            pstmt_tDBOutput_1.setInt(2, toTable.ordering);

                            if(toTable.title == null) {
pstmt_tDBOutput_1.setNull(3, java.sql.Types.VARCHAR);
} else {pstmt_tDBOutput_1.setString(3, toTable.title);
}

                            if(toTable.region == null) {
pstmt_tDBOutput_1.setNull(4, java.sql.Types.VARCHAR);
} else {pstmt_tDBOutput_1.setString(4, toTable.region);
}

                            if(toTable.language == null) {
pstmt_tDBOutput_1.setNull(5, java.sql.Types.VARCHAR);
} else {pstmt_tDBOutput_1.setString(5, toTable.language);
}

                            if(toTable.types == null) {
pstmt_tDBOutput_1.setNull(6, java.sql.Types.VARCHAR);
} else {pstmt_tDBOutput_1.setString(6, toTable.types);
}

                            if(toTable.attributes == null) {
pstmt_tDBOutput_1.setNull(7, java.sql.Types.VARCHAR);
} else {pstmt_tDBOutput_1.setString(7, toTable.attributes);
}

                            if(toTable.isOriginalTitle == null) {
pstmt_tDBOutput_1.setNull(8, java.sql.Types.VARCHAR);
} else {pstmt_tDBOutput_1.setString(8, toTable.isOriginalTitle);
}

                            if(toTable.DI_Create_DT != null) {
date_tDBOutput_1 = toTable.DI_Create_DT.getTime();
if(date_tDBOutput_1 < year1_tDBOutput_1 || date_tDBOutput_1 >= year10000_tDBOutput_1) {
pstmt_tDBOutput_1.setString(9, "0000-00-00 00:00:00");
} else {pstmt_tDBOutput_1.setTimestamp(9, new java.sql.Timestamp(date_tDBOutput_1));
}
} else {
pstmt_tDBOutput_1.setNull(9, java.sql.Types.DATE);
}

                            if(toTable.DI_WorkflowJobId == null) {
pstmt_tDBOutput_1.setNull(10, java.sql.Types.VARCHAR);
} else {pstmt_tDBOutput_1.setString(10, toTable.DI_WorkflowJobId);
}

                    pstmt_tDBOutput_1.addBatch();
                    nb_line_tDBOutput_1++;

                if(log.isDebugEnabled())
            log.debug("tDBOutput_1 - "  + ("Adding the record ")  + (nb_line_tDBOutput_1)  + (" to the ")  + ("INSERT")  + (" batch.") );
                      batchSizeCounter_tDBOutput_1++;
                if ( batchSize_tDBOutput_1 <= batchSizeCounter_tDBOutput_1) {
                try {
                        int countSum_tDBOutput_1 = 0;
                if(log.isDebugEnabled())
            log.debug("tDBOutput_1 - "  + ("Executing the ")  + ("INSERT")  + (" batch.") );
                        for(int countEach_tDBOutput_1: pstmt_tDBOutput_1.executeBatch()) {
                            countSum_tDBOutput_1 += (countEach_tDBOutput_1 == java.sql.Statement.EXECUTE_FAILED ? 0 : 1);
                        }
                        rowsToCommitCount_tDBOutput_1 += countSum_tDBOutput_1;
                if(log.isDebugEnabled())
            log.debug("tDBOutput_1 - "  + ("The ")  + ("INSERT")  + (" batch execution has succeeded.") );
                        insertedCount_tDBOutput_1 += countSum_tDBOutput_1;
                }catch (java.sql.BatchUpdateException e){
                    globalMap.put("tDBOutput_1_ERROR_MESSAGE",e.getMessage());
                    int countSum_tDBOutput_1 = 0;
                    for(int countEach_tDBOutput_1: e.getUpdateCounts()) {
                        countSum_tDBOutput_1 += (countEach_tDBOutput_1 < 0 ? 0 : countEach_tDBOutput_1);
                    }
                    rowsToCommitCount_tDBOutput_1 += countSum_tDBOutput_1;
                    insertedCount_tDBOutput_1 += countSum_tDBOutput_1;
                    System.err.println(e.getMessage());
            log.error("tDBOutput_1 - "  + (e.getMessage()) );
                }

                batchSizeCounter_tDBOutput_1 = 0;
            }
                commitCounter_tDBOutput_1++;

                if(commitEvery_tDBOutput_1 <= commitCounter_tDBOutput_1) {

                        try {
                                int countSum_tDBOutput_1 = 0;
                if(log.isDebugEnabled())
            log.debug("tDBOutput_1 - "  + ("Executing the ")  + ("INSERT")  + (" batch.") );
                                for(int countEach_tDBOutput_1: pstmt_tDBOutput_1.executeBatch()) {
                                    countSum_tDBOutput_1 += (countEach_tDBOutput_1 < 0 ? 0 : 1);
                                }
                                rowsToCommitCount_tDBOutput_1 += countSum_tDBOutput_1;
                if(log.isDebugEnabled())
            log.debug("tDBOutput_1 - "  + ("The ")  + ("INSERT")  + (" batch execution has succeeded.") );
                                insertedCount_tDBOutput_1 += countSum_tDBOutput_1;
                        }catch (java.sql.BatchUpdateException e){
                            globalMap.put("tDBOutput_1_ERROR_MESSAGE",e.getMessage());
                            int countSum_tDBOutput_1 = 0;
                            for(int countEach_tDBOutput_1: e.getUpdateCounts()) {
                                countSum_tDBOutput_1 += (countEach_tDBOutput_1 < 0 ? 0 : countEach_tDBOutput_1);
                            }
                            rowsToCommitCount_tDBOutput_1 += countSum_tDBOutput_1;
                            insertedCount_tDBOutput_1 += countSum_tDBOutput_1;
                            System.err.println(e.getMessage());
            log.error("tDBOutput_1 - "  + (e.getMessage()) );

                        }
                    if(rowsToCommitCount_tDBOutput_1 != 0){
                if(log.isDebugEnabled())
            log.debug("tDBOutput_1 - "  + ("Connection starting to commit ")  + (rowsToCommitCount_tDBOutput_1)  + (" record(s).") );
                    }
                    conn_tDBOutput_1.commit();
                    if(rowsToCommitCount_tDBOutput_1 != 0){
                if(log.isDebugEnabled())
            log.debug("tDBOutput_1 - "  + ("Connection commit has succeeded.") );
                        rowsToCommitCount_tDBOutput_1 = 0;
                    }
                    commitCounter_tDBOutput_1=0;
                }

 


	tos_count_tDBOutput_1++;

/**
 * [tDBOutput_1 main ] stop
 */
	
	/**
	 * [tDBOutput_1 process_data_begin ] start
	 */

	

	
	
	currentComponent="tDBOutput_1";
	
	
			cLabel="stg_movie_releases";
		

 



/**
 * [tDBOutput_1 process_data_begin ] stop
 */
	
	/**
	 * [tDBOutput_1 process_data_end ] start
	 */

	

	
	
	currentComponent="tDBOutput_1";
	
	
			cLabel="stg_movie_releases";
		

 



/**
 * [tDBOutput_1 process_data_end ] stop
 */

} // End of branch "toTable"




	
	/**
	 * [tMap_1 process_data_end ] start
	 */

	

	
	
	currentComponent="tMap_1";
	
	

 



/**
 * [tMap_1 process_data_end ] stop
 */



	
	/**
	 * [tDBInput_1 process_data_end ] start
	 */

	

	
	
	currentComponent="tDBInput_1";
	
	
			cLabel="imdb_title_akas";
		

 



/**
 * [tDBInput_1 process_data_end ] stop
 */
	
	/**
	 * [tDBInput_1 end ] start
	 */

	

	
	
	currentComponent="tDBInput_1";
	
	
			cLabel="imdb_title_akas";
		

	}
}finally{
	if (rs_tDBInput_1 != null) {
		rs_tDBInput_1.close();
	}
	if (stmt_tDBInput_1 != null) {
		stmt_tDBInput_1.close();
	}
		if(conn_tDBInput_1 != null && !conn_tDBInput_1.isClosed()) {
			
	    		log.debug("tDBInput_1 - Closing the connection to the database.");
			
			conn_tDBInput_1.close();
			
			if("com.mysql.cj.jdbc.Driver".equals((String)globalMap.get("driverClass_"))
			    && routines.system.BundleUtils.inOSGi()) {
			        Class.forName("com.mysql.cj.jdbc.AbandonedConnectionCleanupThread").
			            getMethod("checkedShutdown").invoke(null, (Object[]) null);
			}
			
	    		log.debug("tDBInput_1 - Connection to the database closed.");
			
		}
		
}
globalMap.put("tDBInput_1_NB_LINE",nb_line_tDBInput_1);
	    		log.debug("tDBInput_1 - Retrieved records count: "+nb_line_tDBInput_1 + " .");
			

 
                if(log.isDebugEnabled())
            log.debug("tDBInput_1 - "  + ("Done.") );

ok_Hash.put("tDBInput_1", true);
end_Hash.put("tDBInput_1", System.currentTimeMillis());




/**
 * [tDBInput_1 end ] stop
 */

	
	/**
	 * [tMap_1 end ] start
	 */

	

	
	
	currentComponent="tMap_1";
	
	


// ###############################
// # Lookup hashes releasing
// ###############################      
				log.debug("tMap_1 - Written records count in the table 'toTable': " + count_toTable_tMap_1 + ".");





			 		if(runStat.updateStatAndLog(execStat,enableLogStash,resourceMap,iterateId,"row1",2,0,
			 			"tDBInput_1","imdb_title_akas","tMysqlInput","tMap_1","tMap_1","tMap","output")) {
						talendJobLogProcess(globalMap);
					}
				
 
                if(log.isDebugEnabled())
            log.debug("tMap_1 - "  + ("Done.") );

ok_Hash.put("tMap_1", true);
end_Hash.put("tMap_1", System.currentTimeMillis());




/**
 * [tMap_1 end ] stop
 */

	
	/**
	 * [tDBOutput_1 end ] start
	 */

	

	
	
	currentComponent="tDBOutput_1";
	
	
			cLabel="stg_movie_releases";
		



				
					try {
						if (batchSizeCounter_tDBOutput_1 != 0) {
							int countSum_tDBOutput_1 = 0;
							
                if(log.isDebugEnabled())
            log.debug("tDBOutput_1 - "  + ("Executing the ")  + ("INSERT")  + (" batch.") );
							for(int countEach_tDBOutput_1: pstmt_tDBOutput_1.executeBatch()) {
								countSum_tDBOutput_1 += (countEach_tDBOutput_1 == java.sql.Statement.EXECUTE_FAILED ? 0 : 1);
							}
							rowsToCommitCount_tDBOutput_1 += countSum_tDBOutput_1;
							
                if(log.isDebugEnabled())
            log.debug("tDBOutput_1 - "  + ("The ")  + ("INSERT")  + (" batch execution has succeeded.") );
							
								insertedCount_tDBOutput_1 += countSum_tDBOutput_1;
							
						}
					}catch (java.sql.BatchUpdateException e){
						globalMap.put(currentComponent+"_ERROR_MESSAGE",e.getMessage());
						
							int countSum_tDBOutput_1 = 0;
							for(int countEach_tDBOutput_1: e.getUpdateCounts()) {
								countSum_tDBOutput_1 += (countEach_tDBOutput_1 < 0 ? 0 : countEach_tDBOutput_1);
							}
							rowsToCommitCount_tDBOutput_1 += countSum_tDBOutput_1;
							
								insertedCount_tDBOutput_1 += countSum_tDBOutput_1;
								
            log.error("tDBOutput_1 - "  + (e.getMessage()) );
							System.err.println(e.getMessage());
							
					}
					batchSizeCounter_tDBOutput_1 = 0;
					
			
		

		if(pstmt_tDBOutput_1 != null) {
			
				pstmt_tDBOutput_1.close();
				resourceMap.remove("pstmt_tDBOutput_1");
			
		}
		
	resourceMap.put("statementClosed_tDBOutput_1", true);
	
			if (commitCounter_tDBOutput_1 > 0 && rowsToCommitCount_tDBOutput_1 != 0) {
				
                if(log.isDebugEnabled())
            log.debug("tDBOutput_1 - "  + ("Connection starting to commit ")  + (rowsToCommitCount_tDBOutput_1)  + (" record(s).") );
			}
			conn_tDBOutput_1.commit();
			if (commitCounter_tDBOutput_1 > 0 && rowsToCommitCount_tDBOutput_1 != 0) {
				
                if(log.isDebugEnabled())
            log.debug("tDBOutput_1 - "  + ("Connection commit has succeeded.") );
				rowsToCommitCount_tDBOutput_1 = 0;
			}
			commitCounter_tDBOutput_1 = 0;
			
		
                if(log.isDebugEnabled())
            log.debug("tDBOutput_1 - "  + ("Closing the connection to the database.") );
		conn_tDBOutput_1 .close();
		
                if(log.isDebugEnabled())
            log.debug("tDBOutput_1 - "  + ("Connection to the database has closed.") );
		resourceMap.put("finish_tDBOutput_1", true);
	

	nb_line_deleted_tDBOutput_1=nb_line_deleted_tDBOutput_1+ deletedCount_tDBOutput_1;
	nb_line_update_tDBOutput_1=nb_line_update_tDBOutput_1 + updatedCount_tDBOutput_1;
	nb_line_inserted_tDBOutput_1=nb_line_inserted_tDBOutput_1 + insertedCount_tDBOutput_1;
	nb_line_rejected_tDBOutput_1=nb_line_rejected_tDBOutput_1 + rejectedCount_tDBOutput_1;
	
        globalMap.put("tDBOutput_1_NB_LINE",nb_line_tDBOutput_1);
        globalMap.put("tDBOutput_1_NB_LINE_UPDATED",nb_line_update_tDBOutput_1);
        globalMap.put("tDBOutput_1_NB_LINE_INSERTED",nb_line_inserted_tDBOutput_1);
        globalMap.put("tDBOutput_1_NB_LINE_DELETED",nb_line_deleted_tDBOutput_1);
        globalMap.put("tDBOutput_1_NB_LINE_REJECTED", nb_line_rejected_tDBOutput_1);
    

	
                if(log.isDebugEnabled())
            log.debug("tDBOutput_1 - "  + ("Has ")  + ("inserted")  + (" ")  + (nb_line_inserted_tDBOutput_1)  + (" record(s).") );

			 		if(runStat.updateStatAndLog(execStat,enableLogStash,resourceMap,iterateId,"toTable",2,0,
			 			"tMap_1","tMap_1","tMap","tDBOutput_1","stg_movie_releases","tMysqlOutput","output")) {
						talendJobLogProcess(globalMap);
					}
				
 
                if(log.isDebugEnabled())
            log.debug("tDBOutput_1 - "  + ("Done.") );

ok_Hash.put("tDBOutput_1", true);
end_Hash.put("tDBOutput_1", System.currentTimeMillis());




/**
 * [tDBOutput_1 end ] stop
 */






				}//end the resume

				
				    			if(resumeEntryMethodName == null || globalResumeTicket){
				    				resumeUtil.addLog("CHECKPOINT", "CONNECTION:SUBJOB_OK:tDBInput_1:OnSubjobOk", "", Thread.currentThread().getId() + "", "", "", "", "", "");
								}	    				    			
					    	
								if(execStat){    	
									runStat.updateStatOnConnection("OnSubjobOk2", 0, "ok");
								} 
							
							tDBInput_3Process(globalMap); 
						



	
			}catch(java.lang.Exception e){	
				
				    if(!(e instanceof TalendException)){
					   log.fatal(currentComponent + " " + e.getMessage(),e);
					}
				
				TalendException te = new TalendException(e, currentComponent, cLabel, globalMap);
				
				throw te;
			}catch(java.lang.Error error){	
				
					runStat.stopThreadStat();
				
				throw error;
			}finally{
				
				try{
					
	
	/**
	 * [tDBInput_1 finally ] start
	 */

	

	
	
	currentComponent="tDBInput_1";
	
	
			cLabel="imdb_title_akas";
		

 



/**
 * [tDBInput_1 finally ] stop
 */

	
	/**
	 * [tMap_1 finally ] start
	 */

	

	
	
	currentComponent="tMap_1";
	
	

 



/**
 * [tMap_1 finally ] stop
 */

	
	/**
	 * [tDBOutput_1 finally ] start
	 */

	

	
	
	currentComponent="tDBOutput_1";
	
	
			cLabel="stg_movie_releases";
		



    try {
    if (resourceMap.get("statementClosed_tDBOutput_1") == null) {
                java.sql.PreparedStatement pstmtToClose_tDBOutput_1 = null;
                if ((pstmtToClose_tDBOutput_1 = (java.sql.PreparedStatement) resourceMap.remove("pstmt_tDBOutput_1")) != null) {
                    pstmtToClose_tDBOutput_1.close();
                }
    }
    } finally {
        if(resourceMap.get("finish_tDBOutput_1") == null){
            java.sql.Connection ctn_tDBOutput_1 = null;
            if((ctn_tDBOutput_1 = (java.sql.Connection)resourceMap.get("conn_tDBOutput_1")) != null){
                try {
                if(log.isDebugEnabled())
            log.debug("tDBOutput_1 - "  + ("Closing the connection to the database.") );
                    ctn_tDBOutput_1.close();
                if(log.isDebugEnabled())
            log.debug("tDBOutput_1 - "  + ("Connection to the database has closed.") );
                } catch (java.sql.SQLException sqlEx_tDBOutput_1) {
                    String errorMessage_tDBOutput_1 = "failed to close the connection in tDBOutput_1 :" + sqlEx_tDBOutput_1.getMessage();
            log.error("tDBOutput_1 - "  + (errorMessage_tDBOutput_1) );
                    System.err.println(errorMessage_tDBOutput_1);
                }
            }
        }
    }
 



/**
 * [tDBOutput_1 finally ] stop
 */






				}catch(java.lang.Exception e){	
					//ignore
				}catch(java.lang.Error error){
					//ignore
				}
				resourceMap = null;
			}
		

		globalMap.put("tDBInput_1_SUBPROCESS_STATE", 1);
	}
	


public static class copyOftoTable_0Struct implements routines.system.IPersistableRow<copyOftoTable_0Struct> {
    final static byte[] commonByteArrayLock_FINAL_PROJECT_sql_staging_job = new byte[0];
    static byte[] commonByteArray_FINAL_PROJECT_sql_staging_job = new byte[0];

	
			    public String nconst;

				public String getNconst () {
					return this.nconst;
				}

				public Boolean nconstIsNullable(){
				    return false;
				}
				public Boolean nconstIsKey(){
				    return false;
				}
				public Integer nconstLength(){
				    return 10;
				}
				public Integer nconstPrecision(){
				    return 0;
				}
				public String nconstDefault(){
				
					return null;
				
				}
				public String nconstComment(){
				
				    return "";
				
				}
				public String nconstPattern(){
				
					return "";
				
				}
				public String nconstOriginalDbColumnName(){
				
					return "nconst";
				
				}

				
			    public String primaryName;

				public String getPrimaryName () {
					return this.primaryName;
				}

				public Boolean primaryNameIsNullable(){
				    return true;
				}
				public Boolean primaryNameIsKey(){
				    return false;
				}
				public Integer primaryNameLength(){
				    return 255;
				}
				public Integer primaryNamePrecision(){
				    return 0;
				}
				public String primaryNameDefault(){
				
					return null;
				
				}
				public String primaryNameComment(){
				
				    return "";
				
				}
				public String primaryNamePattern(){
				
					return "";
				
				}
				public String primaryNameOriginalDbColumnName(){
				
					return "primaryName";
				
				}

				
			    public String birthYear;

				public String getBirthYear () {
					return this.birthYear;
				}

				public Boolean birthYearIsNullable(){
				    return true;
				}
				public Boolean birthYearIsKey(){
				    return false;
				}
				public Integer birthYearLength(){
				    return 4;
				}
				public Integer birthYearPrecision(){
				    return 0;
				}
				public String birthYearDefault(){
				
					return null;
				
				}
				public String birthYearComment(){
				
				    return "";
				
				}
				public String birthYearPattern(){
				
					return "";
				
				}
				public String birthYearOriginalDbColumnName(){
				
					return "birthYear";
				
				}

				
			    public String deathYear;

				public String getDeathYear () {
					return this.deathYear;
				}

				public Boolean deathYearIsNullable(){
				    return true;
				}
				public Boolean deathYearIsKey(){
				    return false;
				}
				public Integer deathYearLength(){
				    return 4;
				}
				public Integer deathYearPrecision(){
				    return 0;
				}
				public String deathYearDefault(){
				
					return null;
				
				}
				public String deathYearComment(){
				
				    return "";
				
				}
				public String deathYearPattern(){
				
					return "";
				
				}
				public String deathYearOriginalDbColumnName(){
				
					return "deathYear";
				
				}

				
			    public String primaryProfession;

				public String getPrimaryProfession () {
					return this.primaryProfession;
				}

				public Boolean primaryProfessionIsNullable(){
				    return true;
				}
				public Boolean primaryProfessionIsKey(){
				    return false;
				}
				public Integer primaryProfessionLength(){
				    return 255;
				}
				public Integer primaryProfessionPrecision(){
				    return 0;
				}
				public String primaryProfessionDefault(){
				
					return null;
				
				}
				public String primaryProfessionComment(){
				
				    return "";
				
				}
				public String primaryProfessionPattern(){
				
					return "";
				
				}
				public String primaryProfessionOriginalDbColumnName(){
				
					return "primaryProfession";
				
				}

				
			    public String knownForTitles;

				public String getKnownForTitles () {
					return this.knownForTitles;
				}

				public Boolean knownForTitlesIsNullable(){
				    return true;
				}
				public Boolean knownForTitlesIsKey(){
				    return false;
				}
				public Integer knownForTitlesLength(){
				    return 1024;
				}
				public Integer knownForTitlesPrecision(){
				    return 0;
				}
				public String knownForTitlesDefault(){
				
					return null;
				
				}
				public String knownForTitlesComment(){
				
				    return "";
				
				}
				public String knownForTitlesPattern(){
				
					return "";
				
				}
				public String knownForTitlesOriginalDbColumnName(){
				
					return "knownForTitles";
				
				}

				
			    public java.util.Date DI_Create_DT;

				public java.util.Date getDI_Create_DT () {
					return this.DI_Create_DT;
				}

				public Boolean DI_Create_DTIsNullable(){
				    return false;
				}
				public Boolean DI_Create_DTIsKey(){
				    return false;
				}
				public Integer DI_Create_DTLength(){
				    return 19;
				}
				public Integer DI_Create_DTPrecision(){
				    return 0;
				}
				public String DI_Create_DTDefault(){
				
					return null;
				
				}
				public String DI_Create_DTComment(){
				
				    return "";
				
				}
				public String DI_Create_DTPattern(){
				
					return "dd-MM-yyyy";
				
				}
				public String DI_Create_DTOriginalDbColumnName(){
				
					return "DI_Create_DT";
				
				}

				
			    public String DI_WorkflowJobId;

				public String getDI_WorkflowJobId () {
					return this.DI_WorkflowJobId;
				}

				public Boolean DI_WorkflowJobIdIsNullable(){
				    return true;
				}
				public Boolean DI_WorkflowJobIdIsKey(){
				    return false;
				}
				public Integer DI_WorkflowJobIdLength(){
				    return 8;
				}
				public Integer DI_WorkflowJobIdPrecision(){
				    return null;
				}
				public String DI_WorkflowJobIdDefault(){
				
					return null;
				
				}
				public String DI_WorkflowJobIdComment(){
				
				    return "";
				
				}
				public String DI_WorkflowJobIdPattern(){
				
					return "";
				
				}
				public String DI_WorkflowJobIdOriginalDbColumnName(){
				
					return "DI_WorkflowJobId";
				
				}

				



	private String readString(ObjectInputStream dis) throws IOException{
		String strReturn = null;
		int length = 0;
        length = dis.readInt();
		if (length == -1) {
			strReturn = null;
		} else {
			if(length > commonByteArray_FINAL_PROJECT_sql_staging_job.length) {
				if(length < 1024 && commonByteArray_FINAL_PROJECT_sql_staging_job.length == 0) {
   					commonByteArray_FINAL_PROJECT_sql_staging_job = new byte[1024];
				} else {
   					commonByteArray_FINAL_PROJECT_sql_staging_job = new byte[2 * length];
   				}
			}
			dis.readFully(commonByteArray_FINAL_PROJECT_sql_staging_job, 0, length);
			strReturn = new String(commonByteArray_FINAL_PROJECT_sql_staging_job, 0, length, utf8Charset);
		}
		return strReturn;
	}
	
	private String readString(org.jboss.marshalling.Unmarshaller unmarshaller) throws IOException{
		String strReturn = null;
		int length = 0;
        length = unmarshaller.readInt();
		if (length == -1) {
			strReturn = null;
		} else {
			if(length > commonByteArray_FINAL_PROJECT_sql_staging_job.length) {
				if(length < 1024 && commonByteArray_FINAL_PROJECT_sql_staging_job.length == 0) {
   					commonByteArray_FINAL_PROJECT_sql_staging_job = new byte[1024];
				} else {
   					commonByteArray_FINAL_PROJECT_sql_staging_job = new byte[2 * length];
   				}
			}
			unmarshaller.readFully(commonByteArray_FINAL_PROJECT_sql_staging_job, 0, length);
			strReturn = new String(commonByteArray_FINAL_PROJECT_sql_staging_job, 0, length, utf8Charset);
		}
		return strReturn;
	}

    private void writeString(String str, ObjectOutputStream dos) throws IOException{
		if(str == null) {
            dos.writeInt(-1);
		} else {
            byte[] byteArray = str.getBytes(utf8Charset);
	    	dos.writeInt(byteArray.length);
			dos.write(byteArray);
    	}
    }
    
    private void writeString(String str, org.jboss.marshalling.Marshaller marshaller) throws IOException{
		if(str == null) {
			marshaller.writeInt(-1);
		} else {
            byte[] byteArray = str.getBytes(utf8Charset);
            marshaller.writeInt(byteArray.length);
            marshaller.write(byteArray);
    	}
    }

	private java.util.Date readDate(ObjectInputStream dis) throws IOException{
		java.util.Date dateReturn = null;
        int length = 0;
        length = dis.readByte();
		if (length == -1) {
			dateReturn = null;
		} else {
	    	dateReturn = new Date(dis.readLong());
		}
		return dateReturn;
	}
	
	private java.util.Date readDate(org.jboss.marshalling.Unmarshaller unmarshaller) throws IOException{
		java.util.Date dateReturn = null;
        int length = 0;
        length = unmarshaller.readByte();
		if (length == -1) {
			dateReturn = null;
		} else {
	    	dateReturn = new Date(unmarshaller.readLong());
		}
		return dateReturn;
	}

    private void writeDate(java.util.Date date1, ObjectOutputStream dos) throws IOException{
		if(date1 == null) {
            dos.writeByte(-1);
		} else {
			dos.writeByte(0);
	    	dos.writeLong(date1.getTime());
    	}
    }
    
    private void writeDate(java.util.Date date1, org.jboss.marshalling.Marshaller marshaller) throws IOException{
		if(date1 == null) {
			marshaller.writeByte(-1);
		} else {
			marshaller.writeByte(0);
			marshaller.writeLong(date1.getTime());
    	}
    }

    public void readData(ObjectInputStream dis) {

		synchronized(commonByteArrayLock_FINAL_PROJECT_sql_staging_job) {

        	try {

        		int length = 0;
		
					this.nconst = readString(dis);
					
					this.primaryName = readString(dis);
					
					this.birthYear = readString(dis);
					
					this.deathYear = readString(dis);
					
					this.primaryProfession = readString(dis);
					
					this.knownForTitles = readString(dis);
					
					this.DI_Create_DT = readDate(dis);
					
					this.DI_WorkflowJobId = readString(dis);
					
        	} catch (IOException e) {
	            throw new RuntimeException(e);

		

        }

		

      }


    }
    
    public void readData(org.jboss.marshalling.Unmarshaller dis) {

		synchronized(commonByteArrayLock_FINAL_PROJECT_sql_staging_job) {

        	try {

        		int length = 0;
		
					this.nconst = readString(dis);
					
					this.primaryName = readString(dis);
					
					this.birthYear = readString(dis);
					
					this.deathYear = readString(dis);
					
					this.primaryProfession = readString(dis);
					
					this.knownForTitles = readString(dis);
					
					this.DI_Create_DT = readDate(dis);
					
					this.DI_WorkflowJobId = readString(dis);
					
        	} catch (IOException e) {
	            throw new RuntimeException(e);

		

        }

		

      }


    }

    public void writeData(ObjectOutputStream dos) {
        try {

		
					// String
				
						writeString(this.nconst,dos);
					
					// String
				
						writeString(this.primaryName,dos);
					
					// String
				
						writeString(this.birthYear,dos);
					
					// String
				
						writeString(this.deathYear,dos);
					
					// String
				
						writeString(this.primaryProfession,dos);
					
					// String
				
						writeString(this.knownForTitles,dos);
					
					// java.util.Date
				
						writeDate(this.DI_Create_DT,dos);
					
					// String
				
						writeString(this.DI_WorkflowJobId,dos);
					
        	} catch (IOException e) {
	            throw new RuntimeException(e);
        }


    }
    
    public void writeData(org.jboss.marshalling.Marshaller dos) {
        try {

		
					// String
				
						writeString(this.nconst,dos);
					
					// String
				
						writeString(this.primaryName,dos);
					
					// String
				
						writeString(this.birthYear,dos);
					
					// String
				
						writeString(this.deathYear,dos);
					
					// String
				
						writeString(this.primaryProfession,dos);
					
					// String
				
						writeString(this.knownForTitles,dos);
					
					// java.util.Date
				
						writeDate(this.DI_Create_DT,dos);
					
					// String
				
						writeString(this.DI_WorkflowJobId,dos);
					
        	} catch (IOException e) {
	            throw new RuntimeException(e);
        }


    }


    public String toString() {

		StringBuilder sb = new StringBuilder();
		sb.append(super.toString());
		sb.append("[");
		sb.append("nconst="+nconst);
		sb.append(",primaryName="+primaryName);
		sb.append(",birthYear="+birthYear);
		sb.append(",deathYear="+deathYear);
		sb.append(",primaryProfession="+primaryProfession);
		sb.append(",knownForTitles="+knownForTitles);
		sb.append(",DI_Create_DT="+String.valueOf(DI_Create_DT));
		sb.append(",DI_WorkflowJobId="+DI_WorkflowJobId);
	    sb.append("]");

	    return sb.toString();
    }
        public String toLogString(){
        	StringBuilder sb = new StringBuilder();
        	
        				if(nconst == null){
        					sb.append("<null>");
        				}else{
            				sb.append(nconst);
            			}
            		
        			sb.append("|");
        		
        				if(primaryName == null){
        					sb.append("<null>");
        				}else{
            				sb.append(primaryName);
            			}
            		
        			sb.append("|");
        		
        				if(birthYear == null){
        					sb.append("<null>");
        				}else{
            				sb.append(birthYear);
            			}
            		
        			sb.append("|");
        		
        				if(deathYear == null){
        					sb.append("<null>");
        				}else{
            				sb.append(deathYear);
            			}
            		
        			sb.append("|");
        		
        				if(primaryProfession == null){
        					sb.append("<null>");
        				}else{
            				sb.append(primaryProfession);
            			}
            		
        			sb.append("|");
        		
        				if(knownForTitles == null){
        					sb.append("<null>");
        				}else{
            				sb.append(knownForTitles);
            			}
            		
        			sb.append("|");
        		
        				if(DI_Create_DT == null){
        					sb.append("<null>");
        				}else{
            				sb.append(DI_Create_DT);
            			}
            		
        			sb.append("|");
        		
        				if(DI_WorkflowJobId == null){
        					sb.append("<null>");
        				}else{
            				sb.append(DI_WorkflowJobId);
            			}
            		
        			sb.append("|");
        		
        	return sb.toString();
        }

    /**
     * Compare keys
     */
    public int compareTo(copyOftoTable_0Struct other) {

		int returnValue = -1;
		
	    return returnValue;
    }


    private int checkNullsAndCompare(Object object1, Object object2) {
        int returnValue = 0;
		if (object1 instanceof Comparable && object2 instanceof Comparable) {
            returnValue = ((Comparable) object1).compareTo(object2);
        } else if (object1 != null && object2 != null) {
            returnValue = compareStrings(object1.toString(), object2.toString());
        } else if (object1 == null && object2 != null) {
            returnValue = 1;
        } else if (object1 != null && object2 == null) {
            returnValue = -1;
        } else {
            returnValue = 0;
        }

        return returnValue;
    }

    private int compareStrings(String string1, String string2) {
        return string1.compareTo(string2);
    }


}

public static class row3Struct implements routines.system.IPersistableRow<row3Struct> {
    final static byte[] commonByteArrayLock_FINAL_PROJECT_sql_staging_job = new byte[0];
    static byte[] commonByteArray_FINAL_PROJECT_sql_staging_job = new byte[0];

	
			    public String nconst;

				public String getNconst () {
					return this.nconst;
				}

				public Boolean nconstIsNullable(){
				    return false;
				}
				public Boolean nconstIsKey(){
				    return false;
				}
				public Integer nconstLength(){
				    return 10;
				}
				public Integer nconstPrecision(){
				    return 0;
				}
				public String nconstDefault(){
				
					return null;
				
				}
				public String nconstComment(){
				
				    return "";
				
				}
				public String nconstPattern(){
				
					return "";
				
				}
				public String nconstOriginalDbColumnName(){
				
					return "nconst";
				
				}

				
			    public String primaryName;

				public String getPrimaryName () {
					return this.primaryName;
				}

				public Boolean primaryNameIsNullable(){
				    return true;
				}
				public Boolean primaryNameIsKey(){
				    return false;
				}
				public Integer primaryNameLength(){
				    return 255;
				}
				public Integer primaryNamePrecision(){
				    return 0;
				}
				public String primaryNameDefault(){
				
					return null;
				
				}
				public String primaryNameComment(){
				
				    return "";
				
				}
				public String primaryNamePattern(){
				
					return "";
				
				}
				public String primaryNameOriginalDbColumnName(){
				
					return "primaryName";
				
				}

				
			    public String birthYear;

				public String getBirthYear () {
					return this.birthYear;
				}

				public Boolean birthYearIsNullable(){
				    return true;
				}
				public Boolean birthYearIsKey(){
				    return false;
				}
				public Integer birthYearLength(){
				    return 4;
				}
				public Integer birthYearPrecision(){
				    return 0;
				}
				public String birthYearDefault(){
				
					return null;
				
				}
				public String birthYearComment(){
				
				    return "";
				
				}
				public String birthYearPattern(){
				
					return "";
				
				}
				public String birthYearOriginalDbColumnName(){
				
					return "birthYear";
				
				}

				
			    public String deathYear;

				public String getDeathYear () {
					return this.deathYear;
				}

				public Boolean deathYearIsNullable(){
				    return true;
				}
				public Boolean deathYearIsKey(){
				    return false;
				}
				public Integer deathYearLength(){
				    return 4;
				}
				public Integer deathYearPrecision(){
				    return 0;
				}
				public String deathYearDefault(){
				
					return null;
				
				}
				public String deathYearComment(){
				
				    return "";
				
				}
				public String deathYearPattern(){
				
					return "";
				
				}
				public String deathYearOriginalDbColumnName(){
				
					return "deathYear";
				
				}

				
			    public String primaryProfession;

				public String getPrimaryProfession () {
					return this.primaryProfession;
				}

				public Boolean primaryProfessionIsNullable(){
				    return true;
				}
				public Boolean primaryProfessionIsKey(){
				    return false;
				}
				public Integer primaryProfessionLength(){
				    return 255;
				}
				public Integer primaryProfessionPrecision(){
				    return 0;
				}
				public String primaryProfessionDefault(){
				
					return null;
				
				}
				public String primaryProfessionComment(){
				
				    return "";
				
				}
				public String primaryProfessionPattern(){
				
					return "";
				
				}
				public String primaryProfessionOriginalDbColumnName(){
				
					return "primaryProfession";
				
				}

				
			    public String knownForTitles;

				public String getKnownForTitles () {
					return this.knownForTitles;
				}

				public Boolean knownForTitlesIsNullable(){
				    return true;
				}
				public Boolean knownForTitlesIsKey(){
				    return false;
				}
				public Integer knownForTitlesLength(){
				    return 1024;
				}
				public Integer knownForTitlesPrecision(){
				    return 0;
				}
				public String knownForTitlesDefault(){
				
					return null;
				
				}
				public String knownForTitlesComment(){
				
				    return "";
				
				}
				public String knownForTitlesPattern(){
				
					return "";
				
				}
				public String knownForTitlesOriginalDbColumnName(){
				
					return "knownForTitles";
				
				}

				
			    public java.util.Date DI_Create_DT;

				public java.util.Date getDI_Create_DT () {
					return this.DI_Create_DT;
				}

				public Boolean DI_Create_DTIsNullable(){
				    return false;
				}
				public Boolean DI_Create_DTIsKey(){
				    return false;
				}
				public Integer DI_Create_DTLength(){
				    return 19;
				}
				public Integer DI_Create_DTPrecision(){
				    return 0;
				}
				public String DI_Create_DTDefault(){
				
					return null;
				
				}
				public String DI_Create_DTComment(){
				
				    return "";
				
				}
				public String DI_Create_DTPattern(){
				
					return "dd-MM-yyyy";
				
				}
				public String DI_Create_DTOriginalDbColumnName(){
				
					return "DI_Create_DT";
				
				}

				



	private String readString(ObjectInputStream dis) throws IOException{
		String strReturn = null;
		int length = 0;
        length = dis.readInt();
		if (length == -1) {
			strReturn = null;
		} else {
			if(length > commonByteArray_FINAL_PROJECT_sql_staging_job.length) {
				if(length < 1024 && commonByteArray_FINAL_PROJECT_sql_staging_job.length == 0) {
   					commonByteArray_FINAL_PROJECT_sql_staging_job = new byte[1024];
				} else {
   					commonByteArray_FINAL_PROJECT_sql_staging_job = new byte[2 * length];
   				}
			}
			dis.readFully(commonByteArray_FINAL_PROJECT_sql_staging_job, 0, length);
			strReturn = new String(commonByteArray_FINAL_PROJECT_sql_staging_job, 0, length, utf8Charset);
		}
		return strReturn;
	}
	
	private String readString(org.jboss.marshalling.Unmarshaller unmarshaller) throws IOException{
		String strReturn = null;
		int length = 0;
        length = unmarshaller.readInt();
		if (length == -1) {
			strReturn = null;
		} else {
			if(length > commonByteArray_FINAL_PROJECT_sql_staging_job.length) {
				if(length < 1024 && commonByteArray_FINAL_PROJECT_sql_staging_job.length == 0) {
   					commonByteArray_FINAL_PROJECT_sql_staging_job = new byte[1024];
				} else {
   					commonByteArray_FINAL_PROJECT_sql_staging_job = new byte[2 * length];
   				}
			}
			unmarshaller.readFully(commonByteArray_FINAL_PROJECT_sql_staging_job, 0, length);
			strReturn = new String(commonByteArray_FINAL_PROJECT_sql_staging_job, 0, length, utf8Charset);
		}
		return strReturn;
	}

    private void writeString(String str, ObjectOutputStream dos) throws IOException{
		if(str == null) {
            dos.writeInt(-1);
		} else {
            byte[] byteArray = str.getBytes(utf8Charset);
	    	dos.writeInt(byteArray.length);
			dos.write(byteArray);
    	}
    }
    
    private void writeString(String str, org.jboss.marshalling.Marshaller marshaller) throws IOException{
		if(str == null) {
			marshaller.writeInt(-1);
		} else {
            byte[] byteArray = str.getBytes(utf8Charset);
            marshaller.writeInt(byteArray.length);
            marshaller.write(byteArray);
    	}
    }

	private java.util.Date readDate(ObjectInputStream dis) throws IOException{
		java.util.Date dateReturn = null;
        int length = 0;
        length = dis.readByte();
		if (length == -1) {
			dateReturn = null;
		} else {
	    	dateReturn = new Date(dis.readLong());
		}
		return dateReturn;
	}
	
	private java.util.Date readDate(org.jboss.marshalling.Unmarshaller unmarshaller) throws IOException{
		java.util.Date dateReturn = null;
        int length = 0;
        length = unmarshaller.readByte();
		if (length == -1) {
			dateReturn = null;
		} else {
	    	dateReturn = new Date(unmarshaller.readLong());
		}
		return dateReturn;
	}

    private void writeDate(java.util.Date date1, ObjectOutputStream dos) throws IOException{
		if(date1 == null) {
            dos.writeByte(-1);
		} else {
			dos.writeByte(0);
	    	dos.writeLong(date1.getTime());
    	}
    }
    
    private void writeDate(java.util.Date date1, org.jboss.marshalling.Marshaller marshaller) throws IOException{
		if(date1 == null) {
			marshaller.writeByte(-1);
		} else {
			marshaller.writeByte(0);
			marshaller.writeLong(date1.getTime());
    	}
    }

    public void readData(ObjectInputStream dis) {

		synchronized(commonByteArrayLock_FINAL_PROJECT_sql_staging_job) {

        	try {

        		int length = 0;
		
					this.nconst = readString(dis);
					
					this.primaryName = readString(dis);
					
					this.birthYear = readString(dis);
					
					this.deathYear = readString(dis);
					
					this.primaryProfession = readString(dis);
					
					this.knownForTitles = readString(dis);
					
					this.DI_Create_DT = readDate(dis);
					
        	} catch (IOException e) {
	            throw new RuntimeException(e);

		

        }

		

      }


    }
    
    public void readData(org.jboss.marshalling.Unmarshaller dis) {

		synchronized(commonByteArrayLock_FINAL_PROJECT_sql_staging_job) {

        	try {

        		int length = 0;
		
					this.nconst = readString(dis);
					
					this.primaryName = readString(dis);
					
					this.birthYear = readString(dis);
					
					this.deathYear = readString(dis);
					
					this.primaryProfession = readString(dis);
					
					this.knownForTitles = readString(dis);
					
					this.DI_Create_DT = readDate(dis);
					
        	} catch (IOException e) {
	            throw new RuntimeException(e);

		

        }

		

      }


    }

    public void writeData(ObjectOutputStream dos) {
        try {

		
					// String
				
						writeString(this.nconst,dos);
					
					// String
				
						writeString(this.primaryName,dos);
					
					// String
				
						writeString(this.birthYear,dos);
					
					// String
				
						writeString(this.deathYear,dos);
					
					// String
				
						writeString(this.primaryProfession,dos);
					
					// String
				
						writeString(this.knownForTitles,dos);
					
					// java.util.Date
				
						writeDate(this.DI_Create_DT,dos);
					
        	} catch (IOException e) {
	            throw new RuntimeException(e);
        }


    }
    
    public void writeData(org.jboss.marshalling.Marshaller dos) {
        try {

		
					// String
				
						writeString(this.nconst,dos);
					
					// String
				
						writeString(this.primaryName,dos);
					
					// String
				
						writeString(this.birthYear,dos);
					
					// String
				
						writeString(this.deathYear,dos);
					
					// String
				
						writeString(this.primaryProfession,dos);
					
					// String
				
						writeString(this.knownForTitles,dos);
					
					// java.util.Date
				
						writeDate(this.DI_Create_DT,dos);
					
        	} catch (IOException e) {
	            throw new RuntimeException(e);
        }


    }


    public String toString() {

		StringBuilder sb = new StringBuilder();
		sb.append(super.toString());
		sb.append("[");
		sb.append("nconst="+nconst);
		sb.append(",primaryName="+primaryName);
		sb.append(",birthYear="+birthYear);
		sb.append(",deathYear="+deathYear);
		sb.append(",primaryProfession="+primaryProfession);
		sb.append(",knownForTitles="+knownForTitles);
		sb.append(",DI_Create_DT="+String.valueOf(DI_Create_DT));
	    sb.append("]");

	    return sb.toString();
    }
        public String toLogString(){
        	StringBuilder sb = new StringBuilder();
        	
        				if(nconst == null){
        					sb.append("<null>");
        				}else{
            				sb.append(nconst);
            			}
            		
        			sb.append("|");
        		
        				if(primaryName == null){
        					sb.append("<null>");
        				}else{
            				sb.append(primaryName);
            			}
            		
        			sb.append("|");
        		
        				if(birthYear == null){
        					sb.append("<null>");
        				}else{
            				sb.append(birthYear);
            			}
            		
        			sb.append("|");
        		
        				if(deathYear == null){
        					sb.append("<null>");
        				}else{
            				sb.append(deathYear);
            			}
            		
        			sb.append("|");
        		
        				if(primaryProfession == null){
        					sb.append("<null>");
        				}else{
            				sb.append(primaryProfession);
            			}
            		
        			sb.append("|");
        		
        				if(knownForTitles == null){
        					sb.append("<null>");
        				}else{
            				sb.append(knownForTitles);
            			}
            		
        			sb.append("|");
        		
        				if(DI_Create_DT == null){
        					sb.append("<null>");
        				}else{
            				sb.append(DI_Create_DT);
            			}
            		
        			sb.append("|");
        		
        	return sb.toString();
        }

    /**
     * Compare keys
     */
    public int compareTo(row3Struct other) {

		int returnValue = -1;
		
	    return returnValue;
    }


    private int checkNullsAndCompare(Object object1, Object object2) {
        int returnValue = 0;
		if (object1 instanceof Comparable && object2 instanceof Comparable) {
            returnValue = ((Comparable) object1).compareTo(object2);
        } else if (object1 != null && object2 != null) {
            returnValue = compareStrings(object1.toString(), object2.toString());
        } else if (object1 == null && object2 != null) {
            returnValue = 1;
        } else if (object1 != null && object2 == null) {
            returnValue = -1;
        } else {
            returnValue = 0;
        }

        return returnValue;
    }

    private int compareStrings(String string1, String string2) {
        return string1.compareTo(string2);
    }


}

public void tDBInput_3Process(final java.util.Map<String, Object> globalMap) throws TalendException {
	globalMap.put("tDBInput_3_SUBPROCESS_STATE", 0);

 final boolean execStat = this.execStat;
	
		mdcInfo.forEach(org.slf4j.MDC::put);
		org.slf4j.MDC.put("_subJobName", "tDBInput_3");
		org.slf4j.MDC.put("_subJobPid", "XkVPZ9_" + subJobPidCounter.getAndIncrement());
	

	
		String iterateId = "";
	
	
	String currentComponent = "";
	String cLabel =  null;
	java.util.Map<String, Object> resourceMap = new java.util.HashMap<String, Object>();

	try {
			// TDI-39566 avoid throwing an useless Exception
			boolean resumeIt = true;
			if (globalResumeTicket == false && resumeEntryMethodName != null) {
				String currentMethodName = new java.lang.Exception().getStackTrace()[0].getMethodName();
				resumeIt = resumeEntryMethodName.equals(currentMethodName);
			}
			if (resumeIt || globalResumeTicket) { //start the resume
				globalResumeTicket = true;



		row3Struct row3 = new row3Struct();
copyOftoTable_0Struct copyOftoTable_0 = new copyOftoTable_0Struct();





	
	/**
	 * [tDBOutput_3 begin ] start
	 */

	

	
		
		ok_Hash.put("tDBOutput_3", false);
		start_Hash.put("tDBOutput_3", System.currentTimeMillis());
		
	
	currentComponent="tDBOutput_3";
	
	
			cLabel="stg_crew_name";
		
			runStat.updateStatAndLog(execStat,enableLogStash,resourceMap,iterateId,0,0,"copyOftoTable_0");
			
		int tos_count_tDBOutput_3 = 0;
		
                if(log.isDebugEnabled())
            log.debug("tDBOutput_3 - "  + ("Start to work.") );
            if (log.isDebugEnabled()) {
                class BytesLimit65535_tDBOutput_3{
                    public void limitLog4jByte() throws Exception{
                    StringBuilder log4jParamters_tDBOutput_3 = new StringBuilder();
                    log4jParamters_tDBOutput_3.append("Parameters:");
                            log4jParamters_tDBOutput_3.append("DB_VERSION" + " = " + "MYSQL_8");
                        log4jParamters_tDBOutput_3.append(" | ");
                            log4jParamters_tDBOutput_3.append("USE_EXISTING_CONNECTION" + " = " + "false");
                        log4jParamters_tDBOutput_3.append(" | ");
                            log4jParamters_tDBOutput_3.append("HOST" + " = " + "context.MySqlLocal_Server");
                        log4jParamters_tDBOutput_3.append(" | ");
                            log4jParamters_tDBOutput_3.append("PORT" + " = " + "context.MySqlLocal_Port");
                        log4jParamters_tDBOutput_3.append(" | ");
                            log4jParamters_tDBOutput_3.append("DBNAME" + " = " + "context.MySqlLocal_Database");
                        log4jParamters_tDBOutput_3.append(" | ");
                            log4jParamters_tDBOutput_3.append("USER" + " = " + "context.MySqlLocal_Login");
                        log4jParamters_tDBOutput_3.append(" | ");
                            log4jParamters_tDBOutput_3.append("PASS" + " = " + String.valueOf(routines.system.PasswordEncryptUtil.encryptPassword(context.MySqlLocal_Password)).substring(0, 4) + "...");     
                        log4jParamters_tDBOutput_3.append(" | ");
                            log4jParamters_tDBOutput_3.append("TABLE" + " = " + "\"stg_crew_name\"");
                        log4jParamters_tDBOutput_3.append(" | ");
                            log4jParamters_tDBOutput_3.append("TABLE_ACTION" + " = " + "CREATE_IF_NOT_EXISTS");
                        log4jParamters_tDBOutput_3.append(" | ");
                            log4jParamters_tDBOutput_3.append("DATA_ACTION" + " = " + "INSERT");
                        log4jParamters_tDBOutput_3.append(" | ");
                            log4jParamters_tDBOutput_3.append("SPECIFY_DATASOURCE_ALIAS" + " = " + "false");
                        log4jParamters_tDBOutput_3.append(" | ");
                            log4jParamters_tDBOutput_3.append("DIE_ON_ERROR" + " = " + "false");
                        log4jParamters_tDBOutput_3.append(" | ");
                            log4jParamters_tDBOutput_3.append("PROPERTIES" + " = " + "context.MySqlLocal_AdditionalParams");
                        log4jParamters_tDBOutput_3.append(" | ");
                            log4jParamters_tDBOutput_3.append("EXTENDINSERT" + " = " + "true");
                        log4jParamters_tDBOutput_3.append(" | ");
                            log4jParamters_tDBOutput_3.append("NB_ROWS_PER_INSERT" + " = " + "100");
                        log4jParamters_tDBOutput_3.append(" | ");
                            log4jParamters_tDBOutput_3.append("COMMIT_EVERY" + " = " + "10000");
                        log4jParamters_tDBOutput_3.append(" | ");
                            log4jParamters_tDBOutput_3.append("ADD_COLS" + " = " + "[]");
                        log4jParamters_tDBOutput_3.append(" | ");
                            log4jParamters_tDBOutput_3.append("USE_FIELD_OPTIONS" + " = " + "false");
                        log4jParamters_tDBOutput_3.append(" | ");
                            log4jParamters_tDBOutput_3.append("USE_HINT_OPTIONS" + " = " + "false");
                        log4jParamters_tDBOutput_3.append(" | ");
                            log4jParamters_tDBOutput_3.append("ENABLE_DEBUG_MODE" + " = " + "false");
                        log4jParamters_tDBOutput_3.append(" | ");
                            log4jParamters_tDBOutput_3.append("ON_DUPLICATE_KEY_UPDATE" + " = " + "false");
                        log4jParamters_tDBOutput_3.append(" | ");
                            log4jParamters_tDBOutput_3.append("UNIFIED_COMPONENTS" + " = " + "tMysqlOutput");
                        log4jParamters_tDBOutput_3.append(" | ");
                if(log.isDebugEnabled())
            log.debug("tDBOutput_3 - "  + (log4jParamters_tDBOutput_3) );
                    } 
                } 
            new BytesLimit65535_tDBOutput_3().limitLog4jByte();
            }
			if(enableLogStash) {
				talendJobLog.addCM("tDBOutput_3", "stg_crew_name", "tMysqlOutput");
				talendJobLogProcess(globalMap);
			}
			







int nb_line_tDBOutput_3 = 0;
int nb_line_update_tDBOutput_3 = 0;
int nb_line_inserted_tDBOutput_3 = 0;
int nb_line_deleted_tDBOutput_3 = 0;
int nb_line_rejected_tDBOutput_3 = 0;

int deletedCount_tDBOutput_3=0;
int updatedCount_tDBOutput_3=0;
int insertedCount_tDBOutput_3=0;
int rowsToCommitCount_tDBOutput_3=0;
int rejectedCount_tDBOutput_3=0;

String tableName_tDBOutput_3 = "stg_crew_name";
boolean whetherReject_tDBOutput_3 = false;

java.util.Calendar calendar_tDBOutput_3 = java.util.Calendar.getInstance();
calendar_tDBOutput_3.set(1, 0, 1, 0, 0, 0);
long year1_tDBOutput_3 = calendar_tDBOutput_3.getTime().getTime();
calendar_tDBOutput_3.set(10000, 0, 1, 0, 0, 0);
long year10000_tDBOutput_3 = calendar_tDBOutput_3.getTime().getTime();
long date_tDBOutput_3;

java.sql.Connection conn_tDBOutput_3 = null;
		
			
        String properties_tDBOutput_3 = context.MySqlLocal_AdditionalParams;
        if (properties_tDBOutput_3 == null || properties_tDBOutput_3.trim().length() == 0) {
            properties_tDBOutput_3 = "rewriteBatchedStatements=true&allowLoadLocalInfile=true";
        }else {
            if (!properties_tDBOutput_3.contains("rewriteBatchedStatements=")) {
                properties_tDBOutput_3 += "&rewriteBatchedStatements=true";
            }

            if (!properties_tDBOutput_3.contains("allowLoadLocalInfile=")) {
                properties_tDBOutput_3 += "&allowLoadLocalInfile=true";
            }
        }

        String url_tDBOutput_3 = "jdbc:mysql://" + context.MySqlLocal_Server + ":" + context.MySqlLocal_Port + "/" + context.MySqlLocal_Database + "?" + properties_tDBOutput_3;

			String driverClass_tDBOutput_3 = "com.mysql.cj.jdbc.Driver";
			
                if(log.isDebugEnabled())
            log.debug("tDBOutput_3 - "  + ("Driver ClassName: ")  + (driverClass_tDBOutput_3)  + (".") );
			String dbUser_tDBOutput_3 = context.MySqlLocal_Login;
			

			
	final String decryptedPassword_tDBOutput_3 = context.MySqlLocal_Password; 

			String dbPwd_tDBOutput_3 = decryptedPassword_tDBOutput_3;
			java.lang.Class.forName(driverClass_tDBOutput_3);
			
                if(log.isDebugEnabled())
            log.debug("tDBOutput_3 - "  + ("Connection attempts to '")  + (url_tDBOutput_3)  + ("' with the username '")  + (dbUser_tDBOutput_3)  + ("'.") );
			conn_tDBOutput_3 = java.sql.DriverManager.getConnection(url_tDBOutput_3, dbUser_tDBOutput_3, dbPwd_tDBOutput_3);
			
                if(log.isDebugEnabled())
            log.debug("tDBOutput_3 - "  + ("Connection to '")  + (url_tDBOutput_3)  + ("' has succeeded.") );
			
	resourceMap.put("conn_tDBOutput_3", conn_tDBOutput_3);
	
			conn_tDBOutput_3.setAutoCommit(false);
			int commitEvery_tDBOutput_3 = 10000;
			int commitCounter_tDBOutput_3 = 0;
			
                if(log.isDebugEnabled())
            log.debug("tDBOutput_3 - "  + ("Connection is set auto commit to '")  + (conn_tDBOutput_3.getAutoCommit())  + ("'.") );

		int count_tDBOutput_3=0;
		
				
                                java.sql.DatabaseMetaData dbMetaData_tDBOutput_3 = conn_tDBOutput_3.getMetaData();
                                    java.sql.ResultSet rsTable_tDBOutput_3 = dbMetaData_tDBOutput_3.getTables(context.MySqlLocal_Database, null, null, new String[]{"TABLE"});
                                boolean whetherExist_tDBOutput_3 = false;
                                while(rsTable_tDBOutput_3.next()) {
                                    String table_tDBOutput_3 = rsTable_tDBOutput_3.getString("TABLE_NAME");
                                    if(table_tDBOutput_3.equalsIgnoreCase("stg_crew_name")) {
                                        whetherExist_tDBOutput_3 = true;
                                        break;
                                    }
                                }
                                if(!whetherExist_tDBOutput_3) {
                                    try (java.sql.Statement stmtCreate_tDBOutput_3 = conn_tDBOutput_3.createStatement()) {
                if(log.isDebugEnabled())
            log.debug("tDBOutput_3 - "  + ("Creating")  + (" table '")  + (tableName_tDBOutput_3)  + ("'.") );
                                        stmtCreate_tDBOutput_3.execute("CREATE TABLE `" + tableName_tDBOutput_3 + "`(`nconst` VARCHAR(10)   not null ,`primaryName` VARCHAR(255)  ,`birthYear` VARCHAR(4)  ,`deathYear` VARCHAR(4)  ,`primaryProfession` VARCHAR(255)  ,`knownForTitles` VARCHAR(1024)  ,`DI_Create_DT` DATETIME  not null ,`DI_WorkflowJobId` VARCHAR(8)  )");
                if(log.isDebugEnabled())
            log.debug("tDBOutput_3 - "  + ("Create")  + (" table '")  + (tableName_tDBOutput_3)  + ("' has succeeded.") );
                                    }
                                }
			

		
						String insert_tDBOutput_3 = "INSERT INTO `" + "stg_crew_name" + "` (`nconst`,`primaryName`,`birthYear`,`deathYear`,`primaryProfession`,`knownForTitles`,`DI_Create_DT`,`DI_WorkflowJobId`) VALUES (?,?,?,?,?,?,?,?)";
		
						int batchSize_tDBOutput_3 = 100;
						int batchSizeCounter_tDBOutput_3=0;
						    
						java.sql.PreparedStatement pstmt_tDBOutput_3 = conn_tDBOutput_3.prepareStatement(insert_tDBOutput_3);
						resourceMap.put("pstmt_tDBOutput_3", pstmt_tDBOutput_3);

		


 



/**
 * [tDBOutput_3 begin ] stop
 */



	
	/**
	 * [tMap_3 begin ] start
	 */

	

	
		
		ok_Hash.put("tMap_3", false);
		start_Hash.put("tMap_3", System.currentTimeMillis());
		
	
	currentComponent="tMap_3";
	
	
			runStat.updateStatAndLog(execStat,enableLogStash,resourceMap,iterateId,0,0,"row3");
			
		int tos_count_tMap_3 = 0;
		
                if(log.isDebugEnabled())
            log.debug("tMap_3 - "  + ("Start to work.") );
            if (log.isDebugEnabled()) {
                class BytesLimit65535_tMap_3{
                    public void limitLog4jByte() throws Exception{
                    StringBuilder log4jParamters_tMap_3 = new StringBuilder();
                    log4jParamters_tMap_3.append("Parameters:");
                            log4jParamters_tMap_3.append("LINK_STYLE" + " = " + "AUTO");
                        log4jParamters_tMap_3.append(" | ");
                            log4jParamters_tMap_3.append("TEMPORARY_DATA_DIRECTORY" + " = " + "");
                        log4jParamters_tMap_3.append(" | ");
                            log4jParamters_tMap_3.append("ROWS_BUFFER_SIZE" + " = " + "2000000");
                        log4jParamters_tMap_3.append(" | ");
                            log4jParamters_tMap_3.append("CHANGE_HASH_AND_EQUALS_FOR_BIGDECIMAL" + " = " + "true");
                        log4jParamters_tMap_3.append(" | ");
                if(log.isDebugEnabled())
            log.debug("tMap_3 - "  + (log4jParamters_tMap_3) );
                    } 
                } 
            new BytesLimit65535_tMap_3().limitLog4jByte();
            }
			if(enableLogStash) {
				talendJobLog.addCM("tMap_3", "tMap_3", "tMap");
				talendJobLogProcess(globalMap);
			}
			




// ###############################
// # Lookup's keys initialization
		int count_row3_tMap_3 = 0;
		
// ###############################        

// ###############################
// # Vars initialization
class  Var__tMap_3__Struct  {
}
Var__tMap_3__Struct Var__tMap_3 = new Var__tMap_3__Struct();
// ###############################

// ###############################
// # Outputs initialization
				int count_copyOftoTable_0_tMap_3 = 0;
				
copyOftoTable_0Struct copyOftoTable_0_tmp = new copyOftoTable_0Struct();
// ###############################

        
        



        









 



/**
 * [tMap_3 begin ] stop
 */



	
	/**
	 * [tDBInput_3 begin ] start
	 */

	

	
		
		ok_Hash.put("tDBInput_3", false);
		start_Hash.put("tDBInput_3", System.currentTimeMillis());
		
	
	currentComponent="tDBInput_3";
	
	
			cLabel="imdb_name_basics";
		
		int tos_count_tDBInput_3 = 0;
		
                if(log.isDebugEnabled())
            log.debug("tDBInput_3 - "  + ("Start to work.") );
            if (log.isDebugEnabled()) {
                class BytesLimit65535_tDBInput_3{
                    public void limitLog4jByte() throws Exception{
                    StringBuilder log4jParamters_tDBInput_3 = new StringBuilder();
                    log4jParamters_tDBInput_3.append("Parameters:");
                            log4jParamters_tDBInput_3.append("DB_VERSION" + " = " + "MYSQL_8");
                        log4jParamters_tDBInput_3.append(" | ");
                            log4jParamters_tDBInput_3.append("USE_EXISTING_CONNECTION" + " = " + "false");
                        log4jParamters_tDBInput_3.append(" | ");
                            log4jParamters_tDBInput_3.append("HOST" + " = " + "context.MySqlLocal_Server");
                        log4jParamters_tDBInput_3.append(" | ");
                            log4jParamters_tDBInput_3.append("PORT" + " = " + "context.MySqlLocal_Port");
                        log4jParamters_tDBInput_3.append(" | ");
                            log4jParamters_tDBInput_3.append("DBNAME" + " = " + "context.MySqlLocal_Database");
                        log4jParamters_tDBInput_3.append(" | ");
                            log4jParamters_tDBInput_3.append("USER" + " = " + "context.MySqlLocal_Login");
                        log4jParamters_tDBInput_3.append(" | ");
                            log4jParamters_tDBInput_3.append("PASS" + " = " + String.valueOf(routines.system.PasswordEncryptUtil.encryptPassword(context.MySqlLocal_Password)).substring(0, 4) + "...");     
                        log4jParamters_tDBInput_3.append(" | ");
                            log4jParamters_tDBInput_3.append("TABLE" + " = " + "\"imdb_name_basics\"");
                        log4jParamters_tDBInput_3.append(" | ");
                            log4jParamters_tDBInput_3.append("QUERYSTORE" + " = " + "\"\"");
                        log4jParamters_tDBInput_3.append(" | ");
                            log4jParamters_tDBInput_3.append("QUERY" + " = " + "\"SELECT * FROM imdb_name_basics;\"");
                        log4jParamters_tDBInput_3.append(" | ");
                            log4jParamters_tDBInput_3.append("SPECIFY_DATASOURCE_ALIAS" + " = " + "false");
                        log4jParamters_tDBInput_3.append(" | ");
                            log4jParamters_tDBInput_3.append("PROPERTIES" + " = " + "context.MySqlLocal_AdditionalParams");
                        log4jParamters_tDBInput_3.append(" | ");
                            log4jParamters_tDBInput_3.append("ENABLE_STREAM" + " = " + "false");
                        log4jParamters_tDBInput_3.append(" | ");
                            log4jParamters_tDBInput_3.append("TRIM_ALL_COLUMN" + " = " + "false");
                        log4jParamters_tDBInput_3.append(" | ");
                            log4jParamters_tDBInput_3.append("TRIM_COLUMN" + " = " + "[{TRIM="+("false")+", SCHEMA_COLUMN="+("nconst")+"}, {TRIM="+("false")+", SCHEMA_COLUMN="+("primaryName")+"}, {TRIM="+("false")+", SCHEMA_COLUMN="+("birthYear")+"}, {TRIM="+("false")+", SCHEMA_COLUMN="+("deathYear")+"}, {TRIM="+("false")+", SCHEMA_COLUMN="+("primaryProfession")+"}, {TRIM="+("false")+", SCHEMA_COLUMN="+("knownForTitles")+"}, {TRIM="+("false")+", SCHEMA_COLUMN="+("DI_Create_DT")+"}]");
                        log4jParamters_tDBInput_3.append(" | ");
                            log4jParamters_tDBInput_3.append("UNIFIED_COMPONENTS" + " = " + "tMysqlInput");
                        log4jParamters_tDBInput_3.append(" | ");
                if(log.isDebugEnabled())
            log.debug("tDBInput_3 - "  + (log4jParamters_tDBInput_3) );
                    } 
                } 
            new BytesLimit65535_tDBInput_3().limitLog4jByte();
            }
			if(enableLogStash) {
				talendJobLog.addCM("tDBInput_3", "imdb_name_basics", "tMysqlInput");
				talendJobLogProcess(globalMap);
			}
			
	
	
		    java.util.Calendar calendar_tDBInput_3 = java.util.Calendar.getInstance();
		    calendar_tDBInput_3.set(0, 0, 0, 0, 0, 0);
		    java.util.Date year0_tDBInput_3 = calendar_tDBInput_3.getTime();
		    int nb_line_tDBInput_3 = 0;
		    java.sql.Connection conn_tDBInput_3 = null;
				String driverClass_tDBInput_3 = "com.mysql.cj.jdbc.Driver";
			    java.lang.Class jdbcclazz_tDBInput_3 = java.lang.Class.forName(driverClass_tDBInput_3);
				String dbUser_tDBInput_3 = context.MySqlLocal_Login;
				
				
	final String decryptedPassword_tDBInput_3 = context.MySqlLocal_Password; 
				
				String dbPwd_tDBInput_3 = decryptedPassword_tDBInput_3;
				
        String properties_tDBInput_3 = context.MySqlLocal_AdditionalParams;
        if (properties_tDBInput_3 == null || properties_tDBInput_3.trim().length() == 0) {
            properties_tDBInput_3 = "";
        }
        String url_tDBInput_3 = "jdbc:mysql://" + context.MySqlLocal_Server + ":" + context.MySqlLocal_Port + "/" + context.MySqlLocal_Database + "?" + properties_tDBInput_3;
				
	    		log.debug("tDBInput_3 - Driver ClassName: "+driverClass_tDBInput_3+".");
			
	    		log.debug("tDBInput_3 - Connection attempt to '" + url_tDBInput_3 + "' with the username '" + dbUser_tDBInput_3 + "'.");
			
				conn_tDBInput_3 = java.sql.DriverManager.getConnection(url_tDBInput_3,dbUser_tDBInput_3,dbPwd_tDBInput_3);
	    		log.debug("tDBInput_3 - Connection to '" + url_tDBInput_3 + "' has succeeded.");
			
		        
		    
			java.sql.Statement stmt_tDBInput_3 = conn_tDBInput_3.createStatement();

		    String dbquery_tDBInput_3 = "SELECT * FROM imdb_name_basics;";
		    
	    		log.debug("tDBInput_3 - Executing the query: '" + dbquery_tDBInput_3 + "'.");
			

		    globalMap.put("tDBInput_3_QUERY",dbquery_tDBInput_3);

		    java.sql.ResultSet rs_tDBInput_3 = null;

		    try {
		    	rs_tDBInput_3 = stmt_tDBInput_3.executeQuery(dbquery_tDBInput_3);
		    	java.sql.ResultSetMetaData rsmd_tDBInput_3 = rs_tDBInput_3.getMetaData();
		    	int colQtyInRs_tDBInput_3 = rsmd_tDBInput_3.getColumnCount();

		    String tmpContent_tDBInput_3 = null;
		    
		    
		    	log.debug("tDBInput_3 - Retrieving records from the database.");
		    
		    while (rs_tDBInput_3.next()) {
		        nb_line_tDBInput_3++;
		        
							if(colQtyInRs_tDBInput_3 < 1) {
								row3.nconst = null;
							} else {
	                         		
        	row3.nconst = routines.system.JDBCUtil.getString(rs_tDBInput_3, 1, false);
		                    }
							if(colQtyInRs_tDBInput_3 < 2) {
								row3.primaryName = null;
							} else {
	                         		
        	row3.primaryName = routines.system.JDBCUtil.getString(rs_tDBInput_3, 2, false);
		                    }
							if(colQtyInRs_tDBInput_3 < 3) {
								row3.birthYear = null;
							} else {
	                         		
        	row3.birthYear = routines.system.JDBCUtil.getString(rs_tDBInput_3, 3, false);
		                    }
							if(colQtyInRs_tDBInput_3 < 4) {
								row3.deathYear = null;
							} else {
	                         		
        	row3.deathYear = routines.system.JDBCUtil.getString(rs_tDBInput_3, 4, false);
		                    }
							if(colQtyInRs_tDBInput_3 < 5) {
								row3.primaryProfession = null;
							} else {
	                         		
        	row3.primaryProfession = routines.system.JDBCUtil.getString(rs_tDBInput_3, 5, false);
		                    }
							if(colQtyInRs_tDBInput_3 < 6) {
								row3.knownForTitles = null;
							} else {
	                         		
        	row3.knownForTitles = routines.system.JDBCUtil.getString(rs_tDBInput_3, 6, false);
		                    }
							if(colQtyInRs_tDBInput_3 < 7) {
								row3.DI_Create_DT = null;
							} else {
										
				if(rs_tDBInput_3.getString(7) != null) {
					String dateString_tDBInput_3 = rs_tDBInput_3.getString(7);
					if (!("0000-00-00").equals(dateString_tDBInput_3) && !("0000-00-00 00:00:00").equals(dateString_tDBInput_3)) {
						row3.DI_Create_DT = rs_tDBInput_3.getTimestamp(7);
					} else {
						row3.DI_Create_DT = (java.util.Date) year0_tDBInput_3.clone();
					}
				} else {
					row3.DI_Create_DT =  null;
				}
		                    }
					
						log.debug("tDBInput_3 - Retrieving the record " + nb_line_tDBInput_3 + ".");
					

 



/**
 * [tDBInput_3 begin ] stop
 */
	
	/**
	 * [tDBInput_3 main ] start
	 */

	

	
	
	currentComponent="tDBInput_3";
	
	
			cLabel="imdb_name_basics";
		

 


	tos_count_tDBInput_3++;

/**
 * [tDBInput_3 main ] stop
 */
	
	/**
	 * [tDBInput_3 process_data_begin ] start
	 */

	

	
	
	currentComponent="tDBInput_3";
	
	
			cLabel="imdb_name_basics";
		

 



/**
 * [tDBInput_3 process_data_begin ] stop
 */

	
	/**
	 * [tMap_3 main ] start
	 */

	

	
	
	currentComponent="tMap_3";
	
	
			if(runStat.update(execStat,enableLogStash,iterateId,1,1
				
					,"row3","tDBInput_3","imdb_name_basics","tMysqlInput","tMap_3","tMap_3","tMap"
				
			)) {
				talendJobLogProcess(globalMap);
			}
			
    			if(log.isTraceEnabled()){
    				log.trace("row3 - " + (row3==null? "": row3.toLogString()));
    			}
    		

		
		
		boolean hasCasePrimitiveKeyWithNull_tMap_3 = false;
		
		// ###############################
		// # Input tables (lookups)
		
		boolean rejectedInnerJoin_tMap_3 = false;
		boolean mainRowRejected_tMap_3 = false;
		// ###############################
        { // start of Var scope
        
	        // ###############################
        	// # Vars tables
        
Var__tMap_3__Struct Var = Var__tMap_3;// ###############################
        // ###############################
        // # Output tables

copyOftoTable_0 = null;


// # Output table : 'copyOftoTable_0'
count_copyOftoTable_0_tMap_3++;

copyOftoTable_0_tmp.nconst = row3.nconst;
copyOftoTable_0_tmp.primaryName = row3.primaryName;
copyOftoTable_0_tmp.birthYear = row3.birthYear;
copyOftoTable_0_tmp.deathYear = row3.deathYear;
copyOftoTable_0_tmp.primaryProfession = row3.primaryProfession;
copyOftoTable_0_tmp.knownForTitles = row3.knownForTitles;
copyOftoTable_0_tmp.DI_Create_DT = TalendDate.getCurrentDate();
copyOftoTable_0_tmp.DI_WorkflowJobId = pid;
copyOftoTable_0 = copyOftoTable_0_tmp;
log.debug("tMap_3 - Outputting the record " + count_copyOftoTable_0_tMap_3 + " of the output table 'copyOftoTable_0'.");

// ###############################

} // end of Var scope

rejectedInnerJoin_tMap_3 = false;










 


	tos_count_tMap_3++;

/**
 * [tMap_3 main ] stop
 */
	
	/**
	 * [tMap_3 process_data_begin ] start
	 */

	

	
	
	currentComponent="tMap_3";
	
	

 



/**
 * [tMap_3 process_data_begin ] stop
 */
// Start of branch "copyOftoTable_0"
if(copyOftoTable_0 != null) { 



	
	/**
	 * [tDBOutput_3 main ] start
	 */

	

	
	
	currentComponent="tDBOutput_3";
	
	
			cLabel="stg_crew_name";
		
			if(runStat.update(execStat,enableLogStash,iterateId,1,1
				
					,"copyOftoTable_0","tMap_3","tMap_3","tMap","tDBOutput_3","stg_crew_name","tMysqlOutput"
				
			)) {
				talendJobLogProcess(globalMap);
			}
			
    			if(log.isTraceEnabled()){
    				log.trace("copyOftoTable_0 - " + (copyOftoTable_0==null? "": copyOftoTable_0.toLogString()));
    			}
    		



        whetherReject_tDBOutput_3 = false;
                            if(copyOftoTable_0.nconst == null) {
pstmt_tDBOutput_3.setNull(1, java.sql.Types.VARCHAR);
} else {pstmt_tDBOutput_3.setString(1, copyOftoTable_0.nconst);
}

                            if(copyOftoTable_0.primaryName == null) {
pstmt_tDBOutput_3.setNull(2, java.sql.Types.VARCHAR);
} else {pstmt_tDBOutput_3.setString(2, copyOftoTable_0.primaryName);
}

                            if(copyOftoTable_0.birthYear == null) {
pstmt_tDBOutput_3.setNull(3, java.sql.Types.VARCHAR);
} else {pstmt_tDBOutput_3.setString(3, copyOftoTable_0.birthYear);
}

                            if(copyOftoTable_0.deathYear == null) {
pstmt_tDBOutput_3.setNull(4, java.sql.Types.VARCHAR);
} else {pstmt_tDBOutput_3.setString(4, copyOftoTable_0.deathYear);
}

                            if(copyOftoTable_0.primaryProfession == null) {
pstmt_tDBOutput_3.setNull(5, java.sql.Types.VARCHAR);
} else {pstmt_tDBOutput_3.setString(5, copyOftoTable_0.primaryProfession);
}

                            if(copyOftoTable_0.knownForTitles == null) {
pstmt_tDBOutput_3.setNull(6, java.sql.Types.VARCHAR);
} else {pstmt_tDBOutput_3.setString(6, copyOftoTable_0.knownForTitles);
}

                            if(copyOftoTable_0.DI_Create_DT != null) {
date_tDBOutput_3 = copyOftoTable_0.DI_Create_DT.getTime();
if(date_tDBOutput_3 < year1_tDBOutput_3 || date_tDBOutput_3 >= year10000_tDBOutput_3) {
pstmt_tDBOutput_3.setString(7, "0000-00-00 00:00:00");
} else {pstmt_tDBOutput_3.setTimestamp(7, new java.sql.Timestamp(date_tDBOutput_3));
}
} else {
pstmt_tDBOutput_3.setNull(7, java.sql.Types.DATE);
}

                            if(copyOftoTable_0.DI_WorkflowJobId == null) {
pstmt_tDBOutput_3.setNull(8, java.sql.Types.VARCHAR);
} else {pstmt_tDBOutput_3.setString(8, copyOftoTable_0.DI_WorkflowJobId);
}

                    pstmt_tDBOutput_3.addBatch();
                    nb_line_tDBOutput_3++;

                if(log.isDebugEnabled())
            log.debug("tDBOutput_3 - "  + ("Adding the record ")  + (nb_line_tDBOutput_3)  + (" to the ")  + ("INSERT")  + (" batch.") );
                      batchSizeCounter_tDBOutput_3++;
                if ( batchSize_tDBOutput_3 <= batchSizeCounter_tDBOutput_3) {
                try {
                        int countSum_tDBOutput_3 = 0;
                if(log.isDebugEnabled())
            log.debug("tDBOutput_3 - "  + ("Executing the ")  + ("INSERT")  + (" batch.") );
                        for(int countEach_tDBOutput_3: pstmt_tDBOutput_3.executeBatch()) {
                            countSum_tDBOutput_3 += (countEach_tDBOutput_3 == java.sql.Statement.EXECUTE_FAILED ? 0 : 1);
                        }
                        rowsToCommitCount_tDBOutput_3 += countSum_tDBOutput_3;
                if(log.isDebugEnabled())
            log.debug("tDBOutput_3 - "  + ("The ")  + ("INSERT")  + (" batch execution has succeeded.") );
                        insertedCount_tDBOutput_3 += countSum_tDBOutput_3;
                }catch (java.sql.BatchUpdateException e){
                    globalMap.put("tDBOutput_3_ERROR_MESSAGE",e.getMessage());
                    int countSum_tDBOutput_3 = 0;
                    for(int countEach_tDBOutput_3: e.getUpdateCounts()) {
                        countSum_tDBOutput_3 += (countEach_tDBOutput_3 < 0 ? 0 : countEach_tDBOutput_3);
                    }
                    rowsToCommitCount_tDBOutput_3 += countSum_tDBOutput_3;
                    insertedCount_tDBOutput_3 += countSum_tDBOutput_3;
                    System.err.println(e.getMessage());
            log.error("tDBOutput_3 - "  + (e.getMessage()) );
                }

                batchSizeCounter_tDBOutput_3 = 0;
            }
                commitCounter_tDBOutput_3++;

                if(commitEvery_tDBOutput_3 <= commitCounter_tDBOutput_3) {

                        try {
                                int countSum_tDBOutput_3 = 0;
                if(log.isDebugEnabled())
            log.debug("tDBOutput_3 - "  + ("Executing the ")  + ("INSERT")  + (" batch.") );
                                for(int countEach_tDBOutput_3: pstmt_tDBOutput_3.executeBatch()) {
                                    countSum_tDBOutput_3 += (countEach_tDBOutput_3 < 0 ? 0 : 1);
                                }
                                rowsToCommitCount_tDBOutput_3 += countSum_tDBOutput_3;
                if(log.isDebugEnabled())
            log.debug("tDBOutput_3 - "  + ("The ")  + ("INSERT")  + (" batch execution has succeeded.") );
                                insertedCount_tDBOutput_3 += countSum_tDBOutput_3;
                        }catch (java.sql.BatchUpdateException e){
                            globalMap.put("tDBOutput_3_ERROR_MESSAGE",e.getMessage());
                            int countSum_tDBOutput_3 = 0;
                            for(int countEach_tDBOutput_3: e.getUpdateCounts()) {
                                countSum_tDBOutput_3 += (countEach_tDBOutput_3 < 0 ? 0 : countEach_tDBOutput_3);
                            }
                            rowsToCommitCount_tDBOutput_3 += countSum_tDBOutput_3;
                            insertedCount_tDBOutput_3 += countSum_tDBOutput_3;
                            System.err.println(e.getMessage());
            log.error("tDBOutput_3 - "  + (e.getMessage()) );

                        }
                    if(rowsToCommitCount_tDBOutput_3 != 0){
                if(log.isDebugEnabled())
            log.debug("tDBOutput_3 - "  + ("Connection starting to commit ")  + (rowsToCommitCount_tDBOutput_3)  + (" record(s).") );
                    }
                    conn_tDBOutput_3.commit();
                    if(rowsToCommitCount_tDBOutput_3 != 0){
                if(log.isDebugEnabled())
            log.debug("tDBOutput_3 - "  + ("Connection commit has succeeded.") );
                        rowsToCommitCount_tDBOutput_3 = 0;
                    }
                    commitCounter_tDBOutput_3=0;
                }

 


	tos_count_tDBOutput_3++;

/**
 * [tDBOutput_3 main ] stop
 */
	
	/**
	 * [tDBOutput_3 process_data_begin ] start
	 */

	

	
	
	currentComponent="tDBOutput_3";
	
	
			cLabel="stg_crew_name";
		

 



/**
 * [tDBOutput_3 process_data_begin ] stop
 */
	
	/**
	 * [tDBOutput_3 process_data_end ] start
	 */

	

	
	
	currentComponent="tDBOutput_3";
	
	
			cLabel="stg_crew_name";
		

 



/**
 * [tDBOutput_3 process_data_end ] stop
 */

} // End of branch "copyOftoTable_0"




	
	/**
	 * [tMap_3 process_data_end ] start
	 */

	

	
	
	currentComponent="tMap_3";
	
	

 



/**
 * [tMap_3 process_data_end ] stop
 */



	
	/**
	 * [tDBInput_3 process_data_end ] start
	 */

	

	
	
	currentComponent="tDBInput_3";
	
	
			cLabel="imdb_name_basics";
		

 



/**
 * [tDBInput_3 process_data_end ] stop
 */
	
	/**
	 * [tDBInput_3 end ] start
	 */

	

	
	
	currentComponent="tDBInput_3";
	
	
			cLabel="imdb_name_basics";
		

	}
}finally{
	if (rs_tDBInput_3 != null) {
		rs_tDBInput_3.close();
	}
	if (stmt_tDBInput_3 != null) {
		stmt_tDBInput_3.close();
	}
		if(conn_tDBInput_3 != null && !conn_tDBInput_3.isClosed()) {
			
	    		log.debug("tDBInput_3 - Closing the connection to the database.");
			
			conn_tDBInput_3.close();
			
			if("com.mysql.cj.jdbc.Driver".equals((String)globalMap.get("driverClass_"))
			    && routines.system.BundleUtils.inOSGi()) {
			        Class.forName("com.mysql.cj.jdbc.AbandonedConnectionCleanupThread").
			            getMethod("checkedShutdown").invoke(null, (Object[]) null);
			}
			
	    		log.debug("tDBInput_3 - Connection to the database closed.");
			
		}
		
}
globalMap.put("tDBInput_3_NB_LINE",nb_line_tDBInput_3);
	    		log.debug("tDBInput_3 - Retrieved records count: "+nb_line_tDBInput_3 + " .");
			

 
                if(log.isDebugEnabled())
            log.debug("tDBInput_3 - "  + ("Done.") );

ok_Hash.put("tDBInput_3", true);
end_Hash.put("tDBInput_3", System.currentTimeMillis());




/**
 * [tDBInput_3 end ] stop
 */

	
	/**
	 * [tMap_3 end ] start
	 */

	

	
	
	currentComponent="tMap_3";
	
	


// ###############################
// # Lookup hashes releasing
// ###############################      
				log.debug("tMap_3 - Written records count in the table 'copyOftoTable_0': " + count_copyOftoTable_0_tMap_3 + ".");





			 		if(runStat.updateStatAndLog(execStat,enableLogStash,resourceMap,iterateId,"row3",2,0,
			 			"tDBInput_3","imdb_name_basics","tMysqlInput","tMap_3","tMap_3","tMap","output")) {
						talendJobLogProcess(globalMap);
					}
				
 
                if(log.isDebugEnabled())
            log.debug("tMap_3 - "  + ("Done.") );

ok_Hash.put("tMap_3", true);
end_Hash.put("tMap_3", System.currentTimeMillis());




/**
 * [tMap_3 end ] stop
 */

	
	/**
	 * [tDBOutput_3 end ] start
	 */

	

	
	
	currentComponent="tDBOutput_3";
	
	
			cLabel="stg_crew_name";
		



				
					try {
						if (batchSizeCounter_tDBOutput_3 != 0) {
							int countSum_tDBOutput_3 = 0;
							
                if(log.isDebugEnabled())
            log.debug("tDBOutput_3 - "  + ("Executing the ")  + ("INSERT")  + (" batch.") );
							for(int countEach_tDBOutput_3: pstmt_tDBOutput_3.executeBatch()) {
								countSum_tDBOutput_3 += (countEach_tDBOutput_3 == java.sql.Statement.EXECUTE_FAILED ? 0 : 1);
							}
							rowsToCommitCount_tDBOutput_3 += countSum_tDBOutput_3;
							
                if(log.isDebugEnabled())
            log.debug("tDBOutput_3 - "  + ("The ")  + ("INSERT")  + (" batch execution has succeeded.") );
							
								insertedCount_tDBOutput_3 += countSum_tDBOutput_3;
							
						}
					}catch (java.sql.BatchUpdateException e){
						globalMap.put(currentComponent+"_ERROR_MESSAGE",e.getMessage());
						
							int countSum_tDBOutput_3 = 0;
							for(int countEach_tDBOutput_3: e.getUpdateCounts()) {
								countSum_tDBOutput_3 += (countEach_tDBOutput_3 < 0 ? 0 : countEach_tDBOutput_3);
							}
							rowsToCommitCount_tDBOutput_3 += countSum_tDBOutput_3;
							
								insertedCount_tDBOutput_3 += countSum_tDBOutput_3;
								
            log.error("tDBOutput_3 - "  + (e.getMessage()) );
							System.err.println(e.getMessage());
							
					}
					batchSizeCounter_tDBOutput_3 = 0;
					
			
		

		if(pstmt_tDBOutput_3 != null) {
			
				pstmt_tDBOutput_3.close();
				resourceMap.remove("pstmt_tDBOutput_3");
			
		}
		
	resourceMap.put("statementClosed_tDBOutput_3", true);
	
			if (commitCounter_tDBOutput_3 > 0 && rowsToCommitCount_tDBOutput_3 != 0) {
				
                if(log.isDebugEnabled())
            log.debug("tDBOutput_3 - "  + ("Connection starting to commit ")  + (rowsToCommitCount_tDBOutput_3)  + (" record(s).") );
			}
			conn_tDBOutput_3.commit();
			if (commitCounter_tDBOutput_3 > 0 && rowsToCommitCount_tDBOutput_3 != 0) {
				
                if(log.isDebugEnabled())
            log.debug("tDBOutput_3 - "  + ("Connection commit has succeeded.") );
				rowsToCommitCount_tDBOutput_3 = 0;
			}
			commitCounter_tDBOutput_3 = 0;
			
		
                if(log.isDebugEnabled())
            log.debug("tDBOutput_3 - "  + ("Closing the connection to the database.") );
		conn_tDBOutput_3 .close();
		
                if(log.isDebugEnabled())
            log.debug("tDBOutput_3 - "  + ("Connection to the database has closed.") );
		resourceMap.put("finish_tDBOutput_3", true);
	

	nb_line_deleted_tDBOutput_3=nb_line_deleted_tDBOutput_3+ deletedCount_tDBOutput_3;
	nb_line_update_tDBOutput_3=nb_line_update_tDBOutput_3 + updatedCount_tDBOutput_3;
	nb_line_inserted_tDBOutput_3=nb_line_inserted_tDBOutput_3 + insertedCount_tDBOutput_3;
	nb_line_rejected_tDBOutput_3=nb_line_rejected_tDBOutput_3 + rejectedCount_tDBOutput_3;
	
        globalMap.put("tDBOutput_3_NB_LINE",nb_line_tDBOutput_3);
        globalMap.put("tDBOutput_3_NB_LINE_UPDATED",nb_line_update_tDBOutput_3);
        globalMap.put("tDBOutput_3_NB_LINE_INSERTED",nb_line_inserted_tDBOutput_3);
        globalMap.put("tDBOutput_3_NB_LINE_DELETED",nb_line_deleted_tDBOutput_3);
        globalMap.put("tDBOutput_3_NB_LINE_REJECTED", nb_line_rejected_tDBOutput_3);
    

	
                if(log.isDebugEnabled())
            log.debug("tDBOutput_3 - "  + ("Has ")  + ("inserted")  + (" ")  + (nb_line_inserted_tDBOutput_3)  + (" record(s).") );

			 		if(runStat.updateStatAndLog(execStat,enableLogStash,resourceMap,iterateId,"copyOftoTable_0",2,0,
			 			"tMap_3","tMap_3","tMap","tDBOutput_3","stg_crew_name","tMysqlOutput","output")) {
						talendJobLogProcess(globalMap);
					}
				
 
                if(log.isDebugEnabled())
            log.debug("tDBOutput_3 - "  + ("Done.") );

ok_Hash.put("tDBOutput_3", true);
end_Hash.put("tDBOutput_3", System.currentTimeMillis());




/**
 * [tDBOutput_3 end ] stop
 */






				}//end the resume

				
				    			if(resumeEntryMethodName == null || globalResumeTicket){
				    				resumeUtil.addLog("CHECKPOINT", "CONNECTION:SUBJOB_OK:tDBInput_3:OnSubjobOk", "", Thread.currentThread().getId() + "", "", "", "", "", "");
								}	    				    			
					    	
								if(execStat){    	
									runStat.updateStatOnConnection("OnSubjobOk3", 0, "ok");
								} 
							
							tDBInput_4Process(globalMap); 
						



	
			}catch(java.lang.Exception e){	
				
				    if(!(e instanceof TalendException)){
					   log.fatal(currentComponent + " " + e.getMessage(),e);
					}
				
				TalendException te = new TalendException(e, currentComponent, cLabel, globalMap);
				
				throw te;
			}catch(java.lang.Error error){	
				
					runStat.stopThreadStat();
				
				throw error;
			}finally{
				
				try{
					
	
	/**
	 * [tDBInput_3 finally ] start
	 */

	

	
	
	currentComponent="tDBInput_3";
	
	
			cLabel="imdb_name_basics";
		

 



/**
 * [tDBInput_3 finally ] stop
 */

	
	/**
	 * [tMap_3 finally ] start
	 */

	

	
	
	currentComponent="tMap_3";
	
	

 



/**
 * [tMap_3 finally ] stop
 */

	
	/**
	 * [tDBOutput_3 finally ] start
	 */

	

	
	
	currentComponent="tDBOutput_3";
	
	
			cLabel="stg_crew_name";
		



    try {
    if (resourceMap.get("statementClosed_tDBOutput_3") == null) {
                java.sql.PreparedStatement pstmtToClose_tDBOutput_3 = null;
                if ((pstmtToClose_tDBOutput_3 = (java.sql.PreparedStatement) resourceMap.remove("pstmt_tDBOutput_3")) != null) {
                    pstmtToClose_tDBOutput_3.close();
                }
    }
    } finally {
        if(resourceMap.get("finish_tDBOutput_3") == null){
            java.sql.Connection ctn_tDBOutput_3 = null;
            if((ctn_tDBOutput_3 = (java.sql.Connection)resourceMap.get("conn_tDBOutput_3")) != null){
                try {
                if(log.isDebugEnabled())
            log.debug("tDBOutput_3 - "  + ("Closing the connection to the database.") );
                    ctn_tDBOutput_3.close();
                if(log.isDebugEnabled())
            log.debug("tDBOutput_3 - "  + ("Connection to the database has closed.") );
                } catch (java.sql.SQLException sqlEx_tDBOutput_3) {
                    String errorMessage_tDBOutput_3 = "failed to close the connection in tDBOutput_3 :" + sqlEx_tDBOutput_3.getMessage();
            log.error("tDBOutput_3 - "  + (errorMessage_tDBOutput_3) );
                    System.err.println(errorMessage_tDBOutput_3);
                }
            }
        }
    }
 



/**
 * [tDBOutput_3 finally ] stop
 */






				}catch(java.lang.Exception e){	
					//ignore
				}catch(java.lang.Error error){
					//ignore
				}
				resourceMap = null;
			}
		

		globalMap.put("tDBInput_3_SUBPROCESS_STATE", 1);
	}
	


public static class copyOftoTable_1Struct implements routines.system.IPersistableRow<copyOftoTable_1Struct> {
    final static byte[] commonByteArrayLock_FINAL_PROJECT_sql_staging_job = new byte[0];
    static byte[] commonByteArray_FINAL_PROJECT_sql_staging_job = new byte[0];

	
			    public String tconst;

				public String getTconst () {
					return this.tconst;
				}

				public Boolean tconstIsNullable(){
				    return false;
				}
				public Boolean tconstIsKey(){
				    return false;
				}
				public Integer tconstLength(){
				    return 10;
				}
				public Integer tconstPrecision(){
				    return 0;
				}
				public String tconstDefault(){
				
					return null;
				
				}
				public String tconstComment(){
				
				    return "";
				
				}
				public String tconstPattern(){
				
					return "";
				
				}
				public String tconstOriginalDbColumnName(){
				
					return "tconst";
				
				}

				
			    public String directors;

				public String getDirectors () {
					return this.directors;
				}

				public Boolean directorsIsNullable(){
				    return true;
				}
				public Boolean directorsIsKey(){
				    return false;
				}
				public Integer directorsLength(){
				    return 4000;
				}
				public Integer directorsPrecision(){
				    return 0;
				}
				public String directorsDefault(){
				
					return null;
				
				}
				public String directorsComment(){
				
				    return "";
				
				}
				public String directorsPattern(){
				
					return "";
				
				}
				public String directorsOriginalDbColumnName(){
				
					return "directors";
				
				}

				
			    public String writers;

				public String getWriters () {
					return this.writers;
				}

				public Boolean writersIsNullable(){
				    return true;
				}
				public Boolean writersIsKey(){
				    return false;
				}
				public Integer writersLength(){
				    return 4000;
				}
				public Integer writersPrecision(){
				    return 0;
				}
				public String writersDefault(){
				
					return null;
				
				}
				public String writersComment(){
				
				    return "";
				
				}
				public String writersPattern(){
				
					return "";
				
				}
				public String writersOriginalDbColumnName(){
				
					return "writers";
				
				}

				
			    public java.util.Date DI_Create_DT;

				public java.util.Date getDI_Create_DT () {
					return this.DI_Create_DT;
				}

				public Boolean DI_Create_DTIsNullable(){
				    return false;
				}
				public Boolean DI_Create_DTIsKey(){
				    return false;
				}
				public Integer DI_Create_DTLength(){
				    return 19;
				}
				public Integer DI_Create_DTPrecision(){
				    return 0;
				}
				public String DI_Create_DTDefault(){
				
					return null;
				
				}
				public String DI_Create_DTComment(){
				
				    return "";
				
				}
				public String DI_Create_DTPattern(){
				
					return "dd-MM-yyyy";
				
				}
				public String DI_Create_DTOriginalDbColumnName(){
				
					return "DI_Create_DT";
				
				}

				
			    public String DI_WorkflowJobId;

				public String getDI_WorkflowJobId () {
					return this.DI_WorkflowJobId;
				}

				public Boolean DI_WorkflowJobIdIsNullable(){
				    return true;
				}
				public Boolean DI_WorkflowJobIdIsKey(){
				    return false;
				}
				public Integer DI_WorkflowJobIdLength(){
				    return 8;
				}
				public Integer DI_WorkflowJobIdPrecision(){
				    return null;
				}
				public String DI_WorkflowJobIdDefault(){
				
					return null;
				
				}
				public String DI_WorkflowJobIdComment(){
				
				    return "";
				
				}
				public String DI_WorkflowJobIdPattern(){
				
					return "";
				
				}
				public String DI_WorkflowJobIdOriginalDbColumnName(){
				
					return "DI_WorkflowJobId";
				
				}

				



	private String readString(ObjectInputStream dis) throws IOException{
		String strReturn = null;
		int length = 0;
        length = dis.readInt();
		if (length == -1) {
			strReturn = null;
		} else {
			if(length > commonByteArray_FINAL_PROJECT_sql_staging_job.length) {
				if(length < 1024 && commonByteArray_FINAL_PROJECT_sql_staging_job.length == 0) {
   					commonByteArray_FINAL_PROJECT_sql_staging_job = new byte[1024];
				} else {
   					commonByteArray_FINAL_PROJECT_sql_staging_job = new byte[2 * length];
   				}
			}
			dis.readFully(commonByteArray_FINAL_PROJECT_sql_staging_job, 0, length);
			strReturn = new String(commonByteArray_FINAL_PROJECT_sql_staging_job, 0, length, utf8Charset);
		}
		return strReturn;
	}
	
	private String readString(org.jboss.marshalling.Unmarshaller unmarshaller) throws IOException{
		String strReturn = null;
		int length = 0;
        length = unmarshaller.readInt();
		if (length == -1) {
			strReturn = null;
		} else {
			if(length > commonByteArray_FINAL_PROJECT_sql_staging_job.length) {
				if(length < 1024 && commonByteArray_FINAL_PROJECT_sql_staging_job.length == 0) {
   					commonByteArray_FINAL_PROJECT_sql_staging_job = new byte[1024];
				} else {
   					commonByteArray_FINAL_PROJECT_sql_staging_job = new byte[2 * length];
   				}
			}
			unmarshaller.readFully(commonByteArray_FINAL_PROJECT_sql_staging_job, 0, length);
			strReturn = new String(commonByteArray_FINAL_PROJECT_sql_staging_job, 0, length, utf8Charset);
		}
		return strReturn;
	}

    private void writeString(String str, ObjectOutputStream dos) throws IOException{
		if(str == null) {
            dos.writeInt(-1);
		} else {
            byte[] byteArray = str.getBytes(utf8Charset);
	    	dos.writeInt(byteArray.length);
			dos.write(byteArray);
    	}
    }
    
    private void writeString(String str, org.jboss.marshalling.Marshaller marshaller) throws IOException{
		if(str == null) {
			marshaller.writeInt(-1);
		} else {
            byte[] byteArray = str.getBytes(utf8Charset);
            marshaller.writeInt(byteArray.length);
            marshaller.write(byteArray);
    	}
    }

	private java.util.Date readDate(ObjectInputStream dis) throws IOException{
		java.util.Date dateReturn = null;
        int length = 0;
        length = dis.readByte();
		if (length == -1) {
			dateReturn = null;
		} else {
	    	dateReturn = new Date(dis.readLong());
		}
		return dateReturn;
	}
	
	private java.util.Date readDate(org.jboss.marshalling.Unmarshaller unmarshaller) throws IOException{
		java.util.Date dateReturn = null;
        int length = 0;
        length = unmarshaller.readByte();
		if (length == -1) {
			dateReturn = null;
		} else {
	    	dateReturn = new Date(unmarshaller.readLong());
		}
		return dateReturn;
	}

    private void writeDate(java.util.Date date1, ObjectOutputStream dos) throws IOException{
		if(date1 == null) {
            dos.writeByte(-1);
		} else {
			dos.writeByte(0);
	    	dos.writeLong(date1.getTime());
    	}
    }
    
    private void writeDate(java.util.Date date1, org.jboss.marshalling.Marshaller marshaller) throws IOException{
		if(date1 == null) {
			marshaller.writeByte(-1);
		} else {
			marshaller.writeByte(0);
			marshaller.writeLong(date1.getTime());
    	}
    }

    public void readData(ObjectInputStream dis) {

		synchronized(commonByteArrayLock_FINAL_PROJECT_sql_staging_job) {

        	try {

        		int length = 0;
		
					this.tconst = readString(dis);
					
					this.directors = readString(dis);
					
					this.writers = readString(dis);
					
					this.DI_Create_DT = readDate(dis);
					
					this.DI_WorkflowJobId = readString(dis);
					
        	} catch (IOException e) {
	            throw new RuntimeException(e);

		

        }

		

      }


    }
    
    public void readData(org.jboss.marshalling.Unmarshaller dis) {

		synchronized(commonByteArrayLock_FINAL_PROJECT_sql_staging_job) {

        	try {

        		int length = 0;
		
					this.tconst = readString(dis);
					
					this.directors = readString(dis);
					
					this.writers = readString(dis);
					
					this.DI_Create_DT = readDate(dis);
					
					this.DI_WorkflowJobId = readString(dis);
					
        	} catch (IOException e) {
	            throw new RuntimeException(e);

		

        }

		

      }


    }

    public void writeData(ObjectOutputStream dos) {
        try {

		
					// String
				
						writeString(this.tconst,dos);
					
					// String
				
						writeString(this.directors,dos);
					
					// String
				
						writeString(this.writers,dos);
					
					// java.util.Date
				
						writeDate(this.DI_Create_DT,dos);
					
					// String
				
						writeString(this.DI_WorkflowJobId,dos);
					
        	} catch (IOException e) {
	            throw new RuntimeException(e);
        }


    }
    
    public void writeData(org.jboss.marshalling.Marshaller dos) {
        try {

		
					// String
				
						writeString(this.tconst,dos);
					
					// String
				
						writeString(this.directors,dos);
					
					// String
				
						writeString(this.writers,dos);
					
					// java.util.Date
				
						writeDate(this.DI_Create_DT,dos);
					
					// String
				
						writeString(this.DI_WorkflowJobId,dos);
					
        	} catch (IOException e) {
	            throw new RuntimeException(e);
        }


    }


    public String toString() {

		StringBuilder sb = new StringBuilder();
		sb.append(super.toString());
		sb.append("[");
		sb.append("tconst="+tconst);
		sb.append(",directors="+directors);
		sb.append(",writers="+writers);
		sb.append(",DI_Create_DT="+String.valueOf(DI_Create_DT));
		sb.append(",DI_WorkflowJobId="+DI_WorkflowJobId);
	    sb.append("]");

	    return sb.toString();
    }
        public String toLogString(){
        	StringBuilder sb = new StringBuilder();
        	
        				if(tconst == null){
        					sb.append("<null>");
        				}else{
            				sb.append(tconst);
            			}
            		
        			sb.append("|");
        		
        				if(directors == null){
        					sb.append("<null>");
        				}else{
            				sb.append(directors);
            			}
            		
        			sb.append("|");
        		
        				if(writers == null){
        					sb.append("<null>");
        				}else{
            				sb.append(writers);
            			}
            		
        			sb.append("|");
        		
        				if(DI_Create_DT == null){
        					sb.append("<null>");
        				}else{
            				sb.append(DI_Create_DT);
            			}
            		
        			sb.append("|");
        		
        				if(DI_WorkflowJobId == null){
        					sb.append("<null>");
        				}else{
            				sb.append(DI_WorkflowJobId);
            			}
            		
        			sb.append("|");
        		
        	return sb.toString();
        }

    /**
     * Compare keys
     */
    public int compareTo(copyOftoTable_1Struct other) {

		int returnValue = -1;
		
	    return returnValue;
    }


    private int checkNullsAndCompare(Object object1, Object object2) {
        int returnValue = 0;
		if (object1 instanceof Comparable && object2 instanceof Comparable) {
            returnValue = ((Comparable) object1).compareTo(object2);
        } else if (object1 != null && object2 != null) {
            returnValue = compareStrings(object1.toString(), object2.toString());
        } else if (object1 == null && object2 != null) {
            returnValue = 1;
        } else if (object1 != null && object2 == null) {
            returnValue = -1;
        } else {
            returnValue = 0;
        }

        return returnValue;
    }

    private int compareStrings(String string1, String string2) {
        return string1.compareTo(string2);
    }


}

public static class row4Struct implements routines.system.IPersistableRow<row4Struct> {
    final static byte[] commonByteArrayLock_FINAL_PROJECT_sql_staging_job = new byte[0];
    static byte[] commonByteArray_FINAL_PROJECT_sql_staging_job = new byte[0];

	
			    public String tconst;

				public String getTconst () {
					return this.tconst;
				}

				public Boolean tconstIsNullable(){
				    return false;
				}
				public Boolean tconstIsKey(){
				    return false;
				}
				public Integer tconstLength(){
				    return 10;
				}
				public Integer tconstPrecision(){
				    return 0;
				}
				public String tconstDefault(){
				
					return null;
				
				}
				public String tconstComment(){
				
				    return "";
				
				}
				public String tconstPattern(){
				
					return "";
				
				}
				public String tconstOriginalDbColumnName(){
				
					return "tconst";
				
				}

				
			    public String directors;

				public String getDirectors () {
					return this.directors;
				}

				public Boolean directorsIsNullable(){
				    return true;
				}
				public Boolean directorsIsKey(){
				    return false;
				}
				public Integer directorsLength(){
				    return 4000;
				}
				public Integer directorsPrecision(){
				    return 0;
				}
				public String directorsDefault(){
				
					return null;
				
				}
				public String directorsComment(){
				
				    return "";
				
				}
				public String directorsPattern(){
				
					return "";
				
				}
				public String directorsOriginalDbColumnName(){
				
					return "directors";
				
				}

				
			    public String writers;

				public String getWriters () {
					return this.writers;
				}

				public Boolean writersIsNullable(){
				    return true;
				}
				public Boolean writersIsKey(){
				    return false;
				}
				public Integer writersLength(){
				    return 4000;
				}
				public Integer writersPrecision(){
				    return 0;
				}
				public String writersDefault(){
				
					return null;
				
				}
				public String writersComment(){
				
				    return "";
				
				}
				public String writersPattern(){
				
					return "";
				
				}
				public String writersOriginalDbColumnName(){
				
					return "writers";
				
				}

				
			    public java.util.Date DI_Create_DT;

				public java.util.Date getDI_Create_DT () {
					return this.DI_Create_DT;
				}

				public Boolean DI_Create_DTIsNullable(){
				    return false;
				}
				public Boolean DI_Create_DTIsKey(){
				    return false;
				}
				public Integer DI_Create_DTLength(){
				    return 19;
				}
				public Integer DI_Create_DTPrecision(){
				    return 0;
				}
				public String DI_Create_DTDefault(){
				
					return null;
				
				}
				public String DI_Create_DTComment(){
				
				    return "";
				
				}
				public String DI_Create_DTPattern(){
				
					return "dd-MM-yyyy";
				
				}
				public String DI_Create_DTOriginalDbColumnName(){
				
					return "DI_Create_DT";
				
				}

				



	private String readString(ObjectInputStream dis) throws IOException{
		String strReturn = null;
		int length = 0;
        length = dis.readInt();
		if (length == -1) {
			strReturn = null;
		} else {
			if(length > commonByteArray_FINAL_PROJECT_sql_staging_job.length) {
				if(length < 1024 && commonByteArray_FINAL_PROJECT_sql_staging_job.length == 0) {
   					commonByteArray_FINAL_PROJECT_sql_staging_job = new byte[1024];
				} else {
   					commonByteArray_FINAL_PROJECT_sql_staging_job = new byte[2 * length];
   				}
			}
			dis.readFully(commonByteArray_FINAL_PROJECT_sql_staging_job, 0, length);
			strReturn = new String(commonByteArray_FINAL_PROJECT_sql_staging_job, 0, length, utf8Charset);
		}
		return strReturn;
	}
	
	private String readString(org.jboss.marshalling.Unmarshaller unmarshaller) throws IOException{
		String strReturn = null;
		int length = 0;
        length = unmarshaller.readInt();
		if (length == -1) {
			strReturn = null;
		} else {
			if(length > commonByteArray_FINAL_PROJECT_sql_staging_job.length) {
				if(length < 1024 && commonByteArray_FINAL_PROJECT_sql_staging_job.length == 0) {
   					commonByteArray_FINAL_PROJECT_sql_staging_job = new byte[1024];
				} else {
   					commonByteArray_FINAL_PROJECT_sql_staging_job = new byte[2 * length];
   				}
			}
			unmarshaller.readFully(commonByteArray_FINAL_PROJECT_sql_staging_job, 0, length);
			strReturn = new String(commonByteArray_FINAL_PROJECT_sql_staging_job, 0, length, utf8Charset);
		}
		return strReturn;
	}

    private void writeString(String str, ObjectOutputStream dos) throws IOException{
		if(str == null) {
            dos.writeInt(-1);
		} else {
            byte[] byteArray = str.getBytes(utf8Charset);
	    	dos.writeInt(byteArray.length);
			dos.write(byteArray);
    	}
    }
    
    private void writeString(String str, org.jboss.marshalling.Marshaller marshaller) throws IOException{
		if(str == null) {
			marshaller.writeInt(-1);
		} else {
            byte[] byteArray = str.getBytes(utf8Charset);
            marshaller.writeInt(byteArray.length);
            marshaller.write(byteArray);
    	}
    }

	private java.util.Date readDate(ObjectInputStream dis) throws IOException{
		java.util.Date dateReturn = null;
        int length = 0;
        length = dis.readByte();
		if (length == -1) {
			dateReturn = null;
		} else {
	    	dateReturn = new Date(dis.readLong());
		}
		return dateReturn;
	}
	
	private java.util.Date readDate(org.jboss.marshalling.Unmarshaller unmarshaller) throws IOException{
		java.util.Date dateReturn = null;
        int length = 0;
        length = unmarshaller.readByte();
		if (length == -1) {
			dateReturn = null;
		} else {
	    	dateReturn = new Date(unmarshaller.readLong());
		}
		return dateReturn;
	}

    private void writeDate(java.util.Date date1, ObjectOutputStream dos) throws IOException{
		if(date1 == null) {
            dos.writeByte(-1);
		} else {
			dos.writeByte(0);
	    	dos.writeLong(date1.getTime());
    	}
    }
    
    private void writeDate(java.util.Date date1, org.jboss.marshalling.Marshaller marshaller) throws IOException{
		if(date1 == null) {
			marshaller.writeByte(-1);
		} else {
			marshaller.writeByte(0);
			marshaller.writeLong(date1.getTime());
    	}
    }

    public void readData(ObjectInputStream dis) {

		synchronized(commonByteArrayLock_FINAL_PROJECT_sql_staging_job) {

        	try {

        		int length = 0;
		
					this.tconst = readString(dis);
					
					this.directors = readString(dis);
					
					this.writers = readString(dis);
					
					this.DI_Create_DT = readDate(dis);
					
        	} catch (IOException e) {
	            throw new RuntimeException(e);

		

        }

		

      }


    }
    
    public void readData(org.jboss.marshalling.Unmarshaller dis) {

		synchronized(commonByteArrayLock_FINAL_PROJECT_sql_staging_job) {

        	try {

        		int length = 0;
		
					this.tconst = readString(dis);
					
					this.directors = readString(dis);
					
					this.writers = readString(dis);
					
					this.DI_Create_DT = readDate(dis);
					
        	} catch (IOException e) {
	            throw new RuntimeException(e);

		

        }

		

      }


    }

    public void writeData(ObjectOutputStream dos) {
        try {

		
					// String
				
						writeString(this.tconst,dos);
					
					// String
				
						writeString(this.directors,dos);
					
					// String
				
						writeString(this.writers,dos);
					
					// java.util.Date
				
						writeDate(this.DI_Create_DT,dos);
					
        	} catch (IOException e) {
	            throw new RuntimeException(e);
        }


    }
    
    public void writeData(org.jboss.marshalling.Marshaller dos) {
        try {

		
					// String
				
						writeString(this.tconst,dos);
					
					// String
				
						writeString(this.directors,dos);
					
					// String
				
						writeString(this.writers,dos);
					
					// java.util.Date
				
						writeDate(this.DI_Create_DT,dos);
					
        	} catch (IOException e) {
	            throw new RuntimeException(e);
        }


    }


    public String toString() {

		StringBuilder sb = new StringBuilder();
		sb.append(super.toString());
		sb.append("[");
		sb.append("tconst="+tconst);
		sb.append(",directors="+directors);
		sb.append(",writers="+writers);
		sb.append(",DI_Create_DT="+String.valueOf(DI_Create_DT));
	    sb.append("]");

	    return sb.toString();
    }
        public String toLogString(){
        	StringBuilder sb = new StringBuilder();
        	
        				if(tconst == null){
        					sb.append("<null>");
        				}else{
            				sb.append(tconst);
            			}
            		
        			sb.append("|");
        		
        				if(directors == null){
        					sb.append("<null>");
        				}else{
            				sb.append(directors);
            			}
            		
        			sb.append("|");
        		
        				if(writers == null){
        					sb.append("<null>");
        				}else{
            				sb.append(writers);
            			}
            		
        			sb.append("|");
        		
        				if(DI_Create_DT == null){
        					sb.append("<null>");
        				}else{
            				sb.append(DI_Create_DT);
            			}
            		
        			sb.append("|");
        		
        	return sb.toString();
        }

    /**
     * Compare keys
     */
    public int compareTo(row4Struct other) {

		int returnValue = -1;
		
	    return returnValue;
    }


    private int checkNullsAndCompare(Object object1, Object object2) {
        int returnValue = 0;
		if (object1 instanceof Comparable && object2 instanceof Comparable) {
            returnValue = ((Comparable) object1).compareTo(object2);
        } else if (object1 != null && object2 != null) {
            returnValue = compareStrings(object1.toString(), object2.toString());
        } else if (object1 == null && object2 != null) {
            returnValue = 1;
        } else if (object1 != null && object2 == null) {
            returnValue = -1;
        } else {
            returnValue = 0;
        }

        return returnValue;
    }

    private int compareStrings(String string1, String string2) {
        return string1.compareTo(string2);
    }


}

public void tDBInput_4Process(final java.util.Map<String, Object> globalMap) throws TalendException {
	globalMap.put("tDBInput_4_SUBPROCESS_STATE", 0);

 final boolean execStat = this.execStat;
	
		mdcInfo.forEach(org.slf4j.MDC::put);
		org.slf4j.MDC.put("_subJobName", "tDBInput_4");
		org.slf4j.MDC.put("_subJobPid", "MBxuGJ_" + subJobPidCounter.getAndIncrement());
	

	
		String iterateId = "";
	
	
	String currentComponent = "";
	String cLabel =  null;
	java.util.Map<String, Object> resourceMap = new java.util.HashMap<String, Object>();

	try {
			// TDI-39566 avoid throwing an useless Exception
			boolean resumeIt = true;
			if (globalResumeTicket == false && resumeEntryMethodName != null) {
				String currentMethodName = new java.lang.Exception().getStackTrace()[0].getMethodName();
				resumeIt = resumeEntryMethodName.equals(currentMethodName);
			}
			if (resumeIt || globalResumeTicket) { //start the resume
				globalResumeTicket = true;



		row4Struct row4 = new row4Struct();
copyOftoTable_1Struct copyOftoTable_1 = new copyOftoTable_1Struct();





	
	/**
	 * [tDBOutput_4 begin ] start
	 */

	

	
		
		ok_Hash.put("tDBOutput_4", false);
		start_Hash.put("tDBOutput_4", System.currentTimeMillis());
		
	
	currentComponent="tDBOutput_4";
	
	
			cLabel="stg_crew_dir";
		
			runStat.updateStatAndLog(execStat,enableLogStash,resourceMap,iterateId,0,0,"copyOftoTable_1");
			
		int tos_count_tDBOutput_4 = 0;
		
                if(log.isDebugEnabled())
            log.debug("tDBOutput_4 - "  + ("Start to work.") );
            if (log.isDebugEnabled()) {
                class BytesLimit65535_tDBOutput_4{
                    public void limitLog4jByte() throws Exception{
                    StringBuilder log4jParamters_tDBOutput_4 = new StringBuilder();
                    log4jParamters_tDBOutput_4.append("Parameters:");
                            log4jParamters_tDBOutput_4.append("DB_VERSION" + " = " + "MYSQL_8");
                        log4jParamters_tDBOutput_4.append(" | ");
                            log4jParamters_tDBOutput_4.append("USE_EXISTING_CONNECTION" + " = " + "false");
                        log4jParamters_tDBOutput_4.append(" | ");
                            log4jParamters_tDBOutput_4.append("HOST" + " = " + "context.MySqlLocal_Server");
                        log4jParamters_tDBOutput_4.append(" | ");
                            log4jParamters_tDBOutput_4.append("PORT" + " = " + "context.MySqlLocal_Port");
                        log4jParamters_tDBOutput_4.append(" | ");
                            log4jParamters_tDBOutput_4.append("DBNAME" + " = " + "context.MySqlLocal_Database");
                        log4jParamters_tDBOutput_4.append(" | ");
                            log4jParamters_tDBOutput_4.append("USER" + " = " + "context.MySqlLocal_Login");
                        log4jParamters_tDBOutput_4.append(" | ");
                            log4jParamters_tDBOutput_4.append("PASS" + " = " + String.valueOf(routines.system.PasswordEncryptUtil.encryptPassword(context.MySqlLocal_Password)).substring(0, 4) + "...");     
                        log4jParamters_tDBOutput_4.append(" | ");
                            log4jParamters_tDBOutput_4.append("TABLE" + " = " + "\"stg_crew_dir\"");
                        log4jParamters_tDBOutput_4.append(" | ");
                            log4jParamters_tDBOutput_4.append("TABLE_ACTION" + " = " + "CREATE_IF_NOT_EXISTS");
                        log4jParamters_tDBOutput_4.append(" | ");
                            log4jParamters_tDBOutput_4.append("DATA_ACTION" + " = " + "INSERT");
                        log4jParamters_tDBOutput_4.append(" | ");
                            log4jParamters_tDBOutput_4.append("SPECIFY_DATASOURCE_ALIAS" + " = " + "false");
                        log4jParamters_tDBOutput_4.append(" | ");
                            log4jParamters_tDBOutput_4.append("DIE_ON_ERROR" + " = " + "false");
                        log4jParamters_tDBOutput_4.append(" | ");
                            log4jParamters_tDBOutput_4.append("PROPERTIES" + " = " + "context.MySqlLocal_AdditionalParams");
                        log4jParamters_tDBOutput_4.append(" | ");
                            log4jParamters_tDBOutput_4.append("EXTENDINSERT" + " = " + "true");
                        log4jParamters_tDBOutput_4.append(" | ");
                            log4jParamters_tDBOutput_4.append("NB_ROWS_PER_INSERT" + " = " + "100");
                        log4jParamters_tDBOutput_4.append(" | ");
                            log4jParamters_tDBOutput_4.append("COMMIT_EVERY" + " = " + "10000");
                        log4jParamters_tDBOutput_4.append(" | ");
                            log4jParamters_tDBOutput_4.append("ADD_COLS" + " = " + "[]");
                        log4jParamters_tDBOutput_4.append(" | ");
                            log4jParamters_tDBOutput_4.append("USE_FIELD_OPTIONS" + " = " + "false");
                        log4jParamters_tDBOutput_4.append(" | ");
                            log4jParamters_tDBOutput_4.append("USE_HINT_OPTIONS" + " = " + "false");
                        log4jParamters_tDBOutput_4.append(" | ");
                            log4jParamters_tDBOutput_4.append("ENABLE_DEBUG_MODE" + " = " + "false");
                        log4jParamters_tDBOutput_4.append(" | ");
                            log4jParamters_tDBOutput_4.append("ON_DUPLICATE_KEY_UPDATE" + " = " + "false");
                        log4jParamters_tDBOutput_4.append(" | ");
                            log4jParamters_tDBOutput_4.append("UNIFIED_COMPONENTS" + " = " + "tMysqlOutput");
                        log4jParamters_tDBOutput_4.append(" | ");
                if(log.isDebugEnabled())
            log.debug("tDBOutput_4 - "  + (log4jParamters_tDBOutput_4) );
                    } 
                } 
            new BytesLimit65535_tDBOutput_4().limitLog4jByte();
            }
			if(enableLogStash) {
				talendJobLog.addCM("tDBOutput_4", "stg_crew_dir", "tMysqlOutput");
				talendJobLogProcess(globalMap);
			}
			







int nb_line_tDBOutput_4 = 0;
int nb_line_update_tDBOutput_4 = 0;
int nb_line_inserted_tDBOutput_4 = 0;
int nb_line_deleted_tDBOutput_4 = 0;
int nb_line_rejected_tDBOutput_4 = 0;

int deletedCount_tDBOutput_4=0;
int updatedCount_tDBOutput_4=0;
int insertedCount_tDBOutput_4=0;
int rowsToCommitCount_tDBOutput_4=0;
int rejectedCount_tDBOutput_4=0;

String tableName_tDBOutput_4 = "stg_crew_dir";
boolean whetherReject_tDBOutput_4 = false;

java.util.Calendar calendar_tDBOutput_4 = java.util.Calendar.getInstance();
calendar_tDBOutput_4.set(1, 0, 1, 0, 0, 0);
long year1_tDBOutput_4 = calendar_tDBOutput_4.getTime().getTime();
calendar_tDBOutput_4.set(10000, 0, 1, 0, 0, 0);
long year10000_tDBOutput_4 = calendar_tDBOutput_4.getTime().getTime();
long date_tDBOutput_4;

java.sql.Connection conn_tDBOutput_4 = null;
		
			
        String properties_tDBOutput_4 = context.MySqlLocal_AdditionalParams;
        if (properties_tDBOutput_4 == null || properties_tDBOutput_4.trim().length() == 0) {
            properties_tDBOutput_4 = "rewriteBatchedStatements=true&allowLoadLocalInfile=true";
        }else {
            if (!properties_tDBOutput_4.contains("rewriteBatchedStatements=")) {
                properties_tDBOutput_4 += "&rewriteBatchedStatements=true";
            }

            if (!properties_tDBOutput_4.contains("allowLoadLocalInfile=")) {
                properties_tDBOutput_4 += "&allowLoadLocalInfile=true";
            }
        }

        String url_tDBOutput_4 = "jdbc:mysql://" + context.MySqlLocal_Server + ":" + context.MySqlLocal_Port + "/" + context.MySqlLocal_Database + "?" + properties_tDBOutput_4;

			String driverClass_tDBOutput_4 = "com.mysql.cj.jdbc.Driver";
			
                if(log.isDebugEnabled())
            log.debug("tDBOutput_4 - "  + ("Driver ClassName: ")  + (driverClass_tDBOutput_4)  + (".") );
			String dbUser_tDBOutput_4 = context.MySqlLocal_Login;
			

			
	final String decryptedPassword_tDBOutput_4 = context.MySqlLocal_Password; 

			String dbPwd_tDBOutput_4 = decryptedPassword_tDBOutput_4;
			java.lang.Class.forName(driverClass_tDBOutput_4);
			
                if(log.isDebugEnabled())
            log.debug("tDBOutput_4 - "  + ("Connection attempts to '")  + (url_tDBOutput_4)  + ("' with the username '")  + (dbUser_tDBOutput_4)  + ("'.") );
			conn_tDBOutput_4 = java.sql.DriverManager.getConnection(url_tDBOutput_4, dbUser_tDBOutput_4, dbPwd_tDBOutput_4);
			
                if(log.isDebugEnabled())
            log.debug("tDBOutput_4 - "  + ("Connection to '")  + (url_tDBOutput_4)  + ("' has succeeded.") );
			
	resourceMap.put("conn_tDBOutput_4", conn_tDBOutput_4);
	
			conn_tDBOutput_4.setAutoCommit(false);
			int commitEvery_tDBOutput_4 = 10000;
			int commitCounter_tDBOutput_4 = 0;
			
                if(log.isDebugEnabled())
            log.debug("tDBOutput_4 - "  + ("Connection is set auto commit to '")  + (conn_tDBOutput_4.getAutoCommit())  + ("'.") );

		int count_tDBOutput_4=0;
		
				
                                java.sql.DatabaseMetaData dbMetaData_tDBOutput_4 = conn_tDBOutput_4.getMetaData();
                                    java.sql.ResultSet rsTable_tDBOutput_4 = dbMetaData_tDBOutput_4.getTables(context.MySqlLocal_Database, null, null, new String[]{"TABLE"});
                                boolean whetherExist_tDBOutput_4 = false;
                                while(rsTable_tDBOutput_4.next()) {
                                    String table_tDBOutput_4 = rsTable_tDBOutput_4.getString("TABLE_NAME");
                                    if(table_tDBOutput_4.equalsIgnoreCase("stg_crew_dir")) {
                                        whetherExist_tDBOutput_4 = true;
                                        break;
                                    }
                                }
                                if(!whetherExist_tDBOutput_4) {
                                    try (java.sql.Statement stmtCreate_tDBOutput_4 = conn_tDBOutput_4.createStatement()) {
                if(log.isDebugEnabled())
            log.debug("tDBOutput_4 - "  + ("Creating")  + (" table '")  + (tableName_tDBOutput_4)  + ("'.") );
                                        stmtCreate_tDBOutput_4.execute("CREATE TABLE `" + tableName_tDBOutput_4 + "`(`tconst` VARCHAR(10)   not null ,`directors` VARCHAR(4000)  ,`writers` VARCHAR(4000)  ,`DI_Create_DT` DATETIME  not null ,`DI_WorkflowJobId` VARCHAR(8)  )");
                if(log.isDebugEnabled())
            log.debug("tDBOutput_4 - "  + ("Create")  + (" table '")  + (tableName_tDBOutput_4)  + ("' has succeeded.") );
                                    }
                                }
			

		
						String insert_tDBOutput_4 = "INSERT INTO `" + "stg_crew_dir" + "` (`tconst`,`directors`,`writers`,`DI_Create_DT`,`DI_WorkflowJobId`) VALUES (?,?,?,?,?)";
		
						int batchSize_tDBOutput_4 = 100;
						int batchSizeCounter_tDBOutput_4=0;
						    
						java.sql.PreparedStatement pstmt_tDBOutput_4 = conn_tDBOutput_4.prepareStatement(insert_tDBOutput_4);
						resourceMap.put("pstmt_tDBOutput_4", pstmt_tDBOutput_4);

		


 



/**
 * [tDBOutput_4 begin ] stop
 */



	
	/**
	 * [tMap_4 begin ] start
	 */

	

	
		
		ok_Hash.put("tMap_4", false);
		start_Hash.put("tMap_4", System.currentTimeMillis());
		
	
	currentComponent="tMap_4";
	
	
			runStat.updateStatAndLog(execStat,enableLogStash,resourceMap,iterateId,0,0,"row4");
			
		int tos_count_tMap_4 = 0;
		
                if(log.isDebugEnabled())
            log.debug("tMap_4 - "  + ("Start to work.") );
            if (log.isDebugEnabled()) {
                class BytesLimit65535_tMap_4{
                    public void limitLog4jByte() throws Exception{
                    StringBuilder log4jParamters_tMap_4 = new StringBuilder();
                    log4jParamters_tMap_4.append("Parameters:");
                            log4jParamters_tMap_4.append("LINK_STYLE" + " = " + "AUTO");
                        log4jParamters_tMap_4.append(" | ");
                            log4jParamters_tMap_4.append("TEMPORARY_DATA_DIRECTORY" + " = " + "");
                        log4jParamters_tMap_4.append(" | ");
                            log4jParamters_tMap_4.append("ROWS_BUFFER_SIZE" + " = " + "2000000");
                        log4jParamters_tMap_4.append(" | ");
                            log4jParamters_tMap_4.append("CHANGE_HASH_AND_EQUALS_FOR_BIGDECIMAL" + " = " + "true");
                        log4jParamters_tMap_4.append(" | ");
                if(log.isDebugEnabled())
            log.debug("tMap_4 - "  + (log4jParamters_tMap_4) );
                    } 
                } 
            new BytesLimit65535_tMap_4().limitLog4jByte();
            }
			if(enableLogStash) {
				talendJobLog.addCM("tMap_4", "tMap_4", "tMap");
				talendJobLogProcess(globalMap);
			}
			




// ###############################
// # Lookup's keys initialization
		int count_row4_tMap_4 = 0;
		
// ###############################        

// ###############################
// # Vars initialization
class  Var__tMap_4__Struct  {
}
Var__tMap_4__Struct Var__tMap_4 = new Var__tMap_4__Struct();
// ###############################

// ###############################
// # Outputs initialization
				int count_copyOftoTable_1_tMap_4 = 0;
				
copyOftoTable_1Struct copyOftoTable_1_tmp = new copyOftoTable_1Struct();
// ###############################

        
        



        









 



/**
 * [tMap_4 begin ] stop
 */



	
	/**
	 * [tDBInput_4 begin ] start
	 */

	

	
		
		ok_Hash.put("tDBInput_4", false);
		start_Hash.put("tDBInput_4", System.currentTimeMillis());
		
	
	currentComponent="tDBInput_4";
	
	
			cLabel="imdb_title_crew";
		
		int tos_count_tDBInput_4 = 0;
		
                if(log.isDebugEnabled())
            log.debug("tDBInput_4 - "  + ("Start to work.") );
            if (log.isDebugEnabled()) {
                class BytesLimit65535_tDBInput_4{
                    public void limitLog4jByte() throws Exception{
                    StringBuilder log4jParamters_tDBInput_4 = new StringBuilder();
                    log4jParamters_tDBInput_4.append("Parameters:");
                            log4jParamters_tDBInput_4.append("DB_VERSION" + " = " + "MYSQL_8");
                        log4jParamters_tDBInput_4.append(" | ");
                            log4jParamters_tDBInput_4.append("USE_EXISTING_CONNECTION" + " = " + "false");
                        log4jParamters_tDBInput_4.append(" | ");
                            log4jParamters_tDBInput_4.append("HOST" + " = " + "context.MySqlLocal_Server");
                        log4jParamters_tDBInput_4.append(" | ");
                            log4jParamters_tDBInput_4.append("PORT" + " = " + "context.MySqlLocal_Port");
                        log4jParamters_tDBInput_4.append(" | ");
                            log4jParamters_tDBInput_4.append("DBNAME" + " = " + "context.MySqlLocal_Database");
                        log4jParamters_tDBInput_4.append(" | ");
                            log4jParamters_tDBInput_4.append("USER" + " = " + "context.MySqlLocal_Login");
                        log4jParamters_tDBInput_4.append(" | ");
                            log4jParamters_tDBInput_4.append("PASS" + " = " + String.valueOf(routines.system.PasswordEncryptUtil.encryptPassword(context.MySqlLocal_Password)).substring(0, 4) + "...");     
                        log4jParamters_tDBInput_4.append(" | ");
                            log4jParamters_tDBInput_4.append("TABLE" + " = " + "\"imdb_title_crew\"");
                        log4jParamters_tDBInput_4.append(" | ");
                            log4jParamters_tDBInput_4.append("QUERYSTORE" + " = " + "\"\"");
                        log4jParamters_tDBInput_4.append(" | ");
                            log4jParamters_tDBInput_4.append("QUERY" + " = " + "\"SELECT * FROM imdb_title_crew;\"");
                        log4jParamters_tDBInput_4.append(" | ");
                            log4jParamters_tDBInput_4.append("SPECIFY_DATASOURCE_ALIAS" + " = " + "false");
                        log4jParamters_tDBInput_4.append(" | ");
                            log4jParamters_tDBInput_4.append("PROPERTIES" + " = " + "context.MySqlLocal_AdditionalParams");
                        log4jParamters_tDBInput_4.append(" | ");
                            log4jParamters_tDBInput_4.append("ENABLE_STREAM" + " = " + "false");
                        log4jParamters_tDBInput_4.append(" | ");
                            log4jParamters_tDBInput_4.append("TRIM_ALL_COLUMN" + " = " + "false");
                        log4jParamters_tDBInput_4.append(" | ");
                            log4jParamters_tDBInput_4.append("TRIM_COLUMN" + " = " + "[{TRIM="+("false")+", SCHEMA_COLUMN="+("tconst")+"}, {TRIM="+("false")+", SCHEMA_COLUMN="+("directors")+"}, {TRIM="+("false")+", SCHEMA_COLUMN="+("writers")+"}, {TRIM="+("false")+", SCHEMA_COLUMN="+("DI_Create_DT")+"}]");
                        log4jParamters_tDBInput_4.append(" | ");
                            log4jParamters_tDBInput_4.append("UNIFIED_COMPONENTS" + " = " + "tMysqlInput");
                        log4jParamters_tDBInput_4.append(" | ");
                if(log.isDebugEnabled())
            log.debug("tDBInput_4 - "  + (log4jParamters_tDBInput_4) );
                    } 
                } 
            new BytesLimit65535_tDBInput_4().limitLog4jByte();
            }
			if(enableLogStash) {
				talendJobLog.addCM("tDBInput_4", "imdb_title_crew", "tMysqlInput");
				talendJobLogProcess(globalMap);
			}
			
	
	
		    java.util.Calendar calendar_tDBInput_4 = java.util.Calendar.getInstance();
		    calendar_tDBInput_4.set(0, 0, 0, 0, 0, 0);
		    java.util.Date year0_tDBInput_4 = calendar_tDBInput_4.getTime();
		    int nb_line_tDBInput_4 = 0;
		    java.sql.Connection conn_tDBInput_4 = null;
				String driverClass_tDBInput_4 = "com.mysql.cj.jdbc.Driver";
			    java.lang.Class jdbcclazz_tDBInput_4 = java.lang.Class.forName(driverClass_tDBInput_4);
				String dbUser_tDBInput_4 = context.MySqlLocal_Login;
				
				
	final String decryptedPassword_tDBInput_4 = context.MySqlLocal_Password; 
				
				String dbPwd_tDBInput_4 = decryptedPassword_tDBInput_4;
				
        String properties_tDBInput_4 = context.MySqlLocal_AdditionalParams;
        if (properties_tDBInput_4 == null || properties_tDBInput_4.trim().length() == 0) {
            properties_tDBInput_4 = "";
        }
        String url_tDBInput_4 = "jdbc:mysql://" + context.MySqlLocal_Server + ":" + context.MySqlLocal_Port + "/" + context.MySqlLocal_Database + "?" + properties_tDBInput_4;
				
	    		log.debug("tDBInput_4 - Driver ClassName: "+driverClass_tDBInput_4+".");
			
	    		log.debug("tDBInput_4 - Connection attempt to '" + url_tDBInput_4 + "' with the username '" + dbUser_tDBInput_4 + "'.");
			
				conn_tDBInput_4 = java.sql.DriverManager.getConnection(url_tDBInput_4,dbUser_tDBInput_4,dbPwd_tDBInput_4);
	    		log.debug("tDBInput_4 - Connection to '" + url_tDBInput_4 + "' has succeeded.");
			
		        
		    
			java.sql.Statement stmt_tDBInput_4 = conn_tDBInput_4.createStatement();

		    String dbquery_tDBInput_4 = "SELECT * FROM imdb_title_crew;";
		    
	    		log.debug("tDBInput_4 - Executing the query: '" + dbquery_tDBInput_4 + "'.");
			

		    globalMap.put("tDBInput_4_QUERY",dbquery_tDBInput_4);

		    java.sql.ResultSet rs_tDBInput_4 = null;

		    try {
		    	rs_tDBInput_4 = stmt_tDBInput_4.executeQuery(dbquery_tDBInput_4);
		    	java.sql.ResultSetMetaData rsmd_tDBInput_4 = rs_tDBInput_4.getMetaData();
		    	int colQtyInRs_tDBInput_4 = rsmd_tDBInput_4.getColumnCount();

		    String tmpContent_tDBInput_4 = null;
		    
		    
		    	log.debug("tDBInput_4 - Retrieving records from the database.");
		    
		    while (rs_tDBInput_4.next()) {
		        nb_line_tDBInput_4++;
		        
							if(colQtyInRs_tDBInput_4 < 1) {
								row4.tconst = null;
							} else {
	                         		
        	row4.tconst = routines.system.JDBCUtil.getString(rs_tDBInput_4, 1, false);
		                    }
							if(colQtyInRs_tDBInput_4 < 2) {
								row4.directors = null;
							} else {
	                         		
        	row4.directors = routines.system.JDBCUtil.getString(rs_tDBInput_4, 2, false);
		                    }
							if(colQtyInRs_tDBInput_4 < 3) {
								row4.writers = null;
							} else {
	                         		
        	row4.writers = routines.system.JDBCUtil.getString(rs_tDBInput_4, 3, false);
		                    }
							if(colQtyInRs_tDBInput_4 < 4) {
								row4.DI_Create_DT = null;
							} else {
										
				if(rs_tDBInput_4.getString(4) != null) {
					String dateString_tDBInput_4 = rs_tDBInput_4.getString(4);
					if (!("0000-00-00").equals(dateString_tDBInput_4) && !("0000-00-00 00:00:00").equals(dateString_tDBInput_4)) {
						row4.DI_Create_DT = rs_tDBInput_4.getTimestamp(4);
					} else {
						row4.DI_Create_DT = (java.util.Date) year0_tDBInput_4.clone();
					}
				} else {
					row4.DI_Create_DT =  null;
				}
		                    }
					
						log.debug("tDBInput_4 - Retrieving the record " + nb_line_tDBInput_4 + ".");
					

 



/**
 * [tDBInput_4 begin ] stop
 */
	
	/**
	 * [tDBInput_4 main ] start
	 */

	

	
	
	currentComponent="tDBInput_4";
	
	
			cLabel="imdb_title_crew";
		

 


	tos_count_tDBInput_4++;

/**
 * [tDBInput_4 main ] stop
 */
	
	/**
	 * [tDBInput_4 process_data_begin ] start
	 */

	

	
	
	currentComponent="tDBInput_4";
	
	
			cLabel="imdb_title_crew";
		

 



/**
 * [tDBInput_4 process_data_begin ] stop
 */

	
	/**
	 * [tMap_4 main ] start
	 */

	

	
	
	currentComponent="tMap_4";
	
	
			if(runStat.update(execStat,enableLogStash,iterateId,1,1
				
					,"row4","tDBInput_4","imdb_title_crew","tMysqlInput","tMap_4","tMap_4","tMap"
				
			)) {
				talendJobLogProcess(globalMap);
			}
			
    			if(log.isTraceEnabled()){
    				log.trace("row4 - " + (row4==null? "": row4.toLogString()));
    			}
    		

		
		
		boolean hasCasePrimitiveKeyWithNull_tMap_4 = false;
		
		// ###############################
		// # Input tables (lookups)
		
		boolean rejectedInnerJoin_tMap_4 = false;
		boolean mainRowRejected_tMap_4 = false;
		// ###############################
        { // start of Var scope
        
	        // ###############################
        	// # Vars tables
        
Var__tMap_4__Struct Var = Var__tMap_4;// ###############################
        // ###############################
        // # Output tables

copyOftoTable_1 = null;


// # Output table : 'copyOftoTable_1'
count_copyOftoTable_1_tMap_4++;

copyOftoTable_1_tmp.tconst = row4.tconst;
copyOftoTable_1_tmp.directors = row4.directors;
copyOftoTable_1_tmp.writers = row4.writers;
copyOftoTable_1_tmp.DI_Create_DT = TalendDate.getCurrentDate();
copyOftoTable_1_tmp.DI_WorkflowJobId = pid;
copyOftoTable_1 = copyOftoTable_1_tmp;
log.debug("tMap_4 - Outputting the record " + count_copyOftoTable_1_tMap_4 + " of the output table 'copyOftoTable_1'.");

// ###############################

} // end of Var scope

rejectedInnerJoin_tMap_4 = false;










 


	tos_count_tMap_4++;

/**
 * [tMap_4 main ] stop
 */
	
	/**
	 * [tMap_4 process_data_begin ] start
	 */

	

	
	
	currentComponent="tMap_4";
	
	

 



/**
 * [tMap_4 process_data_begin ] stop
 */
// Start of branch "copyOftoTable_1"
if(copyOftoTable_1 != null) { 



	
	/**
	 * [tDBOutput_4 main ] start
	 */

	

	
	
	currentComponent="tDBOutput_4";
	
	
			cLabel="stg_crew_dir";
		
			if(runStat.update(execStat,enableLogStash,iterateId,1,1
				
					,"copyOftoTable_1","tMap_4","tMap_4","tMap","tDBOutput_4","stg_crew_dir","tMysqlOutput"
				
			)) {
				talendJobLogProcess(globalMap);
			}
			
    			if(log.isTraceEnabled()){
    				log.trace("copyOftoTable_1 - " + (copyOftoTable_1==null? "": copyOftoTable_1.toLogString()));
    			}
    		



        whetherReject_tDBOutput_4 = false;
                            if(copyOftoTable_1.tconst == null) {
pstmt_tDBOutput_4.setNull(1, java.sql.Types.VARCHAR);
} else {pstmt_tDBOutput_4.setString(1, copyOftoTable_1.tconst);
}

                            if(copyOftoTable_1.directors == null) {
pstmt_tDBOutput_4.setNull(2, java.sql.Types.VARCHAR);
} else {pstmt_tDBOutput_4.setString(2, copyOftoTable_1.directors);
}

                            if(copyOftoTable_1.writers == null) {
pstmt_tDBOutput_4.setNull(3, java.sql.Types.VARCHAR);
} else {pstmt_tDBOutput_4.setString(3, copyOftoTable_1.writers);
}

                            if(copyOftoTable_1.DI_Create_DT != null) {
date_tDBOutput_4 = copyOftoTable_1.DI_Create_DT.getTime();
if(date_tDBOutput_4 < year1_tDBOutput_4 || date_tDBOutput_4 >= year10000_tDBOutput_4) {
pstmt_tDBOutput_4.setString(4, "0000-00-00 00:00:00");
} else {pstmt_tDBOutput_4.setTimestamp(4, new java.sql.Timestamp(date_tDBOutput_4));
}
} else {
pstmt_tDBOutput_4.setNull(4, java.sql.Types.DATE);
}

                            if(copyOftoTable_1.DI_WorkflowJobId == null) {
pstmt_tDBOutput_4.setNull(5, java.sql.Types.VARCHAR);
} else {pstmt_tDBOutput_4.setString(5, copyOftoTable_1.DI_WorkflowJobId);
}

                    pstmt_tDBOutput_4.addBatch();
                    nb_line_tDBOutput_4++;

                if(log.isDebugEnabled())
            log.debug("tDBOutput_4 - "  + ("Adding the record ")  + (nb_line_tDBOutput_4)  + (" to the ")  + ("INSERT")  + (" batch.") );
                      batchSizeCounter_tDBOutput_4++;
                if ( batchSize_tDBOutput_4 <= batchSizeCounter_tDBOutput_4) {
                try {
                        int countSum_tDBOutput_4 = 0;
                if(log.isDebugEnabled())
            log.debug("tDBOutput_4 - "  + ("Executing the ")  + ("INSERT")  + (" batch.") );
                        for(int countEach_tDBOutput_4: pstmt_tDBOutput_4.executeBatch()) {
                            countSum_tDBOutput_4 += (countEach_tDBOutput_4 == java.sql.Statement.EXECUTE_FAILED ? 0 : 1);
                        }
                        rowsToCommitCount_tDBOutput_4 += countSum_tDBOutput_4;
                if(log.isDebugEnabled())
            log.debug("tDBOutput_4 - "  + ("The ")  + ("INSERT")  + (" batch execution has succeeded.") );
                        insertedCount_tDBOutput_4 += countSum_tDBOutput_4;
                }catch (java.sql.BatchUpdateException e){
                    globalMap.put("tDBOutput_4_ERROR_MESSAGE",e.getMessage());
                    int countSum_tDBOutput_4 = 0;
                    for(int countEach_tDBOutput_4: e.getUpdateCounts()) {
                        countSum_tDBOutput_4 += (countEach_tDBOutput_4 < 0 ? 0 : countEach_tDBOutput_4);
                    }
                    rowsToCommitCount_tDBOutput_4 += countSum_tDBOutput_4;
                    insertedCount_tDBOutput_4 += countSum_tDBOutput_4;
                    System.err.println(e.getMessage());
            log.error("tDBOutput_4 - "  + (e.getMessage()) );
                }

                batchSizeCounter_tDBOutput_4 = 0;
            }
                commitCounter_tDBOutput_4++;

                if(commitEvery_tDBOutput_4 <= commitCounter_tDBOutput_4) {

                        try {
                                int countSum_tDBOutput_4 = 0;
                if(log.isDebugEnabled())
            log.debug("tDBOutput_4 - "  + ("Executing the ")  + ("INSERT")  + (" batch.") );
                                for(int countEach_tDBOutput_4: pstmt_tDBOutput_4.executeBatch()) {
                                    countSum_tDBOutput_4 += (countEach_tDBOutput_4 < 0 ? 0 : 1);
                                }
                                rowsToCommitCount_tDBOutput_4 += countSum_tDBOutput_4;
                if(log.isDebugEnabled())
            log.debug("tDBOutput_4 - "  + ("The ")  + ("INSERT")  + (" batch execution has succeeded.") );
                                insertedCount_tDBOutput_4 += countSum_tDBOutput_4;
                        }catch (java.sql.BatchUpdateException e){
                            globalMap.put("tDBOutput_4_ERROR_MESSAGE",e.getMessage());
                            int countSum_tDBOutput_4 = 0;
                            for(int countEach_tDBOutput_4: e.getUpdateCounts()) {
                                countSum_tDBOutput_4 += (countEach_tDBOutput_4 < 0 ? 0 : countEach_tDBOutput_4);
                            }
                            rowsToCommitCount_tDBOutput_4 += countSum_tDBOutput_4;
                            insertedCount_tDBOutput_4 += countSum_tDBOutput_4;
                            System.err.println(e.getMessage());
            log.error("tDBOutput_4 - "  + (e.getMessage()) );

                        }
                    if(rowsToCommitCount_tDBOutput_4 != 0){
                if(log.isDebugEnabled())
            log.debug("tDBOutput_4 - "  + ("Connection starting to commit ")  + (rowsToCommitCount_tDBOutput_4)  + (" record(s).") );
                    }
                    conn_tDBOutput_4.commit();
                    if(rowsToCommitCount_tDBOutput_4 != 0){
                if(log.isDebugEnabled())
            log.debug("tDBOutput_4 - "  + ("Connection commit has succeeded.") );
                        rowsToCommitCount_tDBOutput_4 = 0;
                    }
                    commitCounter_tDBOutput_4=0;
                }

 


	tos_count_tDBOutput_4++;

/**
 * [tDBOutput_4 main ] stop
 */
	
	/**
	 * [tDBOutput_4 process_data_begin ] start
	 */

	

	
	
	currentComponent="tDBOutput_4";
	
	
			cLabel="stg_crew_dir";
		

 



/**
 * [tDBOutput_4 process_data_begin ] stop
 */
	
	/**
	 * [tDBOutput_4 process_data_end ] start
	 */

	

	
	
	currentComponent="tDBOutput_4";
	
	
			cLabel="stg_crew_dir";
		

 



/**
 * [tDBOutput_4 process_data_end ] stop
 */

} // End of branch "copyOftoTable_1"




	
	/**
	 * [tMap_4 process_data_end ] start
	 */

	

	
	
	currentComponent="tMap_4";
	
	

 



/**
 * [tMap_4 process_data_end ] stop
 */



	
	/**
	 * [tDBInput_4 process_data_end ] start
	 */

	

	
	
	currentComponent="tDBInput_4";
	
	
			cLabel="imdb_title_crew";
		

 



/**
 * [tDBInput_4 process_data_end ] stop
 */
	
	/**
	 * [tDBInput_4 end ] start
	 */

	

	
	
	currentComponent="tDBInput_4";
	
	
			cLabel="imdb_title_crew";
		

	}
}finally{
	if (rs_tDBInput_4 != null) {
		rs_tDBInput_4.close();
	}
	if (stmt_tDBInput_4 != null) {
		stmt_tDBInput_4.close();
	}
		if(conn_tDBInput_4 != null && !conn_tDBInput_4.isClosed()) {
			
	    		log.debug("tDBInput_4 - Closing the connection to the database.");
			
			conn_tDBInput_4.close();
			
			if("com.mysql.cj.jdbc.Driver".equals((String)globalMap.get("driverClass_"))
			    && routines.system.BundleUtils.inOSGi()) {
			        Class.forName("com.mysql.cj.jdbc.AbandonedConnectionCleanupThread").
			            getMethod("checkedShutdown").invoke(null, (Object[]) null);
			}
			
	    		log.debug("tDBInput_4 - Connection to the database closed.");
			
		}
		
}
globalMap.put("tDBInput_4_NB_LINE",nb_line_tDBInput_4);
	    		log.debug("tDBInput_4 - Retrieved records count: "+nb_line_tDBInput_4 + " .");
			

 
                if(log.isDebugEnabled())
            log.debug("tDBInput_4 - "  + ("Done.") );

ok_Hash.put("tDBInput_4", true);
end_Hash.put("tDBInput_4", System.currentTimeMillis());




/**
 * [tDBInput_4 end ] stop
 */

	
	/**
	 * [tMap_4 end ] start
	 */

	

	
	
	currentComponent="tMap_4";
	
	


// ###############################
// # Lookup hashes releasing
// ###############################      
				log.debug("tMap_4 - Written records count in the table 'copyOftoTable_1': " + count_copyOftoTable_1_tMap_4 + ".");





			 		if(runStat.updateStatAndLog(execStat,enableLogStash,resourceMap,iterateId,"row4",2,0,
			 			"tDBInput_4","imdb_title_crew","tMysqlInput","tMap_4","tMap_4","tMap","output")) {
						talendJobLogProcess(globalMap);
					}
				
 
                if(log.isDebugEnabled())
            log.debug("tMap_4 - "  + ("Done.") );

ok_Hash.put("tMap_4", true);
end_Hash.put("tMap_4", System.currentTimeMillis());




/**
 * [tMap_4 end ] stop
 */

	
	/**
	 * [tDBOutput_4 end ] start
	 */

	

	
	
	currentComponent="tDBOutput_4";
	
	
			cLabel="stg_crew_dir";
		



				
					try {
						if (batchSizeCounter_tDBOutput_4 != 0) {
							int countSum_tDBOutput_4 = 0;
							
                if(log.isDebugEnabled())
            log.debug("tDBOutput_4 - "  + ("Executing the ")  + ("INSERT")  + (" batch.") );
							for(int countEach_tDBOutput_4: pstmt_tDBOutput_4.executeBatch()) {
								countSum_tDBOutput_4 += (countEach_tDBOutput_4 == java.sql.Statement.EXECUTE_FAILED ? 0 : 1);
							}
							rowsToCommitCount_tDBOutput_4 += countSum_tDBOutput_4;
							
                if(log.isDebugEnabled())
            log.debug("tDBOutput_4 - "  + ("The ")  + ("INSERT")  + (" batch execution has succeeded.") );
							
								insertedCount_tDBOutput_4 += countSum_tDBOutput_4;
							
						}
					}catch (java.sql.BatchUpdateException e){
						globalMap.put(currentComponent+"_ERROR_MESSAGE",e.getMessage());
						
							int countSum_tDBOutput_4 = 0;
							for(int countEach_tDBOutput_4: e.getUpdateCounts()) {
								countSum_tDBOutput_4 += (countEach_tDBOutput_4 < 0 ? 0 : countEach_tDBOutput_4);
							}
							rowsToCommitCount_tDBOutput_4 += countSum_tDBOutput_4;
							
								insertedCount_tDBOutput_4 += countSum_tDBOutput_4;
								
            log.error("tDBOutput_4 - "  + (e.getMessage()) );
							System.err.println(e.getMessage());
							
					}
					batchSizeCounter_tDBOutput_4 = 0;
					
			
		

		if(pstmt_tDBOutput_4 != null) {
			
				pstmt_tDBOutput_4.close();
				resourceMap.remove("pstmt_tDBOutput_4");
			
		}
		
	resourceMap.put("statementClosed_tDBOutput_4", true);
	
			if (commitCounter_tDBOutput_4 > 0 && rowsToCommitCount_tDBOutput_4 != 0) {
				
                if(log.isDebugEnabled())
            log.debug("tDBOutput_4 - "  + ("Connection starting to commit ")  + (rowsToCommitCount_tDBOutput_4)  + (" record(s).") );
			}
			conn_tDBOutput_4.commit();
			if (commitCounter_tDBOutput_4 > 0 && rowsToCommitCount_tDBOutput_4 != 0) {
				
                if(log.isDebugEnabled())
            log.debug("tDBOutput_4 - "  + ("Connection commit has succeeded.") );
				rowsToCommitCount_tDBOutput_4 = 0;
			}
			commitCounter_tDBOutput_4 = 0;
			
		
                if(log.isDebugEnabled())
            log.debug("tDBOutput_4 - "  + ("Closing the connection to the database.") );
		conn_tDBOutput_4 .close();
		
                if(log.isDebugEnabled())
            log.debug("tDBOutput_4 - "  + ("Connection to the database has closed.") );
		resourceMap.put("finish_tDBOutput_4", true);
	

	nb_line_deleted_tDBOutput_4=nb_line_deleted_tDBOutput_4+ deletedCount_tDBOutput_4;
	nb_line_update_tDBOutput_4=nb_line_update_tDBOutput_4 + updatedCount_tDBOutput_4;
	nb_line_inserted_tDBOutput_4=nb_line_inserted_tDBOutput_4 + insertedCount_tDBOutput_4;
	nb_line_rejected_tDBOutput_4=nb_line_rejected_tDBOutput_4 + rejectedCount_tDBOutput_4;
	
        globalMap.put("tDBOutput_4_NB_LINE",nb_line_tDBOutput_4);
        globalMap.put("tDBOutput_4_NB_LINE_UPDATED",nb_line_update_tDBOutput_4);
        globalMap.put("tDBOutput_4_NB_LINE_INSERTED",nb_line_inserted_tDBOutput_4);
        globalMap.put("tDBOutput_4_NB_LINE_DELETED",nb_line_deleted_tDBOutput_4);
        globalMap.put("tDBOutput_4_NB_LINE_REJECTED", nb_line_rejected_tDBOutput_4);
    

	
                if(log.isDebugEnabled())
            log.debug("tDBOutput_4 - "  + ("Has ")  + ("inserted")  + (" ")  + (nb_line_inserted_tDBOutput_4)  + (" record(s).") );

			 		if(runStat.updateStatAndLog(execStat,enableLogStash,resourceMap,iterateId,"copyOftoTable_1",2,0,
			 			"tMap_4","tMap_4","tMap","tDBOutput_4","stg_crew_dir","tMysqlOutput","output")) {
						talendJobLogProcess(globalMap);
					}
				
 
                if(log.isDebugEnabled())
            log.debug("tDBOutput_4 - "  + ("Done.") );

ok_Hash.put("tDBOutput_4", true);
end_Hash.put("tDBOutput_4", System.currentTimeMillis());




/**
 * [tDBOutput_4 end ] stop
 */






				}//end the resume

				



	
			}catch(java.lang.Exception e){	
				
				    if(!(e instanceof TalendException)){
					   log.fatal(currentComponent + " " + e.getMessage(),e);
					}
				
				TalendException te = new TalendException(e, currentComponent, cLabel, globalMap);
				
				throw te;
			}catch(java.lang.Error error){	
				
					runStat.stopThreadStat();
				
				throw error;
			}finally{
				
				try{
					
	
	/**
	 * [tDBInput_4 finally ] start
	 */

	

	
	
	currentComponent="tDBInput_4";
	
	
			cLabel="imdb_title_crew";
		

 



/**
 * [tDBInput_4 finally ] stop
 */

	
	/**
	 * [tMap_4 finally ] start
	 */

	

	
	
	currentComponent="tMap_4";
	
	

 



/**
 * [tMap_4 finally ] stop
 */

	
	/**
	 * [tDBOutput_4 finally ] start
	 */

	

	
	
	currentComponent="tDBOutput_4";
	
	
			cLabel="stg_crew_dir";
		



    try {
    if (resourceMap.get("statementClosed_tDBOutput_4") == null) {
                java.sql.PreparedStatement pstmtToClose_tDBOutput_4 = null;
                if ((pstmtToClose_tDBOutput_4 = (java.sql.PreparedStatement) resourceMap.remove("pstmt_tDBOutput_4")) != null) {
                    pstmtToClose_tDBOutput_4.close();
                }
    }
    } finally {
        if(resourceMap.get("finish_tDBOutput_4") == null){
            java.sql.Connection ctn_tDBOutput_4 = null;
            if((ctn_tDBOutput_4 = (java.sql.Connection)resourceMap.get("conn_tDBOutput_4")) != null){
                try {
                if(log.isDebugEnabled())
            log.debug("tDBOutput_4 - "  + ("Closing the connection to the database.") );
                    ctn_tDBOutput_4.close();
                if(log.isDebugEnabled())
            log.debug("tDBOutput_4 - "  + ("Connection to the database has closed.") );
                } catch (java.sql.SQLException sqlEx_tDBOutput_4) {
                    String errorMessage_tDBOutput_4 = "failed to close the connection in tDBOutput_4 :" + sqlEx_tDBOutput_4.getMessage();
            log.error("tDBOutput_4 - "  + (errorMessage_tDBOutput_4) );
                    System.err.println(errorMessage_tDBOutput_4);
                }
            }
        }
    }
 



/**
 * [tDBOutput_4 finally ] stop
 */






				}catch(java.lang.Exception e){	
					//ignore
				}catch(java.lang.Error error){
					//ignore
				}
				resourceMap = null;
			}
		

		globalMap.put("tDBInput_4_SUBPROCESS_STATE", 1);
	}
	


public void tPrejob_1Process(final java.util.Map<String, Object> globalMap) throws TalendException {
	globalMap.put("tPrejob_1_SUBPROCESS_STATE", 0);

 final boolean execStat = this.execStat;
	
		mdcInfo.forEach(org.slf4j.MDC::put);
		org.slf4j.MDC.put("_subJobName", "tPrejob_1");
		org.slf4j.MDC.put("_subJobPid", "LnI87v_" + subJobPidCounter.getAndIncrement());
	

	
		String iterateId = "";
	
	
	String currentComponent = "";
	String cLabel =  null;
	java.util.Map<String, Object> resourceMap = new java.util.HashMap<String, Object>();

	try {
			// TDI-39566 avoid throwing an useless Exception
			boolean resumeIt = true;
			if (globalResumeTicket == false && resumeEntryMethodName != null) {
				String currentMethodName = new java.lang.Exception().getStackTrace()[0].getMethodName();
				resumeIt = resumeEntryMethodName.equals(currentMethodName);
			}
			if (resumeIt || globalResumeTicket) { //start the resume
				globalResumeTicket = true;



		


	
	/**
	 * [tPrejob_1 begin ] start
	 */

	

	
		
		ok_Hash.put("tPrejob_1", false);
		start_Hash.put("tPrejob_1", System.currentTimeMillis());
		
	
	currentComponent="tPrejob_1";
	
	
		int tos_count_tPrejob_1 = 0;
		
			if(enableLogStash) {
				talendJobLog.addCM("tPrejob_1", "tPrejob_1", "tPrejob");
				talendJobLogProcess(globalMap);
			}
			

 



/**
 * [tPrejob_1 begin ] stop
 */
	
	/**
	 * [tPrejob_1 main ] start
	 */

	

	
	
	currentComponent="tPrejob_1";
	
	

 


	tos_count_tPrejob_1++;

/**
 * [tPrejob_1 main ] stop
 */
	
	/**
	 * [tPrejob_1 process_data_begin ] start
	 */

	

	
	
	currentComponent="tPrejob_1";
	
	

 



/**
 * [tPrejob_1 process_data_begin ] stop
 */
	
	/**
	 * [tPrejob_1 process_data_end ] start
	 */

	

	
	
	currentComponent="tPrejob_1";
	
	

 



/**
 * [tPrejob_1 process_data_end ] stop
 */
	
	/**
	 * [tPrejob_1 end ] start
	 */

	

	
	
	currentComponent="tPrejob_1";
	
	

 

ok_Hash.put("tPrejob_1", true);
end_Hash.put("tPrejob_1", System.currentTimeMillis());

				if(execStat){   
   	 				runStat.updateStatOnConnection("OnComponentOk1", 0, "ok");
				}
				tRunJob_1Process(globalMap);



/**
 * [tPrejob_1 end ] stop
 */
				}//end the resume

				



	
			}catch(java.lang.Exception e){	
				
				    if(!(e instanceof TalendException)){
					   log.fatal(currentComponent + " " + e.getMessage(),e);
					}
				
				TalendException te = new TalendException(e, currentComponent, cLabel, globalMap);
				
				throw te;
			}catch(java.lang.Error error){	
				
					runStat.stopThreadStat();
				
				throw error;
			}finally{
				
				try{
					
	
	/**
	 * [tPrejob_1 finally ] start
	 */

	

	
	
	currentComponent="tPrejob_1";
	
	

 



/**
 * [tPrejob_1 finally ] stop
 */
				}catch(java.lang.Exception e){	
					//ignore
				}catch(java.lang.Error error){
					//ignore
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
		org.slf4j.MDC.put("_subJobPid", "LxzAVs_" + subJobPidCounter.getAndIncrement());
	

	
		String iterateId = "";
	
	
	String currentComponent = "";
	String cLabel =  null;
	java.util.Map<String, Object> resourceMap = new java.util.HashMap<String, Object>();

	try {
			// TDI-39566 avoid throwing an useless Exception
			boolean resumeIt = true;
			if (globalResumeTicket == false && resumeEntryMethodName != null) {
				String currentMethodName = new java.lang.Exception().getStackTrace()[0].getMethodName();
				resumeIt = resumeEntryMethodName.equals(currentMethodName);
			}
			if (resumeIt || globalResumeTicket) { //start the resume
				globalResumeTicket = true;





	
	/**
	 * [tRunJob_1 begin ] start
	 */

	

	
		
		ok_Hash.put("tRunJob_1", false);
		start_Hash.put("tRunJob_1", System.currentTimeMillis());
		
	
	currentComponent="tRunJob_1";
	
	
		int tos_count_tRunJob_1 = 0;
		
                if(log.isDebugEnabled())
            log.debug("tRunJob_1 - "  + ("Start to work.") );
            if (log.isDebugEnabled()) {
                class BytesLimit65535_tRunJob_1{
                    public void limitLog4jByte() throws Exception{
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
                            log4jParamters_tRunJob_1.append("CONTEXTPARAMS" + " = " + "[{PARAM_NAME_COLUMN="+("job_name")+", PARAM_VALUE_COLUMN="+("context.job_name")+"}, {PARAM_NAME_COLUMN="+("job_status")+", PARAM_VALUE_COLUMN="+("\"Starting\"")+"}]");
                        log4jParamters_tRunJob_1.append(" | ");
                            log4jParamters_tRunJob_1.append("PROPAGATE_CHILD_RESULT" + " = " + "false");
                        log4jParamters_tRunJob_1.append(" | ");
                            log4jParamters_tRunJob_1.append("PRINT_PARAMETER" + " = " + "false");
                        log4jParamters_tRunJob_1.append(" | ");
                            log4jParamters_tRunJob_1.append("USE_DYNAMIC_CONTEXT" + " = " + "false");
                        log4jParamters_tRunJob_1.append(" | ");
                if(log.isDebugEnabled())
            log.debug("tRunJob_1 - "  + (log4jParamters_tRunJob_1) );
                    } 
                } 
            new BytesLimit65535_tRunJob_1().limitLog4jByte();
            }
			if(enableLogStash) {
				talendJobLog.addCM("tRunJob_1", "tRunJob_1", "tRunJob");
				talendJobLogProcess(globalMap);
			}
			


 



/**
 * [tRunJob_1 begin ] stop
 */
	
	/**
	 * [tRunJob_1 main ] start
	 */

	

	
	
	currentComponent="tRunJob_1";
	
	
	java.util.List<String> paraList_tRunJob_1 = new java.util.ArrayList<String>();
	
	        				paraList_tRunJob_1.add("--father_pid="+pid);
	      			
	        				paraList_tRunJob_1.add("--root_pid="+rootPid);
	      			
	        				paraList_tRunJob_1.add("--father_node=tRunJob_1");
	      			
	        				paraList_tRunJob_1.add("--context=Default");
	      			
			if(!"".equals(log4jLevel)){
				paraList_tRunJob_1.add("--log4jLevel="+log4jLevel);
			}
		
		if(enableLogStash){
			paraList_tRunJob_1.add("--audit.enabled="+enableLogStash);
		}
		
	//for feature:10589
	
		paraList_tRunJob_1.add("--stat_port=" + portStats);
	

	if(resuming_logs_dir_path != null){
		paraList_tRunJob_1.add("--resuming_logs_dir_path=" + resuming_logs_dir_path);
	}
	String childResumePath_tRunJob_1 = ResumeUtil.getChildJobCheckPointPath(resuming_checkpoint_path);
	String tRunJobName_tRunJob_1 = ResumeUtil.getRighttRunJob(resuming_checkpoint_path);
	if("tRunJob_1".equals(tRunJobName_tRunJob_1) && childResumePath_tRunJob_1 != null){
		paraList_tRunJob_1.add("--resuming_checkpoint_path=" + ResumeUtil.getChildJobCheckPointPath(resuming_checkpoint_path));
	}
	paraList_tRunJob_1.add("--parent_part_launcher=JOB:" + jobName + "/NODE:tRunJob_1");
	
	java.util.Map<String, Object> parentContextMap_tRunJob_1 = new java.util.HashMap<String, Object>();

	

	Object obj_tRunJob_1 = null;

	
		obj_tRunJob_1 = context.job_name;
		if(obj_tRunJob_1!=null) {
			if (obj_tRunJob_1.getClass().getName().equals("java.util.Date")) {
				paraList_tRunJob_1.add("--context_param job_name=" + ((java.util.Date) obj_tRunJob_1).getTime());
			} else {
				paraList_tRunJob_1.add("--context_param job_name=" + RuntimeUtils.tRunJobConvertContext(obj_tRunJob_1));
			}
		} else {
			paraList_tRunJob_1.add("--context_param job_name=" + NULL_VALUE_EXPRESSION_IN_COMMAND_STRING_FOR_CHILD_JOB_ONLY);
		}
		
		parentContextMap_tRunJob_1.put("job_name", obj_tRunJob_1);
	
		obj_tRunJob_1 = "Starting";
		if(obj_tRunJob_1!=null) {
			if (obj_tRunJob_1.getClass().getName().equals("java.util.Date")) {
				paraList_tRunJob_1.add("--context_param job_status=" + ((java.util.Date) obj_tRunJob_1).getTime());
			} else {
				paraList_tRunJob_1.add("--context_param job_status=" + RuntimeUtils.tRunJobConvertContext(obj_tRunJob_1));
			}
		} else {
			paraList_tRunJob_1.add("--context_param job_status=" + NULL_VALUE_EXPRESSION_IN_COMMAND_STRING_FOR_CHILD_JOB_ONLY);
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
		  
		
			log.info("tRunJob_1 - The child job 'final_project.pre_job_log_0_1.pre_job_log' starts on the version '0.1' with the context 'Default'.");
		
		String[][] childReturn_tRunJob_1 = childJob_tRunJob_1.runJob((String[]) paraList_tRunJob_1.toArray(new String[paraList_tRunJob_1.size()]));
		
			log.info("tRunJob_1 - The child job 'final_project.pre_job_log_0_1.pre_job_log' is done.");
		
            if(childJob_tRunJob_1.getErrorCode() == null){
                globalMap.put("tRunJob_1_CHILD_RETURN_CODE", childJob_tRunJob_1.getStatus() != null && ("failure").equals(childJob_tRunJob_1.getStatus()) ? 1 : 0);
            }else{
                globalMap.put("tRunJob_1_CHILD_RETURN_CODE", childJob_tRunJob_1.getErrorCode());
            }
            if (childJob_tRunJob_1.getExceptionStackTrace() != null) {
                globalMap.put("tRunJob_1_CHILD_EXCEPTION_STACKTRACE", childJob_tRunJob_1.getExceptionStackTrace());
            }
                    errorCode = childJob_tRunJob_1.getErrorCode();
                if (childJob_tRunJob_1.getErrorCode() != null || ("failure").equals(childJob_tRunJob_1.getStatus())) {
                    java.lang.Exception ce_tRunJob_1 = childJob_tRunJob_1.getException();
                    throw new RuntimeException("Child job running failed.\n" + ((ce_tRunJob_1!=null) ? (ce_tRunJob_1.getClass().getName() + ": " + ce_tRunJob_1.getMessage()) : ""));
                }

 


	tos_count_tRunJob_1++;

/**
 * [tRunJob_1 main ] stop
 */
	
	/**
	 * [tRunJob_1 process_data_begin ] start
	 */

	

	
	
	currentComponent="tRunJob_1";
	
	

 



/**
 * [tRunJob_1 process_data_begin ] stop
 */
	
	/**
	 * [tRunJob_1 process_data_end ] start
	 */

	

	
	
	currentComponent="tRunJob_1";
	
	

 



/**
 * [tRunJob_1 process_data_end ] stop
 */
	
	/**
	 * [tRunJob_1 end ] start
	 */

	

	
	
	currentComponent="tRunJob_1";
	
	

 
                if(log.isDebugEnabled())
            log.debug("tRunJob_1 - "  + ("Done.") );

ok_Hash.put("tRunJob_1", true);
end_Hash.put("tRunJob_1", System.currentTimeMillis());




/**
 * [tRunJob_1 end ] stop
 */
				}//end the resume

				



	
			}catch(java.lang.Exception e){	
				
				    if(!(e instanceof TalendException)){
					   log.fatal(currentComponent + " " + e.getMessage(),e);
					}
				
				TalendException te = new TalendException(e, currentComponent, cLabel, globalMap);
				
				throw te;
			}catch(java.lang.Error error){	
				
					runStat.stopThreadStat();
				
				throw error;
			}finally{
				
				try{
					
	
	/**
	 * [tRunJob_1 finally ] start
	 */

	

	
	
	currentComponent="tRunJob_1";
	
	

 



/**
 * [tRunJob_1 finally ] stop
 */
				}catch(java.lang.Exception e){	
					//ignore
				}catch(java.lang.Error error){
					//ignore
				}
				resourceMap = null;
			}
		

		globalMap.put("tRunJob_1_SUBPROCESS_STATE", 1);
	}
	


public void tPostjob_1Process(final java.util.Map<String, Object> globalMap) throws TalendException {
	globalMap.put("tPostjob_1_SUBPROCESS_STATE", 0);

 final boolean execStat = this.execStat;
	
		mdcInfo.forEach(org.slf4j.MDC::put);
		org.slf4j.MDC.put("_subJobName", "tPostjob_1");
		org.slf4j.MDC.put("_subJobPid", "OemWPB_" + subJobPidCounter.getAndIncrement());
	

	
		String iterateId = "";
	
	
	String currentComponent = "";
	String cLabel =  null;
	java.util.Map<String, Object> resourceMap = new java.util.HashMap<String, Object>();

	try {
			// TDI-39566 avoid throwing an useless Exception
			boolean resumeIt = true;
			if (globalResumeTicket == false && resumeEntryMethodName != null) {
				String currentMethodName = new java.lang.Exception().getStackTrace()[0].getMethodName();
				resumeIt = resumeEntryMethodName.equals(currentMethodName);
			}
			if (resumeIt || globalResumeTicket) { //start the resume
				globalResumeTicket = true;



		


	
	/**
	 * [tPostjob_1 begin ] start
	 */

	

	
		
		ok_Hash.put("tPostjob_1", false);
		start_Hash.put("tPostjob_1", System.currentTimeMillis());
		
	
	currentComponent="tPostjob_1";
	
	
		int tos_count_tPostjob_1 = 0;
		
			if(enableLogStash) {
				talendJobLog.addCM("tPostjob_1", "tPostjob_1", "tPostjob");
				talendJobLogProcess(globalMap);
			}
			

 



/**
 * [tPostjob_1 begin ] stop
 */
	
	/**
	 * [tPostjob_1 main ] start
	 */

	

	
	
	currentComponent="tPostjob_1";
	
	

 


	tos_count_tPostjob_1++;

/**
 * [tPostjob_1 main ] stop
 */
	
	/**
	 * [tPostjob_1 process_data_begin ] start
	 */

	

	
	
	currentComponent="tPostjob_1";
	
	

 



/**
 * [tPostjob_1 process_data_begin ] stop
 */
	
	/**
	 * [tPostjob_1 process_data_end ] start
	 */

	

	
	
	currentComponent="tPostjob_1";
	
	

 



/**
 * [tPostjob_1 process_data_end ] stop
 */
	
	/**
	 * [tPostjob_1 end ] start
	 */

	

	
	
	currentComponent="tPostjob_1";
	
	

 

ok_Hash.put("tPostjob_1", true);
end_Hash.put("tPostjob_1", System.currentTimeMillis());

				if(execStat){   
   	 				runStat.updateStatOnConnection("OnComponentOk2", 0, "ok");
				}
				tRunJob_2Process(globalMap);



/**
 * [tPostjob_1 end ] stop
 */
				}//end the resume

				



	
			}catch(java.lang.Exception e){	
				
				    if(!(e instanceof TalendException)){
					   log.fatal(currentComponent + " " + e.getMessage(),e);
					}
				
				TalendException te = new TalendException(e, currentComponent, cLabel, globalMap);
				
				throw te;
			}catch(java.lang.Error error){	
				
					runStat.stopThreadStat();
				
				throw error;
			}finally{
				
				try{
					
	
	/**
	 * [tPostjob_1 finally ] start
	 */

	

	
	
	currentComponent="tPostjob_1";
	
	

 



/**
 * [tPostjob_1 finally ] stop
 */
				}catch(java.lang.Exception e){	
					//ignore
				}catch(java.lang.Error error){
					//ignore
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
		org.slf4j.MDC.put("_subJobPid", "k1yoHD_" + subJobPidCounter.getAndIncrement());
	

	
		String iterateId = "";
	
	
	String currentComponent = "";
	String cLabel =  null;
	java.util.Map<String, Object> resourceMap = new java.util.HashMap<String, Object>();

	try {
			// TDI-39566 avoid throwing an useless Exception
			boolean resumeIt = true;
			if (globalResumeTicket == false && resumeEntryMethodName != null) {
				String currentMethodName = new java.lang.Exception().getStackTrace()[0].getMethodName();
				resumeIt = resumeEntryMethodName.equals(currentMethodName);
			}
			if (resumeIt || globalResumeTicket) { //start the resume
				globalResumeTicket = true;





	
	/**
	 * [tRunJob_2 begin ] start
	 */

	

	
		
		ok_Hash.put("tRunJob_2", false);
		start_Hash.put("tRunJob_2", System.currentTimeMillis());
		
	
	currentComponent="tRunJob_2";
	
	
		int tos_count_tRunJob_2 = 0;
		
                if(log.isDebugEnabled())
            log.debug("tRunJob_2 - "  + ("Start to work.") );
            if (log.isDebugEnabled()) {
                class BytesLimit65535_tRunJob_2{
                    public void limitLog4jByte() throws Exception{
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
                            log4jParamters_tRunJob_2.append("CONTEXTPARAMS" + " = " + "[{PARAM_NAME_COLUMN="+("job_name")+", PARAM_VALUE_COLUMN="+("context.job_name")+"}, {PARAM_NAME_COLUMN="+("job_status")+", PARAM_VALUE_COLUMN="+("\"Completed\"")+"}]");
                        log4jParamters_tRunJob_2.append(" | ");
                            log4jParamters_tRunJob_2.append("PROPAGATE_CHILD_RESULT" + " = " + "false");
                        log4jParamters_tRunJob_2.append(" | ");
                            log4jParamters_tRunJob_2.append("PRINT_PARAMETER" + " = " + "false");
                        log4jParamters_tRunJob_2.append(" | ");
                            log4jParamters_tRunJob_2.append("USE_DYNAMIC_CONTEXT" + " = " + "false");
                        log4jParamters_tRunJob_2.append(" | ");
                if(log.isDebugEnabled())
            log.debug("tRunJob_2 - "  + (log4jParamters_tRunJob_2) );
                    } 
                } 
            new BytesLimit65535_tRunJob_2().limitLog4jByte();
            }
			if(enableLogStash) {
				talendJobLog.addCM("tRunJob_2", "tRunJob_2", "tRunJob");
				talendJobLogProcess(globalMap);
			}
			


 



/**
 * [tRunJob_2 begin ] stop
 */
	
	/**
	 * [tRunJob_2 main ] start
	 */

	

	
	
	currentComponent="tRunJob_2";
	
	
	java.util.List<String> paraList_tRunJob_2 = new java.util.ArrayList<String>();
	
	        				paraList_tRunJob_2.add("--father_pid="+pid);
	      			
	        				paraList_tRunJob_2.add("--root_pid="+rootPid);
	      			
	        				paraList_tRunJob_2.add("--father_node=tRunJob_2");
	      			
	        				paraList_tRunJob_2.add("--context=Default");
	      			
			if(!"".equals(log4jLevel)){
				paraList_tRunJob_2.add("--log4jLevel="+log4jLevel);
			}
		
		if(enableLogStash){
			paraList_tRunJob_2.add("--audit.enabled="+enableLogStash);
		}
		
	//for feature:10589
	
		paraList_tRunJob_2.add("--stat_port=" + portStats);
	

	if(resuming_logs_dir_path != null){
		paraList_tRunJob_2.add("--resuming_logs_dir_path=" + resuming_logs_dir_path);
	}
	String childResumePath_tRunJob_2 = ResumeUtil.getChildJobCheckPointPath(resuming_checkpoint_path);
	String tRunJobName_tRunJob_2 = ResumeUtil.getRighttRunJob(resuming_checkpoint_path);
	if("tRunJob_2".equals(tRunJobName_tRunJob_2) && childResumePath_tRunJob_2 != null){
		paraList_tRunJob_2.add("--resuming_checkpoint_path=" + ResumeUtil.getChildJobCheckPointPath(resuming_checkpoint_path));
	}
	paraList_tRunJob_2.add("--parent_part_launcher=JOB:" + jobName + "/NODE:tRunJob_2");
	
	java.util.Map<String, Object> parentContextMap_tRunJob_2 = new java.util.HashMap<String, Object>();

	

	Object obj_tRunJob_2 = null;

	
		obj_tRunJob_2 = context.job_name;
		if(obj_tRunJob_2!=null) {
			if (obj_tRunJob_2.getClass().getName().equals("java.util.Date")) {
				paraList_tRunJob_2.add("--context_param job_name=" + ((java.util.Date) obj_tRunJob_2).getTime());
			} else {
				paraList_tRunJob_2.add("--context_param job_name=" + RuntimeUtils.tRunJobConvertContext(obj_tRunJob_2));
			}
		} else {
			paraList_tRunJob_2.add("--context_param job_name=" + NULL_VALUE_EXPRESSION_IN_COMMAND_STRING_FOR_CHILD_JOB_ONLY);
		}
		
		parentContextMap_tRunJob_2.put("job_name", obj_tRunJob_2);
	
		obj_tRunJob_2 = "Completed";
		if(obj_tRunJob_2!=null) {
			if (obj_tRunJob_2.getClass().getName().equals("java.util.Date")) {
				paraList_tRunJob_2.add("--context_param job_status=" + ((java.util.Date) obj_tRunJob_2).getTime());
			} else {
				paraList_tRunJob_2.add("--context_param job_status=" + RuntimeUtils.tRunJobConvertContext(obj_tRunJob_2));
			}
		} else {
			paraList_tRunJob_2.add("--context_param job_status=" + NULL_VALUE_EXPRESSION_IN_COMMAND_STRING_FOR_CHILD_JOB_ONLY);
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
		  
		
			log.info("tRunJob_2 - The child job 'final_project.pre_job_log_0_1.pre_job_log' starts on the version '0.1' with the context 'Default'.");
		
		String[][] childReturn_tRunJob_2 = childJob_tRunJob_2.runJob((String[]) paraList_tRunJob_2.toArray(new String[paraList_tRunJob_2.size()]));
		
			log.info("tRunJob_2 - The child job 'final_project.pre_job_log_0_1.pre_job_log' is done.");
		
            if(childJob_tRunJob_2.getErrorCode() == null){
                globalMap.put("tRunJob_2_CHILD_RETURN_CODE", childJob_tRunJob_2.getStatus() != null && ("failure").equals(childJob_tRunJob_2.getStatus()) ? 1 : 0);
            }else{
                globalMap.put("tRunJob_2_CHILD_RETURN_CODE", childJob_tRunJob_2.getErrorCode());
            }
            if (childJob_tRunJob_2.getExceptionStackTrace() != null) {
                globalMap.put("tRunJob_2_CHILD_EXCEPTION_STACKTRACE", childJob_tRunJob_2.getExceptionStackTrace());
            }
                    errorCode = childJob_tRunJob_2.getErrorCode();
                if (childJob_tRunJob_2.getErrorCode() != null || ("failure").equals(childJob_tRunJob_2.getStatus())) {
                    java.lang.Exception ce_tRunJob_2 = childJob_tRunJob_2.getException();
                    throw new RuntimeException("Child job running failed.\n" + ((ce_tRunJob_2!=null) ? (ce_tRunJob_2.getClass().getName() + ": " + ce_tRunJob_2.getMessage()) : ""));
                }

 


	tos_count_tRunJob_2++;

/**
 * [tRunJob_2 main ] stop
 */
	
	/**
	 * [tRunJob_2 process_data_begin ] start
	 */

	

	
	
	currentComponent="tRunJob_2";
	
	

 



/**
 * [tRunJob_2 process_data_begin ] stop
 */
	
	/**
	 * [tRunJob_2 process_data_end ] start
	 */

	

	
	
	currentComponent="tRunJob_2";
	
	

 



/**
 * [tRunJob_2 process_data_end ] stop
 */
	
	/**
	 * [tRunJob_2 end ] start
	 */

	

	
	
	currentComponent="tRunJob_2";
	
	

 
                if(log.isDebugEnabled())
            log.debug("tRunJob_2 - "  + ("Done.") );

ok_Hash.put("tRunJob_2", true);
end_Hash.put("tRunJob_2", System.currentTimeMillis());




/**
 * [tRunJob_2 end ] stop
 */
				}//end the resume

				



	
			}catch(java.lang.Exception e){	
				
				    if(!(e instanceof TalendException)){
					   log.fatal(currentComponent + " " + e.getMessage(),e);
					}
				
				TalendException te = new TalendException(e, currentComponent, cLabel, globalMap);
				
				throw te;
			}catch(java.lang.Error error){	
				
					runStat.stopThreadStat();
				
				throw error;
			}finally{
				
				try{
					
	
	/**
	 * [tRunJob_2 finally ] start
	 */

	

	
	
	currentComponent="tRunJob_2";
	
	

 



/**
 * [tRunJob_2 finally ] stop
 */
				}catch(java.lang.Exception e){	
					//ignore
				}catch(java.lang.Error error){
					//ignore
				}
				resourceMap = null;
			}
		

		globalMap.put("tRunJob_2_SUBPROCESS_STATE", 1);
	}
	


public void talendJobLogProcess(final java.util.Map<String, Object> globalMap) throws TalendException {
	globalMap.put("talendJobLog_SUBPROCESS_STATE", 0);

 final boolean execStat = this.execStat;
	
		mdcInfo.forEach(org.slf4j.MDC::put);
		org.slf4j.MDC.put("_subJobName", "talendJobLog");
		org.slf4j.MDC.put("_subJobPid", "kBIo5X_" + subJobPidCounter.getAndIncrement());
	

	
		String iterateId = "";
	
	
	String currentComponent = "";
	String cLabel =  null;
	java.util.Map<String, Object> resourceMap = new java.util.HashMap<String, Object>();

	try {
			// TDI-39566 avoid throwing an useless Exception
			boolean resumeIt = true;
			if (globalResumeTicket == false && resumeEntryMethodName != null) {
				String currentMethodName = new java.lang.Exception().getStackTrace()[0].getMethodName();
				resumeIt = resumeEntryMethodName.equals(currentMethodName);
			}
			if (resumeIt || globalResumeTicket) { //start the resume
				globalResumeTicket = true;





	
	/**
	 * [talendJobLog begin ] start
	 */

	

	
		
		ok_Hash.put("talendJobLog", false);
		start_Hash.put("talendJobLog", System.currentTimeMillis());
		
	
	currentComponent="talendJobLog";
	
	
		int tos_count_talendJobLog = 0;
		

	for (JobStructureCatcherUtils.JobStructureCatcherMessage jcm : talendJobLog.getMessages()) {
		org.talend.job.audit.JobContextBuilder builder_talendJobLog = org.talend.job.audit.JobContextBuilder.create().jobName(jcm.job_name).jobId(jcm.job_id).jobVersion(jcm.job_version)
			.custom("process_id", jcm.pid).custom("thread_id", jcm.tid).custom("pid", pid).custom("father_pid", fatherPid).custom("root_pid", rootPid);
		org.talend.logging.audit.Context log_context_talendJobLog = null;
		
		
		if(jcm.log_type == JobStructureCatcherUtils.LogType.PERFORMANCE){
			long timeMS = jcm.end_time - jcm.start_time;
			String duration = String.valueOf(timeMS);
			
			log_context_talendJobLog = builder_talendJobLog
				.sourceId(jcm.sourceId).sourceLabel(jcm.sourceLabel).sourceConnectorType(jcm.sourceComponentName)
				.targetId(jcm.targetId).targetLabel(jcm.targetLabel).targetConnectorType(jcm.targetComponentName)
				.connectionName(jcm.current_connector).rows(jcm.row_count).duration(duration).build();
			auditLogger_talendJobLog.flowExecution(log_context_talendJobLog);
		} else if(jcm.log_type == JobStructureCatcherUtils.LogType.JOBSTART) {
			log_context_talendJobLog = builder_talendJobLog.timestamp(jcm.moment).build();
			auditLogger_talendJobLog.jobstart(log_context_talendJobLog);
		} else if(jcm.log_type == JobStructureCatcherUtils.LogType.JOBEND) {
			long timeMS = jcm.end_time - jcm.start_time;
			String duration = String.valueOf(timeMS);
		
			log_context_talendJobLog = builder_talendJobLog
				.timestamp(jcm.moment).duration(duration).status(jcm.status).build();
			auditLogger_talendJobLog.jobstop(log_context_talendJobLog);
		} else if(jcm.log_type == JobStructureCatcherUtils.LogType.RUNCOMPONENT) {
			log_context_talendJobLog = builder_talendJobLog.timestamp(jcm.moment)
				.connectorType(jcm.component_name).connectorId(jcm.component_id).connectorLabel(jcm.component_label).build();
			auditLogger_talendJobLog.runcomponent(log_context_talendJobLog);
		} else if(jcm.log_type == JobStructureCatcherUtils.LogType.FLOWINPUT) {//log current component input line
			long timeMS = jcm.end_time - jcm.start_time;
			String duration = String.valueOf(timeMS);
			
			log_context_talendJobLog = builder_talendJobLog
				.connectorType(jcm.component_name).connectorId(jcm.component_id).connectorLabel(jcm.component_label)
				.connectionName(jcm.current_connector).connectionType(jcm.current_connector_type)
				.rows(jcm.total_row_number).duration(duration).build();
			auditLogger_talendJobLog.flowInput(log_context_talendJobLog);
		} else if(jcm.log_type == JobStructureCatcherUtils.LogType.FLOWOUTPUT) {//log current component output/reject line
			long timeMS = jcm.end_time - jcm.start_time;
			String duration = String.valueOf(timeMS);
			
			log_context_talendJobLog = builder_talendJobLog
				.connectorType(jcm.component_name).connectorId(jcm.component_id).connectorLabel(jcm.component_label)
				.connectionName(jcm.current_connector).connectionType(jcm.current_connector_type)
				.rows(jcm.total_row_number).duration(duration).build();
			auditLogger_talendJobLog.flowOutput(log_context_talendJobLog);
		} else if(jcm.log_type == JobStructureCatcherUtils.LogType.JOBERROR) {
			java.lang.Exception e_talendJobLog = jcm.exception;
			if(e_talendJobLog!=null) {
				try(java.io.StringWriter sw_talendJobLog = new java.io.StringWriter();java.io.PrintWriter pw_talendJobLog = new java.io.PrintWriter(sw_talendJobLog)) {
					e_talendJobLog.printStackTrace(pw_talendJobLog);
					builder_talendJobLog.custom("stacktrace", sw_talendJobLog.getBuffer().substring(0,java.lang.Math.min(sw_talendJobLog.getBuffer().length(), 512)));
				}
			}

			if(jcm.extra_info!=null) {
				builder_talendJobLog.connectorId(jcm.component_id).custom("extra_info", jcm.extra_info);
			}
				
			log_context_talendJobLog = builder_talendJobLog
				.connectorType(jcm.component_id.substring(0, jcm.component_id.lastIndexOf('_')))
				.connectorId(jcm.component_id)
				.connectorLabel(jcm.component_label == null ? jcm.component_id : jcm.component_label).build();

			auditLogger_talendJobLog.exception(log_context_talendJobLog);
		}
		
		
		
	}

 



/**
 * [talendJobLog begin ] stop
 */
	
	/**
	 * [talendJobLog main ] start
	 */

	

	
	
	currentComponent="talendJobLog";
	
	

 


	tos_count_talendJobLog++;

/**
 * [talendJobLog main ] stop
 */
	
	/**
	 * [talendJobLog process_data_begin ] start
	 */

	

	
	
	currentComponent="talendJobLog";
	
	

 



/**
 * [talendJobLog process_data_begin ] stop
 */
	
	/**
	 * [talendJobLog process_data_end ] start
	 */

	

	
	
	currentComponent="talendJobLog";
	
	

 



/**
 * [talendJobLog process_data_end ] stop
 */
	
	/**
	 * [talendJobLog end ] start
	 */

	

	
	
	currentComponent="talendJobLog";
	
	

 

ok_Hash.put("talendJobLog", true);
end_Hash.put("talendJobLog", System.currentTimeMillis());




/**
 * [talendJobLog end ] stop
 */
				}//end the resume

				



	
			}catch(java.lang.Exception e){	
				
				    if(!(e instanceof TalendException)){
					   log.fatal(currentComponent + " " + e.getMessage(),e);
					}
				
				TalendException te = new TalendException(e, currentComponent, cLabel, globalMap);
				
				throw te;
			}catch(java.lang.Error error){	
				
					runStat.stopThreadStat();
				
				throw error;
			}finally{
				
				try{
					
	
	/**
	 * [talendJobLog finally ] start
	 */

	

	
	
	currentComponent="talendJobLog";
	
	

 



/**
 * [talendJobLog finally ] stop
 */
				}catch(java.lang.Exception e){	
					//ignore
				}catch(java.lang.Error error){
					//ignore
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
            java.util.Map<String,String> threadRunResultMap = new java.util.HashMap<String, String>();
            threadRunResultMap.put("errorCode", null);
            threadRunResultMap.put("status", "");
            return threadRunResultMap;
        };
    };


    protected PropertiesWithType context_param = new PropertiesWithType();
    public java.util.Map<String, Object> parentContextMap = new java.util.HashMap<String, Object>();

    public String status= "";
    
    
    private final static java.util.Properties jobInfo = new java.util.Properties();
    private final static java.util.Map<String,String> mdcInfo = new java.util.HashMap<>();
    private final static java.util.concurrent.atomic.AtomicLong subJobPidCounter = new java.util.concurrent.atomic.AtomicLong();


    public static void main(String[] args){
        final sql_staging_job sql_staging_jobClass = new sql_staging_job();

        int exitCode = sql_staging_jobClass.runJobInTOS(args);
	        if(exitCode==0){
		        log.info("TalendJob: 'sql_staging_job' - Done.");
	        }

        System.exit(exitCode);
    }
	

	
	
	private void getjobInfo() {
		final String TEMPLATE_PATH = "src/main/templates/jobInfo_template.properties";
		final String BUILD_PATH = "../jobInfo.properties";
		final String path = this.getClass().getResource("").getPath();
		if(path.lastIndexOf("target") > 0) {
			final java.io.File templateFile = new java.io.File(
					path.substring(0, path.lastIndexOf("target")).concat(TEMPLATE_PATH));
			if (templateFile.exists()) {
				readJobInfo(templateFile);
				return;
			}
		}
			readJobInfo(new java.io.File(BUILD_PATH));
	}

    private void readJobInfo(java.io.File jobInfoFile){
	
        if(jobInfoFile.exists()) {
            try (java.io.InputStream is = new java.io.FileInputStream(jobInfoFile)) {
            	jobInfo.load(is);
            } catch (IOException e) {
            	 
                log.debug("Read jobInfo.properties file fail: " + e.getMessage());
                
            }
        }
		log.info(String.format("Project name: %s\tJob name: %s\tGIT Commit ID: %s\tTalend Version: %s",
				projectName,jobName,jobInfo.getProperty("gitCommitId"), "8.0.1.20230913_0925-patch"));
		
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

	        if(!"".equals(log4jLevel)){
	        	
				
				
				if("trace".equalsIgnoreCase(log4jLevel)){
					org.apache.logging.log4j.core.config.Configurator.setLevel(log.getName(), org.apache.logging.log4j.Level.TRACE);
				}else if("debug".equalsIgnoreCase(log4jLevel)){
					org.apache.logging.log4j.core.config.Configurator.setLevel(log.getName(), org.apache.logging.log4j.Level.DEBUG);
				}else if("info".equalsIgnoreCase(log4jLevel)){
					org.apache.logging.log4j.core.config.Configurator.setLevel(log.getName(), org.apache.logging.log4j.Level.INFO);
				}else if("warn".equalsIgnoreCase(log4jLevel)){
					org.apache.logging.log4j.core.config.Configurator.setLevel(log.getName(), org.apache.logging.log4j.Level.WARN);
				}else if("error".equalsIgnoreCase(log4jLevel)){
					org.apache.logging.log4j.core.config.Configurator.setLevel(log.getName(), org.apache.logging.log4j.Level.ERROR);
				}else if("fatal".equalsIgnoreCase(log4jLevel)){
					org.apache.logging.log4j.core.config.Configurator.setLevel(log.getName(), org.apache.logging.log4j.Level.FATAL);
				}else if ("off".equalsIgnoreCase(log4jLevel)){
					org.apache.logging.log4j.core.config.Configurator.setLevel(log.getName(), org.apache.logging.log4j.Level.OFF);
				}
				org.apache.logging.log4j.core.config.Configurator.setLevel(org.apache.logging.log4j.LogManager.getRootLogger().getName(), log.getLevel());
				
			}

	        getjobInfo();
			log.info("TalendJob: 'sql_staging_job' - Start.");
		

                java.util.Set<Object> jobInfoKeys = jobInfo.keySet();
                for(Object jobInfoKey: jobInfoKeys) {
                    org.slf4j.MDC.put("_" + jobInfoKey.toString(), jobInfo.get(jobInfoKey).toString());
                }
                org.slf4j.MDC.put("_pid", pid);
                org.slf4j.MDC.put("_rootPid", rootPid);
                org.slf4j.MDC.put("_fatherPid", fatherPid);
                org.slf4j.MDC.put("_projectName", projectName);
                org.slf4j.MDC.put("_startTimestamp",java.time.ZonedDateTime.now(java.time.ZoneOffset.UTC ).format( java.time.format.DateTimeFormatter.ISO_INSTANT ));
                org.slf4j.MDC.put("_jobRepositoryId","_5lZK4JEgEe6FmMo3PpyKlQ");
                org.slf4j.MDC.put("_compiledAtTimestamp","2023-12-04T00:39:43.065239700Z");

                java.lang.management.RuntimeMXBean mx = java.lang.management.ManagementFactory.getRuntimeMXBean();
                String[] mxNameTable = mx.getName().split("@"); //$NON-NLS-1$
                if (mxNameTable.length == 2) {
                    org.slf4j.MDC.put("_systemPid", mxNameTable[0]);
                } else {
                    org.slf4j.MDC.put("_systemPid", String.valueOf(java.lang.Thread.currentThread().getId()));
                }

		
		
			if(enableLogStash) {
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

				System.getProperties().stringPropertyNames().stream()
					.filter(it -> it.startsWith("audit.logger."))
					.forEach(key -> properties_talendJobLog.setProperty(key.substring("audit.logger.".length()), System.getProperty(key)));

				
				
				
				org.apache.logging.log4j.core.config.Configurator.setLevel(properties_talendJobLog.getProperty("root.logger"), org.apache.logging.log4j.Level.DEBUG);
				
				auditLogger_talendJobLog = org.talend.job.audit.JobEventAuditLoggerFactory.createJobAuditLogger(properties_talendJobLog);
			}
		

        if(clientHost == null) {
            clientHost = defaultClientHost;
        }

        if(pid == null || "0".equals(pid)) {
            pid = TalendString.getAsciiRandomString(6);
        }

            org.slf4j.MDC.put("_pid", pid);

        if (rootPid==null) {
            rootPid = pid;
        }

            org.slf4j.MDC.put("_rootPid", rootPid);

        if (fatherPid==null) {
            fatherPid = pid;
        }else{
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
                    contextStr = (String)jobProperties.get("context");
                }
            }
            //call job/subjob with an existing context, like: --context=production. if without this parameter, there will use the default context instead.
            java.io.InputStream inContext = sql_staging_job.class.getClassLoader().getResourceAsStream("final_project/sql_staging_job_0_1/contexts/" + contextStr + ".properties");
            if (inContext == null) {
                inContext = sql_staging_job.class.getClassLoader().getResourceAsStream("config/contexts/" + contextStr + ".properties");
            }
            if (inContext != null) {
                try {
                    //defaultProps is in order to keep the original context value
                    if(context != null && context.isEmpty()) {
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
                //print info and job continue to run, for case: context_param is not empty.
                System.err.println("Could not find the context " + contextStr);
            }

            if(!context_param.isEmpty()) {
                context.putAll(context_param);
				//set types for params from parentJobs
				for (Object key: context_param.keySet()){
					String context_key = key.toString();
					String context_type = context_param.getContextType(context_key);
					context.setContextType(context_key, context_type);

				}
            }
            class ContextProcessing {
                private void processContext_0() {
                        context.setContextType("MySqlLocal_Password", "id_Password");
                        if(context.getStringValue("MySqlLocal_Password") == null) {
                            context.MySqlLocal_Password = null;
                        } else {
                            String pwd_MySqlLocal_Password_value = context.getProperty("MySqlLocal_Password");
                            context.MySqlLocal_Password = null;
                            if(pwd_MySqlLocal_Password_value!=null) {
                                if(context_param.containsKey("MySqlLocal_Password")) {//no need to decrypt if it come from program argument or parent job runtime
                                    context.MySqlLocal_Password = pwd_MySqlLocal_Password_value;
                                } else if (!pwd_MySqlLocal_Password_value.isEmpty()) {
                                    try {
                                        context.MySqlLocal_Password = routines.system.PasswordEncryptUtil.decryptPassword(pwd_MySqlLocal_Password_value);
                                        context.put("MySqlLocal_Password",context.MySqlLocal_Password);
                                    } catch (java.lang.RuntimeException e) {
                                        //do nothing
                                    }
                                }
                            }
                        }
                        context.setContextType("MySqlLocal_AdditionalParams", "id_String");
                        if(context.getStringValue("MySqlLocal_AdditionalParams") == null) {
                            context.MySqlLocal_AdditionalParams = null;
                        } else {
                            context.MySqlLocal_AdditionalParams=(String) context.getProperty("MySqlLocal_AdditionalParams");
                        }
                        context.setContextType("MySqlLocal_Login", "id_String");
                        if(context.getStringValue("MySqlLocal_Login") == null) {
                            context.MySqlLocal_Login = null;
                        } else {
                            context.MySqlLocal_Login=(String) context.getProperty("MySqlLocal_Login");
                        }
                        context.setContextType("MySqlLocal_Database", "id_String");
                        if(context.getStringValue("MySqlLocal_Database") == null) {
                            context.MySqlLocal_Database = null;
                        } else {
                            context.MySqlLocal_Database=(String) context.getProperty("MySqlLocal_Database");
                        }
                        context.setContextType("MySqlLocal_Server", "id_String");
                        if(context.getStringValue("MySqlLocal_Server") == null) {
                            context.MySqlLocal_Server = null;
                        } else {
                            context.MySqlLocal_Server=(String) context.getProperty("MySqlLocal_Server");
                        }
                        context.setContextType("MySqlLocal_Port", "id_String");
                        if(context.getStringValue("MySqlLocal_Port") == null) {
                            context.MySqlLocal_Port = null;
                        } else {
                            context.MySqlLocal_Port=(String) context.getProperty("MySqlLocal_Port");
                        }
                        context.setContextType("job_name", "id_String");
                        if(context.getStringValue("job_name") == null) {
                            context.job_name = null;
                        } else {
                            context.job_name=(String) context.getProperty("job_name");
                        }
                } 
                public void processAllContext() {
                        processContext_0();
                }
            }

            new ContextProcessing().processAllContext();
        } catch (java.io.IOException ie) {
            System.err.println("Could not load context "+contextStr);
            ie.printStackTrace();
        }

        // get context value from parent directly
        if (parentContextMap != null && !parentContextMap.isEmpty()) {if (parentContextMap.containsKey("MySqlLocal_Password")) {
                context.MySqlLocal_Password = (java.lang.String) parentContextMap.get("MySqlLocal_Password");
            }if (parentContextMap.containsKey("MySqlLocal_AdditionalParams")) {
                context.MySqlLocal_AdditionalParams = (String) parentContextMap.get("MySqlLocal_AdditionalParams");
            }if (parentContextMap.containsKey("MySqlLocal_Login")) {
                context.MySqlLocal_Login = (String) parentContextMap.get("MySqlLocal_Login");
            }if (parentContextMap.containsKey("MySqlLocal_Database")) {
                context.MySqlLocal_Database = (String) parentContextMap.get("MySqlLocal_Database");
            }if (parentContextMap.containsKey("MySqlLocal_Server")) {
                context.MySqlLocal_Server = (String) parentContextMap.get("MySqlLocal_Server");
            }if (parentContextMap.containsKey("MySqlLocal_Port")) {
                context.MySqlLocal_Port = (String) parentContextMap.get("MySqlLocal_Port");
            }if (parentContextMap.containsKey("job_name")) {
                context.job_name = (String) parentContextMap.get("job_name");
            }
        }

        //Resume: init the resumeUtil
        resumeEntryMethodName = ResumeUtil.getResumeEntryMethodName(resuming_checkpoint_path);
        resumeUtil = new ResumeUtil(resuming_logs_dir_path, isChildJob, rootPid);
        resumeUtil.initCommonInfo(pid, rootPid, fatherPid, projectName, jobName, contextStr, jobVersion);

		List<String> parametersToEncrypt = new java.util.ArrayList<String>();
			parametersToEncrypt.add("MySqlLocal_Password");
        //Resume: jobStart
        resumeUtil.addLog("JOB_STARTED", "JOB:" + jobName, parent_part_launcher, Thread.currentThread().getId() + "", "","","","",resumeUtil.convertToJsonText(context,ContextProperties.class,parametersToEncrypt));

            org.slf4j.MDC.put("_context", contextStr);
            log.info("TalendJob: 'sql_staging_job' - Started.");
            java.util.Optional.ofNullable(org.slf4j.MDC.getCopyOfContextMap()).ifPresent(mdcInfo::putAll);

if(execStat) {
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


this.globalResumeTicket = true;//to run tPreJob

try {
errorCode = null;tPrejob_1Process(globalMap);
if(!"failure".equals(status)) { status = "end"; }
}catch (TalendException e_tPrejob_1) {
globalMap.put("tPrejob_1_SUBPROCESS_STATE", -1);

e_tPrejob_1.printStackTrace();

}



		if(enableLogStash) {
	        talendJobLog.addJobStartMessage();
	        try {
	            talendJobLogProcess(globalMap);
	        } catch (java.lang.Exception e) {
	            e.printStackTrace();
	        }
        }

this.globalResumeTicket = false;//to run others jobs

try {
errorCode = null;tDBInput_2Process(globalMap);
if(!"failure".equals(status)) { status = "end"; }
}catch (TalendException e_tDBInput_2) {
globalMap.put("tDBInput_2_SUBPROCESS_STATE", -1);

e_tDBInput_2.printStackTrace();

}

this.globalResumeTicket = true;//to run tPostJob

try {
errorCode = null;tPostjob_1Process(globalMap);
if(!"failure".equals(status)) { status = "end"; }
}catch (TalendException e_tPostjob_1) {
globalMap.put("tPostjob_1_SUBPROCESS_STATE", -1);

e_tPostjob_1.printStackTrace();

}



        end = System.currentTimeMillis();

        if (watch) {
            System.out.println((end-startTime)+" milliseconds");
        }

        endUsedMemory = Runtime.getRuntime().totalMemory() - Runtime.getRuntime().freeMemory();
        if (false) {
            System.out.println((endUsedMemory - startUsedMemory) + " bytes memory increase when running : sql_staging_job");
        }
		if(enableLogStash) {
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


    if(errorCode == null) {
         returnCode = status != null && status.equals("failure") ? 1 : 0;
    } else {
         returnCode = errorCode.intValue();
    }
    resumeUtil.addLog("JOB_ENDED", "JOB:" + jobName, parent_part_launcher, Thread.currentThread().getId() + "", "","" + returnCode,"","","");
    resumeUtil.flush();


        org.slf4j.MDC.remove("_subJobName");
        org.slf4j.MDC.remove("_subJobPid");
        org.slf4j.MDC.remove("_systemPid");
        log.info("TalendJob: 'sql_staging_job' - Finished - status: " + status + " returnCode: " + returnCode );

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
                if (fatherPid==null) {
                    context_param.setContextType(keyValue.substring(0, index), replaceEscapeChars(keyValue.substring(index + 1)));
                } else { // the subjob won't escape the especial chars
                    context_param.setContextType(keyValue.substring(0, index), keyValue.substring(index + 1) );
                }

            }

		} else if (arg.startsWith("--context_param")) {
            String keyValue = arg.substring(16);
            int index = -1;
            if (keyValue != null && (index = keyValue.indexOf('=')) > -1) {
                if (fatherPid==null) {
                    context_param.put(keyValue.substring(0, index), replaceEscapeChars(keyValue.substring(index + 1)));
                } else { // the subjob won't escape the especial chars
                    context_param.put(keyValue.substring(0, index), keyValue.substring(index + 1) );
                }
            }
        } else if (arg.startsWith("--log4jLevel=")) {
            log4jLevel = arg.substring(13);
		} else if (arg.startsWith("--audit.enabled") && arg.contains("=")) {//for trunjob call
		    final int equal = arg.indexOf('=');
			final String key = arg.substring("--".length(), equal);
			System.setProperty(key, arg.substring(equal + 1));
		}
    }
    
    private static final String NULL_VALUE_EXPRESSION_IN_COMMAND_STRING_FOR_CHILD_JOB_ONLY = "<TALEND_NULL>";

    private final String[][] escapeChars = {
        {"\\\\","\\"},{"\\n","\n"},{"\\'","\'"},{"\\r","\r"},
        {"\\f","\f"},{"\\b","\b"},{"\\t","\t"}
        };
    private String replaceEscapeChars (String keyValue) {

		if (keyValue == null || ("").equals(keyValue.trim())) {
			return keyValue;
		}

		StringBuilder result = new StringBuilder();
		int currIndex = 0;
		while (currIndex < keyValue.length()) {
			int index = -1;
			// judege if the left string includes escape chars
			for (String[] strArray : escapeChars) {
				index = keyValue.indexOf(strArray[0],currIndex);
				if (index>=0) {

					result.append(keyValue.substring(currIndex, index + strArray[0].length()).replace(strArray[0], strArray[1]));
					currIndex = index + strArray[0].length();
					break;
				}
			}
			// if the left string doesn't include escape chars, append the left into the result
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
 *     375371 characters generated by Talend Cloud Data Fabric 
 *     on the December 3, 2023 at 7:39:43 PM EST
 ************************************************************************************************/