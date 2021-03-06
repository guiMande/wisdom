/*
 * #%L
 * Wisdom-Framework
 * %%
 * Copyright (C) 2013 - 2014 Wisdom Framework
 * %%
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * 
 *      http://www.apache.org/licenses/LICENSE-2.0
 * 
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 * #L%
 */
package org.wisdom.validation.hibernate;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class Person {
    @NotNull(message = "{name_must_be_set}")
    @Size(min = 4, message = "The name '${validatedValue}' must contain at least {min} characters long")
    private String name;

    public Person(String name) {
        this.name = name;
    }
    // getters and setters ...
}
