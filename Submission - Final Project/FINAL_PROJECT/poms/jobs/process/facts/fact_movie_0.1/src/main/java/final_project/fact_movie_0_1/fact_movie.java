
package final_project.fact_movie_0_1;

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
 * Job: fact_movie Purpose: <br>
 * Description:  <br>
 * @author gorle.g@northeastern.edu
 * @version 8.0.1.20230913_0925-patch
 * @status 
 */
public class fact_movie implements TalendJob {
	static {System.setProperty("TalendJob.log", "fact_movie.log");}

	

	
	private static org.apache.logging.log4j.Logger log = org.apache.logging.log4j.LogManager.getLogger(fact_movie.class);
	

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
	private final String jobName = "fact_movie";
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
	

private final JobStructureCatcherUtils talendJobLog = new JobStructureCatcherUtils(jobName, "_5hUu8JE7Ee6zXrZhesgs5g", "0.1");
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
				fact_movie.this.exception = e;
			}
		}
		if (!(e instanceof TalendException)) {
		try {
			for (java.lang.reflect.Method m : this.getClass().getEnclosingClass().getMethods()) {
				if (m.getName().compareTo(currentComponent + "_error") == 0) {
					m.invoke(fact_movie.this, new Object[] { e , currentComponent, globalMap});
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
			
			public void tDBInput_2_error(Exception exception, String errorComponent, final java.util.Map<String, Object> globalMap) throws TalendException {
				
				end_Hash.put(errorComponent, System.currentTimeMillis());
				
				status = "failure";
				
					tDBInput_1_onSubJobError(exception, errorComponent, globalMap);
			}
			
			public void tDBInput_3_error(Exception exception, String errorComponent, final java.util.Map<String, Object> globalMap) throws TalendException {
				
				end_Hash.put(errorComponent, System.currentTimeMillis());
				
				status = "failure";
				
					tDBInput_1_onSubJobError(exception, errorComponent, globalMap);
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
			
			public void tAdvancedHash_row2_error(Exception exception, String errorComponent, final java.util.Map<String, Object> globalMap) throws TalendException {
				
				end_Hash.put(errorComponent, System.currentTimeMillis());
				
				status = "failure";
				
					tDBInput_1_onSubJobError(exception, errorComponent, globalMap);
			}
			
			public void tAdvancedHash_row3_error(Exception exception, String errorComponent, final java.util.Map<String, Object> globalMap) throws TalendException {
				
				end_Hash.put(errorComponent, System.currentTimeMillis());
				
				status = "failure";
				
					tDBInput_1_onSubJobError(exception, errorComponent, globalMap);
			}
			
			public void talendJobLog_error(Exception exception, String errorComponent, final java.util.Map<String, Object> globalMap) throws TalendException {
				
				end_Hash.put(errorComponent, System.currentTimeMillis());
				
				status = "failure";
				
					talendJobLog_onSubJobError(exception, errorComponent, globalMap);
			}
			
			public void tDBInput_1_onSubJobError(Exception exception, String errorComponent, final java.util.Map<String, Object> globalMap) throws TalendException {

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
	



public static class toTableStruct implements routines.system.IPersistableRow<toTableStruct> {
    final static byte[] commonByteArrayLock_FINAL_PROJECT_fact_movie = new byte[0];
    static byte[] commonByteArray_FINAL_PROJECT_fact_movie = new byte[0];
	protected static final int DEFAULT_HASHCODE = 1;
    protected static final int PRIME = 31;
    protected int hashCode = DEFAULT_HASHCODE;
    public boolean hashCodeDirty = true;

    public String loopKey;



	
			    public int Movie_ID;

				public int getMovie_ID () {
					return this.Movie_ID;
				}

				public Boolean Movie_IDIsNullable(){
				    return false;
				}
				public Boolean Movie_IDIsKey(){
				    return true;
				}
				public Integer Movie_IDLength(){
				    return null;
				}
				public Integer Movie_IDPrecision(){
				    return null;
				}
				public String Movie_IDDefault(){
				
					return null;
				
				}
				public String Movie_IDComment(){
				
				    return "";
				
				}
				public String Movie_IDPattern(){
				
					return "";
				
				}
				public String Movie_IDOriginalDbColumnName(){
				
					return "Movie_ID";
				
				}

				
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
				    return 10;
				}
				public Integer tconstPrecision(){
				    return null;
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

				
			    public Integer Run_Time;

				public Integer getRun_Time () {
					return this.Run_Time;
				}

				public Boolean Run_TimeIsNullable(){
				    return true;
				}
				public Boolean Run_TimeIsKey(){
				    return false;
				}
				public Integer Run_TimeLength(){
				    return null;
				}
				public Integer Run_TimePrecision(){
				    return null;
				}
				public String Run_TimeDefault(){
				
					return null;
				
				}
				public String Run_TimeComment(){
				
				    return "";
				
				}
				public String Run_TimePattern(){
				
					return "";
				
				}
				public String Run_TimeOriginalDbColumnName(){
				
					return "Run_Time";
				
				}

				
			    public Double Rating;

				public Double getRating () {
					return this.Rating;
				}

				public Boolean RatingIsNullable(){
				    return true;
				}
				public Boolean RatingIsKey(){
				    return false;
				}
				public Integer RatingLength(){
				    return null;
				}
				public Integer RatingPrecision(){
				    return null;
				}
				public String RatingDefault(){
				
					return null;
				
				}
				public String RatingComment(){
				
				    return "";
				
				}
				public String RatingPattern(){
				
					return "";
				
				}
				public String RatingOriginalDbColumnName(){
				
					return "Rating";
				
				}

				
			    public Integer Num_Votes;

				public Integer getNum_Votes () {
					return this.Num_Votes;
				}

				public Boolean Num_VotesIsNullable(){
				    return true;
				}
				public Boolean Num_VotesIsKey(){
				    return false;
				}
				public Integer Num_VotesLength(){
				    return null;
				}
				public Integer Num_VotesPrecision(){
				    return null;
				}
				public String Num_VotesDefault(){
				
					return null;
				
				}
				public String Num_VotesComment(){
				
				    return "";
				
				}
				public String Num_VotesPattern(){
				
					return "";
				
				}
				public String Num_VotesOriginalDbColumnName(){
				
					return "Num_Votes";
				
				}

				
			    public Integer Year;

				public Integer getYear () {
					return this.Year;
				}

				public Boolean YearIsNullable(){
				    return true;
				}
				public Boolean YearIsKey(){
				    return false;
				}
				public Integer YearLength(){
				    return 4;
				}
				public Integer YearPrecision(){
				    return null;
				}
				public String YearDefault(){
				
					return null;
				
				}
				public String YearComment(){
				
				    return "";
				
				}
				public String YearPattern(){
				
					return "";
				
				}
				public String YearOriginalDbColumnName(){
				
					return "Year";
				
				}

				
			    public Integer Title_SK;

				public Integer getTitle_SK () {
					return this.Title_SK;
				}

				public Boolean Title_SKIsNullable(){
				    return true;
				}
				public Boolean Title_SKIsKey(){
				    return false;
				}
				public Integer Title_SKLength(){
				    return null;
				}
				public Integer Title_SKPrecision(){
				    return null;
				}
				public String Title_SKDefault(){
				
					return null;
				
				}
				public String Title_SKComment(){
				
				    return "";
				
				}
				public String Title_SKPattern(){
				
					return "";
				
				}
				public String Title_SKOriginalDbColumnName(){
				
					return "Title_SK";
				
				}

				
			    public Integer Worldwide_Gross;

				public Integer getWorldwide_Gross () {
					return this.Worldwide_Gross;
				}

				public Boolean Worldwide_GrossIsNullable(){
				    return true;
				}
				public Boolean Worldwide_GrossIsKey(){
				    return false;
				}
				public Integer Worldwide_GrossLength(){
				    return null;
				}
				public Integer Worldwide_GrossPrecision(){
				    return null;
				}
				public String Worldwide_GrossDefault(){
				
					return null;
				
				}
				public String Worldwide_GrossComment(){
				
				    return "";
				
				}
				public String Worldwide_GrossPattern(){
				
					return "";
				
				}
				public String Worldwide_GrossOriginalDbColumnName(){
				
					return "Worldwide_Gross";
				
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

				


	@Override
	public int hashCode() {
		if (this.hashCodeDirty) {
			final int prime = PRIME;
			int result = DEFAULT_HASHCODE;
	
							result = prime * result + (int) this.Movie_ID;
						
    		this.hashCode = result;
    		this.hashCodeDirty = false;
		}
		return this.hashCode;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) return true;
		if (obj == null) return false;
		if (getClass() != obj.getClass()) return false;
		final toTableStruct other = (toTableStruct) obj;
		
						if (this.Movie_ID != other.Movie_ID)
							return false;
					

		return true;
    }

	public void copyDataTo(toTableStruct other) {

		other.Movie_ID = this.Movie_ID;
	            other.tconst = this.tconst;
	            other.Run_Time = this.Run_Time;
	            other.Rating = this.Rating;
	            other.Num_Votes = this.Num_Votes;
	            other.Year = this.Year;
	            other.Title_SK = this.Title_SK;
	            other.Worldwide_Gross = this.Worldwide_Gross;
	            other.DI_CreatedDate = this.DI_CreatedDate;
	            other.DI_WorkflowJobId = this.DI_WorkflowJobId;
	            
	}

	public void copyKeysDataTo(toTableStruct other) {

		other.Movie_ID = this.Movie_ID;
	            	
	}




	private String readString(ObjectInputStream dis) throws IOException{
		String strReturn = null;
		int length = 0;
        length = dis.readInt();
		if (length == -1) {
			strReturn = null;
		} else {
			if(length > commonByteArray_FINAL_PROJECT_fact_movie.length) {
				if(length < 1024 && commonByteArray_FINAL_PROJECT_fact_movie.length == 0) {
   					commonByteArray_FINAL_PROJECT_fact_movie = new byte[1024];
				} else {
   					commonByteArray_FINAL_PROJECT_fact_movie = new byte[2 * length];
   				}
			}
			dis.readFully(commonByteArray_FINAL_PROJECT_fact_movie, 0, length);
			strReturn = new String(commonByteArray_FINAL_PROJECT_fact_movie, 0, length, utf8Charset);
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
			if(length > commonByteArray_FINAL_PROJECT_fact_movie.length) {
				if(length < 1024 && commonByteArray_FINAL_PROJECT_fact_movie.length == 0) {
   					commonByteArray_FINAL_PROJECT_fact_movie = new byte[1024];
				} else {
   					commonByteArray_FINAL_PROJECT_fact_movie = new byte[2 * length];
   				}
			}
			unmarshaller.readFully(commonByteArray_FINAL_PROJECT_fact_movie, 0, length);
			strReturn = new String(commonByteArray_FINAL_PROJECT_fact_movie, 0, length, utf8Charset);
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

		synchronized(commonByteArrayLock_FINAL_PROJECT_fact_movie) {

        	try {

        		int length = 0;
		
			        this.Movie_ID = dis.readInt();
					
					this.tconst = readString(dis);
					
						this.Run_Time = readInteger(dis);
					
			            length = dis.readByte();
           				if (length == -1) {
           	    			this.Rating = null;
           				} else {
           			    	this.Rating = dis.readDouble();
           				}
					
						this.Num_Votes = readInteger(dis);
					
						this.Year = readInteger(dis);
					
						this.Title_SK = readInteger(dis);
					
						this.Worldwide_Gross = readInteger(dis);
					
					this.DI_CreatedDate = readDate(dis);
					
					this.DI_WorkflowJobId = readString(dis);
					
        	} catch (IOException e) {
	            throw new RuntimeException(e);

		

        }

		

      }


    }
    
    public void readData(org.jboss.marshalling.Unmarshaller dis) {

		synchronized(commonByteArrayLock_FINAL_PROJECT_fact_movie) {

        	try {

        		int length = 0;
		
			        this.Movie_ID = dis.readInt();
					
					this.tconst = readString(dis);
					
						this.Run_Time = readInteger(dis);
					
			            length = dis.readByte();
           				if (length == -1) {
           	    			this.Rating = null;
           				} else {
           			    	this.Rating = dis.readDouble();
           				}
					
						this.Num_Votes = readInteger(dis);
					
						this.Year = readInteger(dis);
					
						this.Title_SK = readInteger(dis);
					
						this.Worldwide_Gross = readInteger(dis);
					
					this.DI_CreatedDate = readDate(dis);
					
					this.DI_WorkflowJobId = readString(dis);
					
        	} catch (IOException e) {
	            throw new RuntimeException(e);

		

        }

		

      }


    }

    public void writeData(ObjectOutputStream dos) {
        try {

		
					// int
				
		            	dos.writeInt(this.Movie_ID);
					
					// String
				
						writeString(this.tconst,dos);
					
					// Integer
				
						writeInteger(this.Run_Time,dos);
					
					// Double
				
						if(this.Rating == null) {
			                dos.writeByte(-1);
						} else {
               				dos.writeByte(0);
           			    	dos.writeDouble(this.Rating);
		            	}
					
					// Integer
				
						writeInteger(this.Num_Votes,dos);
					
					// Integer
				
						writeInteger(this.Year,dos);
					
					// Integer
				
						writeInteger(this.Title_SK,dos);
					
					// Integer
				
						writeInteger(this.Worldwide_Gross,dos);
					
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

		
					// int
				
		            	dos.writeInt(this.Movie_ID);
					
					// String
				
						writeString(this.tconst,dos);
					
					// Integer
				
						writeInteger(this.Run_Time,dos);
					
					// Double
				
						if(this.Rating == null) {
			                dos.writeByte(-1);
						} else {
               				dos.writeByte(0);
           			    	dos.writeDouble(this.Rating);
		            	}
					
					// Integer
				
						writeInteger(this.Num_Votes,dos);
					
					// Integer
				
						writeInteger(this.Year,dos);
					
					// Integer
				
						writeInteger(this.Title_SK,dos);
					
					// Integer
				
						writeInteger(this.Worldwide_Gross,dos);
					
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
		sb.append("Movie_ID="+String.valueOf(Movie_ID));
		sb.append(",tconst="+tconst);
		sb.append(",Run_Time="+String.valueOf(Run_Time));
		sb.append(",Rating="+String.valueOf(Rating));
		sb.append(",Num_Votes="+String.valueOf(Num_Votes));
		sb.append(",Year="+String.valueOf(Year));
		sb.append(",Title_SK="+String.valueOf(Title_SK));
		sb.append(",Worldwide_Gross="+String.valueOf(Worldwide_Gross));
		sb.append(",DI_CreatedDate="+String.valueOf(DI_CreatedDate));
		sb.append(",DI_WorkflowJobId="+DI_WorkflowJobId);
	    sb.append("]");

	    return sb.toString();
    }
        public String toLogString(){
        	StringBuilder sb = new StringBuilder();
        	
        				sb.append(Movie_ID);
        			
        			sb.append("|");
        		
        				if(tconst == null){
        					sb.append("<null>");
        				}else{
            				sb.append(tconst);
            			}
            		
        			sb.append("|");
        		
        				if(Run_Time == null){
        					sb.append("<null>");
        				}else{
            				sb.append(Run_Time);
            			}
            		
        			sb.append("|");
        		
        				if(Rating == null){
        					sb.append("<null>");
        				}else{
            				sb.append(Rating);
            			}
            		
        			sb.append("|");
        		
        				if(Num_Votes == null){
        					sb.append("<null>");
        				}else{
            				sb.append(Num_Votes);
            			}
            		
        			sb.append("|");
        		
        				if(Year == null){
        					sb.append("<null>");
        				}else{
            				sb.append(Year);
            			}
            		
        			sb.append("|");
        		
        				if(Title_SK == null){
        					sb.append("<null>");
        				}else{
            				sb.append(Title_SK);
            			}
            		
        			sb.append("|");
        		
        				if(Worldwide_Gross == null){
        					sb.append("<null>");
        				}else{
            				sb.append(Worldwide_Gross);
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
    public int compareTo(toTableStruct other) {

		int returnValue = -1;
		
						returnValue = checkNullsAndCompare(this.Movie_ID, other.Movie_ID);
						if(returnValue != 0) {
							return returnValue;
						}

					
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
    final static byte[] commonByteArrayLock_FINAL_PROJECT_fact_movie = new byte[0];
    static byte[] commonByteArray_FINAL_PROJECT_fact_movie = new byte[0];

	
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

				



	private String readString(ObjectInputStream dis) throws IOException{
		String strReturn = null;
		int length = 0;
        length = dis.readInt();
		if (length == -1) {
			strReturn = null;
		} else {
			if(length > commonByteArray_FINAL_PROJECT_fact_movie.length) {
				if(length < 1024 && commonByteArray_FINAL_PROJECT_fact_movie.length == 0) {
   					commonByteArray_FINAL_PROJECT_fact_movie = new byte[1024];
				} else {
   					commonByteArray_FINAL_PROJECT_fact_movie = new byte[2 * length];
   				}
			}
			dis.readFully(commonByteArray_FINAL_PROJECT_fact_movie, 0, length);
			strReturn = new String(commonByteArray_FINAL_PROJECT_fact_movie, 0, length, utf8Charset);
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
			if(length > commonByteArray_FINAL_PROJECT_fact_movie.length) {
				if(length < 1024 && commonByteArray_FINAL_PROJECT_fact_movie.length == 0) {
   					commonByteArray_FINAL_PROJECT_fact_movie = new byte[1024];
				} else {
   					commonByteArray_FINAL_PROJECT_fact_movie = new byte[2 * length];
   				}
			}
			unmarshaller.readFully(commonByteArray_FINAL_PROJECT_fact_movie, 0, length);
			strReturn = new String(commonByteArray_FINAL_PROJECT_fact_movie, 0, length, utf8Charset);
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

		synchronized(commonByteArrayLock_FINAL_PROJECT_fact_movie) {

        	try {

        		int length = 0;
		
					this.tconst = readString(dis);
					
					this.runtimeMinutes = readString(dis);
					
					this.startYear = readString(dis);
					
        	} catch (IOException e) {
	            throw new RuntimeException(e);

		

        }

		

      }


    }
    
    public void readData(org.jboss.marshalling.Unmarshaller dis) {

		synchronized(commonByteArrayLock_FINAL_PROJECT_fact_movie) {

        	try {

        		int length = 0;
		
					this.tconst = readString(dis);
					
					this.runtimeMinutes = readString(dis);
					
					this.startYear = readString(dis);
					
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
				
						writeString(this.runtimeMinutes,dos);
					
					// String
				
						writeString(this.startYear,dos);
					
        	} catch (IOException e) {
	            throw new RuntimeException(e);
        }


    }
    
    public void writeData(org.jboss.marshalling.Marshaller dos) {
        try {

		
					// String
				
						writeString(this.tconst,dos);
					
					// String
				
						writeString(this.runtimeMinutes,dos);
					
					// String
				
						writeString(this.startYear,dos);
					
        	} catch (IOException e) {
	            throw new RuntimeException(e);
        }


    }


    public String toString() {

		StringBuilder sb = new StringBuilder();
		sb.append(super.toString());
		sb.append("[");
		sb.append("tconst="+tconst);
		sb.append(",runtimeMinutes="+runtimeMinutes);
		sb.append(",startYear="+startYear);
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
        		
        				if(runtimeMinutes == null){
        					sb.append("<null>");
        				}else{
            				sb.append(runtimeMinutes);
            			}
            		
        			sb.append("|");
        		
        				if(startYear == null){
        					sb.append("<null>");
        				}else{
            				sb.append(startYear);
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

public static class after_tDBInput_1Struct implements routines.system.IPersistableRow<after_tDBInput_1Struct> {
    final static byte[] commonByteArrayLock_FINAL_PROJECT_fact_movie = new byte[0];
    static byte[] commonByteArray_FINAL_PROJECT_fact_movie = new byte[0];

	
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

				



	private String readString(ObjectInputStream dis) throws IOException{
		String strReturn = null;
		int length = 0;
        length = dis.readInt();
		if (length == -1) {
			strReturn = null;
		} else {
			if(length > commonByteArray_FINAL_PROJECT_fact_movie.length) {
				if(length < 1024 && commonByteArray_FINAL_PROJECT_fact_movie.length == 0) {
   					commonByteArray_FINAL_PROJECT_fact_movie = new byte[1024];
				} else {
   					commonByteArray_FINAL_PROJECT_fact_movie = new byte[2 * length];
   				}
			}
			dis.readFully(commonByteArray_FINAL_PROJECT_fact_movie, 0, length);
			strReturn = new String(commonByteArray_FINAL_PROJECT_fact_movie, 0, length, utf8Charset);
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
			if(length > commonByteArray_FINAL_PROJECT_fact_movie.length) {
				if(length < 1024 && commonByteArray_FINAL_PROJECT_fact_movie.length == 0) {
   					commonByteArray_FINAL_PROJECT_fact_movie = new byte[1024];
				} else {
   					commonByteArray_FINAL_PROJECT_fact_movie = new byte[2 * length];
   				}
			}
			unmarshaller.readFully(commonByteArray_FINAL_PROJECT_fact_movie, 0, length);
			strReturn = new String(commonByteArray_FINAL_PROJECT_fact_movie, 0, length, utf8Charset);
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

		synchronized(commonByteArrayLock_FINAL_PROJECT_fact_movie) {

        	try {

        		int length = 0;
		
					this.tconst = readString(dis);
					
					this.runtimeMinutes = readString(dis);
					
					this.startYear = readString(dis);
					
        	} catch (IOException e) {
	            throw new RuntimeException(e);

		

        }

		

      }


    }
    
    public void readData(org.jboss.marshalling.Unmarshaller dis) {

		synchronized(commonByteArrayLock_FINAL_PROJECT_fact_movie) {

        	try {

        		int length = 0;
		
					this.tconst = readString(dis);
					
					this.runtimeMinutes = readString(dis);
					
					this.startYear = readString(dis);
					
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
				
						writeString(this.runtimeMinutes,dos);
					
					// String
				
						writeString(this.startYear,dos);
					
        	} catch (IOException e) {
	            throw new RuntimeException(e);
        }


    }
    
    public void writeData(org.jboss.marshalling.Marshaller dos) {
        try {

		
					// String
				
						writeString(this.tconst,dos);
					
					// String
				
						writeString(this.runtimeMinutes,dos);
					
					// String
				
						writeString(this.startYear,dos);
					
        	} catch (IOException e) {
	            throw new RuntimeException(e);
        }


    }


    public String toString() {

		StringBuilder sb = new StringBuilder();
		sb.append(super.toString());
		sb.append("[");
		sb.append("tconst="+tconst);
		sb.append(",runtimeMinutes="+runtimeMinutes);
		sb.append(",startYear="+startYear);
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
        		
        				if(runtimeMinutes == null){
        					sb.append("<null>");
        				}else{
            				sb.append(runtimeMinutes);
            			}
            		
        			sb.append("|");
        		
        				if(startYear == null){
        					sb.append("<null>");
        				}else{
            				sb.append(startYear);
            			}
            		
        			sb.append("|");
        		
        	return sb.toString();
        }

    /**
     * Compare keys
     */
    public int compareTo(after_tDBInput_1Struct other) {

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
		org.slf4j.MDC.put("_subJobPid", "4toGjl_" + subJobPidCounter.getAndIncrement());
	

	
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


		tDBInput_2Process(globalMap);
		tDBInput_3Process(globalMap);

		row1Struct row1 = new row1Struct();
toTableStruct toTable = new toTableStruct();





	
	/**
	 * [tDBOutput_1 begin ] start
	 */

	

	
		
		ok_Hash.put("tDBOutput_1", false);
		start_Hash.put("tDBOutput_1", System.currentTimeMillis());
		
	
	currentComponent="tDBOutput_1";
	
	
			cLabel="fact_movie";
		
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
                            log4jParamters_tDBOutput_1.append("TABLE" + " = " + "\"fact_movie\"");
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
				talendJobLog.addCM("tDBOutput_1", "fact_movie", "tMysqlOutput");
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

String tableName_tDBOutput_1 = "fact_movie";
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
                                    if(table_tDBOutput_1.equalsIgnoreCase("fact_movie")) {
                                        whetherExist_tDBOutput_1 = true;
                                        break;
                                    }
                                }
                                if(!whetherExist_tDBOutput_1) {
                                    try (java.sql.Statement stmtCreate_tDBOutput_1 = conn_tDBOutput_1.createStatement()) {
                if(log.isDebugEnabled())
            log.debug("tDBOutput_1 - "  + ("Creating")  + (" table '")  + (tableName_tDBOutput_1)  + ("'.") );
                                        stmtCreate_tDBOutput_1.execute("CREATE TABLE `" + tableName_tDBOutput_1 + "`(`Movie_ID` INT(0)   not null ,`tconst` VARCHAR(10)  ,`Run_Time` INT(0)  ,`Rating` DOUBLE default 0  not null ,`Num_Votes` INT(0)  default 0  not null ,`Year` INT(4)  default 0  not null ,`Title_SK` INT(0)  ,`Worldwide_Gross` INT(0)  default 0 ,`DI_CreatedDate` DATETIME ,`DI_WorkflowJobId` VARCHAR(8)  ,primary key(`Movie_ID`))");
                if(log.isDebugEnabled())
            log.debug("tDBOutput_1 - "  + ("Create")  + (" table '")  + (tableName_tDBOutput_1)  + ("' has succeeded.") );
                                    }
                                }
			

		
						String insert_tDBOutput_1 = "INSERT INTO `" + "fact_movie" + "` (`Movie_ID`,`tconst`,`Run_Time`,`Rating`,`Num_Votes`,`Year`,`Title_SK`,`Worldwide_Gross`,`DI_CreatedDate`,`DI_WorkflowJobId`) VALUES (?,?,?,?,?,?,?,?,?,?)";
		
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
		
		int count_row2_tMap_1 = 0;
		
		int count_row3_tMap_1 = 0;
		
	
		org.talend.designer.components.lookup.memory.AdvancedMemoryLookup<row2Struct> tHash_Lookup_row2 = (org.talend.designer.components.lookup.memory.AdvancedMemoryLookup<row2Struct>) 
				((org.talend.designer.components.lookup.memory.AdvancedMemoryLookup<row2Struct>) 
					globalMap.get( "tHash_Lookup_row2" ))
					;					
					
	

row2Struct row2HashKey = new row2Struct();
row2Struct row2Default = new row2Struct();
	
		org.talend.designer.components.lookup.memory.AdvancedMemoryLookup<row3Struct> tHash_Lookup_row3 = (org.talend.designer.components.lookup.memory.AdvancedMemoryLookup<row3Struct>) 
				((org.talend.designer.components.lookup.memory.AdvancedMemoryLookup<row3Struct>) 
					globalMap.get( "tHash_Lookup_row3" ))
					;					
					
	

row3Struct row3HashKey = new row3Struct();
row3Struct row3Default = new row3Struct();
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
	
	
			cLabel="stg_movie_details";
		
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
                            log4jParamters_tDBInput_1.append("TABLE" + " = " + "\"stg_movie_details\"");
                        log4jParamters_tDBInput_1.append(" | ");
                            log4jParamters_tDBInput_1.append("QUERYSTORE" + " = " + "\"\"");
                        log4jParamters_tDBInput_1.append(" | ");
                            log4jParamters_tDBInput_1.append("QUERY" + " = " + "\"SELECT tconst, runtimeMinutes, startYear FROM stg_movie_details;\"");
                        log4jParamters_tDBInput_1.append(" | ");
                            log4jParamters_tDBInput_1.append("SPECIFY_DATASOURCE_ALIAS" + " = " + "false");
                        log4jParamters_tDBInput_1.append(" | ");
                            log4jParamters_tDBInput_1.append("PROPERTIES" + " = " + "context.MySqlLocal_AdditionalParams");
                        log4jParamters_tDBInput_1.append(" | ");
                            log4jParamters_tDBInput_1.append("ENABLE_STREAM" + " = " + "false");
                        log4jParamters_tDBInput_1.append(" | ");
                            log4jParamters_tDBInput_1.append("TRIM_ALL_COLUMN" + " = " + "false");
                        log4jParamters_tDBInput_1.append(" | ");
                            log4jParamters_tDBInput_1.append("TRIM_COLUMN" + " = " + "[{TRIM="+("false")+", SCHEMA_COLUMN="+("tconst")+"}, {TRIM="+("false")+", SCHEMA_COLUMN="+("runtimeMinutes")+"}, {TRIM="+("false")+", SCHEMA_COLUMN="+("startYear")+"}]");
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
				talendJobLog.addCM("tDBInput_1", "stg_movie_details", "tMysqlInput");
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

		    String dbquery_tDBInput_1 = "SELECT tconst, runtimeMinutes, startYear FROM stg_movie_details;";
		    
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
								row1.tconst = null;
							} else {
	                         		
        	row1.tconst = routines.system.JDBCUtil.getString(rs_tDBInput_1, 1, false);
		                    }
							if(colQtyInRs_tDBInput_1 < 2) {
								row1.runtimeMinutes = null;
							} else {
	                         		
        	row1.runtimeMinutes = routines.system.JDBCUtil.getString(rs_tDBInput_1, 2, false);
		                    }
							if(colQtyInRs_tDBInput_1 < 3) {
								row1.startYear = null;
							} else {
	                         		
        	row1.startYear = routines.system.JDBCUtil.getString(rs_tDBInput_1, 3, false);
		                    }
					
						log.debug("tDBInput_1 - Retrieving the record " + nb_line_tDBInput_1 + ".");
					

 



/**
 * [tDBInput_1 begin ] stop
 */
	
	/**
	 * [tDBInput_1 main ] start
	 */

	

	
	
	currentComponent="tDBInput_1";
	
	
			cLabel="stg_movie_details";
		

 


	tos_count_tDBInput_1++;

/**
 * [tDBInput_1 main ] stop
 */
	
	/**
	 * [tDBInput_1 process_data_begin ] start
	 */

	

	
	
	currentComponent="tDBInput_1";
	
	
			cLabel="stg_movie_details";
		

 



/**
 * [tDBInput_1 process_data_begin ] stop
 */

	
	/**
	 * [tMap_1 main ] start
	 */

	

	
	
	currentComponent="tMap_1";
	
	
			if(runStat.update(execStat,enableLogStash,iterateId,1,1
				
					,"row1","tDBInput_1","stg_movie_details","tMysqlInput","tMap_1","tMap_1","tMap"
				
			)) {
				talendJobLogProcess(globalMap);
			}
			
    			if(log.isTraceEnabled()){
    				log.trace("row1 - " + (row1==null? "": row1.toLogString()));
    			}
    		

		
		
		boolean hasCasePrimitiveKeyWithNull_tMap_1 = false;
		
						row2Struct row2 = null;
					
						row3Struct row3 = null;
					
		// ###############################
		// # Input tables (lookups)
		
		boolean rejectedInnerJoin_tMap_1 = false;
		boolean mainRowRejected_tMap_1 = false;
		

				///////////////////////////////////////////////
				// Starting Lookup Table "row2" 
				///////////////////////////////////////////////


				
				
                            
 					    boolean forceLooprow2 = false;
       		  	    	
       		  	    	
 							row2Struct row2ObjectFromLookup = null;
                          
		           		  	if(!rejectedInnerJoin_tMap_1) { // G_TM_M_020

								
								hasCasePrimitiveKeyWithNull_tMap_1 = false;
								
                        		    		    row2HashKey.tconst = row1.tconst ;
                        		    		

								
		                        	row2HashKey.hashCodeDirty = true;
                        		
	  					
	  							
			  					
			  					
	  					
		  							tHash_Lookup_row2.lookup( row2HashKey );

	  							

	  							

 								
		  				
	  								
						
									
  									  		
 								



							} // G_TM_M_020
			           		  	  
							
				           		if(tHash_Lookup_row2 != null && tHash_Lookup_row2.getCount(row2HashKey) > 1) { // G 071
			  							
			  						
									 		
									//System.out.println("WARNING: UNIQUE MATCH is configured for the lookup 'row2' and it contains more one result from keys :  row2.tconst = '" + row2HashKey.tconst + "'");
								} // G 071
							

							
                    		  	 
							   
                    		  	 
	       		  	    	row2Struct fromLookup_row2 = null;
							row2 = row2Default;
										 
							
								 
							
							
								if (tHash_Lookup_row2 !=null && tHash_Lookup_row2.hasNext()) { // G 099
								
							
								
								fromLookup_row2 = tHash_Lookup_row2.next();

							
							
								} // G 099
							
							

							if(fromLookup_row2 != null) {
								row2 = fromLookup_row2;
							}
							
							
							
			  							
								
	                    		  	
		                    
	            	
	           	
	            	
	            	
	            

				///////////////////////////////////////////////
				// Starting Lookup Table "row3" 
				///////////////////////////////////////////////


				
				
                            
 					    boolean forceLooprow3 = false;
       		  	    	
       		  	    	
 							row3Struct row3ObjectFromLookup = null;
                          
		           		  	if(!rejectedInnerJoin_tMap_1) { // G_TM_M_020

								
								hasCasePrimitiveKeyWithNull_tMap_1 = false;
								
                        		    		    row3HashKey.tconst = row1.tconst ;
                        		    		

								
		                        	row3HashKey.hashCodeDirty = true;
                        		
	  					
	  							
			  					
			  					
	  					
		  							tHash_Lookup_row3.lookup( row3HashKey );

	  							

	  							

 								
		  				
	  								
						
									
  									  		
 								



							} // G_TM_M_020
			           		  	  
							
				           		if(tHash_Lookup_row3 != null && tHash_Lookup_row3.getCount(row3HashKey) > 1) { // G 071
			  							
			  						
									 		
									//System.out.println("WARNING: UNIQUE MATCH is configured for the lookup 'row3' and it contains more one result from keys :  row3.tconst = '" + row3HashKey.tconst + "'");
								} // G 071
							

							
                    		  	 
							   
                    		  	 
	       		  	    	row3Struct fromLookup_row3 = null;
							row3 = row3Default;
										 
							
								 
							
							
								if (tHash_Lookup_row3 !=null && tHash_Lookup_row3.hasNext()) { // G 099
								
							
								
								fromLookup_row3 = tHash_Lookup_row3.next();

							
							
								} // G 099
							
							

							if(fromLookup_row3 != null) {
								row3 = fromLookup_row3;
							}
							
							
							
			  							
								
	                    		  	
		                    
	            	
	            	
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

toTable_tmp.Movie_ID = Numeric.sequence("Movie_ID", 1, 1);
toTable_tmp.tconst = row1.tconst;
toTable_tmp.Run_Time = row1.runtimeMinutes.strip().equals("\\N") ? 0 : Integer.parseInt(row1.runtimeMinutes) ;
toTable_tmp.Rating = row2.averageRating == null ? 0 : row2.averageRating ;
toTable_tmp.Num_Votes = row2.numVotes == null ? 0 : row2.numVotes ;
toTable_tmp.Year = row1.startYear.strip().equals("\\N") ? 0 : Integer.parseInt(row1.startYear) ;
toTable_tmp.Title_SK = row3.Title_SK;
toTable_tmp.Worldwide_Gross = 0;
toTable_tmp.DI_CreatedDate = TalendDate.getCurrentDate();
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
	
	
			cLabel="fact_movie";
		
			if(runStat.update(execStat,enableLogStash,iterateId,1,1
				
					,"toTable","tMap_1","tMap_1","tMap","tDBOutput_1","fact_movie","tMysqlOutput"
				
			)) {
				talendJobLogProcess(globalMap);
			}
			
    			if(log.isTraceEnabled()){
    				log.trace("toTable - " + (toTable==null? "": toTable.toLogString()));
    			}
    		



        whetherReject_tDBOutput_1 = false;
                            pstmt_tDBOutput_1.setInt(1, toTable.Movie_ID);

                            if(toTable.tconst == null) {
pstmt_tDBOutput_1.setNull(2, java.sql.Types.VARCHAR);
} else {pstmt_tDBOutput_1.setString(2, toTable.tconst);
}

                            if(toTable.Run_Time == null) {
pstmt_tDBOutput_1.setNull(3, java.sql.Types.INTEGER);
} else {pstmt_tDBOutput_1.setInt(3, toTable.Run_Time);
}

                            pstmt_tDBOutput_1.setDouble(4, toTable.Rating);

                            pstmt_tDBOutput_1.setInt(5, toTable.Num_Votes);

                            pstmt_tDBOutput_1.setInt(6, toTable.Year);

                            if(toTable.Title_SK == null) {
pstmt_tDBOutput_1.setNull(7, java.sql.Types.INTEGER);
} else {pstmt_tDBOutput_1.setInt(7, toTable.Title_SK);
}

                            if(toTable.Worldwide_Gross == null) {
pstmt_tDBOutput_1.setNull(8, java.sql.Types.INTEGER);
} else {pstmt_tDBOutput_1.setInt(8, toTable.Worldwide_Gross);
}

                            if(toTable.DI_CreatedDate != null) {
date_tDBOutput_1 = toTable.DI_CreatedDate.getTime();
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
	
	
			cLabel="fact_movie";
		

 



/**
 * [tDBOutput_1 process_data_begin ] stop
 */
	
	/**
	 * [tDBOutput_1 process_data_end ] start
	 */

	

	
	
	currentComponent="tDBOutput_1";
	
	
			cLabel="fact_movie";
		

 



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
	
	
			cLabel="stg_movie_details";
		

 



/**
 * [tDBInput_1 process_data_end ] stop
 */
	
	/**
	 * [tDBInput_1 end ] start
	 */

	

	
	
	currentComponent="tDBInput_1";
	
	
			cLabel="stg_movie_details";
		

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
					if(tHash_Lookup_row2 != null) {
						tHash_Lookup_row2.endGet();
					}
					globalMap.remove( "tHash_Lookup_row2" );

					
					
				
					if(tHash_Lookup_row3 != null) {
						tHash_Lookup_row3.endGet();
					}
					globalMap.remove( "tHash_Lookup_row3" );

					
					
				
// ###############################      
				log.debug("tMap_1 - Written records count in the table 'toTable': " + count_toTable_tMap_1 + ".");





			 		if(runStat.updateStatAndLog(execStat,enableLogStash,resourceMap,iterateId,"row1",2,0,
			 			"tDBInput_1","stg_movie_details","tMysqlInput","tMap_1","tMap_1","tMap","output")) {
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
	
	
			cLabel="fact_movie";
		



				
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
			 			"tMap_1","tMap_1","tMap","tDBOutput_1","fact_movie","tMysqlOutput","output")) {
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
				
					     			//free memory for "tMap_1"
					     			globalMap.remove("tHash_Lookup_row2"); 
				     			
					     			//free memory for "tMap_1"
					     			globalMap.remove("tHash_Lookup_row3"); 
				     			
				try{
					
	
	/**
	 * [tDBInput_1 finally ] start
	 */

	

	
	
	currentComponent="tDBInput_1";
	
	
			cLabel="stg_movie_details";
		

 



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
	
	
			cLabel="fact_movie";
		



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
	


public static class row2Struct implements routines.system.IPersistableComparableLookupRow<row2Struct> {
    final static byte[] commonByteArrayLock_FINAL_PROJECT_fact_movie = new byte[0];
    static byte[] commonByteArray_FINAL_PROJECT_fact_movie = new byte[0];
	protected static final int DEFAULT_HASHCODE = 1;
    protected static final int PRIME = 31;
    protected int hashCode = DEFAULT_HASHCODE;
    public boolean hashCodeDirty = true;

    public String loopKey;



	
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

				
			    public Double averageRating;

				public Double getAverageRating () {
					return this.averageRating;
				}

				public Boolean averageRatingIsNullable(){
				    return true;
				}
				public Boolean averageRatingIsKey(){
				    return false;
				}
				public Integer averageRatingLength(){
				    return 22;
				}
				public Integer averageRatingPrecision(){
				    return 0;
				}
				public String averageRatingDefault(){
				
					return "";
				
				}
				public String averageRatingComment(){
				
				    return "";
				
				}
				public String averageRatingPattern(){
				
					return "";
				
				}
				public String averageRatingOriginalDbColumnName(){
				
					return "averageRating";
				
				}

				
			    public Integer numVotes;

				public Integer getNumVotes () {
					return this.numVotes;
				}

				public Boolean numVotesIsNullable(){
				    return true;
				}
				public Boolean numVotesIsKey(){
				    return false;
				}
				public Integer numVotesLength(){
				    return 10;
				}
				public Integer numVotesPrecision(){
				    return 0;
				}
				public String numVotesDefault(){
				
					return "";
				
				}
				public String numVotesComment(){
				
				    return "";
				
				}
				public String numVotesPattern(){
				
					return "";
				
				}
				public String numVotesOriginalDbColumnName(){
				
					return "numVotes";
				
				}

				


	@Override
	public int hashCode() {
		if (this.hashCodeDirty) {
			final int prime = PRIME;
			int result = DEFAULT_HASHCODE;
	
						result = prime * result + ((this.tconst == null) ? 0 : this.tconst.hashCode());
					
    		this.hashCode = result;
    		this.hashCodeDirty = false;
		}
		return this.hashCode;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) return true;
		if (obj == null) return false;
		if (getClass() != obj.getClass()) return false;
		final row2Struct other = (row2Struct) obj;
		
						if (this.tconst == null) {
							if (other.tconst != null)
								return false;
						
						} else if (!this.tconst.equals(other.tconst))
						
							return false;
					

		return true;
    }

	public void copyDataTo(row2Struct other) {

		other.tconst = this.tconst;
	            other.averageRating = this.averageRating;
	            other.numVotes = this.numVotes;
	            
	}

	public void copyKeysDataTo(row2Struct other) {

		other.tconst = this.tconst;
	            	
	}




	private String readString(ObjectInputStream dis) throws IOException{
		String strReturn = null;
		int length = 0;
        length = dis.readInt();
		if (length == -1) {
			strReturn = null;
		} else {
			if(length > commonByteArray_FINAL_PROJECT_fact_movie.length) {
				if(length < 1024 && commonByteArray_FINAL_PROJECT_fact_movie.length == 0) {
   					commonByteArray_FINAL_PROJECT_fact_movie = new byte[1024];
				} else {
   					commonByteArray_FINAL_PROJECT_fact_movie = new byte[2 * length];
   				}
			}
			dis.readFully(commonByteArray_FINAL_PROJECT_fact_movie, 0, length);
			strReturn = new String(commonByteArray_FINAL_PROJECT_fact_movie, 0, length, utf8Charset);
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
			if(length > commonByteArray_FINAL_PROJECT_fact_movie.length) {
				if(length < 1024 && commonByteArray_FINAL_PROJECT_fact_movie.length == 0) {
   					commonByteArray_FINAL_PROJECT_fact_movie = new byte[1024];
				} else {
   					commonByteArray_FINAL_PROJECT_fact_movie = new byte[2 * length];
   				}
			}
			unmarshaller.readFully(commonByteArray_FINAL_PROJECT_fact_movie, 0, length);
			strReturn = new String(commonByteArray_FINAL_PROJECT_fact_movie, 0, length, utf8Charset);
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
	private Integer readInteger(DataInputStream dis, ObjectInputStream ois) throws IOException{
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
	
	private Integer readInteger(DataInputStream dis, org.jboss.marshalling.Unmarshaller unmarshaller) throws IOException{
		Integer intReturn;
        int length = 0;
        length = unmarshaller.readByte();
		if (length == -1) {
			intReturn = null;
		} else {
			intReturn = unmarshaller.readInt();
		}
		return intReturn;
	}

	private void writeInteger(Integer intNum, DataOutputStream dos, ObjectOutputStream oos) throws IOException{
		if(intNum == null) {
            dos.writeByte(-1);
		} else {
			dos.writeByte(0);
	    	dos.writeInt(intNum);
    	}
	}
	
	private void writeInteger(Integer intNum, DataOutputStream dos,org.jboss.marshalling.Marshaller marshaller ) throws IOException{
		if(intNum == null) {
			marshaller.writeByte(-1);
		} else {
			marshaller.writeByte(0);
			marshaller.writeInt(intNum);
    	}
	}

    public void readKeysData(ObjectInputStream dis) {

		synchronized(commonByteArrayLock_FINAL_PROJECT_fact_movie) {

        	try {

        		int length = 0;
		
					this.tconst = readString(dis);
					
        	} catch (IOException e) {
	            throw new RuntimeException(e);

		

        }

		

      }


    }
    
    public void readKeysData(org.jboss.marshalling.Unmarshaller dis) {

		synchronized(commonByteArrayLock_FINAL_PROJECT_fact_movie) {

        	try {

        		int length = 0;
		
					this.tconst = readString(dis);
					
        	} catch (IOException e) {
	            throw new RuntimeException(e);

		

        }

		

      }


    }

    public void writeKeysData(ObjectOutputStream dos) {
        try {

		
					// String
				
						writeString(this.tconst,dos);
					
        	} catch (IOException e) {
	            throw new RuntimeException(e);
        }


    }
    
    public void writeKeysData(org.jboss.marshalling.Marshaller dos) {
        try {

		
					// String
				
						writeString(this.tconst,dos);
					
        	} catch (IOException e) {
	            throw new RuntimeException(e);
        }


    }



    /**
     * Fill Values data by reading ObjectInputStream.
     */
    public void readValuesData(DataInputStream dis, ObjectInputStream ois) {
        try {

			int length = 0;
		
			            length = dis.readByte();
           				if (length == -1) {
           	    			this.averageRating = null;
           				} else {
           			    	this.averageRating = dis.readDouble();
           				}
					
						this.numVotes = readInteger(dis,ois);
					
        	} catch (IOException e) {
	            throw new RuntimeException(e);

		

        }

		

    }
    
    public void readValuesData(DataInputStream dis, org.jboss.marshalling.Unmarshaller objectIn) {
        try {
			int length = 0;
		
			            length = objectIn.readByte();
           				if (length == -1) {
           	    			this.averageRating = null;
           				} else {
           			    	this.averageRating = objectIn.readDouble();
           				}
					
						this.numVotes = readInteger(dis,objectIn);
					
        	} catch (IOException e) {
	            throw new RuntimeException(e);

		

        }

		

    }

    /**
     * Return a byte array which represents Values data.
     */
    public void writeValuesData(DataOutputStream dos, ObjectOutputStream oos) {
        try {

		
						if(this.averageRating == null) {
			                dos.writeByte(-1);
						} else {
               				dos.writeByte(0);
           			    	dos.writeDouble(this.averageRating);
		            	}
					
					writeInteger(this.numVotes, dos, oos);
					
        	} catch (IOException e) {
	            throw new RuntimeException(e);
        	}

    }
    
    public void writeValuesData(DataOutputStream dos, org.jboss.marshalling.Marshaller objectOut){
                try {

		
						if(this.averageRating == null) {
							objectOut.writeByte(-1);
						} else {
							objectOut.writeByte(0);
							objectOut.writeDouble(this.averageRating);
		            	}
					
					writeInteger(this.numVotes, dos, objectOut);
					
        	} catch (IOException e) {
	            throw new RuntimeException(e);
        	}
    }


    
    public boolean supportMarshaller(){
        return true;
    }


    public String toString() {

		StringBuilder sb = new StringBuilder();
		sb.append(super.toString());
		sb.append("[");
		sb.append("tconst="+tconst);
		sb.append(",averageRating="+String.valueOf(averageRating));
		sb.append(",numVotes="+String.valueOf(numVotes));
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
        		
        				if(averageRating == null){
        					sb.append("<null>");
        				}else{
            				sb.append(averageRating);
            			}
            		
        			sb.append("|");
        		
        				if(numVotes == null){
        					sb.append("<null>");
        				}else{
            				sb.append(numVotes);
            			}
            		
        			sb.append("|");
        		
        	return sb.toString();
        }

    /**
     * Compare keys
     */
    public int compareTo(row2Struct other) {

		int returnValue = -1;
		
						returnValue = checkNullsAndCompare(this.tconst, other.tconst);
						if(returnValue != 0) {
							return returnValue;
						}

					
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
		org.slf4j.MDC.put("_subJobPid", "OANlIv_" + subJobPidCounter.getAndIncrement());
	

	
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




	
	/**
	 * [tAdvancedHash_row2 begin ] start
	 */

	

	
		
		ok_Hash.put("tAdvancedHash_row2", false);
		start_Hash.put("tAdvancedHash_row2", System.currentTimeMillis());
		
	
	currentComponent="tAdvancedHash_row2";
	
	
			runStat.updateStatAndLog(execStat,enableLogStash,resourceMap,iterateId,0,0,"row2");
			
		int tos_count_tAdvancedHash_row2 = 0;
		
			if(enableLogStash) {
				talendJobLog.addCM("tAdvancedHash_row2", "tAdvancedHash_row2", "tAdvancedHash");
				talendJobLogProcess(globalMap);
			}
			

			   		// connection name:row2
			   		// source node:tDBInput_2 - inputs:(after_tDBInput_1) outputs:(row2,row2) | target node:tAdvancedHash_row2 - inputs:(row2) outputs:()
			   		// linked node: tMap_1 - inputs:(row1,row2,row3) outputs:(toTable)
			   
			   		org.talend.designer.components.lookup.common.ICommonLookup.MATCHING_MODE matchingModeEnum_row2 = 
			   			org.talend.designer.components.lookup.common.ICommonLookup.MATCHING_MODE.UNIQUE_MATCH;
			   			
			   
	   			org.talend.designer.components.lookup.memory.AdvancedMemoryLookup<row2Struct> tHash_Lookup_row2 =org.talend.designer.components.lookup.memory.AdvancedMemoryLookup.
	   						<row2Struct>getLookup(matchingModeEnum_row2);
	   						   
		   	   	   globalMap.put("tHash_Lookup_row2", tHash_Lookup_row2);
		   	   	   
				
           

 



/**
 * [tAdvancedHash_row2 begin ] stop
 */



	
	/**
	 * [tDBInput_2 begin ] start
	 */

	

	
		
		ok_Hash.put("tDBInput_2", false);
		start_Hash.put("tDBInput_2", System.currentTimeMillis());
		
	
	currentComponent="tDBInput_2";
	
	
			cLabel="\"stg_movie_ratings\"";
		
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
                            log4jParamters_tDBInput_2.append("TABLE" + " = " + "\"stg_movie_ratings\"");
                        log4jParamters_tDBInput_2.append(" | ");
                            log4jParamters_tDBInput_2.append("QUERYSTORE" + " = " + "\"\"");
                        log4jParamters_tDBInput_2.append(" | ");
                            log4jParamters_tDBInput_2.append("QUERY" + " = " + "\"SELECT    `stg_movie_ratings`.`tconst`,    `stg_movie_ratings`.`averageRating`,    `stg_movie_ratings`.`numVotes` FROM `stg_movie_ratings`\"");
                        log4jParamters_tDBInput_2.append(" | ");
                            log4jParamters_tDBInput_2.append("SPECIFY_DATASOURCE_ALIAS" + " = " + "false");
                        log4jParamters_tDBInput_2.append(" | ");
                            log4jParamters_tDBInput_2.append("PROPERTIES" + " = " + "context.MySqlLocal_AdditionalParams");
                        log4jParamters_tDBInput_2.append(" | ");
                            log4jParamters_tDBInput_2.append("ENABLE_STREAM" + " = " + "false");
                        log4jParamters_tDBInput_2.append(" | ");
                            log4jParamters_tDBInput_2.append("TRIM_ALL_COLUMN" + " = " + "false");
                        log4jParamters_tDBInput_2.append(" | ");
                            log4jParamters_tDBInput_2.append("TRIM_COLUMN" + " = " + "[{TRIM="+("false")+", SCHEMA_COLUMN="+("tconst")+"}, {TRIM="+("false")+", SCHEMA_COLUMN="+("averageRating")+"}, {TRIM="+("false")+", SCHEMA_COLUMN="+("numVotes")+"}]");
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
				talendJobLog.addCM("tDBInput_2", "\"stg_movie_ratings\"", "tMysqlInput");
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

		    String dbquery_tDBInput_2 = "SELECT \n  `stg_movie_ratings`.`tconst`, \n  `stg_movie_ratings`.`averageRating`, \n  `stg_movie_ratings`.`numVotes`\nFROM "
+"`stg_movie_ratings`";
		    
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
								row2.averageRating = null;
							} else {
	                         		
            row2.averageRating = rs_tDBInput_2.getDouble(2);
            if(rs_tDBInput_2.wasNull()){
                    row2.averageRating = null;
            }
		                    }
							if(colQtyInRs_tDBInput_2 < 3) {
								row2.numVotes = null;
							} else {
		                          
            row2.numVotes = rs_tDBInput_2.getInt(3);
            if(rs_tDBInput_2.wasNull()){
                    row2.numVotes = null;
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
	
	
			cLabel="\"stg_movie_ratings\"";
		

 


	tos_count_tDBInput_2++;

/**
 * [tDBInput_2 main ] stop
 */
	
	/**
	 * [tDBInput_2 process_data_begin ] start
	 */

	

	
	
	currentComponent="tDBInput_2";
	
	
			cLabel="\"stg_movie_ratings\"";
		

 



/**
 * [tDBInput_2 process_data_begin ] stop
 */

	
	/**
	 * [tAdvancedHash_row2 main ] start
	 */

	

	
	
	currentComponent="tAdvancedHash_row2";
	
	
			if(runStat.update(execStat,enableLogStash,iterateId,1,1
				
					,"row2","tDBInput_2","\"stg_movie_ratings\"","tMysqlInput","tAdvancedHash_row2","tAdvancedHash_row2","tAdvancedHash"
				
			)) {
				talendJobLogProcess(globalMap);
			}
			
    			if(log.isTraceEnabled()){
    				log.trace("row2 - " + (row2==null? "": row2.toLogString()));
    			}
    		


			   
			   

					row2Struct row2_HashRow = new row2Struct();
		   	   	   
				
				row2_HashRow.tconst = row2.tconst;
				
				row2_HashRow.averageRating = row2.averageRating;
				
				row2_HashRow.numVotes = row2.numVotes;
				
			tHash_Lookup_row2.put(row2_HashRow);
			
            




 


	tos_count_tAdvancedHash_row2++;

/**
 * [tAdvancedHash_row2 main ] stop
 */
	
	/**
	 * [tAdvancedHash_row2 process_data_begin ] start
	 */

	

	
	
	currentComponent="tAdvancedHash_row2";
	
	

 



/**
 * [tAdvancedHash_row2 process_data_begin ] stop
 */
	
	/**
	 * [tAdvancedHash_row2 process_data_end ] start
	 */

	

	
	
	currentComponent="tAdvancedHash_row2";
	
	

 



/**
 * [tAdvancedHash_row2 process_data_end ] stop
 */



	
	/**
	 * [tDBInput_2 process_data_end ] start
	 */

	

	
	
	currentComponent="tDBInput_2";
	
	
			cLabel="\"stg_movie_ratings\"";
		

 



/**
 * [tDBInput_2 process_data_end ] stop
 */
	
	/**
	 * [tDBInput_2 end ] start
	 */

	

	
	
	currentComponent="tDBInput_2";
	
	
			cLabel="\"stg_movie_ratings\"";
		

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
	 * [tAdvancedHash_row2 end ] start
	 */

	

	
	
	currentComponent="tAdvancedHash_row2";
	
	

tHash_Lookup_row2.endPut();

			 		if(runStat.updateStatAndLog(execStat,enableLogStash,resourceMap,iterateId,"row2",2,0,
			 			"tDBInput_2","\"stg_movie_ratings\"","tMysqlInput","tAdvancedHash_row2","tAdvancedHash_row2","tAdvancedHash","output")) {
						talendJobLogProcess(globalMap);
					}
				
 

ok_Hash.put("tAdvancedHash_row2", true);
end_Hash.put("tAdvancedHash_row2", System.currentTimeMillis());




/**
 * [tAdvancedHash_row2 end ] stop
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
	 * [tDBInput_2 finally ] start
	 */

	

	
	
	currentComponent="tDBInput_2";
	
	
			cLabel="\"stg_movie_ratings\"";
		

 



/**
 * [tDBInput_2 finally ] stop
 */

	
	/**
	 * [tAdvancedHash_row2 finally ] start
	 */

	

	
	
	currentComponent="tAdvancedHash_row2";
	
	

 



/**
 * [tAdvancedHash_row2 finally ] stop
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
	


public static class row3Struct implements routines.system.IPersistableComparableLookupRow<row3Struct> {
    final static byte[] commonByteArrayLock_FINAL_PROJECT_fact_movie = new byte[0];
    static byte[] commonByteArray_FINAL_PROJECT_fact_movie = new byte[0];
	protected static final int DEFAULT_HASHCODE = 1;
    protected static final int PRIME = 31;
    protected int hashCode = DEFAULT_HASHCODE;
    public boolean hashCodeDirty = true;

    public String loopKey;



	
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

				
			    public int Title_SK;

				public int getTitle_SK () {
					return this.Title_SK;
				}

				public Boolean Title_SKIsNullable(){
				    return false;
				}
				public Boolean Title_SKIsKey(){
				    return false;
				}
				public Integer Title_SKLength(){
				    return 10;
				}
				public Integer Title_SKPrecision(){
				    return 0;
				}
				public String Title_SKDefault(){
				
					return "";
				
				}
				public String Title_SKComment(){
				
				    return "";
				
				}
				public String Title_SKPattern(){
				
					return "";
				
				}
				public String Title_SKOriginalDbColumnName(){
				
					return "Title_SK";
				
				}

				


	@Override
	public int hashCode() {
		if (this.hashCodeDirty) {
			final int prime = PRIME;
			int result = DEFAULT_HASHCODE;
	
						result = prime * result + ((this.tconst == null) ? 0 : this.tconst.hashCode());
					
    		this.hashCode = result;
    		this.hashCodeDirty = false;
		}
		return this.hashCode;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) return true;
		if (obj == null) return false;
		if (getClass() != obj.getClass()) return false;
		final row3Struct other = (row3Struct) obj;
		
						if (this.tconst == null) {
							if (other.tconst != null)
								return false;
						
						} else if (!this.tconst.equals(other.tconst))
						
							return false;
					

		return true;
    }

	public void copyDataTo(row3Struct other) {

		other.tconst = this.tconst;
	            other.Title_SK = this.Title_SK;
	            
	}

	public void copyKeysDataTo(row3Struct other) {

		other.tconst = this.tconst;
	            	
	}




	private String readString(ObjectInputStream dis) throws IOException{
		String strReturn = null;
		int length = 0;
        length = dis.readInt();
		if (length == -1) {
			strReturn = null;
		} else {
			if(length > commonByteArray_FINAL_PROJECT_fact_movie.length) {
				if(length < 1024 && commonByteArray_FINAL_PROJECT_fact_movie.length == 0) {
   					commonByteArray_FINAL_PROJECT_fact_movie = new byte[1024];
				} else {
   					commonByteArray_FINAL_PROJECT_fact_movie = new byte[2 * length];
   				}
			}
			dis.readFully(commonByteArray_FINAL_PROJECT_fact_movie, 0, length);
			strReturn = new String(commonByteArray_FINAL_PROJECT_fact_movie, 0, length, utf8Charset);
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
			if(length > commonByteArray_FINAL_PROJECT_fact_movie.length) {
				if(length < 1024 && commonByteArray_FINAL_PROJECT_fact_movie.length == 0) {
   					commonByteArray_FINAL_PROJECT_fact_movie = new byte[1024];
				} else {
   					commonByteArray_FINAL_PROJECT_fact_movie = new byte[2 * length];
   				}
			}
			unmarshaller.readFully(commonByteArray_FINAL_PROJECT_fact_movie, 0, length);
			strReturn = new String(commonByteArray_FINAL_PROJECT_fact_movie, 0, length, utf8Charset);
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

    public void readKeysData(ObjectInputStream dis) {

		synchronized(commonByteArrayLock_FINAL_PROJECT_fact_movie) {

        	try {

        		int length = 0;
		
					this.tconst = readString(dis);
					
        	} catch (IOException e) {
	            throw new RuntimeException(e);

		

        }

		

      }


    }
    
    public void readKeysData(org.jboss.marshalling.Unmarshaller dis) {

		synchronized(commonByteArrayLock_FINAL_PROJECT_fact_movie) {

        	try {

        		int length = 0;
		
					this.tconst = readString(dis);
					
        	} catch (IOException e) {
	            throw new RuntimeException(e);

		

        }

		

      }


    }

    public void writeKeysData(ObjectOutputStream dos) {
        try {

		
					// String
				
						writeString(this.tconst,dos);
					
        	} catch (IOException e) {
	            throw new RuntimeException(e);
        }


    }
    
    public void writeKeysData(org.jboss.marshalling.Marshaller dos) {
        try {

		
					// String
				
						writeString(this.tconst,dos);
					
        	} catch (IOException e) {
	            throw new RuntimeException(e);
        }


    }



    /**
     * Fill Values data by reading ObjectInputStream.
     */
    public void readValuesData(DataInputStream dis, ObjectInputStream ois) {
        try {

			int length = 0;
		
			            this.Title_SK = dis.readInt();
					
        	} catch (IOException e) {
	            throw new RuntimeException(e);

		

        }

		

    }
    
    public void readValuesData(DataInputStream dis, org.jboss.marshalling.Unmarshaller objectIn) {
        try {
			int length = 0;
		
			            this.Title_SK = objectIn.readInt();
					
        	} catch (IOException e) {
	            throw new RuntimeException(e);

		

        }

		

    }

    /**
     * Return a byte array which represents Values data.
     */
    public void writeValuesData(DataOutputStream dos, ObjectOutputStream oos) {
        try {

		
		            	dos.writeInt(this.Title_SK);
					
        	} catch (IOException e) {
	            throw new RuntimeException(e);
        	}

    }
    
    public void writeValuesData(DataOutputStream dos, org.jboss.marshalling.Marshaller objectOut){
                try {

		
					objectOut.writeInt(this.Title_SK);
					
        	} catch (IOException e) {
	            throw new RuntimeException(e);
        	}
    }


    
    public boolean supportMarshaller(){
        return true;
    }


    public String toString() {

		StringBuilder sb = new StringBuilder();
		sb.append(super.toString());
		sb.append("[");
		sb.append("tconst="+tconst);
		sb.append(",Title_SK="+String.valueOf(Title_SK));
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
        		
        				sb.append(Title_SK);
        			
        			sb.append("|");
        		
        	return sb.toString();
        }

    /**
     * Compare keys
     */
    public int compareTo(row3Struct other) {

		int returnValue = -1;
		
						returnValue = checkNullsAndCompare(this.tconst, other.tconst);
						if(returnValue != 0) {
							return returnValue;
						}

					
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
		org.slf4j.MDC.put("_subJobPid", "yF6qp9_" + subJobPidCounter.getAndIncrement());
	

	
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




	
	/**
	 * [tAdvancedHash_row3 begin ] start
	 */

	

	
		
		ok_Hash.put("tAdvancedHash_row3", false);
		start_Hash.put("tAdvancedHash_row3", System.currentTimeMillis());
		
	
	currentComponent="tAdvancedHash_row3";
	
	
			runStat.updateStatAndLog(execStat,enableLogStash,resourceMap,iterateId,0,0,"row3");
			
		int tos_count_tAdvancedHash_row3 = 0;
		
			if(enableLogStash) {
				talendJobLog.addCM("tAdvancedHash_row3", "tAdvancedHash_row3", "tAdvancedHash");
				talendJobLogProcess(globalMap);
			}
			

			   		// connection name:row3
			   		// source node:tDBInput_3 - inputs:(after_tDBInput_1) outputs:(row3,row3) | target node:tAdvancedHash_row3 - inputs:(row3) outputs:()
			   		// linked node: tMap_1 - inputs:(row1,row2,row3) outputs:(toTable)
			   
			   		org.talend.designer.components.lookup.common.ICommonLookup.MATCHING_MODE matchingModeEnum_row3 = 
			   			org.talend.designer.components.lookup.common.ICommonLookup.MATCHING_MODE.UNIQUE_MATCH;
			   			
			   
	   			org.talend.designer.components.lookup.memory.AdvancedMemoryLookup<row3Struct> tHash_Lookup_row3 =org.talend.designer.components.lookup.memory.AdvancedMemoryLookup.
	   						<row3Struct>getLookup(matchingModeEnum_row3);
	   						   
		   	   	   globalMap.put("tHash_Lookup_row3", tHash_Lookup_row3);
		   	   	   
				
           

 



/**
 * [tAdvancedHash_row3 begin ] stop
 */



	
	/**
	 * [tDBInput_3 begin ] start
	 */

	

	
		
		ok_Hash.put("tDBInput_3", false);
		start_Hash.put("tDBInput_3", System.currentTimeMillis());
		
	
	currentComponent="tDBInput_3";
	
	
			cLabel="\"dim_title\"";
		
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
                            log4jParamters_tDBInput_3.append("TABLE" + " = " + "\"dim_title\"");
                        log4jParamters_tDBInput_3.append(" | ");
                            log4jParamters_tDBInput_3.append("QUERYSTORE" + " = " + "\"\"");
                        log4jParamters_tDBInput_3.append(" | ");
                            log4jParamters_tDBInput_3.append("QUERY" + " = " + "\"SELECT    `dim_title`.`tconst`, `dim_title`.`Title_SK` FROM `dim_title`\"");
                        log4jParamters_tDBInput_3.append(" | ");
                            log4jParamters_tDBInput_3.append("SPECIFY_DATASOURCE_ALIAS" + " = " + "false");
                        log4jParamters_tDBInput_3.append(" | ");
                            log4jParamters_tDBInput_3.append("PROPERTIES" + " = " + "context.MySqlLocal_AdditionalParams");
                        log4jParamters_tDBInput_3.append(" | ");
                            log4jParamters_tDBInput_3.append("ENABLE_STREAM" + " = " + "false");
                        log4jParamters_tDBInput_3.append(" | ");
                            log4jParamters_tDBInput_3.append("TRIM_ALL_COLUMN" + " = " + "false");
                        log4jParamters_tDBInput_3.append(" | ");
                            log4jParamters_tDBInput_3.append("TRIM_COLUMN" + " = " + "[{TRIM="+("false")+", SCHEMA_COLUMN="+("tconst")+"}, {TRIM="+("false")+", SCHEMA_COLUMN="+("Title_SK")+"}]");
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
				talendJobLog.addCM("tDBInput_3", "\"dim_title\"", "tMysqlInput");
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

		    String dbquery_tDBInput_3 = "SELECT \n  `dim_title`.`tconst`, `dim_title`.`Title_SK`\nFROM `dim_title`";
		    
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
								row3.tconst = null;
							} else {
	                         		
        	row3.tconst = routines.system.JDBCUtil.getString(rs_tDBInput_3, 1, false);
		                    }
							if(colQtyInRs_tDBInput_3 < 2) {
								row3.Title_SK = 0;
							} else {
		                          
            row3.Title_SK = rs_tDBInput_3.getInt(2);
            if(rs_tDBInput_3.wasNull()){
                    throw new RuntimeException("Null value in non-Nullable column");
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
	
	
			cLabel="\"dim_title\"";
		

 


	tos_count_tDBInput_3++;

/**
 * [tDBInput_3 main ] stop
 */
	
	/**
	 * [tDBInput_3 process_data_begin ] start
	 */

	

	
	
	currentComponent="tDBInput_3";
	
	
			cLabel="\"dim_title\"";
		

 



/**
 * [tDBInput_3 process_data_begin ] stop
 */

	
	/**
	 * [tAdvancedHash_row3 main ] start
	 */

	

	
	
	currentComponent="tAdvancedHash_row3";
	
	
			if(runStat.update(execStat,enableLogStash,iterateId,1,1
				
					,"row3","tDBInput_3","\"dim_title\"","tMysqlInput","tAdvancedHash_row3","tAdvancedHash_row3","tAdvancedHash"
				
			)) {
				talendJobLogProcess(globalMap);
			}
			
    			if(log.isTraceEnabled()){
    				log.trace("row3 - " + (row3==null? "": row3.toLogString()));
    			}
    		


			   
			   

					row3Struct row3_HashRow = new row3Struct();
		   	   	   
				
				row3_HashRow.tconst = row3.tconst;
				
				row3_HashRow.Title_SK = row3.Title_SK;
				
			tHash_Lookup_row3.put(row3_HashRow);
			
            




 


	tos_count_tAdvancedHash_row3++;

/**
 * [tAdvancedHash_row3 main ] stop
 */
	
	/**
	 * [tAdvancedHash_row3 process_data_begin ] start
	 */

	

	
	
	currentComponent="tAdvancedHash_row3";
	
	

 



/**
 * [tAdvancedHash_row3 process_data_begin ] stop
 */
	
	/**
	 * [tAdvancedHash_row3 process_data_end ] start
	 */

	

	
	
	currentComponent="tAdvancedHash_row3";
	
	

 



/**
 * [tAdvancedHash_row3 process_data_end ] stop
 */



	
	/**
	 * [tDBInput_3 process_data_end ] start
	 */

	

	
	
	currentComponent="tDBInput_3";
	
	
			cLabel="\"dim_title\"";
		

 



/**
 * [tDBInput_3 process_data_end ] stop
 */
	
	/**
	 * [tDBInput_3 end ] start
	 */

	

	
	
	currentComponent="tDBInput_3";
	
	
			cLabel="\"dim_title\"";
		

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
	 * [tAdvancedHash_row3 end ] start
	 */

	

	
	
	currentComponent="tAdvancedHash_row3";
	
	

tHash_Lookup_row3.endPut();

			 		if(runStat.updateStatAndLog(execStat,enableLogStash,resourceMap,iterateId,"row3",2,0,
			 			"tDBInput_3","\"dim_title\"","tMysqlInput","tAdvancedHash_row3","tAdvancedHash_row3","tAdvancedHash","output")) {
						talendJobLogProcess(globalMap);
					}
				
 

ok_Hash.put("tAdvancedHash_row3", true);
end_Hash.put("tAdvancedHash_row3", System.currentTimeMillis());




/**
 * [tAdvancedHash_row3 end ] stop
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
	 * [tDBInput_3 finally ] start
	 */

	

	
	
	currentComponent="tDBInput_3";
	
	
			cLabel="\"dim_title\"";
		

 



/**
 * [tDBInput_3 finally ] stop
 */

	
	/**
	 * [tAdvancedHash_row3 finally ] start
	 */

	

	
	
	currentComponent="tAdvancedHash_row3";
	
	

 



/**
 * [tAdvancedHash_row3 finally ] stop
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
	


public void tPrejob_1Process(final java.util.Map<String, Object> globalMap) throws TalendException {
	globalMap.put("tPrejob_1_SUBPROCESS_STATE", 0);

 final boolean execStat = this.execStat;
	
		mdcInfo.forEach(org.slf4j.MDC::put);
		org.slf4j.MDC.put("_subJobName", "tPrejob_1");
		org.slf4j.MDC.put("_subJobPid", "fqV86X_" + subJobPidCounter.getAndIncrement());
	

	
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
		org.slf4j.MDC.put("_subJobPid", "5Zkk5A_" + subJobPidCounter.getAndIncrement());
	

	
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
	
	
			cLabel="PreJob";
		
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
				talendJobLog.addCM("tRunJob_1", "PreJob", "tRunJob");
				talendJobLogProcess(globalMap);
			}
			


 



/**
 * [tRunJob_1 begin ] stop
 */
	
	/**
	 * [tRunJob_1 main ] start
	 */

	

	
	
	currentComponent="tRunJob_1";
	
	
			cLabel="PreJob";
		
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
	
	
			cLabel="PreJob";
		

 



/**
 * [tRunJob_1 process_data_begin ] stop
 */
	
	/**
	 * [tRunJob_1 process_data_end ] start
	 */

	

	
	
	currentComponent="tRunJob_1";
	
	
			cLabel="PreJob";
		

 



/**
 * [tRunJob_1 process_data_end ] stop
 */
	
	/**
	 * [tRunJob_1 end ] start
	 */

	

	
	
	currentComponent="tRunJob_1";
	
	
			cLabel="PreJob";
		

 
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
	
	
			cLabel="PreJob";
		

 



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
		org.slf4j.MDC.put("_subJobPid", "wIcHOe_" + subJobPidCounter.getAndIncrement());
	

	
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
		org.slf4j.MDC.put("_subJobPid", "h6fdA6_" + subJobPidCounter.getAndIncrement());
	

	
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
	
	
			cLabel="PostJob";
		
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
				talendJobLog.addCM("tRunJob_2", "PostJob", "tRunJob");
				talendJobLogProcess(globalMap);
			}
			


 



/**
 * [tRunJob_2 begin ] stop
 */
	
	/**
	 * [tRunJob_2 main ] start
	 */

	

	
	
	currentComponent="tRunJob_2";
	
	
			cLabel="PostJob";
		
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
	
	
			cLabel="PostJob";
		

 



/**
 * [tRunJob_2 process_data_begin ] stop
 */
	
	/**
	 * [tRunJob_2 process_data_end ] start
	 */

	

	
	
	currentComponent="tRunJob_2";
	
	
			cLabel="PostJob";
		

 



/**
 * [tRunJob_2 process_data_end ] stop
 */
	
	/**
	 * [tRunJob_2 end ] start
	 */

	

	
	
	currentComponent="tRunJob_2";
	
	
			cLabel="PostJob";
		

 
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
	
	
			cLabel="PostJob";
		

 



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
		org.slf4j.MDC.put("_subJobPid", "JyQ5Ps_" + subJobPidCounter.getAndIncrement());
	

	
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
        final fact_movie fact_movieClass = new fact_movie();

        int exitCode = fact_movieClass.runJobInTOS(args);
	        if(exitCode==0){
		        log.info("TalendJob: 'fact_movie' - Done.");
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
			log.info("TalendJob: 'fact_movie' - Start.");
		

                java.util.Set<Object> jobInfoKeys = jobInfo.keySet();
                for(Object jobInfoKey: jobInfoKeys) {
                    org.slf4j.MDC.put("_" + jobInfoKey.toString(), jobInfo.get(jobInfoKey).toString());
                }
                org.slf4j.MDC.put("_pid", pid);
                org.slf4j.MDC.put("_rootPid", rootPid);
                org.slf4j.MDC.put("_fatherPid", fatherPid);
                org.slf4j.MDC.put("_projectName", projectName);
                org.slf4j.MDC.put("_startTimestamp",java.time.ZonedDateTime.now(java.time.ZoneOffset.UTC ).format( java.time.format.DateTimeFormatter.ISO_INSTANT ));
                org.slf4j.MDC.put("_jobRepositoryId","_5hUu8JE7Ee6zXrZhesgs5g");
                org.slf4j.MDC.put("_compiledAtTimestamp","2023-12-04T03:18:46.679391600Z");

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
            java.io.InputStream inContext = fact_movie.class.getClassLoader().getResourceAsStream("final_project/fact_movie_0_1/contexts/" + contextStr + ".properties");
            if (inContext == null) {
                inContext = fact_movie.class.getClassLoader().getResourceAsStream("config/contexts/" + contextStr + ".properties");
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
            log.info("TalendJob: 'fact_movie' - Started.");
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
errorCode = null;tDBInput_1Process(globalMap);
if(!"failure".equals(status)) { status = "end"; }
}catch (TalendException e_tDBInput_1) {
globalMap.put("tDBInput_1_SUBPROCESS_STATE", -1);

e_tDBInput_1.printStackTrace();

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
            System.out.println((endUsedMemory - startUsedMemory) + " bytes memory increase when running : fact_movie");
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
        log.info("TalendJob: 'fact_movie' - Finished - status: " + status + " returnCode: " + returnCode );

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
 *     213469 characters generated by Talend Cloud Data Fabric 
 *     on the December 3, 2023 at 10:18:46 PM EST
 ************************************************************************************************/