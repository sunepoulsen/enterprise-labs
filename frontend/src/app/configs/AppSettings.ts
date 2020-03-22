/**
 * Global settings of the application.
 */
import { LabGroup } from './model/Labs'

// Lab components
import VueComponentRenderPage from '@/app/labs/vue/component-rendering/pages/VueComponentRenderPage.vue'
import HelloWorldIntegration from '@/app/labs/integrations/helloworld/pages/HelloWorldIntegration.vue'

export class AppSettings {
  private backendBaseUrl = '/api'
  name = 'Tech Enterprise Labs';
  version = '1.0.0';

  labs (): LabGroup[] {
    return [
      {
        name: 'Vue',
        labs: [
          {
            name: 'Component Rendering',
            route: {
              path: '/labs/vue/component-rendering',
              component: VueComponentRenderPage
            }
          }
        ]
      },
      {
        name: 'Integrations',
        labs: [
          {
            name: 'Hello World',
            route: {
              path: '/labs/integrations/helloworld',
              component: HelloWorldIntegration
            }
          }
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
