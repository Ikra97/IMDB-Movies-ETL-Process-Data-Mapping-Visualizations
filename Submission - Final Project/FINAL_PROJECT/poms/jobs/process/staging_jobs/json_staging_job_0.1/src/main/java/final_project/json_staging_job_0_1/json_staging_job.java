
package final_project.json_staging_job_0_1;

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
 * Job: json_staging_job Purpose: <br>
 * Description:  <br>
 * @author gorle.g@northeastern.edu
 * @version 8.0.1.20230913_0925-patch
 * @status 
 */
public class json_staging_job implements TalendJob {
	static {System.setProperty("TalendJob.log", "json_staging_job.log");}

	

	
	private static org.apache.logging.log4j.Logger log = org.apache.logging.log4j.LogManager.getLogger(json_staging_job.class);
	

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
			
			if(new_name_file_path != null){
				
					this.setProperty("new_name_file_path", new_name_file_path.toString());
				
			}
			
			if(new_title_file_path != null){
				
					this.setProperty("new_title_file_path", new_title_file_path.toString());
				
			}
			
			if(MySqlLocal_Password != null){
				
					this.setProperty("MySqlLocal_Password", MySqlLocal_Password.toString());
				
			}
			
			if(MySqlLocal_Database != null){
				
					this.setProperty("MySqlLocal_Database", MySqlLocal_Database.toString());
				
			}
			
			if(MySqlLocal_Server != null){
				
					this.setProperty("MySqlLocal_Server", MySqlLocal_Server.toString());
				
			}
			
			if(MySqlLocal_Login != null){
				
					this.setProperty("MySqlLocal_Login", MySqlLocal_Login.toString());
				
			}
			
			if(MySqlLocal_Port != null){
				
					this.setProperty("MySqlLocal_Port", MySqlLocal_Port.toString());
				
			}
			
			if(MySqlLocal_AdditionalParams != null){
				
					this.setProperty("MySqlLocal_AdditionalParams", MySqlLocal_AdditionalParams.toString());
				
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

public String new_name_file_path;
public String getNew_name_file_path(){
	return this.new_name_file_path;
}
public String new_title_file_path;
public String getNew_title_file_path(){
	return this.new_title_file_path;
}
public java.lang.String MySqlLocal_Password;
public java.lang.String getMySqlLocal_Password(){
	return this.MySqlLocal_Password;
}
public String MySqlLocal_Database;
public String getMySqlLocal_Database(){
	return this.MySqlLocal_Database;
}
public String MySqlLocal_Server;
public String getMySqlLocal_Server(){
	return this.MySqlLocal_Server;
}
public String MySqlLocal_Login;
public String getMySqlLocal_Login(){
	return this.MySqlLocal_Login;
}
public String MySqlLocal_Port;
public String getMySqlLocal_Port(){
	return this.MySqlLocal_Port;
}
public String MySqlLocal_AdditionalParams;
public String getMySqlLocal_AdditionalParams(){
	return this.MySqlLocal_AdditionalParams;
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
	private final String jobName = "json_staging_job";
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
	

private final JobStructureCatcherUtils talendJobLog = new JobStructureCatcherUtils(jobName, "_oJZUgJBkEe6j8p5IYOvuKQ", "0.1");
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
				json_staging_job.this.exception = e;
			}
		}
		if (!(e instanceof TalendException)) {
		try {
			for (java.lang.reflect.Method m : this.getClass().getEnclosingClass().getMethods()) {
				if (m.getName().compareTo(currentComponent + "_error") == 0) {
					m.invoke(json_staging_job.this, new Object[] { e , currentComponent, globalMap});
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

			public void tFileInputJSON_1_error(Exception exception, String errorComponent, final java.util.Map<String, Object> globalMap) throws TalendException {
				
				end_Hash.put(errorComponent, System.currentTimeMillis());
				
					tFileInputJSON_1_onSubJobError(exception, errorComponent, globalMap);
			}
			
			public void tMap_1_error(Exception exception, String errorComponent, final java.util.Map<String, Object> globalMap) throws TalendException {
				
				end_Hash.put(errorComponent, System.currentTimeMillis());
				
					tFileInputJSON_1_onSubJobError(exception, errorComponent, globalMap);
			}
			
			public void tLogRow_1_error(Exception exception, String errorComponent, final java.util.Map<String, Object> globalMap) throws TalendException {
				
				end_Hash.put(errorComponent, System.currentTimeMillis());
				
					tFileInputJSON_1_onSubJobError(exception, errorComponent, globalMap);
			}
			
			public void tDBOutput_1_error(Exception exception, String errorComponent, final java.util.Map<String, Object> globalMap) throws TalendException {
				
				end_Hash.put(errorComponent, System.currentTimeMillis());
				
					tFileInputJSON_1_onSubJobError(exception, errorComponent, globalMap);
			}
			
			public void tFileInputJSON_2_error(Exception exception, String errorComponent, final java.util.Map<String, Object> globalMap) throws TalendException {
				
				end_Hash.put(errorComponent, System.currentTimeMillis());
				
					tFileInputJSON_2_onSubJobError(exception, errorComponent, globalMap);
			}
			
			public void tMap_2_error(Exception exception, String errorComponent, final java.util.Map<String, Object> globalMap) throws TalendException {
				
				end_Hash.put(errorComponent, System.currentTimeMillis());
				
					tFileInputJSON_2_onSubJobError(exception, errorComponent, globalMap);
			}
			
			public void tLogRow_2_error(Exception exception, String errorComponent, final java.util.Map<String, Object> globalMap) throws TalendException {
				
				end_Hash.put(errorComponent, System.currentTimeMillis());
				
					tFileInputJSON_2_onSubJobError(exception, errorComponent, globalMap);
			}
			
			public void tDBOutput_2_error(Exception exception, String errorComponent, final java.util.Map<String, Object> globalMap) throws TalendException {
				
				end_Hash.put(errorComponent, System.currentTimeMillis());
				
					tFileInputJSON_2_onSubJobError(exception, errorComponent, globalMap);
			}
			
			public void tRunJob_4_error(Exception exception, String errorComponent, final java.util.Map<String, Object> globalMap) throws TalendException {
				
				end_Hash.put(errorComponent, System.currentTimeMillis());
				
				status = "failure";
				
					tRunJob_4_onSubJobError(exception, errorComponent, globalMap);
			}
			
			public void tRunJob_3_error(Exception exception, String errorComponent, final java.util.Map<String, Object> globalMap) throws TalendException {
				
				end_Hash.put(errorComponent, System.currentTimeMillis());
				
				status = "failure";
				
					tRunJob_3_onSubJobError(exception, errorComponent, globalMap);
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
			
			public void tFileInputJSON_1_onSubJobError(Exception exception, String errorComponent, final java.util.Map<String, Object> globalMap) throws TalendException {

resumeUtil.addLog("SYSTEM_LOG", "NODE:"+ errorComponent, "", Thread.currentThread().getId()+ "", "ERROR", "", exception.getMessage(), ResumeUtil.getExceptionStackTrace(exception),"");

				try {
					
						if(this.execStat){
							runStat.updateStatOnConnection("OnSubjobError1", 0, "error");
						}
					
					errorCode = null;
					tRunJob_3Process(globalMap);
					if (!"failure".equals(status)) {
						status = "end";
					}
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
			public void tFileInputJSON_2_onSubJobError(Exception exception, String errorComponent, final java.util.Map<String, Object> globalMap) throws TalendException {

resumeUtil.addLog("SYSTEM_LOG", "NODE:"+ errorComponent, "", Thread.currentThread().getId()+ "", "ERROR", "", exception.getMessage(), ResumeUtil.getExceptionStackTrace(exception),"");

				try {
					
						if(this.execStat){
							runStat.updateStatOnConnection("OnSubjobError2", 0, "error");
						}
					
					errorCode = null;
					tRunJob_4Process(globalMap);
					if (!"failure".equals(status)) {
						status = "end";
					}
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
			public void tRunJob_4_onSubJobError(Exception exception, String errorComponent, final java.util.Map<String, Object> globalMap) throws TalendException {

resumeUtil.addLog("SYSTEM_LOG", "NODE:"+ errorComponent, "", Thread.currentThread().getId()+ "", "FATAL", "", exception.getMessage(), ResumeUtil.getExceptionStackTrace(exception),"");

			}
			public void tRunJob_3_onSubJobError(Exception exception, String errorComponent, final java.util.Map<String, Object> globalMap) throws TalendException {

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
	



public static class toLogStruct implements routines.system.IPersistableRow<toLogStruct> {
    final static byte[] commonByteArrayLock_FINAL_PROJECT_json_staging_job = new byte[0];
    static byte[] commonByteArray_FINAL_PROJECT_json_staging_job = new byte[0];

	
			    public String nconst;

				public String getNconst () {
					return this.nconst;
				}

				public Boolean nconstIsNullable(){
				    return true;
				}
				public Boolean nconstIsKey(){
				    return false;
				}
				public Integer nconstLength(){
				    return 12;
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
				    return 55;
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
				    return 5;
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
				    return 5;
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
				    return 30;
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
				    return 50;
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

				



	private String readString(ObjectInputStream dis) throws IOException{
		String strReturn = null;
		int length = 0;
        length = dis.readInt();
		if (length == -1) {
			strReturn = null;
		} else {
			if(length > commonByteArray_FINAL_PROJECT_json_staging_job.length) {
				if(length < 1024 && commonByteArray_FINAL_PROJECT_json_staging_job.length == 0) {
   					commonByteArray_FINAL_PROJECT_json_staging_job = new byte[1024];
				} else {
   					commonByteArray_FINAL_PROJECT_json_staging_job = new byte[2 * length];
   				}
			}
			dis.readFully(commonByteArray_FINAL_PROJECT_json_staging_job, 0, length);
			strReturn = new String(commonByteArray_FINAL_PROJECT_json_staging_job, 0, length, utf8Charset);
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
			if(length > commonByteArray_FINAL_PROJECT_json_staging_job.length) {
				if(length < 1024 && commonByteArray_FINAL_PROJECT_json_staging_job.length == 0) {
   					commonByteArray_FINAL_PROJECT_json_staging_job = new byte[1024];
				} else {
   					commonByteArray_FINAL_PROJECT_json_staging_job = new byte[2 * length];
   				}
			}
			unmarshaller.readFully(commonByteArray_FINAL_PROJECT_json_staging_job, 0, length);
			strReturn = new String(commonByteArray_FINAL_PROJECT_json_staging_job, 0, length, utf8Charset);
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

    public void readData(ObjectInputStream dis) {

		synchronized(commonByteArrayLock_FINAL_PROJECT_json_staging_job) {

        	try {

        		int length = 0;
		
					this.nconst = readString(dis);
					
					this.primaryName = readString(dis);
					
					this.birthYear = readString(dis);
					
					this.deathYear = readString(dis);
					
					this.primaryProfession = readString(dis);
					
					this.knownForTitles = readString(dis);
					
        	} catch (IOException e) {
	            throw new RuntimeException(e);

		

        }

		

      }


    }
    
    public void readData(org.jboss.marshalling.Unmarshaller dis) {

		synchronized(commonByteArrayLock_FINAL_PROJECT_json_staging_job) {

        	try {

        		int length = 0;
		
					this.nconst = readString(dis);
					
					this.primaryName = readString(dis);
					
					this.birthYear = readString(dis);
					
					this.deathYear = readString(dis);
					
					this.primaryProfession = readString(dis);
					
					this.knownForTitles = readString(dis);
					
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
        		
        	return sb.toString();
        }

    /**
     * Compare keys
     */
    public int compareTo(toLogStruct other) {

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

public static class toMySqlStruct implements routines.system.IPersistableRow<toMySqlStruct> {
    final static byte[] commonByteArrayLock_FINAL_PROJECT_json_staging_job = new byte[0];
    static byte[] commonByteArray_FINAL_PROJECT_json_staging_job = new byte[0];

	
			    public String nconst;

				public String getNconst () {
					return this.nconst;
				}

				public Boolean nconstIsNullable(){
				    return true;
				}
				public Boolean nconstIsKey(){
				    return false;
				}
				public Integer nconstLength(){
				    return 12;
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
				    return 55;
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
				    return 5;
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
				    return 5;
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
				    return 30;
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
				    return 50;
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

				
			    public java.util.Date DI_CreatedDate;

				public java.util.Date getDI_CreatedDate () {
					return this.DI_CreatedDate;
				}

				public Boolean DI_CreatedDateIsNullable(){
				    return true;
				}
				public Boolean DI_CreatedDateIsKey(){
				    return false;
				}
				public Integer DI_CreatedDateLength(){
				    return null;
				}
				public Integer DI_CreatedDatePrecision(){
				    return null;
				}
				public String DI_CreatedDateDefault(){
				
					return null;
				
				}
				public String DI_CreatedDateComment(){
				
				    return "";
				
				}
				public String DI_CreatedDatePattern(){
				
					return "dd-MM-yyyy";
				
				}
				public String DI_CreatedDateOriginalDbColumnName(){
				
					return "DI_CreatedDate";
				
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
			if(length > commonByteArray_FINAL_PROJECT_json_staging_job.length) {
				if(length < 1024 && commonByteArray_FINAL_PROJECT_json_staging_job.length == 0) {
   					commonByteArray_FINAL_PROJECT_json_staging_job = new byte[1024];
				} else {
   					commonByteArray_FINAL_PROJECT_json_staging_job = new byte[2 * length];
   				}
			}
			dis.readFully(commonByteArray_FINAL_PROJECT_json_staging_job, 0, length);
			strReturn = new String(commonByteArray_FINAL_PROJECT_json_staging_job, 0, length, utf8Charset);
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
			if(length > commonByteArray_FINAL_PROJECT_json_staging_job.length) {
				if(length < 1024 && commonByteArray_FINAL_PROJECT_json_staging_job.length == 0) {
   					commonByteArray_FINAL_PROJECT_json_staging_job = new byte[1024];
				} else {
   					commonByteArray_FINAL_PROJECT_json_staging_job = new byte[2 * length];
   				}
			}
			unmarshaller.readFully(commonByteArray_FINAL_PROJECT_json_staging_job, 0, length);
			strReturn = new String(commonByteArray_FINAL_PROJECT_json_staging_job, 0, length, utf8Charset);
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

		synchronized(commonByteArrayLock_FINAL_PROJECT_json_staging_job) {

        	try {

        		int length = 0;
		
					this.nconst = readString(dis);
					
					this.primaryName = readString(dis);
					
					this.birthYear = readString(dis);
					
					this.deathYear = readString(dis);
					
					this.primaryProfession = readString(dis);
					
					this.knownForTitles = readString(dis);
					
					this.DI_CreatedDate = readDate(dis);
					
					this.DI_WorkflowJobId = readString(dis);
					
        	} catch (IOException e) {
	            throw new RuntimeException(e);

		

        }

		

      }


    }
    
    public void readData(org.jboss.marshalling.Unmarshaller dis) {

		synchronized(commonByteArrayLock_FINAL_PROJECT_json_staging_job) {

        	try {

        		int length = 0;
		
					this.nconst = readString(dis);
					
					this.primaryName = readString(dis);
					
					this.birthYear = readString(dis);
					
					this.deathYear = readString(dis);
					
					this.primaryProfession = readString(dis);
					
					this.knownForTitles = readString(dis);
					
					this.DI_CreatedDate = readDate(dis);
					
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
				
						writeDate(this.DI_CreatedDate,dos);
					
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
				
						writeDate(this.DI_CreatedDate,dos);
					
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
		sb.append(",DI_CreatedDate="+String.valueOf(DI_CreatedDate));
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
        		
        				if(DI_CreatedDate == null){
        					sb.append("<null>");
        				}else{
            				sb.append(DI_CreatedDate);
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
    public int compareTo(toMySqlStruct other) {

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
    final static byte[] commonByteArrayLock_FINAL_PROJECT_json_staging_job = new byte[0];
    static byte[] commonByteArray_FINAL_PROJECT_json_staging_job = new byte[0];

	
			    public String nconst;

				public String getNconst () {
					return this.nconst;
				}

				public Boolean nconstIsNullable(){
				    return true;
				}
				public Boolean nconstIsKey(){
				    return false;
				}
				public Integer nconstLength(){
				    return 12;
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
				    return 55;
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
				    return 5;
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
				    return 5;
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
				    return 30;
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
				    return 50;
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

				



	private String readString(ObjectInputStream dis) throws IOException{
		String strReturn = null;
		int length = 0;
        length = dis.readInt();
		if (length == -1) {
			strReturn = null;
		} else {
			if(length > commonByteArray_FINAL_PROJECT_json_staging_job.length) {
				if(length < 1024 && commonByteArray_FINAL_PROJECT_json_staging_job.length == 0) {
   					commonByteArray_FINAL_PROJECT_json_staging_job = new byte[1024];
				} else {
   					commonByteArray_FINAL_PROJECT_json_staging_job = new byte[2 * length];
   				}
			}
			dis.readFully(commonByteArray_FINAL_PROJECT_json_staging_job, 0, length);
			strReturn = new String(commonByteArray_FINAL_PROJECT_json_staging_job, 0, length, utf8Charset);
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
			if(length > commonByteArray_FINAL_PROJECT_json_staging_job.length) {
				if(length < 1024 && commonByteArray_FINAL_PROJECT_json_staging_job.length == 0) {
   					commonByteArray_FINAL_PROJECT_json_staging_job = new byte[1024];
				} else {
   					commonByteArray_FINAL_PROJECT_json_staging_job = new byte[2 * length];
   				}
			}
			unmarshaller.readFully(commonByteArray_FINAL_PROJECT_json_staging_job, 0, length);
			strReturn = new String(commonByteArray_FINAL_PROJECT_json_staging_job, 0, length, utf8Charset);
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

    public void readData(ObjectInputStream dis) {

		synchronized(commonByteArrayLock_FINAL_PROJECT_json_staging_job) {

        	try {

        		int length = 0;
		
					this.nconst = readString(dis);
					
					this.primaryName = readString(dis);
					
					this.birthYear = readString(dis);
					
					this.deathYear = readString(dis);
					
					this.primaryProfession = readString(dis);
					
					this.knownForTitles = readString(dis);
					
        	} catch (IOException e) {
	            throw new RuntimeException(e);

		

        }

		

      }


    }
    
    public void readData(org.jboss.marshalling.Unmarshaller dis) {

		synchronized(commonByteArrayLock_FINAL_PROJECT_json_staging_job) {

        	try {

        		int length = 0;
		
					this.nconst = readString(dis);
					
					this.primaryName = readString(dis);
					
					this.birthYear = readString(dis);
					
					this.deathYear = readString(dis);
					
					this.primaryProfession = readString(dis);
					
					this.knownForTitles = readString(dis);
					
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

public void tFileInputJSON_1Process(final java.util.Map<String, Object> globalMap) throws TalendException {
	globalMap.put("tFileInputJSON_1_SUBPROCESS_STATE", 0);

 final boolean execStat = this.execStat;
	
		mdcInfo.forEach(org.slf4j.MDC::put);
		org.slf4j.MDC.put("_subJobName", "tFileInputJSON_1");
		org.slf4j.MDC.put("_subJobPid", "6wo1tk_" + subJobPidCounter.getAndIncrement());
	

	
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
toLogStruct toLog = new toLogStruct();
toMySqlStruct toMySql = new toMySqlStruct();





	
	/**
	 * [tLogRow_1 begin ] start
	 */

	

	
		
		ok_Hash.put("tLogRow_1", false);
		start_Hash.put("tLogRow_1", System.currentTimeMillis());
		
	
	currentComponent="tLogRow_1";
	
	
			runStat.updateStatAndLog(execStat,enableLogStash,resourceMap,iterateId,0,0,"toLog");
			
		int tos_count_tLogRow_1 = 0;
		
                if(log.isDebugEnabled())
            log.debug("tLogRow_1 - "  + ("Start to work.") );
            if (log.isDebugEnabled()) {
                class BytesLimit65535_tLogRow_1{
                    public void limitLog4jByte() throws Exception{
                    StringBuilder log4jParamters_tLogRow_1 = new StringBuilder();
                    log4jParamters_tLogRow_1.append("Parameters:");
                            log4jParamters_tLogRow_1.append("BASIC_MODE" + " = " + "false");
                        log4jParamters_tLogRow_1.append(" | ");
                            log4jParamters_tLogRow_1.append("TABLE_PRINT" + " = " + "true");
                        log4jParamters_tLogRow_1.append(" | ");
                            log4jParamters_tLogRow_1.append("VERTICAL" + " = " + "false");
                        log4jParamters_tLogRow_1.append(" | ");
                            log4jParamters_tLogRow_1.append("PRINT_CONTENT_WITH_LOG4J" + " = " + "true");
                        log4jParamters_tLogRow_1.append(" | ");
                if(log.isDebugEnabled())
            log.debug("tLogRow_1 - "  + (log4jParamters_tLogRow_1) );
                    } 
                } 
            new BytesLimit65535_tLogRow_1().limitLog4jByte();
            }
			if(enableLogStash) {
				talendJobLog.addCM("tLogRow_1", "tLogRow_1", "tLogRow");
				talendJobLogProcess(globalMap);
			}
			

	///////////////////////
	
         class Util_tLogRow_1 {

        String[] des_top = { ".", ".", "-", "+" };

        String[] des_head = { "|=", "=|", "-", "+" };

        String[] des_bottom = { "'", "'", "-", "+" };

        String name="";

        java.util.List<String[]> list = new java.util.ArrayList<String[]>();

        int[] colLengths = new int[6];

        public void addRow(String[] row) {

            for (int i = 0; i < 6; i++) {
                if (row[i]!=null) {
                  colLengths[i] = Math.max(colLengths[i], row[i].length());
                }
            }
            list.add(row);
        }

        public void setTableName(String name) {

            this.name = name;
        }

            public StringBuilder format() {
            
                StringBuilder sb = new StringBuilder();
  
            
                    sb.append(print(des_top));
    
                    int totals = 0;
                    for (int i = 0; i < colLengths.length; i++) {
                        totals = totals + colLengths[i];
                    }
    
                    // name
                    sb.append("|");
                    int k = 0;
                    for (k = 0; k < (totals + 5 - name.length()) / 2; k++) {
                        sb.append(' ');
                    }
                    sb.append(name);
                    for (int i = 0; i < totals + 5 - name.length() - k; i++) {
                        sb.append(' ');
                    }
                    sb.append("|\n");

                    // head and rows
                    sb.append(print(des_head));
                    for (int i = 0; i < list.size(); i++) {
    
                        String[] row = list.get(i);
    
                        java.util.Formatter formatter = new java.util.Formatter(new StringBuilder());
                        
                        StringBuilder sbformat = new StringBuilder();                                             
        			        sbformat.append("|%1$-");
        			        sbformat.append(colLengths[0]);
        			        sbformat.append("s");
        			              
        			        sbformat.append("|%2$-");
        			        sbformat.append(colLengths[1]);
        			        sbformat.append("s");
        			              
        			        sbformat.append("|%3$-");
        			        sbformat.append(colLengths[2]);
        			        sbformat.append("s");
        			              
        			        sbformat.append("|%4$-");
        			        sbformat.append(colLengths[3]);
        			        sbformat.append("s");
        			              
        			        sbformat.append("|%5$-");
        			        sbformat.append(colLengths[4]);
        			        sbformat.append("s");
        			              
        			        sbformat.append("|%6$-");
        			        sbformat.append(colLengths[5]);
        			        sbformat.append("s");
        			                      
                        sbformat.append("|\n");                    
       
                        formatter.format(sbformat.toString(), (Object[])row);	
                                
                        sb.append(formatter.toString());
                        if (i == 0)
                            sb.append(print(des_head)); // print the head
                    }
    
                    // end
                    sb.append(print(des_bottom));
                    return sb;
                }
            

            private StringBuilder print(String[] fillChars) {
                StringBuilder sb = new StringBuilder();
                //first column
                sb.append(fillChars[0]);                
                    for (int i = 0; i < colLengths[0] - fillChars[0].length() + 1; i++) {
                        sb.append(fillChars[2]);
                    }
                    sb.append(fillChars[3]);	                

                    for (int i = 0; i < colLengths[1] - fillChars[3].length() + 1; i++) {
                        sb.append(fillChars[2]);
                    }
                    sb.append(fillChars[3]);
                    for (int i = 0; i < colLengths[2] - fillChars[3].length() + 1; i++) {
                        sb.append(fillChars[2]);
                    }
                    sb.append(fillChars[3]);
                    for (int i = 0; i < colLengths[3] - fillChars[3].length() + 1; i++) {
                        sb.append(fillChars[2]);
                    }
                    sb.append(fillChars[3]);
                    for (int i = 0; i < colLengths[4] - fillChars[3].length() + 1; i++) {
                        sb.append(fillChars[2]);
                    }
                    sb.append(fillChars[3]);
                
                    //last column
                    for (int i = 0; i < colLengths[5] - fillChars[1].length() + 1; i++) {
                        sb.append(fillChars[2]);
                    }         
                sb.append(fillChars[1]);
                sb.append("\n");               
                return sb;
            }
            
            public boolean isTableEmpty(){
            	if (list.size() > 1)
            		return false;
            	return true;
            }
        }
        Util_tLogRow_1 util_tLogRow_1 = new Util_tLogRow_1();
        util_tLogRow_1.setTableName("tLogRow_1");
        util_tLogRow_1.addRow(new String[]{"nconst","primaryName","birthYear","deathYear","primaryProfession","knownForTitles",});        
 		StringBuilder strBuffer_tLogRow_1 = null;
		int nb_line_tLogRow_1 = 0;
///////////////////////    			



 



/**
 * [tLogRow_1 begin ] stop
 */




	
	/**
	 * [tDBOutput_1 begin ] start
	 */

	

	
		
		ok_Hash.put("tDBOutput_1", false);
		start_Hash.put("tDBOutput_1", System.currentTimeMillis());
		
	
	currentComponent="tDBOutput_1";
	
	
			cLabel="new_name_basics table";
		
			runStat.updateStatAndLog(execStat,enableLogStash,resourceMap,iterateId,0,0,"toMySql");
			
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
                            log4jParamters_tDBOutput_1.append("TABLE" + " = " + "\"new_name_basics\"");
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
				talendJobLog.addCM("tDBOutput_1", "new_name_basics table", "tMysqlOutput");
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

String tableName_tDBOutput_1 = "new_name_basics";
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
                                    if(table_tDBOutput_1.equalsIgnoreCase("new_name_basics")) {
                                        whetherExist_tDBOutput_1 = true;
                                        break;
                                    }
                                }
                                if(!whetherExist_tDBOutput_1) {
                                    try (java.sql.Statement stmtCreate_tDBOutput_1 = conn_tDBOutput_1.createStatement()) {
                if(log.isDebugEnabled())
            log.debug("tDBOutput_1 - "  + ("Creating")  + (" table '")  + (tableName_tDBOutput_1)  + ("'.") );
                                        stmtCreate_tDBOutput_1.execute("CREATE TABLE `" + tableName_tDBOutput_1 + "`(`nconst` VARCHAR(12)  ,`primaryName` VARCHAR(55)  ,`birthYear` VARCHAR(5)  ,`deathYear` VARCHAR(5)  ,`primaryProfession` VARCHAR(30)  ,`knownForTitles` VARCHAR(50)  ,`DI_CreatedDate` DATETIME ,`DI_WorkflowJobId` VARCHAR(8)  )");
                if(log.isDebugEnabled())
            log.debug("tDBOutput_1 - "  + ("Create")  + (" table '")  + (tableName_tDBOutput_1)  + ("' has succeeded.") );
                                    }
                                }
			

		
						String insert_tDBOutput_1 = "INSERT INTO `" + "new_name_basics" + "` (`nconst`,`primaryName`,`birthYear`,`deathYear`,`primaryProfession`,`knownForTitles`,`DI_CreatedDate`,`DI_WorkflowJobId`) VALUES (?,?,?,?,?,?,?,?)";
		
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
				int count_toLog_tMap_1 = 0;
				
toLogStruct toLog_tmp = new toLogStruct();
				int count_toMySql_tMap_1 = 0;
				
toMySqlStruct toMySql_tmp = new toMySqlStruct();
// ###############################

        
        



        









 



/**
 * [tMap_1 begin ] stop
 */



	
	/**
	 * [tFileInputJSON_1 begin ] start
	 */

	

	
		
		ok_Hash.put("tFileInputJSON_1", false);
		start_Hash.put("tFileInputJSON_1", System.currentTimeMillis());
		
	
	currentComponent="tFileInputJSON_1";
	
	
			cLabel="New Name - Json Load";
		
		int tos_count_tFileInputJSON_1 = 0;
		
                if(log.isDebugEnabled())
            log.debug("tFileInputJSON_1 - "  + ("Start to work.") );
            if (log.isDebugEnabled()) {
                class BytesLimit65535_tFileInputJSON_1{
                    public void limitLog4jByte() throws Exception{
                    StringBuilder log4jParamters_tFileInputJSON_1 = new StringBuilder();
                    log4jParamters_tFileInputJSON_1.append("Parameters:");
                            log4jParamters_tFileInputJSON_1.append("READ_BY" + " = " + "JSONPATH");
                        log4jParamters_tFileInputJSON_1.append(" | ");
                            log4jParamters_tFileInputJSON_1.append("JSON_PATH_VERSION" + " = " + "2_1_0");
                        log4jParamters_tFileInputJSON_1.append(" | ");
                            log4jParamters_tFileInputJSON_1.append("USEURL" + " = " + "false");
                        log4jParamters_tFileInputJSON_1.append(" | ");
                            log4jParamters_tFileInputJSON_1.append("FILENAME" + " = " + "context.new_name_file_path");
                        log4jParamters_tFileInputJSON_1.append(" | ");
                            log4jParamters_tFileInputJSON_1.append("JSON_LOOP_QUERY" + " = " + "\"$.[*]\"");
                        log4jParamters_tFileInputJSON_1.append(" | ");
                            log4jParamters_tFileInputJSON_1.append("MAPPING_JSONPATH" + " = " + "[{QUERY="+("\"$.nconst\"")+", SCHEMA_COLUMN="+("nconst")+"}, {QUERY="+("\"$.primaryName\"")+", SCHEMA_COLUMN="+("primaryName")+"}, {QUERY="+("\"$.birthYear\"")+", SCHEMA_COLUMN="+("birthYear")+"}, {QUERY="+("\"$.deathYear\"")+", SCHEMA_COLUMN="+("deathYear")+"}, {QUERY="+("\"$.primaryProfession\"")+", SCHEMA_COLUMN="+("primaryProfession")+"}, {QUERY="+("\"$.knownForTitles\"")+", SCHEMA_COLUMN="+("knownForTitles")+"}]");
                        log4jParamters_tFileInputJSON_1.append(" | ");
                            log4jParamters_tFileInputJSON_1.append("DIE_ON_ERROR" + " = " + "false");
                        log4jParamters_tFileInputJSON_1.append(" | ");
                            log4jParamters_tFileInputJSON_1.append("ADVANCED_SEPARATOR" + " = " + "false");
                        log4jParamters_tFileInputJSON_1.append(" | ");
                            log4jParamters_tFileInputJSON_1.append("USE_LOOP_AS_ROOT" + " = " + "true");
                        log4jParamters_tFileInputJSON_1.append(" | ");
                            log4jParamters_tFileInputJSON_1.append("ENCODING" + " = " + "\"UTF-8\"");
                        log4jParamters_tFileInputJSON_1.append(" | ");
                if(log.isDebugEnabled())
            log.debug("tFileInputJSON_1 - "  + (log4jParamters_tFileInputJSON_1) );
                    } 
                } 
            new BytesLimit65535_tFileInputJSON_1().limitLog4jByte();
            }
			if(enableLogStash) {
				talendJobLog.addCM("tFileInputJSON_1", "New Name - Json Load", "tFileInputJSON");
				talendJobLogProcess(globalMap);
			}
			

	
class JsonPathCache_tFileInputJSON_1 {
	final java.util.Map<String,com.jayway.jsonpath.JsonPath> jsonPathString2compiledJsonPath = new java.util.HashMap<String,com.jayway.jsonpath.JsonPath>();
	
	public com.jayway.jsonpath.JsonPath getCompiledJsonPath(String jsonPath) {
		if(jsonPathString2compiledJsonPath.containsKey(jsonPath)) {
			return jsonPathString2compiledJsonPath.get(jsonPath);
		} else {
			com.jayway.jsonpath.JsonPath compiledLoopPath = com.jayway.jsonpath.JsonPath.compile(jsonPath);
			jsonPathString2compiledJsonPath.put(jsonPath,compiledLoopPath);
			return compiledLoopPath;
		}
	}
}

int nb_line_tFileInputJSON_1 = 0;

JsonPathCache_tFileInputJSON_1 jsonPathCache_tFileInputJSON_1 = new JsonPathCache_tFileInputJSON_1();

String loopPath_tFileInputJSON_1 = "$.[*]";
java.util.List<Object> resultset_tFileInputJSON_1 = new java.util.ArrayList<Object>();

java.io.InputStream is_tFileInputJSON_1 = null;
com.jayway.jsonpath.ParseContext parseContext_tFileInputJSON_1 = com.jayway.jsonpath.JsonPath.using(com.jayway.jsonpath.Configuration.defaultConfiguration());
Object filenameOrStream_tFileInputJSON_1 = null;
        try {
            filenameOrStream_tFileInputJSON_1 = context.new_name_file_path;
        } catch(java.lang.Exception e_tFileInputJSON_1) {
globalMap.put("tFileInputJSON_1_ERROR_MESSAGE",e_tFileInputJSON_1.getMessage());
				
					log.error("tFileInputJSON_1 - " + e_tFileInputJSON_1.getMessage());
				
	            globalMap.put("tFileInputJSON_1_ERROR_MESSAGE", e_tFileInputJSON_1.getMessage());
	            System.err.println(e_tFileInputJSON_1.getMessage());
        }
        
com.jayway.jsonpath.ReadContext document_tFileInputJSON_1 = null;
try {
     if(filenameOrStream_tFileInputJSON_1 instanceof java.io.InputStream){
         is_tFileInputJSON_1 = (java.io.InputStream)filenameOrStream_tFileInputJSON_1;
     }else{
	    
	        is_tFileInputJSON_1 = new java.io.FileInputStream((String)filenameOrStream_tFileInputJSON_1);
	    
	 }
	
	
	document_tFileInputJSON_1 = parseContext_tFileInputJSON_1.parse(is_tFileInputJSON_1,"UTF-8");
	com.jayway.jsonpath.JsonPath compiledLoopPath_tFileInputJSON_1 = jsonPathCache_tFileInputJSON_1.getCompiledJsonPath(loopPath_tFileInputJSON_1);
	Object result_tFileInputJSON_1 = document_tFileInputJSON_1.read(compiledLoopPath_tFileInputJSON_1,net.minidev.json.JSONObject.class);
	if (result_tFileInputJSON_1 instanceof net.minidev.json.JSONArray) {
		resultset_tFileInputJSON_1 = (net.minidev.json.JSONArray) result_tFileInputJSON_1;
	} else {
		resultset_tFileInputJSON_1.add(result_tFileInputJSON_1);
	}
} catch (java.lang.Exception e_tFileInputJSON_1) {
globalMap.put("tFileInputJSON_1_ERROR_MESSAGE",e_tFileInputJSON_1.getMessage());
	log.error("tFileInputJSON_1 - " + e_tFileInputJSON_1.getMessage());
	
	globalMap.put("tFileInputJSON_1_ERROR_MESSAGE", e_tFileInputJSON_1.getMessage());
	System.err.println(e_tFileInputJSON_1.getMessage());
} finally {
	if(is_tFileInputJSON_1 != null) {
		is_tFileInputJSON_1.close();
	}
}

String jsonPath_tFileInputJSON_1 = null;
com.jayway.jsonpath.JsonPath compiledJsonPath_tFileInputJSON_1 = null;

Object value_tFileInputJSON_1 = null;
	log.info("tFileInputJSON_1 - Retrieving records from data.");
Object root_tFileInputJSON_1 = null;
for(Object row_tFileInputJSON_1 : resultset_tFileInputJSON_1) {
	nb_line_tFileInputJSON_1++;
				log.debug("tFileInputJSON_1 - Retrieving the record " + (nb_line_tFileInputJSON_1) + ".");
			
			row1 = null;			
	boolean whetherReject_tFileInputJSON_1 = false;
	row1 = new row1Struct();
	
	try{
				jsonPath_tFileInputJSON_1 = "$.nconst";
				compiledJsonPath_tFileInputJSON_1 = jsonPathCache_tFileInputJSON_1.getCompiledJsonPath(jsonPath_tFileInputJSON_1);
				
				try {
				   
				       value_tFileInputJSON_1 = compiledJsonPath_tFileInputJSON_1.read(row_tFileInputJSON_1);
				   
						row1.nconst = value_tFileInputJSON_1 == null ? 

		null
 : value_tFileInputJSON_1.toString();
				} catch (com.jayway.jsonpath.PathNotFoundException e_tFileInputJSON_1) {
globalMap.put("tFileInputJSON_1_ERROR_MESSAGE",e_tFileInputJSON_1.getMessage());
					row1.nconst = 

		null
;
				}				
				jsonPath_tFileInputJSON_1 = "$.primaryName";
				compiledJsonPath_tFileInputJSON_1 = jsonPathCache_tFileInputJSON_1.getCompiledJsonPath(jsonPath_tFileInputJSON_1);
				
				try {
				   
				       value_tFileInputJSON_1 = compiledJsonPath_tFileInputJSON_1.read(row_tFileInputJSON_1);
				   
						row1.primaryName = value_tFileInputJSON_1 == null ? 

		null
 : value_tFileInputJSON_1.toString();
				} catch (com.jayway.jsonpath.PathNotFoundException e_tFileInputJSON_1) {
globalMap.put("tFileInputJSON_1_ERROR_MESSAGE",e_tFileInputJSON_1.getMessage());
					row1.primaryName = 

		null
;
				}				
				jsonPath_tFileInputJSON_1 = "$.birthYear";
				compiledJsonPath_tFileInputJSON_1 = jsonPathCache_tFileInputJSON_1.getCompiledJsonPath(jsonPath_tFileInputJSON_1);
				
				try {
				   
				       value_tFileInputJSON_1 = compiledJsonPath_tFileInputJSON_1.read(row_tFileInputJSON_1);
				   
						row1.birthYear = value_tFileInputJSON_1 == null ? 

		null
 : value_tFileInputJSON_1.toString();
				} catch (com.jayway.jsonpath.PathNotFoundException e_tFileInputJSON_1) {
globalMap.put("tFileInputJSON_1_ERROR_MESSAGE",e_tFileInputJSON_1.getMessage());
					row1.birthYear = 

		null
;
				}				
				jsonPath_tFileInputJSON_1 = "$.deathYear";
				compiledJsonPath_tFileInputJSON_1 = jsonPathCache_tFileInputJSON_1.getCompiledJsonPath(jsonPath_tFileInputJSON_1);
				
				try {
				   
				       value_tFileInputJSON_1 = compiledJsonPath_tFileInputJSON_1.read(row_tFileInputJSON_1);
				   
						row1.deathYear = value_tFileInputJSON_1 == null ? 

		null
 : value_tFileInputJSON_1.toString();
				} catch (com.jayway.jsonpath.PathNotFoundException e_tFileInputJSON_1) {
globalMap.put("tFileInputJSON_1_ERROR_MESSAGE",e_tFileInputJSON_1.getMessage());
					row1.deathYear = 

		null
;
				}				
				jsonPath_tFileInputJSON_1 = "$.primaryProfession";
				compiledJsonPath_tFileInputJSON_1 = jsonPathCache_tFileInputJSON_1.getCompiledJsonPath(jsonPath_tFileInputJSON_1);
				
				try {
				   
				       value_tFileInputJSON_1 = compiledJsonPath_tFileInputJSON_1.read(row_tFileInputJSON_1);
				   
						row1.primaryProfession = value_tFileInputJSON_1 == null ? 

		null
 : value_tFileInputJSON_1.toString();
				} catch (com.jayway.jsonpath.PathNotFoundException e_tFileInputJSON_1) {
globalMap.put("tFileInputJSON_1_ERROR_MESSAGE",e_tFileInputJSON_1.getMessage());
					row1.primaryProfession = 

		null
;
				}				
				jsonPath_tFileInputJSON_1 = "$.knownForTitles";
				compiledJsonPath_tFileInputJSON_1 = jsonPathCache_tFileInputJSON_1.getCompiledJsonPath(jsonPath_tFileInputJSON_1);
				
				try {
				   
				       value_tFileInputJSON_1 = compiledJsonPath_tFileInputJSON_1.read(row_tFileInputJSON_1);
				   
						row1.knownForTitles = value_tFileInputJSON_1 == null ? 

		null
 : value_tFileInputJSON_1.toString();
				} catch (com.jayway.jsonpath.PathNotFoundException e_tFileInputJSON_1) {
globalMap.put("tFileInputJSON_1_ERROR_MESSAGE",e_tFileInputJSON_1.getMessage());
					row1.knownForTitles = 

		null
;
				}				
    } catch (java.lang.Exception e_tFileInputJSON_1) {
globalMap.put("tFileInputJSON_1_ERROR_MESSAGE",e_tFileInputJSON_1.getMessage());
        whetherReject_tFileInputJSON_1 = true;
					log.error("tFileInputJSON_1 - " + e_tFileInputJSON_1.getMessage());
				
                System.err.println(e_tFileInputJSON_1.getMessage());
                row1 = null;
            globalMap.put("tFileInputJSON_1_ERROR_MESSAGE", e_tFileInputJSON_1.getMessage());
    }
//}

 



/**
 * [tFileInputJSON_1 begin ] stop
 */
	
	/**
	 * [tFileInputJSON_1 main ] start
	 */

	

	
	
	currentComponent="tFileInputJSON_1";
	
	
			cLabel="New Name - Json Load";
		

 


	tos_count_tFileInputJSON_1++;

/**
 * [tFileInputJSON_1 main ] stop
 */
	
	/**
	 * [tFileInputJSON_1 process_data_begin ] start
	 */

	

	
	
	currentComponent="tFileInputJSON_1";
	
	
			cLabel="New Name - Json Load";
		

 



/**
 * [tFileInputJSON_1 process_data_begin ] stop
 */
// Start of branch "row1"
if(row1 != null) { 



	
	/**
	 * [tMap_1 main ] start
	 */

	

	
	
	currentComponent="tMap_1";
	
	
			if(runStat.update(execStat,enableLogStash,iterateId,1,1
				
					,"row1","tFileInputJSON_1","New Name - Json Load","tFileInputJSON","tMap_1","tMap_1","tMap"
				
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

toLog = null;
toMySql = null;


// # Output table : 'toLog'
count_toLog_tMap_1++;

toLog_tmp.nconst = row1.nconst;
toLog_tmp.primaryName = row1.primaryName;
toLog_tmp.birthYear = row1.birthYear;
toLog_tmp.deathYear = row1.deathYear;
toLog_tmp.primaryProfession = row1.primaryProfession;
toLog_tmp.knownForTitles = row1.knownForTitles;
toLog = toLog_tmp;
log.debug("tMap_1 - Outputting the record " + count_toLog_tMap_1 + " of the output table 'toLog'.");


// # Output table : 'toMySql'
count_toMySql_tMap_1++;

toMySql_tmp.nconst = row1.nconst;
toMySql_tmp.primaryName = row1.primaryName;
toMySql_tmp.birthYear = row1.birthYear;
toMySql_tmp.deathYear = row1.deathYear;
toMySql_tmp.primaryProfession = row1.primaryProfession;
toMySql_tmp.knownForTitles = row1.knownForTitles;
toMySql_tmp.DI_CreatedDate = TalendDate.getCurrentDate();
toMySql_tmp.DI_WorkflowJobId = pid;
toMySql = toMySql_tmp;
log.debug("tMap_1 - Outputting the record " + count_toMySql_tMap_1 + " of the output table 'toMySql'.");

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
// Start of branch "toLog"
if(toLog != null) { 



	
	/**
	 * [tLogRow_1 main ] start
	 */

	

	
	
	currentComponent="tLogRow_1";
	
	
			if(runStat.update(execStat,enableLogStash,iterateId,1,1
				
					,"toLog","tMap_1","tMap_1","tMap","tLogRow_1","tLogRow_1","tLogRow"
				
			)) {
				talendJobLogProcess(globalMap);
			}
			
    			if(log.isTraceEnabled()){
    				log.trace("toLog - " + (toLog==null? "": toLog.toLogString()));
    			}
    		
///////////////////////		
						

				
				String[] row_tLogRow_1 = new String[6];
   				
	    		if(toLog.nconst != null) { //              
                 row_tLogRow_1[0]=    						    
				                String.valueOf(toLog.nconst)			
					          ;	
							
	    		} //			
    			   				
	    		if(toLog.primaryName != null) { //              
                 row_tLogRow_1[1]=    						    
				                String.valueOf(toLog.primaryName)			
					          ;	
							
	    		} //			
    			   				
	    		if(toLog.birthYear != null) { //              
                 row_tLogRow_1[2]=    						    
				                String.valueOf(toLog.birthYear)			
					          ;	
							
	    		} //			
    			   				
	    		if(toLog.deathYear != null) { //              
                 row_tLogRow_1[3]=    						    
				                String.valueOf(toLog.deathYear)			
					          ;	
							
	    		} //			
    			   				
	    		if(toLog.primaryProfession != null) { //              
                 row_tLogRow_1[4]=    						    
				                String.valueOf(toLog.primaryProfession)			
					          ;	
							
	    		} //			
    			   				
	    		if(toLog.knownForTitles != null) { //              
                 row_tLogRow_1[5]=    						    
				                String.valueOf(toLog.knownForTitles)			
					          ;	
							
	    		} //			
    			 

				util_tLogRow_1.addRow(row_tLogRow_1);	
				nb_line_tLogRow_1++;
                	log.info("tLogRow_1 - Content of row "+nb_line_tLogRow_1+": " + TalendString.unionString("|",row_tLogRow_1));
//////

//////                    
                    
///////////////////////    			

 


	tos_count_tLogRow_1++;

/**
 * [tLogRow_1 main ] stop
 */
	
	/**
	 * [tLogRow_1 process_data_begin ] start
	 */

	

	
	
	currentComponent="tLogRow_1";
	
	

 



/**
 * [tLogRow_1 process_data_begin ] stop
 */
	
	/**
	 * [tLogRow_1 process_data_end ] start
	 */

	

	
	
	currentComponent="tLogRow_1";
	
	

 



/**
 * [tLogRow_1 process_data_end ] stop
 */

} // End of branch "toLog"




// Start of branch "toMySql"
if(toMySql != null) { 



	
	/**
	 * [tDBOutput_1 main ] start
	 */

	

	
	
	currentComponent="tDBOutput_1";
	
	
			cLabel="new_name_basics table";
		
			if(runStat.update(execStat,enableLogStash,iterateId,1,1
				
					,"toMySql","tMap_1","tMap_1","tMap","tDBOutput_1","new_name_basics table","tMysqlOutput"
				
			)) {
				talendJobLogProcess(globalMap);
			}
			
    			if(log.isTraceEnabled()){
    				log.trace("toMySql - " + (toMySql==null? "": toMySql.toLogString()));
    			}
    		



        whetherReject_tDBOutput_1 = false;
                            if(toMySql.nconst == null) {
pstmt_tDBOutput_1.setNull(1, java.sql.Types.VARCHAR);
} else {pstmt_tDBOutput_1.setString(1, toMySql.nconst);
}

                            if(toMySql.primaryName == null) {
pstmt_tDBOutput_1.setNull(2, java.sql.Types.VARCHAR);
} else {pstmt_tDBOutput_1.setString(2, toMySql.primaryName);
}

                            if(toMySql.birthYear == null) {
pstmt_tDBOutput_1.setNull(3, java.sql.Types.VARCHAR);
} else {pstmt_tDBOutput_1.setString(3, toMySql.birthYear);
}

                            if(toMySql.deathYear == null) {
pstmt_tDBOutput_1.setNull(4, java.sql.Types.VARCHAR);
} else {pstmt_tDBOutput_1.setString(4, toMySql.deathYear);
}

                            if(toMySql.primaryProfession == null) {
pstmt_tDBOutput_1.setNull(5, java.sql.Types.VARCHAR);
} else {pstmt_tDBOutput_1.setString(5, toMySql.primaryProfession);
}

                            if(toMySql.knownForTitles == null) {
pstmt_tDBOutput_1.setNull(6, java.sql.Types.VARCHAR);
} else {pstmt_tDBOutput_1.setString(6, toMySql.knownForTitles);
}

                            if(toMySql.DI_CreatedDate != null) {
date_tDBOutput_1 = toMySql.DI_CreatedDate.getTime();
if(date_tDBOutput_1 < year1_tDBOutput_1 || date_tDBOutput_1 >= year10000_tDBOutput_1) {
pstmt_tDBOutput_1.setString(7, "0000-00-00 00:00:00");
} else {pstmt_tDBOutput_1.setTimestamp(7, new java.sql.Timestamp(date_tDBOutput_1));
}
} else {
pstmt_tDBOutput_1.setNull(7, java.sql.Types.DATE);
}

                            if(toMySql.DI_WorkflowJobId == null) {
pstmt_tDBOutput_1.setNull(8, java.sql.Types.VARCHAR);
} else {pstmt_tDBOutput_1.setString(8, toMySql.DI_WorkflowJobId);
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
	
	
			cLabel="new_name_basics table";
		

 



/**
 * [tDBOutput_1 process_data_begin ] stop
 */
	
	/**
	 * [tDBOutput_1 process_data_end ] start
	 */

	

	
	
	currentComponent="tDBOutput_1";
	
	
			cLabel="new_name_basics table";
		

 



/**
 * [tDBOutput_1 process_data_end ] stop
 */

} // End of branch "toMySql"




	
	/**
	 * [tMap_1 process_data_end ] start
	 */

	

	
	
	currentComponent="tMap_1";
	
	

 



/**
 * [tMap_1 process_data_end ] stop
 */

} // End of branch "row1"




	
	/**
	 * [tFileInputJSON_1 process_data_end ] start
	 */

	

	
	
	currentComponent="tFileInputJSON_1";
	
	
			cLabel="New Name - Json Load";
		

 



/**
 * [tFileInputJSON_1 process_data_end ] stop
 */
	
	/**
	 * [tFileInputJSON_1 end ] start
	 */

	

	
	
	currentComponent="tFileInputJSON_1";
	
	
			cLabel="New Name - Json Load";
		

	}
	globalMap.put("tFileInputJSON_1_NB_LINE",nb_line_tFileInputJSON_1);
				log.debug("tFileInputJSON_1 - Retrieved records count: "+ nb_line_tFileInputJSON_1 + " .");
			
 
                if(log.isDebugEnabled())
            log.debug("tFileInputJSON_1 - "  + ("Done.") );

ok_Hash.put("tFileInputJSON_1", true);
end_Hash.put("tFileInputJSON_1", System.currentTimeMillis());




/**
 * [tFileInputJSON_1 end ] stop
 */

	
	/**
	 * [tMap_1 end ] start
	 */

	

	
	
	currentComponent="tMap_1";
	
	


// ###############################
// # Lookup hashes releasing
// ###############################      
				log.debug("tMap_1 - Written records count in the table 'toLog': " + count_toLog_tMap_1 + ".");
				log.debug("tMap_1 - Written records count in the table 'toMySql': " + count_toMySql_tMap_1 + ".");





			 		if(runStat.updateStatAndLog(execStat,enableLogStash,resourceMap,iterateId,"row1",2,0,
			 			"tFileInputJSON_1","New Name - Json Load","tFileInputJSON","tMap_1","tMap_1","tMap","output")) {
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
	 * [tLogRow_1 end ] start
	 */

	

	
	
	currentComponent="tLogRow_1";
	
	


//////

                    
                    java.io.PrintStream consoleOut_tLogRow_1 = null;
                    if (globalMap.get("tLogRow_CONSOLE")!=null)
                    {
                    	consoleOut_tLogRow_1 = (java.io.PrintStream) globalMap.get("tLogRow_CONSOLE");
                    }
                    else
                    {
                    	consoleOut_tLogRow_1 = new java.io.PrintStream(new java.io.BufferedOutputStream(System.out));
                    	globalMap.put("tLogRow_CONSOLE",consoleOut_tLogRow_1);
                    }
                    
                    consoleOut_tLogRow_1.println(util_tLogRow_1.format().toString());
                    consoleOut_tLogRow_1.flush();
//////
globalMap.put("tLogRow_1_NB_LINE",nb_line_tLogRow_1);
                if(log.isInfoEnabled())
            log.info("tLogRow_1 - "  + ("Printed row count: ")  + (nb_line_tLogRow_1)  + (".") );

///////////////////////    			

			 		if(runStat.updateStatAndLog(execStat,enableLogStash,resourceMap,iterateId,"toLog",2,0,
			 			"tMap_1","tMap_1","tMap","tLogRow_1","tLogRow_1","tLogRow","output")) {
						talendJobLogProcess(globalMap);
					}
				
 
                if(log.isDebugEnabled())
            log.debug("tLogRow_1 - "  + ("Done.") );

ok_Hash.put("tLogRow_1", true);
end_Hash.put("tLogRow_1", System.currentTimeMillis());




/**
 * [tLogRow_1 end ] stop
 */




	
	/**
	 * [tDBOutput_1 end ] start
	 */

	

	
	
	currentComponent="tDBOutput_1";
	
	
			cLabel="new_name_basics table";
		



				
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

			 		if(runStat.updateStatAndLog(execStat,enableLogStash,resourceMap,iterateId,"toMySql",2,0,
			 			"tMap_1","tMap_1","tMap","tDBOutput_1","new_name_basics table","tMysqlOutput","output")) {
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
				    				resumeUtil.addLog("CHECKPOINT", "CONNECTION:SUBJOB_OK:tFileInputJSON_1:OnSubjobOk", "", Thread.currentThread().getId() + "", "", "", "", "", "");
								}	    				    			
					    	
								if(execStat){    	
									runStat.updateStatOnConnection("OnSubjobOk1", 0, "ok");
								} 
							
							tFileInputJSON_2Process(globalMap); 
						



	
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
	 * [tFileInputJSON_1 finally ] start
	 */

	

	
	
	currentComponent="tFileInputJSON_1";
	
	
			cLabel="New Name - Json Load";
		

 



/**
 * [tFileInputJSON_1 finally ] stop
 */

	
	/**
	 * [tMap_1 finally ] start
	 */

	

	
	
	currentComponent="tMap_1";
	
	

 



/**
 * [tMap_1 finally ] stop
 */

	
	/**
	 * [tLogRow_1 finally ] start
	 */

	

	
	
	currentComponent="tLogRow_1";
	
	

 



/**
 * [tLogRow_1 finally ] stop
 */




	
	/**
	 * [tDBOutput_1 finally ] start
	 */

	

	
	
	currentComponent="tDBOutput_1";
	
	
			cLabel="new_name_basics table";
		



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
		

		globalMap.put("tFileInputJSON_1_SUBPROCESS_STATE", 1);
	}
	


public static class copyOftoLogStruct implements routines.system.IPersistableRow<copyOftoLogStruct> {
    final static byte[] commonByteArrayLock_FINAL_PROJECT_json_staging_job = new byte[0];
    static byte[] commonByteArray_FINAL_PROJECT_json_staging_job = new byte[0];

	
			    public String tconst;

				public String getTconst () {
					return this.tconst;
				}

				public Boolean tconstIsNullable(){
				    return true;
				}
				public Boolean tconstIsKey(){
				    return false;
				}
				public Integer tconstLength(){
				    return 12;
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
				    return 7;
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
				    return 40;
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
				    return 40;
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

				
			    public Integer isAdult;

				public Integer getIsAdult () {
					return this.isAdult;
				}

				public Boolean isAdultIsNullable(){
				    return true;
				}
				public Boolean isAdultIsKey(){
				    return false;
				}
				public Integer isAdultLength(){
				    return null;
				}
				public Integer isAdultPrecision(){
				    return 0;
				}
				public String isAdultDefault(){
				
					return null;
				
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
				    return 4;
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
				    return 35;
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

				



	private String readString(ObjectInputStream dis) throws IOException{
		String strReturn = null;
		int length = 0;
        length = dis.readInt();
		if (length == -1) {
			strReturn = null;
		} else {
			if(length > commonByteArray_FINAL_PROJECT_json_staging_job.length) {
				if(length < 1024 && commonByteArray_FINAL_PROJECT_json_staging_job.length == 0) {
   					commonByteArray_FINAL_PROJECT_json_staging_job = new byte[1024];
				} else {
   					commonByteArray_FINAL_PROJECT_json_staging_job = new byte[2 * length];
   				}
			}
			dis.readFully(commonByteArray_FINAL_PROJECT_json_staging_job, 0, length);
			strReturn = new String(commonByteArray_FINAL_PROJECT_json_staging_job, 0, length, utf8Charset);
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
			if(length > commonByteArray_FINAL_PROJECT_json_staging_job.length) {
				if(length < 1024 && commonByteArray_FINAL_PROJECT_json_staging_job.length == 0) {
   					commonByteArray_FINAL_PROJECT_json_staging_job = new byte[1024];
				} else {
   					commonByteArray_FINAL_PROJECT_json_staging_job = new byte[2 * length];
   				}
			}
			unmarshaller.readFully(commonByteArray_FINAL_PROJECT_json_staging_job, 0, length);
			strReturn = new String(commonByteArray_FINAL_PROJECT_json_staging_job, 0, length, utf8Charset);
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
	private Integer readInteger(ObjectInputStream dis) throws IOException{
		Integer intReturn;
        int length = 0;
        length = dis.readByte();
		if (length == -1) {
			intReturn = null;
		} else {
	    	intReturn = dis.readInt();
		}
		return intReturn;
	}
	
	private Integer readInteger(org.jboss.marshalling.Unmarshaller dis) throws IOException{
		Integer intReturn;
        int length = 0;
        length = dis.readByte();
		if (length == -1) {
			intReturn = null;
		} else {
	    	intReturn = dis.readInt();
		}
		return intReturn;
	}

	private void writeInteger(Integer intNum, ObjectOutputStream dos) throws IOException{
		if(intNum == null) {
            dos.writeByte(-1);
		} else {
			dos.writeByte(0);
	    	dos.writeInt(intNum);
    	}
	}
	
	private void writeInteger(Integer intNum, org.jboss.marshalling.Marshaller marshaller) throws IOException{
		if(intNum == null) {
			marshaller.writeByte(-1);
		} else {
			marshaller.writeByte(0);
			marshaller.writeInt(intNum);
    	}
	}

    public void readData(ObjectInputStream dis) {

		synchronized(commonByteArrayLock_FINAL_PROJECT_json_staging_job) {

        	try {

        		int length = 0;
		
					this.tconst = readString(dis);
					
					this.titleType = readString(dis);
					
					this.primaryTitle = readString(dis);
					
					this.originalTitle = readString(dis);
					
						this.isAdult = readInteger(dis);
					
					this.startYear = readString(dis);
					
					this.endYear = readString(dis);
					
					this.runtimeMinutes = readString(dis);
					
					this.genres = readString(dis);
					
        	} catch (IOException e) {
	            throw new RuntimeException(e);

		

        }

		

      }


    }
    
    public void readData(org.jboss.marshalling.Unmarshaller dis) {

		synchronized(commonByteArrayLock_FINAL_PROJECT_json_staging_job) {

        	try {

        		int length = 0;
		
					this.tconst = readString(dis);
					
					this.titleType = readString(dis);
					
					this.primaryTitle = readString(dis);
					
					this.originalTitle = readString(dis);
					
						this.isAdult = readInteger(dis);
					
					this.startYear = readString(dis);
					
					this.endYear = readString(dis);
					
					this.runtimeMinutes = readString(dis);
					
					this.genres = readString(dis);
					
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
					
					// Integer
				
						writeInteger(this.isAdult,dos);
					
					// String
				
						writeString(this.startYear,dos);
					
					// String
				
						writeString(this.endYear,dos);
					
					// String
				
						writeString(this.runtimeMinutes,dos);
					
					// String
				
						writeString(this.genres,dos);
					
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
					
					// Integer
				
						writeInteger(this.isAdult,dos);
					
					// String
				
						writeString(this.startYear,dos);
					
					// String
				
						writeString(this.endYear,dos);
					
					// String
				
						writeString(this.runtimeMinutes,dos);
					
					// String
				
						writeString(this.genres,dos);
					
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
        		
        	return sb.toString();
        }

    /**
     * Compare keys
     */
    public int compareTo(copyOftoLogStruct other) {

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

public static class copyOftoMySqlStruct implements routines.system.IPersistableRow<copyOftoMySqlStruct> {
    final static byte[] commonByteArrayLock_FINAL_PROJECT_json_staging_job = new byte[0];
    static byte[] commonByteArray_FINAL_PROJECT_json_staging_job = new byte[0];

	
			    public String tconst;

				public String getTconst () {
					return this.tconst;
				}

				public Boolean tconstIsNullable(){
				    return true;
				}
				public Boolean tconstIsKey(){
				    return false;
				}
				public Integer tconstLength(){
				    return 12;
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
				    return 7;
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
				    return 75;
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
				    return 75;
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

				
			    public Integer isAdult;

				public Integer getIsAdult () {
					return this.isAdult;
				}

				public Boolean isAdultIsNullable(){
				    return true;
				}
				public Boolean isAdultIsKey(){
				    return false;
				}
				public Integer isAdultLength(){
				    return null;
				}
				public Integer isAdultPrecision(){
				    return 0;
				}
				public String isAdultDefault(){
				
					return null;
				
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
				    return 4;
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
				    return 35;
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

				
			    public java.util.Date DI_CreatedDate;

				public java.util.Date getDI_CreatedDate () {
					return this.DI_CreatedDate;
				}

				public Boolean DI_CreatedDateIsNullable(){
				    return true;
				}
				public Boolean DI_CreatedDateIsKey(){
				    return false;
				}
				public Integer DI_CreatedDateLength(){
				    return null;
				}
				public Integer DI_CreatedDatePrecision(){
				    return null;
				}
				public String DI_CreatedDateDefault(){
				
					return null;
				
				}
				public String DI_CreatedDateComment(){
				
				    return "";
				
				}
				public String DI_CreatedDatePattern(){
				
					return "dd-MM-yyyy";
				
				}
				public String DI_CreatedDateOriginalDbColumnName(){
				
					return "DI_CreatedDate";
				
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
			if(length > commonByteArray_FINAL_PROJECT_json_staging_job.length) {
				if(length < 1024 && commonByteArray_FINAL_PROJECT_json_staging_job.length == 0) {
   					commonByteArray_FINAL_PROJECT_json_staging_job = new byte[1024];
				} else {
   					commonByteArray_FINAL_PROJECT_json_staging_job = new byte[2 * length];
   				}
			}
			dis.readFully(commonByteArray_FINAL_PROJECT_json_staging_job, 0, length);
			strReturn = new String(commonByteArray_FINAL_PROJECT_json_staging_job, 0, length, utf8Charset);
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
			if(length > commonByteArray_FINAL_PROJECT_json_staging_job.length) {
				if(length < 1024 && commonByteArray_FINAL_PROJECT_json_staging_job.length == 0) {
   					commonByteArray_FINAL_PROJECT_json_staging_job = new byte[1024];
				} else {
   					commonByteArray_FINAL_PROJECT_json_staging_job = new byte[2 * length];
   				}
			}
			unmarshaller.readFully(commonByteArray_FINAL_PROJECT_json_staging_job, 0, length);
			strReturn = new String(commonByteArray_FINAL_PROJECT_json_staging_job, 0, length, utf8Charset);
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
	private Integer readInteger(ObjectInputStream dis) throws IOException{
		Integer intReturn;
        int length = 0;
        length = dis.readByte();
		if (length == -1) {
			intReturn = null;
		} else {
	    	intReturn = dis.readInt();
		}
		return intReturn;
	}
	
	private Integer readInteger(org.jboss.marshalling.Unmarshaller dis) throws IOException{
		Integer intReturn;
        int length = 0;
        length = dis.readByte();
		if (length == -1) {
			intReturn = null;
		} else {
	    	intReturn = dis.readInt();
		}
		return intReturn;
	}

	private void writeInteger(Integer intNum, ObjectOutputStream dos) throws IOException{
		if(intNum == null) {
            dos.writeByte(-1);
		} else {
			dos.writeByte(0);
	    	dos.writeInt(intNum);
    	}
	}
	
	private void writeInteger(Integer intNum, org.jboss.marshalling.Marshaller marshaller) throws IOException{
		if(intNum == null) {
			marshaller.writeByte(-1);
		} else {
			marshaller.writeByte(0);
			marshaller.writeInt(intNum);
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

		synchronized(commonByteArrayLock_FINAL_PROJECT_json_staging_job) {

        	try {

        		int length = 0;
		
					this.tconst = readString(dis);
					
					this.titleType = readString(dis);
					
					this.primaryTitle = readString(dis);
					
					this.originalTitle = readString(dis);
					
						this.isAdult = readInteger(dis);
					
					this.startYear = readString(dis);
					
					this.endYear = readString(dis);
					
					this.runtimeMinutes = readString(dis);
					
					this.genres = readString(dis);
					
					this.DI_CreatedDate = readDate(dis);
					
					this.DI_WorkflowJobId = readString(dis);
					
        	} catch (IOException e) {
	            throw new RuntimeException(e);

		

        }

		

      }


    }
    
    public void readData(org.jboss.marshalling.Unmarshaller dis) {

		synchronized(commonByteArrayLock_FINAL_PROJECT_json_staging_job) {

        	try {

        		int length = 0;
		
					this.tconst = readString(dis);
					
					this.titleType = readString(dis);
					
					this.primaryTitle = readString(dis);
					
					this.originalTitle = readString(dis);
					
						this.isAdult = readInteger(dis);
					
					this.startYear = readString(dis);
					
					this.endYear = readString(dis);
					
					this.runtimeMinutes = readString(dis);
					
					this.genres = readString(dis);
					
					this.DI_CreatedDate = readDate(dis);
					
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
					
					// Integer
				
						writeInteger(this.isAdult,dos);
					
					// String
				
						writeString(this.startYear,dos);
					
					// String
				
						writeString(this.endYear,dos);
					
					// String
				
						writeString(this.runtimeMinutes,dos);
					
					// String
				
						writeString(this.genres,dos);
					
					// java.util.Date
				
						writeDate(this.DI_CreatedDate,dos);
					
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
					
					// Integer
				
						writeInteger(this.isAdult,dos);
					
					// String
				
						writeString(this.startYear,dos);
					
					// String
				
						writeString(this.endYear,dos);
					
					// String
				
						writeString(this.runtimeMinutes,dos);
					
					// String
				
						writeString(this.genres,dos);
					
					// java.util.Date
				
						writeDate(this.DI_CreatedDate,dos);
					
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
		sb.append(",DI_CreatedDate="+String.valueOf(DI_CreatedDate));
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
        		
        				if(DI_CreatedDate == null){
        					sb.append("<null>");
        				}else{
            				sb.append(DI_CreatedDate);
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
    public int compareTo(copyOftoMySqlStruct other) {

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
    final static byte[] commonByteArrayLock_FINAL_PROJECT_json_staging_job = new byte[0];
    static byte[] commonByteArray_FINAL_PROJECT_json_staging_job = new byte[0];

	
			    public String tconst;

				public String getTconst () {
					return this.tconst;
				}

				public Boolean tconstIsNullable(){
				    return true;
				}
				public Boolean tconstIsKey(){
				    return false;
				}
				public Integer tconstLength(){
				    return 8;
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
				    return 7;
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
				    return 40;
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
				    return 40;
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

				
			    public Integer isAdult;

				public Integer getIsAdult () {
					return this.isAdult;
				}

				public Boolean isAdultIsNullable(){
				    return true;
				}
				public Boolean isAdultIsKey(){
				    return false;
				}
				public Integer isAdultLength(){
				    return null;
				}
				public Integer isAdultPrecision(){
				    return 0;
				}
				public String isAdultDefault(){
				
					return null;
				
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
				    return 4;
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
				    return 35;
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

				



	private String readString(ObjectInputStream dis) throws IOException{
		String strReturn = null;
		int length = 0;
        length = dis.readInt();
		if (length == -1) {
			strReturn = null;
		} else {
			if(length > commonByteArray_FINAL_PROJECT_json_staging_job.length) {
				if(length < 1024 && commonByteArray_FINAL_PROJECT_json_staging_job.length == 0) {
   					commonByteArray_FINAL_PROJECT_json_staging_job = new byte[1024];
				} else {
   					commonByteArray_FINAL_PROJECT_json_staging_job = new byte[2 * length];
   				}
			}
			dis.readFully(commonByteArray_FINAL_PROJECT_json_staging_job, 0, length);
			strReturn = new String(commonByteArray_FINAL_PROJECT_json_staging_job, 0, length, utf8Charset);
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
			if(length > commonByteArray_FINAL_PROJECT_json_staging_job.length) {
				if(length < 1024 && commonByteArray_FINAL_PROJECT_json_staging_job.length == 0) {
   					commonByteArray_FINAL_PROJECT_json_staging_job = new byte[1024];
				} else {
   					commonByteArray_FINAL_PROJECT_json_staging_job = new byte[2 * length];
   				}
			}
			unmarshaller.readFully(commonByteArray_FINAL_PROJECT_json_staging_job, 0, length);
			strReturn = new String(commonByteArray_FINAL_PROJECT_json_staging_job, 0, length, utf8Charset);
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
	private Integer readInteger(ObjectInputStream dis) throws IOException{
		Integer intReturn;
        int length = 0;
        length = dis.readByte();
		if (length == -1) {
			intReturn = null;
		} else {
	    	intReturn = dis.readInt();
		}
		return intReturn;
	}
	
	private Integer readInteger(org.jboss.marshalling.Unmarshaller dis) throws IOException{
		Integer intReturn;
        int length = 0;
        length = dis.readByte();
		if (length == -1) {
			intReturn = null;
		} else {
	    	intReturn = dis.readInt();
		}
		return intReturn;
	}

	private void writeInteger(Integer intNum, ObjectOutputStream dos) throws IOException{
		if(intNum == null) {
            dos.writeByte(-1);
		} else {
			dos.writeByte(0);
	    	dos.writeInt(intNum);
    	}
	}
	
	private void writeInteger(Integer intNum, org.jboss.marshalling.Marshaller marshaller) throws IOException{
		if(intNum == null) {
			marshaller.writeByte(-1);
		} else {
			marshaller.writeByte(0);
			marshaller.writeInt(intNum);
    	}
	}

    public void readData(ObjectInputStream dis) {

		synchronized(commonByteArrayLock_FINAL_PROJECT_json_staging_job) {

        	try {

        		int length = 0;
		
					this.tconst = readString(dis);
					
					this.titleType = readString(dis);
					
					this.primaryTitle = readString(dis);
					
					this.originalTitle = readString(dis);
					
						this.isAdult = readInteger(dis);
					
					this.startYear = readString(dis);
					
					this.endYear = readString(dis);
					
					this.runtimeMinutes = readString(dis);
					
					this.genres = readString(dis);
					
        	} catch (IOException e) {
	            throw new RuntimeException(e);

		

        }

		

      }


    }
    
    public void readData(org.jboss.marshalling.Unmarshaller dis) {

		synchronized(commonByteArrayLock_FINAL_PROJECT_json_staging_job) {

        	try {

        		int length = 0;
		
					this.tconst = readString(dis);
					
					this.titleType = readString(dis);
					
					this.primaryTitle = readString(dis);
					
					this.originalTitle = readString(dis);
					
						this.isAdult = readInteger(dis);
					
					this.startYear = readString(dis);
					
					this.endYear = readString(dis);
					
					this.runtimeMinutes = readString(dis);
					
					this.genres = readString(dis);
					
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
					
					// Integer
				
						writeInteger(this.isAdult,dos);
					
					// String
				
						writeString(this.startYear,dos);
					
					// String
				
						writeString(this.endYear,dos);
					
					// String
				
						writeString(this.runtimeMinutes,dos);
					
					// String
				
						writeString(this.genres,dos);
					
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
					
					// Integer
				
						writeInteger(this.isAdult,dos);
					
					// String
				
						writeString(this.startYear,dos);
					
					// String
				
						writeString(this.endYear,dos);
					
					// String
				
						writeString(this.runtimeMinutes,dos);
					
					// String
				
						writeString(this.genres,dos);
					
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

public void tFileInputJSON_2Process(final java.util.Map<String, Object> globalMap) throws TalendException {
	globalMap.put("tFileInputJSON_2_SUBPROCESS_STATE", 0);

 final boolean execStat = this.execStat;
	
		mdcInfo.forEach(org.slf4j.MDC::put);
		org.slf4j.MDC.put("_subJobName", "tFileInputJSON_2");
		org.slf4j.MDC.put("_subJobPid", "bBvdT4_" + subJobPidCounter.getAndIncrement());
	

	
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
copyOftoLogStruct copyOftoLog = new copyOftoLogStruct();
copyOftoMySqlStruct copyOftoMySql = new copyOftoMySqlStruct();





	
	/**
	 * [tLogRow_2 begin ] start
	 */

	

	
		
		ok_Hash.put("tLogRow_2", false);
		start_Hash.put("tLogRow_2", System.currentTimeMillis());
		
	
	currentComponent="tLogRow_2";
	
	
			runStat.updateStatAndLog(execStat,enableLogStash,resourceMap,iterateId,0,0,"copyOftoLog");
			
		int tos_count_tLogRow_2 = 0;
		
                if(log.isDebugEnabled())
            log.debug("tLogRow_2 - "  + ("Start to work.") );
            if (log.isDebugEnabled()) {
                class BytesLimit65535_tLogRow_2{
                    public void limitLog4jByte() throws Exception{
                    StringBuilder log4jParamters_tLogRow_2 = new StringBuilder();
                    log4jParamters_tLogRow_2.append("Parameters:");
                            log4jParamters_tLogRow_2.append("BASIC_MODE" + " = " + "false");
                        log4jParamters_tLogRow_2.append(" | ");
                            log4jParamters_tLogRow_2.append("TABLE_PRINT" + " = " + "true");
                        log4jParamters_tLogRow_2.append(" | ");
                            log4jParamters_tLogRow_2.append("VERTICAL" + " = " + "false");
                        log4jParamters_tLogRow_2.append(" | ");
                            log4jParamters_tLogRow_2.append("PRINT_CONTENT_WITH_LOG4J" + " = " + "true");
                        log4jParamters_tLogRow_2.append(" | ");
                if(log.isDebugEnabled())
            log.debug("tLogRow_2 - "  + (log4jParamters_tLogRow_2) );
                    } 
                } 
            new BytesLimit65535_tLogRow_2().limitLog4jByte();
            }
			if(enableLogStash) {
				talendJobLog.addCM("tLogRow_2", "tLogRow_2", "tLogRow");
				talendJobLogProcess(globalMap);
			}
			

	///////////////////////
	
         class Util_tLogRow_2 {

        String[] des_top = { ".", ".", "-", "+" };

        String[] des_head = { "|=", "=|", "-", "+" };

        String[] des_bottom = { "'", "'", "-", "+" };

        String name="";

        java.util.List<String[]> list = new java.util.ArrayList<String[]>();

        int[] colLengths = new int[9];

        public void addRow(String[] row) {

            for (int i = 0; i < 9; i++) {
                if (row[i]!=null) {
                  colLengths[i] = Math.max(colLengths[i], row[i].length());
                }
            }
            list.add(row);
        }

        public void setTableName(String name) {

            this.name = name;
        }

            public StringBuilder format() {
            
                StringBuilder sb = new StringBuilder();
  
            
                    sb.append(print(des_top));
    
                    int totals = 0;
                    for (int i = 0; i < colLengths.length; i++) {
                        totals = totals + colLengths[i];
                    }
    
                    // name
                    sb.append("|");
                    int k = 0;
                    for (k = 0; k < (totals + 8 - name.length()) / 2; k++) {
                        sb.append(' ');
                    }
                    sb.append(name);
                    for (int i = 0; i < totals + 8 - name.length() - k; i++) {
                        sb.append(' ');
                    }
                    sb.append("|\n");

                    // head and rows
                    sb.append(print(des_head));
                    for (int i = 0; i < list.size(); i++) {
    
                        String[] row = list.get(i);
    
                        java.util.Formatter formatter = new java.util.Formatter(new StringBuilder());
                        
                        StringBuilder sbformat = new StringBuilder();                                             
        			        sbformat.append("|%1$-");
        			        sbformat.append(colLengths[0]);
        			        sbformat.append("s");
        			              
        			        sbformat.append("|%2$-");
        			        sbformat.append(colLengths[1]);
        			        sbformat.append("s");
        			              
        			        sbformat.append("|%3$-");
        			        sbformat.append(colLengths[2]);
        			        sbformat.append("s");
        			              
        			        sbformat.append("|%4$-");
        			        sbformat.append(colLengths[3]);
        			        sbformat.append("s");
        			              
        			        sbformat.append("|%5$-");
        			        sbformat.append(colLengths[4]);
        			        sbformat.append("s");
        			              
        			        sbformat.append("|%6$-");
        			        sbformat.append(colLengths[5]);
        			        sbformat.append("s");
        			              
        			        sbformat.append("|%7$-");
        			        sbformat.append(colLengths[6]);
        			        sbformat.append("s");
        			              
        			        sbformat.append("|%8$-");
        			        sbformat.append(colLengths[7]);
        			        sbformat.append("s");
        			              
        			        sbformat.append("|%9$-");
        			        sbformat.append(colLengths[8]);
        			        sbformat.append("s");
        			                      
                        sbformat.append("|\n");                    
       
                        formatter.format(sbformat.toString(), (Object[])row);	
                                
                        sb.append(formatter.toString());
                        if (i == 0)
                            sb.append(print(des_head)); // print the head
                    }
    
                    // end
                    sb.append(print(des_bottom));
                    return sb;
                }
            

            private StringBuilder print(String[] fillChars) {
                StringBuilder sb = new StringBuilder();
                //first column
                sb.append(fillChars[0]);                
                    for (int i = 0; i < colLengths[0] - fillChars[0].length() + 1; i++) {
                        sb.append(fillChars[2]);
                    }
                    sb.append(fillChars[3]);	                

                    for (int i = 0; i < colLengths[1] - fillChars[3].length() + 1; i++) {
                        sb.append(fillChars[2]);
                    }
                    sb.append(fillChars[3]);
                    for (int i = 0; i < colLengths[2] - fillChars[3].length() + 1; i++) {
                        sb.append(fillChars[2]);
                    }
                    sb.append(fillChars[3]);
                    for (int i = 0; i < colLengths[3] - fillChars[3].length() + 1; i++) {
                        sb.append(fillChars[2]);
                    }
                    sb.append(fillChars[3]);
                    for (int i = 0; i < colLengths[4] - fillChars[3].length() + 1; i++) {
                        sb.append(fillChars[2]);
                    }
                    sb.append(fillChars[3]);
                    for (int i = 0; i < colLengths[5] - fillChars[3].length() + 1; i++) {
                        sb.append(fillChars[2]);
                    }
                    sb.append(fillChars[3]);
                    for (int i = 0; i < colLengths[6] - fillChars[3].length() + 1; i++) {
                        sb.append(fillChars[2]);
                    }
                    sb.append(fillChars[3]);
                    for (int i = 0; i < colLengths[7] - fillChars[3].length() + 1; i++) {
                        sb.append(fillChars[2]);
                    }
                    sb.append(fillChars[3]);
                
                    //last column
                    for (int i = 0; i < colLengths[8] - fillChars[1].length() + 1; i++) {
                        sb.append(fillChars[2]);
                    }         
                sb.append(fillChars[1]);
                sb.append("\n");               
                return sb;
            }
            
            public boolean isTableEmpty(){
            	if (list.size() > 1)
            		return false;
            	return true;
            }
        }
        Util_tLogRow_2 util_tLogRow_2 = new Util_tLogRow_2();
        util_tLogRow_2.setTableName("tLogRow_2");
        util_tLogRow_2.addRow(new String[]{"tconst","titleType","primaryTitle","originalTitle","isAdult","startYear","endYear","runtimeMinutes","genres",});        
 		StringBuilder strBuffer_tLogRow_2 = null;
		int nb_line_tLogRow_2 = 0;
///////////////////////    			



 



/**
 * [tLogRow_2 begin ] stop
 */




	
	/**
	 * [tDBOutput_2 begin ] start
	 */

	

	
		
		ok_Hash.put("tDBOutput_2", false);
		start_Hash.put("tDBOutput_2", System.currentTimeMillis());
		
	
	currentComponent="tDBOutput_2";
	
	
			cLabel="new_title_basics table";
		
			runStat.updateStatAndLog(execStat,enableLogStash,resourceMap,iterateId,0,0,"copyOftoMySql");
			
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
                            log4jParamters_tDBOutput_2.append("TABLE" + " = " + "\"new_title_basics\"");
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
				talendJobLog.addCM("tDBOutput_2", "new_title_basics table", "tMysqlOutput");
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

String tableName_tDBOutput_2 = "new_title_basics";
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
                                    if(table_tDBOutput_2.equalsIgnoreCase("new_title_basics")) {
                                        whetherExist_tDBOutput_2 = true;
                                        break;
                                    }
                                }
                                if(!whetherExist_tDBOutput_2) {
                                    try (java.sql.Statement stmtCreate_tDBOutput_2 = conn_tDBOutput_2.createStatement()) {
                if(log.isDebugEnabled())
            log.debug("tDBOutput_2 - "  + ("Creating")  + (" table '")  + (tableName_tDBOutput_2)  + ("'.") );
                                        stmtCreate_tDBOutput_2.execute("CREATE TABLE `" + tableName_tDBOutput_2 + "`(`tconst` VARCHAR(12)  ,`titleType` VARCHAR(7)  ,`primaryTitle` VARCHAR(75)  ,`originalTitle` VARCHAR(75)  ,`isAdult` INT(0)  ,`startYear` VARCHAR(4)  ,`endYear` VARCHAR(4)  ,`runtimeMinutes` VARCHAR(4)  ,`genres` VARCHAR(35)  ,`DI_CreatedDate` DATETIME ,`DI_WorkflowJobId` VARCHAR(8)  )");
                if(log.isDebugEnabled())
            log.debug("tDBOutput_2 - "  + ("Create")  + (" table '")  + (tableName_tDBOutput_2)  + ("' has succeeded.") );
                                    }
                                }
			

		
						String insert_tDBOutput_2 = "INSERT INTO `" + "new_title_basics" + "` (`tconst`,`titleType`,`primaryTitle`,`originalTitle`,`isAdult`,`startYear`,`endYear`,`runtimeMinutes`,`genres`,`DI_CreatedDate`,`DI_WorkflowJobId`) VALUES (?,?,?,?,?,?,?,?,?,?,?)";
		
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
				int count_copyOftoLog_tMap_2 = 0;
				
copyOftoLogStruct copyOftoLog_tmp = new copyOftoLogStruct();
				int count_copyOftoMySql_tMap_2 = 0;
				
copyOftoMySqlStruct copyOftoMySql_tmp = new copyOftoMySqlStruct();
// ###############################

        
        



        









 



/**
 * [tMap_2 begin ] stop
 */



	
	/**
	 * [tFileInputJSON_2 begin ] start
	 */

	

	
		
		ok_Hash.put("tFileInputJSON_2", false);
		start_Hash.put("tFileInputJSON_2", System.currentTimeMillis());
		
	
	currentComponent="tFileInputJSON_2";
	
	
			cLabel="New Title - Json Load";
		
		int tos_count_tFileInputJSON_2 = 0;
		
                if(log.isDebugEnabled())
            log.debug("tFileInputJSON_2 - "  + ("Start to work.") );
            if (log.isDebugEnabled()) {
                class BytesLimit65535_tFileInputJSON_2{
                    public void limitLog4jByte() throws Exception{
                    StringBuilder log4jParamters_tFileInputJSON_2 = new StringBuilder();
                    log4jParamters_tFileInputJSON_2.append("Parameters:");
                            log4jParamters_tFileInputJSON_2.append("READ_BY" + " = " + "JSONPATH");
                        log4jParamters_tFileInputJSON_2.append(" | ");
                            log4jParamters_tFileInputJSON_2.append("JSON_PATH_VERSION" + " = " + "2_1_0");
                        log4jParamters_tFileInputJSON_2.append(" | ");
                            log4jParamters_tFileInputJSON_2.append("USEURL" + " = " + "false");
                        log4jParamters_tFileInputJSON_2.append(" | ");
                            log4jParamters_tFileInputJSON_2.append("FILENAME" + " = " + "context.new_title_file_path");
                        log4jParamters_tFileInputJSON_2.append(" | ");
                            log4jParamters_tFileInputJSON_2.append("JSON_LOOP_QUERY" + " = " + "\"$.data[*]\"");
                        log4jParamters_tFileInputJSON_2.append(" | ");
                            log4jParamters_tFileInputJSON_2.append("MAPPING_JSONPATH" + " = " + "[{QUERY="+("\"$.tconst\"")+", SCHEMA_COLUMN="+("tconst")+"}, {QUERY="+("\"$.titleType\"")+", SCHEMA_COLUMN="+("titleType")+"}, {QUERY="+("\"$.primaryTitle\"")+", SCHEMA_COLUMN="+("primaryTitle")+"}, {QUERY="+("\"$.originalTitle\"")+", SCHEMA_COLUMN="+("originalTitle")+"}, {QUERY="+("\"$.isAdult\"")+", SCHEMA_COLUMN="+("isAdult")+"}, {QUERY="+("\"$.startYear\"")+", SCHEMA_COLUMN="+("startYear")+"}, {QUERY="+("\"$.endYear\"")+", SCHEMA_COLUMN="+("endYear")+"}, {QUERY="+("\"$.runtimeMinutes\"")+", SCHEMA_COLUMN="+("runtimeMinutes")+"}, {QUERY="+("\"$.genres\"")+", SCHEMA_COLUMN="+("genres")+"}]");
                        log4jParamters_tFileInputJSON_2.append(" | ");
                            log4jParamters_tFileInputJSON_2.append("DIE_ON_ERROR" + " = " + "false");
                        log4jParamters_tFileInputJSON_2.append(" | ");
                            log4jParamters_tFileInputJSON_2.append("ADVANCED_SEPARATOR" + " = " + "false");
                        log4jParamters_tFileInputJSON_2.append(" | ");
                            log4jParamters_tFileInputJSON_2.append("USE_LOOP_AS_ROOT" + " = " + "true");
                        log4jParamters_tFileInputJSON_2.append(" | ");
                            log4jParamters_tFileInputJSON_2.append("ENCODING" + " = " + "\"UTF-8\"");
                        log4jParamters_tFileInputJSON_2.append(" | ");
                if(log.isDebugEnabled())
            log.debug("tFileInputJSON_2 - "  + (log4jParamters_tFileInputJSON_2) );
                    } 
                } 
            new BytesLimit65535_tFileInputJSON_2().limitLog4jByte();
            }
			if(enableLogStash) {
				talendJobLog.addCM("tFileInputJSON_2", "New Title - Json Load", "tFileInputJSON");
				talendJobLogProcess(globalMap);
			}
			

	
class JsonPathCache_tFileInputJSON_2 {
	final java.util.Map<String,com.jayway.jsonpath.JsonPath> jsonPathString2compiledJsonPath = new java.util.HashMap<String,com.jayway.jsonpath.JsonPath>();
	
	public com.jayway.jsonpath.JsonPath getCompiledJsonPath(String jsonPath) {
		if(jsonPathString2compiledJsonPath.containsKey(jsonPath)) {
			return jsonPathString2compiledJsonPath.get(jsonPath);
		} else {
			com.jayway.jsonpath.JsonPath compiledLoopPath = com.jayway.jsonpath.JsonPath.compile(jsonPath);
			jsonPathString2compiledJsonPath.put(jsonPath,compiledLoopPath);
			return compiledLoopPath;
		}
	}
}

int nb_line_tFileInputJSON_2 = 0;

JsonPathCache_tFileInputJSON_2 jsonPathCache_tFileInputJSON_2 = new JsonPathCache_tFileInputJSON_2();

String loopPath_tFileInputJSON_2 = "$.data[*]";
java.util.List<Object> resultset_tFileInputJSON_2 = new java.util.ArrayList<Object>();

java.io.InputStream is_tFileInputJSON_2 = null;
com.jayway.jsonpath.ParseContext parseContext_tFileInputJSON_2 = com.jayway.jsonpath.JsonPath.using(com.jayway.jsonpath.Configuration.defaultConfiguration());
Object filenameOrStream_tFileInputJSON_2 = null;
        try {
            filenameOrStream_tFileInputJSON_2 = context.new_title_file_path;
        } catch(java.lang.Exception e_tFileInputJSON_2) {
globalMap.put("tFileInputJSON_2_ERROR_MESSAGE",e_tFileInputJSON_2.getMessage());
				
					log.error("tFileInputJSON_2 - " + e_tFileInputJSON_2.getMessage());
				
	            globalMap.put("tFileInputJSON_2_ERROR_MESSAGE", e_tFileInputJSON_2.getMessage());
	            System.err.println(e_tFileInputJSON_2.getMessage());
        }
        
com.jayway.jsonpath.ReadContext document_tFileInputJSON_2 = null;
try {
     if(filenameOrStream_tFileInputJSON_2 instanceof java.io.InputStream){
         is_tFileInputJSON_2 = (java.io.InputStream)filenameOrStream_tFileInputJSON_2;
     }else{
	    
	        is_tFileInputJSON_2 = new java.io.FileInputStream((String)filenameOrStream_tFileInputJSON_2);
	    
	 }
	
	
	document_tFileInputJSON_2 = parseContext_tFileInputJSON_2.parse(is_tFileInputJSON_2,"UTF-8");
	com.jayway.jsonpath.JsonPath compiledLoopPath_tFileInputJSON_2 = jsonPathCache_tFileInputJSON_2.getCompiledJsonPath(loopPath_tFileInputJSON_2);
	Object result_tFileInputJSON_2 = document_tFileInputJSON_2.read(compiledLoopPath_tFileInputJSON_2,net.minidev.json.JSONObject.class);
	if (result_tFileInputJSON_2 instanceof net.minidev.json.JSONArray) {
		resultset_tFileInputJSON_2 = (net.minidev.json.JSONArray) result_tFileInputJSON_2;
	} else {
		resultset_tFileInputJSON_2.add(result_tFileInputJSON_2);
	}
} catch (java.lang.Exception e_tFileInputJSON_2) {
globalMap.put("tFileInputJSON_2_ERROR_MESSAGE",e_tFileInputJSON_2.getMessage());
	log.error("tFileInputJSON_2 - " + e_tFileInputJSON_2.getMessage());
	
	globalMap.put("tFileInputJSON_2_ERROR_MESSAGE", e_tFileInputJSON_2.getMessage());
	System.err.println(e_tFileInputJSON_2.getMessage());
} finally {
	if(is_tFileInputJSON_2 != null) {
		is_tFileInputJSON_2.close();
	}
}

String jsonPath_tFileInputJSON_2 = null;
com.jayway.jsonpath.JsonPath compiledJsonPath_tFileInputJSON_2 = null;

Object value_tFileInputJSON_2 = null;
	log.info("tFileInputJSON_2 - Retrieving records from data.");
Object root_tFileInputJSON_2 = null;
for(Object row_tFileInputJSON_2 : resultset_tFileInputJSON_2) {
	nb_line_tFileInputJSON_2++;
				log.debug("tFileInputJSON_2 - Retrieving the record " + (nb_line_tFileInputJSON_2) + ".");
			
			row2 = null;			
	boolean whetherReject_tFileInputJSON_2 = false;
	row2 = new row2Struct();
	
	try{
				jsonPath_tFileInputJSON_2 = "$.tconst";
				compiledJsonPath_tFileInputJSON_2 = jsonPathCache_tFileInputJSON_2.getCompiledJsonPath(jsonPath_tFileInputJSON_2);
				
				try {
				   
				       value_tFileInputJSON_2 = compiledJsonPath_tFileInputJSON_2.read(row_tFileInputJSON_2);
				   
						row2.tconst = value_tFileInputJSON_2 == null ? 

		null
 : value_tFileInputJSON_2.toString();
				} catch (com.jayway.jsonpath.PathNotFoundException e_tFileInputJSON_2) {
globalMap.put("tFileInputJSON_2_ERROR_MESSAGE",e_tFileInputJSON_2.getMessage());
					row2.tconst = 

		null
;
				}				
				jsonPath_tFileInputJSON_2 = "$.titleType";
				compiledJsonPath_tFileInputJSON_2 = jsonPathCache_tFileInputJSON_2.getCompiledJsonPath(jsonPath_tFileInputJSON_2);
				
				try {
				   
				       value_tFileInputJSON_2 = compiledJsonPath_tFileInputJSON_2.read(row_tFileInputJSON_2);
				   
						row2.titleType = value_tFileInputJSON_2 == null ? 

		null
 : value_tFileInputJSON_2.toString();
				} catch (com.jayway.jsonpath.PathNotFoundException e_tFileInputJSON_2) {
globalMap.put("tFileInputJSON_2_ERROR_MESSAGE",e_tFileInputJSON_2.getMessage());
					row2.titleType = 

		null
;
				}				
				jsonPath_tFileInputJSON_2 = "$.primaryTitle";
				compiledJsonPath_tFileInputJSON_2 = jsonPathCache_tFileInputJSON_2.getCompiledJsonPath(jsonPath_tFileInputJSON_2);
				
				try {
				   
				       value_tFileInputJSON_2 = compiledJsonPath_tFileInputJSON_2.read(row_tFileInputJSON_2);
				   
						row2.primaryTitle = value_tFileInputJSON_2 == null ? 

		null
 : value_tFileInputJSON_2.toString();
				} catch (com.jayway.jsonpath.PathNotFoundException e_tFileInputJSON_2) {
globalMap.put("tFileInputJSON_2_ERROR_MESSAGE",e_tFileInputJSON_2.getMessage());
					row2.primaryTitle = 

		null
;
				}				
				jsonPath_tFileInputJSON_2 = "$.originalTitle";
				compiledJsonPath_tFileInputJSON_2 = jsonPathCache_tFileInputJSON_2.getCompiledJsonPath(jsonPath_tFileInputJSON_2);
				
				try {
				   
				       value_tFileInputJSON_2 = compiledJsonPath_tFileInputJSON_2.read(row_tFileInputJSON_2);
				   
						row2.originalTitle = value_tFileInputJSON_2 == null ? 

		null
 : value_tFileInputJSON_2.toString();
				} catch (com.jayway.jsonpath.PathNotFoundException e_tFileInputJSON_2) {
globalMap.put("tFileInputJSON_2_ERROR_MESSAGE",e_tFileInputJSON_2.getMessage());
					row2.originalTitle = 

		null
;
				}				
				jsonPath_tFileInputJSON_2 = "$.isAdult";
				compiledJsonPath_tFileInputJSON_2 = jsonPathCache_tFileInputJSON_2.getCompiledJsonPath(jsonPath_tFileInputJSON_2);
				
				try {
				   
				       value_tFileInputJSON_2 = compiledJsonPath_tFileInputJSON_2.read(row_tFileInputJSON_2);
				   
						if(value_tFileInputJSON_2 != null && !value_tFileInputJSON_2.toString().isEmpty()) {
						row2.isAdult = ParserUtils.parseTo_Integer(value_tFileInputJSON_2.toString());
						} else {
							row2.isAdult = 

		null
;
						}
				} catch (com.jayway.jsonpath.PathNotFoundException e_tFileInputJSON_2) {
globalMap.put("tFileInputJSON_2_ERROR_MESSAGE",e_tFileInputJSON_2.getMessage());
					row2.isAdult = 

		null
;
				}				
				jsonPath_tFileInputJSON_2 = "$.startYear";
				compiledJsonPath_tFileInputJSON_2 = jsonPathCache_tFileInputJSON_2.getCompiledJsonPath(jsonPath_tFileInputJSON_2);
				
				try {
				   
				       value_tFileInputJSON_2 = compiledJsonPath_tFileInputJSON_2.read(row_tFileInputJSON_2);
				   
						row2.startYear = value_tFileInputJSON_2 == null ? 

		null
 : value_tFileInputJSON_2.toString();
				} catch (com.jayway.jsonpath.PathNotFoundException e_tFileInputJSON_2) {
globalMap.put("tFileInputJSON_2_ERROR_MESSAGE",e_tFileInputJSON_2.getMessage());
					row2.startYear = 

		null
;
				}				
				jsonPath_tFileInputJSON_2 = "$.endYear";
				compiledJsonPath_tFileInputJSON_2 = jsonPathCache_tFileInputJSON_2.getCompiledJsonPath(jsonPath_tFileInputJSON_2);
				
				try {
				   
				       value_tFileInputJSON_2 = compiledJsonPath_tFileInputJSON_2.read(row_tFileInputJSON_2);
				   
						row2.endYear = value_tFileInputJSON_2 == null ? 

		null
 : value_tFileInputJSON_2.toString();
				} catch (com.jayway.jsonpath.PathNotFoundException e_tFileInputJSON_2) {
globalMap.put("tFileInputJSON_2_ERROR_MESSAGE",e_tFileInputJSON_2.getMessage());
					row2.endYear = 

		null
;
				}				
				jsonPath_tFileInputJSON_2 = "$.runtimeMinutes";
				compiledJsonPath_tFileInputJSON_2 = jsonPathCache_tFileInputJSON_2.getCompiledJsonPath(jsonPath_tFileInputJSON_2);
				
				try {
				   
				       value_tFileInputJSON_2 = compiledJsonPath_tFileInputJSON_2.read(row_tFileInputJSON_2);
				   
						row2.runtimeMinutes = value_tFileInputJSON_2 == null ? 

		null
 : value_tFileInputJSON_2.toString();
				} catch (com.jayway.jsonpath.PathNotFoundException e_tFileInputJSON_2) {
globalMap.put("tFileInputJSON_2_ERROR_MESSAGE",e_tFileInputJSON_2.getMessage());
					row2.runtimeMinutes = 

		null
;
				}				
				jsonPath_tFileInputJSON_2 = "$.genres";
				compiledJsonPath_tFileInputJSON_2 = jsonPathCache_tFileInputJSON_2.getCompiledJsonPath(jsonPath_tFileInputJSON_2);
				
				try {
				   
				       value_tFileInputJSON_2 = compiledJsonPath_tFileInputJSON_2.read(row_tFileInputJSON_2);
				   
						row2.genres = value_tFileInputJSON_2 == null ? 

		null
 : value_tFileInputJSON_2.toString();
				} catch (com.jayway.jsonpath.PathNotFoundException e_tFileInputJSON_2) {
globalMap.put("tFileInputJSON_2_ERROR_MESSAGE",e_tFileInputJSON_2.getMessage());
					row2.genres = 

		null
;
				}				
    } catch (java.lang.Exception e_tFileInputJSON_2) {
globalMap.put("tFileInputJSON_2_ERROR_MESSAGE",e_tFileInputJSON_2.getMessage());
        whetherReject_tFileInputJSON_2 = true;
					log.error("tFileInputJSON_2 - " + e_tFileInputJSON_2.getMessage());
				
                System.err.println(e_tFileInputJSON_2.getMessage());
                row2 = null;
            globalMap.put("tFileInputJSON_2_ERROR_MESSAGE", e_tFileInputJSON_2.getMessage());
    }
//}

 



/**
 * [tFileInputJSON_2 begin ] stop
 */
	
	/**
	 * [tFileInputJSON_2 main ] start
	 */

	

	
	
	currentComponent="tFileInputJSON_2";
	
	
			cLabel="New Title - Json Load";
		

 


	tos_count_tFileInputJSON_2++;

/**
 * [tFileInputJSON_2 main ] stop
 */
	
	/**
	 * [tFileInputJSON_2 process_data_begin ] start
	 */

	

	
	
	currentComponent="tFileInputJSON_2";
	
	
			cLabel="New Title - Json Load";
		

 



/**
 * [tFileInputJSON_2 process_data_begin ] stop
 */
// Start of branch "row2"
if(row2 != null) { 



	
	/**
	 * [tMap_2 main ] start
	 */

	

	
	
	currentComponent="tMap_2";
	
	
			if(runStat.update(execStat,enableLogStash,iterateId,1,1
				
					,"row2","tFileInputJSON_2","New Title - Json Load","tFileInputJSON","tMap_2","tMap_2","tMap"
				
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

copyOftoLog = null;
copyOftoMySql = null;


// # Output table : 'copyOftoLog'
count_copyOftoLog_tMap_2++;

copyOftoLog_tmp.tconst = row2.tconst;
copyOftoLog_tmp.titleType = row2.titleType;
copyOftoLog_tmp.primaryTitle = row2.primaryTitle;
copyOftoLog_tmp.originalTitle = row2.originalTitle;
copyOftoLog_tmp.isAdult = row2.isAdult;
copyOftoLog_tmp.startYear = row2.startYear;
copyOftoLog_tmp.endYear = row2.endYear;
copyOftoLog_tmp.runtimeMinutes = row2.runtimeMinutes;
copyOftoLog_tmp.genres = row2.genres;
copyOftoLog = copyOftoLog_tmp;
log.debug("tMap_2 - Outputting the record " + count_copyOftoLog_tMap_2 + " of the output table 'copyOftoLog'.");


// # Output table : 'copyOftoMySql'
count_copyOftoMySql_tMap_2++;

copyOftoMySql_tmp.tconst = row2.tconst;
copyOftoMySql_tmp.titleType = row2.titleType;
copyOftoMySql_tmp.primaryTitle = row2.primaryTitle;
copyOftoMySql_tmp.originalTitle = row2.originalTitle;
copyOftoMySql_tmp.isAdult = row2.isAdult;
copyOftoMySql_tmp.startYear = row2.startYear;
copyOftoMySql_tmp.endYear = row2.endYear;
copyOftoMySql_tmp.runtimeMinutes = row2.runtimeMinutes;
copyOftoMySql_tmp.genres = row2.genres;
copyOftoMySql_tmp.DI_CreatedDate = TalendDate.getCurrentDate();
copyOftoMySql_tmp.DI_WorkflowJobId = pid;
copyOftoMySql = copyOftoMySql_tmp;
log.debug("tMap_2 - Outputting the record " + count_copyOftoMySql_tMap_2 + " of the output table 'copyOftoMySql'.");

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
// Start of branch "copyOftoLog"
if(copyOftoLog != null) { 



	
	/**
	 * [tLogRow_2 main ] start
	 */

	

	
	
	currentComponent="tLogRow_2";
	
	
			if(runStat.update(execStat,enableLogStash,iterateId,1,1
				
					,"copyOftoLog","tMap_2","tMap_2","tMap","tLogRow_2","tLogRow_2","tLogRow"
				
			)) {
				talendJobLogProcess(globalMap);
			}
			
    			if(log.isTraceEnabled()){
    				log.trace("copyOftoLog - " + (copyOftoLog==null? "": copyOftoLog.toLogString()));
    			}
    		
///////////////////////		
						

				
				String[] row_tLogRow_2 = new String[9];
   				
	    		if(copyOftoLog.tconst != null) { //              
                 row_tLogRow_2[0]=    						    
				                String.valueOf(copyOftoLog.tconst)			
					          ;	
							
	    		} //			
    			   				
	    		if(copyOftoLog.titleType != null) { //              
                 row_tLogRow_2[1]=    						    
				                String.valueOf(copyOftoLog.titleType)			
					          ;	
							
	    		} //			
    			   				
	    		if(copyOftoLog.primaryTitle != null) { //              
                 row_tLogRow_2[2]=    						    
				                String.valueOf(copyOftoLog.primaryTitle)			
					          ;	
							
	    		} //			
    			   				
	    		if(copyOftoLog.originalTitle != null) { //              
                 row_tLogRow_2[3]=    						    
				                String.valueOf(copyOftoLog.originalTitle)			
					          ;	
							
	    		} //			
    			   				
	    		if(copyOftoLog.isAdult != null) { //              
                 row_tLogRow_2[4]=    						    
				                String.valueOf(copyOftoLog.isAdult)			
					          ;	
							
	    		} //			
    			   				
	    		if(copyOftoLog.startYear != null) { //              
                 row_tLogRow_2[5]=    						    
				                String.valueOf(copyOftoLog.startYear)			
					          ;	
							
	    		} //			
    			   				
	    		if(copyOftoLog.endYear != null) { //              
                 row_tLogRow_2[6]=    						    
				                String.valueOf(copyOftoLog.endYear)			
					          ;	
							
	    		} //			
    			   				
	    		if(copyOftoLog.runtimeMinutes != null) { //              
                 row_tLogRow_2[7]=    						    
				                String.valueOf(copyOftoLog.runtimeMinutes)			
					          ;	
							
	    		} //			
    			   				
	    		if(copyOftoLog.genres != null) { //              
                 row_tLogRow_2[8]=    						    
				                String.valueOf(copyOftoLog.genres)			
					          ;	
							
	    		} //			
    			 

				util_tLogRow_2.addRow(row_tLogRow_2);	
				nb_line_tLogRow_2++;
                	log.info("tLogRow_2 - Content of row "+nb_line_tLogRow_2+": " + TalendString.unionString("|",row_tLogRow_2));
//////

//////                    
                    
///////////////////////    			

 


	tos_count_tLogRow_2++;

/**
 * [tLogRow_2 main ] stop
 */
	
	/**
	 * [tLogRow_2 process_data_begin ] start
	 */

	

	
	
	currentComponent="tLogRow_2";
	
	

 



/**
 * [tLogRow_2 process_data_begin ] stop
 */
	
	/**
	 * [tLogRow_2 process_data_end ] start
	 */

	

	
	
	currentComponent="tLogRow_2";
	
	

 



/**
 * [tLogRow_2 process_data_end ] stop
 */

} // End of branch "copyOftoLog"




// Start of branch "copyOftoMySql"
if(copyOftoMySql != null) { 



	
	/**
	 * [tDBOutput_2 main ] start
	 */

	

	
	
	currentComponent="tDBOutput_2";
	
	
			cLabel="new_title_basics table";
		
			if(runStat.update(execStat,enableLogStash,iterateId,1,1
				
					,"copyOftoMySql","tMap_2","tMap_2","tMap","tDBOutput_2","new_title_basics table","tMysqlOutput"
				
			)) {
				talendJobLogProcess(globalMap);
			}
			
    			if(log.isTraceEnabled()){
    				log.trace("copyOftoMySql - " + (copyOftoMySql==null? "": copyOftoMySql.toLogString()));
    			}
    		



        whetherReject_tDBOutput_2 = false;
                            if(copyOftoMySql.tconst == null) {
pstmt_tDBOutput_2.setNull(1, java.sql.Types.VARCHAR);
} else {pstmt_tDBOutput_2.setString(1, copyOftoMySql.tconst);
}

                            if(copyOftoMySql.titleType == null) {
pstmt_tDBOutput_2.setNull(2, java.sql.Types.VARCHAR);
} else {pstmt_tDBOutput_2.setString(2, copyOftoMySql.titleType);
}

                            if(copyOftoMySql.primaryTitle == null) {
pstmt_tDBOutput_2.setNull(3, java.sql.Types.VARCHAR);
} else {pstmt_tDBOutput_2.setString(3, copyOftoMySql.primaryTitle);
}

                            if(copyOftoMySql.originalTitle == null) {
pstmt_tDBOutput_2.setNull(4, java.sql.Types.VARCHAR);
} else {pstmt_tDBOutput_2.setString(4, copyOftoMySql.originalTitle);
}

                            if(copyOftoMySql.isAdult == null) {
pstmt_tDBOutput_2.setNull(5, java.sql.Types.INTEGER);
} else {pstmt_tDBOutput_2.setInt(5, copyOftoMySql.isAdult);
}

                            if(copyOftoMySql.startYear == null) {
pstmt_tDBOutput_2.setNull(6, java.sql.Types.VARCHAR);
} else {pstmt_tDBOutput_2.setString(6, copyOftoMySql.startYear);
}

                            if(copyOftoMySql.endYear == null) {
pstmt_tDBOutput_2.setNull(7, java.sql.Types.VARCHAR);
} else {pstmt_tDBOutput_2.setString(7, copyOftoMySql.endYear);
}

                            if(copyOftoMySql.runtimeMinutes == null) {
pstmt_tDBOutput_2.setNull(8, java.sql.Types.VARCHAR);
} else {pstmt_tDBOutput_2.setString(8, copyOftoMySql.runtimeMinutes);
}

                            if(copyOftoMySql.genres == null) {
pstmt_tDBOutput_2.setNull(9, java.sql.Types.VARCHAR);
} else {pstmt_tDBOutput_2.setString(9, copyOftoMySql.genres);
}

                            if(copyOftoMySql.DI_CreatedDate != null) {
date_tDBOutput_2 = copyOftoMySql.DI_CreatedDate.getTime();
if(date_tDBOutput_2 < year1_tDBOutput_2 || date_tDBOutput_2 >= year10000_tDBOutput_2) {
pstmt_tDBOutput_2.setString(10, "0000-00-00 00:00:00");
} else {pstmt_tDBOutput_2.setTimestamp(10, new java.sql.Timestamp(date_tDBOutput_2));
}
} else {
pstmt_tDBOutput_2.setNull(10, java.sql.Types.DATE);
}

                            if(copyOftoMySql.DI_WorkflowJobId == null) {
pstmt_tDBOutput_2.setNull(11, java.sql.Types.VARCHAR);
} else {pstmt_tDBOutput_2.setString(11, copyOftoMySql.DI_WorkflowJobId);
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
	
	
			cLabel="new_title_basics table";
		

 



/**
 * [tDBOutput_2 process_data_begin ] stop
 */
	
	/**
	 * [tDBOutput_2 process_data_end ] start
	 */

	

	
	
	currentComponent="tDBOutput_2";
	
	
			cLabel="new_title_basics table";
		

 



/**
 * [tDBOutput_2 process_data_end ] stop
 */

} // End of branch "copyOftoMySql"




	
	/**
	 * [tMap_2 process_data_end ] start
	 */

	

	
	
	currentComponent="tMap_2";
	
	

 



/**
 * [tMap_2 process_data_end ] stop
 */

} // End of branch "row2"




	
	/**
	 * [tFileInputJSON_2 process_data_end ] start
	 */

	

	
	
	currentComponent="tFileInputJSON_2";
	
	
			cLabel="New Title - Json Load";
		

 



/**
 * [tFileInputJSON_2 process_data_end ] stop
 */
	
	/**
	 * [tFileInputJSON_2 end ] start
	 */

	

	
	
	currentComponent="tFileInputJSON_2";
	
	
			cLabel="New Title - Json Load";
		

	}
	globalMap.put("tFileInputJSON_2_NB_LINE",nb_line_tFileInputJSON_2);
				log.debug("tFileInputJSON_2 - Retrieved records count: "+ nb_line_tFileInputJSON_2 + " .");
			
 
                if(log.isDebugEnabled())
            log.debug("tFileInputJSON_2 - "  + ("Done.") );

ok_Hash.put("tFileInputJSON_2", true);
end_Hash.put("tFileInputJSON_2", System.currentTimeMillis());




/**
 * [tFileInputJSON_2 end ] stop
 */

	
	/**
	 * [tMap_2 end ] start
	 */

	

	
	
	currentComponent="tMap_2";
	
	


// ###############################
// # Lookup hashes releasing
// ###############################      
				log.debug("tMap_2 - Written records count in the table 'copyOftoLog': " + count_copyOftoLog_tMap_2 + ".");
				log.debug("tMap_2 - Written records count in the table 'copyOftoMySql': " + count_copyOftoMySql_tMap_2 + ".");





			 		if(runStat.updateStatAndLog(execStat,enableLogStash,resourceMap,iterateId,"row2",2,0,
			 			"tFileInputJSON_2","New Title - Json Load","tFileInputJSON","tMap_2","tMap_2","tMap","output")) {
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
	 * [tLogRow_2 end ] start
	 */

	

	
	
	currentComponent="tLogRow_2";
	
	


//////

                    
                    java.io.PrintStream consoleOut_tLogRow_2 = null;
                    if (globalMap.get("tLogRow_CONSOLE")!=null)
                    {
                    	consoleOut_tLogRow_2 = (java.io.PrintStream) globalMap.get("tLogRow_CONSOLE");
                    }
                    else
                    {
                    	consoleOut_tLogRow_2 = new java.io.PrintStream(new java.io.BufferedOutputStream(System.out));
                    	globalMap.put("tLogRow_CONSOLE",consoleOut_tLogRow_2);
                    }
                    
                    consoleOut_tLogRow_2.println(util_tLogRow_2.format().toString());
                    consoleOut_tLogRow_2.flush();
//////
globalMap.put("tLogRow_2_NB_LINE",nb_line_tLogRow_2);
                if(log.isInfoEnabled())
            log.info("tLogRow_2 - "  + ("Printed row count: ")  + (nb_line_tLogRow_2)  + (".") );

///////////////////////    			

			 		if(runStat.updateStatAndLog(execStat,enableLogStash,resourceMap,iterateId,"copyOftoLog",2,0,
			 			"tMap_2","tMap_2","tMap","tLogRow_2","tLogRow_2","tLogRow","output")) {
						talendJobLogProcess(globalMap);
					}
				
 
                if(log.isDebugEnabled())
            log.debug("tLogRow_2 - "  + ("Done.") );

ok_Hash.put("tLogRow_2", true);
end_Hash.put("tLogRow_2", System.currentTimeMillis());




/**
 * [tLogRow_2 end ] stop
 */




	
	/**
	 * [tDBOutput_2 end ] start
	 */

	

	
	
	currentComponent="tDBOutput_2";
	
	
			cLabel="new_title_basics table";
		



				
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

			 		if(runStat.updateStatAndLog(execStat,enableLogStash,resourceMap,iterateId,"copyOftoMySql",2,0,
			 			"tMap_2","tMap_2","tMap","tDBOutput_2","new_title_basics table","tMysqlOutput","output")) {
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
	 * [tFileInputJSON_2 finally ] start
	 */

	

	
	
	currentComponent="tFileInputJSON_2";
	
	
			cLabel="New Title - Json Load";
		

 



/**
 * [tFileInputJSON_2 finally ] stop
 */

	
	/**
	 * [tMap_2 finally ] start
	 */

	

	
	
	currentComponent="tMap_2";
	
	

 



/**
 * [tMap_2 finally ] stop
 */

	
	/**
	 * [tLogRow_2 finally ] start
	 */

	

	
	
	currentComponent="tLogRow_2";
	
	

 



/**
 * [tLogRow_2 finally ] stop
 */




	
	/**
	 * [tDBOutput_2 finally ] start
	 */

	

	
	
	currentComponent="tDBOutput_2";
	
	
			cLabel="new_title_basics table";
		



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
		

		globalMap.put("tFileInputJSON_2_SUBPROCESS_STATE", 1);
	}
	


public void tRunJob_4Process(final java.util.Map<String, Object> globalMap) throws TalendException {
	globalMap.put("tRunJob_4_SUBPROCESS_STATE", 0);

 final boolean execStat = this.execStat;
	
		mdcInfo.forEach(org.slf4j.MDC::put);
		org.slf4j.MDC.put("_subJobName", "tRunJob_4");
		org.slf4j.MDC.put("_subJobPid", "hL3bfg_" + subJobPidCounter.getAndIncrement());
	

	
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
	 * [tRunJob_4 begin ] start
	 */

	

	
		
		ok_Hash.put("tRunJob_4", false);
		start_Hash.put("tRunJob_4", System.currentTimeMillis());
		
	
	currentComponent="tRunJob_4";
	
	
		int tos_count_tRunJob_4 = 0;
		
                if(log.isDebugEnabled())
            log.debug("tRunJob_4 - "  + ("Start to work.") );
            if (log.isDebugEnabled()) {
                class BytesLimit65535_tRunJob_4{
                    public void limitLog4jByte() throws Exception{
                    StringBuilder log4jParamters_tRunJob_4 = new StringBuilder();
                    log4jParamters_tRunJob_4.append("Parameters:");
                            log4jParamters_tRunJob_4.append("USE_DYNAMIC_JOB" + " = " + "false");
                        log4jParamters_tRunJob_4.append(" | ");
                            log4jParamters_tRunJob_4.append("PROCESS" + " = " + "pre_job_log");
                        log4jParamters_tRunJob_4.append(" | ");
                            log4jParamters_tRunJob_4.append("USE_INDEPENDENT_PROCESS" + " = " + "false");
                        log4jParamters_tRunJob_4.append(" | ");
                            log4jParamters_tRunJob_4.append("DIE_ON_CHILD_ERROR" + " = " + "true");
                        log4jParamters_tRunJob_4.append(" | ");
                            log4jParamters_tRunJob_4.append("TRANSMIT_WHOLE_CONTEXT" + " = " + "false");
                        log4jParamters_tRunJob_4.append(" | ");
                            log4jParamters_tRunJob_4.append("CONTEXTPARAMS" + " = " + "[{PARAM_NAME_COLUMN="+("job_name")+", PARAM_VALUE_COLUMN="+("context.job_name")+"}, {PARAM_NAME_COLUMN="+("job_status")+", PARAM_VALUE_COLUMN="+("\"Error\"")+"}]");
                        log4jParamters_tRunJob_4.append(" | ");
                            log4jParamters_tRunJob_4.append("PROPAGATE_CHILD_RESULT" + " = " + "false");
                        log4jParamters_tRunJob_4.append(" | ");
                            log4jParamters_tRunJob_4.append("PRINT_PARAMETER" + " = " + "false");
                        log4jParamters_tRunJob_4.append(" | ");
                            log4jParamters_tRunJob_4.append("USE_DYNAMIC_CONTEXT" + " = " + "false");
                        log4jParamters_tRunJob_4.append(" | ");
                if(log.isDebugEnabled())
            log.debug("tRunJob_4 - "  + (log4jParamters_tRunJob_4) );
                    } 
                } 
            new BytesLimit65535_tRunJob_4().limitLog4jByte();
            }
			if(enableLogStash) {
				talendJobLog.addCM("tRunJob_4", "tRunJob_4", "tRunJob");
				talendJobLogProcess(globalMap);
			}
			


 



/**
 * [tRunJob_4 begin ] stop
 */
	
	/**
	 * [tRunJob_4 main ] start
	 */

	

	
	
	currentComponent="tRunJob_4";
	
	
	java.util.List<String> paraList_tRunJob_4 = new java.util.ArrayList<String>();
	
	        				paraList_tRunJob_4.add("--father_pid="+pid);
	      			
	        				paraList_tRunJob_4.add("--root_pid="+rootPid);
	      			
	        				paraList_tRunJob_4.add("--father_node=tRunJob_4");
	      			
	        				paraList_tRunJob_4.add("--context=Default");
	      			
			if(!"".equals(log4jLevel)){
				paraList_tRunJob_4.add("--log4jLevel="+log4jLevel);
			}
		
		if(enableLogStash){
			paraList_tRunJob_4.add("--audit.enabled="+enableLogStash);
		}
		
	//for feature:10589
	
		paraList_tRunJob_4.add("--stat_port=" + portStats);
	

	if(resuming_logs_dir_path != null){
		paraList_tRunJob_4.add("--resuming_logs_dir_path=" + resuming_logs_dir_path);
	}
	String childResumePath_tRunJob_4 = ResumeUtil.getChildJobCheckPointPath(resuming_checkpoint_path);
	String tRunJobName_tRunJob_4 = ResumeUtil.getRighttRunJob(resuming_checkpoint_path);
	if("tRunJob_4".equals(tRunJobName_tRunJob_4) && childResumePath_tRunJob_4 != null){
		paraList_tRunJob_4.add("--resuming_checkpoint_path=" + ResumeUtil.getChildJobCheckPointPath(resuming_checkpoint_path));
	}
	paraList_tRunJob_4.add("--parent_part_launcher=JOB:" + jobName + "/NODE:tRunJob_4");
	
	java.util.Map<String, Object> parentContextMap_tRunJob_4 = new java.util.HashMap<String, Object>();

	

	Object obj_tRunJob_4 = null;

	
		obj_tRunJob_4 = context.job_name;
		if(obj_tRunJob_4!=null) {
			if (obj_tRunJob_4.getClass().getName().equals("java.util.Date")) {
				paraList_tRunJob_4.add("--context_param job_name=" + ((java.util.Date) obj_tRunJob_4).getTime());
			} else {
				paraList_tRunJob_4.add("--context_param job_name=" + RuntimeUtils.tRunJobConvertContext(obj_tRunJob_4));
			}
		} else {
			paraList_tRunJob_4.add("--context_param job_name=" + NULL_VALUE_EXPRESSION_IN_COMMAND_STRING_FOR_CHILD_JOB_ONLY);
		}
		
		parentContextMap_tRunJob_4.put("job_name", obj_tRunJob_4);
	
		obj_tRunJob_4 = "Error";
		if(obj_tRunJob_4!=null) {
			if (obj_tRunJob_4.getClass().getName().equals("java.util.Date")) {
				paraList_tRunJob_4.add("--context_param job_status=" + ((java.util.Date) obj_tRunJob_4).getTime());
			} else {
				paraList_tRunJob_4.add("--context_param job_status=" + RuntimeUtils.tRunJobConvertContext(obj_tRunJob_4));
			}
		} else {
			paraList_tRunJob_4.add("--context_param job_status=" + NULL_VALUE_EXPRESSION_IN_COMMAND_STRING_FOR_CHILD_JOB_ONLY);
		}
		
		parentContextMap_tRunJob_4.put("job_status", obj_tRunJob_4);
	
	
		final_project.pre_job_log_0_1.pre_job_log childJob_tRunJob_4 = new final_project.pre_job_log_0_1.pre_job_log();
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
		  
		
			log.info("tRunJob_4 - The child job 'final_project.pre_job_log_0_1.pre_job_log' starts on the version '0.1' with the context 'Default'.");
		
		String[][] childReturn_tRunJob_4 = childJob_tRunJob_4.runJob((String[]) paraList_tRunJob_4.toArray(new String[paraList_tRunJob_4.size()]));
		
			log.info("tRunJob_4 - The child job 'final_project.pre_job_log_0_1.pre_job_log' is done.");
		
            if(childJob_tRunJob_4.getErrorCode() == null){
                globalMap.put("tRunJob_4_CHILD_RETURN_CODE", childJob_tRunJob_4.getStatus() != null && ("failure").equals(childJob_tRunJob_4.getStatus()) ? 1 : 0);
            }else{
                globalMap.put("tRunJob_4_CHILD_RETURN_CODE", childJob_tRunJob_4.getErrorCode());
            }
            if (childJob_tRunJob_4.getExceptionStackTrace() != null) {
                globalMap.put("tRunJob_4_CHILD_EXCEPTION_STACKTRACE", childJob_tRunJob_4.getExceptionStackTrace());
            }
                    errorCode = childJob_tRunJob_4.getErrorCode();
                if (childJob_tRunJob_4.getErrorCode() != null || ("failure").equals(childJob_tRunJob_4.getStatus())) {
                    java.lang.Exception ce_tRunJob_4 = childJob_tRunJob_4.getException();
                    throw new RuntimeException("Child job running failed.\n" + ((ce_tRunJob_4!=null) ? (ce_tRunJob_4.getClass().getName() + ": " + ce_tRunJob_4.getMessage()) : ""));
                }

 


	tos_count_tRunJob_4++;

/**
 * [tRunJob_4 main ] stop
 */
	
	/**
	 * [tRunJob_4 process_data_begin ] start
	 */

	

	
	
	currentComponent="tRunJob_4";
	
	

 



/**
 * [tRunJob_4 process_data_begin ] stop
 */
	
	/**
	 * [tRunJob_4 process_data_end ] start
	 */

	

	
	
	currentComponent="tRunJob_4";
	
	

 



/**
 * [tRunJob_4 process_data_end ] stop
 */
	
	/**
	 * [tRunJob_4 end ] start
	 */

	

	
	
	currentComponent="tRunJob_4";
	
	

 
                if(log.isDebugEnabled())
            log.debug("tRunJob_4 - "  + ("Done.") );

ok_Hash.put("tRunJob_4", true);
end_Hash.put("tRunJob_4", System.currentTimeMillis());




/**
 * [tRunJob_4 end ] stop
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
	 * [tRunJob_4 finally ] start
	 */

	

	
	
	currentComponent="tRunJob_4";
	
	

 



/**
 * [tRunJob_4 finally ] stop
 */
				}catch(java.lang.Exception e){	
					//ignore
				}catch(java.lang.Error error){
					//ignore
				}
				resourceMap = null;
			}
		

		globalMap.put("tRunJob_4_SUBPROCESS_STATE", 1);
	}
	


public void tRunJob_3Process(final java.util.Map<String, Object> globalMap) throws TalendException {
	globalMap.put("tRunJob_3_SUBPROCESS_STATE", 0);

 final boolean execStat = this.execStat;
	
		mdcInfo.forEach(org.slf4j.MDC::put);
		org.slf4j.MDC.put("_subJobName", "tRunJob_3");
		org.slf4j.MDC.put("_subJobPid", "A9rdoi_" + subJobPidCounter.getAndIncrement());
	

	
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
	 * [tRunJob_3 begin ] start
	 */

	

	
		
		ok_Hash.put("tRunJob_3", false);
		start_Hash.put("tRunJob_3", System.currentTimeMillis());
		
	
	currentComponent="tRunJob_3";
	
	
		int tos_count_tRunJob_3 = 0;
		
                if(log.isDebugEnabled())
            log.debug("tRunJob_3 - "  + ("Start to work.") );
            if (log.isDebugEnabled()) {
                class BytesLimit65535_tRunJob_3{
                    public void limitLog4jByte() throws Exception{
                    StringBuilder log4jParamters_tRunJob_3 = new StringBuilder();
                    log4jParamters_tRunJob_3.append("Parameters:");
                            log4jParamters_tRunJob_3.append("USE_DYNAMIC_JOB" + " = " + "false");
                        log4jParamters_tRunJob_3.append(" | ");
                            log4jParamters_tRunJob_3.append("PROCESS" + " = " + "pre_job_log");
                        log4jParamters_tRunJob_3.append(" | ");
                            log4jParamters_tRunJob_3.append("USE_INDEPENDENT_PROCESS" + " = " + "false");
                        log4jParamters_tRunJob_3.append(" | ");
                            log4jParamters_tRunJob_3.append("DIE_ON_CHILD_ERROR" + " = " + "true");
                        log4jParamters_tRunJob_3.append(" | ");
                            log4jParamters_tRunJob_3.append("TRANSMIT_WHOLE_CONTEXT" + " = " + "false");
                        log4jParamters_tRunJob_3.append(" | ");
                            log4jParamters_tRunJob_3.append("CONTEXTPARAMS" + " = " + "[{PARAM_NAME_COLUMN="+("job_name")+", PARAM_VALUE_COLUMN="+("context.job_name")+"}, {PARAM_NAME_COLUMN="+("job_status")+", PARAM_VALUE_COLUMN="+("\"Error\"")+"}]");
                        log4jParamters_tRunJob_3.append(" | ");
                            log4jParamters_tRunJob_3.append("PROPAGATE_CHILD_RESULT" + " = " + "false");
                        log4jParamters_tRunJob_3.append(" | ");
                            log4jParamters_tRunJob_3.append("PRINT_PARAMETER" + " = " + "false");
                        log4jParamters_tRunJob_3.append(" | ");
                            log4jParamters_tRunJob_3.append("USE_DYNAMIC_CONTEXT" + " = " + "false");
                        log4jParamters_tRunJob_3.append(" | ");
                if(log.isDebugEnabled())
            log.debug("tRunJob_3 - "  + (log4jParamters_tRunJob_3) );
                    } 
                } 
            new BytesLimit65535_tRunJob_3().limitLog4jByte();
            }
			if(enableLogStash) {
				talendJobLog.addCM("tRunJob_3", "tRunJob_3", "tRunJob");
				talendJobLogProcess(globalMap);
			}
			


 



/**
 * [tRunJob_3 begin ] stop
 */
	
	/**
	 * [tRunJob_3 main ] start
	 */

	

	
	
	currentComponent="tRunJob_3";
	
	
	java.util.List<String> paraList_tRunJob_3 = new java.util.ArrayList<String>();
	
	        				paraList_tRunJob_3.add("--father_pid="+pid);
	      			
	        				paraList_tRunJob_3.add("--root_pid="+rootPid);
	      			
	        				paraList_tRunJob_3.add("--father_node=tRunJob_3");
	      			
	        				paraList_tRunJob_3.add("--context=Default");
	      			
			if(!"".equals(log4jLevel)){
				paraList_tRunJob_3.add("--log4jLevel="+log4jLevel);
			}
		
		if(enableLogStash){
			paraList_tRunJob_3.add("--audit.enabled="+enableLogStash);
		}
		
	//for feature:10589
	
		paraList_tRunJob_3.add("--stat_port=" + portStats);
	

	if(resuming_logs_dir_path != null){
		paraList_tRunJob_3.add("--resuming_logs_dir_path=" + resuming_logs_dir_path);
	}
	String childResumePath_tRunJob_3 = ResumeUtil.getChildJobCheckPointPath(resuming_checkpoint_path);
	String tRunJobName_tRunJob_3 = ResumeUtil.getRighttRunJob(resuming_checkpoint_path);
	if("tRunJob_3".equals(tRunJobName_tRunJob_3) && childResumePath_tRunJob_3 != null){
		paraList_tRunJob_3.add("--resuming_checkpoint_path=" + ResumeUtil.getChildJobCheckPointPath(resuming_checkpoint_path));
	}
	paraList_tRunJob_3.add("--parent_part_launcher=JOB:" + jobName + "/NODE:tRunJob_3");
	
	java.util.Map<String, Object> parentContextMap_tRunJob_3 = new java.util.HashMap<String, Object>();

	

	Object obj_tRunJob_3 = null;

	
		obj_tRunJob_3 = context.job_name;
		if(obj_tRunJob_3!=null) {
			if (obj_tRunJob_3.getClass().getName().equals("java.util.Date")) {
				paraList_tRunJob_3.add("--context_param job_name=" + ((java.util.Date) obj_tRunJob_3).getTime());
			} else {
				paraList_tRunJob_3.add("--context_param job_name=" + RuntimeUtils.tRunJobConvertContext(obj_tRunJob_3));
			}
		} else {
			paraList_tRunJob_3.add("--context_param job_name=" + NULL_VALUE_EXPRESSION_IN_COMMAND_STRING_FOR_CHILD_JOB_ONLY);
		}
		
		parentContextMap_tRunJob_3.put("job_name", obj_tRunJob_3);
	
		obj_tRunJob_3 = "Error";
		if(obj_tRunJob_3!=null) {
			if (obj_tRunJob_3.getClass().getName().equals("java.util.Date")) {
				paraList_tRunJob_3.add("--context_param job_status=" + ((java.util.Date) obj_tRunJob_3).getTime());
			} else {
				paraList_tRunJob_3.add("--context_param job_status=" + RuntimeUtils.tRunJobConvertContext(obj_tRunJob_3));
			}
		} else {
			paraList_tRunJob_3.add("--context_param job_status=" + NULL_VALUE_EXPRESSION_IN_COMMAND_STRING_FOR_CHILD_JOB_ONLY);
		}
		
		parentContextMap_tRunJob_3.put("job_status", obj_tRunJob_3);
	
	
		final_project.pre_job_log_0_1.pre_job_log childJob_tRunJob_3 = new final_project.pre_job_log_0_1.pre_job_log();
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
		  
		
			log.info("tRunJob_3 - The child job 'final_project.pre_job_log_0_1.pre_job_log' starts on the version '0.1' with the context 'Default'.");
		
		String[][] childReturn_tRunJob_3 = childJob_tRunJob_3.runJob((String[]) paraList_tRunJob_3.toArray(new String[paraList_tRunJob_3.size()]));
		
			log.info("tRunJob_3 - The child job 'final_project.pre_job_log_0_1.pre_job_log' is done.");
		
            if(childJob_tRunJob_3.getErrorCode() == null){
                globalMap.put("tRunJob_3_CHILD_RETURN_CODE", childJob_tRunJob_3.getStatus() != null && ("failure").equals(childJob_tRunJob_3.getStatus()) ? 1 : 0);
            }else{
                globalMap.put("tRunJob_3_CHILD_RETURN_CODE", childJob_tRunJob_3.getErrorCode());
            }
            if (childJob_tRunJob_3.getExceptionStackTrace() != null) {
                globalMap.put("tRunJob_3_CHILD_EXCEPTION_STACKTRACE", childJob_tRunJob_3.getExceptionStackTrace());
            }
                    errorCode = childJob_tRunJob_3.getErrorCode();
                if (childJob_tRunJob_3.getErrorCode() != null || ("failure").equals(childJob_tRunJob_3.getStatus())) {
                    java.lang.Exception ce_tRunJob_3 = childJob_tRunJob_3.getException();
                    throw new RuntimeException("Child job running failed.\n" + ((ce_tRunJob_3!=null) ? (ce_tRunJob_3.getClass().getName() + ": " + ce_tRunJob_3.getMessage()) : ""));
                }

 


	tos_count_tRunJob_3++;

/**
 * [tRunJob_3 main ] stop
 */
	
	/**
	 * [tRunJob_3 process_data_begin ] start
	 */

	

	
	
	currentComponent="tRunJob_3";
	
	

 



/**
 * [tRunJob_3 process_data_begin ] stop
 */
	
	/**
	 * [tRunJob_3 process_data_end ] start
	 */

	

	
	
	currentComponent="tRunJob_3";
	
	

 



/**
 * [tRunJob_3 process_data_end ] stop
 */
	
	/**
	 * [tRunJob_3 end ] start
	 */

	

	
	
	currentComponent="tRunJob_3";
	
	

 
                if(log.isDebugEnabled())
            log.debug("tRunJob_3 - "  + ("Done.") );

ok_Hash.put("tRunJob_3", true);
end_Hash.put("tRunJob_3", System.currentTimeMillis());




/**
 * [tRunJob_3 end ] stop
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
	 * [tRunJob_3 finally ] start
	 */

	

	
	
	currentComponent="tRunJob_3";
	
	

 



/**
 * [tRunJob_3 finally ] stop
 */
				}catch(java.lang.Exception e){	
					//ignore
				}catch(java.lang.Error error){
					//ignore
				}
				resourceMap = null;
			}
		

		globalMap.put("tRunJob_3_SUBPROCESS_STATE", 1);
	}
	


public void tPrejob_1Process(final java.util.Map<String, Object> globalMap) throws TalendException {
	globalMap.put("tPrejob_1_SUBPROCESS_STATE", 0);

 final boolean execStat = this.execStat;
	
		mdcInfo.forEach(org.slf4j.MDC::put);
		org.slf4j.MDC.put("_subJobName", "tPrejob_1");
		org.slf4j.MDC.put("_subJobPid", "mv3w1q_" + subJobPidCounter.getAndIncrement());
	

	
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
		org.slf4j.MDC.put("_subJobPid", "aPoV2U_" + subJobPidCounter.getAndIncrement());
	

	
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
		org.slf4j.MDC.put("_subJobPid", "vMD93I_" + subJobPidCounter.getAndIncrement());
	

	
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
		org.slf4j.MDC.put("_subJobPid", "umkNvG_" + subJobPidCounter.getAndIncrement());
	

	
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
		org.slf4j.MDC.put("_subJobPid", "Tc3L86_" + subJobPidCounter.getAndIncrement());
	

	
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
        final json_staging_job json_staging_jobClass = new json_staging_job();

        int exitCode = json_staging_jobClass.runJobInTOS(args);
	        if(exitCode==0){
		        log.info("TalendJob: 'json_staging_job' - Done.");
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
			log.info("TalendJob: 'json_staging_job' - Start.");
		

                java.util.Set<Object> jobInfoKeys = jobInfo.keySet();
                for(Object jobInfoKey: jobInfoKeys) {
                    org.slf4j.MDC.put("_" + jobInfoKey.toString(), jobInfo.get(jobInfoKey).toString());
                }
                org.slf4j.MDC.put("_pid", pid);
                org.slf4j.MDC.put("_rootPid", rootPid);
                org.slf4j.MDC.put("_fatherPid", fatherPid);
                org.slf4j.MDC.put("_projectName", projectName);
                org.slf4j.MDC.put("_startTimestamp",java.time.ZonedDateTime.now(java.time.ZoneOffset.UTC ).format( java.time.format.DateTimeFormatter.ISO_INSTANT ));
                org.slf4j.MDC.put("_jobRepositoryId","_oJZUgJBkEe6j8p5IYOvuKQ");
                org.slf4j.MDC.put("_compiledAtTimestamp","2023-12-04T00:39:42.373509Z");

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
            java.io.InputStream inContext = json_staging_job.class.getClassLoader().getResourceAsStream("final_project/json_staging_job_0_1/contexts/" + contextStr + ".properties");
            if (inContext == null) {
                inContext = json_staging_job.class.getClassLoader().getResourceAsStream("config/contexts/" + contextStr + ".properties");
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
                        context.setContextType("new_name_file_path", "id_String");
                        if(context.getStringValue("new_name_file_path") == null) {
                            context.new_name_file_path = null;
                        } else {
                            context.new_name_file_path=(String) context.getProperty("new_name_file_path");
                        }
                        context.setContextType("new_title_file_path", "id_String");
                        if(context.getStringValue("new_title_file_path") == null) {
                            context.new_title_file_path = null;
                        } else {
                            context.new_title_file_path=(String) context.getProperty("new_title_file_path");
                        }
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
                        context.setContextType("MySqlLocal_Login", "id_String");
                        if(context.getStringValue("MySqlLocal_Login") == null) {
                            context.MySqlLocal_Login = null;
                        } else {
                            context.MySqlLocal_Login=(String) context.getProperty("MySqlLocal_Login");
                        }
                        context.setContextType("MySqlLocal_Port", "id_String");
                        if(context.getStringValue("MySqlLocal_Port") == null) {
                            context.MySqlLocal_Port = null;
                        } else {
                            context.MySqlLocal_Port=(String) context.getProperty("MySqlLocal_Port");
                        }
                        context.setContextType("MySqlLocal_AdditionalParams", "id_String");
                        if(context.getStringValue("MySqlLocal_AdditionalParams") == null) {
                            context.MySqlLocal_AdditionalParams = null;
                        } else {
                            context.MySqlLocal_AdditionalParams=(String) context.getProperty("MySqlLocal_AdditionalParams");
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
        if (parentContextMap != null && !parentContextMap.isEmpty()) {if (parentContextMap.containsKey("new_name_file_path")) {
                context.new_name_file_path = (String) parentContextMap.get("new_name_file_path");
            }if (parentContextMap.containsKey("new_title_file_path")) {
                context.new_title_file_path = (String) parentContextMap.get("new_title_file_path");
            }if (parentContextMap.containsKey("MySqlLocal_Password")) {
                context.MySqlLocal_Password = (java.lang.String) parentContextMap.get("MySqlLocal_Password");
            }if (parentContextMap.containsKey("MySqlLocal_Database")) {
                context.MySqlLocal_Database = (String) parentContextMap.get("MySqlLocal_Database");
            }if (parentContextMap.containsKey("MySqlLocal_Server")) {
                context.MySqlLocal_Server = (String) parentContextMap.get("MySqlLocal_Server");
            }if (parentContextMap.containsKey("MySqlLocal_Login")) {
                context.MySqlLocal_Login = (String) parentContextMap.get("MySqlLocal_Login");
            }if (parentContextMap.containsKey("MySqlLocal_Port")) {
                context.MySqlLocal_Port = (String) parentContextMap.get("MySqlLocal_Port");
            }if (parentContextMap.containsKey("MySqlLocal_AdditionalParams")) {
                context.MySqlLocal_AdditionalParams = (String) parentContextMap.get("MySqlLocal_AdditionalParams");
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
            log.info("TalendJob: 'json_staging_job' - Started.");
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
errorCode = null;tFileInputJSON_1Process(globalMap);
if(!"failure".equals(status)) { status = "end"; }
}catch (TalendException e_tFileInputJSON_1) {
globalMap.put("tFileInputJSON_1_SUBPROCESS_STATE", -1);

e_tFileInputJSON_1.printStackTrace();

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
            System.out.println((endUsedMemory - startUsedMemory) + " bytes memory increase when running : json_staging_job");
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
        log.info("TalendJob: 'json_staging_job' - Finished - status: " + status + " returnCode: " + returnCode );

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
 *     315076 characters generated by Talend Cloud Data Fabric 
 *     on the December 3, 2023 at 7:39:42 PM EST
 ************************************************************************************************/