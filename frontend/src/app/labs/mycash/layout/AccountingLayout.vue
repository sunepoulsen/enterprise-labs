<template>
    <div class="p-grid">
        <div class="p-col-2">
            <Panel header="Accounting">
                Accounting id: {{ id }}
            </Panel>
        </div>
        <div class="p-col-2">
            <router-view></router-view>
        </div>
    </div>
</template>

<script lang="ts">
import { Component, Vue } from 'vue-property-decorator'

@Component
export default class AccountingLayout extends Vue {
  private id = NaN

  /**
   * Called by Vue when the component has been loaded.
   */
  created () {
    this.id = Number(this.$route.params.id)
  }
}
</script>

<style scoped>

</style>
