package school.domain

import com.fasterxml.jackson.annotation.JsonIdentityInfo
import com.fasterxml.jackson.annotation.JsonProperty
import com.voodoodyne.jackson.jsog.JSOGGenerator

@JsonIdentityInfo(generator = JSOGGenerator.class)
abstract class Entity {

    @JsonProperty("id")
    private Long id

    Long getId() {
        return id
    }

    void setId(Long id) {
        this.id = id
    }

    @Override
    boolean equals(Object o) {
        if (this.is(o)) return true
        if (o == null || id == null || getClass() != o.getClass()) return false

        Entity entity = (Entity) o

        if (!id.equals(entity.id)) return false

        return true
    }

    @Override
    int hashCode() {
        return (id == null) ? -1 : id.hashCode()
    }
}
