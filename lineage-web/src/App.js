
import React,{ useEffect, useState } from 'react'
import { Outlet, Link} from 'react-router-dom'
import { DownOutlined, ProfileOutlined, LoginOutlined, DatabaseOutlined, ToolOutlined, UserOutlined, ExclamationCircleFilled, GithubOutlined, BranchesOutlined, SettingOutlined } from '@ant-design/icons';
import { Layout, Menu, theme, Modal, Tooltip, Dropdown, Space, message } from 'antd'
import './common/common.styl'
import axios from 'axios'

const { Header, Content, Footer, Sider } = Layout
const { confirm } = Modal
const App = () => {
  const [collapsed, setCollapsed] = useState(false)
  const {hash} = window.location
  const [current, setCurrent] = useState(hash.split('/')[1])
  const userInfo = JSON.parse(window.localStorage.getItem('userInfo'))
  const {username=''} = userInfo || {}
  const {
    token: { colorBgContainer },
  } = theme.useToken()

  const menuMap = [
    {
      key: 'job',
      icon: BranchesOutlined,
      label: 'Job',
      url: 'job',
    },
    // {
    //   key: 'catalog',
    //   icon: FileTextOutlined,
    //   label: 'Catalog',
    //   url: 'catalog',
    // },
    {
      key: 'catalog',
      icon: DatabaseOutlined,
      label: 'Catalog',
      url: 'catalog',
    },
    {
      key: 'plugin',
      icon: ToolOutlined,
      label: 'Plugin',
      url: 'plugin',
    },
    {
      key: 'user-manage',
      icon: UserOutlined,
      label: 'User manage',
      url: 'user-manage',
    },
  ]

  const onClickMenu = (e) => {
    console.log('click ', e);
    setCurrent(e.key);
  }
  const signOut = () => {
    confirm({
      title: 'Do you Want to Sign out?',
      icon: <ExclamationCircleFilled />,
      okText: 'Yes',
      cancelText: 'No',
      onOk: async () => {
        try {
          const res = await axios.post('/logout')
          const login_status = window.localStorage.getItem('login_status')
          if (res.data.data && login_status == 1) {
            window.localStorage.setItem('login_status', 0)
            window.location.href = '/#/login'
          }
        } catch (error) {
          message.error(error)
        }
      },
      onCancel() {
        console.log('Cancel');
      },
    });
  }

  const items = [
    {
      key: '1',
      label: (
        <div onClick={signOut}>
          <LoginOutlined className='mr16' />
          Sign out
        </div>
      ),
    },
  ]

  useEffect(() => {
    const login_status = window.localStorage.getItem('login_status')
    if (login_status == 0) {
      window.location.href = '/#/login'
    }
  }, [])
  
  return (
    <Layout>
      <Sider
        breakpoint="lg"
      >
        <div className="logo" />
        <Menu
          theme="dark"
          mode="inline"
          selectedKeys={[current]}
          onClick={onClickMenu}
          items={menuMap.map(
            (item) => ({
              key: item.key,
              icon: React.createElement(item.icon),
              label: <Link 
              to={`/${item.url}`}
            >{item.label}</Link>,
            }),
          )
        }
        />
      </Sider>
      <Layout>
        <Header
          className="FBV FBAE header-box"
        >
          <div className='fcf'>
            <Tooltip title='Document'>
              <ProfileOutlined style={{color: '#fff', fontSize: 16}} className='mr32 hand' />
            </Tooltip>
            <Tooltip title='GitHub'>
              <GithubOutlined style={{color: '#fff', fontSize: 16}} className='mr32 hand' />
            </Tooltip>
            {/* <Button type='link'>EN</Button> */}
            <Dropdown 
              menu={{
                items,
              }}
              trigger='click'
            >
              <Space>
                <span className='hand'>{username}</span>
                <DownOutlined />
              </Space>
            </Dropdown>
          </div>
        </Header>
        <Content
          style={{
          }}
        >
          <div
            style={{
              minHeight: 360,
              background: colorBgContainer,
            }}
          >
            <Outlet />
          </div>
        </Content>
        <Footer
          style={{
            textAlign: 'center',
          }}
        >
          Flink SQL Lineage  ©2023
        </Footer>
      </Layout>
    </Layout>
  );
}

export default App
