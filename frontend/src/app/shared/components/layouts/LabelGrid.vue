<template>
    <div class="p-grid">
        <div class="p-col-fixed" :style="generateWidthStyle()">{{ label }}:</div>
        <div class="p-col"><slot></slot></div>
    </div>
</template>

<script lang="ts">
import { Component, Prop, Vue } from 'vue-property-decorator'

@Component
export default class LabelGrid extends Vue {
  @Prop() private width!: string;
  @Prop() private label!: string;

  generateWidthStyle () {
    return 'width: ' + this.width
  }
}
</script>

<style scoped>
</style>
