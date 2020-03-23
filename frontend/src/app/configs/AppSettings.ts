/**
 * Global settings of the application.
 */
import { LabGroup } from './model/Labs'

// Lab components
import VueComponentRenderLab from '@/app/labs/vue/component-rendering/pages/VueComponentRenderLab.vue'
import HelloWorldLab from '@/app/labs/integrations/helloworld/pages/HelloWorldLab.vue'

export class AppSettings {
  private backendBaseUrl = 'http://localhost:13100/api'
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
              component: VueComponentRenderLab
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
              component: HelloWorldLab
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
