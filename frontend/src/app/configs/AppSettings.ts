/**
 * Global settings of the application.
 */
import { Lab } from '@/app/configs/model/Lab'
import { LabGroup } from '@/app/configs/model/LabGroup'
import { LabRoute } from '@/app/configs/model/LabRoute'

// Lab components
import VueComponentRenderPage from '@/app/labs/vue/component-rendering/pages/VueComponentRenderPage.vue'

export class AppSettings {
  name = 'Tech Enterprise Labs';
  version = '1.0.0';

  labs () {
    return [
      new LabGroup('Vue', [
        new Lab('Component Rendering', new LabRoute('/labs/vue/component-rendering', VueComponentRenderPage))
      ])
    ]
  }
}
