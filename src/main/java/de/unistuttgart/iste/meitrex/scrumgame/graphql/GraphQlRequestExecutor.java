package de.unistuttgart.iste.meitrex.scrumgame.graphql;

import com.kobylynskyi.graphql.codegen.model.graphql.GraphQLOperationRequest;
import com.kobylynskyi.graphql.codegen.model.graphql.GraphQLRequest;
import com.kobylynskyi.graphql.codegen.model.graphql.GraphQLResponseProjection;
import lombok.RequiredArgsConstructor;
import org.springframework.graphql.client.HttpGraphQlClient;
import reactor.core.publisher.Mono;

import java.util.function.Supplier;

@RequiredArgsConstructor
public class GraphQlRequestExecutor {

    private final HttpGraphQlClient graphQlClient;
    private final Supplier<String>  authTokenSupplier;

    public OperationSpecification request(GraphQLOperationRequest request) {
        return new OperationSpecification(request);
    }

    @RequiredArgsConstructor
    public class OperationSpecification {
        private final GraphQLOperationRequest request;

        public <T> ProjectionSpecification<T> projectTo(Class<T> responseType, GraphQLResponseProjection projection) {
            return new ProjectionSpecification<>(request, projection, responseType);
        }
    }

    @RequiredArgsConstructor
    public class ProjectionSpecification<T> {
        private final GraphQLOperationRequest request;
        private final GraphQLResponseProjection projection;
        private final Class<T> responseType;

        public Mono<T> retrieve() {
            GraphQLRequest graphQlRequest = new GraphQLRequest(request, projection);

            String retrievalName = request.getAlias() != null ? request.getAlias() : request.getOperationName();

            return addBearerTokenToClient(graphQlClient)
                    .document(graphQlRequest.toQueryString())
                    .retrieve(retrievalName)
                    .toEntity(responseType);
        }

        private HttpGraphQlClient addBearerTokenToClient(HttpGraphQlClient graphQlClient) {
            return graphQlClient.mutate()
                    .headers(headers -> headers.setBearerAuth(authTokenSupplier.get()))
                    .build();
        }
    }

}
