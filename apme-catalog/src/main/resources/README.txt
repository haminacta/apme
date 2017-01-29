<datasource jta="false" jndi-name="java:/jdbc/CONTENT_CATALOG_DB" pool-name="contentdb" enabled="true" use-java-context="true" use-ccm="true">
    <connection-url>jdbc:hsqldb:file:../../hsql-data/ContentDS</connection-url>
    <driver-class>org.hsqldb.jdbc.JDBCDriver</driver-class>
    <driver>hsqldb</driver>
    <pool>
        <min-pool-size>10</min-pool-size>
        <max-pool-size>20</max-pool-size>
        <prefill>false</prefill>
        <use-strict-min>false</use-strict-min>
        <flush-strategy>EntirePool</flush-strategy>
    </pool>
    <security>
        <user-name>sa</user-name>
        <password></password>
    </security>
    <validation>
        <check-valid-connection-sql>SELECT 1 FROM INFORMATION_SCHEMA.SYSTEM_USERS</check-valid-connection-sql>
        <validate-on-match>false</validate-on-match>
        <background-validation>false</background-validation>
    </validation>
</datasource>

<driver name="hsqldb" module="org.hsqldb">
    <xa-datasource-class>org.hsqldb.jdbc.JDBCDriver</xa-datasource-class>
</driver>