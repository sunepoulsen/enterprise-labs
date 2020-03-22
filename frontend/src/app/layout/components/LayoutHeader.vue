<template>
    <div class="p-grid nested-grid layout-header">
        <div class="p-col-12">
            <div class="p-grid">
                <div class="p-col-10">
                    <div class="name-section">
                        <h1>{{ settings.name }}</h1>
                    </div>
                </div>
                <div class="p-col-2">
                    <div class="nav-section">
                        <ul>
                            <li><router-link to="/">Home</router-link></li>
                            <li><router-link to="/about">About</router-link></li>
                        </ul>
                    </div>
                </div>
            </div>
        </div>
    </div>
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

<style lang="scss" scoped>
    @import '@/assets/styles/layout-header.scss';

    .layout-header {
        background-color: $backgroundColor;
    }

    .name-section {
        color: $textColor;
    }

    div > h1 {
        padding-left: $applicationNameLeftSpace;
        font-size: $applicationNameFontSize;
    }

    .nav-section {
        color: $textColor;
    }
</style>
