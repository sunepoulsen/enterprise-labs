<template>
    <div class="p-grid">
        <div class="p-col-12">
            <label-grid label="Promise type" :width="labelWidth">{{ type }}</label-grid>
            <p/>
            <label-grid label="Status code" :width="labelWidth">{{ response.statusCode }}</label-grid>
            <label-grid label="Headers" :width="labelWidth">{{ response.headers }}</label-grid>
            <label-grid label="Body" :width="labelWidth">{{ response.body }}</label-grid>
            <label-grid label="Error text" :width="labelWidth">{{ errorText }}</label-grid>
        </div>
        <div class="p-col-12">
            <Button class="p-button-raised" style="margin-right: 10px" label="Greetings" @click="greetings" />
            <Button class="p-button-raised" label="Bad request" @click="badRequest" />
        </div>
    </div>
</template>

<script lang="ts">
import { Component, Vue } from 'vue-property-decorator'
import LabelGrid from '@/app/shared/components/layouts/LabelGrid.vue'
import { HelloWorldBackend } from '@/app/core/http/backends/helloworld/HelloWorldBackend'
import { HttpResponse } from '@/app/core/http/HttpResponse'
import { BackendClient } from '@/app/core/http/backends/BackendClient'
import { AppSettings } from '@/app/configs/AppSettings'

@Component({
  components: {
    LabelGrid
  }
})
export default class HelloWorldIntegration extends Vue {
    labelWidth = '180px'

    private type = '';
    private response: HttpResponse<any> = { statusCode: 0 };
    private backend: HelloWorldBackend = new HelloWorldBackend(new AppSettings().externalServices().helloworld);
    private errorText = '';

    greetings () {
      this.clear()
      this.backend.greetings()
        .then(response => {
          this.type = 'Promise.then(): Greetings'
          this.response = response
        })
        .catch(error => this.handleBackendError('Greetings', error))
    }

    badRequest () {
      this.clear()
      this.backend.badRequest()
        .then(response => {
          this.type = 'Promise.then(): BadRequest'
          this.response = response
        })
        .catch(error => this.handleBackendError('badRequest', error))
    }

    private clear () {
      this.type = ''
      this.response = { statusCode: -1 }
      this.errorText = ''
    }

    private handleBackendError (op: string, error: any) {
      this.type = 'Promise.catch(): ' + op

      try {
        this.response = BackendClient.mapBackendError(error)
      } catch (ex) {
        this.errorText = ex.message
      }
    }
}
</script>

<style scoped>

</style>
