<template>
    <div>
        Demonstrates integration with a simple Hello World backend service.
        <p/>
        The buttons demonstrates different cases when calling the service.
        <p/>
        In case of an non 200 response the general BackendError body is extracted from the response.
    </div>
</template>

<script lang="ts">
import { Component, Vue } from 'vue-property-decorator'

@Component
export default class HelloWorldDoc extends Vue {
}
</script>

<style scoped>

</style>
