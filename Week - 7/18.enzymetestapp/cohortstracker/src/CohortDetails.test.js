import React from 'react';
import { shallow, mount } from 'enzyme';
import CohortDetails from './CohortDetails';
import { CohortData } from './Cohort';
describe('Cohort Details Component', () => {

  // Test 1: Component creation
  test('should create the component', () => {
    const wrapper = shallow(<CohortDetails />);
    expect(wrapper.exists()).toBe(true);
  });

  // Test 2: Props initialization
  test('should initialize the props', () => {
    const cohort = CohortData[0];
    const wrapper = mount(<CohortDetails cohort={cohort} />);
    expect(wrapper.props().cohort).toEqual(cohort);
  });

  // Test 3: Display cohort code in h3
  test('should display cohort code in h3', () => {
    const cohort = CohortData[0];
    const wrapper = mount(<CohortDetails cohort={cohort} />);
    const h3 = wrapper.find('h3');
    expect(h3.text()).toContain(cohort.code);
  });

  // Test 4: Snapshot test
  test('should always render same html', () => {
    const cohort = CohortData[0];
    const wrapper = shallow(<CohortDetails cohort={cohort} />);
    expect(wrapper).toMatchSnapshot();
  });

});
