/**
 * Global settings of the application.
 */
import { LabGroup } from './model/Labs'

// Lab components
import VueComponentRenderLab from '@/app/labs/ui/component-rendering/pages/VueComponentRenderLab.vue'
import LogicCalendarLab from '@/app/labs/ui/calendar/pages/LogicCalendarLab.vue'
import HelloWorldLab from '@/app/labs/integrations/helloworld/pages/HelloWorldLab.vue'

export class AppSettings {
  private backendBaseUrl = '/api'
  name = 'Tech Enterprise Labs';
  version = '1.0.0';

  labs (): LabGroup[] {
    return [
      {
        name: 'Frontend',
        labs: [
          {
            name: 'Component Rendering',
            route: {
              path: '/labs/ui/component-rendering',
              component: VueComponentRenderLab
            }
          },
          {
            name: 'Date & Times',
            route: {
              path: '/labs/ui/calendar',
              component: LogicCalendarLab
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
