<xa-datasource jndi-name="java:jboss/datasources/CONTENT_CATALOG_DB" pool-name="contentdb" enabled="true" use-ccm="false">
    <xa-datasource-property name="Url">
        jdbc:hsqldb:file:../../hsql-data/LiferayDS
    </xa-datasource-property>
    <driver>hsqldb</driver>
    <xa-pool>
        <max-pool-size>10</max-pool-size>
        <is-same-rm-override>false</is-same-rm-override>
        <interleaving>false</interleaving>
        <pad-xid>false</pad-xid>
        <wrap-xa-resource>false</wrap-xa-resource>
    </xa-pool>
    <security>
        <user-name>sa</user-name>
        <password></password>
    </security>
    <validation>
        <validate-on-match>false</validate-on-match>
        <background-validation>false</background-validation>
    </validation>
    <statement>
        <prepared-statement-cache-size>0</prepared-statement-cache-size>
        <share-prepared-statements>false</share-prepared-statements>
    </statement>
</xa-datasource>