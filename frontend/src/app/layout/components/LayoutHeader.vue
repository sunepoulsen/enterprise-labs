<template>
    <Card>
        <template slot="title">
            {{ settings.name }}
        </template>
        <template slot="content">
            {{ settings.version }}
        </template>
    </Card>
</template>

<script lang="ts">
import { Component, Prop, Vue } from 'vue-property-decorator'
import { AppSettings } from '@/app/configs/AppSettings'

@Component
export default class LayoutHeader extends Vue {
  @Prop() private settings!: AppSettings

  constructor () {
    super()
    this.settings = new AppSettings()
  }
}
</script>

<style lang="scss">

</style>
