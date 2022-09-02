FROM quay.io/wildfly/wildfly

# First, use the management CLI to add the resource adapter and configure it
ADD install-ibm-mq-offline.cli "$JBOSS_HOME/customization/"
ADD cors.cli "$JBOSS_HOME/customization/"

RUN set -x && \
    "$JBOSS_HOME/bin/jboss-cli.sh" --file="$JBOSS_HOME/customization/install-ibm-mq-offline.cli" && \
#		"$JBOSS_HOME/bin/jboss-cli.sh" --file="$JBOSS_HOME/customization/cors.cli" && \
    rm -rf "$JBOSS_HOME/standalone/configuration/standalone_xml_history"

# Then, deploy the resource adapter by copying the wmq.jmsra.rar file to the JBOSS_HOME/standalone/deployments/ directory
ADD wmq.jmsra.rar "$JBOSS_HOME/standalone/deployments/"

# Finally deploy EAR file to JBOSS_HOME/standalone/deployments/
ADD module-ear/target/module-ear-1.0-SNAPSHOT.ear "$JBOSS_HOME/standalone/deployments/"

EXPOSE 9990

RUN /opt/jboss/wildfly/bin/add-user.sh admin admin --silent

CMD ["/opt/jboss/wildfly/bin/standalone.sh", "-c", "standalone-full.xml",  "-b", "0.0.0.0", "-bmanagement", "0.0.0.0"]
