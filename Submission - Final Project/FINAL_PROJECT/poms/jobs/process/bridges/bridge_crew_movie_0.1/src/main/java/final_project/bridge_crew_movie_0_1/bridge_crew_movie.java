
package final_project.bridge_crew_movie_0_1;

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
 * Job: bridge_crew_movie Purpose: <br>
 * Description: <br>
 * 
 * @author gorle.g@northeastern.edu
 * @version 8.0.1.20230913_0925-patch
 * @status
 */
public class bridge_crew_movie implements TalendJob {
	static {
		System.setProperty("TalendJob.log", "bridge_crew_movie.log");
	}

	private static org.apache.logging.log4j.Logger log = org.apache.logging.log4j.LogManager
			.getLogger(bridge_crew_movie.class);

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

		}

		// if the stored or passed value is "<TALEND_NULL>" string, it mean null
		public String getStringValue(String key) {
			String origin_value = this.getProperty(key);
			if (NULL_VALUE_EXPRESSION_IN_COMMAND_STRING_FOR_CHILD_JOB_ONLY.equals(origin_value)) {
				return null;
			}
			return origin_value;
		}

	}

	protected ContextProperties context = new ContextProperties(); // will be instanciated by MS.

	public ContextProperties getContext() {
		return this.context;
	}

	private final String jobVersion = "0.1";
	private final String jobName = "bridge_crew_movie";
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
			"_q5XesJFJEe6zXrZhesgs5g", "0.1");
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
					bridge_crew_movie.this.exception = e;
				}
			}
			if (!(e instanceof TalendException)) {
				try {
					for (java.lang.reflect.Method m : this.getClass().getEnclosingClass().getMethods()) {
						if (m.getName().compareTo(currentComponent + "_error") == 0) {
							m.invoke(bridge_crew_movie.this, new Object[] { e, currentComponent, globalMap });
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

	public void tDBInput_1_error(Exception exception, String errorComponent,
			final java.util.Map<String, Object> globalMap) throws TalendException {

		end_Hash.put(errorComponent, System.currentTimeMillis());

		status = "failure";

		tDBInput_3_onSubJobError(exception, errorComponent, globalMap);
	}

	public void tMap_1_error(Exception exception, String errorComponent, final java.util.Map<String, Object> globalMap)
			throws TalendException {

		end_Hash.put(errorComponent, System.currentTimeMillis());

		status = "failure";

		tDBInput_3_onSubJobError(exception, errorComponent, globalMap);
	}

	public void tUniqRow_1_error(Exception exception, String errorComponent,
			final java.util.Map<String, Object> globalMap) throws TalendException {

		end_Hash.put(errorComponent, System.currentTimeMillis());

		status = "failure";

		tDBInput_3_onSubJobError(exception, errorComponent, globalMap);
	}

	public void tDBOutput_1_error(Exception exception, String errorComponent,
			final java.util.Map<String, Object> globalMap) throws TalendException {

		end_Hash.put(errorComponent, System.currentTimeMillis());

		status = "failure";

		tDBInput_3_onSubJobError(exception, errorComponent, globalMap);
	}

	public void tDBInput_2_error(Exception exception, String errorComponent,
			final java.util.Map<String, Object> globalMap) throws TalendException {

		end_Hash.put(errorComponent, System.currentTimeMillis());

		status = "failure";

		tDBInput_2_onSubJobError(exception, errorComponent, globalMap);
	}

	public void tNormalize_1_error(Exception exception, String errorComponent,
			final java.util.Map<String, Object> globalMap) throws TalendException {

		end_Hash.put(errorComponent, System.currentTimeMillis());

		status = "failure";

		tDBInput_2_onSubJobError(exception, errorComponent, globalMap);
	}

	public void tMap_2_error(Exception exception, String errorComponent, final java.util.Map<String, Object> globalMap)
			throws TalendException {

		end_Hash.put(errorComponent, System.currentTimeMillis());

		status = "failure";

		tDBInput_2_onSubJobError(exception, errorComponent, globalMap);
	}

	public void tUnite_1_error(Exception exception, String errorComponent,
			final java.util.Map<String, Object> globalMap) throws TalendException {

		end_Hash.put(errorComponent, System.currentTimeMillis());

		status = "failure";

		tDBInput_2_onSubJobError(exception, errorComponent, globalMap);
	}

	public void tMap_4_error(Exception exception, String errorComponent, final java.util.Map<String, Object> globalMap)
			throws TalendException {

		end_Hash.put(errorComponent, System.currentTimeMillis());

		status = "failure";

		tDBInput_2_onSubJobError(exception, errorComponent, globalMap);
	}

	public void tDBOutput_2_error(Exception exception, String errorComponent,
			final java.util.Map<String, Object> globalMap) throws TalendException {

		end_Hash.put(errorComponent, System.currentTimeMillis());

		status = "failure";

		tDBInput_2_onSubJobError(exception, errorComponent, globalMap);
	}

	public void tDBInput_3_error(Exception exception, String errorComponent,
			final java.util.Map<String, Object> globalMap) throws TalendException {

		end_Hash.put(errorComponent, System.currentTimeMillis());

		status = "failure";

		tDBInput_3_onSubJobError(exception, errorComponent, globalMap);
	}

	public void tDBInput_4_error(Exception exception, String errorComponent,
			final java.util.Map<String, Object> globalMap) throws TalendException {

		end_Hash.put(errorComponent, System.currentTimeMillis());

		status = "failure";

		tDBInput_3_onSubJobError(exception, errorComponent, globalMap);
	}

	public void tDBInput_5_error(Exception exception, String errorComponent,
			final java.util.Map<String, Object> globalMap) throws TalendException {

		end_Hash.put(errorComponent, System.currentTimeMillis());

		status = "failure";

		tDBInput_3_onSubJobError(exception, errorComponent, globalMap);
	}

	public void tDBInput_6_error(Exception exception, String errorComponent,
			final java.util.Map<String, Object> globalMap) throws TalendException {

		end_Hash.put(errorComponent, System.currentTimeMillis());

		status = "failure";

		tDBInput_2_onSubJobError(exception, errorComponent, globalMap);
	}

	public void tNormalize_2_error(Exception exception, String errorComponent,
			final java.util.Map<String, Object> globalMap) throws TalendException {

		end_Hash.put(errorComponent, System.currentTimeMillis());

		status = "failure";

		tDBInput_2_onSubJobError(exception, errorComponent, globalMap);
	}

	public void tMap_3_error(Exception exception, String errorComponent, final java.util.Map<String, Object> globalMap)
			throws TalendException {

		end_Hash.put(errorComponent, System.currentTimeMillis());

		status = "failure";

		tDBInput_2_onSubJobError(exception, errorComponent, globalMap);
	}

	public void tDBInput_7_error(Exception exception, String errorComponent,
			final java.util.Map<String, Object> globalMap) throws TalendException {

		end_Hash.put(errorComponent, System.currentTimeMillis());

		status = "failure";

		tDBInput_2_onSubJobError(exception, errorComponent, globalMap);
	}

	public void tDBInput_8_error(Exception exception, String errorComponent,
			final java.util.Map<String, Object> globalMap) throws TalendException {

		end_Hash.put(errorComponent, System.currentTimeMillis());

		status = "failure";

		tDBInput_2_onSubJobError(exception, errorComponent, globalMap);
	}

	public void tDBInput_9_error(Exception exception, String errorComponent,
			final java.util.Map<String, Object> globalMap) throws TalendException {

		end_Hash.put(errorComponent, System.currentTimeMillis());

		status = "failure";

		tDBInput_2_onSubJobError(exception, errorComponent, globalMap);
	}

	public void tAdvancedHash_row3_error(Exception exception, String errorComponent,
			final java.util.Map<String, Object> globalMap) throws TalendException {

		end_Hash.put(errorComponent, System.currentTimeMillis());

		status = "failure";

		tDBInput_3_onSubJobError(exception, errorComponent, globalMap);
	}

	public void tAdvancedHash_row2_error(Exception exception, String errorComponent,
			final java.util.Map<String, Object> globalMap) throws TalendException {

		end_Hash.put(errorComponent, System.currentTimeMillis());

		status = "failure";

		tDBInput_3_onSubJobError(exception, errorComponent, globalMap);
	}

	public void tAdvancedHash_row4_error(Exception exception, String errorComponent,
			final java.util.Map<String, Object> globalMap) throws TalendException {

		end_Hash.put(errorComponent, System.currentTimeMillis());

		status = "failure";

		tDBInput_3_onSubJobError(exception, errorComponent, globalMap);
	}

	public void tAdvancedHash_row11_error(Exception exception, String errorComponent,
			final java.util.Map<String, Object> globalMap) throws TalendException {

		end_Hash.put(errorComponent, System.currentTimeMillis());

		status = "failure";

		tDBInput_2_onSubJobError(exception, errorComponent, globalMap);
	}

	public void tAdvancedHash_row12_error(Exception exception, String errorComponent,
			final java.util.Map<String, Object> globalMap) throws TalendException {

		end_Hash.put(errorComponent, System.currentTimeMillis());

		status = "failure";

		tDBInput_2_onSubJobError(exception, errorComponent, globalMap);
	}

	public void tAdvancedHash_row13_error(Exception exception, String errorComponent,
			final java.util.Map<String, Object> globalMap) throws TalendException {

		end_Hash.put(errorComponent, System.currentTimeMillis());

		status = "failure";

		tDBInput_2_onSubJobError(exception, errorComponent, globalMap);
	}

	public void talendJobLog_error(Exception exception, String errorComponent,
			final java.util.Map<String, Object> globalMap) throws TalendException {

		end_Hash.put(errorComponent, System.currentTimeMillis());

		status = "failure";

		talendJobLog_onSubJobError(exception, errorComponent, globalMap);
	}

	public void tDBInput_2_onSubJobError(Exception exception, String errorComponent,
			final java.util.Map<String, Object> globalMap) throws TalendException {

		resumeUtil.addLog("SYSTEM_LOG", "NODE:" + errorComponent, "", Thread.currentThread().getId() + "", "FATAL", "",
				exception.getMessage(), ResumeUtil.getExceptionStackTrace(exception), "");

	}

	public void tDBInput_3_onSubJobError(Exception exception, String errorComponent,
			final java.util.Map<String, Object> globalMap) throws TalendException {

		resumeUtil.addLog("SYSTEM_LOG", "NODE:" + errorComponent, "", Thread.currentThread().getId() + "", "FATAL", "",
				exception.getMessage(), ResumeUtil.getExceptionStackTrace(exception), "");

	}

	public void talendJobLog_onSubJobError(Exception exception, String errorComponent,
			final java.util.Map<String, Object> globalMap) throws TalendException {

		resumeUtil.addLog("SYSTEM_LOG", "NODE:" + errorComponent, "", Thread.currentThread().getId() + "", "FATAL", "",
				exception.getMessage(), ResumeUtil.getExceptionStackTrace(exception), "");

	}

	public static class row3Struct implements routines.system.IPersistableComparableLookupRow<row3Struct> {
		final static byte[] commonByteArrayLock_FINAL_PROJECT_bridge_crew_movie = new byte[0];
		static byte[] commonByteArray_FINAL_PROJECT_bridge_crew_movie = new byte[0];
		protected static final int DEFAULT_HASHCODE = 1;
		protected static final int PRIME = 31;
		protected int hashCode = DEFAULT_HASHCODE;
		public boolean hashCodeDirty = true;

		public String loopKey;

		public String nmconst;

		public String getNmconst() {
			return this.nmconst;
		}

		public Boolean nmconstIsNullable() {
			return true;
		}

		public Boolean nmconstIsKey() {
			return false;
		}

		public Integer nmconstLength() {
			return 10;
		}

		public Integer nmconstPrecision() {
			return 0;
		}

		public String nmconstDefault() {

			return null;

		}

		public String nmconstComment() {

			return "";

		}

		public String nmconstPattern() {

			return "";

		}

		public String nmconstOriginalDbColumnName() {

			return "nmconst";

		}

		public int Crew_SK;

		public int getCrew_SK() {
			return this.Crew_SK;
		}

		public Boolean Crew_SKIsNullable() {
			return false;
		}

		public Boolean Crew_SKIsKey() {
			return false;
		}

		public Integer Crew_SKLength() {
			return 10;
		}

		public Integer Crew_SKPrecision() {
			return 0;
		}

		public String Crew_SKDefault() {

			return "";

		}

		public String Crew_SKComment() {

			return "";

		}

		public String Crew_SKPattern() {

			return "";

		}

		public String Crew_SKOriginalDbColumnName() {

			return "Crew_SK";

		}

		@Override
		public int hashCode() {
			if (this.hashCodeDirty) {
				final int prime = PRIME;
				int result = DEFAULT_HASHCODE;

				result = prime * result + ((this.nmconst == null) ? 0 : this.nmconst.hashCode());

				this.hashCode = result;
				this.hashCodeDirty = false;
			}
			return this.hashCode;
		}

		@Override
		public boolean equals(Object obj) {
			if (this == obj)
				return true;
			if (obj == null)
				return false;
			if (getClass() != obj.getClass())
				return false;
			final row3Struct other = (row3Struct) obj;

			if (this.nmconst == null) {
				if (other.nmconst != null)
					return false;

			} else if (!this.nmconst.equals(other.nmconst))

				return false;

			return true;
		}

		public void copyDataTo(row3Struct other) {

			other.nmconst = this.nmconst;
			other.Crew_SK = this.Crew_SK;

		}

		public void copyKeysDataTo(row3Struct other) {

			other.nmconst = this.nmconst;

		}

		private String readString(ObjectInputStream dis) throws IOException {
			String strReturn = null;
			int length = 0;
			length = dis.readInt();
			if (length == -1) {
				strReturn = null;
			} else {
				if (length > commonByteArray_FINAL_PROJECT_bridge_crew_movie.length) {
					if (length < 1024 && commonByteArray_FINAL_PROJECT_bridge_crew_movie.length == 0) {
						commonByteArray_FINAL_PROJECT_bridge_crew_movie = new byte[1024];
					} else {
						commonByteArray_FINAL_PROJECT_bridge_crew_movie = new byte[2 * length];
					}
				}
				dis.readFully(commonByteArray_FINAL_PROJECT_bridge_crew_movie, 0, length);
				strReturn = new String(commonByteArray_FINAL_PROJECT_bridge_crew_movie, 0, length, utf8Charset);
			}
			return strReturn;
		}

		private String readString(org.jboss.marshalling.Unmarshaller unmarshaller) throws IOException {
			String strReturn = null;
			int length = 0;
			length = unmarshaller.readInt();
			if (length == -1) {
				strReturn = null;
			} else {
				if (length > commonByteArray_FINAL_PROJECT_bridge_crew_movie.length) {
					if (length < 1024 && commonByteArray_FINAL_PROJECT_bridge_crew_movie.length == 0) {
						commonByteArray_FINAL_PROJECT_bridge_crew_movie = new byte[1024];
					} else {
						commonByteArray_FINAL_PROJECT_bridge_crew_movie = new byte[2 * length];
					}
				}
				unmarshaller.readFully(commonByteArray_FINAL_PROJECT_bridge_crew_movie, 0, length);
				strReturn = new String(commonByteArray_FINAL_PROJECT_bridge_crew_movie, 0, length, utf8Charset);
			}
			return strReturn;
		}

		private void writeString(String str, ObjectOutputStream dos) throws IOException {
			if (str == null) {
				dos.writeInt(-1);
			} else {
				byte[] byteArray = str.getBytes(utf8Charset);
				dos.writeInt(byteArray.length);
				dos.write(byteArray);
			}
		}

		private void writeString(String str, org.jboss.marshalling.Marshaller marshaller) throws IOException {
			if (str == null) {
				marshaller.writeInt(-1);
			} else {
				byte[] byteArray = str.getBytes(utf8Charset);
				marshaller.writeInt(byteArray.length);
				marshaller.write(byteArray);
			}
		}

		public void readKeysData(ObjectInputStream dis) {

			synchronized (commonByteArrayLock_FINAL_PROJECT_bridge_crew_movie) {

				try {

					int length = 0;

					this.nmconst = readString(dis);

				} catch (IOException e) {
					throw new RuntimeException(e);

				}

			}

		}

		public void readKeysData(org.jboss.marshalling.Unmarshaller dis) {

			synchronized (commonByteArrayLock_FINAL_PROJECT_bridge_crew_movie) {

				try {

					int length = 0;

					this.nmconst = readString(dis);

				} catch (IOException e) {
					throw new RuntimeException(e);

				}

			}

		}

		public void writeKeysData(ObjectOutputStream dos) {
			try {

				// String

				writeString(this.nmconst, dos);

			} catch (IOException e) {
				throw new RuntimeException(e);
			}

		}

		public void writeKeysData(org.jboss.marshalling.Marshaller dos) {
			try {

				// String

				writeString(this.nmconst, dos);

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

				this.Crew_SK = dis.readInt();

			} catch (IOException e) {
				throw new RuntimeException(e);

			}

		}

		public void readValuesData(DataInputStream dis, org.jboss.marshalling.Unmarshaller objectIn) {
			try {
				int length = 0;

				this.Crew_SK = objectIn.readInt();

			} catch (IOException e) {
				throw new RuntimeException(e);

			}

		}

		/**
		 * Return a byte array which represents Values data.
		 */
		public void writeValuesData(DataOutputStream dos, ObjectOutputStream oos) {
			try {

				dos.writeInt(this.Crew_SK);

			} catch (IOException e) {
				throw new RuntimeException(e);
			}

		}

		public void writeValuesData(DataOutputStream dos, org.jboss.marshalling.Marshaller objectOut) {
			try {

				objectOut.writeInt(this.Crew_SK);

			} catch (IOException e) {
				throw new RuntimeException(e);
			}
		}

		public boolean supportMarshaller() {
			return true;
		}

		public String toString() {

			StringBuilder sb = new StringBuilder();
			sb.append(super.toString());
			sb.append("[");
			sb.append("nmconst=" + nmconst);
			sb.append(",Crew_SK=" + String.valueOf(Crew_SK));
			sb.append("]");

			return sb.toString();
		}

		public String toLogString() {
			StringBuilder sb = new StringBuilder();

			if (nmconst == null) {
				sb.append("<null>");
			} else {
				sb.append(nmconst);
			}

			sb.append("|");

			sb.append(Crew_SK);

			sb.append("|");

			return sb.toString();
		}

		/**
		 * Compare keys
		 */
		public int compareTo(row3Struct other) {

			int returnValue = -1;

			returnValue = checkNullsAndCompare(this.nmconst, other.nmconst);
			if (returnValue != 0) {
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

	public void tDBInput_1Process(final java.util.Map<String, Object> globalMap) throws TalendException {
		globalMap.put("tDBInput_1_SUBPROCESS_STATE", 0);

		final boolean execStat = this.execStat;

		mdcInfo.forEach(org.slf4j.MDC::put);
		org.slf4j.MDC.put("_subJobName", "tDBInput_1");
		org.slf4j.MDC.put("_subJobPid", "FvaVkS_" + subJobPidCounter.getAndIncrement());

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

				row3Struct row3 = new row3Struct();

				/**
				 * [tAdvancedHash_row3 begin ] start
				 */

				ok_Hash.put("tAdvancedHash_row3", false);
				start_Hash.put("tAdvancedHash_row3", System.currentTimeMillis());

				currentComponent = "tAdvancedHash_row3";

				runStat.updateStatAndLog(execStat, enableLogStash, resourceMap, iterateId, 0, 0, "row3");

				int tos_count_tAdvancedHash_row3 = 0;

				if (enableLogStash) {
					talendJobLog.addCM("tAdvancedHash_row3", "tAdvancedHash_row3", "tAdvancedHash");
					talendJobLogProcess(globalMap);
				}

				// connection name:row3
				// source node:tDBInput_1 - inputs:(after_tDBInput_3) outputs:(row3,row3) |
				// target node:tAdvancedHash_row3 - inputs:(row3) outputs:()
				// linked node: tMap_1 - inputs:(row3,row1,row2,row4) outputs:(toTable)

				org.talend.designer.components.lookup.common.ICommonLookup.MATCHING_MODE matchingModeEnum_row3 = org.talend.designer.components.lookup.common.ICommonLookup.MATCHING_MODE.UNIQUE_MATCH;

				org.talend.designer.components.lookup.memory.AdvancedMemoryLookup<row3Struct> tHash_Lookup_row3 = org.talend.designer.components.lookup.memory.AdvancedMemoryLookup
						.<row3Struct>getLookup(matchingModeEnum_row3);

				globalMap.put("tHash_Lookup_row3", tHash_Lookup_row3);

				/**
				 * [tAdvancedHash_row3 begin ] stop
				 */

				/**
				 * [tDBInput_1 begin ] start
				 */

				ok_Hash.put("tDBInput_1", false);
				start_Hash.put("tDBInput_1", System.currentTimeMillis());

				currentComponent = "tDBInput_1";

				cLabel = "\"dim_crew\"";

				int tos_count_tDBInput_1 = 0;

				if (log.isDebugEnabled())
					log.debug("tDBInput_1 - " + ("Start to work."));
				if (log.isDebugEnabled()) {
					class BytesLimit65535_tDBInput_1 {
						public void limitLog4jByte() throws Exception {
							StringBuilder log4jParamters_tDBInput_1 = new StringBuilder();
							log4jParamters_tDBInput_1.append("Parameters:");
							log4jParamters_tDBInput_1.append("DB_VERSION" + " = " + "MYSQL_8");
							log4jParamters_tDBInput_1.append(" | ");
							log4jParamters_tDBInput_1.append("USE_EXISTING_CONNECTION" + " = " + "false");
							log4jParamters_tDBInput_1.append(" | ");
							log4jParamters_tDBInput_1.append("HOST" + " = " + "\"127.0.0.1\"");
							log4jParamters_tDBInput_1.append(" | ");
							log4jParamters_tDBInput_1.append("PORT" + " = " + "\"3306\"");
							log4jParamters_tDBInput_1.append(" | ");
							log4jParamters_tDBInput_1.append("DBNAME" + " = " + "\"imdb_src\"");
							log4jParamters_tDBInput_1.append(" | ");
							log4jParamters_tDBInput_1.append("USER" + " = " + "\"user2\"");
							log4jParamters_tDBInput_1.append(" | ");
							log4jParamters_tDBInput_1.append("PASS" + " = " + String.valueOf(
									"enc:routine.encryption.key.v1:1DyQJRY6U0G76BOvejCfjptutJfweqO+KonesENFHXGXICMg")
									.substring(0, 4) + "...");
							log4jParamters_tDBInput_1.append(" | ");
							log4jParamters_tDBInput_1.append("TABLE" + " = " + "\"dim_crew\"");
							log4jParamters_tDBInput_1.append(" | ");
							log4jParamters_tDBInput_1.append("QUERYSTORE" + " = " + "\"\"");
							log4jParamters_tDBInput_1.append(" | ");
							log4jParamters_tDBInput_1.append("QUERY" + " = "
									+ "\"SELECT    `dim_crew`.`nmconst`,    `dim_crew`.`Crew_SK` FROM `dim_crew`\"");
							log4jParamters_tDBInput_1.append(" | ");
							log4jParamters_tDBInput_1.append("SPECIFY_DATASOURCE_ALIAS" + " = " + "false");
							log4jParamters_tDBInput_1.append(" | ");
							log4jParamters_tDBInput_1.append("PROPERTIES" + " = "
									+ "\"noDatetimeStringSync=true&enabledTLSProtocols=TLSv1.2,TLSv1.1,TLSv1\"");
							log4jParamters_tDBInput_1.append(" | ");
							log4jParamters_tDBInput_1.append("ENABLE_STREAM" + " = " + "false");
							log4jParamters_tDBInput_1.append(" | ");
							log4jParamters_tDBInput_1.append("TRIM_ALL_COLUMN" + " = " + "false");
							log4jParamters_tDBInput_1.append(" | ");
							log4jParamters_tDBInput_1.append(
									"TRIM_COLUMN" + " = " + "[{TRIM=" + ("false") + ", SCHEMA_COLUMN=" + ("nmconst")
											+ "}, {TRIM=" + ("false") + ", SCHEMA_COLUMN=" + ("Crew_SK") + "}]");
							log4jParamters_tDBInput_1.append(" | ");
							log4jParamters_tDBInput_1.append("UNIFIED_COMPONENTS" + " = " + "tMysqlInput");
							log4jParamters_tDBInput_1.append(" | ");
							if (log.isDebugEnabled())
								log.debug("tDBInput_1 - " + (log4jParamters_tDBInput_1));
						}
					}
					new BytesLimit65535_tDBInput_1().limitLog4jByte();
				}
				if (enableLogStash) {
					talendJobLog.addCM("tDBInput_1", "\"dim_crew\"", "tMysqlInput");
					talendJobLogProcess(globalMap);
				}

				java.util.Calendar calendar_tDBInput_1 = java.util.Calendar.getInstance();
				calendar_tDBInput_1.set(0, 0, 0, 0, 0, 0);
				java.util.Date year0_tDBInput_1 = calendar_tDBInput_1.getTime();
				int nb_line_tDBInput_1 = 0;
				java.sql.Connection conn_tDBInput_1 = null;
				String driverClass_tDBInput_1 = "com.mysql.cj.jdbc.Driver";
				java.lang.Class jdbcclazz_tDBInput_1 = java.lang.Class.forName(driverClass_tDBInput_1);
				String dbUser_tDBInput_1 = "user2";

				final String decryptedPassword_tDBInput_1 = routines.system.PasswordEncryptUtil.decryptPassword(
						"enc:routine.encryption.key.v1:nRWxWkqAnS6aKzkPJ66YnbliefPOMzr2Nm/mxIE9yCbnDih9");

				String dbPwd_tDBInput_1 = decryptedPassword_tDBInput_1;

				String properties_tDBInput_1 = "noDatetimeStringSync=true&enabledTLSProtocols=TLSv1.2,TLSv1.1,TLSv1";
				if (properties_tDBInput_1 == null || properties_tDBInput_1.trim().length() == 0) {
					properties_tDBInput_1 = "";
				}
				String url_tDBInput_1 = "jdbc:mysql://" + "127.0.0.1" + ":" + "3306" + "/" + "imdb_src" + "?"
						+ properties_tDBInput_1;

				log.debug("tDBInput_1 - Driver ClassName: " + driverClass_tDBInput_1 + ".");

				log.debug("tDBInput_1 - Connection attempt to '" + url_tDBInput_1 + "' with the username '"
						+ dbUser_tDBInput_1 + "'.");

				conn_tDBInput_1 = java.sql.DriverManager.getConnection(url_tDBInput_1, dbUser_tDBInput_1,
						dbPwd_tDBInput_1);
				log.debug("tDBInput_1 - Connection to '" + url_tDBInput_1 + "' has succeeded.");

				java.sql.Statement stmt_tDBInput_1 = conn_tDBInput_1.createStatement();

				String dbquery_tDBInput_1 = "SELECT \n  `dim_crew`.`nmconst`, \n  `dim_crew`.`Crew_SK`\nFROM `dim_crew`";

				log.debug("tDBInput_1 - Executing the query: '" + dbquery_tDBInput_1 + "'.");

				globalMap.put("tDBInput_1_QUERY", dbquery_tDBInput_1);

				java.sql.ResultSet rs_tDBInput_1 = null;

				try {
					rs_tDBInput_1 = stmt_tDBInput_1.executeQuery(dbquery_tDBInput_1);
					java.sql.ResultSetMetaData rsmd_tDBInput_1 = rs_tDBInput_1.getMetaData();
					int colQtyInRs_tDBInput_1 = rsmd_tDBInput_1.getColumnCount();

					String tmpContent_tDBInput_1 = null;

					log.debug("tDBInput_1 - Retrieving records from the database.");

					while (rs_tDBInput_1.next()) {
						nb_line_tDBInput_1++;

						if (colQtyInRs_tDBInput_1 < 1) {
							row3.nmconst = null;
						} else {

							row3.nmconst = routines.system.JDBCUtil.getString(rs_tDBInput_1, 1, false);
						}
						if (colQtyInRs_tDBInput_1 < 2) {
							row3.Crew_SK = 0;
						} else {

							row3.Crew_SK = rs_tDBInput_1.getInt(2);
							if (rs_tDBInput_1.wasNull()) {
								throw new RuntimeException("Null value in non-Nullable column");
							}
						}

						log.debug("tDBInput_1 - Retrieving the record " + nb_line_tDBInput_1 + ".");

						/**
						 * [tDBInput_1 begin ] stop
						 */

						/**
						 * [tDBInput_1 main ] start
						 */

						currentComponent = "tDBInput_1";

						cLabel = "\"dim_crew\"";

						tos_count_tDBInput_1++;

						/**
						 * [tDBInput_1 main ] stop
						 */

						/**
						 * [tDBInput_1 process_data_begin ] start
						 */

						currentComponent = "tDBInput_1";

						cLabel = "\"dim_crew\"";

						/**
						 * [tDBInput_1 process_data_begin ] stop
						 */

						/**
						 * [tAdvancedHash_row3 main ] start
						 */

						currentComponent = "tAdvancedHash_row3";

						if (runStat.update(execStat, enableLogStash, iterateId, 1, 1

								, "row3", "tDBInput_1", "\"dim_crew\"", "tMysqlInput", "tAdvancedHash_row3",
								"tAdvancedHash_row3", "tAdvancedHash"

						)) {
							talendJobLogProcess(globalMap);
						}

						if (log.isTraceEnabled()) {
							log.trace("row3 - " + (row3 == null ? "" : row3.toLogString()));
						}

						row3Struct row3_HashRow = new row3Struct();

						row3_HashRow.nmconst = row3.nmconst;

						row3_HashRow.Crew_SK = row3.Crew_SK;

						tHash_Lookup_row3.put(row3_HashRow);

						tos_count_tAdvancedHash_row3++;

						/**
						 * [tAdvancedHash_row3 main ] stop
						 */

						/**
						 * [tAdvancedHash_row3 process_data_begin ] start
						 */

						currentComponent = "tAdvancedHash_row3";

						/**
						 * [tAdvancedHash_row3 process_data_begin ] stop
						 */

						/**
						 * [tAdvancedHash_row3 process_data_end ] start
						 */

						currentComponent = "tAdvancedHash_row3";

						/**
						 * [tAdvancedHash_row3 process_data_end ] stop
						 */

						/**
						 * [tDBInput_1 process_data_end ] start
						 */

						currentComponent = "tDBInput_1";

						cLabel = "\"dim_crew\"";

						/**
						 * [tDBInput_1 process_data_end ] stop
						 */

						/**
						 * [tDBInput_1 end ] start
						 */

						currentComponent = "tDBInput_1";

						cLabel = "\"dim_crew\"";

					}
				} finally {
					if (rs_tDBInput_1 != null) {
						rs_tDBInput_1.close();
					}
					if (stmt_tDBInput_1 != null) {
						stmt_tDBInput_1.close();
					}
					if (conn_tDBInput_1 != null && !conn_tDBInput_1.isClosed()) {

						log.debug("tDBInput_1 - Closing the connection to the database.");

						conn_tDBInput_1.close();

						if ("com.mysql.cj.jdbc.Driver".equals((String) globalMap.get("driverClass_"))
								&& routines.system.BundleUtils.inOSGi()) {
							Class.forName("com.mysql.cj.jdbc.AbandonedConnectionCleanupThread")
									.getMethod("checkedShutdown").invoke(null, (Object[]) null);
						}

						log.debug("tDBInput_1 - Connection to the database closed.");

					}

				}
				globalMap.put("tDBInput_1_NB_LINE", nb_line_tDBInput_1);
				log.debug("tDBInput_1 - Retrieved records count: " + nb_line_tDBInput_1 + " .");

				if (log.isDebugEnabled())
					log.debug("tDBInput_1 - " + ("Done."));

				ok_Hash.put("tDBInput_1", true);
				end_Hash.put("tDBInput_1", System.currentTimeMillis());

				/**
				 * [tDBInput_1 end ] stop
				 */

				/**
				 * [tAdvancedHash_row3 end ] start
				 */

				currentComponent = "tAdvancedHash_row3";

				tHash_Lookup_row3.endPut();

				if (runStat.updateStatAndLog(execStat, enableLogStash, resourceMap, iterateId, "row3", 2, 0,
						"tDBInput_1", "\"dim_crew\"", "tMysqlInput", "tAdvancedHash_row3", "tAdvancedHash_row3",
						"tAdvancedHash", "output")) {
					talendJobLogProcess(globalMap);
				}

				ok_Hash.put("tAdvancedHash_row3", true);
				end_Hash.put("tAdvancedHash_row3", System.currentTimeMillis());

				/**
				 * [tAdvancedHash_row3 end ] stop
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
				 * [tDBInput_1 finally ] start
				 */

				currentComponent = "tDBInput_1";

				cLabel = "\"dim_crew\"";

				/**
				 * [tDBInput_1 finally ] stop
				 */

				/**
				 * [tAdvancedHash_row3 finally ] start
				 */

				currentComponent = "tAdvancedHash_row3";

				/**
				 * [tAdvancedHash_row3 finally ] stop
				 */

			} catch (java.lang.Exception e) {
				// ignore
			} catch (java.lang.Error error) {
				// ignore
			}
			resourceMap = null;
		}

		globalMap.put("tDBInput_1_SUBPROCESS_STATE", 1);
	}

	public static class toTable1Struct implements routines.system.IPersistableRow<toTable1Struct> {
		final static byte[] commonByteArrayLock_FINAL_PROJECT_bridge_crew_movie = new byte[0];
		static byte[] commonByteArray_FINAL_PROJECT_bridge_crew_movie = new byte[0];
		protected static final int DEFAULT_HASHCODE = 1;
		protected static final int PRIME = 31;
		protected int hashCode = DEFAULT_HASHCODE;
		public boolean hashCodeDirty = true;

		public String loopKey;

		public int Movie_ID;

		public int getMovie_ID() {
			return this.Movie_ID;
		}

		public Boolean Movie_IDIsNullable() {
			return false;
		}

		public Boolean Movie_IDIsKey() {
			return true;
		}

		public Integer Movie_IDLength() {
			return null;
		}

		public Integer Movie_IDPrecision() {
			return null;
		}

		public String Movie_IDDefault() {

			return null;

		}

		public String Movie_IDComment() {

			return "";

		}

		public String Movie_IDPattern() {

			return "";

		}

		public String Movie_IDOriginalDbColumnName() {

			return "Movie_ID";

		}

		public int Crew_SK;

		public int getCrew_SK() {
			return this.Crew_SK;
		}

		public Boolean Crew_SKIsNullable() {
			return false;
		}

		public Boolean Crew_SKIsKey() {
			return true;
		}

		public Integer Crew_SKLength() {
			return null;
		}

		public Integer Crew_SKPrecision() {
			return null;
		}

		public String Crew_SKDefault() {

			return null;

		}

		public String Crew_SKComment() {

			return "";

		}

		public String Crew_SKPattern() {

			return "";

		}

		public String Crew_SKOriginalDbColumnName() {

			return "Crew_SK";

		}

		public int Profession_SK;

		public int getProfession_SK() {
			return this.Profession_SK;
		}

		public Boolean Profession_SKIsNullable() {
			return false;
		}

		public Boolean Profession_SKIsKey() {
			return true;
		}

		public Integer Profession_SKLength() {
			return null;
		}

		public Integer Profession_SKPrecision() {
			return null;
		}

		public String Profession_SKDefault() {

			return null;

		}

		public String Profession_SKComment() {

			return "";

		}

		public String Profession_SKPattern() {

			return "";

		}

		public String Profession_SKOriginalDbColumnName() {

			return "Profession_SK";

		}

		public java.util.Date DI_CreatedDate;

		public java.util.Date getDI_CreatedDate() {
			return this.DI_CreatedDate;
		}

		public Boolean DI_CreatedDateIsNullable() {
			return false;
		}

		public Boolean DI_CreatedDateIsKey() {
			return false;
		}

		public Integer DI_CreatedDateLength() {
			return null;
		}

		public Integer DI_CreatedDatePrecision() {
			return null;
		}

		public String DI_CreatedDateDefault() {

			return null;

		}

		public String DI_CreatedDateComment() {

			return "";

		}

		public String DI_CreatedDatePattern() {

			return "dd-MM-yyyy";

		}

		public String DI_CreatedDateOriginalDbColumnName() {

			return "DI_CreatedDate";

		}

		public String DI_WorkflowJobId;

		public String getDI_WorkflowJobId() {
			return this.DI_WorkflowJobId;
		}

		public Boolean DI_WorkflowJobIdIsNullable() {
			return false;
		}

		public Boolean DI_WorkflowJobIdIsKey() {
			return false;
		}

		public Integer DI_WorkflowJobIdLength() {
			return 8;
		}

		public Integer DI_WorkflowJobIdPrecision() {
			return null;
		}

		public String DI_WorkflowJobIdDefault() {

			return null;

		}

		public String DI_WorkflowJobIdComment() {

			return "";

		}

		public String DI_WorkflowJobIdPattern() {

			return "";

		}

		public String DI_WorkflowJobIdOriginalDbColumnName() {

			return "DI_WorkflowJobId";

		}

		@Override
		public int hashCode() {
			if (this.hashCodeDirty) {
				final int prime = PRIME;
				int result = DEFAULT_HASHCODE;

				result = prime * result + (int) this.Movie_ID;

				result = prime * result + (int) this.Crew_SK;

				result = prime * result + (int) this.Profession_SK;

				this.hashCode = result;
				this.hashCodeDirty = false;
			}
			return this.hashCode;
		}

		@Override
		public boolean equals(Object obj) {
			if (this == obj)
				return true;
			if (obj == null)
				return false;
			if (getClass() != obj.getClass())
				return false;
			final toTable1Struct other = (toTable1Struct) obj;

			if (this.Movie_ID != other.Movie_ID)
				return false;

			if (this.Crew_SK != other.Crew_SK)
				return false;

			if (this.Profession_SK != other.Profession_SK)
				return false;

			return true;
		}

		public void copyDataTo(toTable1Struct other) {

			other.Movie_ID = this.Movie_ID;
			other.Crew_SK = this.Crew_SK;
			other.Profession_SK = this.Profession_SK;
			other.DI_CreatedDate = this.DI_CreatedDate;
			other.DI_WorkflowJobId = this.DI_WorkflowJobId;

		}

		public void copyKeysDataTo(toTable1Struct other) {

			other.Movie_ID = this.Movie_ID;
			other.Crew_SK = this.Crew_SK;
			other.Profession_SK = this.Profession_SK;

		}

		private java.util.Date readDate(ObjectInputStream dis) throws IOException {
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

		private java.util.Date readDate(org.jboss.marshalling.Unmarshaller unmarshaller) throws IOException {
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

		private void writeDate(java.util.Date date1, ObjectOutputStream dos) throws IOException {
			if (date1 == null) {
				dos.writeByte(-1);
			} else {
				dos.writeByte(0);
				dos.writeLong(date1.getTime());
			}
		}

		private void writeDate(java.util.Date date1, org.jboss.marshalling.Marshaller marshaller) throws IOException {
			if (date1 == null) {
				marshaller.writeByte(-1);
			} else {
				marshaller.writeByte(0);
				marshaller.writeLong(date1.getTime());
			}
		}

		private String readString(ObjectInputStream dis) throws IOException {
			String strReturn = null;
			int length = 0;
			length = dis.readInt();
			if (length == -1) {
				strReturn = null;
			} else {
				if (length > commonByteArray_FINAL_PROJECT_bridge_crew_movie.length) {
					if (length < 1024 && commonByteArray_FINAL_PROJECT_bridge_crew_movie.length == 0) {
						commonByteArray_FINAL_PROJECT_bridge_crew_movie = new byte[1024];
					} else {
						commonByteArray_FINAL_PROJECT_bridge_crew_movie = new byte[2 * length];
					}
				}
				dis.readFully(commonByteArray_FINAL_PROJECT_bridge_crew_movie, 0, length);
				strReturn = new String(commonByteArray_FINAL_PROJECT_bridge_crew_movie, 0, length, utf8Charset);
			}
			return strReturn;
		}

		private String readString(org.jboss.marshalling.Unmarshaller unmarshaller) throws IOException {
			String strReturn = null;
			int length = 0;
			length = unmarshaller.readInt();
			if (length == -1) {
				strReturn = null;
			} else {
				if (length > commonByteArray_FINAL_PROJECT_bridge_crew_movie.length) {
					if (length < 1024 && commonByteArray_FINAL_PROJECT_bridge_crew_movie.length == 0) {
						commonByteArray_FINAL_PROJECT_bridge_crew_movie = new byte[1024];
					} else {
						commonByteArray_FINAL_PROJECT_bridge_crew_movie = new byte[2 * length];
					}
				}
				unmarshaller.readFully(commonByteArray_FINAL_PROJECT_bridge_crew_movie, 0, length);
				strReturn = new String(commonByteArray_FINAL_PROJECT_bridge_crew_movie, 0, length, utf8Charset);
			}
			return strReturn;
		}

		private void writeString(String str, ObjectOutputStream dos) throws IOException {
			if (str == null) {
				dos.writeInt(-1);
			} else {
				byte[] byteArray = str.getBytes(utf8Charset);
				dos.writeInt(byteArray.length);
				dos.write(byteArray);
			}
		}

		private void writeString(String str, org.jboss.marshalling.Marshaller marshaller) throws IOException {
			if (str == null) {
				marshaller.writeInt(-1);
			} else {
				byte[] byteArray = str.getBytes(utf8Charset);
				marshaller.writeInt(byteArray.length);
				marshaller.write(byteArray);
			}
		}

		public void readData(ObjectInputStream dis) {

			synchronized (commonByteArrayLock_FINAL_PROJECT_bridge_crew_movie) {

				try {

					int length = 0;

					this.Movie_ID = dis.readInt();

					this.Crew_SK = dis.readInt();

					this.Profession_SK = dis.readInt();

					this.DI_CreatedDate = readDate(dis);

					this.DI_WorkflowJobId = readString(dis);

				} catch (IOException e) {
					throw new RuntimeException(e);

				}

			}

		}

		public void readData(org.jboss.marshalling.Unmarshaller dis) {

			synchronized (commonByteArrayLock_FINAL_PROJECT_bridge_crew_movie) {

				try {

					int length = 0;

					this.Movie_ID = dis.readInt();

					this.Crew_SK = dis.readInt();

					this.Profession_SK = dis.readInt();

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

				// int

				dos.writeInt(this.Crew_SK);

				// int

				dos.writeInt(this.Profession_SK);

				// java.util.Date

				writeDate(this.DI_CreatedDate, dos);

				// String

				writeString(this.DI_WorkflowJobId, dos);

			} catch (IOException e) {
				throw new RuntimeException(e);
			}

		}

		public void writeData(org.jboss.marshalling.Marshaller dos) {
			try {

				// int

				dos.writeInt(this.Movie_ID);

				// int

				dos.writeInt(this.Crew_SK);

				// int

				dos.writeInt(this.Profession_SK);

				// java.util.Date

				writeDate(this.DI_CreatedDate, dos);

				// String

				writeString(this.DI_WorkflowJobId, dos);

			} catch (IOException e) {
				throw new RuntimeException(e);
			}

		}

		public String toString() {

			StringBuilder sb = new StringBuilder();
			sb.append(super.toString());
			sb.append("[");
			sb.append("Movie_ID=" + String.valueOf(Movie_ID));
			sb.append(",Crew_SK=" + String.valueOf(Crew_SK));
			sb.append(",Profession_SK=" + String.valueOf(Profession_SK));
			sb.append(",DI_CreatedDate=" + String.valueOf(DI_CreatedDate));
			sb.append(",DI_WorkflowJobId=" + DI_WorkflowJobId);
			sb.append("]");

			return sb.toString();
		}

		public String toLogString() {
			StringBuilder sb = new StringBuilder();

			sb.append(Movie_ID);

			sb.append("|");

			sb.append(Crew_SK);

			sb.append("|");

			sb.append(Profession_SK);

			sb.append("|");

			if (DI_CreatedDate == null) {
				sb.append("<null>");
			} else {
				sb.append(DI_CreatedDate);
			}

			sb.append("|");

			if (DI_WorkflowJobId == null) {
				sb.append("<null>");
			} else {
				sb.append(DI_WorkflowJobId);
			}

			sb.append("|");

			return sb.toString();
		}

		/**
		 * Compare keys
		 */
		public int compareTo(toTable1Struct other) {

			int returnValue = -1;

			returnValue = checkNullsAndCompare(this.Movie_ID, other.Movie_ID);
			if (returnValue != 0) {
				return returnValue;
			}

			returnValue = checkNullsAndCompare(this.Crew_SK, other.Crew_SK);
			if (returnValue != 0) {
				return returnValue;
			}

			returnValue = checkNullsAndCompare(this.Profession_SK, other.Profession_SK);
			if (returnValue != 0) {
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

	public static class row10Struct implements routines.system.IPersistableRow<row10Struct> {
		final static byte[] commonByteArrayLock_FINAL_PROJECT_bridge_crew_movie = new byte[0];
		static byte[] commonByteArray_FINAL_PROJECT_bridge_crew_movie = new byte[0];

		public String tconst;

		public String getTconst() {
			return this.tconst;
		}

		public Boolean tconstIsNullable() {
			return true;
		}

		public Boolean tconstIsKey() {
			return false;
		}

		public Integer tconstLength() {
			return null;
		}

		public Integer tconstPrecision() {
			return null;
		}

		public String tconstDefault() {

			return null;

		}

		public String tconstComment() {

			return "";

		}

		public String tconstPattern() {

			return "";

		}

		public String tconstOriginalDbColumnName() {

			return "tconst";

		}

		public String category;

		public String getCategory() {
			return this.category;
		}

		public Boolean categoryIsNullable() {
			return true;
		}

		public Boolean categoryIsKey() {
			return false;
		}

		public Integer categoryLength() {
			return null;
		}

		public Integer categoryPrecision() {
			return null;
		}

		public String categoryDefault() {

			return null;

		}

		public String categoryComment() {

			return "";

		}

		public String categoryPattern() {

			return "";

		}

		public String categoryOriginalDbColumnName() {

			return "category";

		}

		public String nconst;

		public String getNconst() {
			return this.nconst;
		}

		public Boolean nconstIsNullable() {
			return true;
		}

		public Boolean nconstIsKey() {
			return false;
		}

		public Integer nconstLength() {
			return null;
		}

		public Integer nconstPrecision() {
			return null;
		}

		public String nconstDefault() {

			return null;

		}

		public String nconstComment() {

			return "";

		}

		public String nconstPattern() {

			return "";

		}

		public String nconstOriginalDbColumnName() {

			return "nconst";

		}

		private String readString(ObjectInputStream dis) throws IOException {
			String strReturn = null;
			int length = 0;
			length = dis.readInt();
			if (length == -1) {
				strReturn = null;
			} else {
				if (length > commonByteArray_FINAL_PROJECT_bridge_crew_movie.length) {
					if (length < 1024 && commonByteArray_FINAL_PROJECT_bridge_crew_movie.length == 0) {
						commonByteArray_FINAL_PROJECT_bridge_crew_movie = new byte[1024];
					} else {
						commonByteArray_FINAL_PROJECT_bridge_crew_movie = new byte[2 * length];
					}
				}
				dis.readFully(commonByteArray_FINAL_PROJECT_bridge_crew_movie, 0, length);
				strReturn = new String(commonByteArray_FINAL_PROJECT_bridge_crew_movie, 0, length, utf8Charset);
			}
			return strReturn;
		}

		private String readString(org.jboss.marshalling.Unmarshaller unmarshaller) throws IOException {
			String strReturn = null;
			int length = 0;
			length = unmarshaller.readInt();
			if (length == -1) {
				strReturn = null;
			} else {
				if (length > commonByteArray_FINAL_PROJECT_bridge_crew_movie.length) {
					if (length < 1024 && commonByteArray_FINAL_PROJECT_bridge_crew_movie.length == 0) {
						commonByteArray_FINAL_PROJECT_bridge_crew_movie = new byte[1024];
					} else {
						commonByteArray_FINAL_PROJECT_bridge_crew_movie = new byte[2 * length];
					}
				}
				unmarshaller.readFully(commonByteArray_FINAL_PROJECT_bridge_crew_movie, 0, length);
				strReturn = new String(commonByteArray_FINAL_PROJECT_bridge_crew_movie, 0, length, utf8Charset);
			}
			return strReturn;
		}

		private void writeString(String str, ObjectOutputStream dos) throws IOException {
			if (str == null) {
				dos.writeInt(-1);
			} else {
				byte[] byteArray = str.getBytes(utf8Charset);
				dos.writeInt(byteArray.length);
				dos.write(byteArray);
			}
		}

		private void writeString(String str, org.jboss.marshalling.Marshaller marshaller) throws IOException {
			if (str == null) {
				marshaller.writeInt(-1);
			} else {
				byte[] byteArray = str.getBytes(utf8Charset);
				marshaller.writeInt(byteArray.length);
				marshaller.write(byteArray);
			}
		}

		public void readData(ObjectInputStream dis) {

			synchronized (commonByteArrayLock_FINAL_PROJECT_bridge_crew_movie) {

				try {

					int length = 0;

					this.tconst = readString(dis);

					this.category = readString(dis);

					this.nconst = readString(dis);

				} catch (IOException e) {
					throw new RuntimeException(e);

				}

			}

		}

		public void readData(org.jboss.marshalling.Unmarshaller dis) {

			synchronized (commonByteArrayLock_FINAL_PROJECT_bridge_crew_movie) {

				try {

					int length = 0;

					this.tconst = readString(dis);

					this.category = readString(dis);

					this.nconst = readString(dis);

				} catch (IOException e) {
					throw new RuntimeException(e);

				}

			}

		}

		public void writeData(ObjectOutputStream dos) {
			try {

				// String

				writeString(this.tconst, dos);

				// String

				writeString(this.category, dos);

				// String

				writeString(this.nconst, dos);

			} catch (IOException e) {
				throw new RuntimeException(e);
			}

		}

		public void writeData(org.jboss.marshalling.Marshaller dos) {
			try {

				// String

				writeString(this.tconst, dos);

				// String

				writeString(this.category, dos);

				// String

				writeString(this.nconst, dos);

			} catch (IOException e) {
				throw new RuntimeException(e);
			}

		}

		public String toString() {

			StringBuilder sb = new StringBuilder();
			sb.append(super.toString());
			sb.append("[");
			sb.append("tconst=" + tconst);
			sb.append(",category=" + category);
			sb.append(",nconst=" + nconst);
			sb.append("]");

			return sb.toString();
		}

		public String toLogString() {
			StringBuilder sb = new StringBuilder();

			if (tconst == null) {
				sb.append("<null>");
			} else {
				sb.append(tconst);
			}

			sb.append("|");

			if (category == null) {
				sb.append("<null>");
			} else {
				sb.append(category);
			}

			sb.append("|");

			if (nconst == null) {
				sb.append("<null>");
			} else {
				sb.append(nconst);
			}

			sb.append("|");

			return sb.toString();
		}

		/**
		 * Compare keys
		 */
		public int compareTo(row10Struct other) {

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

	public static class toDirectorStruct implements routines.system.IPersistableRow<toDirectorStruct> {
		final static byte[] commonByteArrayLock_FINAL_PROJECT_bridge_crew_movie = new byte[0];
		static byte[] commonByteArray_FINAL_PROJECT_bridge_crew_movie = new byte[0];

		public String tconst;

		public String getTconst() {
			return this.tconst;
		}

		public Boolean tconstIsNullable() {
			return true;
		}

		public Boolean tconstIsKey() {
			return false;
		}

		public Integer tconstLength() {
			return null;
		}

		public Integer tconstPrecision() {
			return null;
		}

		public String tconstDefault() {

			return null;

		}

		public String tconstComment() {

			return "";

		}

		public String tconstPattern() {

			return "";

		}

		public String tconstOriginalDbColumnName() {

			return "tconst";

		}

		public String category;

		public String getCategory() {
			return this.category;
		}

		public Boolean categoryIsNullable() {
			return true;
		}

		public Boolean categoryIsKey() {
			return false;
		}

		public Integer categoryLength() {
			return null;
		}

		public Integer categoryPrecision() {
			return null;
		}

		public String categoryDefault() {

			return null;

		}

		public String categoryComment() {

			return "";

		}

		public String categoryPattern() {

			return "";

		}

		public String categoryOriginalDbColumnName() {

			return "category";

		}

		public String nconst;

		public String getNconst() {
			return this.nconst;
		}

		public Boolean nconstIsNullable() {
			return true;
		}

		public Boolean nconstIsKey() {
			return false;
		}

		public Integer nconstLength() {
			return null;
		}

		public Integer nconstPrecision() {
			return null;
		}

		public String nconstDefault() {

			return null;

		}

		public String nconstComment() {

			return "";

		}

		public String nconstPattern() {

			return "";

		}

		public String nconstOriginalDbColumnName() {

			return "nconst";

		}

		private String readString(ObjectInputStream dis) throws IOException {
			String strReturn = null;
			int length = 0;
			length = dis.readInt();
			if (length == -1) {
				strReturn = null;
			} else {
				if (length > commonByteArray_FINAL_PROJECT_bridge_crew_movie.length) {
					if (length < 1024 && commonByteArray_FINAL_PROJECT_bridge_crew_movie.length == 0) {
						commonByteArray_FINAL_PROJECT_bridge_crew_movie = new byte[1024];
					} else {
						commonByteArray_FINAL_PROJECT_bridge_crew_movie = new byte[2 * length];
					}
				}
				dis.readFully(commonByteArray_FINAL_PROJECT_bridge_crew_movie, 0, length);
				strReturn = new String(commonByteArray_FINAL_PROJECT_bridge_crew_movie, 0, length, utf8Charset);
			}
			return strReturn;
		}

		private String readString(org.jboss.marshalling.Unmarshaller unmarshaller) throws IOException {
			String strReturn = null;
			int length = 0;
			length = unmarshaller.readInt();
			if (length == -1) {
				strReturn = null;
			} else {
				if (length > commonByteArray_FINAL_PROJECT_bridge_crew_movie.length) {
					if (length < 1024 && commonByteArray_FINAL_PROJECT_bridge_crew_movie.length == 0) {
						commonByteArray_FINAL_PROJECT_bridge_crew_movie = new byte[1024];
					} else {
						commonByteArray_FINAL_PROJECT_bridge_crew_movie = new byte[2 * length];
					}
				}
				unmarshaller.readFully(commonByteArray_FINAL_PROJECT_bridge_crew_movie, 0, length);
				strReturn = new String(commonByteArray_FINAL_PROJECT_bridge_crew_movie, 0, length, utf8Charset);
			}
			return strReturn;
		}

		private void writeString(String str, ObjectOutputStream dos) throws IOException {
			if (str == null) {
				dos.writeInt(-1);
			} else {
				byte[] byteArray = str.getBytes(utf8Charset);
				dos.writeInt(byteArray.length);
				dos.write(byteArray);
			}
		}

		private void writeString(String str, org.jboss.marshalling.Marshaller marshaller) throws IOException {
			if (str == null) {
				marshaller.writeInt(-1);
			} else {
				byte[] byteArray = str.getBytes(utf8Charset);
				marshaller.writeInt(byteArray.length);
				marshaller.write(byteArray);
			}
		}

		public void readData(ObjectInputStream dis) {

			synchronized (commonByteArrayLock_FINAL_PROJECT_bridge_crew_movie) {

				try {

					int length = 0;

					this.tconst = readString(dis);

					this.category = readString(dis);

					this.nconst = readString(dis);

				} catch (IOException e) {
					throw new RuntimeException(e);

				}

			}

		}

		public void readData(org.jboss.marshalling.Unmarshaller dis) {

			synchronized (commonByteArrayLock_FINAL_PROJECT_bridge_crew_movie) {

				try {

					int length = 0;

					this.tconst = readString(dis);

					this.category = readString(dis);

					this.nconst = readString(dis);

				} catch (IOException e) {
					throw new RuntimeException(e);

				}

			}

		}

		public void writeData(ObjectOutputStream dos) {
			try {

				// String

				writeString(this.tconst, dos);

				// String

				writeString(this.category, dos);

				// String

				writeString(this.nconst, dos);

			} catch (IOException e) {
				throw new RuntimeException(e);
			}

		}

		public void writeData(org.jboss.marshalling.Marshaller dos) {
			try {

				// String

				writeString(this.tconst, dos);

				// String

				writeString(this.category, dos);

				// String

				writeString(this.nconst, dos);

			} catch (IOException e) {
				throw new RuntimeException(e);
			}

		}

		public String toString() {

			StringBuilder sb = new StringBuilder();
			sb.append(super.toString());
			sb.append("[");
			sb.append("tconst=" + tconst);
			sb.append(",category=" + category);
			sb.append(",nconst=" + nconst);
			sb.append("]");

			return sb.toString();
		}

		public String toLogString() {
			StringBuilder sb = new StringBuilder();

			if (tconst == null) {
				sb.append("<null>");
			} else {
				sb.append(tconst);
			}

			sb.append("|");

			if (category == null) {
				sb.append("<null>");
			} else {
				sb.append(category);
			}

			sb.append("|");

			if (nconst == null) {
				sb.append("<null>");
			} else {
				sb.append(nconst);
			}

			sb.append("|");

			return sb.toString();
		}

		/**
		 * Compare keys
		 */
		public int compareTo(toDirectorStruct other) {

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

	public static class row7Struct implements routines.system.IPersistableRow<row7Struct> {
		final static byte[] commonByteArrayLock_FINAL_PROJECT_bridge_crew_movie = new byte[0];
		static byte[] commonByteArray_FINAL_PROJECT_bridge_crew_movie = new byte[0];

		public String tconst;

		public String getTconst() {
			return this.tconst;
		}

		public Boolean tconstIsNullable() {
			return false;
		}

		public Boolean tconstIsKey() {
			return false;
		}

		public Integer tconstLength() {
			return 10;
		}

		public Integer tconstPrecision() {
			return 0;
		}

		public String tconstDefault() {

			return null;

		}

		public String tconstComment() {

			return "";

		}

		public String tconstPattern() {

			return "";

		}

		public String tconstOriginalDbColumnName() {

			return "tconst";

		}

		public String directors;

		public String getDirectors() {
			return this.directors;
		}

		public Boolean directorsIsNullable() {
			return true;
		}

		public Boolean directorsIsKey() {
			return false;
		}

		public Integer directorsLength() {
			return 4000;
		}

		public Integer directorsPrecision() {
			return 0;
		}

		public String directorsDefault() {

			return null;

		}

		public String directorsComment() {

			return "";

		}

		public String directorsPattern() {

			return "";

		}

		public String directorsOriginalDbColumnName() {

			return "directors";

		}

		private String readString(ObjectInputStream dis) throws IOException {
			String strReturn = null;
			int length = 0;
			length = dis.readInt();
			if (length == -1) {
				strReturn = null;
			} else {
				if (length > commonByteArray_FINAL_PROJECT_bridge_crew_movie.length) {
					if (length < 1024 && commonByteArray_FINAL_PROJECT_bridge_crew_movie.length == 0) {
						commonByteArray_FINAL_PROJECT_bridge_crew_movie = new byte[1024];
					} else {
						commonByteArray_FINAL_PROJECT_bridge_crew_movie = new byte[2 * length];
					}
				}
				dis.readFully(commonByteArray_FINAL_PROJECT_bridge_crew_movie, 0, length);
				strReturn = new String(commonByteArray_FINAL_PROJECT_bridge_crew_movie, 0, length, utf8Charset);
			}
			return strReturn;
		}

		private String readString(org.jboss.marshalling.Unmarshaller unmarshaller) throws IOException {
			String strReturn = null;
			int length = 0;
			length = unmarshaller.readInt();
			if (length == -1) {
				strReturn = null;
			} else {
				if (length > commonByteArray_FINAL_PROJECT_bridge_crew_movie.length) {
					if (length < 1024 && commonByteArray_FINAL_PROJECT_bridge_crew_movie.length == 0) {
						commonByteArray_FINAL_PROJECT_bridge_crew_movie = new byte[1024];
					} else {
						commonByteArray_FINAL_PROJECT_bridge_crew_movie = new byte[2 * length];
					}
				}
				unmarshaller.readFully(commonByteArray_FINAL_PROJECT_bridge_crew_movie, 0, length);
				strReturn = new String(commonByteArray_FINAL_PROJECT_bridge_crew_movie, 0, length, utf8Charset);
			}
			return strReturn;
		}

		private void writeString(String str, ObjectOutputStream dos) throws IOException {
			if (str == null) {
				dos.writeInt(-1);
			} else {
				byte[] byteArray = str.getBytes(utf8Charset);
				dos.writeInt(byteArray.length);
				dos.write(byteArray);
			}
		}

		private void writeString(String str, org.jboss.marshalling.Marshaller marshaller) throws IOException {
			if (str == null) {
				marshaller.writeInt(-1);
			} else {
				byte[] byteArray = str.getBytes(utf8Charset);
				marshaller.writeInt(byteArray.length);
				marshaller.write(byteArray);
			}
		}

		public void readData(ObjectInputStream dis) {

			synchronized (commonByteArrayLock_FINAL_PROJECT_bridge_crew_movie) {

				try {

					int length = 0;

					this.tconst = readString(dis);

					this.directors = readString(dis);

				} catch (IOException e) {
					throw new RuntimeException(e);

				}

			}

		}

		public void readData(org.jboss.marshalling.Unmarshaller dis) {

			synchronized (commonByteArrayLock_FINAL_PROJECT_bridge_crew_movie) {

				try {

					int length = 0;

					this.tconst = readString(dis);

					this.directors = readString(dis);

				} catch (IOException e) {
					throw new RuntimeException(e);

				}

			}

		}

		public void writeData(ObjectOutputStream dos) {
			try {

				// String

				writeString(this.tconst, dos);

				// String

				writeString(this.directors, dos);

			} catch (IOException e) {
				throw new RuntimeException(e);
			}

		}

		public void writeData(org.jboss.marshalling.Marshaller dos) {
			try {

				// String

				writeString(this.tconst, dos);

				// String

				writeString(this.directors, dos);

			} catch (IOException e) {
				throw new RuntimeException(e);
			}

		}

		public String toString() {

			StringBuilder sb = new StringBuilder();
			sb.append(super.toString());
			sb.append("[");
			sb.append("tconst=" + tconst);
			sb.append(",directors=" + directors);
			sb.append("]");

			return sb.toString();
		}

		public String toLogString() {
			StringBuilder sb = new StringBuilder();

			if (tconst == null) {
				sb.append("<null>");
			} else {
				sb.append(tconst);
			}

			sb.append("|");

			if (directors == null) {
				sb.append("<null>");
			} else {
				sb.append(directors);
			}

			sb.append("|");

			return sb.toString();
		}

		/**
		 * Compare keys
		 */
		public int compareTo(row7Struct other) {

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

	public static class row6Struct implements routines.system.IPersistableRow<row6Struct> {
		final static byte[] commonByteArrayLock_FINAL_PROJECT_bridge_crew_movie = new byte[0];
		static byte[] commonByteArray_FINAL_PROJECT_bridge_crew_movie = new byte[0];

		public String tconst;

		public String getTconst() {
			return this.tconst;
		}

		public Boolean tconstIsNullable() {
			return false;
		}

		public Boolean tconstIsKey() {
			return false;
		}

		public Integer tconstLength() {
			return 10;
		}

		public Integer tconstPrecision() {
			return 0;
		}

		public String tconstDefault() {

			return null;

		}

		public String tconstComment() {

			return "";

		}

		public String tconstPattern() {

			return "";

		}

		public String tconstOriginalDbColumnName() {

			return "tconst";

		}

		public String directors;

		public String getDirectors() {
			return this.directors;
		}

		public Boolean directorsIsNullable() {
			return true;
		}

		public Boolean directorsIsKey() {
			return false;
		}

		public Integer directorsLength() {
			return 4000;
		}

		public Integer directorsPrecision() {
			return 0;
		}

		public String directorsDefault() {

			return null;

		}

		public String directorsComment() {

			return "";

		}

		public String directorsPattern() {

			return "";

		}

		public String directorsOriginalDbColumnName() {

			return "directors";

		}

		private String readString(ObjectInputStream dis) throws IOException {
			String strReturn = null;
			int length = 0;
			length = dis.readInt();
			if (length == -1) {
				strReturn = null;
			} else {
				if (length > commonByteArray_FINAL_PROJECT_bridge_crew_movie.length) {
					if (length < 1024 && commonByteArray_FINAL_PROJECT_bridge_crew_movie.length == 0) {
						commonByteArray_FINAL_PROJECT_bridge_crew_movie = new byte[1024];
					} else {
						commonByteArray_FINAL_PROJECT_bridge_crew_movie = new byte[2 * length];
					}
				}
				dis.readFully(commonByteArray_FINAL_PROJECT_bridge_crew_movie, 0, length);
				strReturn = new String(commonByteArray_FINAL_PROJECT_bridge_crew_movie, 0, length, utf8Charset);
			}
			return strReturn;
		}

		private String readString(org.jboss.marshalling.Unmarshaller unmarshaller) throws IOException {
			String strReturn = null;
			int length = 0;
			length = unmarshaller.readInt();
			if (length == -1) {
				strReturn = null;
			} else {
				if (length > commonByteArray_FINAL_PROJECT_bridge_crew_movie.length) {
					if (length < 1024 && commonByteArray_FINAL_PROJECT_bridge_crew_movie.length == 0) {
						commonByteArray_FINAL_PROJECT_bridge_crew_movie = new byte[1024];
					} else {
						commonByteArray_FINAL_PROJECT_bridge_crew_movie = new byte[2 * length];
					}
				}
				unmarshaller.readFully(commonByteArray_FINAL_PROJECT_bridge_crew_movie, 0, length);
				strReturn = new String(commonByteArray_FINAL_PROJECT_bridge_crew_movie, 0, length, utf8Charset);
			}
			return strReturn;
		}

		private void writeString(String str, ObjectOutputStream dos) throws IOException {
			if (str == null) {
				dos.writeInt(-1);
			} else {
				byte[] byteArray = str.getBytes(utf8Charset);
				dos.writeInt(byteArray.length);
				dos.write(byteArray);
			}
		}

		private void writeString(String str, org.jboss.marshalling.Marshaller marshaller) throws IOException {
			if (str == null) {
				marshaller.writeInt(-1);
			} else {
				byte[] byteArray = str.getBytes(utf8Charset);
				marshaller.writeInt(byteArray.length);
				marshaller.write(byteArray);
			}
		}

		public void readData(ObjectInputStream dis) {

			synchronized (commonByteArrayLock_FINAL_PROJECT_bridge_crew_movie) {

				try {

					int length = 0;

					this.tconst = readString(dis);

					this.directors = readString(dis);

				} catch (IOException e) {
					throw new RuntimeException(e);

				}

			}

		}

		public void readData(org.jboss.marshalling.Unmarshaller dis) {

			synchronized (commonByteArrayLock_FINAL_PROJECT_bridge_crew_movie) {

				try {

					int length = 0;

					this.tconst = readString(dis);

					this.directors = readString(dis);

				} catch (IOException e) {
					throw new RuntimeException(e);

				}

			}

		}

		public void writeData(ObjectOutputStream dos) {
			try {

				// String

				writeString(this.tconst, dos);

				// String

				writeString(this.directors, dos);

			} catch (IOException e) {
				throw new RuntimeException(e);
			}

		}

		public void writeData(org.jboss.marshalling.Marshaller dos) {
			try {

				// String

				writeString(this.tconst, dos);

				// String

				writeString(this.directors, dos);

			} catch (IOException e) {
				throw new RuntimeException(e);
			}

		}

		public String toString() {

			StringBuilder sb = new StringBuilder();
			sb.append(super.toString());
			sb.append("[");
			sb.append("tconst=" + tconst);
			sb.append(",directors=" + directors);
			sb.append("]");

			return sb.toString();
		}

		public String toLogString() {
			StringBuilder sb = new StringBuilder();

			if (tconst == null) {
				sb.append("<null>");
			} else {
				sb.append(tconst);
			}

			sb.append("|");

			if (directors == null) {
				sb.append("<null>");
			} else {
				sb.append(directors);
			}

			sb.append("|");

			return sb.toString();
		}

		/**
		 * Compare keys
		 */
		public int compareTo(row6Struct other) {

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

	public static class after_tDBInput_2Struct implements routines.system.IPersistableRow<after_tDBInput_2Struct> {
		final static byte[] commonByteArrayLock_FINAL_PROJECT_bridge_crew_movie = new byte[0];
		static byte[] commonByteArray_FINAL_PROJECT_bridge_crew_movie = new byte[0];

		public String tconst;

		public String getTconst() {
			return this.tconst;
		}

		public Boolean tconstIsNullable() {
			return false;
		}

		public Boolean tconstIsKey() {
			return false;
		}

		public Integer tconstLength() {
			return 10;
		}

		public Integer tconstPrecision() {
			return 0;
		}

		public String tconstDefault() {

			return null;

		}

		public String tconstComment() {

			return "";

		}

		public String tconstPattern() {

			return "";

		}

		public String tconstOriginalDbColumnName() {

			return "tconst";

		}

		public String directors;

		public String getDirectors() {
			return this.directors;
		}

		public Boolean directorsIsNullable() {
			return true;
		}

		public Boolean directorsIsKey() {
			return false;
		}

		public Integer directorsLength() {
			return 4000;
		}

		public Integer directorsPrecision() {
			return 0;
		}

		public String directorsDefault() {

			return null;

		}

		public String directorsComment() {

			return "";

		}

		public String directorsPattern() {

			return "";

		}

		public String directorsOriginalDbColumnName() {

			return "directors";

		}

		private String readString(ObjectInputStream dis) throws IOException {
			String strReturn = null;
			int length = 0;
			length = dis.readInt();
			if (length == -1) {
				strReturn = null;
			} else {
				if (length > commonByteArray_FINAL_PROJECT_bridge_crew_movie.length) {
					if (length < 1024 && commonByteArray_FINAL_PROJECT_bridge_crew_movie.length == 0) {
						commonByteArray_FINAL_PROJECT_bridge_crew_movie = new byte[1024];
					} else {
						commonByteArray_FINAL_PROJECT_bridge_crew_movie = new byte[2 * length];
					}
				}
				dis.readFully(commonByteArray_FINAL_PROJECT_bridge_crew_movie, 0, length);
				strReturn = new String(commonByteArray_FINAL_PROJECT_bridge_crew_movie, 0, length, utf8Charset);
			}
			return strReturn;
		}

		private String readString(org.jboss.marshalling.Unmarshaller unmarshaller) throws IOException {
			String strReturn = null;
			int length = 0;
			length = unmarshaller.readInt();
			if (length == -1) {
				strReturn = null;
			} else {
				if (length > commonByteArray_FINAL_PROJECT_bridge_crew_movie.length) {
					if (length < 1024 && commonByteArray_FINAL_PROJECT_bridge_crew_movie.length == 0) {
						commonByteArray_FINAL_PROJECT_bridge_crew_movie = new byte[1024];
					} else {
						commonByteArray_FINAL_PROJECT_bridge_crew_movie = new byte[2 * length];
					}
				}
				unmarshaller.readFully(commonByteArray_FINAL_PROJECT_bridge_crew_movie, 0, length);
				strReturn = new String(commonByteArray_FINAL_PROJECT_bridge_crew_movie, 0, length, utf8Charset);
			}
			return strReturn;
		}

		private void writeString(String str, ObjectOutputStream dos) throws IOException {
			if (str == null) {
				dos.writeInt(-1);
			} else {
				byte[] byteArray = str.getBytes(utf8Charset);
				dos.writeInt(byteArray.length);
				dos.write(byteArray);
			}
		}

		private void writeString(String str, org.jboss.marshalling.Marshaller marshaller) throws IOException {
			if (str == null) {
				marshaller.writeInt(-1);
			} else {
				byte[] byteArray = str.getBytes(utf8Charset);
				marshaller.writeInt(byteArray.length);
				marshaller.write(byteArray);
			}
		}

		public void readData(ObjectInputStream dis) {

			synchronized (commonByteArrayLock_FINAL_PROJECT_bridge_crew_movie) {

				try {

					int length = 0;

					this.tconst = readString(dis);

					this.directors = readString(dis);

				} catch (IOException e) {
					throw new RuntimeException(e);

				}

			}

		}

		public void readData(org.jboss.marshalling.Unmarshaller dis) {

			synchronized (commonByteArrayLock_FINAL_PROJECT_bridge_crew_movie) {

				try {

					int length = 0;

					this.tconst = readString(dis);

					this.directors = readString(dis);

				} catch (IOException e) {
					throw new RuntimeException(e);

				}

			}

		}

		public void writeData(ObjectOutputStream dos) {
			try {

				// String

				writeString(this.tconst, dos);

				// String

				writeString(this.directors, dos);

			} catch (IOException e) {
				throw new RuntimeException(e);
			}

		}

		public void writeData(org.jboss.marshalling.Marshaller dos) {
			try {

				// String

				writeString(this.tconst, dos);

				// String

				writeString(this.directors, dos);

			} catch (IOException e) {
				throw new RuntimeException(e);
			}

		}

		public String toString() {

			StringBuilder sb = new StringBuilder();
			sb.append(super.toString());
			sb.append("[");
			sb.append("tconst=" + tconst);
			sb.append(",directors=" + directors);
			sb.append("]");

			return sb.toString();
		}

		public String toLogString() {
			StringBuilder sb = new StringBuilder();

			if (tconst == null) {
				sb.append("<null>");
			} else {
				sb.append(tconst);
			}

			sb.append("|");

			if (directors == null) {
				sb.append("<null>");
			} else {
				sb.append(directors);
			}

			sb.append("|");

			return sb.toString();
		}

		/**
		 * Compare keys
		 */
		public int compareTo(after_tDBInput_2Struct other) {

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

	public static class copyOftoDirectorStruct implements routines.system.IPersistableRow<copyOftoDirectorStruct> {
		final static byte[] commonByteArrayLock_FINAL_PROJECT_bridge_crew_movie = new byte[0];
		static byte[] commonByteArray_FINAL_PROJECT_bridge_crew_movie = new byte[0];

		public String tconst;

		public String getTconst() {
			return this.tconst;
		}

		public Boolean tconstIsNullable() {
			return true;
		}

		public Boolean tconstIsKey() {
			return false;
		}

		public Integer tconstLength() {
			return null;
		}

		public Integer tconstPrecision() {
			return null;
		}

		public String tconstDefault() {

			return null;

		}

		public String tconstComment() {

			return "";

		}

		public String tconstPattern() {

			return "";

		}

		public String tconstOriginalDbColumnName() {

			return "tconst";

		}

		public String category;

		public String getCategory() {
			return this.category;
		}

		public Boolean categoryIsNullable() {
			return true;
		}

		public Boolean categoryIsKey() {
			return false;
		}

		public Integer categoryLength() {
			return null;
		}

		public Integer categoryPrecision() {
			return null;
		}

		public String categoryDefault() {

			return null;

		}

		public String categoryComment() {

			return "";

		}

		public String categoryPattern() {

			return "";

		}

		public String categoryOriginalDbColumnName() {

			return "category";

		}

		public String nconst;

		public String getNconst() {
			return this.nconst;
		}

		public Boolean nconstIsNullable() {
			return true;
		}

		public Boolean nconstIsKey() {
			return false;
		}

		public Integer nconstLength() {
			return null;
		}

		public Integer nconstPrecision() {
			return null;
		}

		public String nconstDefault() {

			return null;

		}

		public String nconstComment() {

			return "";

		}

		public String nconstPattern() {

			return "";

		}

		public String nconstOriginalDbColumnName() {

			return "nconst";

		}

		private String readString(ObjectInputStream dis) throws IOException {
			String strReturn = null;
			int length = 0;
			length = dis.readInt();
			if (length == -1) {
				strReturn = null;
			} else {
				if (length > commonByteArray_FINAL_PROJECT_bridge_crew_movie.length) {
					if (length < 1024 && commonByteArray_FINAL_PROJECT_bridge_crew_movie.length == 0) {
						commonByteArray_FINAL_PROJECT_bridge_crew_movie = new byte[1024];
					} else {
						commonByteArray_FINAL_PROJECT_bridge_crew_movie = new byte[2 * length];
					}
				}
				dis.readFully(commonByteArray_FINAL_PROJECT_bridge_crew_movie, 0, length);
				strReturn = new String(commonByteArray_FINAL_PROJECT_bridge_crew_movie, 0, length, utf8Charset);
			}
			return strReturn;
		}

		private String readString(org.jboss.marshalling.Unmarshaller unmarshaller) throws IOException {
			String strReturn = null;
			int length = 0;
			length = unmarshaller.readInt();
			if (length == -1) {
				strReturn = null;
			} else {
				if (length > commonByteArray_FINAL_PROJECT_bridge_crew_movie.length) {
					if (length < 1024 && commonByteArray_FINAL_PROJECT_bridge_crew_movie.length == 0) {
						commonByteArray_FINAL_PROJECT_bridge_crew_movie = new byte[1024];
					} else {
						commonByteArray_FINAL_PROJECT_bridge_crew_movie = new byte[2 * length];
					}
				}
				unmarshaller.readFully(commonByteArray_FINAL_PROJECT_bridge_crew_movie, 0, length);
				strReturn = new String(commonByteArray_FINAL_PROJECT_bridge_crew_movie, 0, length, utf8Charset);
			}
			return strReturn;
		}

		private void writeString(String str, ObjectOutputStream dos) throws IOException {
			if (str == null) {
				dos.writeInt(-1);
			} else {
				byte[] byteArray = str.getBytes(utf8Charset);
				dos.writeInt(byteArray.length);
				dos.write(byteArray);
			}
		}

		private void writeString(String str, org.jboss.marshalling.Marshaller marshaller) throws IOException {
			if (str == null) {
				marshaller.writeInt(-1);
			} else {
				byte[] byteArray = str.getBytes(utf8Charset);
				marshaller.writeInt(byteArray.length);
				marshaller.write(byteArray);
			}
		}

		public void readData(ObjectInputStream dis) {

			synchronized (commonByteArrayLock_FINAL_PROJECT_bridge_crew_movie) {

				try {

					int length = 0;

					this.tconst = readString(dis);

					this.category = readString(dis);

					this.nconst = readString(dis);

				} catch (IOException e) {
					throw new RuntimeException(e);

				}

			}

		}

		public void readData(org.jboss.marshalling.Unmarshaller dis) {

			synchronized (commonByteArrayLock_FINAL_PROJECT_bridge_crew_movie) {

				try {

					int length = 0;

					this.tconst = readString(dis);

					this.category = readString(dis);

					this.nconst = readString(dis);

				} catch (IOException e) {
					throw new RuntimeException(e);

				}

			}

		}

		public void writeData(ObjectOutputStream dos) {
			try {

				// String

				writeString(this.tconst, dos);

				// String

				writeString(this.category, dos);

				// String

				writeString(this.nconst, dos);

			} catch (IOException e) {
				throw new RuntimeException(e);
			}

		}

		public void writeData(org.jboss.marshalling.Marshaller dos) {
			try {

				// String

				writeString(this.tconst, dos);

				// String

				writeString(this.category, dos);

				// String

				writeString(this.nconst, dos);

			} catch (IOException e) {
				throw new RuntimeException(e);
			}

		}

		public String toString() {

			StringBuilder sb = new StringBuilder();
			sb.append(super.toString());
			sb.append("[");
			sb.append("tconst=" + tconst);
			sb.append(",category=" + category);
			sb.append(",nconst=" + nconst);
			sb.append("]");

			return sb.toString();
		}

		public String toLogString() {
			StringBuilder sb = new StringBuilder();

			if (tconst == null) {
				sb.append("<null>");
			} else {
				sb.append(tconst);
			}

			sb.append("|");

			if (category == null) {
				sb.append("<null>");
			} else {
				sb.append(category);
			}

			sb.append("|");

			if (nconst == null) {
				sb.append("<null>");
			} else {
				sb.append(nconst);
			}

			sb.append("|");

			return sb.toString();
		}

		/**
		 * Compare keys
		 */
		public int compareTo(copyOftoDirectorStruct other) {

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

	public static class row9Struct implements routines.system.IPersistableRow<row9Struct> {
		final static byte[] commonByteArrayLock_FINAL_PROJECT_bridge_crew_movie = new byte[0];
		static byte[] commonByteArray_FINAL_PROJECT_bridge_crew_movie = new byte[0];

		public String tconst;

		public String getTconst() {
			return this.tconst;
		}

		public Boolean tconstIsNullable() {
			return false;
		}

		public Boolean tconstIsKey() {
			return false;
		}

		public Integer tconstLength() {
			return 10;
		}

		public Integer tconstPrecision() {
			return 0;
		}

		public String tconstDefault() {

			return null;

		}

		public String tconstComment() {

			return "";

		}

		public String tconstPattern() {

			return "";

		}

		public String tconstOriginalDbColumnName() {

			return "tconst";

		}

		public String writers;

		public String getWriters() {
			return this.writers;
		}

		public Boolean writersIsNullable() {
			return true;
		}

		public Boolean writersIsKey() {
			return false;
		}

		public Integer writersLength() {
			return 4000;
		}

		public Integer writersPrecision() {
			return 0;
		}

		public String writersDefault() {

			return null;

		}

		public String writersComment() {

			return "";

		}

		public String writersPattern() {

			return "";

		}

		public String writersOriginalDbColumnName() {

			return "writers";

		}

		private String readString(ObjectInputStream dis) throws IOException {
			String strReturn = null;
			int length = 0;
			length = dis.readInt();
			if (length == -1) {
				strReturn = null;
			} else {
				if (length > commonByteArray_FINAL_PROJECT_bridge_crew_movie.length) {
					if (length < 1024 && commonByteArray_FINAL_PROJECT_bridge_crew_movie.length == 0) {
						commonByteArray_FINAL_PROJECT_bridge_crew_movie = new byte[1024];
					} else {
						commonByteArray_FINAL_PROJECT_bridge_crew_movie = new byte[2 * length];
					}
				}
				dis.readFully(commonByteArray_FINAL_PROJECT_bridge_crew_movie, 0, length);
				strReturn = new String(commonByteArray_FINAL_PROJECT_bridge_crew_movie, 0, length, utf8Charset);
			}
			return strReturn;
		}

		private String readString(org.jboss.marshalling.Unmarshaller unmarshaller) throws IOException {
			String strReturn = null;
			int length = 0;
			length = unmarshaller.readInt();
			if (length == -1) {
				strReturn = null;
			} else {
				if (length > commonByteArray_FINAL_PROJECT_bridge_crew_movie.length) {
					if (length < 1024 && commonByteArray_FINAL_PROJECT_bridge_crew_movie.length == 0) {
						commonByteArray_FINAL_PROJECT_bridge_crew_movie = new byte[1024];
					} else {
						commonByteArray_FINAL_PROJECT_bridge_crew_movie = new byte[2 * length];
					}
				}
				unmarshaller.readFully(commonByteArray_FINAL_PROJECT_bridge_crew_movie, 0, length);
				strReturn = new String(commonByteArray_FINAL_PROJECT_bridge_crew_movie, 0, length, utf8Charset);
			}
			return strReturn;
		}

		private void writeString(String str, ObjectOutputStream dos) throws IOException {
			if (str == null) {
				dos.writeInt(-1);
			} else {
				byte[] byteArray = str.getBytes(utf8Charset);
				dos.writeInt(byteArray.length);
				dos.write(byteArray);
			}
		}

		private void writeString(String str, org.jboss.marshalling.Marshaller marshaller) throws IOException {
			if (str == null) {
				marshaller.writeInt(-1);
			} else {
				byte[] byteArray = str.getBytes(utf8Charset);
				marshaller.writeInt(byteArray.length);
				marshaller.write(byteArray);
			}
		}

		public void readData(ObjectInputStream dis) {

			synchronized (commonByteArrayLock_FINAL_PROJECT_bridge_crew_movie) {

				try {

					int length = 0;

					this.tconst = readString(dis);

					this.writers = readString(dis);

				} catch (IOException e) {
					throw new RuntimeException(e);

				}

			}

		}

		public void readData(org.jboss.marshalling.Unmarshaller dis) {

			synchronized (commonByteArrayLock_FINAL_PROJECT_bridge_crew_movie) {

				try {

					int length = 0;

					this.tconst = readString(dis);

					this.writers = readString(dis);

				} catch (IOException e) {
					throw new RuntimeException(e);

				}

			}

		}

		public void writeData(ObjectOutputStream dos) {
			try {

				// String

				writeString(this.tconst, dos);

				// String

				writeString(this.writers, dos);

			} catch (IOException e) {
				throw new RuntimeException(e);
			}

		}

		public void writeData(org.jboss.marshalling.Marshaller dos) {
			try {

				// String

				writeString(this.tconst, dos);

				// String

				writeString(this.writers, dos);

			} catch (IOException e) {
				throw new RuntimeException(e);
			}

		}

		public String toString() {

			StringBuilder sb = new StringBuilder();
			sb.append(super.toString());
			sb.append("[");
			sb.append("tconst=" + tconst);
			sb.append(",writers=" + writers);
			sb.append("]");

			return sb.toString();
		}

		public String toLogString() {
			StringBuilder sb = new StringBuilder();

			if (tconst == null) {
				sb.append("<null>");
			} else {
				sb.append(tconst);
			}

			sb.append("|");

			if (writers == null) {
				sb.append("<null>");
			} else {
				sb.append(writers);
			}

			sb.append("|");

			return sb.toString();
		}

		/**
		 * Compare keys
		 */
		public int compareTo(row9Struct other) {

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

	public static class row8Struct implements routines.system.IPersistableRow<row8Struct> {
		final static byte[] commonByteArrayLock_FINAL_PROJECT_bridge_crew_movie = new byte[0];
		static byte[] commonByteArray_FINAL_PROJECT_bridge_crew_movie = new byte[0];

		public String tconst;

		public String getTconst() {
			return this.tconst;
		}

		public Boolean tconstIsNullable() {
			return false;
		}

		public Boolean tconstIsKey() {
			return false;
		}

		public Integer tconstLength() {
			return 10;
		}

		public Integer tconstPrecision() {
			return 0;
		}

		public String tconstDefault() {

			return null;

		}

		public String tconstComment() {

			return "";

		}

		public String tconstPattern() {

			return "";

		}

		public String tconstOriginalDbColumnName() {

			return "tconst";

		}

		public String writers;

		public String getWriters() {
			return this.writers;
		}

		public Boolean writersIsNullable() {
			return true;
		}

		public Boolean writersIsKey() {
			return false;
		}

		public Integer writersLength() {
			return 4000;
		}

		public Integer writersPrecision() {
			return 0;
		}

		public String writersDefault() {

			return null;

		}

		public String writersComment() {

			return "";

		}

		public String writersPattern() {

			return "";

		}

		public String writersOriginalDbColumnName() {

			return "writers";

		}

		private String readString(ObjectInputStream dis) throws IOException {
			String strReturn = null;
			int length = 0;
			length = dis.readInt();
			if (length == -1) {
				strReturn = null;
			} else {
				if (length > commonByteArray_FINAL_PROJECT_bridge_crew_movie.length) {
					if (length < 1024 && commonByteArray_FINAL_PROJECT_bridge_crew_movie.length == 0) {
						commonByteArray_FINAL_PROJECT_bridge_crew_movie = new byte[1024];
					} else {
						commonByteArray_FINAL_PROJECT_bridge_crew_movie = new byte[2 * length];
					}
				}
				dis.readFully(commonByteArray_FINAL_PROJECT_bridge_crew_movie, 0, length);
				strReturn = new String(commonByteArray_FINAL_PROJECT_bridge_crew_movie, 0, length, utf8Charset);
			}
			return strReturn;
		}

		private String readString(org.jboss.marshalling.Unmarshaller unmarshaller) throws IOException {
			String strReturn = null;
			int length = 0;
			length = unmarshaller.readInt();
			if (length == -1) {
				strReturn = null;
			} else {
				if (length > commonByteArray_FINAL_PROJECT_bridge_crew_movie.length) {
					if (length < 1024 && commonByteArray_FINAL_PROJECT_bridge_crew_movie.length == 0) {
						commonByteArray_FINAL_PROJECT_bridge_crew_movie = new byte[1024];
					} else {
						commonByteArray_FINAL_PROJECT_bridge_crew_movie = new byte[2 * length];
					}
				}
				unmarshaller.readFully(commonByteArray_FINAL_PROJECT_bridge_crew_movie, 0, length);
				strReturn = new String(commonByteArray_FINAL_PROJECT_bridge_crew_movie, 0, length, utf8Charset);
			}
			return strReturn;
		}

		private void writeString(String str, ObjectOutputStream dos) throws IOException {
			if (str == null) {
				dos.writeInt(-1);
			} else {
				byte[] byteArray = str.getBytes(utf8Charset);
				dos.writeInt(byteArray.length);
				dos.write(byteArray);
			}
		}

		private void writeString(String str, org.jboss.marshalling.Marshaller marshaller) throws IOException {
			if (str == null) {
				marshaller.writeInt(-1);
			} else {
				byte[] byteArray = str.getBytes(utf8Charset);
				marshaller.writeInt(byteArray.length);
				marshaller.write(byteArray);
			}
		}

		public void readData(ObjectInputStream dis) {

			synchronized (commonByteArrayLock_FINAL_PROJECT_bridge_crew_movie) {

				try {

					int length = 0;

					this.tconst = readString(dis);

					this.writers = readString(dis);

				} catch (IOException e) {
					throw new RuntimeException(e);

				}

			}

		}

		public void readData(org.jboss.marshalling.Unmarshaller dis) {

			synchronized (commonByteArrayLock_FINAL_PROJECT_bridge_crew_movie) {

				try {

					int length = 0;

					this.tconst = readString(dis);

					this.writers = readString(dis);

				} catch (IOException e) {
					throw new RuntimeException(e);

				}

			}

		}

		public void writeData(ObjectOutputStream dos) {
			try {

				// String

				writeString(this.tconst, dos);

				// String

				writeString(this.writers, dos);

			} catch (IOException e) {
				throw new RuntimeException(e);
			}

		}

		public void writeData(org.jboss.marshalling.Marshaller dos) {
			try {

				// String

				writeString(this.tconst, dos);

				// String

				writeString(this.writers, dos);

			} catch (IOException e) {
				throw new RuntimeException(e);
			}

		}

		public String toString() {

			StringBuilder sb = new StringBuilder();
			sb.append(super.toString());
			sb.append("[");
			sb.append("tconst=" + tconst);
			sb.append(",writers=" + writers);
			sb.append("]");

			return sb.toString();
		}

		public String toLogString() {
			StringBuilder sb = new StringBuilder();

			if (tconst == null) {
				sb.append("<null>");
			} else {
				sb.append(tconst);
			}

			sb.append("|");

			if (writers == null) {
				sb.append("<null>");
			} else {
				sb.append(writers);
			}

			sb.append("|");

			return sb.toString();
		}

		/**
		 * Compare keys
		 */
		public int compareTo(row8Struct other) {

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
		org.slf4j.MDC.put("_subJobPid", "FkVNcL_" + subJobPidCounter.getAndIncrement());

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

				tDBInput_7Process(globalMap);
				tDBInput_8Process(globalMap);
				tDBInput_9Process(globalMap);

				row6Struct row6 = new row6Struct();
				row7Struct row7 = new row7Struct();
				toDirectorStruct toDirector = new toDirectorStruct();

				row8Struct row8 = new row8Struct();
				row9Struct row9 = new row9Struct();
				copyOftoDirectorStruct copyOftoDirector = new copyOftoDirectorStruct();

				row10Struct row10 = new row10Struct();
				toTable1Struct toTable1 = new toTable1Struct();

				/**
				 * [tDBOutput_2 begin ] start
				 */

				ok_Hash.put("tDBOutput_2", false);
				start_Hash.put("tDBOutput_2", System.currentTimeMillis());

				currentComponent = "tDBOutput_2";

				cLabel = "\"bridge_crew_movie\"";

				runStat.updateStatAndLog(execStat, enableLogStash, resourceMap, iterateId, 0, 0, "toTable1");

				int tos_count_tDBOutput_2 = 0;

				if (log.isDebugEnabled())
					log.debug("tDBOutput_2 - " + ("Start to work."));
				if (log.isDebugEnabled()) {
					class BytesLimit65535_tDBOutput_2 {
						public void limitLog4jByte() throws Exception {
							StringBuilder log4jParamters_tDBOutput_2 = new StringBuilder();
							log4jParamters_tDBOutput_2.append("Parameters:");
							log4jParamters_tDBOutput_2.append("DB_VERSION" + " = " + "MYSQL_8");
							log4jParamters_tDBOutput_2.append(" | ");
							log4jParamters_tDBOutput_2.append("USE_EXISTING_CONNECTION" + " = " + "false");
							log4jParamters_tDBOutput_2.append(" | ");
							log4jParamters_tDBOutput_2.append("HOST" + " = " + "\"127.0.0.1\"");
							log4jParamters_tDBOutput_2.append(" | ");
							log4jParamters_tDBOutput_2.append("PORT" + " = " + "\"3306\"");
							log4jParamters_tDBOutput_2.append(" | ");
							log4jParamters_tDBOutput_2.append("DBNAME" + " = " + "\"imdb_src\"");
							log4jParamters_tDBOutput_2.append(" | ");
							log4jParamters_tDBOutput_2.append("USER" + " = " + "\"user2\"");
							log4jParamters_tDBOutput_2.append(" | ");
							log4jParamters_tDBOutput_2.append("PASS" + " = " + String.valueOf(
									"enc:routine.encryption.key.v1:xTcDpuICzCxMm6LhJqCtqO7ctq98YTYNKrwxmHYzACzVsdcm")
									.substring(0, 4) + "...");
							log4jParamters_tDBOutput_2.append(" | ");
							log4jParamters_tDBOutput_2.append("TABLE" + " = " + "\"bridge_crew_movie\"");
							log4jParamters_tDBOutput_2.append(" | ");
							log4jParamters_tDBOutput_2.append("TABLE_ACTION" + " = " + "CREATE_IF_NOT_EXISTS");
							log4jParamters_tDBOutput_2.append(" | ");
							log4jParamters_tDBOutput_2.append("DATA_ACTION" + " = " + "INSERT_OR_UPDATE");
							log4jParamters_tDBOutput_2.append(" | ");
							log4jParamters_tDBOutput_2.append("SPECIFY_DATASOURCE_ALIAS" + " = " + "false");
							log4jParamters_tDBOutput_2.append(" | ");
							log4jParamters_tDBOutput_2.append("DIE_ON_ERROR" + " = " + "false");
							log4jParamters_tDBOutput_2.append(" | ");
							log4jParamters_tDBOutput_2.append("PROPERTIES" + " = "
									+ "\"noDatetimeStringSync=true&enabledTLSProtocols=TLSv1.2,TLSv1.1,TLSv1\"");
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
							log4jParamters_tDBOutput_2.append("SUPPORT_NULL_WHERE" + " = " + "false");
							log4jParamters_tDBOutput_2.append(" | ");
							log4jParamters_tDBOutput_2.append("UNIFIED_COMPONENTS" + " = " + "tMysqlOutput");
							log4jParamters_tDBOutput_2.append(" | ");
							if (log.isDebugEnabled())
								log.debug("tDBOutput_2 - " + (log4jParamters_tDBOutput_2));
						}
					}
					new BytesLimit65535_tDBOutput_2().limitLog4jByte();
				}
				if (enableLogStash) {
					talendJobLog.addCM("tDBOutput_2", "\"bridge_crew_movie\"", "tMysqlOutput");
					talendJobLogProcess(globalMap);
				}

				int updateKeyCount_tDBOutput_2 = 3;
				if (updateKeyCount_tDBOutput_2 < 1) {
					throw new RuntimeException("For update, Schema must have a key");
				} else if (updateKeyCount_tDBOutput_2 == 5 && true) {
					log.warn("For update, every Schema column can not be a key");
				}

				int nb_line_tDBOutput_2 = 0;
				int nb_line_update_tDBOutput_2 = 0;
				int nb_line_inserted_tDBOutput_2 = 0;
				int nb_line_deleted_tDBOutput_2 = 0;
				int nb_line_rejected_tDBOutput_2 = 0;

				int deletedCount_tDBOutput_2 = 0;
				int updatedCount_tDBOutput_2 = 0;
				int insertedCount_tDBOutput_2 = 0;
				int rowsToCommitCount_tDBOutput_2 = 0;
				int rejectedCount_tDBOutput_2 = 0;

				String tableName_tDBOutput_2 = "bridge_crew_movie";
				boolean whetherReject_tDBOutput_2 = false;

				java.util.Calendar calendar_tDBOutput_2 = java.util.Calendar.getInstance();
				calendar_tDBOutput_2.set(1, 0, 1, 0, 0, 0);
				long year1_tDBOutput_2 = calendar_tDBOutput_2.getTime().getTime();
				calendar_tDBOutput_2.set(10000, 0, 1, 0, 0, 0);
				long year10000_tDBOutput_2 = calendar_tDBOutput_2.getTime().getTime();
				long date_tDBOutput_2;

				java.sql.Connection conn_tDBOutput_2 = null;

				String properties_tDBOutput_2 = "noDatetimeStringSync=true&enabledTLSProtocols=TLSv1.2,TLSv1.1,TLSv1";
				if (properties_tDBOutput_2 == null || properties_tDBOutput_2.trim().length() == 0) {
					properties_tDBOutput_2 = "rewriteBatchedStatements=true&allowLoadLocalInfile=true";
				} else {
					if (!properties_tDBOutput_2.contains("rewriteBatchedStatements=")) {
						properties_tDBOutput_2 += "&rewriteBatchedStatements=true";
					}

					if (!properties_tDBOutput_2.contains("allowLoadLocalInfile=")) {
						properties_tDBOutput_2 += "&allowLoadLocalInfile=true";
					}
				}

				String url_tDBOutput_2 = "jdbc:mysql://" + "127.0.0.1" + ":" + "3306" + "/" + "imdb_src" + "?"
						+ properties_tDBOutput_2;

				String driverClass_tDBOutput_2 = "com.mysql.cj.jdbc.Driver";

				if (log.isDebugEnabled())
					log.debug("tDBOutput_2 - " + ("Driver ClassName: ") + (driverClass_tDBOutput_2) + ("."));
				String dbUser_tDBOutput_2 = "user2";

				final String decryptedPassword_tDBOutput_2 = routines.system.PasswordEncryptUtil.decryptPassword(
						"enc:routine.encryption.key.v1:I9tRnl8ydhKeSXIUW087Bn0a1F1hJKvGWo1rdN64lhbmq/lM");

				String dbPwd_tDBOutput_2 = decryptedPassword_tDBOutput_2;
				java.lang.Class.forName(driverClass_tDBOutput_2);

				if (log.isDebugEnabled())
					log.debug("tDBOutput_2 - " + ("Connection attempts to '") + (url_tDBOutput_2)
							+ ("' with the username '") + (dbUser_tDBOutput_2) + ("'."));
				conn_tDBOutput_2 = java.sql.DriverManager.getConnection(url_tDBOutput_2, dbUser_tDBOutput_2,
						dbPwd_tDBOutput_2);

				if (log.isDebugEnabled())
					log.debug("tDBOutput_2 - " + ("Connection to '") + (url_tDBOutput_2) + ("' has succeeded."));

				resourceMap.put("conn_tDBOutput_2", conn_tDBOutput_2);

				conn_tDBOutput_2.setAutoCommit(false);
				int commitEvery_tDBOutput_2 = 10000;
				int commitCounter_tDBOutput_2 = 0;

				if (log.isDebugEnabled())
					log.debug("tDBOutput_2 - " + ("Connection is set auto commit to '")
							+ (conn_tDBOutput_2.getAutoCommit()) + ("'."));

				int count_tDBOutput_2 = 0;

				java.sql.DatabaseMetaData dbMetaData_tDBOutput_2 = conn_tDBOutput_2.getMetaData();
				java.sql.ResultSet rsTable_tDBOutput_2 = dbMetaData_tDBOutput_2.getTables("imdb_src", null, null,
						new String[] { "TABLE" });
				boolean whetherExist_tDBOutput_2 = false;
				while (rsTable_tDBOutput_2.next()) {
					String table_tDBOutput_2 = rsTable_tDBOutput_2.getString("TABLE_NAME");
					if (table_tDBOutput_2.equalsIgnoreCase("bridge_crew_movie")) {
						whetherExist_tDBOutput_2 = true;
						break;
					}
				}
				if (!whetherExist_tDBOutput_2) {
					try (java.sql.Statement stmtCreate_tDBOutput_2 = conn_tDBOutput_2.createStatement()) {
						if (log.isDebugEnabled())
							log.debug(
									"tDBOutput_2 - " + ("Creating") + (" table '") + (tableName_tDBOutput_2) + ("'."));
						stmtCreate_tDBOutput_2.execute("CREATE TABLE `" + tableName_tDBOutput_2
								+ "`(`Movie_ID` INT(0)   not null ,`Crew_SK` INT(0)   not null ,`Profession_SK` INT(0)   not null ,`DI_CreatedDate` DATETIME  not null ,`DI_WorkflowJobId` VARCHAR(8)   not null ,primary key(`Movie_ID`,`Crew_SK`,`Profession_SK`))");
						if (log.isDebugEnabled())
							log.debug("tDBOutput_2 - " + ("Create") + (" table '") + (tableName_tDBOutput_2)
									+ ("' has succeeded."));
					}
				}

				java.sql.PreparedStatement pstmt_tDBOutput_2 = conn_tDBOutput_2
						.prepareStatement("SELECT COUNT(1) FROM `" + "bridge_crew_movie"
								+ "` WHERE `Movie_ID` = ? AND `Crew_SK` = ? AND `Profession_SK` = ?");
				resourceMap.put("pstmt_tDBOutput_2", pstmt_tDBOutput_2);
				String insert_tDBOutput_2 = "INSERT INTO `" + "bridge_crew_movie"
						+ "` (`Movie_ID`,`Crew_SK`,`Profession_SK`,`DI_CreatedDate`,`DI_WorkflowJobId`) VALUES (?,?,?,?,?)";

				java.sql.PreparedStatement pstmtInsert_tDBOutput_2 = conn_tDBOutput_2
						.prepareStatement(insert_tDBOutput_2);
				resourceMap.put("pstmtInsert_tDBOutput_2", pstmtInsert_tDBOutput_2);
				String update_tDBOutput_2 = "UPDATE `" + "bridge_crew_movie"
						+ "` SET `DI_CreatedDate` = ?,`DI_WorkflowJobId` = ? WHERE `Movie_ID` = ? AND `Crew_SK` = ? AND `Profession_SK` = ?";

				java.sql.PreparedStatement pstmtUpdate_tDBOutput_2 = conn_tDBOutput_2
						.prepareStatement(update_tDBOutput_2);
				resourceMap.put("pstmtUpdate_tDBOutput_2", pstmtUpdate_tDBOutput_2);

				/**
				 * [tDBOutput_2 begin ] stop
				 */

				/**
				 * [tMap_4 begin ] start
				 */

				ok_Hash.put("tMap_4", false);
				start_Hash.put("tMap_4", System.currentTimeMillis());

				currentComponent = "tMap_4";

				runStat.updateStatAndLog(execStat, enableLogStash, resourceMap, iterateId, 0, 0, "row10");

				int tos_count_tMap_4 = 0;

				if (log.isDebugEnabled())
					log.debug("tMap_4 - " + ("Start to work."));
				if (log.isDebugEnabled()) {
					class BytesLimit65535_tMap_4 {
						public void limitLog4jByte() throws Exception {
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
							if (log.isDebugEnabled())
								log.debug("tMap_4 - " + (log4jParamters_tMap_4));
						}
					}
					new BytesLimit65535_tMap_4().limitLog4jByte();
				}
				if (enableLogStash) {
					talendJobLog.addCM("tMap_4", "tMap_4", "tMap");
					talendJobLogProcess(globalMap);
				}

// ###############################
// # Lookup's keys initialization
				int count_row10_tMap_4 = 0;

				int count_row11_tMap_4 = 0;

				int count_row12_tMap_4 = 0;

				int count_row13_tMap_4 = 0;

				org.talend.designer.components.lookup.memory.AdvancedMemoryLookup<row11Struct> tHash_Lookup_row11 = (org.talend.designer.components.lookup.memory.AdvancedMemoryLookup<row11Struct>) ((org.talend.designer.components.lookup.memory.AdvancedMemoryLookup<row11Struct>) globalMap
						.get("tHash_Lookup_row11"));

				row11Struct row11HashKey = new row11Struct();
				row11Struct row11Default = new row11Struct();

				org.talend.designer.components.lookup.memory.AdvancedMemoryLookup<row12Struct> tHash_Lookup_row12 = (org.talend.designer.components.lookup.memory.AdvancedMemoryLookup<row12Struct>) ((org.talend.designer.components.lookup.memory.AdvancedMemoryLookup<row12Struct>) globalMap
						.get("tHash_Lookup_row12"));

				row12Struct row12HashKey = new row12Struct();
				row12Struct row12Default = new row12Struct();

				org.talend.designer.components.lookup.memory.AdvancedMemoryLookup<row13Struct> tHash_Lookup_row13 = (org.talend.designer.components.lookup.memory.AdvancedMemoryLookup<row13Struct>) ((org.talend.designer.components.lookup.memory.AdvancedMemoryLookup<row13Struct>) globalMap
						.get("tHash_Lookup_row13"));

				row13Struct row13HashKey = new row13Struct();
				row13Struct row13Default = new row13Struct();
// ###############################        

// ###############################
// # Vars initialization
				class Var__tMap_4__Struct {
				}
				Var__tMap_4__Struct Var__tMap_4 = new Var__tMap_4__Struct();
// ###############################

// ###############################
// # Outputs initialization
				int count_toTable1_tMap_4 = 0;

				toTable1Struct toTable1_tmp = new toTable1Struct();
// ###############################

				/**
				 * [tMap_4 begin ] stop
				 */

				/**
				 * [tUnite_1 begin ] start
				 */

				ok_Hash.put("tUnite_1", false);
				start_Hash.put("tUnite_1", System.currentTimeMillis());

				currentComponent = "tUnite_1";

				runStat.updateStatAndLog(execStat, enableLogStash, resourceMap, iterateId, 0, 0, "copyOftoDirector",
						"toDirector");

				int tos_count_tUnite_1 = 0;

				if (log.isDebugEnabled())
					log.debug("tUnite_1 - " + ("Start to work."));
				if (log.isDebugEnabled()) {
					class BytesLimit65535_tUnite_1 {
						public void limitLog4jByte() throws Exception {
							StringBuilder log4jParamters_tUnite_1 = new StringBuilder();
							log4jParamters_tUnite_1.append("Parameters:");
							if (log.isDebugEnabled())
								log.debug("tUnite_1 - " + (log4jParamters_tUnite_1));
						}
					}
					new BytesLimit65535_tUnite_1().limitLog4jByte();
				}
				if (enableLogStash) {
					talendJobLog.addCM("tUnite_1", "tUnite_1", "tUnite");
					talendJobLogProcess(globalMap);
				}

				int nb_line_tUnite_1 = 0;

				/**
				 * [tUnite_1 begin ] stop
				 */

				/**
				 * [tMap_2 begin ] start
				 */

				ok_Hash.put("tMap_2", false);
				start_Hash.put("tMap_2", System.currentTimeMillis());

				currentComponent = "tMap_2";

				runStat.updateStatAndLog(execStat, enableLogStash, resourceMap, iterateId, 0, 0, "row7");

				int tos_count_tMap_2 = 0;

				if (log.isDebugEnabled())
					log.debug("tMap_2 - " + ("Start to work."));
				if (log.isDebugEnabled()) {
					class BytesLimit65535_tMap_2 {
						public void limitLog4jByte() throws Exception {
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
							if (log.isDebugEnabled())
								log.debug("tMap_2 - " + (log4jParamters_tMap_2));
						}
					}
					new BytesLimit65535_tMap_2().limitLog4jByte();
				}
				if (enableLogStash) {
					talendJobLog.addCM("tMap_2", "tMap_2", "tMap");
					talendJobLogProcess(globalMap);
				}

// ###############################
// # Lookup's keys initialization
				int count_row7_tMap_2 = 0;

// ###############################        

// ###############################
// # Vars initialization
				class Var__tMap_2__Struct {
				}
				Var__tMap_2__Struct Var__tMap_2 = new Var__tMap_2__Struct();
// ###############################

// ###############################
// # Outputs initialization
				int count_toDirector_tMap_2 = 0;

				toDirectorStruct toDirector_tmp = new toDirectorStruct();
// ###############################

				/**
				 * [tMap_2 begin ] stop
				 */

				/**
				 * [tNormalize_1 begin ] start
				 */

				ok_Hash.put("tNormalize_1", false);
				start_Hash.put("tNormalize_1", System.currentTimeMillis());

				currentComponent = "tNormalize_1";

				runStat.updateStatAndLog(execStat, enableLogStash, resourceMap, iterateId, 0, 0, "row6");

				int tos_count_tNormalize_1 = 0;

				if (log.isDebugEnabled())
					log.debug("tNormalize_1 - " + ("Start to work."));
				if (log.isDebugEnabled()) {
					class BytesLimit65535_tNormalize_1 {
						public void limitLog4jByte() throws Exception {
							StringBuilder log4jParamters_tNormalize_1 = new StringBuilder();
							log4jParamters_tNormalize_1.append("Parameters:");
							log4jParamters_tNormalize_1.append("NORMALIZE_COLUMN" + " = " + "directors");
							log4jParamters_tNormalize_1.append(" | ");
							log4jParamters_tNormalize_1.append("ITEMSEPARATOR" + " = " + "\",\"");
							log4jParamters_tNormalize_1.append(" | ");
							log4jParamters_tNormalize_1.append("DEDUPLICATE" + " = " + "false");
							log4jParamters_tNormalize_1.append(" | ");
							log4jParamters_tNormalize_1.append("CSV_OPTION" + " = " + "false");
							log4jParamters_tNormalize_1.append(" | ");
							log4jParamters_tNormalize_1.append("DISCARD_TRAILING_EMPTY_STR" + " = " + "false");
							log4jParamters_tNormalize_1.append(" | ");
							log4jParamters_tNormalize_1.append("TRIM" + " = " + "false");
							log4jParamters_tNormalize_1.append(" | ");
							if (log.isDebugEnabled())
								log.debug("tNormalize_1 - " + (log4jParamters_tNormalize_1));
						}
					}
					new BytesLimit65535_tNormalize_1().limitLog4jByte();
				}
				if (enableLogStash) {
					talendJobLog.addCM("tNormalize_1", "tNormalize_1", "tNormalize");
					talendJobLogProcess(globalMap);
				}

				int lastNoEmptyIndex_tNormalize_1 = 0;
				int nb_line_tNormalize_1 = 0;
				String tmp_tNormalize_1 = null;
				StringBuilder currentRecord_tNormalize_1 = null;
				String[] normalizeRecord_tNormalize_1 = null;
				java.util.Set<String> recordSet_tNormalize_1 = new java.util.HashSet<String>();

				if (((String) ",").length() == 0) {
					throw new IllegalArgumentException("Field Separator must be assigned a char.");
				}

				/**
				 * [tNormalize_1 begin ] stop
				 */

				/**
				 * [tDBInput_2 begin ] start
				 */

				ok_Hash.put("tDBInput_2", false);
				start_Hash.put("tDBInput_2", System.currentTimeMillis());

				currentComponent = "tDBInput_2";

				cLabel = "\"stg_crew_dir\"";

				int tos_count_tDBInput_2 = 0;

				if (log.isDebugEnabled())
					log.debug("tDBInput_2 - " + ("Start to work."));
				if (log.isDebugEnabled()) {
					class BytesLimit65535_tDBInput_2 {
						public void limitLog4jByte() throws Exception {
							StringBuilder log4jParamters_tDBInput_2 = new StringBuilder();
							log4jParamters_tDBInput_2.append("Parameters:");
							log4jParamters_tDBInput_2.append("DB_VERSION" + " = " + "MYSQL_8");
							log4jParamters_tDBInput_2.append(" | ");
							log4jParamters_tDBInput_2.append("USE_EXISTING_CONNECTION" + " = " + "false");
							log4jParamters_tDBInput_2.append(" | ");
							log4jParamters_tDBInput_2.append("HOST" + " = " + "\"127.0.0.1\"");
							log4jParamters_tDBInput_2.append(" | ");
							log4jParamters_tDBInput_2.append("PORT" + " = " + "\"3306\"");
							log4jParamters_tDBInput_2.append(" | ");
							log4jParamters_tDBInput_2.append("DBNAME" + " = " + "\"imdb_src\"");
							log4jParamters_tDBInput_2.append(" | ");
							log4jParamters_tDBInput_2.append("USER" + " = " + "\"user2\"");
							log4jParamters_tDBInput_2.append(" | ");
							log4jParamters_tDBInput_2.append("PASS" + " = " + String.valueOf(
									"enc:routine.encryption.key.v1:YNGNxqpOzB5NZmg/AJxl5HEcvLnaiFlyIuNlI1XbIaEeYi6G")
									.substring(0, 4) + "...");
							log4jParamters_tDBInput_2.append(" | ");
							log4jParamters_tDBInput_2.append("TABLE" + " = " + "\"stg_crew_dir\"");
							log4jParamters_tDBInput_2.append(" | ");
							log4jParamters_tDBInput_2.append("QUERYSTORE" + " = " + "\"\"");
							log4jParamters_tDBInput_2.append(" | ");
							log4jParamters_tDBInput_2.append("QUERY" + " = "
									+ "\"SELECT    `stg_crew_dir`.`tconst`,    `stg_crew_dir`.`directors` FROM `stg_crew_dir`\"");
							log4jParamters_tDBInput_2.append(" | ");
							log4jParamters_tDBInput_2.append("SPECIFY_DATASOURCE_ALIAS" + " = " + "false");
							log4jParamters_tDBInput_2.append(" | ");
							log4jParamters_tDBInput_2.append("PROPERTIES" + " = "
									+ "\"noDatetimeStringSync=true&enabledTLSProtocols=TLSv1.2,TLSv1.1,TLSv1\"");
							log4jParamters_tDBInput_2.append(" | ");
							log4jParamters_tDBInput_2.append("ENABLE_STREAM" + " = " + "false");
							log4jParamters_tDBInput_2.append(" | ");
							log4jParamters_tDBInput_2.append("TRIM_ALL_COLUMN" + " = " + "false");
							log4jParamters_tDBInput_2.append(" | ");
							log4jParamters_tDBInput_2.append(
									"TRIM_COLUMN" + " = " + "[{TRIM=" + ("false") + ", SCHEMA_COLUMN=" + ("tconst")
											+ "}, {TRIM=" + ("false") + ", SCHEMA_COLUMN=" + ("directors") + "}]");
							log4jParamters_tDBInput_2.append(" | ");
							log4jParamters_tDBInput_2.append("UNIFIED_COMPONENTS" + " = " + "tMysqlInput");
							log4jParamters_tDBInput_2.append(" | ");
							if (log.isDebugEnabled())
								log.debug("tDBInput_2 - " + (log4jParamters_tDBInput_2));
						}
					}
					new BytesLimit65535_tDBInput_2().limitLog4jByte();
				}
				if (enableLogStash) {
					talendJobLog.addCM("tDBInput_2", "\"stg_crew_dir\"", "tMysqlInput");
					talendJobLogProcess(globalMap);
				}

				java.util.Calendar calendar_tDBInput_2 = java.util.Calendar.getInstance();
				calendar_tDBInput_2.set(0, 0, 0, 0, 0, 0);
				java.util.Date year0_tDBInput_2 = calendar_tDBInput_2.getTime();
				int nb_line_tDBInput_2 = 0;
				java.sql.Connection conn_tDBInput_2 = null;
				String driverClass_tDBInput_2 = "com.mysql.cj.jdbc.Driver";
				java.lang.Class jdbcclazz_tDBInput_2 = java.lang.Class.forName(driverClass_tDBInput_2);
				String dbUser_tDBInput_2 = "user2";

				final String decryptedPassword_tDBInput_2 = routines.system.PasswordEncryptUtil.decryptPassword(
						"enc:routine.encryption.key.v1:rWNDC5tiAdh9eI0QP9Iby1wCokBdspkujtW8OVAUyUbde3Y1");

				String dbPwd_tDBInput_2 = decryptedPassword_tDBInput_2;

				String properties_tDBInput_2 = "noDatetimeStringSync=true&enabledTLSProtocols=TLSv1.2,TLSv1.1,TLSv1";
				if (properties_tDBInput_2 == null || properties_tDBInput_2.trim().length() == 0) {
					properties_tDBInput_2 = "";
				}
				String url_tDBInput_2 = "jdbc:mysql://" + "127.0.0.1" + ":" + "3306" + "/" + "imdb_src" + "?"
						+ properties_tDBInput_2;

				log.debug("tDBInput_2 - Driver ClassName: " + driverClass_tDBInput_2 + ".");

				log.debug("tDBInput_2 - Connection attempt to '" + url_tDBInput_2 + "' with the username '"
						+ dbUser_tDBInput_2 + "'.");

				conn_tDBInput_2 = java.sql.DriverManager.getConnection(url_tDBInput_2, dbUser_tDBInput_2,
						dbPwd_tDBInput_2);
				log.debug("tDBInput_2 - Connection to '" + url_tDBInput_2 + "' has succeeded.");

				java.sql.Statement stmt_tDBInput_2 = conn_tDBInput_2.createStatement();

				String dbquery_tDBInput_2 = "SELECT \n  `stg_crew_dir`.`tconst`, \n  `stg_crew_dir`.`directors`\nFROM `stg_crew_dir`";

				log.debug("tDBInput_2 - Executing the query: '" + dbquery_tDBInput_2 + "'.");

				globalMap.put("tDBInput_2_QUERY", dbquery_tDBInput_2);

				java.sql.ResultSet rs_tDBInput_2 = null;

				try {
					rs_tDBInput_2 = stmt_tDBInput_2.executeQuery(dbquery_tDBInput_2);
					java.sql.ResultSetMetaData rsmd_tDBInput_2 = rs_tDBInput_2.getMetaData();
					int colQtyInRs_tDBInput_2 = rsmd_tDBInput_2.getColumnCount();

					String tmpContent_tDBInput_2 = null;

					log.debug("tDBInput_2 - Retrieving records from the database.");

					while (rs_tDBInput_2.next()) {
						nb_line_tDBInput_2++;

						if (colQtyInRs_tDBInput_2 < 1) {
							row6.tconst = null;
						} else {

							row6.tconst = routines.system.JDBCUtil.getString(rs_tDBInput_2, 1, false);
						}
						if (colQtyInRs_tDBInput_2 < 2) {
							row6.directors = null;
						} else {

							row6.directors = routines.system.JDBCUtil.getString(rs_tDBInput_2, 2, false);
						}

						log.debug("tDBInput_2 - Retrieving the record " + nb_line_tDBInput_2 + ".");

						/**
						 * [tDBInput_2 begin ] stop
						 */

						/**
						 * [tDBInput_2 main ] start
						 */

						currentComponent = "tDBInput_2";

						cLabel = "\"stg_crew_dir\"";

						tos_count_tDBInput_2++;

						/**
						 * [tDBInput_2 main ] stop
						 */

						/**
						 * [tDBInput_2 process_data_begin ] start
						 */

						currentComponent = "tDBInput_2";

						cLabel = "\"stg_crew_dir\"";

						/**
						 * [tDBInput_2 process_data_begin ] stop
						 */

						/**
						 * [tNormalize_1 main ] start
						 */

						currentComponent = "tNormalize_1";

						if (runStat.update(execStat, enableLogStash, iterateId, 1, 1

								, "row6", "tDBInput_2", "\"stg_crew_dir\"", "tMysqlInput", "tNormalize_1",
								"tNormalize_1", "tNormalize"

						)) {
							talendJobLogProcess(globalMap);
						}

						if (log.isTraceEnabled()) {
							log.trace("row6 - " + (row6 == null ? "" : row6.toLogString()));
						}

						normalizeRecord_tNormalize_1 = new String[1];
						if (row6.directors != null) {
							if ("".equals(row6.directors)) {
								normalizeRecord_tNormalize_1[0] = "";
							} else {

								normalizeRecord_tNormalize_1 = row6.directors.split(",", -1);

							}
						}
						lastNoEmptyIndex_tNormalize_1 = normalizeRecord_tNormalize_1.length;

						for (int i_tNormalize_1 = 0; i_tNormalize_1 < lastNoEmptyIndex_tNormalize_1; i_tNormalize_1++) {

							currentRecord_tNormalize_1 = new StringBuilder();
							nb_line_tNormalize_1++;

							row7.tconst = row6.tconst;

							row7.directors = normalizeRecord_tNormalize_1[i_tNormalize_1];

							tos_count_tNormalize_1++;

							/**
							 * [tNormalize_1 main ] stop
							 */

							/**
							 * [tNormalize_1 process_data_begin ] start
							 */

							currentComponent = "tNormalize_1";

							/**
							 * [tNormalize_1 process_data_begin ] stop
							 */

							/**
							 * [tMap_2 main ] start
							 */

							currentComponent = "tMap_2";

							if (runStat.update(execStat, enableLogStash, iterateId, 1, 1

									, "row7", "tNormalize_1", "tNormalize_1", "tNormalize", "tMap_2", "tMap_2", "tMap"

							)) {
								talendJobLogProcess(globalMap);
							}

							if (log.isTraceEnabled()) {
								log.trace("row7 - " + (row7 == null ? "" : row7.toLogString()));
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

								toDirector = null;

// # Output table : 'toDirector'
								count_toDirector_tMap_2++;

								toDirector_tmp.tconst = row7.tconst;
								toDirector_tmp.category = "director";
								toDirector_tmp.nconst = row7.directors;
								toDirector = toDirector_tmp;
								log.debug("tMap_2 - Outputting the record " + count_toDirector_tMap_2
										+ " of the output table 'toDirector'.");

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

							currentComponent = "tMap_2";

							/**
							 * [tMap_2 process_data_begin ] stop
							 */
// Start of branch "toDirector"
							if (toDirector != null) {

								/**
								 * [tUnite_1 main ] start
								 */

								currentComponent = "tUnite_1";

								if (runStat.update(execStat, enableLogStash, iterateId, 1, 1

										, "toDirector", "tMap_2", "tMap_2", "tMap", "tUnite_1", "tUnite_1", "tUnite"

								)) {
									talendJobLogProcess(globalMap);
								}

								if (log.isTraceEnabled()) {
									log.trace("copyOftoDirector - "
											+ (copyOftoDirector == null ? "" : copyOftoDirector.toLogString()));
								}

								if (log.isTraceEnabled()) {
									log.trace("toDirector - " + (toDirector == null ? "" : toDirector.toLogString()));
								}

//////////

// for output
								row10 = new row10Struct();

								row10.tconst = toDirector.tconst;
								row10.category = toDirector.category;
								row10.nconst = toDirector.nconst;

								nb_line_tUnite_1++;

//////////

								tos_count_tUnite_1++;

								/**
								 * [tUnite_1 main ] stop
								 */

								/**
								 * [tUnite_1 process_data_begin ] start
								 */

								currentComponent = "tUnite_1";

								/**
								 * [tUnite_1 process_data_begin ] stop
								 */

								/**
								 * [tMap_4 main ] start
								 */

								currentComponent = "tMap_4";

								if (runStat.update(execStat, enableLogStash, iterateId, 1, 1

										, "row10", "tUnite_1", "tUnite_1", "tUnite", "tMap_4", "tMap_4", "tMap"

								)) {
									talendJobLogProcess(globalMap);
								}

								if (log.isTraceEnabled()) {
									log.trace("row10 - " + (row10 == null ? "" : row10.toLogString()));
								}

								boolean hasCasePrimitiveKeyWithNull_tMap_4 = false;

								row11Struct row11 = null;

								row12Struct row12 = null;

								row13Struct row13 = null;

								// ###############################
								// # Input tables (lookups)

								boolean rejectedInnerJoin_tMap_4 = false;
								boolean mainRowRejected_tMap_4 = false;

								///////////////////////////////////////////////
								// Starting Lookup Table "row11"
								///////////////////////////////////////////////

								boolean forceLooprow11 = false;

								row11Struct row11ObjectFromLookup = null;

								if (!rejectedInnerJoin_tMap_4) { // G_TM_M_020

									hasCasePrimitiveKeyWithNull_tMap_4 = false;

									row11HashKey.nmconst = row10.nconst;

									row11HashKey.hashCodeDirty = true;

									tHash_Lookup_row11.lookup(row11HashKey);

								} // G_TM_M_020

								if (tHash_Lookup_row11 != null && tHash_Lookup_row11.getCount(row11HashKey) > 1) { // G
																													// 071

									// System.out.println("WARNING: UNIQUE MATCH is configured for the lookup
									// 'row11' and it contains more one result from keys : row11.nmconst = '" +
									// row11HashKey.nmconst + "'");
								} // G 071

								row11Struct fromLookup_row11 = null;
								row11 = row11Default;

								if (tHash_Lookup_row11 != null && tHash_Lookup_row11.hasNext()) { // G 099

									fromLookup_row11 = tHash_Lookup_row11.next();

								} // G 099

								if (fromLookup_row11 != null) {
									row11 = fromLookup_row11;
								}

								///////////////////////////////////////////////
								// Starting Lookup Table "row12"
								///////////////////////////////////////////////

								boolean forceLooprow12 = false;

								row12Struct row12ObjectFromLookup = null;

								if (!rejectedInnerJoin_tMap_4) { // G_TM_M_020

									hasCasePrimitiveKeyWithNull_tMap_4 = false;

									row12HashKey.Name = row10.category;

									row12HashKey.hashCodeDirty = true;

									tHash_Lookup_row12.lookup(row12HashKey);

								} // G_TM_M_020

								if (tHash_Lookup_row12 != null && tHash_Lookup_row12.getCount(row12HashKey) > 1) { // G
																													// 071

									// System.out.println("WARNING: UNIQUE MATCH is configured for the lookup
									// 'row12' and it contains more one result from keys : row12.Name = '" +
									// row12HashKey.Name + "'");
								} // G 071

								row12Struct fromLookup_row12 = null;
								row12 = row12Default;

								if (tHash_Lookup_row12 != null && tHash_Lookup_row12.hasNext()) { // G 099

									fromLookup_row12 = tHash_Lookup_row12.next();

								} // G 099

								if (fromLookup_row12 != null) {
									row12 = fromLookup_row12;
								}

								///////////////////////////////////////////////
								// Starting Lookup Table "row13"
								///////////////////////////////////////////////

								boolean forceLooprow13 = false;

								row13Struct row13ObjectFromLookup = null;

								if (!rejectedInnerJoin_tMap_4) { // G_TM_M_020

									hasCasePrimitiveKeyWithNull_tMap_4 = false;

									row13HashKey.tconst = row10.tconst;

									row13HashKey.hashCodeDirty = true;

									tHash_Lookup_row13.lookup(row13HashKey);

								} // G_TM_M_020

								if (tHash_Lookup_row13 != null && tHash_Lookup_row13.getCount(row13HashKey) > 1) { // G
																													// 071

									// System.out.println("WARNING: UNIQUE MATCH is configured for the lookup
									// 'row13' and it contains more one result from keys : row13.tconst = '" +
									// row13HashKey.tconst + "'");
								} // G 071

								row13Struct fromLookup_row13 = null;
								row13 = row13Default;

								if (tHash_Lookup_row13 != null && tHash_Lookup_row13.hasNext()) { // G 099

									fromLookup_row13 = tHash_Lookup_row13.next();

								} // G 099

								if (fromLookup_row13 != null) {
									row13 = fromLookup_row13;
								}

								// ###############################
								{ // start of Var scope

									// ###############################
									// # Vars tables

									Var__tMap_4__Struct Var = Var__tMap_4;// ###############################
									// ###############################
									// # Output tables

									toTable1 = null;

// # Output table : 'toTable1'
									count_toTable1_tMap_4++;

									toTable1_tmp.Movie_ID = row13.Movie_ID;
									toTable1_tmp.Crew_SK = row11.Crew_SK;
									toTable1_tmp.Profession_SK = row12.Profession_SK;
									toTable1_tmp.DI_CreatedDate = TalendDate.getCurrentDate();
									toTable1_tmp.DI_WorkflowJobId = pid;
									toTable1 = toTable1_tmp;
									log.debug("tMap_4 - Outputting the record " + count_toTable1_tMap_4
											+ " of the output table 'toTable1'.");

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

								currentComponent = "tMap_4";

								/**
								 * [tMap_4 process_data_begin ] stop
								 */
// Start of branch "toTable1"
								if (toTable1 != null) {

									/**
									 * [tDBOutput_2 main ] start
									 */

									currentComponent = "tDBOutput_2";

									cLabel = "\"bridge_crew_movie\"";

									if (runStat.update(execStat, enableLogStash, iterateId, 1, 1

											, "toTable1", "tMap_4", "tMap_4", "tMap", "tDBOutput_2",
											"\"bridge_crew_movie\"", "tMysqlOutput"

									)) {
										talendJobLogProcess(globalMap);
									}

									if (log.isTraceEnabled()) {
										log.trace("toTable1 - " + (toTable1 == null ? "" : toTable1.toLogString()));
									}

									whetherReject_tDBOutput_2 = false;
									pstmt_tDBOutput_2.setInt(1, toTable1.Movie_ID);

									pstmt_tDBOutput_2.setInt(2, toTable1.Crew_SK);

									pstmt_tDBOutput_2.setInt(3, toTable1.Profession_SK);

									int checkCount_tDBOutput_2 = -1;
									try (java.sql.ResultSet rs_tDBOutput_2 = pstmt_tDBOutput_2.executeQuery()) {
										while (rs_tDBOutput_2.next()) {
											checkCount_tDBOutput_2 = rs_tDBOutput_2.getInt(1);
										}
									}
									if (checkCount_tDBOutput_2 > 0) {
										if (toTable1.DI_CreatedDate != null) {
											date_tDBOutput_2 = toTable1.DI_CreatedDate.getTime();
											if (date_tDBOutput_2 < year1_tDBOutput_2
													|| date_tDBOutput_2 >= year10000_tDBOutput_2) {
												pstmtUpdate_tDBOutput_2.setString(1, "0000-00-00 00:00:00");
											} else {
												pstmtUpdate_tDBOutput_2.setTimestamp(1,
														new java.sql.Timestamp(date_tDBOutput_2));
											}
										} else {
											pstmtUpdate_tDBOutput_2.setNull(1, java.sql.Types.DATE);
										}

										if (toTable1.DI_WorkflowJobId == null) {
											pstmtUpdate_tDBOutput_2.setNull(2, java.sql.Types.VARCHAR);
										} else {
											pstmtUpdate_tDBOutput_2.setString(2, toTable1.DI_WorkflowJobId);
										}

										pstmtUpdate_tDBOutput_2.setInt(3 + count_tDBOutput_2, toTable1.Movie_ID);

										pstmtUpdate_tDBOutput_2.setInt(4 + count_tDBOutput_2, toTable1.Crew_SK);

										pstmtUpdate_tDBOutput_2.setInt(5 + count_tDBOutput_2, toTable1.Profession_SK);

										try {
											int processedCount_tDBOutput_2 = pstmtUpdate_tDBOutput_2.executeUpdate();
											updatedCount_tDBOutput_2 += processedCount_tDBOutput_2;
											rowsToCommitCount_tDBOutput_2 += processedCount_tDBOutput_2;
											nb_line_tDBOutput_2++;
											if (log.isDebugEnabled())
												log.debug("tDBOutput_2 - " + ("Updating") + (" the record ")
														+ (nb_line_tDBOutput_2) + ("."));
										} catch (java.lang.Exception e) {
											globalMap.put("tDBOutput_2_ERROR_MESSAGE", e.getMessage());
											whetherReject_tDBOutput_2 = true;
											nb_line_tDBOutput_2++;
											log.error("tDBOutput_2 - " + (e.getMessage()));
											System.err.print(e.getMessage());
										}
									} else {
										pstmtInsert_tDBOutput_2.setInt(1, toTable1.Movie_ID);

										pstmtInsert_tDBOutput_2.setInt(2, toTable1.Crew_SK);

										pstmtInsert_tDBOutput_2.setInt(3, toTable1.Profession_SK);

										if (toTable1.DI_CreatedDate != null) {
											date_tDBOutput_2 = toTable1.DI_CreatedDate.getTime();
											if (date_tDBOutput_2 < year1_tDBOutput_2
													|| date_tDBOutput_2 >= year10000_tDBOutput_2) {
												pstmtInsert_tDBOutput_2.setString(4, "0000-00-00 00:00:00");
											} else {
												pstmtInsert_tDBOutput_2.setTimestamp(4,
														new java.sql.Timestamp(date_tDBOutput_2));
											}
										} else {
											pstmtInsert_tDBOutput_2.setNull(4, java.sql.Types.DATE);
										}

										if (toTable1.DI_WorkflowJobId == null) {
											pstmtInsert_tDBOutput_2.setNull(5, java.sql.Types.VARCHAR);
										} else {
											pstmtInsert_tDBOutput_2.setString(5, toTable1.DI_WorkflowJobId);
										}

										try {
											int processedCount_tDBOutput_2 = pstmtInsert_tDBOutput_2.executeUpdate();
											insertedCount_tDBOutput_2 += processedCount_tDBOutput_2;
											rowsToCommitCount_tDBOutput_2 += processedCount_tDBOutput_2;
											nb_line_tDBOutput_2++;
											if (log.isDebugEnabled())
												log.debug("tDBOutput_2 - " + ("Inserting") + (" the record ")
														+ (nb_line_tDBOutput_2) + ("."));
										} catch (java.lang.Exception e) {
											globalMap.put("tDBOutput_2_ERROR_MESSAGE", e.getMessage());
											whetherReject_tDBOutput_2 = true;
											nb_line_tDBOutput_2++;
											log.error("tDBOutput_2 - " + (e.getMessage()));
											System.err.print(e.getMessage());
										}
									}
									commitCounter_tDBOutput_2++;

									if (commitEvery_tDBOutput_2 <= commitCounter_tDBOutput_2) {

										if (rowsToCommitCount_tDBOutput_2 != 0) {
											if (log.isDebugEnabled())
												log.debug("tDBOutput_2 - " + ("Connection starting to commit ")
														+ (rowsToCommitCount_tDBOutput_2) + (" record(s)."));
										}
										conn_tDBOutput_2.commit();
										if (rowsToCommitCount_tDBOutput_2 != 0) {
											if (log.isDebugEnabled())
												log.debug("tDBOutput_2 - " + ("Connection commit has succeeded."));
											rowsToCommitCount_tDBOutput_2 = 0;
										}
										commitCounter_tDBOutput_2 = 0;
									}

									tos_count_tDBOutput_2++;

									/**
									 * [tDBOutput_2 main ] stop
									 */

									/**
									 * [tDBOutput_2 process_data_begin ] start
									 */

									currentComponent = "tDBOutput_2";

									cLabel = "\"bridge_crew_movie\"";

									/**
									 * [tDBOutput_2 process_data_begin ] stop
									 */

									/**
									 * [tDBOutput_2 process_data_end ] start
									 */

									currentComponent = "tDBOutput_2";

									cLabel = "\"bridge_crew_movie\"";

									/**
									 * [tDBOutput_2 process_data_end ] stop
									 */

								} // End of branch "toTable1"

								/**
								 * [tMap_4 process_data_end ] start
								 */

								currentComponent = "tMap_4";

								/**
								 * [tMap_4 process_data_end ] stop
								 */

								/**
								 * [tUnite_1 process_data_end ] start
								 */

								currentComponent = "tUnite_1";

								/**
								 * [tUnite_1 process_data_end ] stop
								 */

							} // End of branch "toDirector"

							/**
							 * [tMap_2 process_data_end ] start
							 */

							currentComponent = "tMap_2";

							/**
							 * [tMap_2 process_data_end ] stop
							 */
							// end for
						}

						/**
						 * [tNormalize_1 process_data_end ] start
						 */

						currentComponent = "tNormalize_1";

						/**
						 * [tNormalize_1 process_data_end ] stop
						 */

						/**
						 * [tDBInput_2 process_data_end ] start
						 */

						currentComponent = "tDBInput_2";

						cLabel = "\"stg_crew_dir\"";

						/**
						 * [tDBInput_2 process_data_end ] stop
						 */

						/**
						 * [tDBInput_2 end ] start
						 */

						currentComponent = "tDBInput_2";

						cLabel = "\"stg_crew_dir\"";

					}
				} finally {
					if (rs_tDBInput_2 != null) {
						rs_tDBInput_2.close();
					}
					if (stmt_tDBInput_2 != null) {
						stmt_tDBInput_2.close();
					}
					if (conn_tDBInput_2 != null && !conn_tDBInput_2.isClosed()) {

						log.debug("tDBInput_2 - Closing the connection to the database.");

						conn_tDBInput_2.close();

						if ("com.mysql.cj.jdbc.Driver".equals((String) globalMap.get("driverClass_"))
								&& routines.system.BundleUtils.inOSGi()) {
							Class.forName("com.mysql.cj.jdbc.AbandonedConnectionCleanupThread")
									.getMethod("checkedShutdown").invoke(null, (Object[]) null);
						}

						log.debug("tDBInput_2 - Connection to the database closed.");

					}

				}
				globalMap.put("tDBInput_2_NB_LINE", nb_line_tDBInput_2);
				log.debug("tDBInput_2 - Retrieved records count: " + nb_line_tDBInput_2 + " .");

				if (log.isDebugEnabled())
					log.debug("tDBInput_2 - " + ("Done."));

				ok_Hash.put("tDBInput_2", true);
				end_Hash.put("tDBInput_2", System.currentTimeMillis());

				/**
				 * [tDBInput_2 end ] stop
				 */

				/**
				 * [tNormalize_1 end ] start
				 */

				currentComponent = "tNormalize_1";

				globalMap.put("tNormalize_1_NB_LINE", nb_line_tNormalize_1);
				if (runStat.updateStatAndLog(execStat, enableLogStash, resourceMap, iterateId, "row6", 2, 0,
						"tDBInput_2", "\"stg_crew_dir\"", "tMysqlInput", "tNormalize_1", "tNormalize_1", "tNormalize",
						"output")) {
					talendJobLogProcess(globalMap);
				}

				if (log.isDebugEnabled())
					log.debug("tNormalize_1 - " + ("Done."));

				ok_Hash.put("tNormalize_1", true);
				end_Hash.put("tNormalize_1", System.currentTimeMillis());

				/**
				 * [tNormalize_1 end ] stop
				 */

				/**
				 * [tMap_2 end ] start
				 */

				currentComponent = "tMap_2";

// ###############################
// # Lookup hashes releasing
// ###############################      
				log.debug("tMap_2 - Written records count in the table 'toDirector': " + count_toDirector_tMap_2 + ".");

				if (runStat.updateStatAndLog(execStat, enableLogStash, resourceMap, iterateId, "row7", 2, 0,
						"tNormalize_1", "tNormalize_1", "tNormalize", "tMap_2", "tMap_2", "tMap", "output")) {
					talendJobLogProcess(globalMap);
				}

				if (log.isDebugEnabled())
					log.debug("tMap_2 - " + ("Done."));

				ok_Hash.put("tMap_2", true);
				end_Hash.put("tMap_2", System.currentTimeMillis());

				/**
				 * [tMap_2 end ] stop
				 */

				/**
				 * [tMap_3 begin ] start
				 */

				ok_Hash.put("tMap_3", false);
				start_Hash.put("tMap_3", System.currentTimeMillis());

				currentComponent = "tMap_3";

				runStat.updateStatAndLog(execStat, enableLogStash, resourceMap, iterateId, 0, 0, "row9");

				int tos_count_tMap_3 = 0;

				if (log.isDebugEnabled())
					log.debug("tMap_3 - " + ("Start to work."));
				if (log.isDebugEnabled()) {
					class BytesLimit65535_tMap_3 {
						public void limitLog4jByte() throws Exception {
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
							if (log.isDebugEnabled())
								log.debug("tMap_3 - " + (log4jParamters_tMap_3));
						}
					}
					new BytesLimit65535_tMap_3().limitLog4jByte();
				}
				if (enableLogStash) {
					talendJobLog.addCM("tMap_3", "tMap_3", "tMap");
					talendJobLogProcess(globalMap);
				}

// ###############################
// # Lookup's keys initialization
				int count_row9_tMap_3 = 0;

// ###############################        

// ###############################
// # Vars initialization
				class Var__tMap_3__Struct {
				}
				Var__tMap_3__Struct Var__tMap_3 = new Var__tMap_3__Struct();
// ###############################

// ###############################
// # Outputs initialization
				int count_copyOftoDirector_tMap_3 = 0;

				copyOftoDirectorStruct copyOftoDirector_tmp = new copyOftoDirectorStruct();
// ###############################

				/**
				 * [tMap_3 begin ] stop
				 */

				/**
				 * [tNormalize_2 begin ] start
				 */

				ok_Hash.put("tNormalize_2", false);
				start_Hash.put("tNormalize_2", System.currentTimeMillis());

				currentComponent = "tNormalize_2";

				runStat.updateStatAndLog(execStat, enableLogStash, resourceMap, iterateId, 0, 0, "row8");

				int tos_count_tNormalize_2 = 0;

				if (log.isDebugEnabled())
					log.debug("tNormalize_2 - " + ("Start to work."));
				if (log.isDebugEnabled()) {
					class BytesLimit65535_tNormalize_2 {
						public void limitLog4jByte() throws Exception {
							StringBuilder log4jParamters_tNormalize_2 = new StringBuilder();
							log4jParamters_tNormalize_2.append("Parameters:");
							log4jParamters_tNormalize_2.append("NORMALIZE_COLUMN" + " = " + "writers");
							log4jParamters_tNormalize_2.append(" | ");
							log4jParamters_tNormalize_2.append("ITEMSEPARATOR" + " = " + "\",\"");
							log4jParamters_tNormalize_2.append(" | ");
							log4jParamters_tNormalize_2.append("DEDUPLICATE" + " = " + "false");
							log4jParamters_tNormalize_2.append(" | ");
							log4jParamters_tNormalize_2.append("CSV_OPTION" + " = " + "false");
							log4jParamters_tNormalize_2.append(" | ");
							log4jParamters_tNormalize_2.append("DISCARD_TRAILING_EMPTY_STR" + " = " + "false");
							log4jParamters_tNormalize_2.append(" | ");
							log4jParamters_tNormalize_2.append("TRIM" + " = " + "false");
							log4jParamters_tNormalize_2.append(" | ");
							if (log.isDebugEnabled())
								log.debug("tNormalize_2 - " + (log4jParamters_tNormalize_2));
						}
					}
					new BytesLimit65535_tNormalize_2().limitLog4jByte();
				}
				if (enableLogStash) {
					talendJobLog.addCM("tNormalize_2", "tNormalize_2", "tNormalize");
					talendJobLogProcess(globalMap);
				}

				int lastNoEmptyIndex_tNormalize_2 = 0;
				int nb_line_tNormalize_2 = 0;
				String tmp_tNormalize_2 = null;
				StringBuilder currentRecord_tNormalize_2 = null;
				String[] normalizeRecord_tNormalize_2 = null;
				java.util.Set<String> recordSet_tNormalize_2 = new java.util.HashSet<String>();

				if (((String) ",").length() == 0) {
					throw new IllegalArgumentException("Field Separator must be assigned a char.");
				}

				/**
				 * [tNormalize_2 begin ] stop
				 */

				/**
				 * [tDBInput_6 begin ] start
				 */

				ok_Hash.put("tDBInput_6", false);
				start_Hash.put("tDBInput_6", System.currentTimeMillis());

				currentComponent = "tDBInput_6";

				cLabel = "\"stg_crew_dir\"";

				int tos_count_tDBInput_6 = 0;

				if (log.isDebugEnabled())
					log.debug("tDBInput_6 - " + ("Start to work."));
				if (log.isDebugEnabled()) {
					class BytesLimit65535_tDBInput_6 {
						public void limitLog4jByte() throws Exception {
							StringBuilder log4jParamters_tDBInput_6 = new StringBuilder();
							log4jParamters_tDBInput_6.append("Parameters:");
							log4jParamters_tDBInput_6.append("DB_VERSION" + " = " + "MYSQL_8");
							log4jParamters_tDBInput_6.append(" | ");
							log4jParamters_tDBInput_6.append("USE_EXISTING_CONNECTION" + " = " + "false");
							log4jParamters_tDBInput_6.append(" | ");
							log4jParamters_tDBInput_6.append("HOST" + " = " + "\"127.0.0.1\"");
							log4jParamters_tDBInput_6.append(" | ");
							log4jParamters_tDBInput_6.append("PORT" + " = " + "\"3306\"");
							log4jParamters_tDBInput_6.append(" | ");
							log4jParamters_tDBInput_6.append("DBNAME" + " = " + "\"imdb_src\"");
							log4jParamters_tDBInput_6.append(" | ");
							log4jParamters_tDBInput_6.append("USER" + " = " + "\"user2\"");
							log4jParamters_tDBInput_6.append(" | ");
							log4jParamters_tDBInput_6.append("PASS" + " = " + String.valueOf(
									"enc:routine.encryption.key.v1:8kKMkXeciiMzeveirX8yFWjH086duqEkDBP89OpTq+IJdrO8")
									.substring(0, 4) + "...");
							log4jParamters_tDBInput_6.append(" | ");
							log4jParamters_tDBInput_6.append("TABLE" + " = " + "\"stg_crew_dir\"");
							log4jParamters_tDBInput_6.append(" | ");
							log4jParamters_tDBInput_6.append("QUERYSTORE" + " = " + "\"\"");
							log4jParamters_tDBInput_6.append(" | ");
							log4jParamters_tDBInput_6.append("QUERY" + " = "
									+ "\"SELECT    `stg_crew_dir`.`tconst`,    `stg_crew_dir`.`writers` FROM `stg_crew_dir`\"");
							log4jParamters_tDBInput_6.append(" | ");
							log4jParamters_tDBInput_6.append("SPECIFY_DATASOURCE_ALIAS" + " = " + "false");
							log4jParamters_tDBInput_6.append(" | ");
							log4jParamters_tDBInput_6.append("PROPERTIES" + " = "
									+ "\"noDatetimeStringSync=true&enabledTLSProtocols=TLSv1.2,TLSv1.1,TLSv1\"");
							log4jParamters_tDBInput_6.append(" | ");
							log4jParamters_tDBInput_6.append("ENABLE_STREAM" + " = " + "false");
							log4jParamters_tDBInput_6.append(" | ");
							log4jParamters_tDBInput_6.append("TRIM_ALL_COLUMN" + " = " + "false");
							log4jParamters_tDBInput_6.append(" | ");
							log4jParamters_tDBInput_6.append(
									"TRIM_COLUMN" + " = " + "[{TRIM=" + ("false") + ", SCHEMA_COLUMN=" + ("tconst")
											+ "}, {TRIM=" + ("false") + ", SCHEMA_COLUMN=" + ("writers") + "}]");
							log4jParamters_tDBInput_6.append(" | ");
							log4jParamters_tDBInput_6.append("UNIFIED_COMPONENTS" + " = " + "tMysqlInput");
							log4jParamters_tDBInput_6.append(" | ");
							if (log.isDebugEnabled())
								log.debug("tDBInput_6 - " + (log4jParamters_tDBInput_6));
						}
					}
					new BytesLimit65535_tDBInput_6().limitLog4jByte();
				}
				if (enableLogStash) {
					talendJobLog.addCM("tDBInput_6", "\"stg_crew_dir\"", "tMysqlInput");
					talendJobLogProcess(globalMap);
				}

				java.util.Calendar calendar_tDBInput_6 = java.util.Calendar.getInstance();
				calendar_tDBInput_6.set(0, 0, 0, 0, 0, 0);
				java.util.Date year0_tDBInput_6 = calendar_tDBInput_6.getTime();
				int nb_line_tDBInput_6 = 0;
				java.sql.Connection conn_tDBInput_6 = null;
				String driverClass_tDBInput_6 = "com.mysql.cj.jdbc.Driver";
				java.lang.Class jdbcclazz_tDBInput_6 = java.lang.Class.forName(driverClass_tDBInput_6);
				String dbUser_tDBInput_6 = "user2";

				final String decryptedPassword_tDBInput_6 = routines.system.PasswordEncryptUtil.decryptPassword(
						"enc:routine.encryption.key.v1:Jnn8yASCrLtKqevNjhl6aS8qwjSnDhaE+YGO+Cb/Gwpogttg");

				String dbPwd_tDBInput_6 = decryptedPassword_tDBInput_6;

				String properties_tDBInput_6 = "noDatetimeStringSync=true&enabledTLSProtocols=TLSv1.2,TLSv1.1,TLSv1";
				if (properties_tDBInput_6 == null || properties_tDBInput_6.trim().length() == 0) {
					properties_tDBInput_6 = "";
				}
				String url_tDBInput_6 = "jdbc:mysql://" + "127.0.0.1" + ":" + "3306" + "/" + "imdb_src" + "?"
						+ properties_tDBInput_6;

				log.debug("tDBInput_6 - Driver ClassName: " + driverClass_tDBInput_6 + ".");

				log.debug("tDBInput_6 - Connection attempt to '" + url_tDBInput_6 + "' with the username '"
						+ dbUser_tDBInput_6 + "'.");

				conn_tDBInput_6 = java.sql.DriverManager.getConnection(url_tDBInput_6, dbUser_tDBInput_6,
						dbPwd_tDBInput_6);
				log.debug("tDBInput_6 - Connection to '" + url_tDBInput_6 + "' has succeeded.");

				java.sql.Statement stmt_tDBInput_6 = conn_tDBInput_6.createStatement();

				String dbquery_tDBInput_6 = "SELECT \n  `stg_crew_dir`.`tconst`, \n  `stg_crew_dir`.`writers`\nFROM `stg_crew_dir`";

				log.debug("tDBInput_6 - Executing the query: '" + dbquery_tDBInput_6 + "'.");

				globalMap.put("tDBInput_6_QUERY", dbquery_tDBInput_6);

				java.sql.ResultSet rs_tDBInput_6 = null;

				try {
					rs_tDBInput_6 = stmt_tDBInput_6.executeQuery(dbquery_tDBInput_6);
					java.sql.ResultSetMetaData rsmd_tDBInput_6 = rs_tDBInput_6.getMetaData();
					int colQtyInRs_tDBInput_6 = rsmd_tDBInput_6.getColumnCount();

					String tmpContent_tDBInput_6 = null;

					log.debug("tDBInput_6 - Retrieving records from the database.");

					while (rs_tDBInput_6.next()) {
						nb_line_tDBInput_6++;

						if (colQtyInRs_tDBInput_6 < 1) {
							row8.tconst = null;
						} else {

							row8.tconst = routines.system.JDBCUtil.getString(rs_tDBInput_6, 1, false);
						}
						if (colQtyInRs_tDBInput_6 < 2) {
							row8.writers = null;
						} else {

							row8.writers = routines.system.JDBCUtil.getString(rs_tDBInput_6, 2, false);
						}

						log.debug("tDBInput_6 - Retrieving the record " + nb_line_tDBInput_6 + ".");

						/**
						 * [tDBInput_6 begin ] stop
						 */

						/**
						 * [tDBInput_6 main ] start
						 */

						currentComponent = "tDBInput_6";

						cLabel = "\"stg_crew_dir\"";

						tos_count_tDBInput_6++;

						/**
						 * [tDBInput_6 main ] stop
						 */

						/**
						 * [tDBInput_6 process_data_begin ] start
						 */

						currentComponent = "tDBInput_6";

						cLabel = "\"stg_crew_dir\"";

						/**
						 * [tDBInput_6 process_data_begin ] stop
						 */

						/**
						 * [tNormalize_2 main ] start
						 */

						currentComponent = "tNormalize_2";

						if (runStat.update(execStat, enableLogStash, iterateId, 1, 1

								, "row8", "tDBInput_6", "\"stg_crew_dir\"", "tMysqlInput", "tNormalize_2",
								"tNormalize_2", "tNormalize"

						)) {
							talendJobLogProcess(globalMap);
						}

						if (log.isTraceEnabled()) {
							log.trace("row8 - " + (row8 == null ? "" : row8.toLogString()));
						}

						normalizeRecord_tNormalize_2 = new String[1];
						if (row8.writers != null) {
							if ("".equals(row8.writers)) {
								normalizeRecord_tNormalize_2[0] = "";
							} else {

								normalizeRecord_tNormalize_2 = row8.writers.split(",", -1);

							}
						}
						lastNoEmptyIndex_tNormalize_2 = normalizeRecord_tNormalize_2.length;

						for (int i_tNormalize_2 = 0; i_tNormalize_2 < lastNoEmptyIndex_tNormalize_2; i_tNormalize_2++) {

							currentRecord_tNormalize_2 = new StringBuilder();
							nb_line_tNormalize_2++;

							row9.tconst = row8.tconst;

							row9.writers = normalizeRecord_tNormalize_2[i_tNormalize_2];

							tos_count_tNormalize_2++;

							/**
							 * [tNormalize_2 main ] stop
							 */

							/**
							 * [tNormalize_2 process_data_begin ] start
							 */

							currentComponent = "tNormalize_2";

							/**
							 * [tNormalize_2 process_data_begin ] stop
							 */

							/**
							 * [tMap_3 main ] start
							 */

							currentComponent = "tMap_3";

							if (runStat.update(execStat, enableLogStash, iterateId, 1, 1

									, "row9", "tNormalize_2", "tNormalize_2", "tNormalize", "tMap_3", "tMap_3", "tMap"

							)) {
								talendJobLogProcess(globalMap);
							}

							if (log.isTraceEnabled()) {
								log.trace("row9 - " + (row9 == null ? "" : row9.toLogString()));
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

								copyOftoDirector = null;

// # Output table : 'copyOftoDirector'
								count_copyOftoDirector_tMap_3++;

								copyOftoDirector_tmp.tconst = row9.tconst;
								copyOftoDirector_tmp.category = "writer";
								copyOftoDirector_tmp.nconst = row9.writers;
								copyOftoDirector = copyOftoDirector_tmp;
								log.debug("tMap_3 - Outputting the record " + count_copyOftoDirector_tMap_3
										+ " of the output table 'copyOftoDirector'.");

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

							currentComponent = "tMap_3";

							/**
							 * [tMap_3 process_data_begin ] stop
							 */
// Start of branch "copyOftoDirector"
							if (copyOftoDirector != null) {

								/**
								 * [tUnite_1 main ] start
								 */

								currentComponent = "tUnite_1";

								if (runStat.update(execStat, enableLogStash, iterateId, 1, 1

										, "copyOftoDirector", "tMap_3", "tMap_3", "tMap", "tUnite_1", "tUnite_1",
										"tUnite"

								)) {
									talendJobLogProcess(globalMap);
								}

								if (log.isTraceEnabled()) {
									log.trace("copyOftoDirector - "
											+ (copyOftoDirector == null ? "" : copyOftoDirector.toLogString()));
								}

								if (log.isTraceEnabled()) {
									log.trace("toDirector - " + (toDirector == null ? "" : toDirector.toLogString()));
								}

//////////

// for output
								row10 = new row10Struct();

								row10.tconst = copyOftoDirector.tconst;
								row10.category = copyOftoDirector.category;
								row10.nconst = copyOftoDirector.nconst;

								nb_line_tUnite_1++;

//////////

								tos_count_tUnite_1++;

								/**
								 * [tUnite_1 main ] stop
								 */

								/**
								 * [tUnite_1 process_data_begin ] start
								 */

								currentComponent = "tUnite_1";

								/**
								 * [tUnite_1 process_data_begin ] stop
								 */

								/**
								 * [tMap_4 main ] start
								 */

								currentComponent = "tMap_4";

								if (runStat.update(execStat, enableLogStash, iterateId, 1, 1

										, "row10", "tUnite_1", "tUnite_1", "tUnite", "tMap_4", "tMap_4", "tMap"

								)) {
									talendJobLogProcess(globalMap);
								}

								if (log.isTraceEnabled()) {
									log.trace("row10 - " + (row10 == null ? "" : row10.toLogString()));
								}

								boolean hasCasePrimitiveKeyWithNull_tMap_4 = false;

								row11Struct row11 = null;

								row12Struct row12 = null;

								row13Struct row13 = null;

								// ###############################
								// # Input tables (lookups)

								boolean rejectedInnerJoin_tMap_4 = false;
								boolean mainRowRejected_tMap_4 = false;

								///////////////////////////////////////////////
								// Starting Lookup Table "row11"
								///////////////////////////////////////////////

								boolean forceLooprow11 = false;

								row11Struct row11ObjectFromLookup = null;

								if (!rejectedInnerJoin_tMap_4) { // G_TM_M_020

									hasCasePrimitiveKeyWithNull_tMap_4 = false;

									row11HashKey.nmconst = row10.nconst;

									row11HashKey.hashCodeDirty = true;

									tHash_Lookup_row11.lookup(row11HashKey);

								} // G_TM_M_020

								if (tHash_Lookup_row11 != null && tHash_Lookup_row11.getCount(row11HashKey) > 1) { // G
																													// 071

									// System.out.println("WARNING: UNIQUE MATCH is configured for the lookup
									// 'row11' and it contains more one result from keys : row11.nmconst = '" +
									// row11HashKey.nmconst + "'");
								} // G 071

								row11Struct fromLookup_row11 = null;
								row11 = row11Default;

								if (tHash_Lookup_row11 != null && tHash_Lookup_row11.hasNext()) { // G 099

									fromLookup_row11 = tHash_Lookup_row11.next();

								} // G 099

								if (fromLookup_row11 != null) {
									row11 = fromLookup_row11;
								}

								///////////////////////////////////////////////
								// Starting Lookup Table "row12"
								///////////////////////////////////////////////

								boolean forceLooprow12 = false;

								row12Struct row12ObjectFromLookup = null;

								if (!rejectedInnerJoin_tMap_4) { // G_TM_M_020

									hasCasePrimitiveKeyWithNull_tMap_4 = false;

									row12HashKey.Name = row10.category;

									row12HashKey.hashCodeDirty = true;

									tHash_Lookup_row12.lookup(row12HashKey);

								} // G_TM_M_020

								if (tHash_Lookup_row12 != null && tHash_Lookup_row12.getCount(row12HashKey) > 1) { // G
																													// 071

									// System.out.println("WARNING: UNIQUE MATCH is configured for the lookup
									// 'row12' and it contains more one result from keys : row12.Name = '" +
									// row12HashKey.Name + "'");
								} // G 071

								row12Struct fromLookup_row12 = null;
								row12 = row12Default;

								if (tHash_Lookup_row12 != null && tHash_Lookup_row12.hasNext()) { // G 099

									fromLookup_row12 = tHash_Lookup_row12.next();

								} // G 099

								if (fromLookup_row12 != null) {
									row12 = fromLookup_row12;
								}

								///////////////////////////////////////////////
								// Starting Lookup Table "row13"
								///////////////////////////////////////////////

								boolean forceLooprow13 = false;

								row13Struct row13ObjectFromLookup = null;

								if (!rejectedInnerJoin_tMap_4) { // G_TM_M_020

									hasCasePrimitiveKeyWithNull_tMap_4 = false;

									row13HashKey.tconst = row10.tconst;

									row13HashKey.hashCodeDirty = true;

									tHash_Lookup_row13.lookup(row13HashKey);

								} // G_TM_M_020

								if (tHash_Lookup_row13 != null && tHash_Lookup_row13.getCount(row13HashKey) > 1) { // G
																													// 071

									// System.out.println("WARNING: UNIQUE MATCH is configured for the lookup
									// 'row13' and it contains more one result from keys : row13.tconst = '" +
									// row13HashKey.tconst + "'");
								} // G 071

								row13Struct fromLookup_row13 = null;
								row13 = row13Default;

								if (tHash_Lookup_row13 != null && tHash_Lookup_row13.hasNext()) { // G 099

									fromLookup_row13 = tHash_Lookup_row13.next();

								} // G 099

								if (fromLookup_row13 != null) {
									row13 = fromLookup_row13;
								}

								// ###############################
								{ // start of Var scope

									// ###############################
									// # Vars tables

									Var__tMap_4__Struct Var = Var__tMap_4;// ###############################
									// ###############################
									// # Output tables

									toTable1 = null;

// # Output table : 'toTable1'
									count_toTable1_tMap_4++;

									toTable1_tmp.Movie_ID = row13.Movie_ID;
									toTable1_tmp.Crew_SK = row11.Crew_SK;
									toTable1_tmp.Profession_SK = row12.Profession_SK;
									toTable1_tmp.DI_CreatedDate = TalendDate.getCurrentDate();
									toTable1_tmp.DI_WorkflowJobId = pid;
									toTable1 = toTable1_tmp;
									log.debug("tMap_4 - Outputting the record " + count_toTable1_tMap_4
											+ " of the output table 'toTable1'.");

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

								currentComponent = "tMap_4";

								/**
								 * [tMap_4 process_data_begin ] stop
								 */
// Start of branch "toTable1"
								if (toTable1 != null) {

									/**
									 * [tDBOutput_2 main ] start
									 */

									currentComponent = "tDBOutput_2";

									cLabel = "\"bridge_crew_movie\"";

									if (runStat.update(execStat, enableLogStash, iterateId, 1, 1

											, "toTable1", "tMap_4", "tMap_4", "tMap", "tDBOutput_2",
											"\"bridge_crew_movie\"", "tMysqlOutput"

									)) {
										talendJobLogProcess(globalMap);
									}

									if (log.isTraceEnabled()) {
										log.trace("toTable1 - " + (toTable1 == null ? "" : toTable1.toLogString()));
									}

									whetherReject_tDBOutput_2 = false;
									pstmt_tDBOutput_2.setInt(1, toTable1.Movie_ID);

									pstmt_tDBOutput_2.setInt(2, toTable1.Crew_SK);

									pstmt_tDBOutput_2.setInt(3, toTable1.Profession_SK);

									int checkCount_tDBOutput_2 = -1;
									try (java.sql.ResultSet rs_tDBOutput_2 = pstmt_tDBOutput_2.executeQuery()) {
										while (rs_tDBOutput_2.next()) {
											checkCount_tDBOutput_2 = rs_tDBOutput_2.getInt(1);
										}
									}
									if (checkCount_tDBOutput_2 > 0) {
										if (toTable1.DI_CreatedDate != null) {
											date_tDBOutput_2 = toTable1.DI_CreatedDate.getTime();
											if (date_tDBOutput_2 < year1_tDBOutput_2
													|| date_tDBOutput_2 >= year10000_tDBOutput_2) {
												pstmtUpdate_tDBOutput_2.setString(1, "0000-00-00 00:00:00");
											} else {
												pstmtUpdate_tDBOutput_2.setTimestamp(1,
														new java.sql.Timestamp(date_tDBOutput_2));
											}
										} else {
											pstmtUpdate_tDBOutput_2.setNull(1, java.sql.Types.DATE);
										}

										if (toTable1.DI_WorkflowJobId == null) {
											pstmtUpdate_tDBOutput_2.setNull(2, java.sql.Types.VARCHAR);
										} else {
											pstmtUpdate_tDBOutput_2.setString(2, toTable1.DI_WorkflowJobId);
										}

										pstmtUpdate_tDBOutput_2.setInt(3 + count_tDBOutput_2, toTable1.Movie_ID);

										pstmtUpdate_tDBOutput_2.setInt(4 + count_tDBOutput_2, toTable1.Crew_SK);

										pstmtUpdate_tDBOutput_2.setInt(5 + count_tDBOutput_2, toTable1.Profession_SK);

										try {
											int processedCount_tDBOutput_2 = pstmtUpdate_tDBOutput_2.executeUpdate();
											updatedCount_tDBOutput_2 += processedCount_tDBOutput_2;
											rowsToCommitCount_tDBOutput_2 += processedCount_tDBOutput_2;
											nb_line_tDBOutput_2++;
											if (log.isDebugEnabled())
												log.debug("tDBOutput_2 - " + ("Updating") + (" the record ")
														+ (nb_line_tDBOutput_2) + ("."));
										} catch (java.lang.Exception e) {
											globalMap.put("tDBOutput_2_ERROR_MESSAGE", e.getMessage());
											whetherReject_tDBOutput_2 = true;
											nb_line_tDBOutput_2++;
											log.error("tDBOutput_2 - " + (e.getMessage()));
											System.err.print(e.getMessage());
										}
									} else {
										pstmtInsert_tDBOutput_2.setInt(1, toTable1.Movie_ID);

										pstmtInsert_tDBOutput_2.setInt(2, toTable1.Crew_SK);

										pstmtInsert_tDBOutput_2.setInt(3, toTable1.Profession_SK);

										if (toTable1.DI_CreatedDate != null) {
											date_tDBOutput_2 = toTable1.DI_CreatedDate.getTime();
											if (date_tDBOutput_2 < year1_tDBOutput_2
													|| date_tDBOutput_2 >= year10000_tDBOutput_2) {
												pstmtInsert_tDBOutput_2.setString(4, "0000-00-00 00:00:00");
											} else {
												pstmtInsert_tDBOutput_2.setTimestamp(4,
														new java.sql.Timestamp(date_tDBOutput_2));
											}
										} else {
											pstmtInsert_tDBOutput_2.setNull(4, java.sql.Types.DATE);
										}

										if (toTable1.DI_WorkflowJobId == null) {
											pstmtInsert_tDBOutput_2.setNull(5, java.sql.Types.VARCHAR);
										} else {
											pstmtInsert_tDBOutput_2.setString(5, toTable1.DI_WorkflowJobId);
										}

										try {
											int processedCount_tDBOutput_2 = pstmtInsert_tDBOutput_2.executeUpdate();
											insertedCount_tDBOutput_2 += processedCount_tDBOutput_2;
											rowsToCommitCount_tDBOutput_2 += processedCount_tDBOutput_2;
											nb_line_tDBOutput_2++;
											if (log.isDebugEnabled())
												log.debug("tDBOutput_2 - " + ("Inserting") + (" the record ")
														+ (nb_line_tDBOutput_2) + ("."));
										} catch (java.lang.Exception e) {
											globalMap.put("tDBOutput_2_ERROR_MESSAGE", e.getMessage());
											whetherReject_tDBOutput_2 = true;
											nb_line_tDBOutput_2++;
											log.error("tDBOutput_2 - " + (e.getMessage()));
											System.err.print(e.getMessage());
										}
									}
									commitCounter_tDBOutput_2++;

									if (commitEvery_tDBOutput_2 <= commitCounter_tDBOutput_2) {

										if (rowsToCommitCount_tDBOutput_2 != 0) {
											if (log.isDebugEnabled())
												log.debug("tDBOutput_2 - " + ("Connection starting to commit ")
														+ (rowsToCommitCount_tDBOutput_2) + (" record(s)."));
										}
										conn_tDBOutput_2.commit();
										if (rowsToCommitCount_tDBOutput_2 != 0) {
											if (log.isDebugEnabled())
												log.debug("tDBOutput_2 - " + ("Connection commit has succeeded."));
											rowsToCommitCount_tDBOutput_2 = 0;
										}
										commitCounter_tDBOutput_2 = 0;
									}

									tos_count_tDBOutput_2++;

									/**
									 * [tDBOutput_2 main ] stop
									 */

									/**
									 * [tDBOutput_2 process_data_begin ] start
									 */

									currentComponent = "tDBOutput_2";

									cLabel = "\"bridge_crew_movie\"";

									/**
									 * [tDBOutput_2 process_data_begin ] stop
									 */

									/**
									 * [tDBOutput_2 process_data_end ] start
									 */

									currentComponent = "tDBOutput_2";

									cLabel = "\"bridge_crew_movie\"";

									/**
									 * [tDBOutput_2 process_data_end ] stop
									 */

								} // End of branch "toTable1"

								/**
								 * [tMap_4 process_data_end ] start
								 */

								currentComponent = "tMap_4";

								/**
								 * [tMap_4 process_data_end ] stop
								 */

								/**
								 * [tUnite_1 process_data_end ] start
								 */

								currentComponent = "tUnite_1";

								/**
								 * [tUnite_1 process_data_end ] stop
								 */

							} // End of branch "copyOftoDirector"

							/**
							 * [tMap_3 process_data_end ] start
							 */

							currentComponent = "tMap_3";

							/**
							 * [tMap_3 process_data_end ] stop
							 */
							// end for
						}

						/**
						 * [tNormalize_2 process_data_end ] start
						 */

						currentComponent = "tNormalize_2";

						/**
						 * [tNormalize_2 process_data_end ] stop
						 */

						/**
						 * [tDBInput_6 process_data_end ] start
						 */

						currentComponent = "tDBInput_6";

						cLabel = "\"stg_crew_dir\"";

						/**
						 * [tDBInput_6 process_data_end ] stop
						 */

						/**
						 * [tDBInput_6 end ] start
						 */

						currentComponent = "tDBInput_6";

						cLabel = "\"stg_crew_dir\"";

					}
				} finally {
					if (rs_tDBInput_6 != null) {
						rs_tDBInput_6.close();
					}
					if (stmt_tDBInput_6 != null) {
						stmt_tDBInput_6.close();
					}
					if (conn_tDBInput_6 != null && !conn_tDBInput_6.isClosed()) {

						log.debug("tDBInput_6 - Closing the connection to the database.");

						conn_tDBInput_6.close();

						if ("com.mysql.cj.jdbc.Driver".equals((String) globalMap.get("driverClass_"))
								&& routines.system.BundleUtils.inOSGi()) {
							Class.forName("com.mysql.cj.jdbc.AbandonedConnectionCleanupThread")
									.getMethod("checkedShutdown").invoke(null, (Object[]) null);
						}

						log.debug("tDBInput_6 - Connection to the database closed.");

					}

				}
				globalMap.put("tDBInput_6_NB_LINE", nb_line_tDBInput_6);
				log.debug("tDBInput_6 - Retrieved records count: " + nb_line_tDBInput_6 + " .");

				if (log.isDebugEnabled())
					log.debug("tDBInput_6 - " + ("Done."));

				ok_Hash.put("tDBInput_6", true);
				end_Hash.put("tDBInput_6", System.currentTimeMillis());

				/**
				 * [tDBInput_6 end ] stop
				 */

				/**
				 * [tNormalize_2 end ] start
				 */

				currentComponent = "tNormalize_2";

				globalMap.put("tNormalize_2_NB_LINE", nb_line_tNormalize_2);
				if (runStat.updateStatAndLog(execStat, enableLogStash, resourceMap, iterateId, "row8", 2, 0,
						"tDBInput_6", "\"stg_crew_dir\"", "tMysqlInput", "tNormalize_2", "tNormalize_2", "tNormalize",
						"output")) {
					talendJobLogProcess(globalMap);
				}

				if (log.isDebugEnabled())
					log.debug("tNormalize_2 - " + ("Done."));

				ok_Hash.put("tNormalize_2", true);
				end_Hash.put("tNormalize_2", System.currentTimeMillis());

				/**
				 * [tNormalize_2 end ] stop
				 */

				/**
				 * [tMap_3 end ] start
				 */

				currentComponent = "tMap_3";

// ###############################
// # Lookup hashes releasing
// ###############################      
				log.debug("tMap_3 - Written records count in the table 'copyOftoDirector': "
						+ count_copyOftoDirector_tMap_3 + ".");

				if (runStat.updateStatAndLog(execStat, enableLogStash, resourceMap, iterateId, "row9", 2, 0,
						"tNormalize_2", "tNormalize_2", "tNormalize", "tMap_3", "tMap_3", "tMap", "output")) {
					talendJobLogProcess(globalMap);
				}

				if (log.isDebugEnabled())
					log.debug("tMap_3 - " + ("Done."));

				ok_Hash.put("tMap_3", true);
				end_Hash.put("tMap_3", System.currentTimeMillis());

				/**
				 * [tMap_3 end ] stop
				 */

				/**
				 * [tUnite_1 end ] start
				 */

				currentComponent = "tUnite_1";

				globalMap.put("tUnite_1_NB_LINE", nb_line_tUnite_1);
				if (execStat) {
					runStat.updateStat(resourceMap, iterateId, 2, 0, "copyOftoDirector", "toDirector");
				}

				if (enableLogStash) {

					if (runStat.log(resourceMap, iterateId, "copyOftoDirector", 2, 0, "tMap_3", "tMap_3", "tMap",
							"tUnite_1", "tUnite_1", "tUnite", "output")) {
						talendJobLogProcess(globalMap);
					}

					if (runStat.log(resourceMap, iterateId, "toDirector", 2, 0, "tMap_2", "tMap_2", "tMap", "tUnite_1",
							"tUnite_1", "tUnite", "output")) {
						talendJobLogProcess(globalMap);
					}

				}

				if (log.isDebugEnabled())
					log.debug("tUnite_1 - " + ("Done."));

				ok_Hash.put("tUnite_1", true);
				end_Hash.put("tUnite_1", System.currentTimeMillis());

				/**
				 * [tUnite_1 end ] stop
				 */

				/**
				 * [tMap_4 end ] start
				 */

				currentComponent = "tMap_4";

// ###############################
// # Lookup hashes releasing
				if (tHash_Lookup_row11 != null) {
					tHash_Lookup_row11.endGet();
				}
				globalMap.remove("tHash_Lookup_row11");

				if (tHash_Lookup_row12 != null) {
					tHash_Lookup_row12.endGet();
				}
				globalMap.remove("tHash_Lookup_row12");

				if (tHash_Lookup_row13 != null) {
					tHash_Lookup_row13.endGet();
				}
				globalMap.remove("tHash_Lookup_row13");

// ###############################      
				log.debug("tMap_4 - Written records count in the table 'toTable1': " + count_toTable1_tMap_4 + ".");

				if (runStat.updateStatAndLog(execStat, enableLogStash, resourceMap, iterateId, "row10", 2, 0,
						"tUnite_1", "tUnite_1", "tUnite", "tMap_4", "tMap_4", "tMap", "output")) {
					talendJobLogProcess(globalMap);
				}

				if (log.isDebugEnabled())
					log.debug("tMap_4 - " + ("Done."));

				ok_Hash.put("tMap_4", true);
				end_Hash.put("tMap_4", System.currentTimeMillis());

				/**
				 * [tMap_4 end ] stop
				 */

				/**
				 * [tDBOutput_2 end ] start
				 */

				currentComponent = "tDBOutput_2";

				cLabel = "\"bridge_crew_movie\"";

				if (pstmtUpdate_tDBOutput_2 != null) {
					pstmtUpdate_tDBOutput_2.close();
					resourceMap.remove("pstmtUpdate_tDBOutput_2");
				}
				if (pstmtInsert_tDBOutput_2 != null) {
					pstmtInsert_tDBOutput_2.close();
					resourceMap.remove("pstmtInsert_tDBOutput_2");
				}
				if (pstmt_tDBOutput_2 != null) {
					pstmt_tDBOutput_2.close();
					resourceMap.remove("pstmt_tDBOutput_2");
				}

				resourceMap.put("statementClosed_tDBOutput_2", true);

				if (commitCounter_tDBOutput_2 > 0 && rowsToCommitCount_tDBOutput_2 != 0) {

					if (log.isDebugEnabled())
						log.debug("tDBOutput_2 - " + ("Connection starting to commit ")
								+ (rowsToCommitCount_tDBOutput_2) + (" record(s)."));
				}
				conn_tDBOutput_2.commit();
				if (commitCounter_tDBOutput_2 > 0 && rowsToCommitCount_tDBOutput_2 != 0) {

					if (log.isDebugEnabled())
						log.debug("tDBOutput_2 - " + ("Connection commit has succeeded."));
					rowsToCommitCount_tDBOutput_2 = 0;
				}
				commitCounter_tDBOutput_2 = 0;

				if (log.isDebugEnabled())
					log.debug("tDBOutput_2 - " + ("Closing the connection to the database."));
				conn_tDBOutput_2.close();

				if (log.isDebugEnabled())
					log.debug("tDBOutput_2 - " + ("Connection to the database has closed."));
				resourceMap.put("finish_tDBOutput_2", true);

				nb_line_deleted_tDBOutput_2 = nb_line_deleted_tDBOutput_2 + deletedCount_tDBOutput_2;
				nb_line_update_tDBOutput_2 = nb_line_update_tDBOutput_2 + updatedCount_tDBOutput_2;
				nb_line_inserted_tDBOutput_2 = nb_line_inserted_tDBOutput_2 + insertedCount_tDBOutput_2;
				nb_line_rejected_tDBOutput_2 = nb_line_rejected_tDBOutput_2 + rejectedCount_tDBOutput_2;

				globalMap.put("tDBOutput_2_NB_LINE", nb_line_tDBOutput_2);
				globalMap.put("tDBOutput_2_NB_LINE_UPDATED", nb_line_update_tDBOutput_2);
				globalMap.put("tDBOutput_2_NB_LINE_INSERTED", nb_line_inserted_tDBOutput_2);
				globalMap.put("tDBOutput_2_NB_LINE_DELETED", nb_line_deleted_tDBOutput_2);
				globalMap.put("tDBOutput_2_NB_LINE_REJECTED", nb_line_rejected_tDBOutput_2);

				if (log.isDebugEnabled())
					log.debug("tDBOutput_2 - " + ("Has ") + ("inserted") + (" ") + (nb_line_inserted_tDBOutput_2)
							+ (" record(s)."));
				if (log.isDebugEnabled())
					log.debug("tDBOutput_2 - " + ("Has ") + ("updated") + (" ") + (nb_line_update_tDBOutput_2)
							+ (" record(s)."));

				if (runStat.updateStatAndLog(execStat, enableLogStash, resourceMap, iterateId, "toTable1", 2, 0,
						"tMap_4", "tMap_4", "tMap", "tDBOutput_2", "\"bridge_crew_movie\"", "tMysqlOutput", "output")) {
					talendJobLogProcess(globalMap);
				}

				if (log.isDebugEnabled())
					log.debug("tDBOutput_2 - " + ("Done."));

				ok_Hash.put("tDBOutput_2", true);
				end_Hash.put("tDBOutput_2", System.currentTimeMillis());

				/**
				 * [tDBOutput_2 end ] stop
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

			// free memory for "tMap_4"
			globalMap.remove("tHash_Lookup_row11");

			// free memory for "tMap_4"
			globalMap.remove("tHash_Lookup_row12");

			// free memory for "tMap_4"
			globalMap.remove("tHash_Lookup_row13");

			try {

				/**
				 * [tDBInput_2 finally ] start
				 */

				currentComponent = "tDBInput_2";

				cLabel = "\"stg_crew_dir\"";

				/**
				 * [tDBInput_2 finally ] stop
				 */

				/**
				 * [tNormalize_1 finally ] start
				 */

				currentComponent = "tNormalize_1";

				/**
				 * [tNormalize_1 finally ] stop
				 */

				/**
				 * [tMap_2 finally ] start
				 */

				currentComponent = "tMap_2";

				/**
				 * [tMap_2 finally ] stop
				 */

				/**
				 * [tDBInput_6 finally ] start
				 */

				currentComponent = "tDBInput_6";

				cLabel = "\"stg_crew_dir\"";

				/**
				 * [tDBInput_6 finally ] stop
				 */

				/**
				 * [tNormalize_2 finally ] start
				 */

				currentComponent = "tNormalize_2";

				/**
				 * [tNormalize_2 finally ] stop
				 */

				/**
				 * [tMap_3 finally ] start
				 */

				currentComponent = "tMap_3";

				/**
				 * [tMap_3 finally ] stop
				 */

				/**
				 * [tUnite_1 finally ] start
				 */

				currentComponent = "tUnite_1";

				/**
				 * [tUnite_1 finally ] stop
				 */

				/**
				 * [tMap_4 finally ] start
				 */

				currentComponent = "tMap_4";

				/**
				 * [tMap_4 finally ] stop
				 */

				/**
				 * [tDBOutput_2 finally ] start
				 */

				currentComponent = "tDBOutput_2";

				cLabel = "\"bridge_crew_movie\"";

				try {
					if (resourceMap.get("statementClosed_tDBOutput_2") == null) {
						java.sql.PreparedStatement pstmtUpdateToClose_tDBOutput_2 = null;
						if ((pstmtUpdateToClose_tDBOutput_2 = (java.sql.PreparedStatement) resourceMap
								.remove("pstmtUpdate_tDBOutput_2")) != null) {
							pstmtUpdateToClose_tDBOutput_2.close();
						}
						java.sql.PreparedStatement pstmtInsertToClose_tDBOutput_2 = null;
						if ((pstmtInsertToClose_tDBOutput_2 = (java.sql.PreparedStatement) resourceMap
								.remove("pstmtInsert_tDBOutput_2")) != null) {
							pstmtInsertToClose_tDBOutput_2.close();
						}
						java.sql.PreparedStatement pstmtToClose_tDBOutput_2 = null;
						if ((pstmtToClose_tDBOutput_2 = (java.sql.PreparedStatement) resourceMap
								.remove("pstmt_tDBOutput_2")) != null) {
							pstmtToClose_tDBOutput_2.close();
						}
					}
				} finally {
					if (resourceMap.get("finish_tDBOutput_2") == null) {
						java.sql.Connection ctn_tDBOutput_2 = null;
						if ((ctn_tDBOutput_2 = (java.sql.Connection) resourceMap.get("conn_tDBOutput_2")) != null) {
							try {
								if (log.isDebugEnabled())
									log.debug("tDBOutput_2 - " + ("Closing the connection to the database."));
								ctn_tDBOutput_2.close();
								if (log.isDebugEnabled())
									log.debug("tDBOutput_2 - " + ("Connection to the database has closed."));
							} catch (java.sql.SQLException sqlEx_tDBOutput_2) {
								String errorMessage_tDBOutput_2 = "failed to close the connection in tDBOutput_2 :"
										+ sqlEx_tDBOutput_2.getMessage();
								log.error("tDBOutput_2 - " + (errorMessage_tDBOutput_2));
								System.err.println(errorMessage_tDBOutput_2);
							}
						}
					}
				}

				/**
				 * [tDBOutput_2 finally ] stop
				 */

			} catch (java.lang.Exception e) {
				// ignore
			} catch (java.lang.Error error) {
				// ignore
			}
			resourceMap = null;
		}

		globalMap.put("tDBInput_2_SUBPROCESS_STATE", 1);
	}

	public static class row5Struct implements routines.system.IPersistableRow<row5Struct> {
		final static byte[] commonByteArrayLock_FINAL_PROJECT_bridge_crew_movie = new byte[0];
		static byte[] commonByteArray_FINAL_PROJECT_bridge_crew_movie = new byte[0];
		protected static final int DEFAULT_HASHCODE = 1;
		protected static final int PRIME = 31;
		protected int hashCode = DEFAULT_HASHCODE;
		public boolean hashCodeDirty = true;

		public String loopKey;

		public int Movie_ID;

		public int getMovie_ID() {
			return this.Movie_ID;
		}

		public Boolean Movie_IDIsNullable() {
			return false;
		}

		public Boolean Movie_IDIsKey() {
			return true;
		}

		public Integer Movie_IDLength() {
			return null;
		}

		public Integer Movie_IDPrecision() {
			return null;
		}

		public String Movie_IDDefault() {

			return null;

		}

		public String Movie_IDComment() {

			return "";

		}

		public String Movie_IDPattern() {

			return "";

		}

		public String Movie_IDOriginalDbColumnName() {

			return "Movie_ID";

		}

		public int Crew_SK;

		public int getCrew_SK() {
			return this.Crew_SK;
		}

		public Boolean Crew_SKIsNullable() {
			return false;
		}

		public Boolean Crew_SKIsKey() {
			return true;
		}

		public Integer Crew_SKLength() {
			return null;
		}

		public Integer Crew_SKPrecision() {
			return null;
		}

		public String Crew_SKDefault() {

			return null;

		}

		public String Crew_SKComment() {

			return "";

		}

		public String Crew_SKPattern() {

			return "";

		}

		public String Crew_SKOriginalDbColumnName() {

			return "Crew_SK";

		}

		public int Profession_SK;

		public int getProfession_SK() {
			return this.Profession_SK;
		}

		public Boolean Profession_SKIsNullable() {
			return false;
		}

		public Boolean Profession_SKIsKey() {
			return true;
		}

		public Integer Profession_SKLength() {
			return null;
		}

		public Integer Profession_SKPrecision() {
			return null;
		}

		public String Profession_SKDefault() {

			return null;

		}

		public String Profession_SKComment() {

			return "";

		}

		public String Profession_SKPattern() {

			return "";

		}

		public String Profession_SKOriginalDbColumnName() {

			return "Profession_SK";

		}

		public java.util.Date DI_CreatedDate;

		public java.util.Date getDI_CreatedDate() {
			return this.DI_CreatedDate;
		}

		public Boolean DI_CreatedDateIsNullable() {
			return false;
		}

		public Boolean DI_CreatedDateIsKey() {
			return false;
		}

		public Integer DI_CreatedDateLength() {
			return null;
		}

		public Integer DI_CreatedDatePrecision() {
			return null;
		}

		public String DI_CreatedDateDefault() {

			return null;

		}

		public String DI_CreatedDateComment() {

			return "";

		}

		public String DI_CreatedDatePattern() {

			return "dd-MM-yyyy";

		}

		public String DI_CreatedDateOriginalDbColumnName() {

			return "DI_CreatedDate";

		}

		public String DI_WorkflowJobId;

		public String getDI_WorkflowJobId() {
			return this.DI_WorkflowJobId;
		}

		public Boolean DI_WorkflowJobIdIsNullable() {
			return false;
		}

		public Boolean DI_WorkflowJobIdIsKey() {
			return false;
		}

		public Integer DI_WorkflowJobIdLength() {
			return 8;
		}

		public Integer DI_WorkflowJobIdPrecision() {
			return null;
		}

		public String DI_WorkflowJobIdDefault() {

			return null;

		}

		public String DI_WorkflowJobIdComment() {

			return "";

		}

		public String DI_WorkflowJobIdPattern() {

			return "";

		}

		public String DI_WorkflowJobIdOriginalDbColumnName() {

			return "DI_WorkflowJobId";

		}

		@Override
		public int hashCode() {
			if (this.hashCodeDirty) {
				final int prime = PRIME;
				int result = DEFAULT_HASHCODE;

				result = prime * result + (int) this.Movie_ID;

				result = prime * result + (int) this.Crew_SK;

				result = prime * result + (int) this.Profession_SK;

				this.hashCode = result;
				this.hashCodeDirty = false;
			}
			return this.hashCode;
		}

		@Override
		public boolean equals(Object obj) {
			if (this == obj)
				return true;
			if (obj == null)
				return false;
			if (getClass() != obj.getClass())
				return false;
			final row5Struct other = (row5Struct) obj;

			if (this.Movie_ID != other.Movie_ID)
				return false;

			if (this.Crew_SK != other.Crew_SK)
				return false;

			if (this.Profession_SK != other.Profession_SK)
				return false;

			return true;
		}

		public void copyDataTo(row5Struct other) {

			other.Movie_ID = this.Movie_ID;
			other.Crew_SK = this.Crew_SK;
			other.Profession_SK = this.Profession_SK;
			other.DI_CreatedDate = this.DI_CreatedDate;
			other.DI_WorkflowJobId = this.DI_WorkflowJobId;

		}

		public void copyKeysDataTo(row5Struct other) {

			other.Movie_ID = this.Movie_ID;
			other.Crew_SK = this.Crew_SK;
			other.Profession_SK = this.Profession_SK;

		}

		private java.util.Date readDate(ObjectInputStream dis) throws IOException {
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

		private java.util.Date readDate(org.jboss.marshalling.Unmarshaller unmarshaller) throws IOException {
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

		private void writeDate(java.util.Date date1, ObjectOutputStream dos) throws IOException {
			if (date1 == null) {
				dos.writeByte(-1);
			} else {
				dos.writeByte(0);
				dos.writeLong(date1.getTime());
			}
		}

		private void writeDate(java.util.Date date1, org.jboss.marshalling.Marshaller marshaller) throws IOException {
			if (date1 == null) {
				marshaller.writeByte(-1);
			} else {
				marshaller.writeByte(0);
				marshaller.writeLong(date1.getTime());
			}
		}

		private String readString(ObjectInputStream dis) throws IOException {
			String strReturn = null;
			int length = 0;
			length = dis.readInt();
			if (length == -1) {
				strReturn = null;
			} else {
				if (length > commonByteArray_FINAL_PROJECT_bridge_crew_movie.length) {
					if (length < 1024 && commonByteArray_FINAL_PROJECT_bridge_crew_movie.length == 0) {
						commonByteArray_FINAL_PROJECT_bridge_crew_movie = new byte[1024];
					} else {
						commonByteArray_FINAL_PROJECT_bridge_crew_movie = new byte[2 * length];
					}
				}
				dis.readFully(commonByteArray_FINAL_PROJECT_bridge_crew_movie, 0, length);
				strReturn = new String(commonByteArray_FINAL_PROJECT_bridge_crew_movie, 0, length, utf8Charset);
			}
			return strReturn;
		}

		private String readString(org.jboss.marshalling.Unmarshaller unmarshaller) throws IOException {
			String strReturn = null;
			int length = 0;
			length = unmarshaller.readInt();
			if (length == -1) {
				strReturn = null;
			} else {
				if (length > commonByteArray_FINAL_PROJECT_bridge_crew_movie.length) {
					if (length < 1024 && commonByteArray_FINAL_PROJECT_bridge_crew_movie.length == 0) {
						commonByteArray_FINAL_PROJECT_bridge_crew_movie = new byte[1024];
					} else {
						commonByteArray_FINAL_PROJECT_bridge_crew_movie = new byte[2 * length];
					}
				}
				unmarshaller.readFully(commonByteArray_FINAL_PROJECT_bridge_crew_movie, 0, length);
				strReturn = new String(commonByteArray_FINAL_PROJECT_bridge_crew_movie, 0, length, utf8Charset);
			}
			return strReturn;
		}

		private void writeString(String str, ObjectOutputStream dos) throws IOException {
			if (str == null) {
				dos.writeInt(-1);
			} else {
				byte[] byteArray = str.getBytes(utf8Charset);
				dos.writeInt(byteArray.length);
				dos.write(byteArray);
			}
		}

		private void writeString(String str, org.jboss.marshalling.Marshaller marshaller) throws IOException {
			if (str == null) {
				marshaller.writeInt(-1);
			} else {
				byte[] byteArray = str.getBytes(utf8Charset);
				marshaller.writeInt(byteArray.length);
				marshaller.write(byteArray);
			}
		}

		public void readData(ObjectInputStream dis) {

			synchronized (commonByteArrayLock_FINAL_PROJECT_bridge_crew_movie) {

				try {

					int length = 0;

					this.Movie_ID = dis.readInt();

					this.Crew_SK = dis.readInt();

					this.Profession_SK = dis.readInt();

					this.DI_CreatedDate = readDate(dis);

					this.DI_WorkflowJobId = readString(dis);

				} catch (IOException e) {
					throw new RuntimeException(e);

				}

			}

		}

		public void readData(org.jboss.marshalling.Unmarshaller dis) {

			synchronized (commonByteArrayLock_FINAL_PROJECT_bridge_crew_movie) {

				try {

					int length = 0;

					this.Movie_ID = dis.readInt();

					this.Crew_SK = dis.readInt();

					this.Profession_SK = dis.readInt();

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

				// int

				dos.writeInt(this.Crew_SK);

				// int

				dos.writeInt(this.Profession_SK);

				// java.util.Date

				writeDate(this.DI_CreatedDate, dos);

				// String

				writeString(this.DI_WorkflowJobId, dos);

			} catch (IOException e) {
				throw new RuntimeException(e);
			}

		}

		public void writeData(org.jboss.marshalling.Marshaller dos) {
			try {

				// int

				dos.writeInt(this.Movie_ID);

				// int

				dos.writeInt(this.Crew_SK);

				// int

				dos.writeInt(this.Profession_SK);

				// java.util.Date

				writeDate(this.DI_CreatedDate, dos);

				// String

				writeString(this.DI_WorkflowJobId, dos);

			} catch (IOException e) {
				throw new RuntimeException(e);
			}

		}

		public String toString() {

			StringBuilder sb = new StringBuilder();
			sb.append(super.toString());
			sb.append("[");
			sb.append("Movie_ID=" + String.valueOf(Movie_ID));
			sb.append(",Crew_SK=" + String.valueOf(Crew_SK));
			sb.append(",Profession_SK=" + String.valueOf(Profession_SK));
			sb.append(",DI_CreatedDate=" + String.valueOf(DI_CreatedDate));
			sb.append(",DI_WorkflowJobId=" + DI_WorkflowJobId);
			sb.append("]");

			return sb.toString();
		}

		public String toLogString() {
			StringBuilder sb = new StringBuilder();

			sb.append(Movie_ID);

			sb.append("|");

			sb.append(Crew_SK);

			sb.append("|");

			sb.append(Profession_SK);

			sb.append("|");

			if (DI_CreatedDate == null) {
				sb.append("<null>");
			} else {
				sb.append(DI_CreatedDate);
			}

			sb.append("|");

			if (DI_WorkflowJobId == null) {
				sb.append("<null>");
			} else {
				sb.append(DI_WorkflowJobId);
			}

			sb.append("|");

			return sb.toString();
		}

		/**
		 * Compare keys
		 */
		public int compareTo(row5Struct other) {

			int returnValue = -1;

			returnValue = checkNullsAndCompare(this.Movie_ID, other.Movie_ID);
			if (returnValue != 0) {
				return returnValue;
			}

			returnValue = checkNullsAndCompare(this.Crew_SK, other.Crew_SK);
			if (returnValue != 0) {
				return returnValue;
			}

			returnValue = checkNullsAndCompare(this.Profession_SK, other.Profession_SK);
			if (returnValue != 0) {
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

	public static class toTableStruct implements routines.system.IPersistableRow<toTableStruct> {
		final static byte[] commonByteArrayLock_FINAL_PROJECT_bridge_crew_movie = new byte[0];
		static byte[] commonByteArray_FINAL_PROJECT_bridge_crew_movie = new byte[0];
		protected static final int DEFAULT_HASHCODE = 1;
		protected static final int PRIME = 31;
		protected int hashCode = DEFAULT_HASHCODE;
		public boolean hashCodeDirty = true;

		public String loopKey;

		public int Movie_ID;

		public int getMovie_ID() {
			return this.Movie_ID;
		}

		public Boolean Movie_IDIsNullable() {
			return false;
		}

		public Boolean Movie_IDIsKey() {
			return true;
		}

		public Integer Movie_IDLength() {
			return null;
		}

		public Integer Movie_IDPrecision() {
			return null;
		}

		public String Movie_IDDefault() {

			return null;

		}

		public String Movie_IDComment() {

			return "";

		}

		public String Movie_IDPattern() {

			return "";

		}

		public String Movie_IDOriginalDbColumnName() {

			return "Movie_ID";

		}

		public int Crew_SK;

		public int getCrew_SK() {
			return this.Crew_SK;
		}

		public Boolean Crew_SKIsNullable() {
			return false;
		}

		public Boolean Crew_SKIsKey() {
			return true;
		}

		public Integer Crew_SKLength() {
			return null;
		}

		public Integer Crew_SKPrecision() {
			return null;
		}

		public String Crew_SKDefault() {

			return null;

		}

		public String Crew_SKComment() {

			return "";

		}

		public String Crew_SKPattern() {

			return "";

		}

		public String Crew_SKOriginalDbColumnName() {

			return "Crew_SK";

		}

		public int Profession_SK;

		public int getProfession_SK() {
			return this.Profession_SK;
		}

		public Boolean Profession_SKIsNullable() {
			return false;
		}

		public Boolean Profession_SKIsKey() {
			return true;
		}

		public Integer Profession_SKLength() {
			return null;
		}

		public Integer Profession_SKPrecision() {
			return null;
		}

		public String Profession_SKDefault() {

			return null;

		}

		public String Profession_SKComment() {

			return "";

		}

		public String Profession_SKPattern() {

			return "";

		}

		public String Profession_SKOriginalDbColumnName() {

			return "Profession_SK";

		}

		public java.util.Date DI_CreatedDate;

		public java.util.Date getDI_CreatedDate() {
			return this.DI_CreatedDate;
		}

		public Boolean DI_CreatedDateIsNullable() {
			return false;
		}

		public Boolean DI_CreatedDateIsKey() {
			return false;
		}

		public Integer DI_CreatedDateLength() {
			return null;
		}

		public Integer DI_CreatedDatePrecision() {
			return null;
		}

		public String DI_CreatedDateDefault() {

			return null;

		}

		public String DI_CreatedDateComment() {

			return "";

		}

		public String DI_CreatedDatePattern() {

			return "dd-MM-yyyy";

		}

		public String DI_CreatedDateOriginalDbColumnName() {

			return "DI_CreatedDate";

		}

		public String DI_WorkflowJobId;

		public String getDI_WorkflowJobId() {
			return this.DI_WorkflowJobId;
		}

		public Boolean DI_WorkflowJobIdIsNullable() {
			return false;
		}

		public Boolean DI_WorkflowJobIdIsKey() {
			return false;
		}

		public Integer DI_WorkflowJobIdLength() {
			return 8;
		}

		public Integer DI_WorkflowJobIdPrecision() {
			return null;
		}

		public String DI_WorkflowJobIdDefault() {

			return null;

		}

		public String DI_WorkflowJobIdComment() {

			return "";

		}

		public String DI_WorkflowJobIdPattern() {

			return "";

		}

		public String DI_WorkflowJobIdOriginalDbColumnName() {

			return "DI_WorkflowJobId";

		}

		@Override
		public int hashCode() {
			if (this.hashCodeDirty) {
				final int prime = PRIME;
				int result = DEFAULT_HASHCODE;

				result = prime * result + (int) this.Movie_ID;

				result = prime * result + (int) this.Crew_SK;

				result = prime * result + (int) this.Profession_SK;

				this.hashCode = result;
				this.hashCodeDirty = false;
			}
			return this.hashCode;
		}

		@Override
		public boolean equals(Object obj) {
			if (this == obj)
				return true;
			if (obj == null)
				return false;
			if (getClass() != obj.getClass())
				return false;
			final toTableStruct other = (toTableStruct) obj;

			if (this.Movie_ID != other.Movie_ID)
				return false;

			if (this.Crew_SK != other.Crew_SK)
				return false;

			if (this.Profession_SK != other.Profession_SK)
				return false;

			return true;
		}

		public void copyDataTo(toTableStruct other) {

			other.Movie_ID = this.Movie_ID;
			other.Crew_SK = this.Crew_SK;
			other.Profession_SK = this.Profession_SK;
			other.DI_CreatedDate = this.DI_CreatedDate;
			other.DI_WorkflowJobId = this.DI_WorkflowJobId;

		}

		public void copyKeysDataTo(toTableStruct other) {

			other.Movie_ID = this.Movie_ID;
			other.Crew_SK = this.Crew_SK;
			other.Profession_SK = this.Profession_SK;

		}

		private java.util.Date readDate(ObjectInputStream dis) throws IOException {
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

		private java.util.Date readDate(org.jboss.marshalling.Unmarshaller unmarshaller) throws IOException {
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

		private void writeDate(java.util.Date date1, ObjectOutputStream dos) throws IOException {
			if (date1 == null) {
				dos.writeByte(-1);
			} else {
				dos.writeByte(0);
				dos.writeLong(date1.getTime());
			}
		}

		private void writeDate(java.util.Date date1, org.jboss.marshalling.Marshaller marshaller) throws IOException {
			if (date1 == null) {
				marshaller.writeByte(-1);
			} else {
				marshaller.writeByte(0);
				marshaller.writeLong(date1.getTime());
			}
		}

		private String readString(ObjectInputStream dis) throws IOException {
			String strReturn = null;
			int length = 0;
			length = dis.readInt();
			if (length == -1) {
				strReturn = null;
			} else {
				if (length > commonByteArray_FINAL_PROJECT_bridge_crew_movie.length) {
					if (length < 1024 && commonByteArray_FINAL_PROJECT_bridge_crew_movie.length == 0) {
						commonByteArray_FINAL_PROJECT_bridge_crew_movie = new byte[1024];
					} else {
						commonByteArray_FINAL_PROJECT_bridge_crew_movie = new byte[2 * length];
					}
				}
				dis.readFully(commonByteArray_FINAL_PROJECT_bridge_crew_movie, 0, length);
				strReturn = new String(commonByteArray_FINAL_PROJECT_bridge_crew_movie, 0, length, utf8Charset);
			}
			return strReturn;
		}

		private String readString(org.jboss.marshalling.Unmarshaller unmarshaller) throws IOException {
			String strReturn = null;
			int length = 0;
			length = unmarshaller.readInt();
			if (length == -1) {
				strReturn = null;
			} else {
				if (length > commonByteArray_FINAL_PROJECT_bridge_crew_movie.length) {
					if (length < 1024 && commonByteArray_FINAL_PROJECT_bridge_crew_movie.length == 0) {
						commonByteArray_FINAL_PROJECT_bridge_crew_movie = new byte[1024];
					} else {
						commonByteArray_FINAL_PROJECT_bridge_crew_movie = new byte[2 * length];
					}
				}
				unmarshaller.readFully(commonByteArray_FINAL_PROJECT_bridge_crew_movie, 0, length);
				strReturn = new String(commonByteArray_FINAL_PROJECT_bridge_crew_movie, 0, length, utf8Charset);
			}
			return strReturn;
		}

		private void writeString(String str, ObjectOutputStream dos) throws IOException {
			if (str == null) {
				dos.writeInt(-1);
			} else {
				byte[] byteArray = str.getBytes(utf8Charset);
				dos.writeInt(byteArray.length);
				dos.write(byteArray);
			}
		}

		private void writeString(String str, org.jboss.marshalling.Marshaller marshaller) throws IOException {
			if (str == null) {
				marshaller.writeInt(-1);
			} else {
				byte[] byteArray = str.getBytes(utf8Charset);
				marshaller.writeInt(byteArray.length);
				marshaller.write(byteArray);
			}
		}

		public void readData(ObjectInputStream dis) {

			synchronized (commonByteArrayLock_FINAL_PROJECT_bridge_crew_movie) {

				try {

					int length = 0;

					this.Movie_ID = dis.readInt();

					this.Crew_SK = dis.readInt();

					this.Profession_SK = dis.readInt();

					this.DI_CreatedDate = readDate(dis);

					this.DI_WorkflowJobId = readString(dis);

				} catch (IOException e) {
					throw new RuntimeException(e);

				}

			}

		}

		public void readData(org.jboss.marshalling.Unmarshaller dis) {

			synchronized (commonByteArrayLock_FINAL_PROJECT_bridge_crew_movie) {

				try {

					int length = 0;

					this.Movie_ID = dis.readInt();

					this.Crew_SK = dis.readInt();

					this.Profession_SK = dis.readInt();

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

				// int

				dos.writeInt(this.Crew_SK);

				// int

				dos.writeInt(this.Profession_SK);

				// java.util.Date

				writeDate(this.DI_CreatedDate, dos);

				// String

				writeString(this.DI_WorkflowJobId, dos);

			} catch (IOException e) {
				throw new RuntimeException(e);
			}

		}

		public void writeData(org.jboss.marshalling.Marshaller dos) {
			try {

				// int

				dos.writeInt(this.Movie_ID);

				// int

				dos.writeInt(this.Crew_SK);

				// int

				dos.writeInt(this.Profession_SK);

				// java.util.Date

				writeDate(this.DI_CreatedDate, dos);

				// String

				writeString(this.DI_WorkflowJobId, dos);

			} catch (IOException e) {
				throw new RuntimeException(e);
			}

		}

		public String toString() {

			StringBuilder sb = new StringBuilder();
			sb.append(super.toString());
			sb.append("[");
			sb.append("Movie_ID=" + String.valueOf(Movie_ID));
			sb.append(",Crew_SK=" + String.valueOf(Crew_SK));
			sb.append(",Profession_SK=" + String.valueOf(Profession_SK));
			sb.append(",DI_CreatedDate=" + String.valueOf(DI_CreatedDate));
			sb.append(",DI_WorkflowJobId=" + DI_WorkflowJobId);
			sb.append("]");

			return sb.toString();
		}

		public String toLogString() {
			StringBuilder sb = new StringBuilder();

			sb.append(Movie_ID);

			sb.append("|");

			sb.append(Crew_SK);

			sb.append("|");

			sb.append(Profession_SK);

			sb.append("|");

			if (DI_CreatedDate == null) {
				sb.append("<null>");
			} else {
				sb.append(DI_CreatedDate);
			}

			sb.append("|");

			if (DI_WorkflowJobId == null) {
				sb.append("<null>");
			} else {
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
			if (returnValue != 0) {
				return returnValue;
			}

			returnValue = checkNullsAndCompare(this.Crew_SK, other.Crew_SK);
			if (returnValue != 0) {
				return returnValue;
			}

			returnValue = checkNullsAndCompare(this.Profession_SK, other.Profession_SK);
			if (returnValue != 0) {
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
		final static byte[] commonByteArrayLock_FINAL_PROJECT_bridge_crew_movie = new byte[0];
		static byte[] commonByteArray_FINAL_PROJECT_bridge_crew_movie = new byte[0];

		public String tconst;

		public String getTconst() {
			return this.tconst;
		}

		public Boolean tconstIsNullable() {
			return false;
		}

		public Boolean tconstIsKey() {
			return false;
		}

		public Integer tconstLength() {
			return 10;
		}

		public Integer tconstPrecision() {
			return 0;
		}

		public String tconstDefault() {

			return null;

		}

		public String tconstComment() {

			return "";

		}

		public String tconstPattern() {

			return "";

		}

		public String tconstOriginalDbColumnName() {

			return "tconst";

		}

		public String nconst;

		public String getNconst() {
			return this.nconst;
		}

		public Boolean nconstIsNullable() {
			return true;
		}

		public Boolean nconstIsKey() {
			return false;
		}

		public Integer nconstLength() {
			return 10;
		}

		public Integer nconstPrecision() {
			return 0;
		}

		public String nconstDefault() {

			return null;

		}

		public String nconstComment() {

			return "";

		}

		public String nconstPattern() {

			return "";

		}

		public String nconstOriginalDbColumnName() {

			return "nconst";

		}

		public String category;

		public String getCategory() {
			return this.category;
		}

		public Boolean categoryIsNullable() {
			return true;
		}

		public Boolean categoryIsKey() {
			return false;
		}

		public Integer categoryLength() {
			return 255;
		}

		public Integer categoryPrecision() {
			return 0;
		}

		public String categoryDefault() {

			return null;

		}

		public String categoryComment() {

			return "";

		}

		public String categoryPattern() {

			return "";

		}

		public String categoryOriginalDbColumnName() {

			return "category";

		}

		private String readString(ObjectInputStream dis) throws IOException {
			String strReturn = null;
			int length = 0;
			length = dis.readInt();
			if (length == -1) {
				strReturn = null;
			} else {
				if (length > commonByteArray_FINAL_PROJECT_bridge_crew_movie.length) {
					if (length < 1024 && commonByteArray_FINAL_PROJECT_bridge_crew_movie.length == 0) {
						commonByteArray_FINAL_PROJECT_bridge_crew_movie = new byte[1024];
					} else {
						commonByteArray_FINAL_PROJECT_bridge_crew_movie = new byte[2 * length];
					}
				}
				dis.readFully(commonByteArray_FINAL_PROJECT_bridge_crew_movie, 0, length);
				strReturn = new String(commonByteArray_FINAL_PROJECT_bridge_crew_movie, 0, length, utf8Charset);
			}
			return strReturn;
		}

		private String readString(org.jboss.marshalling.Unmarshaller unmarshaller) throws IOException {
			String strReturn = null;
			int length = 0;
			length = unmarshaller.readInt();
			if (length == -1) {
				strReturn = null;
			} else {
				if (length > commonByteArray_FINAL_PROJECT_bridge_crew_movie.length) {
					if (length < 1024 && commonByteArray_FINAL_PROJECT_bridge_crew_movie.length == 0) {
						commonByteArray_FINAL_PROJECT_bridge_crew_movie = new byte[1024];
					} else {
						commonByteArray_FINAL_PROJECT_bridge_crew_movie = new byte[2 * length];
					}
				}
				unmarshaller.readFully(commonByteArray_FINAL_PROJECT_bridge_crew_movie, 0, length);
				strReturn = new String(commonByteArray_FINAL_PROJECT_bridge_crew_movie, 0, length, utf8Charset);
			}
			return strReturn;
		}

		private void writeString(String str, ObjectOutputStream dos) throws IOException {
			if (str == null) {
				dos.writeInt(-1);
			} else {
				byte[] byteArray = str.getBytes(utf8Charset);
				dos.writeInt(byteArray.length);
				dos.write(byteArray);
			}
		}

		private void writeString(String str, org.jboss.marshalling.Marshaller marshaller) throws IOException {
			if (str == null) {
				marshaller.writeInt(-1);
			} else {
				byte[] byteArray = str.getBytes(utf8Charset);
				marshaller.writeInt(byteArray.length);
				marshaller.write(byteArray);
			}
		}

		public void readData(ObjectInputStream dis) {

			synchronized (commonByteArrayLock_FINAL_PROJECT_bridge_crew_movie) {

				try {

					int length = 0;

					this.tconst = readString(dis);

					this.nconst = readString(dis);

					this.category = readString(dis);

				} catch (IOException e) {
					throw new RuntimeException(e);

				}

			}

		}

		public void readData(org.jboss.marshalling.Unmarshaller dis) {

			synchronized (commonByteArrayLock_FINAL_PROJECT_bridge_crew_movie) {

				try {

					int length = 0;

					this.tconst = readString(dis);

					this.nconst = readString(dis);

					this.category = readString(dis);

				} catch (IOException e) {
					throw new RuntimeException(e);

				}

			}

		}

		public void writeData(ObjectOutputStream dos) {
			try {

				// String

				writeString(this.tconst, dos);

				// String

				writeString(this.nconst, dos);

				// String

				writeString(this.category, dos);

			} catch (IOException e) {
				throw new RuntimeException(e);
			}

		}

		public void writeData(org.jboss.marshalling.Marshaller dos) {
			try {

				// String

				writeString(this.tconst, dos);

				// String

				writeString(this.nconst, dos);

				// String

				writeString(this.category, dos);

			} catch (IOException e) {
				throw new RuntimeException(e);
			}

		}

		public String toString() {

			StringBuilder sb = new StringBuilder();
			sb.append(super.toString());
			sb.append("[");
			sb.append("tconst=" + tconst);
			sb.append(",nconst=" + nconst);
			sb.append(",category=" + category);
			sb.append("]");

			return sb.toString();
		}

		public String toLogString() {
			StringBuilder sb = new StringBuilder();

			if (tconst == null) {
				sb.append("<null>");
			} else {
				sb.append(tconst);
			}

			sb.append("|");

			if (nconst == null) {
				sb.append("<null>");
			} else {
				sb.append(nconst);
			}

			sb.append("|");

			if (category == null) {
				sb.append("<null>");
			} else {
				sb.append(category);
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

	public static class after_tDBInput_3Struct implements routines.system.IPersistableRow<after_tDBInput_3Struct> {
		final static byte[] commonByteArrayLock_FINAL_PROJECT_bridge_crew_movie = new byte[0];
		static byte[] commonByteArray_FINAL_PROJECT_bridge_crew_movie = new byte[0];

		public String tconst;

		public String getTconst() {
			return this.tconst;
		}

		public Boolean tconstIsNullable() {
			return false;
		}

		public Boolean tconstIsKey() {
			return false;
		}

		public Integer tconstLength() {
			return 10;
		}

		public Integer tconstPrecision() {
			return 0;
		}

		public String tconstDefault() {

			return null;

		}

		public String tconstComment() {

			return "";

		}

		public String tconstPattern() {

			return "";

		}

		public String tconstOriginalDbColumnName() {

			return "tconst";

		}

		public String nconst;

		public String getNconst() {
			return this.nconst;
		}

		public Boolean nconstIsNullable() {
			return true;
		}

		public Boolean nconstIsKey() {
			return false;
		}

		public Integer nconstLength() {
			return 10;
		}

		public Integer nconstPrecision() {
			return 0;
		}

		public String nconstDefault() {

			return null;

		}

		public String nconstComment() {

			return "";

		}

		public String nconstPattern() {

			return "";

		}

		public String nconstOriginalDbColumnName() {

			return "nconst";

		}

		public String category;

		public String getCategory() {
			return this.category;
		}

		public Boolean categoryIsNullable() {
			return true;
		}

		public Boolean categoryIsKey() {
			return false;
		}

		public Integer categoryLength() {
			return 255;
		}

		public Integer categoryPrecision() {
			return 0;
		}

		public String categoryDefault() {

			return null;

		}

		public String categoryComment() {

			return "";

		}

		public String categoryPattern() {

			return "";

		}

		public String categoryOriginalDbColumnName() {

			return "category";

		}

		private String readString(ObjectInputStream dis) throws IOException {
			String strReturn = null;
			int length = 0;
			length = dis.readInt();
			if (length == -1) {
				strReturn = null;
			} else {
				if (length > commonByteArray_FINAL_PROJECT_bridge_crew_movie.length) {
					if (length < 1024 && commonByteArray_FINAL_PROJECT_bridge_crew_movie.length == 0) {
						commonByteArray_FINAL_PROJECT_bridge_crew_movie = new byte[1024];
					} else {
						commonByteArray_FINAL_PROJECT_bridge_crew_movie = new byte[2 * length];
					}
				}
				dis.readFully(commonByteArray_FINAL_PROJECT_bridge_crew_movie, 0, length);
				strReturn = new String(commonByteArray_FINAL_PROJECT_bridge_crew_movie, 0, length, utf8Charset);
			}
			return strReturn;
		}

		private String readString(org.jboss.marshalling.Unmarshaller unmarshaller) throws IOException {
			String strReturn = null;
			int length = 0;
			length = unmarshaller.readInt();
			if (length == -1) {
				strReturn = null;
			} else {
				if (length > commonByteArray_FINAL_PROJECT_bridge_crew_movie.length) {
					if (length < 1024 && commonByteArray_FINAL_PROJECT_bridge_crew_movie.length == 0) {
						commonByteArray_FINAL_PROJECT_bridge_crew_movie = new byte[1024];
					} else {
						commonByteArray_FINAL_PROJECT_bridge_crew_movie = new byte[2 * length];
					}
				}
				unmarshaller.readFully(commonByteArray_FINAL_PROJECT_bridge_crew_movie, 0, length);
				strReturn = new String(commonByteArray_FINAL_PROJECT_bridge_crew_movie, 0, length, utf8Charset);
			}
			return strReturn;
		}

		private void writeString(String str, ObjectOutputStream dos) throws IOException {
			if (str == null) {
				dos.writeInt(-1);
			} else {
				byte[] byteArray = str.getBytes(utf8Charset);
				dos.writeInt(byteArray.length);
				dos.write(byteArray);
			}
		}

		private void writeString(String str, org.jboss.marshalling.Marshaller marshaller) throws IOException {
			if (str == null) {
				marshaller.writeInt(-1);
			} else {
				byte[] byteArray = str.getBytes(utf8Charset);
				marshaller.writeInt(byteArray.length);
				marshaller.write(byteArray);
			}
		}

		public void readData(ObjectInputStream dis) {

			synchronized (commonByteArrayLock_FINAL_PROJECT_bridge_crew_movie) {

				try {

					int length = 0;

					this.tconst = readString(dis);

					this.nconst = readString(dis);

					this.category = readString(dis);

				} catch (IOException e) {
					throw new RuntimeException(e);

				}

			}

		}

		public void readData(org.jboss.marshalling.Unmarshaller dis) {

			synchronized (commonByteArrayLock_FINAL_PROJECT_bridge_crew_movie) {

				try {

					int length = 0;

					this.tconst = readString(dis);

					this.nconst = readString(dis);

					this.category = readString(dis);

				} catch (IOException e) {
					throw new RuntimeException(e);

				}

			}

		}

		public void writeData(ObjectOutputStream dos) {
			try {

				// String

				writeString(this.tconst, dos);

				// String

				writeString(this.nconst, dos);

				// String

				writeString(this.category, dos);

			} catch (IOException e) {
				throw new RuntimeException(e);
			}

		}

		public void writeData(org.jboss.marshalling.Marshaller dos) {
			try {

				// String

				writeString(this.tconst, dos);

				// String

				writeString(this.nconst, dos);

				// String

				writeString(this.category, dos);

			} catch (IOException e) {
				throw new RuntimeException(e);
			}

		}

		public String toString() {

			StringBuilder sb = new StringBuilder();
			sb.append(super.toString());
			sb.append("[");
			sb.append("tconst=" + tconst);
			sb.append(",nconst=" + nconst);
			sb.append(",category=" + category);
			sb.append("]");

			return sb.toString();
		}

		public String toLogString() {
			StringBuilder sb = new StringBuilder();

			if (tconst == null) {
				sb.append("<null>");
			} else {
				sb.append(tconst);
			}

			sb.append("|");

			if (nconst == null) {
				sb.append("<null>");
			} else {
				sb.append(nconst);
			}

			sb.append("|");

			if (category == null) {
				sb.append("<null>");
			} else {
				sb.append(category);
			}

			sb.append("|");

			return sb.toString();
		}

		/**
		 * Compare keys
		 */
		public int compareTo(after_tDBInput_3Struct other) {

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
		org.slf4j.MDC.put("_subJobPid", "uWmYAi_" + subJobPidCounter.getAndIncrement());

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

				tDBInput_1Process(globalMap);
				tDBInput_4Process(globalMap);
				tDBInput_5Process(globalMap);

				row1Struct row1 = new row1Struct();
				toTableStruct toTable = new toTableStruct();
				row5Struct row5 = new row5Struct();

				/**
				 * [tDBOutput_1 begin ] start
				 */

				ok_Hash.put("tDBOutput_1", false);
				start_Hash.put("tDBOutput_1", System.currentTimeMillis());

				currentComponent = "tDBOutput_1";

				cLabel = "\"bridge_crew_movie\"";

				runStat.updateStatAndLog(execStat, enableLogStash, resourceMap, iterateId, 0, 0, "row5");

				int tos_count_tDBOutput_1 = 0;

				if (log.isDebugEnabled())
					log.debug("tDBOutput_1 - " + ("Start to work."));
				if (log.isDebugEnabled()) {
					class BytesLimit65535_tDBOutput_1 {
						public void limitLog4jByte() throws Exception {
							StringBuilder log4jParamters_tDBOutput_1 = new StringBuilder();
							log4jParamters_tDBOutput_1.append("Parameters:");
							log4jParamters_tDBOutput_1.append("DB_VERSION" + " = " + "MYSQL_8");
							log4jParamters_tDBOutput_1.append(" | ");
							log4jParamters_tDBOutput_1.append("USE_EXISTING_CONNECTION" + " = " + "false");
							log4jParamters_tDBOutput_1.append(" | ");
							log4jParamters_tDBOutput_1.append("HOST" + " = " + "\"127.0.0.1\"");
							log4jParamters_tDBOutput_1.append(" | ");
							log4jParamters_tDBOutput_1.append("PORT" + " = " + "\"3306\"");
							log4jParamters_tDBOutput_1.append(" | ");
							log4jParamters_tDBOutput_1.append("DBNAME" + " = " + "\"imdb_src\"");
							log4jParamters_tDBOutput_1.append(" | ");
							log4jParamters_tDBOutput_1.append("USER" + " = " + "\"user2\"");
							log4jParamters_tDBOutput_1.append(" | ");
							log4jParamters_tDBOutput_1.append("PASS" + " = " + String.valueOf(
									"enc:routine.encryption.key.v1:M8cfT2T9HXraoUFlUMnx0sHT/QAolw0GgXFfVHgiM5zYZOea")
									.substring(0, 4) + "...");
							log4jParamters_tDBOutput_1.append(" | ");
							log4jParamters_tDBOutput_1.append("TABLE" + " = " + "\"bridge_crew_movie\"");
							log4jParamters_tDBOutput_1.append(" | ");
							log4jParamters_tDBOutput_1.append("TABLE_ACTION" + " = " + "CREATE_IF_NOT_EXISTS");
							log4jParamters_tDBOutput_1.append(" | ");
							log4jParamters_tDBOutput_1.append("DATA_ACTION" + " = " + "INSERT");
							log4jParamters_tDBOutput_1.append(" | ");
							log4jParamters_tDBOutput_1.append("SPECIFY_DATASOURCE_ALIAS" + " = " + "false");
							log4jParamters_tDBOutput_1.append(" | ");
							log4jParamters_tDBOutput_1.append("DIE_ON_ERROR" + " = " + "false");
							log4jParamters_tDBOutput_1.append(" | ");
							log4jParamters_tDBOutput_1.append("PROPERTIES" + " = "
									+ "\"noDatetimeStringSync=true&enabledTLSProtocols=TLSv1.2,TLSv1.1,TLSv1\"");
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
							if (log.isDebugEnabled())
								log.debug("tDBOutput_1 - " + (log4jParamters_tDBOutput_1));
						}
					}
					new BytesLimit65535_tDBOutput_1().limitLog4jByte();
				}
				if (enableLogStash) {
					talendJobLog.addCM("tDBOutput_1", "\"bridge_crew_movie\"", "tMysqlOutput");
					talendJobLogProcess(globalMap);
				}

				int nb_line_tDBOutput_1 = 0;
				int nb_line_update_tDBOutput_1 = 0;
				int nb_line_inserted_tDBOutput_1 = 0;
				int nb_line_deleted_tDBOutput_1 = 0;
				int nb_line_rejected_tDBOutput_1 = 0;

				int deletedCount_tDBOutput_1 = 0;
				int updatedCount_tDBOutput_1 = 0;
				int insertedCount_tDBOutput_1 = 0;
				int rowsToCommitCount_tDBOutput_1 = 0;
				int rejectedCount_tDBOutput_1 = 0;

				String tableName_tDBOutput_1 = "bridge_crew_movie";
				boolean whetherReject_tDBOutput_1 = false;

				java.util.Calendar calendar_tDBOutput_1 = java.util.Calendar.getInstance();
				calendar_tDBOutput_1.set(1, 0, 1, 0, 0, 0);
				long year1_tDBOutput_1 = calendar_tDBOutput_1.getTime().getTime();
				calendar_tDBOutput_1.set(10000, 0, 1, 0, 0, 0);
				long year10000_tDBOutput_1 = calendar_tDBOutput_1.getTime().getTime();
				long date_tDBOutput_1;

				java.sql.Connection conn_tDBOutput_1 = null;

				String properties_tDBOutput_1 = "noDatetimeStringSync=true&enabledTLSProtocols=TLSv1.2,TLSv1.1,TLSv1";
				if (properties_tDBOutput_1 == null || properties_tDBOutput_1.trim().length() == 0) {
					properties_tDBOutput_1 = "rewriteBatchedStatements=true&allowLoadLocalInfile=true";
				} else {
					if (!properties_tDBOutput_1.contains("rewriteBatchedStatements=")) {
						properties_tDBOutput_1 += "&rewriteBatchedStatements=true";
					}

					if (!properties_tDBOutput_1.contains("allowLoadLocalInfile=")) {
						properties_tDBOutput_1 += "&allowLoadLocalInfile=true";
					}
				}

				String url_tDBOutput_1 = "jdbc:mysql://" + "127.0.0.1" + ":" + "3306" + "/" + "imdb_src" + "?"
						+ properties_tDBOutput_1;

				String driverClass_tDBOutput_1 = "com.mysql.cj.jdbc.Driver";

				if (log.isDebugEnabled())
					log.debug("tDBOutput_1 - " + ("Driver ClassName: ") + (driverClass_tDBOutput_1) + ("."));
				String dbUser_tDBOutput_1 = "user2";

				final String decryptedPassword_tDBOutput_1 = routines.system.PasswordEncryptUtil.decryptPassword(
						"enc:routine.encryption.key.v1:vqvLRO3s5XhMezKTxKRrKXb/qzGQEXh1vx7mjVI6iWoOeShe");

				String dbPwd_tDBOutput_1 = decryptedPassword_tDBOutput_1;
				java.lang.Class.forName(driverClass_tDBOutput_1);

				if (log.isDebugEnabled())
					log.debug("tDBOutput_1 - " + ("Connection attempts to '") + (url_tDBOutput_1)
							+ ("' with the username '") + (dbUser_tDBOutput_1) + ("'."));
				conn_tDBOutput_1 = java.sql.DriverManager.getConnection(url_tDBOutput_1, dbUser_tDBOutput_1,
						dbPwd_tDBOutput_1);

				if (log.isDebugEnabled())
					log.debug("tDBOutput_1 - " + ("Connection to '") + (url_tDBOutput_1) + ("' has succeeded."));

				resourceMap.put("conn_tDBOutput_1", conn_tDBOutput_1);

				conn_tDBOutput_1.setAutoCommit(false);
				int commitEvery_tDBOutput_1 = 10000;
				int commitCounter_tDBOutput_1 = 0;

				if (log.isDebugEnabled())
					log.debug("tDBOutput_1 - " + ("Connection is set auto commit to '")
							+ (conn_tDBOutput_1.getAutoCommit()) + ("'."));

				int count_tDBOutput_1 = 0;

				java.sql.DatabaseMetaData dbMetaData_tDBOutput_1 = conn_tDBOutput_1.getMetaData();
				java.sql.ResultSet rsTable_tDBOutput_1 = dbMetaData_tDBOutput_1.getTables("imdb_src", null, null,
						new String[] { "TABLE" });
				boolean whetherExist_tDBOutput_1 = false;
				while (rsTable_tDBOutput_1.next()) {
					String table_tDBOutput_1 = rsTable_tDBOutput_1.getString("TABLE_NAME");
					if (table_tDBOutput_1.equalsIgnoreCase("bridge_crew_movie")) {
						whetherExist_tDBOutput_1 = true;
						break;
					}
				}
				if (!whetherExist_tDBOutput_1) {
					try (java.sql.Statement stmtCreate_tDBOutput_1 = conn_tDBOutput_1.createStatement()) {
						if (log.isDebugEnabled())
							log.debug(
									"tDBOutput_1 - " + ("Creating") + (" table '") + (tableName_tDBOutput_1) + ("'."));
						stmtCreate_tDBOutput_1.execute("CREATE TABLE `" + tableName_tDBOutput_1
								+ "`(`Movie_ID` INT(0)   not null ,`Crew_SK` INT(0)   not null ,`Profession_SK` INT(0)   not null ,`DI_CreatedDate` DATETIME  not null ,`DI_WorkflowJobId` VARCHAR(8)   not null ,primary key(`Movie_ID`,`Crew_SK`,`Profession_SK`))");
						if (log.isDebugEnabled())
							log.debug("tDBOutput_1 - " + ("Create") + (" table '") + (tableName_tDBOutput_1)
									+ ("' has succeeded."));
					}
				}

				String insert_tDBOutput_1 = "INSERT INTO `" + "bridge_crew_movie"
						+ "` (`Movie_ID`,`Crew_SK`,`Profession_SK`,`DI_CreatedDate`,`DI_WorkflowJobId`) VALUES (?,?,?,?,?)";

				int batchSize_tDBOutput_1 = 100;
				int batchSizeCounter_tDBOutput_1 = 0;

				java.sql.PreparedStatement pstmt_tDBOutput_1 = conn_tDBOutput_1.prepareStatement(insert_tDBOutput_1);
				resourceMap.put("pstmt_tDBOutput_1", pstmt_tDBOutput_1);

				/**
				 * [tDBOutput_1 begin ] stop
				 */

				/**
				 * [tUniqRow_1 begin ] start
				 */

				ok_Hash.put("tUniqRow_1", false);
				start_Hash.put("tUniqRow_1", System.currentTimeMillis());

				currentComponent = "tUniqRow_1";

				runStat.updateStatAndLog(execStat, enableLogStash, resourceMap, iterateId, 0, 0, "toTable");

				int tos_count_tUniqRow_1 = 0;

				if (log.isDebugEnabled())
					log.debug("tUniqRow_1 - " + ("Start to work."));
				if (log.isDebugEnabled()) {
					class BytesLimit65535_tUniqRow_1 {
						public void limitLog4jByte() throws Exception {
							StringBuilder log4jParamters_tUniqRow_1 = new StringBuilder();
							log4jParamters_tUniqRow_1.append("Parameters:");
							log4jParamters_tUniqRow_1.append("UNIQUE_KEY" + " = " + "[{CASE_SENSITIVE=" + ("false")
									+ ", KEY_ATTRIBUTE=" + ("true") + ", SCHEMA_COLUMN=" + ("Movie_ID")
									+ "}, {CASE_SENSITIVE=" + ("false") + ", KEY_ATTRIBUTE=" + ("true")
									+ ", SCHEMA_COLUMN=" + ("Crew_SK") + "}, {CASE_SENSITIVE=" + ("false")
									+ ", KEY_ATTRIBUTE=" + ("true") + ", SCHEMA_COLUMN=" + ("Profession_SK")
									+ "}, {CASE_SENSITIVE=" + ("false") + ", KEY_ATTRIBUTE=" + ("false")
									+ ", SCHEMA_COLUMN=" + ("DI_CreatedDate") + "}, {CASE_SENSITIVE=" + ("false")
									+ ", KEY_ATTRIBUTE=" + ("false") + ", SCHEMA_COLUMN=" + ("DI_WorkflowJobId")
									+ "}]");
							log4jParamters_tUniqRow_1.append(" | ");
							log4jParamters_tUniqRow_1.append("ONLY_ONCE_EACH_DUPLICATED_KEY" + " = " + "false");
							log4jParamters_tUniqRow_1.append(" | ");
							log4jParamters_tUniqRow_1.append("IS_VIRTUAL_COMPONENT" + " = " + "false");
							log4jParamters_tUniqRow_1.append(" | ");
							log4jParamters_tUniqRow_1.append("CHANGE_HASH_AND_EQUALS_FOR_BIGDECIMAL" + " = " + "false");
							log4jParamters_tUniqRow_1.append(" | ");
							if (log.isDebugEnabled())
								log.debug("tUniqRow_1 - " + (log4jParamters_tUniqRow_1));
						}
					}
					new BytesLimit65535_tUniqRow_1().limitLog4jByte();
				}
				if (enableLogStash) {
					talendJobLog.addCM("tUniqRow_1", "tUniqRow_1", "tUniqRow");
					talendJobLogProcess(globalMap);
				}

				class KeyStruct_tUniqRow_1 {

					private static final int DEFAULT_HASHCODE = 1;
					private static final int PRIME = 31;
					private int hashCode = DEFAULT_HASHCODE;
					public boolean hashCodeDirty = true;

					int Movie_ID;
					int Crew_SK;
					int Profession_SK;

					@Override
					public int hashCode() {
						if (this.hashCodeDirty) {
							final int prime = PRIME;
							int result = DEFAULT_HASHCODE;

							result = prime * result + (int) this.Movie_ID;

							result = prime * result + (int) this.Crew_SK;

							result = prime * result + (int) this.Profession_SK;

							this.hashCode = result;
							this.hashCodeDirty = false;
						}
						return this.hashCode;
					}

					@Override
					public boolean equals(Object obj) {
						if (this == obj)
							return true;
						if (obj == null)
							return false;
						if (getClass() != obj.getClass())
							return false;
						final KeyStruct_tUniqRow_1 other = (KeyStruct_tUniqRow_1) obj;

						if (this.Movie_ID != other.Movie_ID)
							return false;

						if (this.Crew_SK != other.Crew_SK)
							return false;

						if (this.Profession_SK != other.Profession_SK)
							return false;

						return true;
					}

				}

				int nb_uniques_tUniqRow_1 = 0;
				int nb_duplicates_tUniqRow_1 = 0;
				log.debug("tUniqRow_1 - Start to process the data from datasource.");
				KeyStruct_tUniqRow_1 finder_tUniqRow_1 = new KeyStruct_tUniqRow_1();
				java.util.Set<KeyStruct_tUniqRow_1> keystUniqRow_1 = new java.util.HashSet<KeyStruct_tUniqRow_1>();

				/**
				 * [tUniqRow_1 begin ] stop
				 */

				/**
				 * [tMap_1 begin ] start
				 */

				ok_Hash.put("tMap_1", false);
				start_Hash.put("tMap_1", System.currentTimeMillis());

				currentComponent = "tMap_1";

				runStat.updateStatAndLog(execStat, enableLogStash, resourceMap, iterateId, 0, 0, "row1");

				int tos_count_tMap_1 = 0;

				if (log.isDebugEnabled())
					log.debug("tMap_1 - " + ("Start to work."));
				if (log.isDebugEnabled()) {
					class BytesLimit65535_tMap_1 {
						public void limitLog4jByte() throws Exception {
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
							if (log.isDebugEnabled())
								log.debug("tMap_1 - " + (log4jParamters_tMap_1));
						}
					}
					new BytesLimit65535_tMap_1().limitLog4jByte();
				}
				if (enableLogStash) {
					talendJobLog.addCM("tMap_1", "tMap_1", "tMap");
					talendJobLogProcess(globalMap);
				}

// ###############################
// # Lookup's keys initialization
				int count_row1_tMap_1 = 0;

				int count_row2_tMap_1 = 0;

				int count_row3_tMap_1 = 0;

				int count_row4_tMap_1 = 0;

				org.talend.designer.components.lookup.memory.AdvancedMemoryLookup<row2Struct> tHash_Lookup_row2 = (org.talend.designer.components.lookup.memory.AdvancedMemoryLookup<row2Struct>) ((org.talend.designer.components.lookup.memory.AdvancedMemoryLookup<row2Struct>) globalMap
						.get("tHash_Lookup_row2"));

				row2Struct row2HashKey = new row2Struct();
				row2Struct row2Default = new row2Struct();

				org.talend.designer.components.lookup.memory.AdvancedMemoryLookup<row3Struct> tHash_Lookup_row3 = (org.talend.designer.components.lookup.memory.AdvancedMemoryLookup<row3Struct>) ((org.talend.designer.components.lookup.memory.AdvancedMemoryLookup<row3Struct>) globalMap
						.get("tHash_Lookup_row3"));

				row3Struct row3HashKey = new row3Struct();
				row3Struct row3Default = new row3Struct();

				org.talend.designer.components.lookup.memory.AdvancedMemoryLookup<row4Struct> tHash_Lookup_row4 = (org.talend.designer.components.lookup.memory.AdvancedMemoryLookup<row4Struct>) ((org.talend.designer.components.lookup.memory.AdvancedMemoryLookup<row4Struct>) globalMap
						.get("tHash_Lookup_row4"));

				row4Struct row4HashKey = new row4Struct();
				row4Struct row4Default = new row4Struct();
// ###############################        

// ###############################
// # Vars initialization
				class Var__tMap_1__Struct {
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
				 * [tDBInput_3 begin ] start
				 */

				ok_Hash.put("tDBInput_3", false);
				start_Hash.put("tDBInput_3", System.currentTimeMillis());

				currentComponent = "tDBInput_3";

				cLabel = "\"stg_crew_list\"";

				int tos_count_tDBInput_3 = 0;

				if (log.isDebugEnabled())
					log.debug("tDBInput_3 - " + ("Start to work."));
				if (log.isDebugEnabled()) {
					class BytesLimit65535_tDBInput_3 {
						public void limitLog4jByte() throws Exception {
							StringBuilder log4jParamters_tDBInput_3 = new StringBuilder();
							log4jParamters_tDBInput_3.append("Parameters:");
							log4jParamters_tDBInput_3.append("DB_VERSION" + " = " + "MYSQL_8");
							log4jParamters_tDBInput_3.append(" | ");
							log4jParamters_tDBInput_3.append("USE_EXISTING_CONNECTION" + " = " + "false");
							log4jParamters_tDBInput_3.append(" | ");
							log4jParamters_tDBInput_3.append("HOST" + " = " + "\"127.0.0.1\"");
							log4jParamters_tDBInput_3.append(" | ");
							log4jParamters_tDBInput_3.append("PORT" + " = " + "\"3306\"");
							log4jParamters_tDBInput_3.append(" | ");
							log4jParamters_tDBInput_3.append("DBNAME" + " = " + "\"imdb_src\"");
							log4jParamters_tDBInput_3.append(" | ");
							log4jParamters_tDBInput_3.append("USER" + " = " + "\"user2\"");
							log4jParamters_tDBInput_3.append(" | ");
							log4jParamters_tDBInput_3.append("PASS" + " = " + String.valueOf(
									"enc:routine.encryption.key.v1:fO6H/o9KMqW6KXgtKxWcx46s1Jg+CQS4Doi6yuCnB6cAqS6z")
									.substring(0, 4) + "...");
							log4jParamters_tDBInput_3.append(" | ");
							log4jParamters_tDBInput_3.append("TABLE" + " = " + "\"stg_crew_list\"");
							log4jParamters_tDBInput_3.append(" | ");
							log4jParamters_tDBInput_3.append("QUERYSTORE" + " = " + "\"\"");
							log4jParamters_tDBInput_3.append(" | ");
							log4jParamters_tDBInput_3.append("QUERY" + " = "
									+ "\"SELECT    `stg_crew_list`.`tconst`,     `stg_crew_list`.`nconst`,    `stg_crew_list`.`category` FROM `stg_crew_list`\"");
							log4jParamters_tDBInput_3.append(" | ");
							log4jParamters_tDBInput_3.append("SPECIFY_DATASOURCE_ALIAS" + " = " + "false");
							log4jParamters_tDBInput_3.append(" | ");
							log4jParamters_tDBInput_3.append("PROPERTIES" + " = "
									+ "\"noDatetimeStringSync=true&enabledTLSProtocols=TLSv1.2,TLSv1.1,TLSv1\"");
							log4jParamters_tDBInput_3.append(" | ");
							log4jParamters_tDBInput_3.append("ENABLE_STREAM" + " = " + "false");
							log4jParamters_tDBInput_3.append(" | ");
							log4jParamters_tDBInput_3.append("TRIM_ALL_COLUMN" + " = " + "false");
							log4jParamters_tDBInput_3.append(" | ");
							log4jParamters_tDBInput_3.append("TRIM_COLUMN" + " = " + "[{TRIM=" + ("false")
									+ ", SCHEMA_COLUMN=" + ("tconst") + "}, {TRIM=" + ("false") + ", SCHEMA_COLUMN="
									+ ("nconst") + "}, {TRIM=" + ("false") + ", SCHEMA_COLUMN=" + ("category") + "}]");
							log4jParamters_tDBInput_3.append(" | ");
							log4jParamters_tDBInput_3.append("UNIFIED_COMPONENTS" + " = " + "tMysqlInput");
							log4jParamters_tDBInput_3.append(" | ");
							if (log.isDebugEnabled())
								log.debug("tDBInput_3 - " + (log4jParamters_tDBInput_3));
						}
					}
					new BytesLimit65535_tDBInput_3().limitLog4jByte();
				}
				if (enableLogStash) {
					talendJobLog.addCM("tDBInput_3", "\"stg_crew_list\"", "tMysqlInput");
					talendJobLogProcess(globalMap);
				}

				java.util.Calendar calendar_tDBInput_3 = java.util.Calendar.getInstance();
				calendar_tDBInput_3.set(0, 0, 0, 0, 0, 0);
				java.util.Date year0_tDBInput_3 = calendar_tDBInput_3.getTime();
				int nb_line_tDBInput_3 = 0;
				java.sql.Connection conn_tDBInput_3 = null;
				String driverClass_tDBInput_3 = "com.mysql.cj.jdbc.Driver";
				java.lang.Class jdbcclazz_tDBInput_3 = java.lang.Class.forName(driverClass_tDBInput_3);
				String dbUser_tDBInput_3 = "user2";

				final String decryptedPassword_tDBInput_3 = routines.system.PasswordEncryptUtil.decryptPassword(
						"enc:routine.encryption.key.v1:vHr2ohAY5esXoja+IWwe/FApXCD/WnOGp1QO16ves3wXRf9F");

				String dbPwd_tDBInput_3 = decryptedPassword_tDBInput_3;

				String properties_tDBInput_3 = "noDatetimeStringSync=true&enabledTLSProtocols=TLSv1.2,TLSv1.1,TLSv1";
				if (properties_tDBInput_3 == null || properties_tDBInput_3.trim().length() == 0) {
					properties_tDBInput_3 = "";
				}
				String url_tDBInput_3 = "jdbc:mysql://" + "127.0.0.1" + ":" + "3306" + "/" + "imdb_src" + "?"
						+ properties_tDBInput_3;

				log.debug("tDBInput_3 - Driver ClassName: " + driverClass_tDBInput_3 + ".");

				log.debug("tDBInput_3 - Connection attempt to '" + url_tDBInput_3 + "' with the username '"
						+ dbUser_tDBInput_3 + "'.");

				conn_tDBInput_3 = java.sql.DriverManager.getConnection(url_tDBInput_3, dbUser_tDBInput_3,
						dbPwd_tDBInput_3);
				log.debug("tDBInput_3 - Connection to '" + url_tDBInput_3 + "' has succeeded.");

				java.sql.Statement stmt_tDBInput_3 = conn_tDBInput_3.createStatement();

				String dbquery_tDBInput_3 = "SELECT \n  `stg_crew_list`.`tconst`, \n  `stg_crew_list`.`nconst`, \n  `stg_crew_list`.`category`\nFROM `stg_crew_list`";

				log.debug("tDBInput_3 - Executing the query: '" + dbquery_tDBInput_3 + "'.");

				globalMap.put("tDBInput_3_QUERY", dbquery_tDBInput_3);

				java.sql.ResultSet rs_tDBInput_3 = null;

				try {
					rs_tDBInput_3 = stmt_tDBInput_3.executeQuery(dbquery_tDBInput_3);
					java.sql.ResultSetMetaData rsmd_tDBInput_3 = rs_tDBInput_3.getMetaData();
					int colQtyInRs_tDBInput_3 = rsmd_tDBInput_3.getColumnCount();

					String tmpContent_tDBInput_3 = null;

					log.debug("tDBInput_3 - Retrieving records from the database.");

					while (rs_tDBInput_3.next()) {
						nb_line_tDBInput_3++;

						if (colQtyInRs_tDBInput_3 < 1) {
							row1.tconst = null;
						} else {

							row1.tconst = routines.system.JDBCUtil.getString(rs_tDBInput_3, 1, false);
						}
						if (colQtyInRs_tDBInput_3 < 2) {
							row1.nconst = null;
						} else {

							row1.nconst = routines.system.JDBCUtil.getString(rs_tDBInput_3, 2, false);
						}
						if (colQtyInRs_tDBInput_3 < 3) {
							row1.category = null;
						} else {

							row1.category = routines.system.JDBCUtil.getString(rs_tDBInput_3, 3, false);
						}

						log.debug("tDBInput_3 - Retrieving the record " + nb_line_tDBInput_3 + ".");

						/**
						 * [tDBInput_3 begin ] stop
						 */

						/**
						 * [tDBInput_3 main ] start
						 */

						currentComponent = "tDBInput_3";

						cLabel = "\"stg_crew_list\"";

						tos_count_tDBInput_3++;

						/**
						 * [tDBInput_3 main ] stop
						 */

						/**
						 * [tDBInput_3 process_data_begin ] start
						 */

						currentComponent = "tDBInput_3";

						cLabel = "\"stg_crew_list\"";

						/**
						 * [tDBInput_3 process_data_begin ] stop
						 */

						/**
						 * [tMap_1 main ] start
						 */

						currentComponent = "tMap_1";

						if (runStat.update(execStat, enableLogStash, iterateId, 1, 1

								, "row1", "tDBInput_3", "\"stg_crew_list\"", "tMysqlInput", "tMap_1", "tMap_1", "tMap"

						)) {
							talendJobLogProcess(globalMap);
						}

						if (log.isTraceEnabled()) {
							log.trace("row1 - " + (row1 == null ? "" : row1.toLogString()));
						}

						boolean hasCasePrimitiveKeyWithNull_tMap_1 = false;

						row2Struct row2 = null;

						row3Struct row3 = null;

						row4Struct row4 = null;

						// ###############################
						// # Input tables (lookups)

						boolean rejectedInnerJoin_tMap_1 = false;
						boolean mainRowRejected_tMap_1 = false;

						///////////////////////////////////////////////
						// Starting Lookup Table "row2"
						///////////////////////////////////////////////

						boolean forceLooprow2 = false;

						row2Struct row2ObjectFromLookup = null;

						if (!rejectedInnerJoin_tMap_1) { // G_TM_M_020

							hasCasePrimitiveKeyWithNull_tMap_1 = false;

							row2HashKey.tconst = row1.tconst;

							row2HashKey.hashCodeDirty = true;

							tHash_Lookup_row2.lookup(row2HashKey);

							if (!tHash_Lookup_row2.hasNext()) { // G_TM_M_090

								rejectedInnerJoin_tMap_1 = true;

							} // G_TM_M_090

						} // G_TM_M_020

						if (tHash_Lookup_row2 != null && tHash_Lookup_row2.getCount(row2HashKey) > 1) { // G 071

							// System.out.println("WARNING: UNIQUE MATCH is configured for the lookup 'row2'
							// and it contains more one result from keys : row2.tconst = '" +
							// row2HashKey.tconst + "'");
						} // G 071

						row2Struct fromLookup_row2 = null;
						row2 = row2Default;

						if (tHash_Lookup_row2 != null && tHash_Lookup_row2.hasNext()) { // G 099

							fromLookup_row2 = tHash_Lookup_row2.next();

						} // G 099

						if (fromLookup_row2 != null) {
							row2 = fromLookup_row2;
						}

						///////////////////////////////////////////////
						// Starting Lookup Table "row3"
						///////////////////////////////////////////////

						boolean forceLooprow3 = false;

						row3Struct row3ObjectFromLookup = null;

						if (!rejectedInnerJoin_tMap_1) { // G_TM_M_020

							hasCasePrimitiveKeyWithNull_tMap_1 = false;

							row3HashKey.nmconst = row1.nconst;

							row3HashKey.hashCodeDirty = true;

							tHash_Lookup_row3.lookup(row3HashKey);

							if (!tHash_Lookup_row3.hasNext()) { // G_TM_M_090

								rejectedInnerJoin_tMap_1 = true;

							} // G_TM_M_090

						} // G_TM_M_020

						if (tHash_Lookup_row3 != null && tHash_Lookup_row3.getCount(row3HashKey) > 1) { // G 071

							// System.out.println("WARNING: UNIQUE MATCH is configured for the lookup 'row3'
							// and it contains more one result from keys : row3.nmconst = '" +
							// row3HashKey.nmconst + "'");
						} // G 071

						row3Struct fromLookup_row3 = null;
						row3 = row3Default;

						if (tHash_Lookup_row3 != null && tHash_Lookup_row3.hasNext()) { // G 099

							fromLookup_row3 = tHash_Lookup_row3.next();

						} // G 099

						if (fromLookup_row3 != null) {
							row3 = fromLookup_row3;
						}

						///////////////////////////////////////////////
						// Starting Lookup Table "row4"
						///////////////////////////////////////////////

						boolean forceLooprow4 = false;

						row4Struct row4ObjectFromLookup = null;

						if (!rejectedInnerJoin_tMap_1) { // G_TM_M_020

							hasCasePrimitiveKeyWithNull_tMap_1 = false;

							row4HashKey.Name = row1.category;

							row4HashKey.hashCodeDirty = true;

							tHash_Lookup_row4.lookup(row4HashKey);

							if (!tHash_Lookup_row4.hasNext()) { // G_TM_M_090

								rejectedInnerJoin_tMap_1 = true;

							} // G_TM_M_090

						} // G_TM_M_020

						if (tHash_Lookup_row4 != null && tHash_Lookup_row4.getCount(row4HashKey) > 1) { // G 071

							// System.out.println("WARNING: UNIQUE MATCH is configured for the lookup 'row4'
							// and it contains more one result from keys : row4.Name = '" + row4HashKey.Name
							// + "'");
						} // G 071

						row4Struct fromLookup_row4 = null;
						row4 = row4Default;

						if (tHash_Lookup_row4 != null && tHash_Lookup_row4.hasNext()) { // G 099

							fromLookup_row4 = tHash_Lookup_row4.next();

						} // G 099

						if (fromLookup_row4 != null) {
							row4 = fromLookup_row4;
						}

						// ###############################
						{ // start of Var scope

							// ###############################
							// # Vars tables

							Var__tMap_1__Struct Var = Var__tMap_1;// ###############################
							// ###############################
							// # Output tables

							toTable = null;

							if (!rejectedInnerJoin_tMap_1) {

// # Output table : 'toTable'
								count_toTable_tMap_1++;

								toTable_tmp.Movie_ID = row2.Movie_ID;
								toTable_tmp.Crew_SK = row3.Crew_SK;
								toTable_tmp.Profession_SK = row4.Profession_SK;
								toTable_tmp.DI_CreatedDate = TalendDate.getCurrentDate();
								toTable_tmp.DI_WorkflowJobId = pid;
								toTable = toTable_tmp;
								log.debug("tMap_1 - Outputting the record " + count_toTable_tMap_1
										+ " of the output table 'toTable'.");

							} // closing inner join bracket (2)
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

						currentComponent = "tMap_1";

						/**
						 * [tMap_1 process_data_begin ] stop
						 */
// Start of branch "toTable"
						if (toTable != null) {

							/**
							 * [tUniqRow_1 main ] start
							 */

							currentComponent = "tUniqRow_1";

							if (runStat.update(execStat, enableLogStash, iterateId, 1, 1

									, "toTable", "tMap_1", "tMap_1", "tMap", "tUniqRow_1", "tUniqRow_1", "tUniqRow"

							)) {
								talendJobLogProcess(globalMap);
							}

							if (log.isTraceEnabled()) {
								log.trace("toTable - " + (toTable == null ? "" : toTable.toLogString()));
							}

							row5 = null;
							finder_tUniqRow_1.Movie_ID = toTable.Movie_ID;
							finder_tUniqRow_1.Crew_SK = toTable.Crew_SK;
							finder_tUniqRow_1.Profession_SK = toTable.Profession_SK;
							finder_tUniqRow_1.hashCodeDirty = true;
							if (!keystUniqRow_1.contains(finder_tUniqRow_1)) {
								KeyStruct_tUniqRow_1 new_tUniqRow_1 = new KeyStruct_tUniqRow_1();

								new_tUniqRow_1.Movie_ID = toTable.Movie_ID;
								new_tUniqRow_1.Crew_SK = toTable.Crew_SK;
								new_tUniqRow_1.Profession_SK = toTable.Profession_SK;

								keystUniqRow_1.add(new_tUniqRow_1);
								if (row5 == null) {

									log.trace("tUniqRow_1 - Writing the unique record " + (nb_uniques_tUniqRow_1 + 1)
											+ " into row5.");

									row5 = new row5Struct();
								}
								row5.Movie_ID = toTable.Movie_ID;
								row5.Crew_SK = toTable.Crew_SK;
								row5.Profession_SK = toTable.Profession_SK;
								row5.DI_CreatedDate = toTable.DI_CreatedDate;
								row5.DI_WorkflowJobId = toTable.DI_WorkflowJobId;
								nb_uniques_tUniqRow_1++;
							} else {
								nb_duplicates_tUniqRow_1++;
							}

							tos_count_tUniqRow_1++;

							/**
							 * [tUniqRow_1 main ] stop
							 */

							/**
							 * [tUniqRow_1 process_data_begin ] start
							 */

							currentComponent = "tUniqRow_1";

							/**
							 * [tUniqRow_1 process_data_begin ] stop
							 */
// Start of branch "row5"
							if (row5 != null) {

								/**
								 * [tDBOutput_1 main ] start
								 */

								currentComponent = "tDBOutput_1";

								cLabel = "\"bridge_crew_movie\"";

								if (runStat.update(execStat, enableLogStash, iterateId, 1, 1

										, "row5", "tUniqRow_1", "tUniqRow_1", "tUniqRow", "tDBOutput_1",
										"\"bridge_crew_movie\"", "tMysqlOutput"

								)) {
									talendJobLogProcess(globalMap);
								}

								if (log.isTraceEnabled()) {
									log.trace("row5 - " + (row5 == null ? "" : row5.toLogString()));
								}

								whetherReject_tDBOutput_1 = false;
								pstmt_tDBOutput_1.setInt(1, row5.Movie_ID);

								pstmt_tDBOutput_1.setInt(2, row5.Crew_SK);

								pstmt_tDBOutput_1.setInt(3, row5.Profession_SK);

								if (row5.DI_CreatedDate != null) {
									date_tDBOutput_1 = row5.DI_CreatedDate.getTime();
									if (date_tDBOutput_1 < year1_tDBOutput_1
											|| date_tDBOutput_1 >= year10000_tDBOutput_1) {
										pstmt_tDBOutput_1.setString(4, "0000-00-00 00:00:00");
									} else {
										pstmt_tDBOutput_1.setTimestamp(4, new java.sql.Timestamp(date_tDBOutput_1));
									}
								} else {
									pstmt_tDBOutput_1.setNull(4, java.sql.Types.DATE);
								}

								if (row5.DI_WorkflowJobId == null) {
									pstmt_tDBOutput_1.setNull(5, java.sql.Types.VARCHAR);
								} else {
									pstmt_tDBOutput_1.setString(5, row5.DI_WorkflowJobId);
								}

								pstmt_tDBOutput_1.addBatch();
								nb_line_tDBOutput_1++;

								if (log.isDebugEnabled())
									log.debug("tDBOutput_1 - " + ("Adding the record ") + (nb_line_tDBOutput_1)
											+ (" to the ") + ("INSERT") + (" batch."));
								batchSizeCounter_tDBOutput_1++;
								if (batchSize_tDBOutput_1 <= batchSizeCounter_tDBOutput_1) {
									try {
										int countSum_tDBOutput_1 = 0;
										if (log.isDebugEnabled())
											log.debug("tDBOutput_1 - " + ("Executing the ") + ("INSERT") + (" batch."));
										for (int countEach_tDBOutput_1 : pstmt_tDBOutput_1.executeBatch()) {
											countSum_tDBOutput_1 += (countEach_tDBOutput_1 == java.sql.Statement.EXECUTE_FAILED
													? 0
													: 1);
										}
										rowsToCommitCount_tDBOutput_1 += countSum_tDBOutput_1;
										if (log.isDebugEnabled())
											log.debug("tDBOutput_1 - " + ("The ") + ("INSERT")
													+ (" batch execution has succeeded."));
										insertedCount_tDBOutput_1 += countSum_tDBOutput_1;
									} catch (java.sql.BatchUpdateException e) {
										globalMap.put("tDBOutput_1_ERROR_MESSAGE", e.getMessage());
										int countSum_tDBOutput_1 = 0;
										for (int countEach_tDBOutput_1 : e.getUpdateCounts()) {
											countSum_tDBOutput_1 += (countEach_tDBOutput_1 < 0 ? 0
													: countEach_tDBOutput_1);
										}
										rowsToCommitCount_tDBOutput_1 += countSum_tDBOutput_1;
										insertedCount_tDBOutput_1 += countSum_tDBOutput_1;
										System.err.println(e.getMessage());
										log.error("tDBOutput_1 - " + (e.getMessage()));
									}

									batchSizeCounter_tDBOutput_1 = 0;
								}
								commitCounter_tDBOutput_1++;

								if (commitEvery_tDBOutput_1 <= commitCounter_tDBOutput_1) {

									try {
										int countSum_tDBOutput_1 = 0;
										if (log.isDebugEnabled())
											log.debug("tDBOutput_1 - " + ("Executing the ") + ("INSERT") + (" batch."));
										for (int countEach_tDBOutput_1 : pstmt_tDBOutput_1.executeBatch()) {
											countSum_tDBOutput_1 += (countEach_tDBOutput_1 < 0 ? 0 : 1);
										}
										rowsToCommitCount_tDBOutput_1 += countSum_tDBOutput_1;
										if (log.isDebugEnabled())
											log.debug("tDBOutput_1 - " + ("The ") + ("INSERT")
													+ (" batch execution has succeeded."));
										insertedCount_tDBOutput_1 += countSum_tDBOutput_1;
									} catch (java.sql.BatchUpdateException e) {
										globalMap.put("tDBOutput_1_ERROR_MESSAGE", e.getMessage());
										int countSum_tDBOutput_1 = 0;
										for (int countEach_tDBOutput_1 : e.getUpdateCounts()) {
											countSum_tDBOutput_1 += (countEach_tDBOutput_1 < 0 ? 0
													: countEach_tDBOutput_1);
										}
										rowsToCommitCount_tDBOutput_1 += countSum_tDBOutput_1;
										insertedCount_tDBOutput_1 += countSum_tDBOutput_1;
										System.err.println(e.getMessage());
										log.error("tDBOutput_1 - " + (e.getMessage()));

									}
									if (rowsToCommitCount_tDBOutput_1 != 0) {
										if (log.isDebugEnabled())
											log.debug("tDBOutput_1 - " + ("Connection starting to commit ")
													+ (rowsToCommitCount_tDBOutput_1) + (" record(s)."));
									}
									conn_tDBOutput_1.commit();
									if (rowsToCommitCount_tDBOutput_1 != 0) {
										if (log.isDebugEnabled())
											log.debug("tDBOutput_1 - " + ("Connection commit has succeeded."));
										rowsToCommitCount_tDBOutput_1 = 0;
									}
									commitCounter_tDBOutput_1 = 0;
								}

								tos_count_tDBOutput_1++;

								/**
								 * [tDBOutput_1 main ] stop
								 */

								/**
								 * [tDBOutput_1 process_data_begin ] start
								 */

								currentComponent = "tDBOutput_1";

								cLabel = "\"bridge_crew_movie\"";

								/**
								 * [tDBOutput_1 process_data_begin ] stop
								 */

								/**
								 * [tDBOutput_1 process_data_end ] start
								 */

								currentComponent = "tDBOutput_1";

								cLabel = "\"bridge_crew_movie\"";

								/**
								 * [tDBOutput_1 process_data_end ] stop
								 */

							} // End of branch "row5"

							/**
							 * [tUniqRow_1 process_data_end ] start
							 */

							currentComponent = "tUniqRow_1";

							/**
							 * [tUniqRow_1 process_data_end ] stop
							 */

						} // End of branch "toTable"

						/**
						 * [tMap_1 process_data_end ] start
						 */

						currentComponent = "tMap_1";

						/**
						 * [tMap_1 process_data_end ] stop
						 */

						/**
						 * [tDBInput_3 process_data_end ] start
						 */

						currentComponent = "tDBInput_3";

						cLabel = "\"stg_crew_list\"";

						/**
						 * [tDBInput_3 process_data_end ] stop
						 */

						/**
						 * [tDBInput_3 end ] start
						 */

						currentComponent = "tDBInput_3";

						cLabel = "\"stg_crew_list\"";

					}
				} finally {
					if (rs_tDBInput_3 != null) {
						rs_tDBInput_3.close();
					}
					if (stmt_tDBInput_3 != null) {
						stmt_tDBInput_3.close();
					}
					if (conn_tDBInput_3 != null && !conn_tDBInput_3.isClosed()) {

						log.debug("tDBInput_3 - Closing the connection to the database.");

						conn_tDBInput_3.close();

						if ("com.mysql.cj.jdbc.Driver".equals((String) globalMap.get("driverClass_"))
								&& routines.system.BundleUtils.inOSGi()) {
							Class.forName("com.mysql.cj.jdbc.AbandonedConnectionCleanupThread")
									.getMethod("checkedShutdown").invoke(null, (Object[]) null);
						}

						log.debug("tDBInput_3 - Connection to the database closed.");

					}

				}
				globalMap.put("tDBInput_3_NB_LINE", nb_line_tDBInput_3);
				log.debug("tDBInput_3 - Retrieved records count: " + nb_line_tDBInput_3 + " .");

				if (log.isDebugEnabled())
					log.debug("tDBInput_3 - " + ("Done."));

				ok_Hash.put("tDBInput_3", true);
				end_Hash.put("tDBInput_3", System.currentTimeMillis());

				/**
				 * [tDBInput_3 end ] stop
				 */

				/**
				 * [tMap_1 end ] start
				 */

				currentComponent = "tMap_1";

// ###############################
// # Lookup hashes releasing
				if (tHash_Lookup_row2 != null) {
					tHash_Lookup_row2.endGet();
				}
				globalMap.remove("tHash_Lookup_row2");

				if (tHash_Lookup_row3 != null) {
					tHash_Lookup_row3.endGet();
				}
				globalMap.remove("tHash_Lookup_row3");

				if (tHash_Lookup_row4 != null) {
					tHash_Lookup_row4.endGet();
				}
				globalMap.remove("tHash_Lookup_row4");

// ###############################      
				log.debug("tMap_1 - Written records count in the table 'toTable': " + count_toTable_tMap_1 + ".");

				if (runStat.updateStatAndLog(execStat, enableLogStash, resourceMap, iterateId, "row1", 2, 0,
						"tDBInput_3", "\"stg_crew_list\"", "tMysqlInput", "tMap_1", "tMap_1", "tMap", "output")) {
					talendJobLogProcess(globalMap);
				}

				if (log.isDebugEnabled())
					log.debug("tMap_1 - " + ("Done."));

				ok_Hash.put("tMap_1", true);
				end_Hash.put("tMap_1", System.currentTimeMillis());

				/**
				 * [tMap_1 end ] stop
				 */

				/**
				 * [tUniqRow_1 end ] start
				 */

				currentComponent = "tUniqRow_1";

				globalMap.put("tUniqRow_1_NB_UNIQUES", nb_uniques_tUniqRow_1);
				globalMap.put("tUniqRow_1_NB_DUPLICATES", nb_duplicates_tUniqRow_1);
				log.info("tUniqRow_1 - Unique records count: " + (nb_uniques_tUniqRow_1) + " .");
				log.info("tUniqRow_1 - Duplicate records count: " + (nb_duplicates_tUniqRow_1) + " .");

				if (runStat.updateStatAndLog(execStat, enableLogStash, resourceMap, iterateId, "toTable", 2, 0,
						"tMap_1", "tMap_1", "tMap", "tUniqRow_1", "tUniqRow_1", "tUniqRow", "output")) {
					talendJobLogProcess(globalMap);
				}

				if (log.isDebugEnabled())
					log.debug("tUniqRow_1 - " + ("Done."));

				ok_Hash.put("tUniqRow_1", true);
				end_Hash.put("tUniqRow_1", System.currentTimeMillis());

				/**
				 * [tUniqRow_1 end ] stop
				 */

				/**
				 * [tDBOutput_1 end ] start
				 */

				currentComponent = "tDBOutput_1";

				cLabel = "\"bridge_crew_movie\"";

				try {
					if (batchSizeCounter_tDBOutput_1 != 0) {
						int countSum_tDBOutput_1 = 0;

						if (log.isDebugEnabled())
							log.debug("tDBOutput_1 - " + ("Executing the ") + ("INSERT") + (" batch."));
						for (int countEach_tDBOutput_1 : pstmt_tDBOutput_1.executeBatch()) {
							countSum_tDBOutput_1 += (countEach_tDBOutput_1 == java.sql.Statement.EXECUTE_FAILED ? 0
									: 1);
						}
						rowsToCommitCount_tDBOutput_1 += countSum_tDBOutput_1;

						if (log.isDebugEnabled())
							log.debug("tDBOutput_1 - " + ("The ") + ("INSERT") + (" batch execution has succeeded."));

						insertedCount_tDBOutput_1 += countSum_tDBOutput_1;

					}
				} catch (java.sql.BatchUpdateException e) {
					globalMap.put(currentComponent + "_ERROR_MESSAGE", e.getMessage());

					int countSum_tDBOutput_1 = 0;
					for (int countEach_tDBOutput_1 : e.getUpdateCounts()) {
						countSum_tDBOutput_1 += (countEach_tDBOutput_1 < 0 ? 0 : countEach_tDBOutput_1);
					}
					rowsToCommitCount_tDBOutput_1 += countSum_tDBOutput_1;

					insertedCount_tDBOutput_1 += countSum_tDBOutput_1;

					log.error("tDBOutput_1 - " + (e.getMessage()));
					System.err.println(e.getMessage());

				}
				batchSizeCounter_tDBOutput_1 = 0;

				if (pstmt_tDBOutput_1 != null) {

					pstmt_tDBOutput_1.close();
					resourceMap.remove("pstmt_tDBOutput_1");

				}

				resourceMap.put("statementClosed_tDBOutput_1", true);

				if (commitCounter_tDBOutput_1 > 0 && rowsToCommitCount_tDBOutput_1 != 0) {

					if (log.isDebugEnabled())
						log.debug("tDBOutput_1 - " + ("Connection starting to commit ")
								+ (rowsToCommitCount_tDBOutput_1) + (" record(s)."));
				}
				conn_tDBOutput_1.commit();
				if (commitCounter_tDBOutput_1 > 0 && rowsToCommitCount_tDBOutput_1 != 0) {

					if (log.isDebugEnabled())
						log.debug("tDBOutput_1 - " + ("Connection commit has succeeded."));
					rowsToCommitCount_tDBOutput_1 = 0;
				}
				commitCounter_tDBOutput_1 = 0;

				if (log.isDebugEnabled())
					log.debug("tDBOutput_1 - " + ("Closing the connection to the database."));
				conn_tDBOutput_1.close();

				if (log.isDebugEnabled())
					log.debug("tDBOutput_1 - " + ("Connection to the database has closed."));
				resourceMap.put("finish_tDBOutput_1", true);

				nb_line_deleted_tDBOutput_1 = nb_line_deleted_tDBOutput_1 + deletedCount_tDBOutput_1;
				nb_line_update_tDBOutput_1 = nb_line_update_tDBOutput_1 + updatedCount_tDBOutput_1;
				nb_line_inserted_tDBOutput_1 = nb_line_inserted_tDBOutput_1 + insertedCount_tDBOutput_1;
				nb_line_rejected_tDBOutput_1 = nb_line_rejected_tDBOutput_1 + rejectedCount_tDBOutput_1;

				globalMap.put("tDBOutput_1_NB_LINE", nb_line_tDBOutput_1);
				globalMap.put("tDBOutput_1_NB_LINE_UPDATED", nb_line_update_tDBOutput_1);
				globalMap.put("tDBOutput_1_NB_LINE_INSERTED", nb_line_inserted_tDBOutput_1);
				globalMap.put("tDBOutput_1_NB_LINE_DELETED", nb_line_deleted_tDBOutput_1);
				globalMap.put("tDBOutput_1_NB_LINE_REJECTED", nb_line_rejected_tDBOutput_1);

				if (log.isDebugEnabled())
					log.debug("tDBOutput_1 - " + ("Has ") + ("inserted") + (" ") + (nb_line_inserted_tDBOutput_1)
							+ (" record(s)."));

				if (runStat.updateStatAndLog(execStat, enableLogStash, resourceMap, iterateId, "row5", 2, 0,
						"tUniqRow_1", "tUniqRow_1", "tUniqRow", "tDBOutput_1", "\"bridge_crew_movie\"", "tMysqlOutput",
						"output")) {
					talendJobLogProcess(globalMap);
				}

				if (log.isDebugEnabled())
					log.debug("tDBOutput_1 - " + ("Done."));

				ok_Hash.put("tDBOutput_1", true);
				end_Hash.put("tDBOutput_1", System.currentTimeMillis());

				/**
				 * [tDBOutput_1 end ] stop
				 */

			} // end the resume

			if (resumeEntryMethodName == null || globalResumeTicket) {
				resumeUtil.addLog("CHECKPOINT", "CONNECTION:SUBJOB_OK:tDBInput_3:OnSubjobOk", "",
						Thread.currentThread().getId() + "", "", "", "", "", "");
			}

			if (execStat) {
				runStat.updateStatOnConnection("OnSubjobOk1", 0, "ok");
			}

			tDBInput_2Process(globalMap);

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

			// free memory for "tMap_1"
			globalMap.remove("tHash_Lookup_row3");

			// free memory for "tMap_1"
			globalMap.remove("tHash_Lookup_row2");

			// free memory for "tMap_1"
			globalMap.remove("tHash_Lookup_row4");

			try {

				/**
				 * [tDBInput_3 finally ] start
				 */

				currentComponent = "tDBInput_3";

				cLabel = "\"stg_crew_list\"";

				/**
				 * [tDBInput_3 finally ] stop
				 */

				/**
				 * [tMap_1 finally ] start
				 */

				currentComponent = "tMap_1";

				/**
				 * [tMap_1 finally ] stop
				 */

				/**
				 * [tUniqRow_1 finally ] start
				 */

				currentComponent = "tUniqRow_1";

				/**
				 * [tUniqRow_1 finally ] stop
				 */

				/**
				 * [tDBOutput_1 finally ] start
				 */

				currentComponent = "tDBOutput_1";

				cLabel = "\"bridge_crew_movie\"";

				try {
					if (resourceMap.get("statementClosed_tDBOutput_1") == null) {
						java.sql.PreparedStatement pstmtToClose_tDBOutput_1 = null;
						if ((pstmtToClose_tDBOutput_1 = (java.sql.PreparedStatement) resourceMap
								.remove("pstmt_tDBOutput_1")) != null) {
							pstmtToClose_tDBOutput_1.close();
						}
					}
				} finally {
					if (resourceMap.get("finish_tDBOutput_1") == null) {
						java.sql.Connection ctn_tDBOutput_1 = null;
						if ((ctn_tDBOutput_1 = (java.sql.Connection) resourceMap.get("conn_tDBOutput_1")) != null) {
							try {
								if (log.isDebugEnabled())
									log.debug("tDBOutput_1 - " + ("Closing the connection to the database."));
								ctn_tDBOutput_1.close();
								if (log.isDebugEnabled())
									log.debug("tDBOutput_1 - " + ("Connection to the database has closed."));
							} catch (java.sql.SQLException sqlEx_tDBOutput_1) {
								String errorMessage_tDBOutput_1 = "failed to close the connection in tDBOutput_1 :"
										+ sqlEx_tDBOutput_1.getMessage();
								log.error("tDBOutput_1 - " + (errorMessage_tDBOutput_1));
								System.err.println(errorMessage_tDBOutput_1);
							}
						}
					}
				}

				/**
				 * [tDBOutput_1 finally ] stop
				 */

			} catch (java.lang.Exception e) {
				// ignore
			} catch (java.lang.Error error) {
				// ignore
			}
			resourceMap = null;
		}

		globalMap.put("tDBInput_3_SUBPROCESS_STATE", 1);
	}

	public static class row2Struct implements routines.system.IPersistableComparableLookupRow<row2Struct> {
		final static byte[] commonByteArrayLock_FINAL_PROJECT_bridge_crew_movie = new byte[0];
		static byte[] commonByteArray_FINAL_PROJECT_bridge_crew_movie = new byte[0];
		protected static final int DEFAULT_HASHCODE = 1;
		protected static final int PRIME = 31;
		protected int hashCode = DEFAULT_HASHCODE;
		public boolean hashCodeDirty = true;

		public String loopKey;

		public int Movie_ID;

		public int getMovie_ID() {
			return this.Movie_ID;
		}

		public Boolean Movie_IDIsNullable() {
			return false;
		}

		public Boolean Movie_IDIsKey() {
			return false;
		}

		public Integer Movie_IDLength() {
			return 10;
		}

		public Integer Movie_IDPrecision() {
			return 0;
		}

		public String Movie_IDDefault() {

			return "";

		}

		public String Movie_IDComment() {

			return "";

		}

		public String Movie_IDPattern() {

			return "";

		}

		public String Movie_IDOriginalDbColumnName() {

			return "Movie_ID";

		}

		public String tconst;

		public String getTconst() {
			return this.tconst;
		}

		public Boolean tconstIsNullable() {
			return true;
		}

		public Boolean tconstIsKey() {
			return false;
		}

		public Integer tconstLength() {
			return 10;
		}

		public Integer tconstPrecision() {
			return 0;
		}

		public String tconstDefault() {

			return null;

		}

		public String tconstComment() {

			return "";

		}

		public String tconstPattern() {

			return "";

		}

		public String tconstOriginalDbColumnName() {

			return "tconst";

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
			if (this == obj)
				return true;
			if (obj == null)
				return false;
			if (getClass() != obj.getClass())
				return false;
			final row2Struct other = (row2Struct) obj;

			if (this.tconst == null) {
				if (other.tconst != null)
					return false;

			} else if (!this.tconst.equals(other.tconst))

				return false;

			return true;
		}

		public void copyDataTo(row2Struct other) {

			other.Movie_ID = this.Movie_ID;
			other.tconst = this.tconst;

		}

		public void copyKeysDataTo(row2Struct other) {

			other.tconst = this.tconst;

		}

		private String readString(ObjectInputStream dis) throws IOException {
			String strReturn = null;
			int length = 0;
			length = dis.readInt();
			if (length == -1) {
				strReturn = null;
			} else {
				if (length > commonByteArray_FINAL_PROJECT_bridge_crew_movie.length) {
					if (length < 1024 && commonByteArray_FINAL_PROJECT_bridge_crew_movie.length == 0) {
						commonByteArray_FINAL_PROJECT_bridge_crew_movie = new byte[1024];
					} else {
						commonByteArray_FINAL_PROJECT_bridge_crew_movie = new byte[2 * length];
					}
				}
				dis.readFully(commonByteArray_FINAL_PROJECT_bridge_crew_movie, 0, length);
				strReturn = new String(commonByteArray_FINAL_PROJECT_bridge_crew_movie, 0, length, utf8Charset);
			}
			return strReturn;
		}

		private String readString(org.jboss.marshalling.Unmarshaller unmarshaller) throws IOException {
			String strReturn = null;
			int length = 0;
			length = unmarshaller.readInt();
			if (length == -1) {
				strReturn = null;
			} else {
				if (length > commonByteArray_FINAL_PROJECT_bridge_crew_movie.length) {
					if (length < 1024 && commonByteArray_FINAL_PROJECT_bridge_crew_movie.length == 0) {
						commonByteArray_FINAL_PROJECT_bridge_crew_movie = new byte[1024];
					} else {
						commonByteArray_FINAL_PROJECT_bridge_crew_movie = new byte[2 * length];
					}
				}
				unmarshaller.readFully(commonByteArray_FINAL_PROJECT_bridge_crew_movie, 0, length);
				strReturn = new String(commonByteArray_FINAL_PROJECT_bridge_crew_movie, 0, length, utf8Charset);
			}
			return strReturn;
		}

		private void writeString(String str, ObjectOutputStream dos) throws IOException {
			if (str == null) {
				dos.writeInt(-1);
			} else {
				byte[] byteArray = str.getBytes(utf8Charset);
				dos.writeInt(byteArray.length);
				dos.write(byteArray);
			}
		}

		private void writeString(String str, org.jboss.marshalling.Marshaller marshaller) throws IOException {
			if (str == null) {
				marshaller.writeInt(-1);
			} else {
				byte[] byteArray = str.getBytes(utf8Charset);
				marshaller.writeInt(byteArray.length);
				marshaller.write(byteArray);
			}
		}

		public void readKeysData(ObjectInputStream dis) {

			synchronized (commonByteArrayLock_FINAL_PROJECT_bridge_crew_movie) {

				try {

					int length = 0;

					this.tconst = readString(dis);

				} catch (IOException e) {
					throw new RuntimeException(e);

				}

			}

		}

		public void readKeysData(org.jboss.marshalling.Unmarshaller dis) {

			synchronized (commonByteArrayLock_FINAL_PROJECT_bridge_crew_movie) {

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

				writeString(this.tconst, dos);

			} catch (IOException e) {
				throw new RuntimeException(e);
			}

		}

		public void writeKeysData(org.jboss.marshalling.Marshaller dos) {
			try {

				// String

				writeString(this.tconst, dos);

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

				this.Movie_ID = dis.readInt();

			} catch (IOException e) {
				throw new RuntimeException(e);

			}

		}

		public void readValuesData(DataInputStream dis, org.jboss.marshalling.Unmarshaller objectIn) {
			try {
				int length = 0;

				this.Movie_ID = objectIn.readInt();

			} catch (IOException e) {
				throw new RuntimeException(e);

			}

		}

		/**
		 * Return a byte array which represents Values data.
		 */
		public void writeValuesData(DataOutputStream dos, ObjectOutputStream oos) {
			try {

				dos.writeInt(this.Movie_ID);

			} catch (IOException e) {
				throw new RuntimeException(e);
			}

		}

		public void writeValuesData(DataOutputStream dos, org.jboss.marshalling.Marshaller objectOut) {
			try {

				objectOut.writeInt(this.Movie_ID);

			} catch (IOException e) {
				throw new RuntimeException(e);
			}
		}

		public boolean supportMarshaller() {
			return true;
		}

		public String toString() {

			StringBuilder sb = new StringBuilder();
			sb.append(super.toString());
			sb.append("[");
			sb.append("Movie_ID=" + String.valueOf(Movie_ID));
			sb.append(",tconst=" + tconst);
			sb.append("]");

			return sb.toString();
		}

		public String toLogString() {
			StringBuilder sb = new StringBuilder();

			sb.append(Movie_ID);

			sb.append("|");

			if (tconst == null) {
				sb.append("<null>");
			} else {
				sb.append(tconst);
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
			if (returnValue != 0) {
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

	public void tDBInput_4Process(final java.util.Map<String, Object> globalMap) throws TalendException {
		globalMap.put("tDBInput_4_SUBPROCESS_STATE", 0);

		final boolean execStat = this.execStat;

		mdcInfo.forEach(org.slf4j.MDC::put);
		org.slf4j.MDC.put("_subJobName", "tDBInput_4");
		org.slf4j.MDC.put("_subJobPid", "uMw4SZ_" + subJobPidCounter.getAndIncrement());

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

				row2Struct row2 = new row2Struct();

				/**
				 * [tAdvancedHash_row2 begin ] start
				 */

				ok_Hash.put("tAdvancedHash_row2", false);
				start_Hash.put("tAdvancedHash_row2", System.currentTimeMillis());

				currentComponent = "tAdvancedHash_row2";

				runStat.updateStatAndLog(execStat, enableLogStash, resourceMap, iterateId, 0, 0, "row2");

				int tos_count_tAdvancedHash_row2 = 0;

				if (enableLogStash) {
					talendJobLog.addCM("tAdvancedHash_row2", "tAdvancedHash_row2", "tAdvancedHash");
					talendJobLogProcess(globalMap);
				}

				// connection name:row2
				// source node:tDBInput_4 - inputs:(after_tDBInput_3) outputs:(row2,row2) |
				// target node:tAdvancedHash_row2 - inputs:(row2) outputs:()
				// linked node: tMap_1 - inputs:(row3,row1,row2,row4) outputs:(toTable)

				org.talend.designer.components.lookup.common.ICommonLookup.MATCHING_MODE matchingModeEnum_row2 = org.talend.designer.components.lookup.common.ICommonLookup.MATCHING_MODE.UNIQUE_MATCH;

				org.talend.designer.components.lookup.memory.AdvancedMemoryLookup<row2Struct> tHash_Lookup_row2 = org.talend.designer.components.lookup.memory.AdvancedMemoryLookup
						.<row2Struct>getLookup(matchingModeEnum_row2);

				globalMap.put("tHash_Lookup_row2", tHash_Lookup_row2);

				/**
				 * [tAdvancedHash_row2 begin ] stop
				 */

				/**
				 * [tDBInput_4 begin ] start
				 */

				ok_Hash.put("tDBInput_4", false);
				start_Hash.put("tDBInput_4", System.currentTimeMillis());

				currentComponent = "tDBInput_4";

				cLabel = "\"fact_movie\"";

				int tos_count_tDBInput_4 = 0;

				if (log.isDebugEnabled())
					log.debug("tDBInput_4 - " + ("Start to work."));
				if (log.isDebugEnabled()) {
					class BytesLimit65535_tDBInput_4 {
						public void limitLog4jByte() throws Exception {
							StringBuilder log4jParamters_tDBInput_4 = new StringBuilder();
							log4jParamters_tDBInput_4.append("Parameters:");
							log4jParamters_tDBInput_4.append("DB_VERSION" + " = " + "MYSQL_8");
							log4jParamters_tDBInput_4.append(" | ");
							log4jParamters_tDBInput_4.append("USE_EXISTING_CONNECTION" + " = " + "false");
							log4jParamters_tDBInput_4.append(" | ");
							log4jParamters_tDBInput_4.append("HOST" + " = " + "\"127.0.0.1\"");
							log4jParamters_tDBInput_4.append(" | ");
							log4jParamters_tDBInput_4.append("PORT" + " = " + "\"3306\"");
							log4jParamters_tDBInput_4.append(" | ");
							log4jParamters_tDBInput_4.append("DBNAME" + " = " + "\"imdb_src\"");
							log4jParamters_tDBInput_4.append(" | ");
							log4jParamters_tDBInput_4.append("USER" + " = " + "\"user2\"");
							log4jParamters_tDBInput_4.append(" | ");
							log4jParamters_tDBInput_4.append("PASS" + " = " + String.valueOf(
									"enc:routine.encryption.key.v1:O9C5HT+FydNZ7EzQAFlN3GzSIxYdXFCGqVSitdugUrl1gHTi")
									.substring(0, 4) + "...");
							log4jParamters_tDBInput_4.append(" | ");
							log4jParamters_tDBInput_4.append("TABLE" + " = " + "\"fact_movie\"");
							log4jParamters_tDBInput_4.append(" | ");
							log4jParamters_tDBInput_4.append("QUERYSTORE" + " = " + "\"\"");
							log4jParamters_tDBInput_4.append(" | ");
							log4jParamters_tDBInput_4.append("QUERY" + " = "
									+ "\"SELECT    `fact_movie`.`Movie_ID`,    `fact_movie`.`tconst` FROM `fact_movie`\"");
							log4jParamters_tDBInput_4.append(" | ");
							log4jParamters_tDBInput_4.append("SPECIFY_DATASOURCE_ALIAS" + " = " + "false");
							log4jParamters_tDBInput_4.append(" | ");
							log4jParamters_tDBInput_4.append("PROPERTIES" + " = "
									+ "\"noDatetimeStringSync=true&enabledTLSProtocols=TLSv1.2,TLSv1.1,TLSv1\"");
							log4jParamters_tDBInput_4.append(" | ");
							log4jParamters_tDBInput_4.append("ENABLE_STREAM" + " = " + "false");
							log4jParamters_tDBInput_4.append(" | ");
							log4jParamters_tDBInput_4.append("TRIM_ALL_COLUMN" + " = " + "false");
							log4jParamters_tDBInput_4.append(" | ");
							log4jParamters_tDBInput_4.append(
									"TRIM_COLUMN" + " = " + "[{TRIM=" + ("false") + ", SCHEMA_COLUMN=" + ("Movie_ID")
											+ "}, {TRIM=" + ("false") + ", SCHEMA_COLUMN=" + ("tconst") + "}]");
							log4jParamters_tDBInput_4.append(" | ");
							log4jParamters_tDBInput_4.append("UNIFIED_COMPONENTS" + " = " + "tMysqlInput");
							log4jParamters_tDBInput_4.append(" | ");
							if (log.isDebugEnabled())
								log.debug("tDBInput_4 - " + (log4jParamters_tDBInput_4));
						}
					}
					new BytesLimit65535_tDBInput_4().limitLog4jByte();
				}
				if (enableLogStash) {
					talendJobLog.addCM("tDBInput_4", "\"fact_movie\"", "tMysqlInput");
					talendJobLogProcess(globalMap);
				}

				java.util.Calendar calendar_tDBInput_4 = java.util.Calendar.getInstance();
				calendar_tDBInput_4.set(0, 0, 0, 0, 0, 0);
				java.util.Date year0_tDBInput_4 = calendar_tDBInput_4.getTime();
				int nb_line_tDBInput_4 = 0;
				java.sql.Connection conn_tDBInput_4 = null;
				String driverClass_tDBInput_4 = "com.mysql.cj.jdbc.Driver";
				java.lang.Class jdbcclazz_tDBInput_4 = java.lang.Class.forName(driverClass_tDBInput_4);
				String dbUser_tDBInput_4 = "user2";

				final String decryptedPassword_tDBInput_4 = routines.system.PasswordEncryptUtil.decryptPassword(
						"enc:routine.encryption.key.v1:eu+8jr2Esn/0ua5kAQzWuourwalws/4E2c0ORq/NUHW4CNhO");

				String dbPwd_tDBInput_4 = decryptedPassword_tDBInput_4;

				String properties_tDBInput_4 = "noDatetimeStringSync=true&enabledTLSProtocols=TLSv1.2,TLSv1.1,TLSv1";
				if (properties_tDBInput_4 == null || properties_tDBInput_4.trim().length() == 0) {
					properties_tDBInput_4 = "";
				}
				String url_tDBInput_4 = "jdbc:mysql://" + "127.0.0.1" + ":" + "3306" + "/" + "imdb_src" + "?"
						+ properties_tDBInput_4;

				log.debug("tDBInput_4 - Driver ClassName: " + driverClass_tDBInput_4 + ".");

				log.debug("tDBInput_4 - Connection attempt to '" + url_tDBInput_4 + "' with the username '"
						+ dbUser_tDBInput_4 + "'.");

				conn_tDBInput_4 = java.sql.DriverManager.getConnection(url_tDBInput_4, dbUser_tDBInput_4,
						dbPwd_tDBInput_4);
				log.debug("tDBInput_4 - Connection to '" + url_tDBInput_4 + "' has succeeded.");

				java.sql.Statement stmt_tDBInput_4 = conn_tDBInput_4.createStatement();

				String dbquery_tDBInput_4 = "SELECT \n  `fact_movie`.`Movie_ID`, \n  `fact_movie`.`tconst`\nFROM `fact_movie`";

				log.debug("tDBInput_4 - Executing the query: '" + dbquery_tDBInput_4 + "'.");

				globalMap.put("tDBInput_4_QUERY", dbquery_tDBInput_4);

				java.sql.ResultSet rs_tDBInput_4 = null;

				try {
					rs_tDBInput_4 = stmt_tDBInput_4.executeQuery(dbquery_tDBInput_4);
					java.sql.ResultSetMetaData rsmd_tDBInput_4 = rs_tDBInput_4.getMetaData();
					int colQtyInRs_tDBInput_4 = rsmd_tDBInput_4.getColumnCount();

					String tmpContent_tDBInput_4 = null;

					log.debug("tDBInput_4 - Retrieving records from the database.");

					while (rs_tDBInput_4.next()) {
						nb_line_tDBInput_4++;

						if (colQtyInRs_tDBInput_4 < 1) {
							row2.Movie_ID = 0;
						} else {

							row2.Movie_ID = rs_tDBInput_4.getInt(1);
							if (rs_tDBInput_4.wasNull()) {
								throw new RuntimeException("Null value in non-Nullable column");
							}
						}
						if (colQtyInRs_tDBInput_4 < 2) {
							row2.tconst = null;
						} else {

							row2.tconst = routines.system.JDBCUtil.getString(rs_tDBInput_4, 2, false);
						}

						log.debug("tDBInput_4 - Retrieving the record " + nb_line_tDBInput_4 + ".");

						/**
						 * [tDBInput_4 begin ] stop
						 */

						/**
						 * [tDBInput_4 main ] start
						 */

						currentComponent = "tDBInput_4";

						cLabel = "\"fact_movie\"";

						tos_count_tDBInput_4++;

						/**
						 * [tDBInput_4 main ] stop
						 */

						/**
						 * [tDBInput_4 process_data_begin ] start
						 */

						currentComponent = "tDBInput_4";

						cLabel = "\"fact_movie\"";

						/**
						 * [tDBInput_4 process_data_begin ] stop
						 */

						/**
						 * [tAdvancedHash_row2 main ] start
						 */

						currentComponent = "tAdvancedHash_row2";

						if (runStat.update(execStat, enableLogStash, iterateId, 1, 1

								, "row2", "tDBInput_4", "\"fact_movie\"", "tMysqlInput", "tAdvancedHash_row2",
								"tAdvancedHash_row2", "tAdvancedHash"

						)) {
							talendJobLogProcess(globalMap);
						}

						if (log.isTraceEnabled()) {
							log.trace("row2 - " + (row2 == null ? "" : row2.toLogString()));
						}

						row2Struct row2_HashRow = new row2Struct();

						row2_HashRow.Movie_ID = row2.Movie_ID;

						row2_HashRow.tconst = row2.tconst;

						tHash_Lookup_row2.put(row2_HashRow);

						tos_count_tAdvancedHash_row2++;

						/**
						 * [tAdvancedHash_row2 main ] stop
						 */

						/**
						 * [tAdvancedHash_row2 process_data_begin ] start
						 */

						currentComponent = "tAdvancedHash_row2";

						/**
						 * [tAdvancedHash_row2 process_data_begin ] stop
						 */

						/**
						 * [tAdvancedHash_row2 process_data_end ] start
						 */

						currentComponent = "tAdvancedHash_row2";

						/**
						 * [tAdvancedHash_row2 process_data_end ] stop
						 */

						/**
						 * [tDBInput_4 process_data_end ] start
						 */

						currentComponent = "tDBInput_4";

						cLabel = "\"fact_movie\"";

						/**
						 * [tDBInput_4 process_data_end ] stop
						 */

						/**
						 * [tDBInput_4 end ] start
						 */

						currentComponent = "tDBInput_4";

						cLabel = "\"fact_movie\"";

					}
				} finally {
					if (rs_tDBInput_4 != null) {
						rs_tDBInput_4.close();
					}
					if (stmt_tDBInput_4 != null) {
						stmt_tDBInput_4.close();
					}
					if (conn_tDBInput_4 != null && !conn_tDBInput_4.isClosed()) {

						log.debug("tDBInput_4 - Closing the connection to the database.");

						conn_tDBInput_4.close();

						if ("com.mysql.cj.jdbc.Driver".equals((String) globalMap.get("driverClass_"))
								&& routines.system.BundleUtils.inOSGi()) {
							Class.forName("com.mysql.cj.jdbc.AbandonedConnectionCleanupThread")
									.getMethod("checkedShutdown").invoke(null, (Object[]) null);
						}

						log.debug("tDBInput_4 - Connection to the database closed.");

					}

				}
				globalMap.put("tDBInput_4_NB_LINE", nb_line_tDBInput_4);
				log.debug("tDBInput_4 - Retrieved records count: " + nb_line_tDBInput_4 + " .");

				if (log.isDebugEnabled())
					log.debug("tDBInput_4 - " + ("Done."));

				ok_Hash.put("tDBInput_4", true);
				end_Hash.put("tDBInput_4", System.currentTimeMillis());

				/**
				 * [tDBInput_4 end ] stop
				 */

				/**
				 * [tAdvancedHash_row2 end ] start
				 */

				currentComponent = "tAdvancedHash_row2";

				tHash_Lookup_row2.endPut();

				if (runStat.updateStatAndLog(execStat, enableLogStash, resourceMap, iterateId, "row2", 2, 0,
						"tDBInput_4", "\"fact_movie\"", "tMysqlInput", "tAdvancedHash_row2", "tAdvancedHash_row2",
						"tAdvancedHash", "output")) {
					talendJobLogProcess(globalMap);
				}

				ok_Hash.put("tAdvancedHash_row2", true);
				end_Hash.put("tAdvancedHash_row2", System.currentTimeMillis());

				/**
				 * [tAdvancedHash_row2 end ] stop
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
				 * [tDBInput_4 finally ] start
				 */

				currentComponent = "tDBInput_4";

				cLabel = "\"fact_movie\"";

				/**
				 * [tDBInput_4 finally ] stop
				 */

				/**
				 * [tAdvancedHash_row2 finally ] start
				 */

				currentComponent = "tAdvancedHash_row2";

				/**
				 * [tAdvancedHash_row2 finally ] stop
				 */

			} catch (java.lang.Exception e) {
				// ignore
			} catch (java.lang.Error error) {
				// ignore
			}
			resourceMap = null;
		}

		globalMap.put("tDBInput_4_SUBPROCESS_STATE", 1);
	}

	public static class row4Struct implements routines.system.IPersistableComparableLookupRow<row4Struct> {
		final static byte[] commonByteArrayLock_FINAL_PROJECT_bridge_crew_movie = new byte[0];
		static byte[] commonByteArray_FINAL_PROJECT_bridge_crew_movie = new byte[0];
		protected static final int DEFAULT_HASHCODE = 1;
		protected static final int PRIME = 31;
		protected int hashCode = DEFAULT_HASHCODE;
		public boolean hashCodeDirty = true;

		public String loopKey;

		public int Profession_SK;

		public int getProfession_SK() {
			return this.Profession_SK;
		}

		public Boolean Profession_SKIsNullable() {
			return false;
		}

		public Boolean Profession_SKIsKey() {
			return false;
		}

		public Integer Profession_SKLength() {
			return 10;
		}

		public Integer Profession_SKPrecision() {
			return 0;
		}

		public String Profession_SKDefault() {

			return "";

		}

		public String Profession_SKComment() {

			return "";

		}

		public String Profession_SKPattern() {

			return "";

		}

		public String Profession_SKOriginalDbColumnName() {

			return "Profession_SK";

		}

		public String Name;

		public String getName() {
			return this.Name;
		}

		public Boolean NameIsNullable() {
			return true;
		}

		public Boolean NameIsKey() {
			return false;
		}

		public Integer NameLength() {
			return 20;
		}

		public Integer NamePrecision() {
			return 0;
		}

		public String NameDefault() {

			return null;

		}

		public String NameComment() {

			return "";

		}

		public String NamePattern() {

			return "";

		}

		public String NameOriginalDbColumnName() {

			return "Name";

		}

		@Override
		public int hashCode() {
			if (this.hashCodeDirty) {
				final int prime = PRIME;
				int result = DEFAULT_HASHCODE;

				result = prime * result + ((this.Name == null) ? 0 : this.Name.hashCode());

				this.hashCode = result;
				this.hashCodeDirty = false;
			}
			return this.hashCode;
		}

		@Override
		public boolean equals(Object obj) {
			if (this == obj)
				return true;
			if (obj == null)
				return false;
			if (getClass() != obj.getClass())
				return false;
			final row4Struct other = (row4Struct) obj;

			if (this.Name == null) {
				if (other.Name != null)
					return false;

			} else if (!this.Name.equals(other.Name))

				return false;

			return true;
		}

		public void copyDataTo(row4Struct other) {

			other.Profession_SK = this.Profession_SK;
			other.Name = this.Name;

		}

		public void copyKeysDataTo(row4Struct other) {

			other.Name = this.Name;

		}

		private String readString(ObjectInputStream dis) throws IOException {
			String strReturn = null;
			int length = 0;
			length = dis.readInt();
			if (length == -1) {
				strReturn = null;
			} else {
				if (length > commonByteArray_FINAL_PROJECT_bridge_crew_movie.length) {
					if (length < 1024 && commonByteArray_FINAL_PROJECT_bridge_crew_movie.length == 0) {
						commonByteArray_FINAL_PROJECT_bridge_crew_movie = new byte[1024];
					} else {
						commonByteArray_FINAL_PROJECT_bridge_crew_movie = new byte[2 * length];
					}
				}
				dis.readFully(commonByteArray_FINAL_PROJECT_bridge_crew_movie, 0, length);
				strReturn = new String(commonByteArray_FINAL_PROJECT_bridge_crew_movie, 0, length, utf8Charset);
			}
			return strReturn;
		}

		private String readString(org.jboss.marshalling.Unmarshaller unmarshaller) throws IOException {
			String strReturn = null;
			int length = 0;
			length = unmarshaller.readInt();
			if (length == -1) {
				strReturn = null;
			} else {
				if (length > commonByteArray_FINAL_PROJECT_bridge_crew_movie.length) {
					if (length < 1024 && commonByteArray_FINAL_PROJECT_bridge_crew_movie.length == 0) {
						commonByteArray_FINAL_PROJECT_bridge_crew_movie = new byte[1024];
					} else {
						commonByteArray_FINAL_PROJECT_bridge_crew_movie = new byte[2 * length];
					}
				}
				unmarshaller.readFully(commonByteArray_FINAL_PROJECT_bridge_crew_movie, 0, length);
				strReturn = new String(commonByteArray_FINAL_PROJECT_bridge_crew_movie, 0, length, utf8Charset);
			}
			return strReturn;
		}

		private void writeString(String str, ObjectOutputStream dos) throws IOException {
			if (str == null) {
				dos.writeInt(-1);
			} else {
				byte[] byteArray = str.getBytes(utf8Charset);
				dos.writeInt(byteArray.length);
				dos.write(byteArray);
			}
		}

		private void writeString(String str, org.jboss.marshalling.Marshaller marshaller) throws IOException {
			if (str == null) {
				marshaller.writeInt(-1);
			} else {
				byte[] byteArray = str.getBytes(utf8Charset);
				marshaller.writeInt(byteArray.length);
				marshaller.write(byteArray);
			}
		}

		public void readKeysData(ObjectInputStream dis) {

			synchronized (commonByteArrayLock_FINAL_PROJECT_bridge_crew_movie) {

				try {

					int length = 0;

					this.Name = readString(dis);

				} catch (IOException e) {
					throw new RuntimeException(e);

				}

			}

		}

		public void readKeysData(org.jboss.marshalling.Unmarshaller dis) {

			synchronized (commonByteArrayLock_FINAL_PROJECT_bridge_crew_movie) {

				try {

					int length = 0;

					this.Name = readString(dis);

				} catch (IOException e) {
					throw new RuntimeException(e);

				}

			}

		}

		public void writeKeysData(ObjectOutputStream dos) {
			try {

				// String

				writeString(this.Name, dos);

			} catch (IOException e) {
				throw new RuntimeException(e);
			}

		}

		public void writeKeysData(org.jboss.marshalling.Marshaller dos) {
			try {

				// String

				writeString(this.Name, dos);

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

				this.Profession_SK = dis.readInt();

			} catch (IOException e) {
				throw new RuntimeException(e);

			}

		}

		public void readValuesData(DataInputStream dis, org.jboss.marshalling.Unmarshaller objectIn) {
			try {
				int length = 0;

				this.Profession_SK = objectIn.readInt();

			} catch (IOException e) {
				throw new RuntimeException(e);

			}

		}

		/**
		 * Return a byte array which represents Values data.
		 */
		public void writeValuesData(DataOutputStream dos, ObjectOutputStream oos) {
			try {

				dos.writeInt(this.Profession_SK);

			} catch (IOException e) {
				throw new RuntimeException(e);
			}

		}

		public void writeValuesData(DataOutputStream dos, org.jboss.marshalling.Marshaller objectOut) {
			try {

				objectOut.writeInt(this.Profession_SK);

			} catch (IOException e) {
				throw new RuntimeException(e);
			}
		}

		public boolean supportMarshaller() {
			return true;
		}

		public String toString() {

			StringBuilder sb = new StringBuilder();
			sb.append(super.toString());
			sb.append("[");
			sb.append("Profession_SK=" + String.valueOf(Profession_SK));
			sb.append(",Name=" + Name);
			sb.append("]");

			return sb.toString();
		}

		public String toLogString() {
			StringBuilder sb = new StringBuilder();

			sb.append(Profession_SK);

			sb.append("|");

			if (Name == null) {
				sb.append("<null>");
			} else {
				sb.append(Name);
			}

			sb.append("|");

			return sb.toString();
		}

		/**
		 * Compare keys
		 */
		public int compareTo(row4Struct other) {

			int returnValue = -1;

			returnValue = checkNullsAndCompare(this.Name, other.Name);
			if (returnValue != 0) {
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

	public void tDBInput_5Process(final java.util.Map<String, Object> globalMap) throws TalendException {
		globalMap.put("tDBInput_5_SUBPROCESS_STATE", 0);

		final boolean execStat = this.execStat;

		mdcInfo.forEach(org.slf4j.MDC::put);
		org.slf4j.MDC.put("_subJobName", "tDBInput_5");
		org.slf4j.MDC.put("_subJobPid", "LjDAgX_" + subJobPidCounter.getAndIncrement());

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

				row4Struct row4 = new row4Struct();

				/**
				 * [tAdvancedHash_row4 begin ] start
				 */

				ok_Hash.put("tAdvancedHash_row4", false);
				start_Hash.put("tAdvancedHash_row4", System.currentTimeMillis());

				currentComponent = "tAdvancedHash_row4";

				runStat.updateStatAndLog(execStat, enableLogStash, resourceMap, iterateId, 0, 0, "row4");

				int tos_count_tAdvancedHash_row4 = 0;

				if (enableLogStash) {
					talendJobLog.addCM("tAdvancedHash_row4", "tAdvancedHash_row4", "tAdvancedHash");
					talendJobLogProcess(globalMap);
				}

				// connection name:row4
				// source node:tDBInput_5 - inputs:(after_tDBInput_3) outputs:(row4,row4) |
				// target node:tAdvancedHash_row4 - inputs:(row4) outputs:()
				// linked node: tMap_1 - inputs:(row3,row1,row2,row4) outputs:(toTable)

				org.talend.designer.components.lookup.common.ICommonLookup.MATCHING_MODE matchingModeEnum_row4 = org.talend.designer.components.lookup.common.ICommonLookup.MATCHING_MODE.UNIQUE_MATCH;

				org.talend.designer.components.lookup.memory.AdvancedMemoryLookup<row4Struct> tHash_Lookup_row4 = org.talend.designer.components.lookup.memory.AdvancedMemoryLookup
						.<row4Struct>getLookup(matchingModeEnum_row4);

				globalMap.put("tHash_Lookup_row4", tHash_Lookup_row4);

				/**
				 * [tAdvancedHash_row4 begin ] stop
				 */

				/**
				 * [tDBInput_5 begin ] start
				 */

				ok_Hash.put("tDBInput_5", false);
				start_Hash.put("tDBInput_5", System.currentTimeMillis());

				currentComponent = "tDBInput_5";

				cLabel = "\"dim_profession\"";

				int tos_count_tDBInput_5 = 0;

				if (log.isDebugEnabled())
					log.debug("tDBInput_5 - " + ("Start to work."));
				if (log.isDebugEnabled()) {
					class BytesLimit65535_tDBInput_5 {
						public void limitLog4jByte() throws Exception {
							StringBuilder log4jParamters_tDBInput_5 = new StringBuilder();
							log4jParamters_tDBInput_5.append("Parameters:");
							log4jParamters_tDBInput_5.append("DB_VERSION" + " = " + "MYSQL_8");
							log4jParamters_tDBInput_5.append(" | ");
							log4jParamters_tDBInput_5.append("USE_EXISTING_CONNECTION" + " = " + "false");
							log4jParamters_tDBInput_5.append(" | ");
							log4jParamters_tDBInput_5.append("HOST" + " = " + "\"127.0.0.1\"");
							log4jParamters_tDBInput_5.append(" | ");
							log4jParamters_tDBInput_5.append("PORT" + " = " + "\"3306\"");
							log4jParamters_tDBInput_5.append(" | ");
							log4jParamters_tDBInput_5.append("DBNAME" + " = " + "\"imdb_src\"");
							log4jParamters_tDBInput_5.append(" | ");
							log4jParamters_tDBInput_5.append("USER" + " = " + "\"user2\"");
							log4jParamters_tDBInput_5.append(" | ");
							log4jParamters_tDBInput_5.append("PASS" + " = " + String.valueOf(
									"enc:routine.encryption.key.v1:dT0FCKfHTGyMkxSjj4uu2DCq/qe50W45BCh/Sr4qwF+b6fPT")
									.substring(0, 4) + "...");
							log4jParamters_tDBInput_5.append(" | ");
							log4jParamters_tDBInput_5.append("TABLE" + " = " + "\"dim_profession\"");
							log4jParamters_tDBInput_5.append(" | ");
							log4jParamters_tDBInput_5.append("QUERYSTORE" + " = " + "\"\"");
							log4jParamters_tDBInput_5.append(" | ");
							log4jParamters_tDBInput_5.append("QUERY" + " = "
									+ "\"SELECT    `dim_profession`.`Profession_SK`,    `dim_profession`.`Name` FROM `dim_profession`\"");
							log4jParamters_tDBInput_5.append(" | ");
							log4jParamters_tDBInput_5.append("SPECIFY_DATASOURCE_ALIAS" + " = " + "false");
							log4jParamters_tDBInput_5.append(" | ");
							log4jParamters_tDBInput_5.append("PROPERTIES" + " = "
									+ "\"noDatetimeStringSync=true&enabledTLSProtocols=TLSv1.2,TLSv1.1,TLSv1\"");
							log4jParamters_tDBInput_5.append(" | ");
							log4jParamters_tDBInput_5.append("ENABLE_STREAM" + " = " + "false");
							log4jParamters_tDBInput_5.append(" | ");
							log4jParamters_tDBInput_5.append("TRIM_ALL_COLUMN" + " = " + "false");
							log4jParamters_tDBInput_5.append(" | ");
							log4jParamters_tDBInput_5.append("TRIM_COLUMN" + " = " + "[{TRIM=" + ("false")
									+ ", SCHEMA_COLUMN=" + ("Profession_SK") + "}, {TRIM=" + ("false")
									+ ", SCHEMA_COLUMN=" + ("Name") + "}]");
							log4jParamters_tDBInput_5.append(" | ");
							log4jParamters_tDBInput_5.append("UNIFIED_COMPONENTS" + " = " + "tMysqlInput");
							log4jParamters_tDBInput_5.append(" | ");
							if (log.isDebugEnabled())
								log.debug("tDBInput_5 - " + (log4jParamters_tDBInput_5));
						}
					}
					new BytesLimit65535_tDBInput_5().limitLog4jByte();
				}
				if (enableLogStash) {
					talendJobLog.addCM("tDBInput_5", "\"dim_profession\"", "tMysqlInput");
					talendJobLogProcess(globalMap);
				}

				java.util.Calendar calendar_tDBInput_5 = java.util.Calendar.getInstance();
				calendar_tDBInput_5.set(0, 0, 0, 0, 0, 0);
				java.util.Date year0_tDBInput_5 = calendar_tDBInput_5.getTime();
				int nb_line_tDBInput_5 = 0;
				java.sql.Connection conn_tDBInput_5 = null;
				String driverClass_tDBInput_5 = "com.mysql.cj.jdbc.Driver";
				java.lang.Class jdbcclazz_tDBInput_5 = java.lang.Class.forName(driverClass_tDBInput_5);
				String dbUser_tDBInput_5 = "user2";

				final String decryptedPassword_tDBInput_5 = routines.system.PasswordEncryptUtil.decryptPassword(
						"enc:routine.encryption.key.v1:1lOX8nkI0rib3PwIRHNqXp1yHyMN21m/HBewIw+JRjpSixOs");

				String dbPwd_tDBInput_5 = decryptedPassword_tDBInput_5;

				String properties_tDBInput_5 = "noDatetimeStringSync=true&enabledTLSProtocols=TLSv1.2,TLSv1.1,TLSv1";
				if (properties_tDBInput_5 == null || properties_tDBInput_5.trim().length() == 0) {
					properties_tDBInput_5 = "";
				}
				String url_tDBInput_5 = "jdbc:mysql://" + "127.0.0.1" + ":" + "3306" + "/" + "imdb_src" + "?"
						+ properties_tDBInput_5;

				log.debug("tDBInput_5 - Driver ClassName: " + driverClass_tDBInput_5 + ".");

				log.debug("tDBInput_5 - Connection attempt to '" + url_tDBInput_5 + "' with the username '"
						+ dbUser_tDBInput_5 + "'.");

				conn_tDBInput_5 = java.sql.DriverManager.getConnection(url_tDBInput_5, dbUser_tDBInput_5,
						dbPwd_tDBInput_5);
				log.debug("tDBInput_5 - Connection to '" + url_tDBInput_5 + "' has succeeded.");

				java.sql.Statement stmt_tDBInput_5 = conn_tDBInput_5.createStatement();

				String dbquery_tDBInput_5 = "SELECT \n  `dim_profession`.`Profession_SK`, \n  `dim_profession`.`Name`\nFROM `dim_profession`";

				log.debug("tDBInput_5 - Executing the query: '" + dbquery_tDBInput_5 + "'.");

				globalMap.put("tDBInput_5_QUERY", dbquery_tDBInput_5);

				java.sql.ResultSet rs_tDBInput_5 = null;

				try {
					rs_tDBInput_5 = stmt_tDBInput_5.executeQuery(dbquery_tDBInput_5);
					java.sql.ResultSetMetaData rsmd_tDBInput_5 = rs_tDBInput_5.getMetaData();
					int colQtyInRs_tDBInput_5 = rsmd_tDBInput_5.getColumnCount();

					String tmpContent_tDBInput_5 = null;

					log.debug("tDBInput_5 - Retrieving records from the database.");

					while (rs_tDBInput_5.next()) {
						nb_line_tDBInput_5++;

						if (colQtyInRs_tDBInput_5 < 1) {
							row4.Profession_SK = 0;
						} else {

							row4.Profession_SK = rs_tDBInput_5.getInt(1);
							if (rs_tDBInput_5.wasNull()) {
								throw new RuntimeException("Null value in non-Nullable column");
							}
						}
						if (colQtyInRs_tDBInput_5 < 2) {
							row4.Name = null;
						} else {

							row4.Name = routines.system.JDBCUtil.getString(rs_tDBInput_5, 2, false);
						}

						log.debug("tDBInput_5 - Retrieving the record " + nb_line_tDBInput_5 + ".");

						/**
						 * [tDBInput_5 begin ] stop
						 */

						/**
						 * [tDBInput_5 main ] start
						 */

						currentComponent = "tDBInput_5";

						cLabel = "\"dim_profession\"";

						tos_count_tDBInput_5++;

						/**
						 * [tDBInput_5 main ] stop
						 */

						/**
						 * [tDBInput_5 process_data_begin ] start
						 */

						currentComponent = "tDBInput_5";

						cLabel = "\"dim_profession\"";

						/**
						 * [tDBInput_5 process_data_begin ] stop
						 */

						/**
						 * [tAdvancedHash_row4 main ] start
						 */

						currentComponent = "tAdvancedHash_row4";

						if (runStat.update(execStat, enableLogStash, iterateId, 1, 1

								, "row4", "tDBInput_5", "\"dim_profession\"", "tMysqlInput", "tAdvancedHash_row4",
								"tAdvancedHash_row4", "tAdvancedHash"

						)) {
							talendJobLogProcess(globalMap);
						}

						if (log.isTraceEnabled()) {
							log.trace("row4 - " + (row4 == null ? "" : row4.toLogString()));
						}

						row4Struct row4_HashRow = new row4Struct();

						row4_HashRow.Profession_SK = row4.Profession_SK;

						row4_HashRow.Name = row4.Name;

						tHash_Lookup_row4.put(row4_HashRow);

						tos_count_tAdvancedHash_row4++;

						/**
						 * [tAdvancedHash_row4 main ] stop
						 */

						/**
						 * [tAdvancedHash_row4 process_data_begin ] start
						 */

						currentComponent = "tAdvancedHash_row4";

						/**
						 * [tAdvancedHash_row4 process_data_begin ] stop
						 */

						/**
						 * [tAdvancedHash_row4 process_data_end ] start
						 */

						currentComponent = "tAdvancedHash_row4";

						/**
						 * [tAdvancedHash_row4 process_data_end ] stop
						 */

						/**
						 * [tDBInput_5 process_data_end ] start
						 */

						currentComponent = "tDBInput_5";

						cLabel = "\"dim_profession\"";

						/**
						 * [tDBInput_5 process_data_end ] stop
						 */

						/**
						 * [tDBInput_5 end ] start
						 */

						currentComponent = "tDBInput_5";

						cLabel = "\"dim_profession\"";

					}
				} finally {
					if (rs_tDBInput_5 != null) {
						rs_tDBInput_5.close();
					}
					if (stmt_tDBInput_5 != null) {
						stmt_tDBInput_5.close();
					}
					if (conn_tDBInput_5 != null && !conn_tDBInput_5.isClosed()) {

						log.debug("tDBInput_5 - Closing the connection to the database.");

						conn_tDBInput_5.close();

						if ("com.mysql.cj.jdbc.Driver".equals((String) globalMap.get("driverClass_"))
								&& routines.system.BundleUtils.inOSGi()) {
							Class.forName("com.mysql.cj.jdbc.AbandonedConnectionCleanupThread")
									.getMethod("checkedShutdown").invoke(null, (Object[]) null);
						}

						log.debug("tDBInput_5 - Connection to the database closed.");

					}

				}
				globalMap.put("tDBInput_5_NB_LINE", nb_line_tDBInput_5);
				log.debug("tDBInput_5 - Retrieved records count: " + nb_line_tDBInput_5 + " .");

				if (log.isDebugEnabled())
					log.debug("tDBInput_5 - " + ("Done."));

				ok_Hash.put("tDBInput_5", true);
				end_Hash.put("tDBInput_5", System.currentTimeMillis());

				/**
				 * [tDBInput_5 end ] stop
				 */

				/**
				 * [tAdvancedHash_row4 end ] start
				 */

				currentComponent = "tAdvancedHash_row4";

				tHash_Lookup_row4.endPut();

				if (runStat.updateStatAndLog(execStat, enableLogStash, resourceMap, iterateId, "row4", 2, 0,
						"tDBInput_5", "\"dim_profession\"", "tMysqlInput", "tAdvancedHash_row4", "tAdvancedHash_row4",
						"tAdvancedHash", "output")) {
					talendJobLogProcess(globalMap);
				}

				ok_Hash.put("tAdvancedHash_row4", true);
				end_Hash.put("tAdvancedHash_row4", System.currentTimeMillis());

				/**
				 * [tAdvancedHash_row4 end ] stop
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
				 * [tDBInput_5 finally ] start
				 */

				currentComponent = "tDBInput_5";

				cLabel = "\"dim_profession\"";

				/**
				 * [tDBInput_5 finally ] stop
				 */

				/**
				 * [tAdvancedHash_row4 finally ] start
				 */

				currentComponent = "tAdvancedHash_row4";

				/**
				 * [tAdvancedHash_row4 finally ] stop
				 */

			} catch (java.lang.Exception e) {
				// ignore
			} catch (java.lang.Error error) {
				// ignore
			}
			resourceMap = null;
		}

		globalMap.put("tDBInput_5_SUBPROCESS_STATE", 1);
	}

	public static class row11Struct implements routines.system.IPersistableComparableLookupRow<row11Struct> {
		final static byte[] commonByteArrayLock_FINAL_PROJECT_bridge_crew_movie = new byte[0];
		static byte[] commonByteArray_FINAL_PROJECT_bridge_crew_movie = new byte[0];
		protected static final int DEFAULT_HASHCODE = 1;
		protected static final int PRIME = 31;
		protected int hashCode = DEFAULT_HASHCODE;
		public boolean hashCodeDirty = true;

		public String loopKey;

		public String nmconst;

		public String getNmconst() {
			return this.nmconst;
		}

		public Boolean nmconstIsNullable() {
			return true;
		}

		public Boolean nmconstIsKey() {
			return false;
		}

		public Integer nmconstLength() {
			return 10;
		}

		public Integer nmconstPrecision() {
			return 0;
		}

		public String nmconstDefault() {

			return null;

		}

		public String nmconstComment() {

			return "";

		}

		public String nmconstPattern() {

			return "";

		}

		public String nmconstOriginalDbColumnName() {

			return "nmconst";

		}

		public int Crew_SK;

		public int getCrew_SK() {
			return this.Crew_SK;
		}

		public Boolean Crew_SKIsNullable() {
			return false;
		}

		public Boolean Crew_SKIsKey() {
			return false;
		}

		public Integer Crew_SKLength() {
			return 10;
		}

		public Integer Crew_SKPrecision() {
			return 0;
		}

		public String Crew_SKDefault() {

			return "";

		}

		public String Crew_SKComment() {

			return "";

		}

		public String Crew_SKPattern() {

			return "";

		}

		public String Crew_SKOriginalDbColumnName() {

			return "Crew_SK";

		}

		@Override
		public int hashCode() {
			if (this.hashCodeDirty) {
				final int prime = PRIME;
				int result = DEFAULT_HASHCODE;

				result = prime * result + ((this.nmconst == null) ? 0 : this.nmconst.hashCode());

				this.hashCode = result;
				this.hashCodeDirty = false;
			}
			return this.hashCode;
		}

		@Override
		public boolean equals(Object obj) {
			if (this == obj)
				return true;
			if (obj == null)
				return false;
			if (getClass() != obj.getClass())
				return false;
			final row11Struct other = (row11Struct) obj;

			if (this.nmconst == null) {
				if (other.nmconst != null)
					return false;

			} else if (!this.nmconst.equals(other.nmconst))

				return false;

			return true;
		}

		public void copyDataTo(row11Struct other) {

			other.nmconst = this.nmconst;
			other.Crew_SK = this.Crew_SK;

		}

		public void copyKeysDataTo(row11Struct other) {

			other.nmconst = this.nmconst;

		}

		private String readString(ObjectInputStream dis) throws IOException {
			String strReturn = null;
			int length = 0;
			length = dis.readInt();
			if (length == -1) {
				strReturn = null;
			} else {
				if (length > commonByteArray_FINAL_PROJECT_bridge_crew_movie.length) {
					if (length < 1024 && commonByteArray_FINAL_PROJECT_bridge_crew_movie.length == 0) {
						commonByteArray_FINAL_PROJECT_bridge_crew_movie = new byte[1024];
					} else {
						commonByteArray_FINAL_PROJECT_bridge_crew_movie = new byte[2 * length];
					}
				}
				dis.readFully(commonByteArray_FINAL_PROJECT_bridge_crew_movie, 0, length);
				strReturn = new String(commonByteArray_FINAL_PROJECT_bridge_crew_movie, 0, length, utf8Charset);
			}
			return strReturn;
		}

		private String readString(org.jboss.marshalling.Unmarshaller unmarshaller) throws IOException {
			String strReturn = null;
			int length = 0;
			length = unmarshaller.readInt();
			if (length == -1) {
				strReturn = null;
			} else {
				if (length > commonByteArray_FINAL_PROJECT_bridge_crew_movie.length) {
					if (length < 1024 && commonByteArray_FINAL_PROJECT_bridge_crew_movie.length == 0) {
						commonByteArray_FINAL_PROJECT_bridge_crew_movie = new byte[1024];
					} else {
						commonByteArray_FINAL_PROJECT_bridge_crew_movie = new byte[2 * length];
					}
				}
				unmarshaller.readFully(commonByteArray_FINAL_PROJECT_bridge_crew_movie, 0, length);
				strReturn = new String(commonByteArray_FINAL_PROJECT_bridge_crew_movie, 0, length, utf8Charset);
			}
			return strReturn;
		}

		private void writeString(String str, ObjectOutputStream dos) throws IOException {
			if (str == null) {
				dos.writeInt(-1);
			} else {
				byte[] byteArray = str.getBytes(utf8Charset);
				dos.writeInt(byteArray.length);
				dos.write(byteArray);
			}
		}

		private void writeString(String str, org.jboss.marshalling.Marshaller marshaller) throws IOException {
			if (str == null) {
				marshaller.writeInt(-1);
			} else {
				byte[] byteArray = str.getBytes(utf8Charset);
				marshaller.writeInt(byteArray.length);
				marshaller.write(byteArray);
			}
		}

		public void readKeysData(ObjectInputStream dis) {

			synchronized (commonByteArrayLock_FINAL_PROJECT_bridge_crew_movie) {

				try {

					int length = 0;

					this.nmconst = readString(dis);

				} catch (IOException e) {
					throw new RuntimeException(e);

				}

			}

		}

		public void readKeysData(org.jboss.marshalling.Unmarshaller dis) {

			synchronized (commonByteArrayLock_FINAL_PROJECT_bridge_crew_movie) {

				try {

					int length = 0;

					this.nmconst = readString(dis);

				} catch (IOException e) {
					throw new RuntimeException(e);

				}

			}

		}

		public void writeKeysData(ObjectOutputStream dos) {
			try {

				// String

				writeString(this.nmconst, dos);

			} catch (IOException e) {
				throw new RuntimeException(e);
			}

		}

		public void writeKeysData(org.jboss.marshalling.Marshaller dos) {
			try {

				// String

				writeString(this.nmconst, dos);

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

				this.Crew_SK = dis.readInt();

			} catch (IOException e) {
				throw new RuntimeException(e);

			}

		}

		public void readValuesData(DataInputStream dis, org.jboss.marshalling.Unmarshaller objectIn) {
			try {
				int length = 0;

				this.Crew_SK = objectIn.readInt();

			} catch (IOException e) {
				throw new RuntimeException(e);

			}

		}

		/**
		 * Return a byte array which represents Values data.
		 */
		public void writeValuesData(DataOutputStream dos, ObjectOutputStream oos) {
			try {

				dos.writeInt(this.Crew_SK);

			} catch (IOException e) {
				throw new RuntimeException(e);
			}

		}

		public void writeValuesData(DataOutputStream dos, org.jboss.marshalling.Marshaller objectOut) {
			try {

				objectOut.writeInt(this.Crew_SK);

			} catch (IOException e) {
				throw new RuntimeException(e);
			}
		}

		public boolean supportMarshaller() {
			return true;
		}

		public String toString() {

			StringBuilder sb = new StringBuilder();
			sb.append(super.toString());
			sb.append("[");
			sb.append("nmconst=" + nmconst);
			sb.append(",Crew_SK=" + String.valueOf(Crew_SK));
			sb.append("]");

			return sb.toString();
		}

		public String toLogString() {
			StringBuilder sb = new StringBuilder();

			if (nmconst == null) {
				sb.append("<null>");
			} else {
				sb.append(nmconst);
			}

			sb.append("|");

			sb.append(Crew_SK);

			sb.append("|");

			return sb.toString();
		}

		/**
		 * Compare keys
		 */
		public int compareTo(row11Struct other) {

			int returnValue = -1;

			returnValue = checkNullsAndCompare(this.nmconst, other.nmconst);
			if (returnValue != 0) {
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

	public void tDBInput_7Process(final java.util.Map<String, Object> globalMap) throws TalendException {
		globalMap.put("tDBInput_7_SUBPROCESS_STATE", 0);

		final boolean execStat = this.execStat;

		mdcInfo.forEach(org.slf4j.MDC::put);
		org.slf4j.MDC.put("_subJobName", "tDBInput_7");
		org.slf4j.MDC.put("_subJobPid", "EeX09V_" + subJobPidCounter.getAndIncrement());

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

				row11Struct row11 = new row11Struct();

				/**
				 * [tAdvancedHash_row11 begin ] start
				 */

				ok_Hash.put("tAdvancedHash_row11", false);
				start_Hash.put("tAdvancedHash_row11", System.currentTimeMillis());

				currentComponent = "tAdvancedHash_row11";

				runStat.updateStatAndLog(execStat, enableLogStash, resourceMap, iterateId, 0, 0, "row11");

				int tos_count_tAdvancedHash_row11 = 0;

				if (enableLogStash) {
					talendJobLog.addCM("tAdvancedHash_row11", "tAdvancedHash_row11", "tAdvancedHash");
					talendJobLogProcess(globalMap);
				}

				// connection name:row11
				// source node:tDBInput_7 - inputs:(after_tDBInput_2) outputs:(row11,row11) |
				// target node:tAdvancedHash_row11 - inputs:(row11) outputs:()
				// linked node: tMap_4 - inputs:(row10,row11,row12,row13) outputs:(toTable1)

				org.talend.designer.components.lookup.common.ICommonLookup.MATCHING_MODE matchingModeEnum_row11 = org.talend.designer.components.lookup.common.ICommonLookup.MATCHING_MODE.UNIQUE_MATCH;

				org.talend.designer.components.lookup.memory.AdvancedMemoryLookup<row11Struct> tHash_Lookup_row11 = org.talend.designer.components.lookup.memory.AdvancedMemoryLookup
						.<row11Struct>getLookup(matchingModeEnum_row11);

				globalMap.put("tHash_Lookup_row11", tHash_Lookup_row11);

				/**
				 * [tAdvancedHash_row11 begin ] stop
				 */

				/**
				 * [tDBInput_7 begin ] start
				 */

				ok_Hash.put("tDBInput_7", false);
				start_Hash.put("tDBInput_7", System.currentTimeMillis());

				currentComponent = "tDBInput_7";

				cLabel = "\"dim_crew\"";

				int tos_count_tDBInput_7 = 0;

				if (log.isDebugEnabled())
					log.debug("tDBInput_7 - " + ("Start to work."));
				if (log.isDebugEnabled()) {
					class BytesLimit65535_tDBInput_7 {
						public void limitLog4jByte() throws Exception {
							StringBuilder log4jParamters_tDBInput_7 = new StringBuilder();
							log4jParamters_tDBInput_7.append("Parameters:");
							log4jParamters_tDBInput_7.append("DB_VERSION" + " = " + "MYSQL_8");
							log4jParamters_tDBInput_7.append(" | ");
							log4jParamters_tDBInput_7.append("USE_EXISTING_CONNECTION" + " = " + "false");
							log4jParamters_tDBInput_7.append(" | ");
							log4jParamters_tDBInput_7.append("HOST" + " = " + "\"127.0.0.1\"");
							log4jParamters_tDBInput_7.append(" | ");
							log4jParamters_tDBInput_7.append("PORT" + " = " + "\"3306\"");
							log4jParamters_tDBInput_7.append(" | ");
							log4jParamters_tDBInput_7.append("DBNAME" + " = " + "\"imdb_src\"");
							log4jParamters_tDBInput_7.append(" | ");
							log4jParamters_tDBInput_7.append("USER" + " = " + "\"user2\"");
							log4jParamters_tDBInput_7.append(" | ");
							log4jParamters_tDBInput_7.append("PASS" + " = " + String.valueOf(
									"enc:routine.encryption.key.v1:W0LS39GXfbSPY9fftdedAPBZws8qaGOST+5bghE0McJZBN0t")
									.substring(0, 4) + "...");
							log4jParamters_tDBInput_7.append(" | ");
							log4jParamters_tDBInput_7.append("TABLE" + " = " + "\"dim_crew\"");
							log4jParamters_tDBInput_7.append(" | ");
							log4jParamters_tDBInput_7.append("QUERYSTORE" + " = " + "\"\"");
							log4jParamters_tDBInput_7.append(" | ");
							log4jParamters_tDBInput_7.append("QUERY" + " = "
									+ "\"SELECT    `dim_crew`.`nmconst`,    `dim_crew`.`Crew_SK` FROM `dim_crew`\"");
							log4jParamters_tDBInput_7.append(" | ");
							log4jParamters_tDBInput_7.append("SPECIFY_DATASOURCE_ALIAS" + " = " + "false");
							log4jParamters_tDBInput_7.append(" | ");
							log4jParamters_tDBInput_7.append("PROPERTIES" + " = "
									+ "\"noDatetimeStringSync=true&enabledTLSProtocols=TLSv1.2,TLSv1.1,TLSv1\"");
							log4jParamters_tDBInput_7.append(" | ");
							log4jParamters_tDBInput_7.append("ENABLE_STREAM" + " = " + "false");
							log4jParamters_tDBInput_7.append(" | ");
							log4jParamters_tDBInput_7.append("TRIM_ALL_COLUMN" + " = " + "false");
							log4jParamters_tDBInput_7.append(" | ");
							log4jParamters_tDBInput_7.append(
									"TRIM_COLUMN" + " = " + "[{TRIM=" + ("false") + ", SCHEMA_COLUMN=" + ("nmconst")
											+ "}, {TRIM=" + ("false") + ", SCHEMA_COLUMN=" + ("Crew_SK") + "}]");
							log4jParamters_tDBInput_7.append(" | ");
							log4jParamters_tDBInput_7.append("UNIFIED_COMPONENTS" + " = " + "tMysqlInput");
							log4jParamters_tDBInput_7.append(" | ");
							if (log.isDebugEnabled())
								log.debug("tDBInput_7 - " + (log4jParamters_tDBInput_7));
						}
					}
					new BytesLimit65535_tDBInput_7().limitLog4jByte();
				}
				if (enableLogStash) {
					talendJobLog.addCM("tDBInput_7", "\"dim_crew\"", "tMysqlInput");
					talendJobLogProcess(globalMap);
				}

				java.util.Calendar calendar_tDBInput_7 = java.util.Calendar.getInstance();
				calendar_tDBInput_7.set(0, 0, 0, 0, 0, 0);
				java.util.Date year0_tDBInput_7 = calendar_tDBInput_7.getTime();
				int nb_line_tDBInput_7 = 0;
				java.sql.Connection conn_tDBInput_7 = null;
				String driverClass_tDBInput_7 = "com.mysql.cj.jdbc.Driver";
				java.lang.Class jdbcclazz_tDBInput_7 = java.lang.Class.forName(driverClass_tDBInput_7);
				String dbUser_tDBInput_7 = "user2";

				final String decryptedPassword_tDBInput_7 = routines.system.PasswordEncryptUtil.decryptPassword(
						"enc:routine.encryption.key.v1:jCX/S9KRlS3iLofpd7oVtdz1mlX4dM1Ghi+jzUQu4/XtwglD");

				String dbPwd_tDBInput_7 = decryptedPassword_tDBInput_7;

				String properties_tDBInput_7 = "noDatetimeStringSync=true&enabledTLSProtocols=TLSv1.2,TLSv1.1,TLSv1";
				if (properties_tDBInput_7 == null || properties_tDBInput_7.trim().length() == 0) {
					properties_tDBInput_7 = "";
				}
				String url_tDBInput_7 = "jdbc:mysql://" + "127.0.0.1" + ":" + "3306" + "/" + "imdb_src" + "?"
						+ properties_tDBInput_7;

				log.debug("tDBInput_7 - Driver ClassName: " + driverClass_tDBInput_7 + ".");

				log.debug("tDBInput_7 - Connection attempt to '" + url_tDBInput_7 + "' with the username '"
						+ dbUser_tDBInput_7 + "'.");

				conn_tDBInput_7 = java.sql.DriverManager.getConnection(url_tDBInput_7, dbUser_tDBInput_7,
						dbPwd_tDBInput_7);
				log.debug("tDBInput_7 - Connection to '" + url_tDBInput_7 + "' has succeeded.");

				java.sql.Statement stmt_tDBInput_7 = conn_tDBInput_7.createStatement();

				String dbquery_tDBInput_7 = "SELECT \n  `dim_crew`.`nmconst`, \n  `dim_crew`.`Crew_SK`\nFROM `dim_crew`";

				log.debug("tDBInput_7 - Executing the query: '" + dbquery_tDBInput_7 + "'.");

				globalMap.put("tDBInput_7_QUERY", dbquery_tDBInput_7);

				java.sql.ResultSet rs_tDBInput_7 = null;

				try {
					rs_tDBInput_7 = stmt_tDBInput_7.executeQuery(dbquery_tDBInput_7);
					java.sql.ResultSetMetaData rsmd_tDBInput_7 = rs_tDBInput_7.getMetaData();
					int colQtyInRs_tDBInput_7 = rsmd_tDBInput_7.getColumnCount();

					String tmpContent_tDBInput_7 = null;

					log.debug("tDBInput_7 - Retrieving records from the database.");

					while (rs_tDBInput_7.next()) {
						nb_line_tDBInput_7++;

						if (colQtyInRs_tDBInput_7 < 1) {
							row11.nmconst = null;
						} else {

							row11.nmconst = routines.system.JDBCUtil.getString(rs_tDBInput_7, 1, false);
						}
						if (colQtyInRs_tDBInput_7 < 2) {
							row11.Crew_SK = 0;
						} else {

							row11.Crew_SK = rs_tDBInput_7.getInt(2);
							if (rs_tDBInput_7.wasNull()) {
								throw new RuntimeException("Null value in non-Nullable column");
							}
						}

						log.debug("tDBInput_7 - Retrieving the record " + nb_line_tDBInput_7 + ".");

						/**
						 * [tDBInput_7 begin ] stop
						 */

						/**
						 * [tDBInput_7 main ] start
						 */

						currentComponent = "tDBInput_7";

						cLabel = "\"dim_crew\"";

						tos_count_tDBInput_7++;

						/**
						 * [tDBInput_7 main ] stop
						 */

						/**
						 * [tDBInput_7 process_data_begin ] start
						 */

						currentComponent = "tDBInput_7";

						cLabel = "\"dim_crew\"";

						/**
						 * [tDBInput_7 process_data_begin ] stop
						 */

						/**
						 * [tAdvancedHash_row11 main ] start
						 */

						currentComponent = "tAdvancedHash_row11";

						if (runStat.update(execStat, enableLogStash, iterateId, 1, 1

								, "row11", "tDBInput_7", "\"dim_crew\"", "tMysqlInput", "tAdvancedHash_row11",
								"tAdvancedHash_row11", "tAdvancedHash"

						)) {
							talendJobLogProcess(globalMap);
						}

						if (log.isTraceEnabled()) {
							log.trace("row11 - " + (row11 == null ? "" : row11.toLogString()));
						}

						row11Struct row11_HashRow = new row11Struct();

						row11_HashRow.nmconst = row11.nmconst;

						row11_HashRow.Crew_SK = row11.Crew_SK;

						tHash_Lookup_row11.put(row11_HashRow);

						tos_count_tAdvancedHash_row11++;

						/**
						 * [tAdvancedHash_row11 main ] stop
						 */

						/**
						 * [tAdvancedHash_row11 process_data_begin ] start
						 */

						currentComponent = "tAdvancedHash_row11";

						/**
						 * [tAdvancedHash_row11 process_data_begin ] stop
						 */

						/**
						 * [tAdvancedHash_row11 process_data_end ] start
						 */

						currentComponent = "tAdvancedHash_row11";

						/**
						 * [tAdvancedHash_row11 process_data_end ] stop
						 */

						/**
						 * [tDBInput_7 process_data_end ] start
						 */

						currentComponent = "tDBInput_7";

						cLabel = "\"dim_crew\"";

						/**
						 * [tDBInput_7 process_data_end ] stop
						 */

						/**
						 * [tDBInput_7 end ] start
						 */

						currentComponent = "tDBInput_7";

						cLabel = "\"dim_crew\"";

					}
				} finally {
					if (rs_tDBInput_7 != null) {
						rs_tDBInput_7.close();
					}
					if (stmt_tDBInput_7 != null) {
						stmt_tDBInput_7.close();
					}
					if (conn_tDBInput_7 != null && !conn_tDBInput_7.isClosed()) {

						log.debug("tDBInput_7 - Closing the connection to the database.");

						conn_tDBInput_7.close();

						if ("com.mysql.cj.jdbc.Driver".equals((String) globalMap.get("driverClass_"))
								&& routines.system.BundleUtils.inOSGi()) {
							Class.forName("com.mysql.cj.jdbc.AbandonedConnectionCleanupThread")
									.getMethod("checkedShutdown").invoke(null, (Object[]) null);
						}

						log.debug("tDBInput_7 - Connection to the database closed.");

					}

				}
				globalMap.put("tDBInput_7_NB_LINE", nb_line_tDBInput_7);
				log.debug("tDBInput_7 - Retrieved records count: " + nb_line_tDBInput_7 + " .");

				if (log.isDebugEnabled())
					log.debug("tDBInput_7 - " + ("Done."));

				ok_Hash.put("tDBInput_7", true);
				end_Hash.put("tDBInput_7", System.currentTimeMillis());

				/**
				 * [tDBInput_7 end ] stop
				 */

				/**
				 * [tAdvancedHash_row11 end ] start
				 */

				currentComponent = "tAdvancedHash_row11";

				tHash_Lookup_row11.endPut();

				if (runStat.updateStatAndLog(execStat, enableLogStash, resourceMap, iterateId, "row11", 2, 0,
						"tDBInput_7", "\"dim_crew\"", "tMysqlInput", "tAdvancedHash_row11", "tAdvancedHash_row11",
						"tAdvancedHash", "output")) {
					talendJobLogProcess(globalMap);
				}

				ok_Hash.put("tAdvancedHash_row11", true);
				end_Hash.put("tAdvancedHash_row11", System.currentTimeMillis());

				/**
				 * [tAdvancedHash_row11 end ] stop
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
				 * [tDBInput_7 finally ] start
				 */

				currentComponent = "tDBInput_7";

				cLabel = "\"dim_crew\"";

				/**
				 * [tDBInput_7 finally ] stop
				 */

				/**
				 * [tAdvancedHash_row11 finally ] start
				 */

				currentComponent = "tAdvancedHash_row11";

				/**
				 * [tAdvancedHash_row11 finally ] stop
				 */

			} catch (java.lang.Exception e) {
				// ignore
			} catch (java.lang.Error error) {
				// ignore
			}
			resourceMap = null;
		}

		globalMap.put("tDBInput_7_SUBPROCESS_STATE", 1);
	}

	public static class row12Struct implements routines.system.IPersistableComparableLookupRow<row12Struct> {
		final static byte[] commonByteArrayLock_FINAL_PROJECT_bridge_crew_movie = new byte[0];
		static byte[] commonByteArray_FINAL_PROJECT_bridge_crew_movie = new byte[0];
		protected static final int DEFAULT_HASHCODE = 1;
		protected static final int PRIME = 31;
		protected int hashCode = DEFAULT_HASHCODE;
		public boolean hashCodeDirty = true;

		public String loopKey;

		public int Profession_SK;

		public int getProfession_SK() {
			return this.Profession_SK;
		}

		public Boolean Profession_SKIsNullable() {
			return false;
		}

		public Boolean Profession_SKIsKey() {
			return false;
		}

		public Integer Profession_SKLength() {
			return 10;
		}

		public Integer Profession_SKPrecision() {
			return 0;
		}

		public String Profession_SKDefault() {

			return "";

		}

		public String Profession_SKComment() {

			return "";

		}

		public String Profession_SKPattern() {

			return "";

		}

		public String Profession_SKOriginalDbColumnName() {

			return "Profession_SK";

		}

		public String Name;

		public String getName() {
			return this.Name;
		}

		public Boolean NameIsNullable() {
			return true;
		}

		public Boolean NameIsKey() {
			return false;
		}

		public Integer NameLength() {
			return 20;
		}

		public Integer NamePrecision() {
			return 0;
		}

		public String NameDefault() {

			return null;

		}

		public String NameComment() {

			return "";

		}

		public String NamePattern() {

			return "";

		}

		public String NameOriginalDbColumnName() {

			return "Name";

		}

		@Override
		public int hashCode() {
			if (this.hashCodeDirty) {
				final int prime = PRIME;
				int result = DEFAULT_HASHCODE;

				result = prime * result + ((this.Name == null) ? 0 : this.Name.hashCode());

				this.hashCode = result;
				this.hashCodeDirty = false;
			}
			return this.hashCode;
		}

		@Override
		public boolean equals(Object obj) {
			if (this == obj)
				return true;
			if (obj == null)
				return false;
			if (getClass() != obj.getClass())
				return false;
			final row12Struct other = (row12Struct) obj;

			if (this.Name == null) {
				if (other.Name != null)
					return false;

			} else if (!this.Name.equals(other.Name))

				return false;

			return true;
		}

		public void copyDataTo(row12Struct other) {

			other.Profession_SK = this.Profession_SK;
			other.Name = this.Name;

		}

		public void copyKeysDataTo(row12Struct other) {

			other.Name = this.Name;

		}

		private String readString(ObjectInputStream dis) throws IOException {
			String strReturn = null;
			int length = 0;
			length = dis.readInt();
			if (length == -1) {
				strReturn = null;
			} else {
				if (length > commonByteArray_FINAL_PROJECT_bridge_crew_movie.length) {
					if (length < 1024 && commonByteArray_FINAL_PROJECT_bridge_crew_movie.length == 0) {
						commonByteArray_FINAL_PROJECT_bridge_crew_movie = new byte[1024];
					} else {
						commonByteArray_FINAL_PROJECT_bridge_crew_movie = new byte[2 * length];
					}
				}
				dis.readFully(commonByteArray_FINAL_PROJECT_bridge_crew_movie, 0, length);
				strReturn = new String(commonByteArray_FINAL_PROJECT_bridge_crew_movie, 0, length, utf8Charset);
			}
			return strReturn;
		}

		private String readString(org.jboss.marshalling.Unmarshaller unmarshaller) throws IOException {
			String strReturn = null;
			int length = 0;
			length = unmarshaller.readInt();
			if (length == -1) {
				strReturn = null;
			} else {
				if (length > commonByteArray_FINAL_PROJECT_bridge_crew_movie.length) {
					if (length < 1024 && commonByteArray_FINAL_PROJECT_bridge_crew_movie.length == 0) {
						commonByteArray_FINAL_PROJECT_bridge_crew_movie = new byte[1024];
					} else {
						commonByteArray_FINAL_PROJECT_bridge_crew_movie = new byte[2 * length];
					}
				}
				unmarshaller.readFully(commonByteArray_FINAL_PROJECT_bridge_crew_movie, 0, length);
				strReturn = new String(commonByteArray_FINAL_PROJECT_bridge_crew_movie, 0, length, utf8Charset);
			}
			return strReturn;
		}

		private void writeString(String str, ObjectOutputStream dos) throws IOException {
			if (str == null) {
				dos.writeInt(-1);
			} else {
				byte[] byteArray = str.getBytes(utf8Charset);
				dos.writeInt(byteArray.length);
				dos.write(byteArray);
			}
		}

		private void writeString(String str, org.jboss.marshalling.Marshaller marshaller) throws IOException {
			if (str == null) {
				marshaller.writeInt(-1);
			} else {
				byte[] byteArray = str.getBytes(utf8Charset);
				marshaller.writeInt(byteArray.length);
				marshaller.write(byteArray);
			}
		}

		public void readKeysData(ObjectInputStream dis) {

			synchronized (commonByteArrayLock_FINAL_PROJECT_bridge_crew_movie) {

				try {

					int length = 0;

					this.Name = readString(dis);

				} catch (IOException e) {
					throw new RuntimeException(e);

				}

			}

		}

		public void readKeysData(org.jboss.marshalling.Unmarshaller dis) {

			synchronized (commonByteArrayLock_FINAL_PROJECT_bridge_crew_movie) {

				try {

					int length = 0;

					this.Name = readString(dis);

				} catch (IOException e) {
					throw new RuntimeException(e);

				}

			}

		}

		public void writeKeysData(ObjectOutputStream dos) {
			try {

				// String

				writeString(this.Name, dos);

			} catch (IOException e) {
				throw new RuntimeException(e);
			}

		}

		public void writeKeysData(org.jboss.marshalling.Marshaller dos) {
			try {

				// String

				writeString(this.Name, dos);

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

				this.Profession_SK = dis.readInt();

			} catch (IOException e) {
				throw new RuntimeException(e);

			}

		}

		public void readValuesData(DataInputStream dis, org.jboss.marshalling.Unmarshaller objectIn) {
			try {
				int length = 0;

				this.Profession_SK = objectIn.readInt();

			} catch (IOException e) {
				throw new RuntimeException(e);

			}

		}

		/**
		 * Return a byte array which represents Values data.
		 */
		public void writeValuesData(DataOutputStream dos, ObjectOutputStream oos) {
			try {

				dos.writeInt(this.Profession_SK);

			} catch (IOException e) {
				throw new RuntimeException(e);
			}

		}

		public void writeValuesData(DataOutputStream dos, org.jboss.marshalling.Marshaller objectOut) {
			try {

				objectOut.writeInt(this.Profession_SK);

			} catch (IOException e) {
				throw new RuntimeException(e);
			}
		}

		public boolean supportMarshaller() {
			return true;
		}

		public String toString() {

			StringBuilder sb = new StringBuilder();
			sb.append(super.toString());
			sb.append("[");
			sb.append("Profession_SK=" + String.valueOf(Profession_SK));
			sb.append(",Name=" + Name);
			sb.append("]");

			return sb.toString();
		}

		public String toLogString() {
			StringBuilder sb = new StringBuilder();

			sb.append(Profession_SK);

			sb.append("|");

			if (Name == null) {
				sb.append("<null>");
			} else {
				sb.append(Name);
			}

			sb.append("|");

			return sb.toString();
		}

		/**
		 * Compare keys
		 */
		public int compareTo(row12Struct other) {

			int returnValue = -1;

			returnValue = checkNullsAndCompare(this.Name, other.Name);
			if (returnValue != 0) {
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

	public void tDBInput_8Process(final java.util.Map<String, Object> globalMap) throws TalendException {
		globalMap.put("tDBInput_8_SUBPROCESS_STATE", 0);

		final boolean execStat = this.execStat;

		mdcInfo.forEach(org.slf4j.MDC::put);
		org.slf4j.MDC.put("_subJobName", "tDBInput_8");
		org.slf4j.MDC.put("_subJobPid", "WhxTdY_" + subJobPidCounter.getAndIncrement());

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

				row12Struct row12 = new row12Struct();

				/**
				 * [tAdvancedHash_row12 begin ] start
				 */

				ok_Hash.put("tAdvancedHash_row12", false);
				start_Hash.put("tAdvancedHash_row12", System.currentTimeMillis());

				currentComponent = "tAdvancedHash_row12";

				runStat.updateStatAndLog(execStat, enableLogStash, resourceMap, iterateId, 0, 0, "row12");

				int tos_count_tAdvancedHash_row12 = 0;

				if (enableLogStash) {
					talendJobLog.addCM("tAdvancedHash_row12", "tAdvancedHash_row12", "tAdvancedHash");
					talendJobLogProcess(globalMap);
				}

				// connection name:row12
				// source node:tDBInput_8 - inputs:(after_tDBInput_2) outputs:(row12,row12) |
				// target node:tAdvancedHash_row12 - inputs:(row12) outputs:()
				// linked node: tMap_4 - inputs:(row10,row11,row12,row13) outputs:(toTable1)

				org.talend.designer.components.lookup.common.ICommonLookup.MATCHING_MODE matchingModeEnum_row12 = org.talend.designer.components.lookup.common.ICommonLookup.MATCHING_MODE.UNIQUE_MATCH;

				org.talend.designer.components.lookup.memory.AdvancedMemoryLookup<row12Struct> tHash_Lookup_row12 = org.talend.designer.components.lookup.memory.AdvancedMemoryLookup
						.<row12Struct>getLookup(matchingModeEnum_row12);

				globalMap.put("tHash_Lookup_row12", tHash_Lookup_row12);

				/**
				 * [tAdvancedHash_row12 begin ] stop
				 */

				/**
				 * [tDBInput_8 begin ] start
				 */

				ok_Hash.put("tDBInput_8", false);
				start_Hash.put("tDBInput_8", System.currentTimeMillis());

				currentComponent = "tDBInput_8";

				cLabel = "\"dim_profession\"";

				int tos_count_tDBInput_8 = 0;

				if (log.isDebugEnabled())
					log.debug("tDBInput_8 - " + ("Start to work."));
				if (log.isDebugEnabled()) {
					class BytesLimit65535_tDBInput_8 {
						public void limitLog4jByte() throws Exception {
							StringBuilder log4jParamters_tDBInput_8 = new StringBuilder();
							log4jParamters_tDBInput_8.append("Parameters:");
							log4jParamters_tDBInput_8.append("DB_VERSION" + " = " + "MYSQL_8");
							log4jParamters_tDBInput_8.append(" | ");
							log4jParamters_tDBInput_8.append("USE_EXISTING_CONNECTION" + " = " + "false");
							log4jParamters_tDBInput_8.append(" | ");
							log4jParamters_tDBInput_8.append("HOST" + " = " + "\"127.0.0.1\"");
							log4jParamters_tDBInput_8.append(" | ");
							log4jParamters_tDBInput_8.append("PORT" + " = " + "\"3306\"");
							log4jParamters_tDBInput_8.append(" | ");
							log4jParamters_tDBInput_8.append("DBNAME" + " = " + "\"imdb_src\"");
							log4jParamters_tDBInput_8.append(" | ");
							log4jParamters_tDBInput_8.append("USER" + " = " + "\"user2\"");
							log4jParamters_tDBInput_8.append(" | ");
							log4jParamters_tDBInput_8.append("PASS" + " = " + String.valueOf(
									"enc:routine.encryption.key.v1:uSd0VZlLNZj1Sq8FEcT+nGhJxhyf2lRNTODNpDCkicl0045n")
									.substring(0, 4) + "...");
							log4jParamters_tDBInput_8.append(" | ");
							log4jParamters_tDBInput_8.append("TABLE" + " = " + "\"dim_profession\"");
							log4jParamters_tDBInput_8.append(" | ");
							log4jParamters_tDBInput_8.append("QUERYSTORE" + " = " + "\"\"");
							log4jParamters_tDBInput_8.append(" | ");
							log4jParamters_tDBInput_8.append("QUERY" + " = "
									+ "\"SELECT    `dim_profession`.`Profession_SK`,    `dim_profession`.`Name` FROM `dim_profession`\"");
							log4jParamters_tDBInput_8.append(" | ");
							log4jParamters_tDBInput_8.append("SPECIFY_DATASOURCE_ALIAS" + " = " + "false");
							log4jParamters_tDBInput_8.append(" | ");
							log4jParamters_tDBInput_8.append("PROPERTIES" + " = "
									+ "\"noDatetimeStringSync=true&enabledTLSProtocols=TLSv1.2,TLSv1.1,TLSv1\"");
							log4jParamters_tDBInput_8.append(" | ");
							log4jParamters_tDBInput_8.append("ENABLE_STREAM" + " = " + "false");
							log4jParamters_tDBInput_8.append(" | ");
							log4jParamters_tDBInput_8.append("TRIM_ALL_COLUMN" + " = " + "false");
							log4jParamters_tDBInput_8.append(" | ");
							log4jParamters_tDBInput_8.append("TRIM_COLUMN" + " = " + "[{TRIM=" + ("false")
									+ ", SCHEMA_COLUMN=" + ("Profession_SK") + "}, {TRIM=" + ("false")
									+ ", SCHEMA_COLUMN=" + ("Name") + "}]");
							log4jParamters_tDBInput_8.append(" | ");
							log4jParamters_tDBInput_8.append("UNIFIED_COMPONENTS" + " = " + "tMysqlInput");
							log4jParamters_tDBInput_8.append(" | ");
							if (log.isDebugEnabled())
								log.debug("tDBInput_8 - " + (log4jParamters_tDBInput_8));
						}
					}
					new BytesLimit65535_tDBInput_8().limitLog4jByte();
				}
				if (enableLogStash) {
					talendJobLog.addCM("tDBInput_8", "\"dim_profession\"", "tMysqlInput");
					talendJobLogProcess(globalMap);
				}

				java.util.Calendar calendar_tDBInput_8 = java.util.Calendar.getInstance();
				calendar_tDBInput_8.set(0, 0, 0, 0, 0, 0);
				java.util.Date year0_tDBInput_8 = calendar_tDBInput_8.getTime();
				int nb_line_tDBInput_8 = 0;
				java.sql.Connection conn_tDBInput_8 = null;
				String driverClass_tDBInput_8 = "com.mysql.cj.jdbc.Driver";
				java.lang.Class jdbcclazz_tDBInput_8 = java.lang.Class.forName(driverClass_tDBInput_8);
				String dbUser_tDBInput_8 = "user2";

				final String decryptedPassword_tDBInput_8 = routines.system.PasswordEncryptUtil.decryptPassword(
						"enc:routine.encryption.key.v1:OyNBMzmRMIRxggRHs1oNxoVspSOh6lAn0OMYYRm8PfHQgF0J");

				String dbPwd_tDBInput_8 = decryptedPassword_tDBInput_8;

				String properties_tDBInput_8 = "noDatetimeStringSync=true&enabledTLSProtocols=TLSv1.2,TLSv1.1,TLSv1";
				if (properties_tDBInput_8 == null || properties_tDBInput_8.trim().length() == 0) {
					properties_tDBInput_8 = "";
				}
				String url_tDBInput_8 = "jdbc:mysql://" + "127.0.0.1" + ":" + "3306" + "/" + "imdb_src" + "?"
						+ properties_tDBInput_8;

				log.debug("tDBInput_8 - Driver ClassName: " + driverClass_tDBInput_8 + ".");

				log.debug("tDBInput_8 - Connection attempt to '" + url_tDBInput_8 + "' with the username '"
						+ dbUser_tDBInput_8 + "'.");

				conn_tDBInput_8 = java.sql.DriverManager.getConnection(url_tDBInput_8, dbUser_tDBInput_8,
						dbPwd_tDBInput_8);
				log.debug("tDBInput_8 - Connection to '" + url_tDBInput_8 + "' has succeeded.");

				java.sql.Statement stmt_tDBInput_8 = conn_tDBInput_8.createStatement();

				String dbquery_tDBInput_8 = "SELECT \n  `dim_profession`.`Profession_SK`, \n  `dim_profession`.`Name`\nFROM `dim_profession`";

				log.debug("tDBInput_8 - Executing the query: '" + dbquery_tDBInput_8 + "'.");

				globalMap.put("tDBInput_8_QUERY", dbquery_tDBInput_8);

				java.sql.ResultSet rs_tDBInput_8 = null;

				try {
					rs_tDBInput_8 = stmt_tDBInput_8.executeQuery(dbquery_tDBInput_8);
					java.sql.ResultSetMetaData rsmd_tDBInput_8 = rs_tDBInput_8.getMetaData();
					int colQtyInRs_tDBInput_8 = rsmd_tDBInput_8.getColumnCount();

					String tmpContent_tDBInput_8 = null;

					log.debug("tDBInput_8 - Retrieving records from the database.");

					while (rs_tDBInput_8.next()) {
						nb_line_tDBInput_8++;

						if (colQtyInRs_tDBInput_8 < 1) {
							row12.Profession_SK = 0;
						} else {

							row12.Profession_SK = rs_tDBInput_8.getInt(1);
							if (rs_tDBInput_8.wasNull()) {
								throw new RuntimeException("Null value in non-Nullable column");
							}
						}
						if (colQtyInRs_tDBInput_8 < 2) {
							row12.Name = null;
						} else {

							row12.Name = routines.system.JDBCUtil.getString(rs_tDBInput_8, 2, false);
						}

						log.debug("tDBInput_8 - Retrieving the record " + nb_line_tDBInput_8 + ".");

						/**
						 * [tDBInput_8 begin ] stop
						 */

						/**
						 * [tDBInput_8 main ] start
						 */

						currentComponent = "tDBInput_8";

						cLabel = "\"dim_profession\"";

						tos_count_tDBInput_8++;

						/**
						 * [tDBInput_8 main ] stop
						 */

						/**
						 * [tDBInput_8 process_data_begin ] start
						 */

						currentComponent = "tDBInput_8";

						cLabel = "\"dim_profession\"";

						/**
						 * [tDBInput_8 process_data_begin ] stop
						 */

						/**
						 * [tAdvancedHash_row12 main ] start
						 */

						currentComponent = "tAdvancedHash_row12";

						if (runStat.update(execStat, enableLogStash, iterateId, 1, 1

								, "row12", "tDBInput_8", "\"dim_profession\"", "tMysqlInput", "tAdvancedHash_row12",
								"tAdvancedHash_row12", "tAdvancedHash"

						)) {
							talendJobLogProcess(globalMap);
						}

						if (log.isTraceEnabled()) {
							log.trace("row12 - " + (row12 == null ? "" : row12.toLogString()));
						}

						row12Struct row12_HashRow = new row12Struct();

						row12_HashRow.Profession_SK = row12.Profession_SK;

						row12_HashRow.Name = row12.Name;

						tHash_Lookup_row12.put(row12_HashRow);

						tos_count_tAdvancedHash_row12++;

						/**
						 * [tAdvancedHash_row12 main ] stop
						 */

						/**
						 * [tAdvancedHash_row12 process_data_begin ] start
						 */

						currentComponent = "tAdvancedHash_row12";

						/**
						 * [tAdvancedHash_row12 process_data_begin ] stop
						 */

						/**
						 * [tAdvancedHash_row12 process_data_end ] start
						 */

						currentComponent = "tAdvancedHash_row12";

						/**
						 * [tAdvancedHash_row12 process_data_end ] stop
						 */

						/**
						 * [tDBInput_8 process_data_end ] start
						 */

						currentComponent = "tDBInput_8";

						cLabel = "\"dim_profession\"";

						/**
						 * [tDBInput_8 process_data_end ] stop
						 */

						/**
						 * [tDBInput_8 end ] start
						 */

						currentComponent = "tDBInput_8";

						cLabel = "\"dim_profession\"";

					}
				} finally {
					if (rs_tDBInput_8 != null) {
						rs_tDBInput_8.close();
					}
					if (stmt_tDBInput_8 != null) {
						stmt_tDBInput_8.close();
					}
					if (conn_tDBInput_8 != null && !conn_tDBInput_8.isClosed()) {

						log.debug("tDBInput_8 - Closing the connection to the database.");

						conn_tDBInput_8.close();

						if ("com.mysql.cj.jdbc.Driver".equals((String) globalMap.get("driverClass_"))
								&& routines.system.BundleUtils.inOSGi()) {
							Class.forName("com.mysql.cj.jdbc.AbandonedConnectionCleanupThread")
									.getMethod("checkedShutdown").invoke(null, (Object[]) null);
						}

						log.debug("tDBInput_8 - Connection to the database closed.");

					}

				}
				globalMap.put("tDBInput_8_NB_LINE", nb_line_tDBInput_8);
				log.debug("tDBInput_8 - Retrieved records count: " + nb_line_tDBInput_8 + " .");

				if (log.isDebugEnabled())
					log.debug("tDBInput_8 - " + ("Done."));

				ok_Hash.put("tDBInput_8", true);
				end_Hash.put("tDBInput_8", System.currentTimeMillis());

				/**
				 * [tDBInput_8 end ] stop
				 */

				/**
				 * [tAdvancedHash_row12 end ] start
				 */

				currentComponent = "tAdvancedHash_row12";

				tHash_Lookup_row12.endPut();

				if (runStat.updateStatAndLog(execStat, enableLogStash, resourceMap, iterateId, "row12", 2, 0,
						"tDBInput_8", "\"dim_profession\"", "tMysqlInput", "tAdvancedHash_row12", "tAdvancedHash_row12",
						"tAdvancedHash", "output")) {
					talendJobLogProcess(globalMap);
				}

				ok_Hash.put("tAdvancedHash_row12", true);
				end_Hash.put("tAdvancedHash_row12", System.currentTimeMillis());

				/**
				 * [tAdvancedHash_row12 end ] stop
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
				 * [tDBInput_8 finally ] start
				 */

				currentComponent = "tDBInput_8";

				cLabel = "\"dim_profession\"";

				/**
				 * [tDBInput_8 finally ] stop
				 */

				/**
				 * [tAdvancedHash_row12 finally ] start
				 */

				currentComponent = "tAdvancedHash_row12";

				/**
				 * [tAdvancedHash_row12 finally ] stop
				 */

			} catch (java.lang.Exception e) {
				// ignore
			} catch (java.lang.Error error) {
				// ignore
			}
			resourceMap = null;
		}

		globalMap.put("tDBInput_8_SUBPROCESS_STATE", 1);
	}

	public static class row13Struct implements routines.system.IPersistableComparableLookupRow<row13Struct> {
		final static byte[] commonByteArrayLock_FINAL_PROJECT_bridge_crew_movie = new byte[0];
		static byte[] commonByteArray_FINAL_PROJECT_bridge_crew_movie = new byte[0];
		protected static final int DEFAULT_HASHCODE = 1;
		protected static final int PRIME = 31;
		protected int hashCode = DEFAULT_HASHCODE;
		public boolean hashCodeDirty = true;

		public String loopKey;

		public int Movie_ID;

		public int getMovie_ID() {
			return this.Movie_ID;
		}

		public Boolean Movie_IDIsNullable() {
			return false;
		}

		public Boolean Movie_IDIsKey() {
			return false;
		}

		public Integer Movie_IDLength() {
			return 10;
		}

		public Integer Movie_IDPrecision() {
			return 0;
		}

		public String Movie_IDDefault() {

			return "";

		}

		public String Movie_IDComment() {

			return "";

		}

		public String Movie_IDPattern() {

			return "";

		}

		public String Movie_IDOriginalDbColumnName() {

			return "Movie_ID";

		}

		public String tconst;

		public String getTconst() {
			return this.tconst;
		}

		public Boolean tconstIsNullable() {
			return true;
		}

		public Boolean tconstIsKey() {
			return false;
		}

		public Integer tconstLength() {
			return 10;
		}

		public Integer tconstPrecision() {
			return 0;
		}

		public String tconstDefault() {

			return null;

		}

		public String tconstComment() {

			return "";

		}

		public String tconstPattern() {

			return "";

		}

		public String tconstOriginalDbColumnName() {

			return "tconst";

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
			if (this == obj)
				return true;
			if (obj == null)
				return false;
			if (getClass() != obj.getClass())
				return false;
			final row13Struct other = (row13Struct) obj;

			if (this.tconst == null) {
				if (other.tconst != null)
					return false;

			} else if (!this.tconst.equals(other.tconst))

				return false;

			return true;
		}

		public void copyDataTo(row13Struct other) {

			other.Movie_ID = this.Movie_ID;
			other.tconst = this.tconst;

		}

		public void copyKeysDataTo(row13Struct other) {

			other.tconst = this.tconst;

		}

		private String readString(ObjectInputStream dis) throws IOException {
			String strReturn = null;
			int length = 0;
			length = dis.readInt();
			if (length == -1) {
				strReturn = null;
			} else {
				if (length > commonByteArray_FINAL_PROJECT_bridge_crew_movie.length) {
					if (length < 1024 && commonByteArray_FINAL_PROJECT_bridge_crew_movie.length == 0) {
						commonByteArray_FINAL_PROJECT_bridge_crew_movie = new byte[1024];
					} else {
						commonByteArray_FINAL_PROJECT_bridge_crew_movie = new byte[2 * length];
					}
				}
				dis.readFully(commonByteArray_FINAL_PROJECT_bridge_crew_movie, 0, length);
				strReturn = new String(commonByteArray_FINAL_PROJECT_bridge_crew_movie, 0, length, utf8Charset);
			}
			return strReturn;
		}

		private String readString(org.jboss.marshalling.Unmarshaller unmarshaller) throws IOException {
			String strReturn = null;
			int length = 0;
			length = unmarshaller.readInt();
			if (length == -1) {
				strReturn = null;
			} else {
				if (length > commonByteArray_FINAL_PROJECT_bridge_crew_movie.length) {
					if (length < 1024 && commonByteArray_FINAL_PROJECT_bridge_crew_movie.length == 0) {
						commonByteArray_FINAL_PROJECT_bridge_crew_movie = new byte[1024];
					} else {
						commonByteArray_FINAL_PROJECT_bridge_crew_movie = new byte[2 * length];
					}
				}
				unmarshaller.readFully(commonByteArray_FINAL_PROJECT_bridge_crew_movie, 0, length);
				strReturn = new String(commonByteArray_FINAL_PROJECT_bridge_crew_movie, 0, length, utf8Charset);
			}
			return strReturn;
		}

		private void writeString(String str, ObjectOutputStream dos) throws IOException {
			if (str == null) {
				dos.writeInt(-1);
			} else {
				byte[] byteArray = str.getBytes(utf8Charset);
				dos.writeInt(byteArray.length);
				dos.write(byteArray);
			}
		}

		private void writeString(String str, org.jboss.marshalling.Marshaller marshaller) throws IOException {
			if (str == null) {
				marshaller.writeInt(-1);
			} else {
				byte[] byteArray = str.getBytes(utf8Charset);
				marshaller.writeInt(byteArray.length);
				marshaller.write(byteArray);
			}
		}

		public void readKeysData(ObjectInputStream dis) {

			synchronized (commonByteArrayLock_FINAL_PROJECT_bridge_crew_movie) {

				try {

					int length = 0;

					this.tconst = readString(dis);

				} catch (IOException e) {
					throw new RuntimeException(e);

				}

			}

		}

		public void readKeysData(org.jboss.marshalling.Unmarshaller dis) {

			synchronized (commonByteArrayLock_FINAL_PROJECT_bridge_crew_movie) {

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

				writeString(this.tconst, dos);

			} catch (IOException e) {
				throw new RuntimeException(e);
			}

		}

		public void writeKeysData(org.jboss.marshalling.Marshaller dos) {
			try {

				// String

				writeString(this.tconst, dos);

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

				this.Movie_ID = dis.readInt();

			} catch (IOException e) {
				throw new RuntimeException(e);

			}

		}

		public void readValuesData(DataInputStream dis, org.jboss.marshalling.Unmarshaller objectIn) {
			try {
				int length = 0;

				this.Movie_ID = objectIn.readInt();

			} catch (IOException e) {
				throw new RuntimeException(e);

			}

		}

		/**
		 * Return a byte array which represents Values data.
		 */
		public void writeValuesData(DataOutputStream dos, ObjectOutputStream oos) {
			try {

				dos.writeInt(this.Movie_ID);

			} catch (IOException e) {
				throw new RuntimeException(e);
			}

		}

		public void writeValuesData(DataOutputStream dos, org.jboss.marshalling.Marshaller objectOut) {
			try {

				objectOut.writeInt(this.Movie_ID);

			} catch (IOException e) {
				throw new RuntimeException(e);
			}
		}

		public boolean supportMarshaller() {
			return true;
		}

		public String toString() {

			StringBuilder sb = new StringBuilder();
			sb.append(super.toString());
			sb.append("[");
			sb.append("Movie_ID=" + String.valueOf(Movie_ID));
			sb.append(",tconst=" + tconst);
			sb.append("]");

			return sb.toString();
		}

		public String toLogString() {
			StringBuilder sb = new StringBuilder();

			sb.append(Movie_ID);

			sb.append("|");

			if (tconst == null) {
				sb.append("<null>");
			} else {
				sb.append(tconst);
			}

			sb.append("|");

			return sb.toString();
		}

		/**
		 * Compare keys
		 */
		public int compareTo(row13Struct other) {

			int returnValue = -1;

			returnValue = checkNullsAndCompare(this.tconst, other.tconst);
			if (returnValue != 0) {
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

	public void tDBInput_9Process(final java.util.Map<String, Object> globalMap) throws TalendException {
		globalMap.put("tDBInput_9_SUBPROCESS_STATE", 0);

		final boolean execStat = this.execStat;

		mdcInfo.forEach(org.slf4j.MDC::put);
		org.slf4j.MDC.put("_subJobName", "tDBInput_9");
		org.slf4j.MDC.put("_subJobPid", "iSdPN5_" + subJobPidCounter.getAndIncrement());

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

				row13Struct row13 = new row13Struct();

				/**
				 * [tAdvancedHash_row13 begin ] start
				 */

				ok_Hash.put("tAdvancedHash_row13", false);
				start_Hash.put("tAdvancedHash_row13", System.currentTimeMillis());

				currentComponent = "tAdvancedHash_row13";

				runStat.updateStatAndLog(execStat, enableLogStash, resourceMap, iterateId, 0, 0, "row13");

				int tos_count_tAdvancedHash_row13 = 0;

				if (enableLogStash) {
					talendJobLog.addCM("tAdvancedHash_row13", "tAdvancedHash_row13", "tAdvancedHash");
					talendJobLogProcess(globalMap);
				}

				// connection name:row13
				// source node:tDBInput_9 - inputs:(after_tDBInput_2) outputs:(row13,row13) |
				// target node:tAdvancedHash_row13 - inputs:(row13) outputs:()
				// linked node: tMap_4 - inputs:(row10,row11,row12,row13) outputs:(toTable1)

				org.talend.designer.components.lookup.common.ICommonLookup.MATCHING_MODE matchingModeEnum_row13 = org.talend.designer.components.lookup.common.ICommonLookup.MATCHING_MODE.UNIQUE_MATCH;

				org.talend.designer.components.lookup.memory.AdvancedMemoryLookup<row13Struct> tHash_Lookup_row13 = org.talend.designer.components.lookup.memory.AdvancedMemoryLookup
						.<row13Struct>getLookup(matchingModeEnum_row13);

				globalMap.put("tHash_Lookup_row13", tHash_Lookup_row13);

				/**
				 * [tAdvancedHash_row13 begin ] stop
				 */

				/**
				 * [tDBInput_9 begin ] start
				 */

				ok_Hash.put("tDBInput_9", false);
				start_Hash.put("tDBInput_9", System.currentTimeMillis());

				currentComponent = "tDBInput_9";

				cLabel = "\"fact_movie\"";

				int tos_count_tDBInput_9 = 0;

				if (log.isDebugEnabled())
					log.debug("tDBInput_9 - " + ("Start to work."));
				if (log.isDebugEnabled()) {
					class BytesLimit65535_tDBInput_9 {
						public void limitLog4jByte() throws Exception {
							StringBuilder log4jParamters_tDBInput_9 = new StringBuilder();
							log4jParamters_tDBInput_9.append("Parameters:");
							log4jParamters_tDBInput_9.append("DB_VERSION" + " = " + "MYSQL_8");
							log4jParamters_tDBInput_9.append(" | ");
							log4jParamters_tDBInput_9.append("USE_EXISTING_CONNECTION" + " = " + "false");
							log4jParamters_tDBInput_9.append(" | ");
							log4jParamters_tDBInput_9.append("HOST" + " = " + "\"127.0.0.1\"");
							log4jParamters_tDBInput_9.append(" | ");
							log4jParamters_tDBInput_9.append("PORT" + " = " + "\"3306\"");
							log4jParamters_tDBInput_9.append(" | ");
							log4jParamters_tDBInput_9.append("DBNAME" + " = " + "\"imdb_src\"");
							log4jParamters_tDBInput_9.append(" | ");
							log4jParamters_tDBInput_9.append("USER" + " = " + "\"user2\"");
							log4jParamters_tDBInput_9.append(" | ");
							log4jParamters_tDBInput_9.append("PASS" + " = " + String.valueOf(
									"enc:routine.encryption.key.v1:4Hjki9A0hlCFPgCjQdhzHSJarTg0WI0cqwnjbyouJXRi4VZN")
									.substring(0, 4) + "...");
							log4jParamters_tDBInput_9.append(" | ");
							log4jParamters_tDBInput_9.append("TABLE" + " = " + "\"fact_movie\"");
							log4jParamters_tDBInput_9.append(" | ");
							log4jParamters_tDBInput_9.append("QUERYSTORE" + " = " + "\"\"");
							log4jParamters_tDBInput_9.append(" | ");
							log4jParamters_tDBInput_9.append("QUERY" + " = "
									+ "\"SELECT    `fact_movie`.`Movie_ID`,    `fact_movie`.`tconst` FROM `fact_movie`\"");
							log4jParamters_tDBInput_9.append(" | ");
							log4jParamters_tDBInput_9.append("SPECIFY_DATASOURCE_ALIAS" + " = " + "false");
							log4jParamters_tDBInput_9.append(" | ");
							log4jParamters_tDBInput_9.append("PROPERTIES" + " = "
									+ "\"noDatetimeStringSync=true&enabledTLSProtocols=TLSv1.2,TLSv1.1,TLSv1\"");
							log4jParamters_tDBInput_9.append(" | ");
							log4jParamters_tDBInput_9.append("ENABLE_STREAM" + " = " + "false");
							log4jParamters_tDBInput_9.append(" | ");
							log4jParamters_tDBInput_9.append("TRIM_ALL_COLUMN" + " = " + "false");
							log4jParamters_tDBInput_9.append(" | ");
							log4jParamters_tDBInput_9.append(
									"TRIM_COLUMN" + " = " + "[{TRIM=" + ("false") + ", SCHEMA_COLUMN=" + ("Movie_ID")
											+ "}, {TRIM=" + ("false") + ", SCHEMA_COLUMN=" + ("tconst") + "}]");
							log4jParamters_tDBInput_9.append(" | ");
							log4jParamters_tDBInput_9.append("UNIFIED_COMPONENTS" + " = " + "tMysqlInput");
							log4jParamters_tDBInput_9.append(" | ");
							if (log.isDebugEnabled())
								log.debug("tDBInput_9 - " + (log4jParamters_tDBInput_9));
						}
					}
					new BytesLimit65535_tDBInput_9().limitLog4jByte();
				}
				if (enableLogStash) {
					talendJobLog.addCM("tDBInput_9", "\"fact_movie\"", "tMysqlInput");
					talendJobLogProcess(globalMap);
				}

				java.util.Calendar calendar_tDBInput_9 = java.util.Calendar.getInstance();
				calendar_tDBInput_9.set(0, 0, 0, 0, 0, 0);
				java.util.Date year0_tDBInput_9 = calendar_tDBInput_9.getTime();
				int nb_line_tDBInput_9 = 0;
				java.sql.Connection conn_tDBInput_9 = null;
				String driverClass_tDBInput_9 = "com.mysql.cj.jdbc.Driver";
				java.lang.Class jdbcclazz_tDBInput_9 = java.lang.Class.forName(driverClass_tDBInput_9);
				String dbUser_tDBInput_9 = "user2";

				final String decryptedPassword_tDBInput_9 = routines.system.PasswordEncryptUtil.decryptPassword(
						"enc:routine.encryption.key.v1:0gNcqEfyMx5BP3XPp6C6RiU6PA/uTBlrgMLoaZklza50N6Uv");

				String dbPwd_tDBInput_9 = decryptedPassword_tDBInput_9;

				String properties_tDBInput_9 = "noDatetimeStringSync=true&enabledTLSProtocols=TLSv1.2,TLSv1.1,TLSv1";
				if (properties_tDBInput_9 == null || properties_tDBInput_9.trim().length() == 0) {
					properties_tDBInput_9 = "";
				}
				String url_tDBInput_9 = "jdbc:mysql://" + "127.0.0.1" + ":" + "3306" + "/" + "imdb_src" + "?"
						+ properties_tDBInput_9;

				log.debug("tDBInput_9 - Driver ClassName: " + driverClass_tDBInput_9 + ".");

				log.debug("tDBInput_9 - Connection attempt to '" + url_tDBInput_9 + "' with the username '"
						+ dbUser_tDBInput_9 + "'.");

				conn_tDBInput_9 = java.sql.DriverManager.getConnection(url_tDBInput_9, dbUser_tDBInput_9,
						dbPwd_tDBInput_9);
				log.debug("tDBInput_9 - Connection to '" + url_tDBInput_9 + "' has succeeded.");

				java.sql.Statement stmt_tDBInput_9 = conn_tDBInput_9.createStatement();

				String dbquery_tDBInput_9 = "SELECT \n  `fact_movie`.`Movie_ID`, \n  `fact_movie`.`tconst`\nFROM `fact_movie`";

				log.debug("tDBInput_9 - Executing the query: '" + dbquery_tDBInput_9 + "'.");

				globalMap.put("tDBInput_9_QUERY", dbquery_tDBInput_9);

				java.sql.ResultSet rs_tDBInput_9 = null;

				try {
					rs_tDBInput_9 = stmt_tDBInput_9.executeQuery(dbquery_tDBInput_9);
					java.sql.ResultSetMetaData rsmd_tDBInput_9 = rs_tDBInput_9.getMetaData();
					int colQtyInRs_tDBInput_9 = rsmd_tDBInput_9.getColumnCount();

					String tmpContent_tDBInput_9 = null;

					log.debug("tDBInput_9 - Retrieving records from the database.");

					while (rs_tDBInput_9.next()) {
						nb_line_tDBInput_9++;

						if (colQtyInRs_tDBInput_9 < 1) {
							row13.Movie_ID = 0;
						} else {

							row13.Movie_ID = rs_tDBInput_9.getInt(1);
							if (rs_tDBInput_9.wasNull()) {
								throw new RuntimeException("Null value in non-Nullable column");
							}
						}
						if (colQtyInRs_tDBInput_9 < 2) {
							row13.tconst = null;
						} else {

							row13.tconst = routines.system.JDBCUtil.getString(rs_tDBInput_9, 2, false);
						}

						log.debug("tDBInput_9 - Retrieving the record " + nb_line_tDBInput_9 + ".");

						/**
						 * [tDBInput_9 begin ] stop
						 */

						/**
						 * [tDBInput_9 main ] start
						 */

						currentComponent = "tDBInput_9";

						cLabel = "\"fact_movie\"";

						tos_count_tDBInput_9++;

						/**
						 * [tDBInput_9 main ] stop
						 */

						/**
						 * [tDBInput_9 process_data_begin ] start
						 */

						currentComponent = "tDBInput_9";

						cLabel = "\"fact_movie\"";

						/**
						 * [tDBInput_9 process_data_begin ] stop
						 */

						/**
						 * [tAdvancedHash_row13 main ] start
						 */

						currentComponent = "tAdvancedHash_row13";

						if (runStat.update(execStat, enableLogStash, iterateId, 1, 1

								, "row13", "tDBInput_9", "\"fact_movie\"", "tMysqlInput", "tAdvancedHash_row13",
								"tAdvancedHash_row13", "tAdvancedHash"

						)) {
							talendJobLogProcess(globalMap);
						}

						if (log.isTraceEnabled()) {
							log.trace("row13 - " + (row13 == null ? "" : row13.toLogString()));
						}

						row13Struct row13_HashRow = new row13Struct();

						row13_HashRow.Movie_ID = row13.Movie_ID;

						row13_HashRow.tconst = row13.tconst;

						tHash_Lookup_row13.put(row13_HashRow);

						tos_count_tAdvancedHash_row13++;

						/**
						 * [tAdvancedHash_row13 main ] stop
						 */

						/**
						 * [tAdvancedHash_row13 process_data_begin ] start
						 */

						currentComponent = "tAdvancedHash_row13";

						/**
						 * [tAdvancedHash_row13 process_data_begin ] stop
						 */

						/**
						 * [tAdvancedHash_row13 process_data_end ] start
						 */

						currentComponent = "tAdvancedHash_row13";

						/**
						 * [tAdvancedHash_row13 process_data_end ] stop
						 */

						/**
						 * [tDBInput_9 process_data_end ] start
						 */

						currentComponent = "tDBInput_9";

						cLabel = "\"fact_movie\"";

						/**
						 * [tDBInput_9 process_data_end ] stop
						 */

						/**
						 * [tDBInput_9 end ] start
						 */

						currentComponent = "tDBInput_9";

						cLabel = "\"fact_movie\"";

					}
				} finally {
					if (rs_tDBInput_9 != null) {
						rs_tDBInput_9.close();
					}
					if (stmt_tDBInput_9 != null) {
						stmt_tDBInput_9.close();
					}
					if (conn_tDBInput_9 != null && !conn_tDBInput_9.isClosed()) {

						log.debug("tDBInput_9 - Closing the connection to the database.");

						conn_tDBInput_9.close();

						if ("com.mysql.cj.jdbc.Driver".equals((String) globalMap.get("driverClass_"))
								&& routines.system.BundleUtils.inOSGi()) {
							Class.forName("com.mysql.cj.jdbc.AbandonedConnectionCleanupThread")
									.getMethod("checkedShutdown").invoke(null, (Object[]) null);
						}

						log.debug("tDBInput_9 - Connection to the database closed.");

					}

				}
				globalMap.put("tDBInput_9_NB_LINE", nb_line_tDBInput_9);
				log.debug("tDBInput_9 - Retrieved records count: " + nb_line_tDBInput_9 + " .");

				if (log.isDebugEnabled())
					log.debug("tDBInput_9 - " + ("Done."));

				ok_Hash.put("tDBInput_9", true);
				end_Hash.put("tDBInput_9", System.currentTimeMillis());

				/**
				 * [tDBInput_9 end ] stop
				 */

				/**
				 * [tAdvancedHash_row13 end ] start
				 */

				currentComponent = "tAdvancedHash_row13";

				tHash_Lookup_row13.endPut();

				if (runStat.updateStatAndLog(execStat, enableLogStash, resourceMap, iterateId, "row13", 2, 0,
						"tDBInput_9", "\"fact_movie\"", "tMysqlInput", "tAdvancedHash_row13", "tAdvancedHash_row13",
						"tAdvancedHash", "output")) {
					talendJobLogProcess(globalMap);
				}

				ok_Hash.put("tAdvancedHash_row13", true);
				end_Hash.put("tAdvancedHash_row13", System.currentTimeMillis());

				/**
				 * [tAdvancedHash_row13 end ] stop
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
				 * [tDBInput_9 finally ] start
				 */

				currentComponent = "tDBInput_9";

				cLabel = "\"fact_movie\"";

				/**
				 * [tDBInput_9 finally ] stop
				 */

				/**
				 * [tAdvancedHash_row13 finally ] start
				 */

				currentComponent = "tAdvancedHash_row13";

				/**
				 * [tAdvancedHash_row13 finally ] stop
				 */

			} catch (java.lang.Exception e) {
				// ignore
			} catch (java.lang.Error error) {
				// ignore
			}
			resourceMap = null;
		}

		globalMap.put("tDBInput_9_SUBPROCESS_STATE", 1);
	}

	public void talendJobLogProcess(final java.util.Map<String, Object> globalMap) throws TalendException {
		globalMap.put("talendJobLog_SUBPROCESS_STATE", 0);

		final boolean execStat = this.execStat;

		mdcInfo.forEach(org.slf4j.MDC::put);
		org.slf4j.MDC.put("_subJobName", "talendJobLog");
		org.slf4j.MDC.put("_subJobPid", "XRf8io_" + subJobPidCounter.getAndIncrement());

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
		final bridge_crew_movie bridge_crew_movieClass = new bridge_crew_movie();

		int exitCode = bridge_crew_movieClass.runJobInTOS(args);
		if (exitCode == 0) {
			log.info("TalendJob: 'bridge_crew_movie' - Done.");
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
		log.info("TalendJob: 'bridge_crew_movie' - Start.");

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
		org.slf4j.MDC.put("_jobRepositoryId", "_q5XesJFJEe6zXrZhesgs5g");
		org.slf4j.MDC.put("_compiledAtTimestamp", "2023-12-02T23:39:45.326199500Z");

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
			java.io.InputStream inContext = bridge_crew_movie.class.getClassLoader()
					.getResourceAsStream("final_project/bridge_crew_movie_0_1/contexts/" + contextStr + ".properties");
			if (inContext == null) {
				inContext = bridge_crew_movie.class.getClassLoader()
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
		log.info("TalendJob: 'bridge_crew_movie' - Started.");
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
			tDBInput_3Process(globalMap);
			if (!"failure".equals(status)) {
				status = "end";
			}
		} catch (TalendException e_tDBInput_3) {
			globalMap.put("tDBInput_3_SUBPROCESS_STATE", -1);

			e_tDBInput_3.printStackTrace();

		}

		this.globalResumeTicket = true;// to run tPostJob

		end = System.currentTimeMillis();

		if (watch) {
			System.out.println((end - startTime) + " milliseconds");
		}

		endUsedMemory = Runtime.getRuntime().totalMemory() - Runtime.getRuntime().freeMemory();
		if (false) {
			System.out.println(
					(endUsedMemory - startUsedMemory) + " bytes memory increase when running : bridge_crew_movie");
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
		log.info("TalendJob: 'bridge_crew_movie' - Finished - status: " + status + " returnCode: " + returnCode);

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
 * 463422 characters generated by Talend Cloud Data Fabric on the December 2,
 * 2023 at 6:39:45 PM EST
 ************************************************************************************************/