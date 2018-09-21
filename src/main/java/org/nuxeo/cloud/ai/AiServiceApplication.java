package org.nuxeo.cloud.ai;

import org.jdbi.v3.core.Jdbi;
import org.nuxeo.cloud.ai.api.AiApi;
import org.nuxeo.cloud.ai.api.factories.AiApiServiceFactory;

import io.dropwizard.Application;
import io.dropwizard.configuration.EnvironmentVariableSubstitutor;
import io.dropwizard.configuration.SubstitutingSourceProvider;
import io.dropwizard.db.DataSourceFactory;
import io.dropwizard.jdbi3.JdbiFactory;
import io.dropwizard.jdbi3.bundles.JdbiExceptionsBundle;
import io.dropwizard.migrations.MigrationsBundle;
import io.dropwizard.setup.Bootstrap;
import io.dropwizard.setup.Environment;
import io.federecio.dropwizard.swagger.SwaggerBundle;
import io.federecio.dropwizard.swagger.SwaggerBundleConfiguration;

public class AiServiceApplication extends Application<AiServiceConfiguration> {

    public static void main(final String[] args) throws Exception {
        new AiServiceApplication().run(args);
    }

    @Override
    public String getName() {
        return "Nuxeo Cloud :: AI Service";
    }

    @Override
    public void initialize(final Bootstrap<AiServiceConfiguration> bootstrap) {
        bootstrap.addBundle(new MigrationsBundle<AiServiceConfiguration>() {
            @Override
            public DataSourceFactory getDataSourceFactory(AiServiceConfiguration configuration) {
                return configuration.getDataSourceFactory();
            }
        });

        bootstrap.addBundle(new SwaggerBundle<AiServiceConfiguration>() {
            @Override
            protected SwaggerBundleConfiguration getSwaggerBundleConfiguration(AiServiceConfiguration configuration) {
                return configuration.swaggerBundleConfiguration;
            }
        });

        bootstrap.addBundle(new JdbiExceptionsBundle());

        bootstrap.setConfigurationSourceProvider(new SubstitutingSourceProvider(
                bootstrap.getConfigurationSourceProvider(), new EnvironmentVariableSubstitutor(false)));
    }

    @Override
    public void run(final AiServiceConfiguration config, final Environment environment) {

        final JdbiFactory factory = new JdbiFactory();
        final Jdbi jdbi = factory.build(environment, config.getDataSourceFactory(), "postgresql");
        // Could be done by injection later....
        AiApiServiceFactory.registerJdbi(jdbi);

        final AiApi api = new AiApi(null);
        environment.jersey().register(api);
    }

}
