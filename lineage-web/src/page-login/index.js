import React, { useState, useEffect } from 'react'
import { Form, Button, Checkbox, Input, message } from 'antd'
import { LockOutlined, UserOutlined } from '@ant-design/icons'
import axios from 'axios'
import './index.css'


const Page = () => {
  const [form] = Form.useForm()
  const onFinish = (values) => {
    login(values)
  }
  // login
  const login = async (params) => {
    try {
      const res = await axios.post('/login', {...params}, {
        headers: {
          'Content-Type': 'multipart/form-data'
        }
      })
      const login_status = window.localStorage.getItem('login_status')
      if (res.data.data && login_status == 0) {
        window.localStorage.setItem('login_status', 1)
        window.localStorage.setItem('userInfo', JSON.stringify(res.data.data))
        window.location.href = '/#/job'
      } else {
        window.localStorage.setItem('login_status', 0)
        window.location.href = '/#/login'
      }
    } catch (error) {
      message(error)
    }
  }

  useEffect(() => {
    const login_status = window.localStorage.getItem('login_status')
    if (login_status == 1) {
      window.location.href = '/#/job'
    }
  }, [])

  return (
    <div className='login-wrapper'>
      <div className='login-box'>
        <div className='login-title FBH FBJC FBAC mb16'>
          {/* <img src='' width={40} height={40} /> */}
          <span className='ml8 fc24'>FlinkSQL Lineage</span>
        </div>
        <div className='gray-bd pl32 pr32 pb16 login-bd'>
          <div className='FBH FBJC FBAC m16'>Sign in to FlinkSQL Lineage</div>
          <Form
            form={form}
            name="normal_login"
            className="login-form"
            initialValues={{
              remember: true,
            }}
            onFinish={onFinish}
          >
            <Form.Item
              name="username"
              rules={[
                {
                  required: true,
                  message: 'Please input your Username!',
                },
              ]}
            >
              <Input prefix={<UserOutlined className="site-form-item-icon" />} placeholder="Username" />
            </Form.Item>
            <Form.Item
              name="password"
              rules={[
                {
                  required: true,
                  message: 'Please input your Password!',
                },
              ]}
            >
              <Input
                prefix={<LockOutlined className="site-form-item-icon" />}
                type="password"
                placeholder="Password"
              />
            </Form.Item>
            
            <Form.Item
              wrapperCol={{
                offset: 0,
                span: 16,
              }}
            >
              <Button type="primary" htmlType="submit" style={{ width: 250 }}>
                Sign in
              </Button>
            </Form.Item>
            {/* <Form.Item 
              wrapperCol={{
                offset: 13,
                span: 12,
              }}
            >
              <Form.Item name="remember" valuePropName="checked" noStyle>
                <Checkbox>Remember me</Checkbox>
              </Form.Item>
              <a className="login-form-forgot" href="">
                Forgot password
              </a>
            </Form.Item> */}
          </Form>
        </div>
      </div>
    </div>
  )
}
export default Page