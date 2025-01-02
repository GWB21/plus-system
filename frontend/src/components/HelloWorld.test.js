import { mount } from '@vue/test-utils';
import HelloWorld from './HelloWorld.vue';
import { describe, it, expect } from 'vitest';

describe('HelloWorld', () => {
    it('renders default message', () => {
        const wrapper = mount(HelloWorld);
        expect(wrapper.text()).toContain('Hello World');
    });

    it('renders custom message', () => {
        const msg = 'Custom Message';
        const wrapper = mount(HelloWorld, { props: { msg } });
        expect(wrapper.text()).toContain(msg);
    });

    it('renders another custom message in div', () => {
        const msg = 'Another Custom Message';
        const wrapper = mount(HelloWorld, { props: { msg } });
        expect(wrapper.find('div').text()).toContain(msg);
    });
});