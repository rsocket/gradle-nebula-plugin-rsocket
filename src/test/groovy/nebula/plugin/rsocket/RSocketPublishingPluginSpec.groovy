/*
 * Copyright 2014-2015 Netflix, Inc.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * <http://www.apache.org/licenses/LICENSE-2.0>
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package nebula.plugin.rsocket

import spock.lang.Specification

class RSocketPublishingPluginSpec extends Specification {
    def 'testCalculateUrlFromOrigin'(String origin, String uri) {
        expect:
        RSocketPublishingPlugin.calculateUrlFromOrigin(origin) == uri

        where:
        origin                                           | uri
        'git@github.com:reactivex/rxjava-core.git'       | 'https://github.com/reactivex/rxjava-core'
        'ssh://git@github.com:reactivex/rxjava-core.git' | 'https://github.com/reactivex/rxjava-core'
        'https://github.com:reactivex/rxjava-core.git'   | 'https://github.com/reactivex/rxjava-core'

    }
    def 'testCalculateRepoFromOrigin'(String origin, String repo) {
        expect:
        RSocketPublishingPlugin.calculateRepoFromOrigin(origin) == repo

        where:
        origin                                           | repo
        'git@github.com:reactivex/rxjava-core.git'       | 'rxjava-core'
        'ssh://git@github.com:reactivex/rxjava-core.git' | 'rxjava-core'
        'https://github.com:reactivex/rxjava-core.git'   | 'rxjava-core'

    }
}
