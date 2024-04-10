package io.github.sashirestela.openai.domain.chat.tool;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import io.github.sashirestela.openai.function.Functional;
import io.github.sashirestela.openai.function.ParametersSerializer;
import io.github.sashirestela.slimvalidator.constraints.Required;
import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class ChatFunction {

    @Required
    private String name;

    @JsonInclude(Include.NON_NULL)
    private String description;

    @Required
    @JsonSerialize(using = ParametersSerializer.class)
    @JsonProperty("parameters")
    private Class<? extends Functional> functionalClass;

}
