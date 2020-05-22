/**
 * Global settings of the application.
 */

export class AppSettings {
  private backendBaseUrl = 'http://localhost:13100/api'
  name = 'Tech Enterprise Labs';
  version = '1.0.0';

  navigationMenu () {
    return [
      {
        label: 'Labs',
        items: [
          [
            {
              label: 'Frontend',
              items: [
                {
                  label: 'Component Rendering',
                  to: '/labs/ui/component-rendering'
                },
                {
                  label: 'VUEx Store States',
                  to: '/labs/ui/store-states'
                },
                {
                  label: 'Date & Times',
                  to: '/labs/ui/calendar'
                }
              ]
            }
          ],
          [
            {
              label: 'Integrations',
              items: [
                {
                  label: 'Hello World',
                  to: '/labs/integrations/helloworld'
                }
              ]
            }
          ],
          [
            {
              label: 'Apps',
              items: [
                {
                  label: 'MyCash',
                  to: '/labs/mycash'
                }
              ]
            }
          ],
          [
            {
              label: 'Backends',
              items: [
                {
                  label: 'Hello World',
                  url: this.backendBaseUrl + '/helloworld/swagger-ui.html',
                  target: '_blank'
                },
                {
                  label: 'MyCash Accounting',
                  url: this.backendBaseUrl + '/mycash/accounting/swagger-ui.html',
                  target: '_blank'
                }
              ]
            }
          ]
        ]
      },
      {
        label: 'Vue',
        items: [
          [
            {
              label: 'CLI Plugins',
              items: [
                {
                  label: 'babel',
                  url: 'https://github.com/vuejs/vue-cli/tree/dev/packages/%40vue/cli-plugin-babel',
                  target: '_blank'
                },
                {
                  label: 'typescript',
                  url: 'https://github.com/vuejs/vue-cli/tree/dev/packages/%40vue/cli-plugin-typescript',
                  target: '_blank'
                },
                {
                  label: 'router',
                  url: 'https://github.com/vuejs/vue-cli/tree/dev/packages/%40vue/cli-plugin-router',
                  target: '_blank'
                },
                {
                  label: 'vuex',
                  url: 'https://github.com/vuejs/vue-cli/tree/dev/packages/%40vue/cli-plugin-vuex',
                  target: '_blank'
                },
                {
                  label: 'eslint',
                  url: 'https://github.com/vuejs/vue-cli/tree/dev/packages/%40vue/cli-plugin-eslint',
                  target: '_blank'
                },
                {
                  label: 'unit-mocha',
                  url: 'https://github.com/vuejs/vue-cli/tree/dev/packages/%40vue/cli-plugin-unit-mocha',
                  target: '_blank'
                },
                {
                  label: 'e2e-cypress',
                  url: 'https://github.com/vuejs/vue-cli/tree/dev/packages/%40vue/cli-plugin-e2e-cypress',
                  target: '_blank'
                }
              ]
            }
          ],
          [
            {
              label: 'Essential',
              items: [
                {
                  label: 'Core Docs',
                  url: 'https://vuejs.org',
                  target: '_blank'
                },
                {
                  label: 'Forum',
                  url: 'https://forum.vuejs.org',
                  target: '_blank'
                },
                {
                  label: 'Community Chat',
                  url: 'https://chat.vuejs.org',
                  target: '_blank'
                },
                {
                  label: 'Twitter',
                  url: 'https://twitter.com/vuejs',
                  target: '_blank'
                },
                {
                  label: 'News',
                  url: 'https://news.vuejs.org',
                  target: '_blank'
                }
              ]
            }
          ],
          [
            {
              label: 'Ecosystem',
              items: [
                {
                  label: 'vue-router',
                  url: 'https://router.vuejs.org',
                  target: '_blank'
                },
                {
                  label: 'vuex',
                  url: 'https://vuex.vuejs.org',
                  target: '_blank'
                },
                {
                  label: 'vue-devtools',
                  url: 'https://github.com/vuejs/vue-devtools#vue-devtools',
                  target: '_blank'
                },
                {
                  label: 'vue-loader',
                  url: 'https://vue-loader.vuejs.org',
                  target: '_blank'
                },
                {
                  label: 'awesome-vue',
                  url: 'https://github.com/vuejs/awesome-vue',
                  target: '_blank'
                }
              ]
            }
          ]
        ]
      },
      {
        label: 'Frontend',
        items: [
          [
            {
              label: 'Standards',
              items: [
                {
                  label: 'HTML 5.2',
                  url: 'https://www.w3.org/TR/html52/',
                  target: '_blank'
                },
                {
                  label: 'CSS 2.2',
                  url: 'https://www.w3.org/TR/2016/WD-CSS22-20160412/',
                  target: '_blank'
                }
              ]
            },
            {
              label: 'Prime VUE',
              items: [
                {
                  label: 'Demo',
                  url: 'https://primefaces.org/primevue/showcase',
                  target: '_blank'
                }
              ]
            }
          ],
          [
            {
              label: 'Libraries',
              items: [
                {
                  label: 'Date & Times',
                  url: 'https://momentjscom.readthedocs.io/en/latest/',
                  target: '_blank'
                }
              ]
            }
          ]
        ]
      }
    ]
  }

  externalServices () {
    return {
      helloworld: this.backendBaseUrl + '/helloworld'
    }
  }
}
